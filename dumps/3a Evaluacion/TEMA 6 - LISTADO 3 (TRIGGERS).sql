#Realiza sobre la base de datos biblioteca_ud5 los siguientes ejercicios.
#1. Crea el trigger BEFORE INSERT en la tabla Autores para que salte el error “El autor ya está registrado.” si se intenta insertar un autor repetido.
#PREGUNTA: ¿de qué otro modo se podría hacer esto? --> Crear un índice sobre los 2 campos nombre y apellidos y que no acepten nombre y apellidos iguales
delimiter $$
drop trigger if exists autor_repetido_BI $$
CREATE TRIGGER autor_repetido_BI
before insert
 ON autores FOR EACH ROW
BEGIN
	if (NEW.nombre, NEW.apellidos) in (select nombre, apellidos from autores) then
		signal sqlstate '45000' set message_text = 'El autor está repetido';
	end if;
END $$
DELIMITER ;

#2. Repite el ejercicio anterior para BEFORE UPDATE en la tabla Autores.
delimiter $$
drop trigger if exists autor_repetido_BU $$
CREATE TRIGGER autor_repetido_BU
before update
 ON autores FOR EACH ROW
BEGIN
	if (NEW.nombre, NEW.apellidos) in (select nombre, apellidos from autores) then
		signal sqlstate '45000' set message_text = 'El autor está repetido';
	end if;
END $$
DELIMITER ;
/*
	SE PUEDE HACER EL CODIGO EN UN PROCEDIMIENTO Y USARLO EN LOS 2 TRIGGERS
    
    delimiter $$
drop procedure if exists comparador_autor_repetido $$
CREATE procedure comparador_autor_repetido (in nombre varchar(30), in apellidos (50))
BEGIN

END $$
delimiter ;
*/

#3. Crea el trigger BEFORE DELETE en la tabla Prestamos para que no permita borrar préstamos de libros sin devolver.
delimiter $$
drop trigger if exists borrar_libros_sin_devolver_BD $$
CREATE TRIGGER borrar_libros_sin_devolver_BD
before delete
 ON prestamos FOR EACH ROW
BEGIN
	if OLD.fecha_devolucion is null then
		signal sqlstate '45000' set message_text = 'El libro aún no se ha devuelto';
	end if;
END $$
DELIMITER ;

#4. Crea el trigger AFTER INSERT en la tabla Socios para que registre el nuevo socio en la tabla Cumpleaños.
delimiter $$
drop trigger if exists crear_cumpleaños_AI $$
CREATE TRIGGER crear_cumpleaños_AI
after insert
 ON socios FOR EACH ROW
BEGIN
	insert into cumpleaños (id, nombre, apellidos, dia, mes)
    values (new.id_socio, new.nombre, new.apellidos, day(new.fecha_nacimiento), month(new.fecha_nacimiento));
END $$
DELIMITER ;

#5. Crea el trigger AFTER UPDATE en la tabla Socios para que, si cambia el día y/o mes de cumpleaños, actualice la tabla Cumpleaños.
delimiter $$
drop trigger if exists actualizar_cumpleaños_AU $$
CREATE TRIGGER actualizar_cumpleaños_AU
after update
 ON socios FOR EACH ROW
BEGIN
    if day(old.fecha_nacimiento) <> day(new.fecha_nacimiento) or 
    month(old.fecha_nacimiento) <> month(new.fecha_nacimiento) then
    
		update cumpleaños
		set dia = day(new.fecha_nacimiento),
		mes = month(new.fecha_nacimiento)
		where id = new.id_socio;
	end if;
END $$
DELIMITER ;

#6. Crea el trigger AFTER DELETE en la tabla Socios para que borre el cumpleaños del socio que se borra de la tabla Cumpleaños.
#NOTA: si la tabla Cumpleaños se creó con FK a Socios y borrado en cascada, eliminar esa FK para probar este trigger.
delimiter $$
drop trigger if exists borrar_cumpleaños_AD $$
CREATE TRIGGER borrar_cumpleaños_AD
after delete
 ON socios FOR EACH ROW
BEGIN
	delete from cumpleaños
    where id = old.id_socio;
END $$
DELIMITER ;

#Para los siguientes ejercicios crea la tabla Estadísticas con la siguiente estructura:
	#NOMBRE 		TIPO 	DESCRIPCIÓN
	#Socios 		INT 	Número de socios registrados.
	#Libros 		INT 	Número de libros registrados.
	#Ejemplares 	INT 	Número de ejemplares registrados.
#Esta tabla tendrá una única fila para almacenar los contadores indicados.
create table estadisticas(
socios int,
libros int,
ejemplares int
);

#7. Crea un procedimiento inicializar_estadisticas() que guarde en la tabla los contadores. Recuerda que la tabla debe tener una única fila.
delimiter $$
drop procedure if exists inicializar_estadisticas $$
create procedure inicializar_estadisticas()
begin
	delete from estadisticas;
	/*insert into estadisticas
    set socios = (select count(*) from socios),
    libros = (select count(*) from libros),
    ejemplares = (select count(*) from ejemplares);*/
    insert into estadisticas (socios, libros, ejemplares)
    values ((select count(*) from socios),
			(select count(*) from libros),
            (select count(*) from ejemplares));
end $$
delimiter ;

#8. Crea el trigger AFTER INSERT en la tabla Socios (se debe ejecutar después del trigger del ejercicio 4) que incremente en 1 el contador de socios. (FOLLOWS <trigger>)
delimiter $$
drop trigger if exists incrementador_socios $$
create trigger incrementador_socios_AI
	after insert
    on socios for each row follows crear_cumpleaños_AI
begin
	update estadisticas
    set socios = socios + 1;
end $$
delimiter ;

#9. Crea el trigger AFTER DELETE en la tabla Socios (se debe ejecutar después del trigger del ejercicio 6) que decremente en 1 el contador de socios. (FOLLOWS <trigger>)
delimiter $$
drop trigger if exists decremento_socios_AD $$
create trigger decremento_socios_AD
	after delete
    on socios for each row follows borrar_cumpleaños_AD
begin
	update estadisticas
    set socios = socios - 1;
end $$
delimiter ;