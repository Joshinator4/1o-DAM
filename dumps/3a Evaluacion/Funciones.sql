delimiter $$
drop function if exists nombre $$
create function nombre(var1 int, var2 int) returns int no sql

begin 
	declare valor1 int;
	return var1 + var2;
end $$

delimiter ;

delimiter $$
drop function if exists aleatorio_entre $$
create function aleatorio_entre(inicio int, fin int) returns int no sql not deterministic

begin 
	declare valor int;
	set valor =  inicio + rand()*fin;
    return valor;
end $$

delimiter ;