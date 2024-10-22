#existe
#if
#case
#while
#repeat
#loop no es bueno, hace bucle infinito que se le mete instrucciones para que salga del bucle infinito. NO ES BUENO UTILIZARLO


#declare n1, n2, n3 int default 10;
#declare nom, ape varchar(50);
    
    
/* COMO USAR IF (ejemplo)
if n1 = 0 then 
	set nombre = null;
else 
    set nombre = 'pepito';
end if;

if n1 = 0 then 
	set nombre = null;

elseif n1 = 1 then 
	set nombre = 'juanito';
else 
    set nombre = 'pepito';
end if;

*/

/*COMO USAR EL CASE (ejemplo)
case n1
when 0 then set nombre = 'cero';
when 1 then set nombre = 'uno';
else set nombre = 'otro valor';
end case;

case 
when n1 = 0 then set nombre = 'cero';
when n2 = 1 and n3 < 5 then set nombre = 'uno y menor que 5';
else set nombre = 'otro valor';
end case;
*/

/*COMO USAR EL WHILE (ejemplo) while = MIENTRAS!!!
set n1 = 10;
while n1 > 0 do
	insert into prestamos (id_ejemplar, id_socio, fecha_prestamo, fecha_devolucion)
    values (1, 1, curdate(), curdate());
    set n1 = n1 - 1; # para que en algun momento salga del bucle, que no sea infinito
end while;
*/

/*COMO USAR REPEAT (ejemplo) until = HASTA!!!! 
repeat
while n1 > 0 do
	insert into prestamos (id_ejemplar, id_socio, fecha_prestamo, fecha_devolucion);
    values (1, 1, curdate(), curdate())
    set n1 = n1 - 1; # para que en algun momento salga del bucle, que no sea infinito
until n1= 0
end repeat
*/