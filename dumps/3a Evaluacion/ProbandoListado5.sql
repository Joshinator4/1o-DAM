#PROCEDIMIENTOS <------------------
#ejercicio1
call nuevo_libro('libro Jane','Jane', 'Austen', 0, 5, 3);# salta error por cantidad de ejemplares a crear = 0
call nuevo_libro('libro Jane','Jane', 'Austen', 3, 5, 3); # crea solo el libro y los ejemplares
call nuevo_libro('libro Josh','Josh', 'Sanga', 3, 5, 3);#crea el autor, el libro y los ejemplares

#ejercicio2
call ampliar_prestamo('Maria', 'Garcia Garcia', 0);#salta error por cantidad dias = 0
call ampliar_prestamo('Maria', 'Garcia Garcia', 5);#no modifica nada porque este socio no tiene libros por entregar
call ampliar_prestamo('Francisco', 'Lopez Sanchez', 5);#añade 5 dias a la fecha limite de entrega del prestamo dia 17 pasa a ser dia 22;

#ejercicio3
call nuevo_prestamo('Maria', 'Garcia Garcia', 1, 0);#salta error por cantidad dias = 0
call nuevo_prestamo('Maria', 'Garcia Garcia', 170, 15);#salta error por no existir ejemplar
call nuevo_prestamo('Maria2', 'Garcia1 Garcia3', 170, 15);#salta error por no existir socio
call nuevo_prestamo('Maria', 'Garcia Garcia', 1, 15);#crea un prestamo con id socio 1 id pejemplar 1 fecha prestamo 2024-05-16 fecha limite 2024-05-31 y fecha devolucion null

#ejercicio4
# hay que eliminar el trigger creado en la tabla prestamo para poder borrar prestamos que aún no se han devuelto
call borrar_libro('1984');#borra libro con id 12, ejemplares 85 y 118 y por último  4 prestamos con cada uno de los id_ejemplar
call borrar_libro('19842');# salta error de libro no existe, no borra nada

#ejercicio5
call borrar_socio('Maria', 'Garcia Garcia');#Borra de las tablas cumpleaños historico_prestamos prestamos y socios donde con el id 1 que es el de Maria Garcia Garcia
call borrar_socio('Maria2', 'Garcia Garcia');#Salta el error El socio no existe

#ejercicio6
select aleatorio_entre(5, 10);

#ejercicio7
select socios_nacidos(1950);#devuelve 2 por los socios nacidos ese año
select socios_nacidos(1988);#devuelve 3 por los socios nacidos ese año

#ejercicio8
select ejemplares_comprados(2025);#devuelve todos los ejemplares (147)
select ejemplares_comprados(1997);#devuelve 9 ejemplares los adquiridos en 1996 y 1995

#ejercicio9
select numero_cumpleaños(4);# devuelve 7 porque hay 7 socios que cumplen años en Abril
select numero_cumpleaños(0);#Salta error por no estar entre 1 y 12 el mes introducido

#ejercicio10
select prestamos_pendientes(24);#devuelve 2 porque el socio con id 24 tiene 2 prestamos sin devolver
select prestamos_pendientes(0);#devuelve 15 que son todos los prestamos que existen pendientes de devolucion. el socio con id 0 no existe
select prestamos_pendientes(null);#devuelve 15 que son todos los prestamos que existen pendientes de devolucion. Se introduce el id null 

#ejercicio11
update prestamos set fecha_devolucion = curdate() where id_ejemplar = 62 and id_socio = 31;
#se actualiza el prestamo del ejemplar 62 con id_socio 31 que tenía 1 prestamo sin devolver haciendo así el 5º prestamo del ejemplar moviendose el ejemplar a la balda 1 y estanteria 1 para su revision
update prestamos set fecha_devolucion = curdate() where id_ejemplar = 91 and id_socio = 33 and fecha_prestamo = '2024-03-28';
#se actualiza el prestamo del ejemplar 91 con id socio 33 y fecha prestamo del 2024-03-28 que tenía 1 prestamo sin devolver haciendo así el 5º prestamo, moviendose el ejemplar a la balda 1 y estanteria 1 para su revision

#ejercicio12
delete from log where Guion = 'eventoPrestamos';
select * from log;