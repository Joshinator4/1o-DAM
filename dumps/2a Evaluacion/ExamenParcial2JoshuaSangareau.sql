#Ejercicio 1 (1 punto)
#a) (0,5 puntos) Crea una tabla historico_pedidos con el código, fecha, id de cliente, id
#de vendedor de los pedidos anteriores a 2023. Crea la tabla a partir de una consulta.
create table historico_pedidos as
select p.id, p.fecha, p.id_cliente, p.id_vendedor
from pedidos p 
where p.fecha < '2023-01-01';

#b) (0, 5 puntos) Añade a la tabla historico_pedidos los pedidos realizados en 2023.
insert into historico_pedidos 
select p.id, p.fecha, p.id_cliente, p.id_vendedor
from pedidos p 
where p.fecha between '2023-01-01' and '2023-12-31';
#correcto es: where year(fecha) = 2023;

#Ejercicio 2 (1 punto)
#Crea una vista clientes_ue con los países de la Unión Europea y el número de clientes
#registrados de dicho país. Ordena el resultado por el nombre del país.
create or replace view clientes_ue (pais, numero_clientes)as
select p.pais, count(*)
from clientes c
inner join paises p on c.id_pais = p.id
where p.ue = 1
group by c.id_pais
order by p.pais;

#Ejercicio 3 (1,5 puntos)
#Crea una vista bonus_fidelidad con el nombre y apellidos de empleado, departamento
#en el que trabaja y fecha de incorporación a la empresa de todos aquellos empleados
#que tienen 10 o más años de antigüedad. Ordena el resultado por apellidos y nombre.
#NOTA: para calcular la antigüedad tienes que hacer una diferencia entre dos fechas. La
#función timestampdiff(year, f1, f2) te devuelve la diferencia entre dos fechas (f2-f1)
#medida en años.
create or replace view bonus_fidelidad as 
select e.nombre, e.apellido1, e.apellido2, d.departamento, e.fecha_incorporacion, timestampdiff(year, e.fecha_incorporacion, curdate()) as años_en_la_empresa
from empleados e
inner join departamentos d on e.id_dpto = d.id
where timestampdiff(year, e.fecha_incorporacion, curdate()) >= 10
order by e.apellido1, e.apellido2, e.nombre;



#Ejercicio 4 (1,5 puntos)
#Crea una vista salarios_departamentos con el departamento, nombre y apellidos del
#jefe del departamento y el rango de salarios (el menorsalario, el mayor salario y el salario
#medio del departamento). Ordena el resultado por el nombre del departamento.
create or replace view salarios_departamentos as 
select d.departamento, e.nombre, e.apellido1, e.apellido2, min(e2.sueldo), max(e2.sueldo), avg(e2.sueldo)
from departamentos d
inner join empleados e on e.id = d.id_jefe_dpto
inner join empleados e2 on e2.id_dpto = d.id
group by d.id
order by d.departamento;


#Ejercicio 5 (1,5 puntos)
#Crea una vista pedidos_incompletos con el código de pedido, fecha de pedido y nombre
#y apellidos del vendedor de todos aquellos pedidos que no tienen detalle de pedidos.
#Ordena el resultado por fecha en sentido descendente.
create or replace view pedidos_incompletos as 
select p.id, p.fecha, e.nombre, e.apellido1, e.apellido2
from pedidos p
inner join empleados e on p.id_vendedor = e.id
left join pedidos_productos pp on p.id = pp.id_pedido
order by fecha desc;
#correcto si where pp.id_pedido is null
#correcto sin left join y where p.id not in(select id_pedido from pedido_productos)


#Ejercicio 6 (1,5 puntos)
#Crea una vista productos_esp con la descripción y precio de los productos comprados
#por clientes españoles. Ordena el resultado por la descripción.
create or replace view productos_esp as 
select pr.descripcion, pr.precio
from productos pr 
inner join pedidos_productos pp on pr.id = pp.id_producto
inner join pedidos p on pp.id_pedido = p.id
inner join clientes c on p.id_cliente = c.id
where c.id_pais = 63
order by pr.descripcion;
#mas correcto si: inner join paises pa on c.id_pais = pa.id where pa.pais = 'España'


#Ejercicio 7 (2 puntos)
#Crea una vista top_ventas con el código de pedido, fecha de pedido, nombre y apellidos
#del cliente e importe total del pedido de los 10 pedidos con importe más alto. Orden el
#resultado por importe en sentido descendente.
create or replace view top_ventas as
select p.id, p.fecha, c.nombre, c.apellido1, c.apellido2, sum(pr.precio*pp.cantidad) as importe_total
from pedidos p
inner join clientes c on p.id_cliente = c.id
inner join pedidos_productos pp on p.id = pp.id_pedido
inner join productos pr on pp.id_producto = pr.id
group by p.id #correcto sin esto: , pr.id, pp.id_pedido
order by sum(pr.precio*pp.cantidad) desc
limit 10;
