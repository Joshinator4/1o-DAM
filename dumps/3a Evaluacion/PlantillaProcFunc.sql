#FUNCION!!!!!
delimiter $$
drop function if exists nombre $$
CREATE FUNCTION nombre () returns int reads sql data #<<----------- deterministic, {CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA} 1 de estos siempre
BEGIN

RETURN ;
END $$
delimiter ;

#PROCEDIMIENTO!!!!
delimiter $$
drop procedure if exists nombre $$
CREATE procedure nombre ()
BEGIN

END $$
delimiter ;

#TRIGGER!!!
delimiter $$
drop trigger if exists nombre $$
CREATE TRIGGER nombre
before delete #<<<----------- before(antes) after(despues) de delete, update o insert <<---------- delete (old), update(new, old), insert (new) 
 ON nombreTabla FOR EACH ROW #<------------follows(despues de) nombre_trigger o precedes(antes de) nombre_trigger
BEGIN
	
END $$
DELIMITER ;

#EVENTO!!!!!!
delimiter $$ 
drop event if exists nombre $$
create event nombre 
	on schedule at current_timestamp do #<<<--------------on schedule SIEMPRE.  AT = solo 1 vez en el momento indicado.   EVERY = se repite en el intervalo indicado
begin					#^^^^----------------- interval = en el intervalo (ejemplo interval 1 minute)(ejemplo2 current_timestamp + interval 30 second)  second, minute, hour, day, week, month, year, quarter
						#^^^^----------------- starts = empieza en el momento indicado. ends = acaba en el momento indicado
end $$
delimiter ;