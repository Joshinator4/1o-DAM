/*
Realiza sobre la base de datos biblioteca_ud5 los siguientes ejercicios.

CONSEJO: para facilitar la depuración del código de los guiones que crees, crea una tabla Log
para ir registrando información para depurar tu código, con los siguientes campos (en negrita
los campos obligatorios):
NOMBRE 					TIPO						 DESCRIPCIÓN
Id 						INT 						PK

Instante 				TIMESTAMP 					Instante en el que se inserta el comentario.
													Valor por defecto: el instante actual.
                                                    
Guion 					VARCHAR(20) 				Nombre del guion que registra el comentario.

Comentario 				VARCHAR(20) 				Comentario que se desea añadir para facilitar 
													la depuración del guion.
                                                    
Observaciones 			VARCHAR(100) 				Información adicional que añadir al
													comentario.
*/

#1. Crea un procedimiento escribir_log(guion, comentario, observaciones), que registra un nuevo comentario en la tabla Log.

delimiter $$
create table if not exists log
(
Id int auto_increment,
Instante timestamp not null default now(),
Guion varchar(20) not null,
Comentario varchar(20) not null,
Observaciones varchar(100),
primary key (Id)
)$$
drop procedure if exists escribir_log $$
create procedure escribir_log(in guion1 varchar(20), in comentario1 VARCHAR(20), in observaciones1 VARCHAR(100))
begin
	insert into log (Guion, Comentario, Observaciones) values (guion1, comentario1, observaciones1);
end $$
delimiter ;

#2. Crea un procedimiento borrar_log(fecha), que borra todos los registros de Log anteriores a la fecha. Si no se indica fecha, se borran todos los registros. El borrado
#debe hacerse dentro de una transacción.
delimiter $$
drop procedure if exists borrar_log $$
create procedure borrar_log(in fecha timestamp)
begin
	if fecha is null then
		call escribir_log('borrar_log', concat('la fecha introducida es: ', fecha), 'La fechas es nula no se borrará todos los datos');
		delete from log;
    else 
		call escribir_log('borrar_log', concat('la fecha introducida es: ', fecha), 'Se borrarán los datos anteriores a la fecha señalada');
		start transaction;
		delete from log where Instante < fecha;
		commit;
    end if;
    call escribir_log('borrar_log',  'FIN', '');
end $$
delimiter ;

#3. Crea un procedimiento mover_libros_balda(estanteria1, balda1, estanteria2, balda2, movimientos), que mueve los ejemplares localizados en estanteria1 y balda1 a la estanteria2 y balda2.
delimiter $$
drop procedure if exists mover_libros_balda $$
create procedure mover_libros_balda(in estanteria1 int, in balda1 int, in estanteria2 int, in balda2 int, out movimientos int)
begin
	declare terminar int default 0;
	declare ejemplar int;
    declare cursorejemplares cursor for
		select id_ejemplar 
		from ejemplares
        where estanteria = estanteria1 and balda = balda1;
	declare continue handler for not found set terminar = 1;
    
    set movimientos = 0;
    open cursorejemplares;
    fetch cursorejemplares into ejemplar;
    while terminar = 0 do
		set movimientos = movimientos + 1;
		update ejemplares 
        set estanteria = estanteria2,
        balda = balda2
        where id_ejemplar = ejemplar;
        fetch cursorejemplares into ejemplar;
    end while;
    close cursorejemplares;
end $$
delimiter ;

/*TAMBIEN SE PODRIA HACER ASI
Delimiter $$ 
Create procedure mover_libros_balda (in estanteria1 int, in balda1 int, in estanteria2 int, in balda2 int, out movimientos int)
begin
	set movimientos = (select count(*) from ejemplares where estanteria = estanteria1 and balda = balda1);
	if movimientos > 0 then
		update ejemplares 
		set estanteria = estanteria2,
		balda=balda2
		where estanteria=estanteria1 and balda=balda1;
	end if;
end $$
Delimiter ;
*/

#4. Crea un procedimiento localizar_ejemplar(id, estantería, balda), que a partir del identificador del ejemplar devuelva la estantería y balda donde se encuentra. Si no
#existe el ejemplar, estantería y balda deben devolver el valor -1.
delimiter $$
drop procedure if exists localizar_ejemplar $$
create procedure localizar_ejemplar(in id int, out estan int, out bald int)
begin
	declare ejemplar int;
    set ejemplar = (select id_ejemplar from ejemplares where id_ejemplar = id);
    if ejemplar is null then
		set estan = -1;
		set bald = -1;
    else
		set estan = (select estanteria from ejemplares where id_ejemplar = id);
		set bald = (select balda from ejemplares where id_ejemplar = id);
    end if;
end $$
delimiter ;

#5. Crea un procedimiento libro_mas_leido(titulo, autor), que devuelva el título y autor del libro más leído (contando todos sus ejemplares). Autor debe ser el resultado de
#concatenar nombre y apellidos del autor (la función CONCAT permite concatenar textos).
delimiter $$
drop procedure if exists libro_mas_leido $$
create procedure libro_mas_leido(out titulo1 varchar(100), out autor varchar(50))
begin
	declare idlibro int;
    declare idlibromasleido int;
    declare idautor int;
    declare idejemplar int;
    declare cantidadvecesleido int;
    declare cantidadmax int;
    declare terminar int default 0;
    /* PRIMERO LO PENSABA QUE ERA ASI
    et idlibro = (select id_libro from ejemplares group by id_libro having count(*) order by count(*) desc limit 1);
    set titulo1 = (select titulo from libros where id_libro = idlibro);
    set idautor = (select id_autor from libros where id_libro = idlibro);
    set autor = concat((select nombre from autores where id_autor = idautor), ' ', (select apellidos from autores where id_autor = idautor));
    */
    declare micursor cursor for
		select id_libro
        from libros;
	declare micursor2 cursor for
		select id_ejemplar
        from ejemplares 
        where id_libro = idlibro;
	declare continue handler for not found set terminar = 1;
    
    set cantidadmax = 0;
    open micursor;
    fetch micursor into idlibro;
	while terminar = 0 do
    
		open micursor2;
        fetch micursor2 into idejemplar;
        set cantidadvecesleido = 0;
        while terminar = 0 do
			set cantidadvecesleido = cantidadvecesleido + (select count(*) from prestamos where id_ejemplar = idejemplar);
            fetch micursor2 into idejemplar;
		end while;
        close micursor2;
        set terminar = 0;
        
        if cantidadvecesleido > cantidadmax then
			set cantidadmax = cantidadvecesleido;
            set idlibromasleido = idlibro;
		end if;
        
        fetch micursor into idlibro;
    end while;
    
    close micursor;
    
	set titulo1 = (select titulo from libros where id_libro = idlibromasleido);
    set idautor = (select id_autor from libros where id_libro = idlibromasleido);
    set autor = concat((select nombre from autores where id_autor = idautor), ' ', (select apellidos from autores where id_autor = idautor));
end $$
delimiter ;
#Da como resultado 'Los cuentos de Beedle el bardo' con 9 veces leido
/*TAMBIEN SE PUEDE HACER ASÍ Y ES MAS EFICIENTE
delimiter $$
create procedure libro_mas_leido(out titulo varchar(100), out autor varchar(80))
begin
	select l.titulo, concat(a.nombre, ' ', a.apellidos) escritor
    into titulo, autor
	from libros l
		inner join ejemplares e on l.id_libro = e.id_libro
		inner join prestamos p on e.id_ejemplar = p.id_ejemplar
		inner join autores a on l.id_autor = a.id_autor
	group by l.titulo, escritor
	order by count(*) desc
	limit 1;
end $$
delimiter ;
*/

#6. Crea un procedimiento autor_mas_leido(autor, prestamos), que devuelve el autor (nombre concatenado con apellidos) y número de préstamos de sus obras del autor más leído.
delimiter $$
drop procedure if exists autor_mas_leido $$
create procedure autor_mas_leido(out autor varchar(50), out prestamos1 int)
begin
	declare idautor int;
    declare idautormasleido int;
    declare idlibro int;
    declare idejemplar int;
    declare cantidadprestamos int;
    declare prestamosmax int;
    declare terminar int default 0;
    declare micursor cursor for
		select id_autor 
        from autores;
	declare micursor2 cursor for
		select id_libro
        from libros 
        where id_autor = idautor;
	declare micursor3 cursor for
		select id_ejemplar 
        from ejemplares 
        where id_libro = idlibro;
	declare continue handler for not found set terminar = 1;
	
	set prestamosmax = 0;
    open micursor;
	fetch micursor into idautor;
    while terminar = 0 do
    set cantidadprestamos = 0;
		open micursor2;
		fetch micursor2 into idlibro;
		while terminar = 0 do
			open micursor3;
			fetch micursor3 into idejemplar;
            while terminar = 0 do
				set cantidadprestamos = cantidadprestamos + (select count(*) from prestamos where id_ejemplar = idejemplar group by id_ejemplar);
                fetch micursor3 into idejemplar;
			end while;
			if cantidadprestamos > prestamosmax then
				set prestamosmax = cantidadprestamos;
				set idautormasleido = idautor;
			end if;
            set terminar = 0;
            close micursor3;
            fetch micursor2 into idlibro;
		end while;
        
        set terminar = 0;
        close micursor2;
        fetch micursor into idautor;
    end while;
    
    close micursor;
    
    set autor = concat((select nombre from autores where id_autor = idautormasleido), ' ', (select apellidos from autores where id_autor = idautormasleido));
    set prestamos1 = prestamosmax;
end $$
delimiter ;

/*TAMBIEN SE PUEDE HACER ASI
delimiter $$
create procedure autor_mas_leido(out autor1 varchar(100), out NumemeroPrestamos int)		
begin
	select concat(a.nombre,' ',a.apellidos), count(*)
	into autor1,NumemeroPrestamos
	from libros l
	inner join autores a on a.id_autor = l.id_autor
	inner join ejemplares e on e.id_libro = l.id_libro
	inner join prestamos p on p.id_ejemplar = e.id_ejemplar
	group by a.id_autor						 
	order by count(*) desc
    limit 1;
end $$
delimiter ;
*/

#Para los dos próximos ejercicios es necesario crear una tabla Cumpleaños(id, nombre, apellidos, día, mes). Día y mes deben ser números para guardar el día (1..31)
#y el mes (1..12) del cumpleaños del socio.
create table cumpleaños 
(
id int,
nombre varchar(30),
apellidos varchar(50),
dia int check (dia >= 1 and dia <= 31),
mes int check (mes >=1 and mes <= 12),
primary key(id)
);

#7. Crea un procedimiento calcular_cumpleaños() para guardar en la tabla cumpleaños las fechas de cumpleaños de los socios de la biblioteca. Utiliza una transacción y
#cursor para resolver este ejercicio.
delimiter $$
drop procedure if exists calcular_cumpleaños $$
create procedure calcular_cumpleaños()
begin
	declare terminar int default 0;
    declare idsocio int;
    declare nombresocio varchar(30);
    declare apellidossocio varchar(50);
    declare fechasocio date;
	declare micursor cursor for
    select id_socio, nombre, apellidos, fecha_nacimiento
    from socios;
	declare continue handler for not found set terminar = 1;
    START TRANSACTION;
	open micursor;
    fetch micursor into idsocio, nombresocio, apellidossocio, fechasocio;
    
    while terminar = 0 do
		insert into cumpleaños values(idsocio, nombresocio, apellidossocio, day(fechasocio), month(fechasocio));
        fetch micursor into idsocio, nombresocio, apellidossocio, fechasocio;
	end while;
    
    close micursor;
	commit;
end $$
delimiter ;

#8. Crea un procedimiento próximo_cumpleaños(fecha, fecha_cumpleaños, socio, edad), que a partir de una fecha devuelva la fecha del próximo cumpleaños de cualquier socio, el
#nombre completo del socio y la edad que va a cumplir. Realiza la consulta sobre la tabla cumpleaños. Para los dos próximos ejercicios es necesario crear una tabla Historico_prestamos
#con la misma estructura que la tabla Prestamos. Utiliza transacciones en todos los ejercicios.

create table historico_prestamos like prestamos;

delimiter $$
drop procedure if exists proximo_cumpleaños $$
create procedure proximo_cumpleaños(in fecha date, out fecha_cumpleaños date, out socio varchar(80), out edad int)
begin
	declare idsocio int;
    declare terminar int default 0;
    declare fecha_nacimiento1 date;
    
    start transaction;
    set idsocio = (select id from cumpleaños c 
					where (c.mes = month(fecha) and c.dia >= day(fecha)) or mes > month(fecha) order by mes, dia limit 1);
    set fecha_cumpleaños = concat(year(fecha), '-', (select mes from cumpleaños where id = idsocio), '-', (select dia from cumpleaños where id = idsocio));
    set socio = concat((select nombre from cumpleaños where id = idsocio), ' ', (select apellidos from cumpleaños where id = idsocio));
    set fecha_nacimiento1 = (select fecha_nacimiento from socios where id_socio = idsocio);
    set edad = year(fecha_cumpleaños) - year(fecha_nacimiento1);
    
    
    commit;
end $$
delimiter ;

#9. Crea un procedimiento mover_historico(tiempo), que mueve los préstamos a la tabla de históricos con una antigüedad en años igual o mayor al tiempo indicado por
#parámetro. El año indicado en tiempo debe ser igual o superior a uno, si se indica un valor erróneo debe devolver el error “Debe indicar al menos un año de antigüedad”.
#Utiliza un cursor para resolver este ejercicio.
delimiter $$
drop procedure if exists mover_historico $$
create procedure mover_historico(in tiempo int)
begin
	declare idejemplar, idsocio int;
    declare terminar int default 0;
    declare fechaprest, fechalim, fechadev date;
    
    declare micursor cursor for 
		select id_ejemplar, id_socio, fecha_prestamo, fecha_limite, fecha_devolucion
        from prestamos
        where timestampdiff(year, fecha_prestamo, curdate()) >= tiempo;
        
	declare exit handler for sqlexception
		begin
			signal sqlstate '45000'set message_text = 'Debe indicar al menos un año de antigüedad';
        end;
	declare continue handler for not found set terminar = 1;
    if(tiempo < 1) then
		rollback;
		signal sqlstate '45000'; #se declara aqui el mensaje a mostrar por si hubiera otros casos de error poder mostrar otro tipo de mensaje
	end if;
	start transaction;
		open micursor;
        fetch micursor into idejemplar, idsocio, fechaprest, fechalim, fechadev;
        while(terminar = 0) do
			insert into historico_prestamos values (idejemplar, idsocio, fechaprest, fechalim, fechadev);
            delete from prestamos where id_ejemplar = idejemplar and id_socio = idsocio and fecha_prestamo = fechaprest and fecha_limite = fechalim and fecha_devolucion = fechadev;
			fetch micursor into idejemplar, idsocio, fechaprest, fechalim, fechadev;
        end while;
        close micursor;
		#select * into historico_prestamos from prestamos where timestampdiff(year, fecha_prestamo, curdate()) >= tiempo; SE PODRIA HACER ASI SIN CURSOR
    commit;
end $$
delimiter ;


#10. Crea un procedimiento borrar_historico_prestamos(fecha, num_borrados), que borra los préstamos del histórico anteriores a la fecha indicada. En num_borrados se
#devolverá el número de préstamos borrados.
delimiter $$
drop procedure if exists borrar_historioca_prestamos $$
create procedure borrar_historico_prestamos(in fecha date, out num_borrados int)
begin
	set num_borrados = (select count(*) from historico_prestamos where fecha_prestamo < fecha);
    if num_borrados > 0 then
		start transaction;
		delete from historico_prestamos
		where fecha_prestamo < fecha;
        commit;
	end if;
end $$
delimiter ;