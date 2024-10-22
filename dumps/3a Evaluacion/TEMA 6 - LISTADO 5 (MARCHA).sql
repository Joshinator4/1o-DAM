#Procedimientos
#1. Crea el procedimiento nuevo_libro(titulo, nombre_autor, apellidos_autor, num_ejemplares, estantería, balda). El procedimiento hará lo siguiente:
#- Si el autor indicado ya existe, se debe utilizar su ID. En otro caso debe registrarlo en la base de datos
#- Registra un nuevo libro con el título y autor indicados.
#- Registra los ejemplares indicados en num_ejemplares en la estantería y balda indicados. Como fecha de adquisición se pone la fecha actual.
#El procedimiento debe controlar:
#- Que el número de ejemplares, estantería y balda sean mayores que cero.
delimiter $$
drop procedure if exists nuevo_libro $$
CREATE procedure nuevo_libro(in titulo varchar(100),in nombre_autor varchar(30), in apellidos_autor varchar(50), in num_ejemplares int ,in estanteria int, in balda int)
BEGIN
	declare autor int;
    if num_ejemplares <= 0 or estanteria <= 0 or balda <= 0 then
		signal sqlstate '45000' set message_text = 'El numero de ejemplares, la estanteria y la balada deben ser mayores que 0.';
	end if;
    set autor = (select id_autor from autores a where a.nombre = nombre_autor and a.apellidos = apellidos_autor);
    if autor is null then
		insert into autores (nombre, apellidos) values (nombre_autor, apellidos_autor);
        set autor = (select id_autor from autores a where a.nombre = nombre_autor and a.apellidos = apellidos_autor);
	end if;
		call insertar_libro(titulo, autor, num_ejemplares, estanteria, balda);
END $$
delimiter ;
#Genero un procedimiento para no repetir codigo!!! <---- Crea el libro y los ejemplares en la estanteria desada
delimiter $$
drop procedure if exists insertar_libro $$
CREATE procedure insertar_libro(in titulo1 varchar(100), in id_autor1 int, in num_ejemplares int ,in estanteria1 int, in balda1 int)
BEGIN
	declare contador int default 0;
    declare idlibro int;
	insert into libros (titulo, id_autor) values (titulo1, id_autor1);
    set idlibro = (select id_libro from libros l where l.titulo = titulo1 and l.id_autor = id_autor1);
    while contador < num_ejemplares do
		insert into ejemplares (fecha_adquisicion, ejemplares.estanteria, ejemplares.balda, id_libro) values (curdate(), estanteria1, balda1, idlibro);
        set contador = contador + 1;
	end while;
END $$
delimiter ;

#2. Crea el procedimiento ampliar_prestamo(nombre, apellidos, días), que amplía todos los préstamos pendiente de devolución del socio el número de días indicado.
#El procedimiento debe controlar:
#- Que el socio realmente exista.
#- Que el número de días sea mayor que cero.
#NOTA: si el socio no tiene préstamos pendientes de devolver el procedimiento no falla, simplemente “no hace nada”.
delimiter $$
drop procedure if exists ampliar_prestamo $$
CREATE procedure ampliar_prestamo(in nombre varchar(30), in apellidos varchar(50), in dias int)
BEGIN
	declare socio int;
    if dias <= 0 then
		signal sqlstate '45000' set message_text = 'El numero de días a ampliar debe ser mayor que 0';
    end if;
    set socio = (select id_socio from socios s where s.nombre = nombre and s.apellidos = apellidos);
    if socio is null then
		signal sqlstate '45000' set message_text = 'El socio no existe';
	else
		update prestamos p set fecha_limite = adddate(fecha_limite, interval dias day) where p.id_socio = socio and p.fecha_devolucion is null;
    end if;
END $$
delimiter ;

#3. Crea el procedimiento nuevo_prestamo(nombre, apellidos, ejemplar, días), que registra un nuevo préstamo del ejemplar indicado al socio. La fecha de préstamo es
#el día actual y la fecha límite se calcula añadiendo los días indicados.
#El procedimiento debe controlar:
#- Que el socio realmente exista.
#- Que el identificador de ejemplar realmente exista.
#- Que el número de días sea mayor que cero.
delimiter $$
drop procedure if exists nuevo_prestamo $$
CREATE procedure nuevo_prestamo(in nombre varchar(30), in apellidos varchar(50), in ejemplar int, in dias int)
BEGIN
	declare socio int;
    declare idejemplar int;
    if dias <= 0 then
		signal sqlstate '45000' set message_text = 'El numero de dias tiene que ser superior a 0';
	end if;
    set idejemplar = (select id_ejemplar from ejemplares e where e.id_ejemplar = ejemplar);
    set socio = (select id_socio from socios s where s.nombre = nombre and s.apellidos = apellidos);
    
    if socio is null then
		signal sqlstate '45000' set message_text = 'El socio no existe';
        
	elseif idejemplar is null then
		signal sqlstate '45000' set message_text = 'El ejemplar no existe';
        
    else
		insert into prestamos values (ejemplar, socio, curdate(), adddate(curdate(), interval dias day), null);
        
    end if;
END $$
delimiter ;



#4. Crea el procedimiento borrar_libro(titulo), que borra el libro de la base de datos junto con todos sus datos asociados.
#El procedimiento debe controlar:
#- Que el título realmente exista.
delimiter $$
drop procedure if exists borrar_libro $$
CREATE procedure borrar_libro(in titulo varchar(100))
BEGIN
	declare libro int;
    declare final int default 0;
    declare ejemplar int;
    declare micursor cursor for
		select id_ejemplar from ejemplares e
        where e.id_libro = libro;
	declare continue handler for not found set final = 1;
    set libro = (select id_libro from libros l where l.titulo = titulo);
    if libro is null then
		signal sqlstate '45000' set message_text = 'El libro con este titulo no existe';
	else
		open micursor;
        fetch micursor into ejemplar;
        while final = 0 do
			delete from prestamos where id_ejemplar = ejemplar;
            fetch micursor into ejemplar;
		end while;
        close micursor;
		delete from libros l where l.id_libro = libro; #no hace falta borrar los ejemplares porque hay una relacion on delete cascade. Se borra el libro y se borra sus ejemplares
    end if;
	
END $$
delimiter ;

#5. Crea el procedimiento borrar_socio(nombre, apellidos), que borra el socio de la base de datos junto con todos sus datos asociados.
#El procedimiento debe controlar:
#- Que el socio realmente exista.
delimiter $$
drop procedure if exists borrar_socio $$
CREATE procedure borrar_socio (in nombre varchar(30), in apellidos varchar(50))
BEGIN
	declare socio int;
    
    set socio = (select id_socio from socios s where s.nombre = nombre and s.apellidos = apellidos);
    if socio is null then
		signal sqlstate '45000' set message_text = 'El socio no existe';
	else
		delete from cumpleaños c where c.id = socio;
        delete from historico_prestamos hp where id_socio = socio;
        delete from prestamos p where id_socio = socio;
        delete from socios s where s.id_socio = socio;
	end if;
    
END $$
delimiter ;

#Funciones
#6. Crea la función aleatorio_entre(inicio, fin), que devuelve un número entero aleatorio entre inicio y fin. Es decir: inicio <= respuesta <= fin.
delimiter $$
drop function if exists aleatorio_entre $$
CREATE FUNCTION aleatorio_entre (inicio int, fin int) returns int no sql
BEGIN
	declare devolucion int;
    set devolucion = inicio + floor(rand()*(fin - inicio + 1));
RETURN devolucion;
END $$
delimiter ;

#7. Crea la función socios_nacidos(año), que devuelve el número de socios que han nacido en el año indicado.
delimiter $$
drop function if exists socios_nacidos $$
CREATE FUNCTION socios_nacidos(año int) returns int reads sql data
BEGIN
	declare devolucion int;
    set devolucion = (select count(*) from socios where year(fecha_nacimiento) = año);
RETURN devolucion;
END $$
delimiter ;

#8. Crea la función ejemplares_comprados(año), que devuelve el número de ejemplares que se compraron antes del año indicado.
delimiter $$
drop function if exists ejemplares_comprados $$
CREATE FUNCTION ejemplares_comprados(año int) returns int reads sql data
BEGIN
	declare devolucion int;
    set devolucion = (select count(*) from ejemplares where year(fecha_adquisicion) < año);
RETURN devolucion;
END $$
delimiter ;

#9. Crea la función numero_cumpleaños(mes), que devuelve el número de socios que tienen su cumpleaños en el mes indicado (1 = enero, 2 = febrero…).
#La función debe controlar:
#- Que el mes indicado sea correcto.
delimiter $$
drop function if exists numero_cumpleaños $$
CREATE FUNCTION numero_cumpleaños(mes int) returns int reads sql data
BEGIN
	declare devolucion int;
    if mes < 1 or mes > 12 then
		signal sqlstate '45000' set message_text = 'El mes introducido debe estar entre 1 y 12';
	end if;
    set devolucion = (select count(*) from socios where month(fecha_nacimiento) = mes);
RETURN devolucion;
END $$
delimiter ;

#10. Crea la función prestamos_pendientes(id), que devuelve el número de préstamos pendientes de devolver del socio indicado por su ID. Si como ID se indica un valor
#nulo o se trata de un ID que no existe, debe devolver todos los préstamos pendientes de devolver.
#NOTA: si necesitas practicar el uso de cursores, haz una solución usándolos. Si los cursores ya no son un misterio para ti, puedes evitarlos.
delimiter $$
drop function if exists prestamos_pendientes $$
CREATE FUNCTION prestamos_pendientes(id int) returns int reads sql data
BEGIN
	declare devolucion int;
    declare socio int;
    set socio = (select id_socio from socios where id_socio = id);
    if socio is null or id is null then
		set devolucion = (select count(*) from prestamos p where fecha_devolucion is null);
    else
		set devolucion = (select count(*) from prestamos p where id_socio = id and fecha_devolucion is null);
	end if;
RETURN devolucion;
END $$
delimiter ;
/*SOLUCION CON CURSORES
delimiter $$
drop function if exists prestamos_pendientes $$
CREATE FUNCTION prestamos_pendientes(id int) returns int reads sql data
BEGIN
	declare devolucion int default 0;
    declare socio int;
    declare final int default 0;
    declare fecha date;
    declare micursor cursor for
		select fecha_devolucion from prestamos where id_socio = id;
	declare continue handler for not found set final = 1;
    set socio = (select id_socio from socios where id_socio = id);
    if socio is null or id is null then
		set devolucion = (select count(*) from prestamos p where fecha_devolucion is null);
    else
		open micursor;
        fetch micursor into fecha;
		while final = 0 do
			if fecha is null then
				set devolucion = devolucion +1;
			end if;
			fetch micursor into fecha;
        end while;
	end if;
RETURN devolucion;
END $$
delimiter ;
*/

#Triggers
#11. Crea el trigger AFTER UPDATE en la tabla Prestamos, de tal modo que si se devuelve el libro y el ejemplar se ha prestado ya un número de veces múltiplo de cinco (es
#decir: 5, 10, 15…), se mueva a la estantería 1 balda 1 para su revisión.
delimiter $$
drop trigger if exists revisar_libros_AU $$
CREATE TRIGGER revisar_libros_AU
after update
 ON prestamos FOR EACH ROW
BEGIN
	declare cantidad int;
    if new.fecha_devolucion is not null then
		set cantidad = (select count(*) from prestamos p where p.id_ejemplar = new.id_ejemplar and fecha_devolucion is not null);
		if cantidad % 5 = 0 then
			update ejemplares 
			set estanteria = 1,
			balda = 1
			where id_ejemplar = new.id_ejemplar;
		end if;
	end if;
END $$
DELIMITER ;

#Eventos
#12. Crea un evento que se active todos los días a las 8 de la mañana. El evento debe registrar los préstamos pendientes de devolver a los que se le ha pasado la fecha de
#entrega.
#NOTA: como se trata de un ejercicio, por simplicidad cada préstamo caducado se
#registra en la tabla Log con el siguiente formato:
#- Guion: indicar el nombre del evento.
#- Comentario: Préstamo caducado.
#- Observaciones: Indicar ID del socio, ID del libro, ID del ejemplar, fecha de préstamo y fecha límite de devolución.
delimiter $$ 
drop event if exists eventoPrestamos $$
create event eventoPrestamos
	on schedule every 24 hour 
    #starts current_timestamp do 
    starts concat(adddate(curdate(), 1), ' ', '08:00') do          
begin
	declare socio int;
	declare libro int;
    declare ejemplar int;
    declare fechaPrestamo date;
    declare fechaLimite date;
    declare final int default 0;
	declare micursor cursor for
		select id_ejemplar, id_socio, fecha_prestamo, fecha_limite
        from prestamos 
        where fecha_limite < curdate() and fecha_devolucion is null;
        
	declare continue handler for not found set final = 1;
    
    open micursor;
    fetch micursor into ejemplar, socio, fechaPrestamo, fechaLimite;
    while final = 0 do
		set libro = (select id_libro from ejemplares e where e.id_ejemplar = ejemplar);
		call escribir_log('eventoPrestamos', 'Préstamo caducado', concat('ID socio: ', socio, ' ID libro: ', libro, ' ID ejemplar: ', ejemplar, ' fecha préstamo: ', fechaPrestamo, ' fecha límite: ', fechaLimite));
        fetch micursor into ejemplar, socio, fechaPrestamo, fechaLimite;
	end while;
end $$
delimiter ;
show events;
alter event eventoPrestamos disable;
/*
comprobaciones realizadas
select concat(adddate(curdate(), 1), ' ', '08:00');
select * from prestamos where fecha_limite < curdate() and fecha_devolucion is null;
*/