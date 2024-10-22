/*Ejercicio 1 (2,5 puntos)
Crea el procedimiento registrar_cumpleaños(fecha). El procedimiento debe registrar en
la tabla Cumpleaños todos los alumnos que cumplen años en esa fecha. Para cada
alumno se inserta su nombre completo, el nombre del grupo y la edad que cumplirá en
esa fecha.
Por ejemplo, si el alumno Francisco López Sánchez de 1º DAM cumple 28 años hoy 27 de
mayo, en la tabla se debe registrar:
FECHA ALUMNO GRUPO EDAD
2024-05-27 Francisco López Sánchez 1DAM 28*/
delimiter $$
drop procedure if exists registrar_cumpleaños $$
CREATE procedure registrar_cumpleaños(in fecha date)
BEGIN
	declare alumno1 varchar(60);
    declare grupo1 varchar(10);
    declare edad1 int;
    declare final int default 0;
    declare micursor cursor for
		select concat(a.nombre, ' ',a.apellidos), gp.grupo, timestampdiff(year, fecha_nacimiento, fecha)
        from alumnos a
        inner join grupos gp on a.id_grupo = gp.id
        where month(fecha_nacimiento)=month(fecha) and day(fecha_nacimiento)=day(fecha);
	declare continue handler for not found set final =1;
    
    open micursor;
    fetch micursor into alumno1, grupo1, edad1;
    while final = 0 do
		insert into cumpleaños (fecha, alumno, grupo, edad) values (fecha, alumno1, grupo1, edad1);
        fetch micursor into alumno1, grupo1, edad1;
    end while;
	close micursor;
        
END $$
delimiter ;

/*Ejercicio 2 (0,5 punto)
Crea la función id_modulo(ejercicio). La función debe devolver el identificador del
módulo asociado al identificador de ejercicio indicado por parámetro. Si el identificador
de ejercicio no existe, debe devolver el valor 0.*/
delimiter $$
drop function if exists id_modulo $$
CREATE FUNCTION id_modulo(ejercicio int) returns int reads sql data #<<----------- deterministic, {CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA} 1 de estos siempre
BEGIN
	declare devolucion int;
    set devolucion = (select id_modulo from ejercicios where id = ejercicio);
RETURN devolucion;
END $$
delimiter ;

/*Ejercicio 3 (0,5 punto)
Crea el procedimiento revisar_nota_modulo(ejercicio, alumno). El procedimiento debe
revisar nota y nota_seneca del alumno para el módulo al que pertenece el ejercicio
(indicados por sus identificadores).
NOTA: puedes usar el procedimiento nota_alumno(alumno, modulo) incluido en la base
de datos, que actualiza nota y nota_seneca del alumno en el módulo (ambos indicados
por su identificador).*/
delimiter $$
drop procedure if exists revisar_nota_modulo $$
CREATE procedure revisar_nota_modulo(in ejercicio int, in alumno int)
BEGIN
	declare modulo1 int;
    set modulo1 = id_modulo(ejercicio);
    call nota_alumno(alumno, modulo1);
END $$
delimiter ;

/*Ejercicio 4 (1,5 puntos)
Crea un evento que se active diariamente a las 06:00. El evento debe realizar dos tareas:
- (1 punto) Borrar los cumpleaños con una antigüedad superior a siete días.
- (0,5 puntos) Registrar los cumpleaños de alumnos para el día en el que se activa
el evento.*/
delimiter $$ 
drop event if exists cumpleaños $$
create event cumpleaños 
	on schedule every 1 day
    starts '2024-05-27 06:00' do 
begin					
	delete from cumpleaños 
    where timestampdiff(day, fecha, curdate())<=7;
    call registrar_cumpleaños(curdate());
end $$
delimiter ;

/*Ejercicio 5 (1,5 puntos)
Crea un trigger que, tras matricular un alumno en un módulo, cree automáticamente en
la tabla Calificaciones una fila por cada ejercicio que tiene asociado el módulo.
Por ejemplo, el alumno Javier Rodríguez Sánchez no está matriculado en el módulo “FOL”
y no tiene calificaciones para los ejercicios de este módulo.*/
delimiter $$
drop trigger if exists matricular_alumno $$
CREATE TRIGGER matricular_alumno
after insert 
 ON matriculas FOR EACH ROW 
BEGIN
	declare idejercicio int;
    declare final int default 0;
    declare micursor cursor for
		(select id from ejercicios where id_modulo = new.id_modulo);
	declare continue handler for not found set final = 1;
    open micursor;
    fetch micursor into idejercicio;
    while final = 0 do
		insert into calificaciones (id_ejercicio, id_alumno) values (idejercicio, new.id_alumno);
		fetch micursor into idejercicio;
    end while;
	
END $$
DELIMITER ;

/*Ejercicio 6 (2 puntos)
Crea triggers para que tras cada inserción/modificación/borrado en la tabla
Calificaciones se revisen nota y nota_seneca del alumno en el módulo asociado al
ejercicio, teniendo en cuenta que:
1) (0,5 puntos) En la inserción se revisa la nota del módulo solo si la calificación
insertada informa el campo nota.
2) (1 punto) En la actualización, se revisa la nota del módulo solo si ha cambiado el
campo nota. Hay que tener en cuenta tres casos:
a) La nota estaba sin informar y se informa en la actualización.
b) La nota estaba informada y se pone a nulo en la actualización.
c) La nota estaba informada y se actualiza con un nuevo valor.
3) (0,5 puntos) En el borrado, solo se revisa la nota si la calificación tenía el campo nota
informado.*/
delimiter $$
drop trigger if exists revisar_nota_AI $$
CREATE TRIGGER revisar_nota_AI
after insert #<<<----------- before(antes) after(despues) de delete, update o insert <<---------- delete (old), update(new, old), insert (new) 
 ON calificaciones FOR EACH ROW #<------------follows(despues de) nombre_trigger o precedes(antes de) nombre_trigger
BEGIN
	if new.nota is not null then 
		call revisar_nota_modulo(new.id_ejercicio, new.id_alumno);
	end if;
END $$
DELIMITER ;

delimiter $$
drop trigger if exists revisar_nota_AU $$
CREATE TRIGGER revisar_nota_AU
after update #<<<----------- before(antes) after(despues) de delete, update o insert <<---------- delete (old), update(new, old), insert (new) 
 ON calificaciones FOR EACH ROW #<------------follows(despues de) nombre_trigger o precedes(antes de) nombre_trigger
BEGIN
	if new.nota is not null then 
		if old.nota is null then
			call revisar_nota_modulo(new.id_ejercicio, new.id_alumno);
		elseif old.nota is not null and new.nota is null then
			call revisar_nota_modulo(new.id_ejercicio, new.id_alumno);
        elseif old.nota is not null and new.nota is not null then
			call revisar_nota_modulo(new.id_ejercicio, new.id_alumno);
		end if;
	end if;
END $$
DELIMITER ;

delimiter $$
drop trigger if exists revisar_nota_AD $$
CREATE TRIGGER revisar_nota_AD
after delete #<<<----------- before(antes) after(despues) de delete, update o insert <<---------- delete (old), update(new, old), insert (new) 
 ON calificaciones FOR EACH ROW #<------------follows(despues de) nombre_trigger o precedes(antes de) nombre_trigger
BEGIN
	if old.nota is not null then
		call revisar_nota_modulo(new.id_ejercicio, new.id_alumno);
	end if;
END $$
DELIMITER ;

/*Ejercicio 7 (1,5 puntos)
El diseño de la base de datos presenta una anomalía, y es que es posible insertar en la
tabla Calificaciones un ejercicio para un alumno en un módulo para el que no está
matriculado. Por ejemplo, el alumno Javier Martínez García no está matriculado en el
módulo “Entornos de desarrollo” pero es posible registrarle cualquier ejercicio de dicho
módulo.
Crea un trigger para validar la inserción de calificaciones de tal modo que sólo permita
ejercicios de un alumno para módulos en los que se encuentra registrado. Si el alumno
no está matriculado en el módulo asociado al ejercicio debe elevar el error “El alumno
no está matriculado en el módulo.”.*/
delimiter $$
drop trigger if exists restringir_calificaciones $$
CREATE TRIGGER restringir_calificaciones
before insert #<<<----------- before(antes) after(despues) de delete, update o insert <<---------- delete (old), update(new, old), insert (new) 
 ON calificaciones FOR EACH ROW #<------------follows(despues de) nombre_trigger o precedes(antes de) nombre_trigger
BEGIN
    declare saltaerror int default 0;
    
    set saltaerror = (select count(id) from ejercicios e
    inner join calificaciones c on e.id = c.id_ejercicio
    inner join matriculas m on c.id_alumno = m.id_alumno
    where m.id_alumno = new.id_alumno and e.id = new.id_ejercicio);
    
    if saltaerror = 0 then
		signal sqlstate '45000' set message_text = 'El alumno no está matriculado en el módulo.';
	end if;
    
END $$
DELIMITER ;