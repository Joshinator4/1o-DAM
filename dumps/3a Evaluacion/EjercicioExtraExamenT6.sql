delimiter $$
drop procedure if exists matricular_alumno $$
CREATE procedure matricular_alumno(in nombre varchar(20), in apellidos varchar(40), in grupo varchar(10))
BEGIN
	declare alumno int;
	declare grup int;
    declare modulo int;
    declare ejercicio int;
    declare final int default 0;
    declare micursor cursor for
		select id from modulos;
	declare micursor2 cursor for
		select id from ejercicios e where id_modulo = modulo;
	declare continue handler for not found set final = 1;
	set grup = (select id from grupos g where g.grupo = grupo);
    if grup is null then
		signal sqlstate '45000' set message_text = 'El grupo no existe.';
	end if;
    insert into alumnos (nombre, apellidos, id_grupo) values(nombre, apellidos, grup);
    set alumno = (select id from alumnos a where a.nombre = nombre and a.apellidos = apellidos);
    
    open micursor;
    fetch micursor into modulo;
    while final = 0 do
		insert into matriculas (id_alumno, id_modulo) values (alumno, modulo);
        open micursor2;
		fetch micursor2 into ejercicio;
        while final = 0 do 
			insert into calificaciones (id_ejercicio, id_alumno) values (ejercicio, alumno);
            fetch micursor2 into ejercicio;
        end while;
        close micursor2;
        set final = 0;
        fetch micursor into modulo;
	end while;
    close micursor;
    
END $$
delimiter ;

call matricular_alumno('Joshua', 'Sangareau Quesada', '1DAX');# salta error el grupo no existe
call matricular_alumno('Joshua', 'Sangareau Quesada', '1DAM');# crea el alumno en el grupo 1DAM id_grupo = 1, se le matricula en los 6 módulos y en calificaciones se le asignan los 132 ejercicios a realizar con la nota null
call matricular_alumno('Rafael', 'Garcia Cambron', '1DAW');# crea el alumno con el grupo 1DAW id_grupo = 2, se le matricula en los 6 módulos y en calificaciones se le asignan los 132 ejercicios a realizar con la nota null