call devolver_libros('Maria', 'Garcia Garcia');
select estanteria_mas_poblada();
select autor_con_mas_libros();
select ultimo_prestamo_socio('Maria', 'Garcia Garcia');
insert into prestamos (id_ejemplar, id_socio, fecha_prestamo, fecha_limite, Fecha_devolucion) values (5, 24, curdate(), adddate(curdate(), interval 15 day), null);
select count(id_ejemplar) from ejemplares e where e.balda = 5 and estanteria = 4;
update ejemplares set balda =5, estanteria = 4 where id_ejemplar = 72;
insert into ejemplares values(100, curdate(), 4, 5, 1);
insert into prestamos values (1, 1, curdate(), curdate(), '2024-05-25');
update prestamos set fecha_prestamo = curdate(), fecha_limite = '2024-05-20' ,fecha_devolucion = '2024-05-27' where id_socio = 1 and id_ejemplar =1 ;
select id_ejemplar from ejemplares
        where timestampdiff(year, fecha_adquisicion, curdate()) >= 20;


select id_ejemplar, id_socio, timestampdiff(day, fecha_devolucion, curdate())
	from prestamos
	where timestampdiff(day, fecha_devolucion, curdate()) <= 5;
