delimiter $$ #esto es solo si se crea en una "hoja sql" no se pone si se le da a clic derecho en functions, create function
CREATE PROCEDURE test (in dato int)
BEGIN
	declare n1, n2, n3 int default 10;
    declare nom, ape varchar(50);
    set n1 = 20;
    set n2 = n1 + 2*n3;
    set n3 = (select count(*) from socios);
    
    select count(*) into n3 from socios;
    
    select nombre, apellidos into nom, ap from socios where id_socio = 4;
END $$
delimiter ; #esto es solo si se crea en una "hoja sql" no se pone si se le da a clic derecho en functions, create function