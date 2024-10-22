#Ejercicio 1 (2 puntos)
#Crea la función descuento(id), que a partir del identificador de un cliente devuelva el descuento que se va a aplicar en sus pedidos según la siguiente tabla:
#Antigüedad        	Valor a devolver
#Cliente no existe 		0
#Menos de un año 		0
#Un año 				1
#Dos años 				2
#…
#Nueve 9 años 			9
#10 o más 				10
delimiter $$
drop function if exists descuento $$
create function descuento(id int) returns int reads sql data 
begin

	declare devolucion int;
    declare cliente date;
    declare antiguedad int;
    
    set cliente = (select fecha_alta from clientes c where c.id = id);
    set antiguedad = timestampdiff(year, cliente, curdate());
    
    if cliente is null then 
		set devolucion = 0;
	else 
		case 
		when antiguedad < 1 then set devolucion = 0;
        when antiguedad = 1 then set devolucion = 1;
        when antiguedad = 2 then set devolucion = 2;
        when antiguedad = 3 then set devolucion = 3;
        when antiguedad = 4 then set devolucion = 4;
        when antiguedad = 5 then set devolucion = 5;
        when antiguedad = 6 then set devolucion = 6;
        when antiguedad = 7 then set devolucion = 7;
        when antiguedad = 8 then set devolucion = 8;
        when antiguedad = 9 then set devolucion = 9;
        when antiguedad >= 10 then set devolucion = 10;
        end case;
        
	end if;
    return devolucion;
end $$
/*CODIGO DE PROFESOR
delimiter $$
drop function if exists descuento $$
create function descuento(id int)
    returns int reads sql data
begin
    declare fecha date;
    declare devolucion int default 0;
    select cl.fecha_alta into fecha 
    from clientes cl 
    where cl.id=id;

if fecha is not null then 
 set devolucion= (timestampdiff(year,fecha,curdate()));
    if devolucion>10 then 
        set devolucion= 10;
    end if;
end if;
return devolucion;
end $$
delimiter ;
*/

delimiter ;

#Ejercicio 2 (3 puntos)
#Crea la función importe(id), que a partir del identificador de un pedido devuelva el importe total del mismo teniendo en cuenta la cantidad de cada producto y su precio
#por unidad. Si el pedido no existe, o se trata de un pedido sin líneas de pedido, debe  devolver 0.
delimiter $$
drop function if exists importe $$
create function importe(id int) returns double reads sql data 
begin
    declare pedido int;
    declare precio double;
	declare devolucion double;
    set pedido = (select id from pedidos p where p.id = id);
    if pedido = 0 or pedido is null then 
		set devolucion = 0;
	else
		set devolucion = (select sum(pr.precio * pp.cantidad)
						from pedidos p 
                        inner join pedidos_productos pp on p.id = pp.id_pedido
                        inner join productos pr on pp.id_producto = pr.id
                        where p.id = id);
    end if;
    if devolucion is null then
		set devolucion = 0;
	end if;
    return devolucion;
end $$

delimiter ;
/*CODIGO DE PROFESOR
delimiter $$
drop function if exists importe $$
create function importe(id int) returns double reads sql data 
begin
	declare total double;
		select ifnull(sum(pp.cantidad*pr.precio), 0)
		into total
		from pedidos_productos pp
		inner join productos pr on pp.id_producto = pr.id
		where pp.id_pedido = id;
	return total;
end $$

delimiter ;
*/

#Ejercicio 3 (5 puntos)
#Crea el procedimiento revisar_pedidos() que actualice la tabla Pedidos para informar los nuevos campos añadidos:
#• Importe: debe contener el importe total del pedido.
#• Descuento: debe contener el porcentaje de descuento aplicado al cliente.
#• Total_a_pagar: debe contener el importe total que debe pagar el cliente, descontando al importe del pedido el descuento aplicado al cliente.
delimiter $$
drop procedure if exists revisar_pedidos $$
create procedure revisar_pedidos() 
begin
    update pedidos
    set importe = importe(id),
    descuento = descuento(id_cliente),
    total_a_pagar = importe(id) - (importe(id)*(descuento(id_cliente)/100));
end $$

delimiter ;
/*CODIGO DE PROFESOR
delimiter $$
drop function if exists revisar_pedidos $$
create procedure revisar_pedidos() 
begin
	update pedidos p
    set importe = importe(id) ,
    descuento = descuento(id_cliente),
    total_a_pagar = importe - (importe * (descuento/100));
end $$

delimiter ;
*/

