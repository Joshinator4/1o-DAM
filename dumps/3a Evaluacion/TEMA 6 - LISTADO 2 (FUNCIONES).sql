#TEMA 6 - LISTADO 2 (FUNCIONES)
#Realiza sobre la base de datos biblioteca_ud5 los siguientes ejercicios.
#1. Crea la función factorial(numero), que calcula el factorial de un número. Si el parámetro es negativo debe elevar el mensaje de error “No existe el factorial de un número negativo”.
delimiter $$
drop function if exists factorial $$
create function factorial(numero int) returns int no sql deterministic

begin
    declare devolucion int default 1;
    declare contador int default 1;
    declare exit handler for
		sqlexception
			begin
				signal sqlstate '45000' set message_text = 'No existe el factorial de un número negativo';#se podria declarar aqui el mensaje de error aqui pero spedidoseria igual para todos los casos
			end;
    if(numero < 0) then
		signal sqlstate '45000'; #se declara aqui el mensaje a mostrar por si hubiera otros casos de error poder mostrar otro tipo de mensaje
	else 
		while(contador <= numero) do
			set devolucion = devolucion * contador;
            set contador = contador + 1;
        end while;
	end if;
    return devolucion;
end $$

delimiter ;

#2. Crea la función dia_semana(dia), que devuelva el día de la semana (Lunes, Martes, Miercoles…) a partir del número de día (1 = Lunes, 2 = Martes…).
delimiter $$
drop function if exists dia_semana $$
create function dia_semana(dia int) returns varchar(15) no sql deterministic
begin
	declare devolucion varchar(15);
    declare exit handler for 
		sqlexception
			begin
				signal sqlstate '45000' set message_text = 'No existe un dia mayor que 7 o menor que 1 (de lunes a domingo)';#se podria declarar aqui el mensaje de error aqui peros eria igual para todos los casos
			end;			
    case dia
		when 1 then set devolucion = 'Lunes';
        when 2 then set devolucion = 'Martes';
        when 3 then set devolucion = 'Miércoles';
        when 4 then set devolucion = 'Jueves';
        when 5 then set devolucion = 'Viernes';
        when 6 then set devolucion = 'Sábado';
        when 7 then set devolucion = 'Domingo';
        when dia > 7 then signal sqlstate '45000';
        when dia < 1 then signal sqlstate '45000';
	end case;
    return devolucion;
end $$

delimiter ;

#3. Crea la función primo(numero), que devuelva 1 si el número es primo y 0 si no lo es.
delimiter $$
drop function if exists primo $$
create function primo(numero int) returns int no sql deterministic
begin
	declare contador int default 2;
    declare es_primo int default 1;

	set numero= abs(numero);
		if numero <2 then 
			set es_primo = false;
		else 
			while (contador < numero) and (es_primo) do 
				if numero % contador= 0 then 
					set es_primo = 0;
				end if;
				set contador= contador +1;
			end while;
		end if;

    return es_primo;
    
    return devolucion;
end $$

delimiter ;

#4. Crea la función contar_libros(estantería, balda), que devuelve los libros que hay en una estantería y balda.
delimiter $$
drop function if exists contar_libros $$
create function contar_libros(estanteria1 int, balda1 int) returns int reads sql data
begin
	declare devolucion int;
    set devolucion = (select count(*) from ejemplares where estanteria = estanteria1 and balda = balda1);
    return devolucion;
end $$

delimiter ;

#5. Crea la función contar_libros_leidos(nombre, apellidos), que devuelva los libros que se ha llevado prestados el socio identificado por su nombre y apellidos. Si el socio no
#existe, debe devolver el error “El socio no existe”.
delimiter $$
drop function if exists contar_libros_leidos $$
create function contar_libros_leidos(nombre1 varchar(30), apellidos1 varchar(50)) returns int reads sql data
begin
	declare devolucion int;
    declare socio int;
    declare exit handler for 
		sqlexception 
			begin
				signal sqlstate '45000' set message_text = 'El socio no existe';
            end;
	set socio = (select id_socio from socios where nombre = nombre1 and apellidos = apellidos1);
    if (socio is null) then
		signal sqlstate '45000';
    else
		set devolucion = (select count(*) from prestamos p
						  inner join socios s on p.id_socio = s.id_socio 
						  where s.nombre = nombre1 and s.apellidos = apellidos1);
	end if;
    return devolucion;
end $$

delimiter ;

#6. Crea la función contar_prestamos(titulo), que devuelva el número de veces que se ha prestado el libro identificado por su título. Si el libro no existe, debe devolver el
#error “El libro no existe”.
delimiter $$
drop function if exists contar_prestamos $$
create function contar_prestamos(titulo1 varchar(100)) returns int reads sql data
begin
	declare devolucion int;
    declare libro int;
    declare exit handler for 
		sqlexception 
			begin
				signal sqlstate '45000' set message_text = 'El libro no existe';
            end;
            
	set libro = (select count(*) from libros where titulo = titulo1 group by titulo); # tambien se puede hacer con el condicional if libro = 0. Tambien devolviendo el id de libro y limitandolo a 1
	
    if (libro is null) then
		signal sqlstate '45000';
    else
		set devolucion = (select count(*) from prestamos p
                          inner join ejemplares e on e.id_ejemplar = p.id_ejemplar
                          inner join libros l on  e.id_libro = l.id_libro
                          where l.titulo = titulo1);
    end if;
    return devolucion;
end $$

delimiter ;


#7. Crea la función altas(año), que devuelva el número de socios que se dieron de alta en el año indicado. Si el año indicado es inferior al año 2000, debe devolver el error
#“La biblioteca se abrió en el año 2000”.
delimiter $$
drop function if exists altas $$
create function altas(año int) returns int reads sql data
begin
	declare devolucion int;
    declare exit handler for 
		sqlexception 
			begin
				signal sqlstate '45000' set message_text = 'La biblioteca se abrió en el año 2000';
            end;
    if (año < 2000) then
		signal sqlstate '45000';
    else
		set devolucion = (select count(*) from socios
                          where year(fecha_alta) = año);
    end if;
    return devolucion;
end $$

delimiter ;

#8. Crea la función mayor(tipo), que devuelva:
#a. Si tipo = 1, el ID del socio con mayor edad.
#b. Si tipo = 2, el ID del socio con mayor antigüedad en la biblioteca.
delimiter $$
drop function if exists mayor $$
create function mayor(tipo int) returns int reads sql data
begin
	declare devolucion int;
    declare exit handler for 
		sqlexception 
			begin
				signal sqlstate '45000' set message_text = 'Tipo de operación no soportado';
            end;
    if tipo = 1 then 
		set devolucion = (select id_socio from socios order by fecha_nacimiento limit 1);
    elseif tipo = 2 then
		set devolucion = (select id_socio from socios order by fecha_alta limit 1);
    else
		signal sqlstate '45000';
    end if;
   return devolucion;
end $$
delimiter ;

#9. Crea la función num_ejemplares(titulo), que devuelve el número de ejemplares del libro identificado por su título. Si el libro no existe debe devolver el error “El libro no existe”.
delimiter $$
drop function if exists num_ejemplares $$
create function num_ejemplares(titulo1 varchar(100)) returns int reads sql data
begin
	declare devolucion int;
    declare libro int;
    declare exit handler for 
		sqlexception
			begin
				signal sqlstate '45000' set message_text = 'El libro no existe';
            end;
	set libro = (select count(*) from libros where titulo = titulo1 group by titulo); # tambien se puede hacer con el condicional if libro = 0. Tambien devolviendo el id de libro y limitandolo a 1
    
    if libro is null then 
		signal sqlstate '45000';
	else
		set devolucion = (select count(*) from ejemplares e 
						  inner join libros l on e.id_libro = l.id_libro
                          where l.titulo = titulo1);
    end if;
    return devolucion;
end $$
delimiter ;

#10. Crea la función prestamo_medio(id), que devuelve el promedio de días que tarda el socio identificado por su id en devolver los libros prestados. Para el cálculo sólo se
#tienen en cuenta los préstamos devueltos. Si el socio no existe debe devolver el error “Identificador de socio incorrecto”.
delimiter $$
drop function if exists prestamo_medio $$
create function prestamo_medio(id int) returns int reads sql data
begin
	declare devolucion int;
    declare socio int;
    declare exit handler for
		sqlexception
        begin
			signal sqlstate '45000' set message_text = 'Identificador de socio incorrecto';
        end;
	
    set socio = (select id_socio from socios where id_socio = id);
    if socio is null then
		signal sqlstate '45000';
	else	
        set devolucion = (select avg(timestampdiff(day, fecha_prestamo, fecha_devolucion)) from prestamos where id_socio = id and fecha_devolucion is not null);
	end if;
    return devolucion;
end $$
delimiter ;
