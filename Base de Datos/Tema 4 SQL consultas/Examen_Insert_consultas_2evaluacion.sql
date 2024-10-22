use jardineria;
#ejercicio1
# A)
insert into oficinas (CodigoOficina, Ciudad, Region, Pais, CodigoPostal, telefono, lineadireccion1) 
values ('MLG-ES', 'Málaga', 'Andalucía', 'España','CP1', 'telefono1', 'direccion1');

#B)
insert into Empleados (CodigoEmpleado, Nombre, Apellido1, Apellido2, CodigoOficina, CodigoJefe, Puesto, extension, email)
values ('32', 'Joshua','Sangareau', 'Quesada', 'MLG-ES', '7', 'Director oficina', '325','email1');

# C)
insert into Clientes (CodigoCliente, CodigoEmpleadoRepVentas, Ciudad, Region, Pais, NombreCliente, Telefono, Fax, LineaDireccion1)
values ('39', '32', 'Málaga', 'Andalucía', 'España', 'pepito', 'telefonoCLiente', 'fax1', 'direccionCliente');

#ejercicio 2
select CodigoProducto, nombre, proveedor
from productos
where nombre = 'peral' or nombre = 'manzano'
order by nombre, CodigoProducto;

#ejercicio3
select CodigoPedido, FechaPedido
from pedidos
where estado = 'rechazado' and FechaPedido like '2008%'
order by FechaPedido;

#ejercicio4
select p.CodigoPedido, dp.cantidad
from pedidos p
inner join detallepedidos dp on p.CodigoPedido = dp.CodigoPedido
order by dp.cantidad desc
limit 5;

#Ejercicio 5 
select count(*)
from pedidos p
inner join clientes c on p.CodigoCliente = c.CodigoCliente
where c.pais <> 'España';

#ejercicio6
select p.CodigoPedido, p.FechaPedido, c.NombreCliente
from pedidos p
inner join detallepedidos dp on p.CodigoPedido = dp.CodigoPedido
inner join clientes c on p.CodigoCliente = c.CodigoCliente
inner join productos pr on dp.CodigoProducto = pr.CodigoProducto
where pr.gama = 'Aromáticas'
order by p.FechaPedido;

#ejercicio7
select p.codigopedido, pa.cantidad
from pedidos p
inner join clientes c on c.CodigoCliente = p.CodigoCliente
inner join pagos pa on p.CodigoCliente = pa.CodigoCliente
group by pa.cantidad
having max(pa.cantidad);