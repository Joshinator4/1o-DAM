use sakila;
#1 Código y país de los países con código entre 1 y 10
select country_id, country from country where country_id between 1 and 10;

#2. Nombre y apellidos de los actores con nombre ADAM o apellido JONES, ordenados por apellido.
select first_name, last_name from actor where first_name = 'Adam' or last_name = 'Jones';

#3. Nombre y apellidos de los actores que no se llamen ADAM ni tengan apellido JONES, ordenado por apellido.
select first_name, last_name from actor where not (first_name = 'Adam' or last_name = 'Jones') order by last_name;
#select first_name, last_name from actor where first_name <> 'Adam' and last_name <> 'Jones' order by last_name;

#4. Códigos y ciudades españolas (este ejercicio se hizo en el listado 1 con dos consultas. Ahora hazlo con una sola consulta).
select city_id, city from city where country_id in (select country_id from country where country = 'spain');

#5. Las películas con una duración entre 100 y 200 minutos y que sean para todos los públicos (rating G).
select title from film where (length between 100 and 200) and (rating = 'G');

#6. Código del actor con nombre ED y apellido CHASE.
select actor_id from actor where first_name = 'ed' and last_name = 'chase';

#7. Nombre y apellidos de los actores cuyo apellido comienza por A, ordenados por apellidos, luego por nombre.
select first_name, last_name from actor where last_name like 'a%' order by last_name, first_name;
#select first_name, last_name from actor where left(last_name, 1) = 'a' order by last_name, first_name;

#8. Nombre y apellidos de los actores cuyo apellido termina por G y nombre comienza por N.
select first_name, last_name from actor where last_name like '%g' and first_name like 'n%';
#select first_name, last_name from actor where right(last_name, 1) = 'g' and left(first_name, 1) = 'n';

#9. Nombre y apellidos de los actores cuyo apellido tiene en la tercera posición la letra H.
select first_name, last_name from actor where last_name like '__h%';
#select first_name, last_name from actor where substr(last_name, 3, 1) = 'h';

#10. La fecha actual y diez días después a la fecha actual
select curdate(), adddate(curdate(), 10);
#select curdate(), curdate()+10;
#select curdate(), date(curdate()+10);

#11. Las tres primeras letras del nombre y las tres últimas del apellido de cada actor, ordenados por apellido, luego por nombre.
select left(first_name, 3), right(last_name, 3) from actor order by last_name, first_name;

#12. Las letras en posición 2, 3 y 4 del nombre de cada actor
select substr(first_name, 2,3) from actor; #(por ejemplo, si un actor se llama MANUEL, la consulta debe devolver ANU).

#13. Nombre y apellidos de los actores con apellido PECK o ADAM.
select first_name, last_name from actor where last_name = 'peck' or last_name = 'adam';
#select first_name, last_name from actor where last_name in ('peck', 'adam');

#14. Nombre de la película con más duración.
select title from film where length = (select max(length) from film);

#15. Duración media de las películas, agrupadas por su clasificación (rating).
select avg(length) from film group by rating;

#16. Número de películas, agrupadas por su clasificación (rating) excepto las clasificadas como R.
select count(*) from film group by rating having rating <> 'r'; # tambien se puede hacer--> select count(*) from film where rating <> 'r' group by rating;

#17. Las direcciones de España, ordenadas por distrito, luego por dirección (este ejercicio se hizo en el listado 1 con varias consultas. Ahora hazlo con una sola consulta).
select address from address where city_id in (select city_id from city where country_id in (select country_id from country where country = 'spain')) order by district, address;

#18. Las películas con un título de 10 o más caracteres, ordenadas por la longitud del título.
select title from film where length(title) >= 10 order by length(title);

#19. Las ciudades para las que no se asocia dirección.
select city from city where not exists (select city_id from address where city_id = city.city_id);
#select city from city where city_id not in (select city_id from address);--> esta seria otra posibilidad
#select city from city where (select count(*) from address where city_id = city.city_id) = 0;

#20. El código de cliente y la media de pagos de cada cliente, agrupado por cliente y teniendo en cuenta únicamente los clientes que pagan por encima de la media total de pagos. Ordena el resultado por la media.
select customer_id, avg(amount) from payment group by customer_id having avg(amount) >= (select avg(amount) from payment) order by avg(amount);