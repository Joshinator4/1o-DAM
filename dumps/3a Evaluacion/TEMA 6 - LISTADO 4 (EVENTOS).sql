#Crea una tabla Eventos con la siguiente estructura (en negrita los campos obligatorios):
#NOMBRE 	TIPO 		DESCRIPCIÓN
#Id 		INT 		PK
#Instante 	TIMESTAMP 	Instante en el que se inserta el comentario.
#						Valor por defecto: el instante actual.
#Evento 	INT 		Número de evento que escribe en la tabla. Se
#						corresponde con el número de ejercicio.
#Valor 		INT 		Dato que almacena el evento en la tabla.
create table eventos (
id int auto_increment,
instante timestamp default current_timestamp,
 evento int,
 valor int,
 primary key (id)
)

#1. Crea evento1 que se ejecute una vez en el momento y registre el año actual.
delimiter $$ 
drop event if exists evento1 $$
create event evento1 
	on schedule at current_timestamp do        
begin
	insert into eventos ( evento, valor)
    values (1, year(curdate()));
end $$
delimiter ;

#2. Crea evento2 que se ejecute una vez dentro de un minuto y registre el mes actual.
delimiter $$ 
drop event if exists evento2 $$
create event evento2 
	on schedule at current_timestamp + interval 1 minute do        
begin
	insert into eventos (instante, evento, valor)
    values (2, month(curdate()));
end $$
delimiter ;


#3. Crea evento3 que se ejecute de forma periódica cada 15 minutos y registre un número aleatorio entre 1 y 10.000.
delimiter $$ 
drop event if exists evento3 $$
create event evento3
	on schedule every 15 minute do        
begin
	insert into eventos (instante, evento, valor)
    values (3, floor(1 + (rand()*10000)));
end $$
delimiter ;

#4. Crea evento4 que se ejecute de forma periódica. Debe activarse un minuto después de crearse y finalizar a los cinco minutos. Cada 30 segundos debe registrar un número
#aleatorio entre -1 y -10.000.
delimiter $$ 
drop event if exists evento4 $$
create event evento4
	on schedule every 30 second
    starts current_timestamp + interval 1 minute
    ends current_timestamp + interval 5 minute 
    do        
begin
	insert into eventos (evento, valor)
    values (4, floor((rand()*-10000)-1));# tambien se puede hacer (-1)*floor(1 + (rand()*10000))
end $$
delimiter ;


#5. Crea evento5 que se ejecute de forma periódica cada diez minutos y borre de la tabla historico_prestamos aquellos préstamos con una antigüedad superior a cinco años.
#En la tabla Eventos deben guardarse los registros borrados.
delimiter $$ 
drop event if exists evento5 $$
create event evento5
	on schedule every 10 minute do        
begin
	insert into eventos (evento, valor)
    values (5, (select count(*) from historico_prestamos where timestampdiff(year, fecha_prestamo, curdate())>5));
    delete from historico_prestamos
    where timestampdiff(year, fecha_prestamo, curdate())>5;
end $$
delimiter ;
alter event evento5 disable;
alter event evento4 disable;