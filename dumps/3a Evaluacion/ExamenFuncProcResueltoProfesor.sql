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
    declare devolucion int default -1;
    
    if grupo in (select id from grupos) and modulo in (select id from modulos) then
		set devolucion = (select count(*) from alumnos a 
        inner join matriculas m on a.id = m.id_alumno
        where a.id_grupo = grupo and m.id_modulo = modulo);
	end if;
    return devolucion;
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
drop procedure if exists media $$
CREATE procedure media(id_alumno int, id_modulo int, id_tipo_ejercicio int)
BEGIN
	declare devolucion float default 0;
    set devolucion = (select avg(c.nota)
						from calificaciones c
						inner join ejercicios e on c.id_ejercicio = e.id
                        where e.id_modulo = id_modulo and c.id_alumno = id_alumno and e.id_tipo = id_tipo_ejercicio);  
    
END $$
delimiter ;

delimiter $$
drop procedure if exists nota_alumno $$
CREATE procedure nota_alumno(in alumno int, in modulo int)
BEGIN
	declare media_practica, media_examen float default 0;
    set media_practica = media(alumno, modulo, 2);
    set media_examen = media(alumno, modulo, 1);
    
    update matriculas set
		nota = (0.4*media_practica) + (0.6*media_examen),
        nota_seneca = if(round(nota) = 0, 1, round(nota))
	where id_alumno = alumno and id_modulo = modulo;
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
	declare fin int default 0;
    declare alumno, modulo int;
    declare c_matriculas cursor for
		select id_alumno, id_modulo from matriculas;
    declare continue handler for not found set fin = 1;
    declare exit handler for sqlexception rollback;
    
    start transaction;
    open c_matriculas;
    fetch c_matriuclas into alumno, modulo;
    while fin = 0 do
		call nota_alumno(alumno, modulo);
        fetch c_matriculas into alumno, modulo;
	end while;
    close c_matriculas;
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
	declare id_alumno int;
    
    set id_alumno = (select id from alumnos a
					where a.nombre = nombre and a.apellidos = apellidos);
	if id_alumno is null then
		signal sqlstate '45000'
			set message_text = 'El alumno no existe';
	else 
		delete from matriculas m where m.id_alumno = id_alumno;
        delete from calificaciones c where c.id_alumno = id_alumno;
        delete from alumnos a where a-id = id_alumno;
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
		set devolucion = (select count(*) from matriculas ma where nota_seneca >= 5 and id_modulo = idModulo);
	end if;
    
RETURN devolucion;
END $$
delimiter ;
END $$
delimiter ;
