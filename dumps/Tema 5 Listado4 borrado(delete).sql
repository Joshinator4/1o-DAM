#Realiza sobre la base de datos examen_ud5 los siguientes ejercicios utilizando instrucciones DELETE.
use examen_ud5;
#1. Borra los productos que contengan la palabra DIMM.
delete from productos
where descripcion like '%DIMM%';

#2. Borra los clientes de Rusia.
delete from pedidos
where id_cliente in (select id from clientes where id_pais = 167);
delete from clientes
where id_pais = 167;

#3. Borra Rusia.
delete from paises
where pais = 'Rusia';

#4. Borra Zimbabwe. Si no se puede, ¿qué debes hacer para borrar el país?
delete from clientes 
where id_pais = (select id from paises where pais = 'Zimbabwe');
delete from paises
where pais = 'Zimbabwe';

#5. Borra todos los pedidos de historico_pedidos anteriores a 2015.
delete from historico_pedidos
where year(fecha) = 2015;

#6. Borra el cliente Gualterio Geroldo.
delete from pedidos
where id_cliente = (select id from clientes where nombre = 'Gualterio' and apellido1 = 'Geroldo');
delete from clientes 
where nombre = 'Gualterio' and apellido1 = 'Geroldo';

#7. Borra los pedidos de Danni Duchant que sean anteriores a 2020.
delete from 

#8. Borra los detalles de pedido relacionados con cable.


#9. Borra los pedidos de abril de 2011. ¿Qué pasa con los detalles de los pedidos que se borran?


#10. Borra los pedidos de los clientes de Zambia.