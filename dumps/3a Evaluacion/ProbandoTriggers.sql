#ejerecicio1
SELECT * FROM biblioteca_ud5.autores;
insert into autores (id_autor, nombre, apellidos) values (1, 'Gabriel', 'García Márquez');

#ejercicio3
SELECT * FROM biblioteca_ud5.prestamos;
delete from prestamos where id_ejemplar = 8 and id_socio = 59;

#ejercicio4
SELECT * FROM biblioteca_ud5.socios;
insert into socios (id_socio, nombre, apellidos, telefono, fecha_nacimiento, fecha_alta) values (80, 'pepito', 'de los palotes', '6148', '1992-08-22', '2024-01-20');
SELECT * FROM biblioteca_ud5.cumpleaños;
delete from socios where id_socio = 80;

#ejercicio 5
SELECT * FROM biblioteca_ud5.socios;
update socios set fecha_nacimiento = '1991-03-16' where id_socio = 80;
SELECT * FROM biblioteca_ud5.cumpleaños;

#ejercicio 6
SELECT * FROM biblioteca_ud5.cumpleaños;
delete from prestamos where id_socio = 1;
delete from socios where id_socio = 1;
SELECT * FROM biblioteca_ud5.cumpleaños;

#ejercicio 7
call inicializar_estadisticas();
select * from estadisticas;

#ejercicio 8
SELECT * FROM biblioteca_ud5.socios;
select * from estadisticas;
insert into socios (nombre, apellidos, telefono, fecha_nacimiento, fecha_alta) values('juanito', 'el Chupacabras', '675284632', '1985-05-23', '2024-01-01');
select * from estadisticas;

#ejercicio 9
delete from socios where id_socio = 80;
select * from estadisticas;