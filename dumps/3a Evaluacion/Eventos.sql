show variables where variable_name like 'event%'; # esto sirve para saber si la base de datos procesa eventos
show processlist; #muestra los procesos por realizar
show events; #muestra los procesos que se lanzarán cuando llegue su momento

delimiter $$ 
drop event if exists evento1 $$
create event evento1
	on schedule at current_timestamp do           #este evento saltará ahora mismo  AT es para darle un momneto determinado se lanzará solo 1 vez<----------------------------------
begin
	call escribir_log('evento1', 'ejemplo1', null);
end $$
delimiter ;


delimiter $$ 
drop event if exists evento2 $$
create event evento2
	on schedule at current_timestamp + interval 1 minute do                    #este evento saltará dentro de 1 minuto AT es para darle un momneto determinado se lanzará solo 1 vez<<--------------------------------------------------
begin
	call escribir_log('evento2', 'ejemplo2', null);
end $$
delimiter ;

delimiter $$ 
drop event if exists evento3 $$
create event evento3
	on schedule at '2024-05-14 17:41' do               #este evento saltará el 14 de mayo de 2024 a las 17:41 AT es para darle un momneto determinado se lanzará solo 1 vez<<--------------------------------------------------
begin
	call escribir_log('evento3', 'ejemplo3', null);
end $$
delimiter ;

delimiter $$ 
drop event if exists evento4 $$
create event evento4
	on schedule every 15 second do                #este evento se lanzara cada 15 segundos. ES un evento recurente no se borrar al ejecutarlo <--------------------------------------------------
begin
	call escribir_log('evento4', 'ejemplo4', null);
end $$
delimiter ;

delimiter $$ 
drop event if exists evento5 $$
create event evento5
	on schedule every 15 second
    starts current_timestamp
    ends current_timestamp + interval 2 minute do             #este evento se lanzara cada 15 segundos, empezando ahora y terminando en 2 minutos. ES un evento recurente no se borrar al ejecutarlo <--------------------------
begin
	call escribir_log('evento5', 'ejemplo5', null);
end $$
delimiter ;
alter event evento1 disable; #esto es para desactivar el evento 
alter event evento2 disable; #esto es para desactivar el evento 
alter event evento3 disable; #esto es para desactivar el evento 
alter event evento4 disable; #esto es para desactivar el evento 
alter event evento5 disable; #esto es para desactivar el evento 
alter event evento1 enable; #esto es para activar el evento 
alter event evento2 enable; #esto es para activar el evento 
alter event evento3 enable; #esto es para activar el evento 
alter event evento4 enable; #esto es para activar el evento 
alter event evento5 enable; #esto es para activar el evento 
