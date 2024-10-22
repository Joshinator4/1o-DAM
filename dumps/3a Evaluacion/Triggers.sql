delimiter $$
	drop trigger if exists autores_before_insert $$
	CREATE TRIGGER autores_before_insert

before insert on autores for each row

BEGIN
	call escribir_log('insert_autores','trigger',null);
 
END $$

delimiter ;

#---------------------------------------------------------------------------
insert into autores (nombre, apellidos) values 
('Periquito', 'de los Palotes');

#---------------------------------------------------------------------------

delimiter $$
	drop trigger if exists autores_before_insert $$
	CREATE TRIGGER autores_before_insert

before insert on autores for each row

BEGIN

	insert into log(guion, comentario, observaciones)
    values ('autor_insert', new.nombre, new.apellidos);
	
 
END $$

delimiter ;
#--------------------------------------------------------------------------
# Este triger es para antes de insertar.
delimiter $$
	drop trigger if exists autores_before_insert $$
	CREATE TRIGGER autores_before_insert

before insert on autores for each row

BEGIN
	insert into log(guion, comentario, observaciones)
		values ('BEFORE_AUTOR_IN', new.nombre, new.apellidos);
    # Podemos comprobar que el autor que vamos a meter no este repetido.
    # Si lo esta, lanzamos una excepcion y escribimos el log.
    if (new.nombre, new.apellidos) in (select nombre, apellidos from autores) then
    
		insert into log(guion, comentario, observaciones) values
		('autores_insert', 'autor_repetido', null);
    
		signal sqlstate '45000' set message_text= 'autor repetido';
	end if;
END $$
delimiter ;
#---------------------------------------------------------------------------
insert into autores (nombre, apellidos) values 
('Periquito', 'de los Palotes');

#---------------------------------------------------------------------------
# Este triger es para despues, añadiendo AFTER
delimiter $$
	drop trigger if exists autores_after_insert $$
	CREATE TRIGGER autores_after_insert
# AQUI SE PONE EL AFTER, reemplazando el before.
after insert on autores for each row

BEGIN
	insert into log(guion, comentario, observaciones)
		values ('AFTER_AUTOR_IN', new.nombre, new.apellidos);
    # Podemos comprobar que el autor que vamos a meter no este repetido.
    # Si lo esta, lanzamos una excepcion y escribimos el log.
    
END $$
delimiter ;

insert into autores (nombre, apellidos) values 
('Periquito2', 'de los Palotes2');

/* Lo que hemos conseguido con 2 triger before y after, es que antes
de inserter autores, se comprueben los datos, se crea una entrada en log
especificando que triger es.

Una vez insertado, con un triger de after, se vuelve a introducir
un valor nuevo en la tabla log, justo DESPUES de haber introducido 
algo en la tabla autores.

*/