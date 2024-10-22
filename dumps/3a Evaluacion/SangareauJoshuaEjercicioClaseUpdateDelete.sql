#Ejercicio 1
#El autor “Leo Tolstoy” debe ser “Leon Tolstoy”.
update autores
set  nombre = 'Leon',
apellidos = 'Tolstoy'
where nombre = 'Leo' and apellidos = 'Tolstoy';
# tambien puede hacerse where id_autor = (select id_autor from autores where nombre = 'Leo' and apellidos = 'Tolstoy')

#Ejercicio 2
#El libro “La metamorfosis” es de Franz Kafka y no aparece así en la base de datos.
select * from libros where titulo = 'La metamorfosis';#id_libro=5
select * from autores where nombre = 'Franz' and apellidos = 'Kafka';#id_autor =6
update libros 
set id_autor = 6
where id_libro = 5;

#Ejercicio 3
#Coloca todos los ejemplares adquiridos antes del año 2000 en la estantería 1, balda 1.
update ejemplares
set estanteria = 1,
balda = 1
where year(fecha_adquisicion) < 2000;

#Ejercicio 4
#La socia Marta Martín Sánchez nos indica que hay errores en sus datos. Su número de
#teléfono es 689012345 y su fecha de nacimiento es el 27 de noviembre de 1983.
update socios
set telefono = '689012345',
fecha_nacimiento = '1983-11-27'
where nombre = 'Marta' and apellidos = 'Martín Sánchez';

#Ejercicio 5
#El socio Manuel Pérez Rodríguez tiene préstamos pendientes de devolver y solicita
#ampliar el préstamo 15 días más. Actualiza la fecha límite a dentro de 15 días contando
#el día actual (debes calcularlo, no se pone la fecha a mano).
#NOTA: la función adddate(f, d) añade a la fecha f un total de d días. Por ejemplo,
#adddate(‘2024-04-03’, 15) devuelve 18/04/2024.
select * from socios where nombre = 'Manuel' and apellidos = 'Pérez Rodríguez';# id_socio=24
select * from prestamos where id_socio = 24 and fecha_devolucion is null; #hago esta consulta para saber si hay prestamos que no se hayan devuelto todavia
update prestamos 
set fecha_limite = adddate(curdate(), 15)
where id_socio = 24 and fecha_devolucion is null;

#Ejercicio 6
#Borra los autores para los que no hay libros en la biblioteca.
delete from autores
where id_autor not in (select id_autor from libros);


#Ejercicio 7
#La socia Julia Gómez López se da de baja. Borra todos sus datos.
delete from prestamos
where id_socio = (select id_socio from socios where nombre = 'Julia' and apellidos = 'Gómez López');
delete from socios 
where nombre = 'Julia' and apellidos = 'Gómez López';

#Ejercicio 8
#Borra el libro con título “Mrs. Dalloway”, que nunca ha sido prestado.
delete from libros
where titulo = 'Mrs. Dalloway';

#Ejercicio 9
#Borra los préstamos con fecha de préstamo anterior a 2020.
delete from prestamos 
where year(fecha_prestamo) < 2020;

#Ejercicio 10
#El socio Francisco López Sánchez realizó un préstamo ayer 2 de abril y se dejó el libro en
#el mostrador. Borra el préstamo.
select * from socios where nombre = 'Francisco' and apellidos = 'López Sánchez'; #id_socio=6
select * from prestamos where id_socio = 6 and fecha_prestamo = '2024-04-02';#hago esta consulta para comprobar que hay un prestamo en esta fecha y con el id_socio = 6
delete from prestamos
where id_socio = 6 and fecha_prestamo = '2024-04-02';