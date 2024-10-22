/*Ejercicio 1 (1,5 puntos)
Crea la función total_alumnos(grupo, modulo), donde:
• grupo es el identificador del grupo.
• módulo es el identificador del módulo.
La función debe devolver el número de alumnos del grupo matriculados en el módulo.
Si el grupo y/o módulo no existen, debe devolver -1.*/
delimiter $$
drop function if exists total_alumnos $$
CREATE FUNCTION  total_alumnos(grupo int, modulo int) returns int reads sql data
BEGIN
	declare grupo1 int;
    declare modulo1 int;
    declare devolucion int;
    set grupo1 = (select id from grupos g where g.id = grupo);
    set modulo1 = (select id from modulos m where m.id = modulo);
    
    if modulo1 is null or grupo1 is null then
		set devolucion = -1;
	else
		set devolucion = (select count(*) from alumnos a
							inner join matriculas m on m.id_alumno = a.id
                            inner join modulos mo on m.id_modulo = mo.id
                            inner join grupos g on a.id_grupo = g.id
                            where mo.id = modulo1 and g.id = grupo1);
    end if;
    
RETURN devolucion;
END $$
delimiter ;

/*Ejercicio 2 (3 puntos)
Crea el procedimiento nota_alumno(alumno, modulo), donde:
• alumno es el identificador del alumno.
• modulo es el identificador del módulo.
El procedimiento debe actualizar la fila indicada de la tabla Matriculas:
- nota: nota final del alumno en el módulo (con decimales) a partir de las notas de la
tabla Calificaciones según el siguiente cálculo:
nota final = 40%(media de las prácticas del alumno en el módulo) + 60%(media de los
exámenes del alumno en el módulo)
- nota_seneca: es la nota final redondeada a número entero. Si al redondear la nota
el resultado es cero, debe guardarse un uno.*/
delimiter $$
drop procedure if exists nota_alumno $$
CREATE procedure nota_alumno(in alumno int, in modulo int)
BEGIN

	declare total double;
    set total = ((select avg(c.nota) from alumnos a
				inner join matriculas ma on ma.id_alumno = a.id
				inner join calificaciones c on a.id = c.id_alumno
                inner join ejercicios e on c.id_ejercicio = e.id
                inner join modulos mo on mo.id = ma.id_modulo
                where e.id_tipo = 1 and a.id = alumno and mo.id = modulo)*0.6) + 
                ((select avg(c.nota) from alumnos a
				inner join matriculas ma on ma.id_alumno = a.id
				inner join calificaciones c on a.id = c.id_alumno
                inner join ejercicios e on c.id_ejercicio = e.id
                 inner join modulos mo on mo.id = ma.id_modulo
                where e.id_tipo = 2 and a.id = alumno and mo.id = modulo)*0.4);
	if round(total) = 0 then
		update matriculas 
		set nota = total,
		nota_seneca = 1
        where id_alumno = alumno and id_modulo = modulo;
    else
		update matriculas 
		set nota = total,
		nota_seneca = round(total)
		where id_alumno = alumno and id_modulo = modulo;     
    end if;
END $$
delimiter ;

/*Ejercicio 3 (2,5 puntos)
Crea el procedimiento actualizar_notas_finales(). El procedimiento debe actualizar las
notas de todas las filas de la tabla Matriculas. Realiza todas las operaciones en una
transacción.*/
delimiter $$
drop procedure if exists actualizar_notas_finales $$
CREATE procedure actualizar_notas_finales()
BEGIN
	declare terminar int default 0;
    declare idAlumno int;
	declare micursor cursor for
		select a.id from alumnos a;
	declare continue handler for not found set terminar = 1;
	start transaction;
    open micursor;
    fetch micursor into idAlumno;
    while terminar = 0 do
		update matriculas
		set nota = ((select avg(c.nota) from alumnos a
					inner join calificaciones c on a.id = c.id_alumno
					inner join ejercicios e on c.id_ejercicio = e.id
					inner join modulos mo on mo.id = e.id_modulo
					where e.id_tipo = 1 and a.id = idAlumno)*0.6 ) + 
					((select avg(c.nota) from alumnos a
					inner join calificaciones c on a.id = c.id_alumno
					inner join ejercicios e on c.id_ejercicio = e.id
					 inner join modulos mo on mo.id = e.id_modulo
					where e.id_tipo = 2 and a.id = idAlumno)*0.4),
			nota_seneca = round(nota)
            where id_alumno = idAlumno;
		fetch micursor into idAlumno;
	end while;
    commit;
END $$
delimiter ;



/*Ejercicio 4 (1,5 puntos)
Crea el procedimiento borrar_alumno(nombre, apellidos), donde:
• nombre, apellidos son el nombre y apellidos del alumno.
El procedimiento debe borrar todos los datos del alumno. Si se indican nombre y
apellidos de un alumno que no existe debe mostrarse el error “El alumno no existe.”*/
delimiter $$
drop procedure if exists borrar_alumno $$
CREATE procedure borrar_alumno(in nombre varchar(20), in apellidos varchar(40))
BEGIN
	declare idAlumno int;
    declare terminar int default 0;
    declare idEjercicio int;
    declare micursor cursor for
		select e.id from ejercicios e
        inner join calificaciones c on e.id = c.id_ejercicio
        inner join alumnos a on c.id_alumno = a.id
        where a.id = idAlumno;
	declare continue handler for not found set terminar = 1;
    declare exit handler for sqlexception
		begin
			signal sqlstate '45000' set message_text = 'El alumno no existe';
		end;
	set idAlumno = (select a.id from alumnos a where a.nombre = nombre and a.apellidos = apellidos);
    
    if idAlumno is null then
		signal sqlstate '45000';
	else 
		delete from calificaciones c
		where c.id_alumno = idAlumno; 
        delete from matriculas m
        where m.id_alumno = idAlumno;
		delete from alumnos a
        where a.id = idAlumno;
        open micursor;
        fetch micursor into idEjercicio;
		while terminar = 0 do
			delete from ejercicios e
            where e.id = idEjercicio;
            fetch micursor into idEjercicio;
        end while;
        close micursor;
        
    end if;
    
END $$
delimiter ;


/*Ejercicio 5 (1,5 puntos)
Crea la función aprobados(modulo), donde:
• módulo es el nombre del módulo.
La función debe devolver el número de alumnos aprobados en el módulo indicado (a
partir de la nota de la tabla Matriculas). Si el módulo no existe, debe devolver -1.*/
delimiter $$
drop function if exists aprobados $$
CREATE FUNCTION aprobados(modulo varchar(30)) returns int reads sql data
BEGIN
	declare devolucion int;
    declare idModulo int;
    
    set idModulo = (select m.id from modulos m where m.modulo = modulo);
    
    if idModulo is null then
		set devolucion = -1;
	else 
		set devolucion = (select count(*) from matriculas ma where nota >= 5 and id_modulo = idModulo);
	end if;
    
RETURN devolucion;
END $$
delimiter ;

