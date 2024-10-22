use examen_ud5;

#1. Cambia la descripción del departamento “I+D” para que sea “Investigación y Desarrollo”.
update departamentos 
set departamento = 'Investigacion y Desarrollo'
where id = 3;
#tambien se puede hacer sin modo seguro where id = (select id from departamentos where departamento = 'I+D')

#2. Cambia el correo electrónico de Billi Peres para que sea billi.peres@gmail.com.
update clientes
set email = 'billi.peres@gmail.com'
where id = 1;
#tambien se puede hacer sin modo seguro where id = (select id from clientes where nombre = 'Bill' and apellido1 = 'Peres')

#3. Aumenta 1 euro a los productos en cuya descripción aparezca la palabra “cable”.
update productos
set precio = precio + 1
where descripcion like '%cable%';

#4. Descuenta 2 euros a los productos en cuya descripción aparezca la palabra “memory stick” y no sean de 2GB.
update productos
set precio = precio - 2
where descripcion like '%memory stick%' and descripcion not like '%2GB%';


#5. Aumenta un 3% el sueldo de los empleados que pertenecen al departamento de Recursos Humanos o al de Atención al cliente.
update empleados
set sueldo = sueldo * 1.03
where id_dpto = 2 or id_dpto = 6;

#6. Aumenta un 10% el sueldo de los directores.
update empleados
set sueldo = sueldo * 1.1
where id_dpto = 4;
#tambien se puede hacer where id_dpto = (select id from departamentos where departamento = 'Dirección')

#7. Añade 2.000 € al sueldo de los jefes de departamento.
update empleados 
set sueldo = sueldo + 2000
where id in (select id_jefe_dpto from departamentos);

#8. Añade 5.000 € al sueldo de los empleados que tengan 10 o más años de antigüedad.
update empleados
set sueldo = sueldo + 5000
where timestampdiff(year, fecha_incorporacion, curdate()) >= 10;

#9. Aumenta en 10 la cantidad en todos los productos de los pedidos realizados en 2024.
update pedidos_productos
set cantidad = cantidad + 10
where id_pedido in (select id from pedidos where year(fecha) = 2024);

#10. Cambia el vendedor de los pedidos de Tomi de Clerk para asociarlos a Edgar Alves.
update pedidos
set id_vendedor = (select id from empleados where nombre = 'Edgar' and apellido1 = 'Alves')#id=17
where id_vendedor in (select id from empleados where nombre = 'Tomi' and apellido1 = 'de Clerk');#id=15