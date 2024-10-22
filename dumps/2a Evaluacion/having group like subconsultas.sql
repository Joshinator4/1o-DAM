#use sakila;
#select first_name, left (first_name, 4), right (first_name, 3), substr(first_name, 3, 2)
#from sakila.actor;

#substr(first_name, 1,3) substr sirve para coger fragmentos del string, en este caso coge desde la 1ª posicion hasta la 3ª
#left(first_name, 3) left sirve para coger los caracteres desde la izquierda
#right(first_name, 3) left sirve para coger los caracteres desde la derecha
#is es para comparar null o is not null

#select curdate(), adddate(curdate(), 10), curdate()+10

#select * FROM sakila.actor where first_name = 'adam' or first_name = 'nick' or first_name = 'jennifer';

#select * FROM sakila.actor where first_name in ('adam', 'nick', 'jennifer'); in se utiliza para agrupaciones

#select * FROM sakila.actor where first_name not in ('adam', 'nick', 'jennifer')

#select * FROM sakila.film where length >= 50 and length <=100;

#select * FROM sakila.film where length between 50 and 100;

#select * FROM sakila.film where length not between 50 and 100;

#select first_name, last_name from actor where first_name like; '%ni%' %significa cualquier cantidad antes de ni
#select first_name, last_name from actor where first_name like; '_ni%' _ significa 1 caracter antes de ni
#select first_name, last_name from actor where first_name not like; '%a%' 

#select count(*) from actor;  sirve para contar los actores en este caso
#select count(*) from actor where first_name = 'adam';
#select count(*) count(address) count(address2) from sakila.address; cuenta la cantidad de campos que hay 

#select sum(length), min(length), max(length), avg(length) from sakila.film; sum() hace la suma, min es ell minimo, max es el max, avg es el promedio o la media.alter

#select city_id, count(*) from sakila.address group by city_id; group by agrupa por columna

#select city_id, count(*) from sakila.address group by city_id having count(*) > 1; having filtra en los grupos
#select city_id, count(*) from sakila.address group by city_id having count(*) > 1 and city_id > 100;

#SUBCONSULTAS

#select * from sakila.address where city_id in(select city_id from city where city like 'a%')

#select title from sakila.film where length = (select min(length) from sakila.film) and title like 'a%';

#select * from sakila.country where exists (select * from city where country.country_id = country_id);
#select * from sakila.country where not exists (select * from city where country.country_id = country_id);

#select title, length from fil where length >= (select max (length) from sakila.film where rating = 'R');

#select title, length from film where length >= ANY (SELECT length from sakila.film where rating = 'NC-17');
