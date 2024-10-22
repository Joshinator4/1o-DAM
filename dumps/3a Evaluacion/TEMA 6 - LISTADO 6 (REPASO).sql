#Procedimientos
/*1. Crea el procedimiento devolver_libros(nombre, apellidos), que devuelve todos los libros del socio indicado por parámetros. Si el socio no tiene préstamos pendientes
de devolver simplemente “no hace nada”.
El procedimiento debe controlar:
- Que el socio realmente exista.*/
delimiter $$
drop procedure if exists devolver_libros $$
CREATE procedure devolver_libros(in nombre varchar(30), in apellidos varchar(50))
BEGIN
	declare socio int;
    set socio = (select id_socio from socios s where s.nombre = nombre and s.apellidos = apellidos);
    
    if socio is null then
		signal sqlstate '45000' set message_text = 'El socio no existe';
	else
		update prestamos set fecha_devolucion = curdate() where fecha_devolucion is null and id_socio = socio;
    end if;    
	    
END $$
delimiter ;



/*Funciones
2. Crea la función estanteria_mas_poblada(), que devuelve el número de la estantería
con más libros.*/
delimiter $$
drop function if exists estanteria_mas_poblada $$
CREATE FUNCTION estanteria_mas_poblada() returns int reads sql data #<<----------- deterministic, {CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA} 1 de estos siempre
BEGIN
	declare devolucion int;
    set devolucion = (select estanteria from ejemplares group by estanteria order by count(id_ejemplar) desc limit 1);
RETURN devolucion;
END $$
delimiter ;



/*3. Crea la función autor_con_mas_libros(), que devuelve el nombre completo (nombre
y apellidos) del escritor con más libros en la biblioteca.
¡OJO!: con más libros, no con más ejemplares.*/
delimiter $$
drop function if exists autor_con_mas_libros $$
CREATE FUNCTION autor_con_mas_libros () returns varchar(80) reads sql data #<<----------- deterministic, {CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA} 1 de estos siempre
BEGIN
	declare idautor int;
	declare autor varchar(80);
    set idautor = (select a.id_autor from autores a inner join libros l on a.id_autor = l.id_autor group by l.id_autor order by count(l.id_libro) desc limit 1);
    set autor = concat((select nombre from autores where id_autor = idautor), ' ', (select apellidos from autores where id_autor = idautor));
RETURN autor;
END $$
delimiter ;



/*4. Crea la función ultimo_prestamo_socio(nombre, apellidos), que devuelve la fecha
del último préstamo realizado por el socio indicado por parámetros.
La función debe controlar:
- Que el socio realmente exista.*/
delimiter $$
drop function if exists ultimo_prestamo_socio $$
CREATE FUNCTION ultimo_prestamo_socio(nombre varchar(30), apellidos varchar(50)) returns date reads sql data #<<----------- deterministic, {CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA} 1 de estos siempre
BEGIN
	declare socio int;
	declare fecha date;
    set socio = (select id_socio from socios s where s.nombre = nombre and s.apellidos = apellidos);
    set fecha = (select fecha_prestamo from prestamos where id_socio = socio order by fecha_prestamo desc limit 1);
RETURN fecha;
END $$
delimiter ;




/*Triggers
5. Se crea una nueva regla en la biblioteca: un socio puede llevarse prestados hasta
cuatro libros. Controla la inserción de préstamos para que un socio no pueda tener
más de cuatro préstamos pendientes de devolución.*/
delimiter $$
drop trigger if exists maximo_prestamos_BI $$
CREATE TRIGGER maximo_prestamos_BI
before insert #<<<----------- before(antes) after(despues) de delete, update o insert <<---------- delete (old), update(new, old), insert (new) 
 ON prestamos FOR EACH ROW #<------------follows(despues de) nombre_trigger o precedes(antes de) nombre_trigger
BEGIN
	declare cantidad int;
    set cantidad = (select count(id_ejemplar) from prestamos where fecha_devolucion is null and id_socio = new.id_socio);
    if cantidad >= 4 then 
		signal sqlstate '45000' set message_text = 'Cada socio puede tener maximo 4 prestamos sin devolver. No se le puede prestar mas libros';
	end if;
END $$
DELIMITER ;



/*6. Se crea una nueva regla en la biblioteca: no puede haber más de diez ejemplares por
balda. Controla la inserción y actualización de ejemplares para que no haya balda
con más de diez ejemplares.*/
delimiter $$
drop trigger if exists controlar_balda_BI $$
CREATE TRIGGER controlar_balda_BI
before insert #<<<----------- before(antes) after(despues) de delete, update o insert <<---------- delete (old), update(new, old), insert (new) 
 ON ejemplares FOR EACH ROW #<------------follows(despues de) nombre_trigger o precedes(antes de) nombre_trigger
BEGIN
	declare cantidad int;
    set cantidad = (select contar_ejemplares_balda(new.estanteria, new.balda));
    if cantidad >= 10 then
		signal sqlstate '45000' set message_text = 'Ya hay 10 o más ejemplares en la balda, no se pueden insertar mas';
	end if;
END $$
DELIMITER ;

delimiter $$
drop trigger if exists controlar_balda_BU $$
CREATE TRIGGER controlar_balda_BU
before update #<<<----------- before(antes) after(despues) de delete, update o insert <<---------- delete (old), update(new, old), insert (new) 
 ON ejemplares FOR EACH ROW #<------------follows(despues de) nombre_trigger o precedes(antes de) nombre_trigger
BEGIN
	declare cantidad int;
    set cantidad = (select contar_ejemplares_balda(new.estanteria, new.balda));
    if cantidad >= 10 then
		signal sqlstate '45000' set message_text = 'Ya hay 10 o más ejemplares en la balda, no se pueden actualizar el ejemplar para introducirlo en esa balda';
	end if;
END $$
DELIMITER ;

delimiter $$
drop function if exists contar_ejemplares_balda $$
CREATE FUNCTION contar_ejemplares_balda (estanteria int, balda int) returns int reads sql data #<<----------- deterministic, {CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA} 1 de estos siempre
BEGIN
	declare devolucion int;
    set devolucion = (select count(id_ejemplar) from ejemplares e where e.balda = balda and e.estanteria = estanteria);
RETURN devolucion;
END $$
delimiter ;

/*7. Crea triggers para controlar la inserción y/o actualización de préstamos para que:
- Las fechas de préstamo y límite no pueden ser anteriores al día de hoy.
- La fecha de devolución no puede ser anterior a la fecha de préstamo.*/
delimiter $$
drop trigger if exists controlar_prestamos_BI $$
CREATE TRIGGER controlar_prestamos_BI
before insert #<<<----------- before(antes) after(despues) de delete, update o insert <<---------- delete (old), update(new, old), insert (new) 
 ON prestamos FOR EACH ROW #<------------follows(despues de) nombre_trigger o precedes(antes de) nombre_trigger
BEGIN
	call comprobar_fechas( new.fecha_prestamo, new.fecha_limite, new.fecha_devolucion );
END $$
DELIMITER ;

delimiter $$
drop trigger if exists controlar_prestamos_BU $$
CREATE TRIGGER controlar_prestamos_BU
before update #<<<----------- before(antes) after(despues) de delete, update o insert <<---------- delete (old), update(new, old), insert (new) 
 ON prestamos FOR EACH ROW #<------------follows(despues de) nombre_trigger o precedes(antes de) nombre_trigger
BEGIN
	call comprobar_fechas( new.fecha_prestamo, new.fecha_limite, new.fecha_devolucion );
END $$
DELIMITER ;

delimiter $$
drop procedure if exists comprobar_fechas $$
CREATE procedure comprobar_fechas(in fecha_prestamo date, in fecha_limite date, in fecha_devolucion date)
BEGIN
	if fecha_prestamo < curdate() then 
		signal sqlstate '45000' set message_text = 'La fecha de prestamo no puede ser anteiror a la fecha de hoy';
	elseif fecha_limite < curdate() then
		signal sqlstate '45000' set message_text = 'La fecha limite no puede ser anteiror a la fecha de hoy';
    elseif fecha_devolucion < fecha_prestamo then
		signal sqlstate '45000' set message_text = 'La fecha de devolucion no puede ser anterior a la fecha en la que se ha prestado el libro';
    end if;
END $$
delimiter ;

/*Eventos
8. Crea un evento que se active todos los días de madrugada (elige tú el instante de
activación). El evento debe registrar los ejemplares de la biblioteca que tengan 20
años o más, para ello registrará en la tabla Log el id del ejemplar:
Ejemplo: “El ejemplar con id = *** tiene 20 años o más.”*/
delimiter $$ 
drop event if exists ejemplares_antiguos $$
create event ejemplares_antiguos 
	on schedule every 1 day
    starts '2024-05-26 02:00'
    do #<<<--------------on schedule SIEMPRE.  AT = solo 1 vez en el momento indicado.   EVERY = se repite en el intervalo indicado
begin					#^^^^----------------- interval = en el intervalo (ejemplo interval 1 minute)(ejemplo2 current_timestamp + interval 30 second)  second, minute, hour, day, week, month, year, quarter
						#^^^^----------------- starts = empieza en el momento indicado. ends = acaba en el momento indicado
	declare id int;
    declare final int default 0;
    declare micursor cursor for
		select id_ejemplar from ejemplares
        where timestampdiff(year, fecha_adquisicion, curdate()) >= 20;
	declare continue handler for not found set final = 1;
    open micursor;
    fetch micursor into id;
    while final = 0 do
		call escribir_log('ejemplares_antiguos', concat('Ejemplar id: ', id), ' tiene 20 años o más');
        fetch micursor into id;
    end while;
    close micursor;
end $$
delimiter ;

show events;
alter event ejemplares_antiguos disable;


/*9. Crea un evento que se active todos los días de madrugada (elige tú el instante de
activación). El evento debe registrar en la tabla Log los préstamos a los que les
quedan cinco días o menos para caducar.
Ejemplo: “ Al préstamo del ejemplar *** del socio *** le quedan *** días para
caducar.”*/
delimiter $$ 
drop event if exists prestamos_caducar $$
create event prestamos_caducar 
	on schedule every 1 day
    starts current_timestamp()#'2024-05-26 02:00'
    do #<<<--------------on schedule fijar/programar.  AT = solo 1 vez en el momento indicado.   EVERY = se repite en el intervalo indicado
begin					#^^^^----------------- interval = en el intervalo (ejemplo interval 1 minute)(ejemplo2 current_timestamp + interval 30 second)  second, minute, hour, day, week, month, year, quarter
						#^^^^----------------- starts = empieza en el momento indicado. ends = acaba en el momento indicado
	declare dias, ejemplar, socio int;
    declare final int default 0;
    declare micursor cursor for
		select id_ejemplar, id_socio, timestampdiff(day, curdate(), fecha_limite)
        from prestamos
        where timestampdiff(day, curdate(), fecha_limite) <= 5 and fecha_devolucion is null;
	declare continue handler for not found set final = 1;
    open micursor;
    fetch micursor into ejemplar, socio, dias;
    while final = 0 do
		call escribir_log('prestamos_caducar', 'prestamo a caducar', concat('Ejemplar id: ', ejemplar, ' id de socio ', socio, ' le quedan ', dias, ' para caducar'));
        fetch micursor into ejemplar, socio, dias;
    end while;
    close micursor;
end $$
delimiter ;

