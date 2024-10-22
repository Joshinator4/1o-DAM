/*DECLARACION DEL HANDLER
DECLARE handler_action HANDLER
    FOR condition_value [, condition_value] ...
    statement

handler_action: {
    CONTINUE
  | EXIT
  | UNDO
}

condition_value: {
    mysql_error_code
  | SQLSTATE [VALUE] sqlstate_value
  | condition_name
  | SQLWARNING
  | NOT FOUND
  | SQLEXCEPTION
}
*/

#manejar errores
delimiter $$
create procedure prueba3()
begin
	declare err int default 0;
	declare exit handler #exit cuando salte el error sale del procedimiento
    for sqlexception, 1064
    set err = 1;
	insert into autores values(1, 'autor', 'ap');
    select err;
end $$
delimiter ;

#crear errores personalizados
delimiter $$
create procedure prueba4(in autor int)
begin
	declare err int default 0;
	declare exit handler #exit cuando salte el error sale del procedimiento
    for sqlexception, 1064
		begin
			set err = 1;
			signal sqlstate '45000' #se usa 45000 para los errores personalizados
				set message_text = 'No se ha podido eliminar el autor',
                table_name = 'autor';
        end;
	delete from autores where id_autor = autor;
    select err;
end $$
delimiter ;

#Cursores
delimiter $$
create procedure prueba5(in autor int)
begin
	declare fin int default 0;
    declare id int;
    declare contador int default 0;
    declare titulo varchar(100);
	declare micursor cursor for
		select id_libro, titulo
        from libros
        where id_autor = autor;
	declare continue handler for not found set fin = 1;
    
    open micursor;
    fetch micursor into id , titulo; #se hace una primera busqueda antes del bucle por si solo hay 1 fila
    while fin = 0 do
		set contador = contador + 1;
		fetch micursor into id , titulo;
    end while;
    close micursor;
end $$
delimiter ;
