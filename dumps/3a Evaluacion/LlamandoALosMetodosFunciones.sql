select biblioteca_ud5.factorial(-1);
select biblioteca_ud5.factorial(0);
select biblioteca_ud5.factorial(5);
select biblioteca_ud5.dia_semana(0);
select biblioteca_ud5.dia_semana(6);
select biblioteca_ud5.primo(3);
select biblioteca_ud5.primo(5);
select biblioteca_ud5.primo(6);
select biblioteca_ud5.primo(8);
select biblioteca_ud5.contar_libros(1, 1);
select biblioteca_ud5.contar_libros(2, 5);
select biblioteca_ud5.contar_libros(11, 5);
select biblioteca_ud5.contar_libros_leidos('Maria', 'Garcia Garcia');#->3
select biblioteca_ud5.contar_libros_leidos('Javier', 'Gómez López');#->11
select biblioteca_ud5.contar_libros_leidos('Cualquier', 'Nombre');#-> Error Code: 1644. El socio no 
select biblioteca_ud5.contar_prestamos('Cien años de soledad');#-->6
select biblioteca_ud5.contar_prestamos('El viejo y el mar');#-->1
select biblioteca_ud5.contar_prestamos('Otro libro');#-> Error Code: 1644. El libro no existe
select biblioteca_ud5.altas(1990);#-> Error Code: 1644. La biblioteca se abrió en el año 2000.
select biblioteca_ud5.altas(2000);#-> 9
select biblioteca_ud5.altas(2001);#-> 4
select biblioteca_ud5.mayor(1); #-->11
select biblioteca_ud5.mayor(2); #-->52
select biblioteca_ud5.mayor(3); #-->Eror Code: 1644. Tipo de operación no soportado.
select biblioteca_ud5.num_ejemplares('Otro libro'); #-> Error Code: 1644. El libro no existe.
select biblioteca_ud5.num_ejemplares('Cien años de soledad');# -> 1
select biblioteca_ud5.num_ejemplares('El viejo y el mar');# -> 3
select biblioteca_ud5.prestamo_medio(1); #-> 7
select biblioteca_ud5.prestamo_medio(2); #-> 7,5
select biblioteca_ud5.prestamo_medio(200); #-> Error Code: 1644. Identificador de socio incorrecto.