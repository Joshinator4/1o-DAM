use sakila;
#1. Dirección, distrito y ciudad de todas las aquellas ciudades que comiencen por C y terminan por A. Ordena por nombre de ciudad, distrito y dirección.
select address, district, c.city 
from address a 
inner join addressaddresscity c on a.city_id = c.city_id 
where c.city like 'c%a' 
order by c.city, a.district, a.address;
#tambien se puede ordenar por numero de columna, en este caso order by 3, 2, 1;

#2. Nombre, apellido, dirección, ciudad y país de los clientes con código inferior a 10. Ordena por apellido y nombre.
select c.first_name, c.last_name, a.address, cy.city, co.country 
from customer c 
inner join address a on a.address_id = c.address_id
inner join city cy on cy.city_id = a.address_id
inner join country co on co.country_id = cy.country_id
where customer_id < 10
order by last_name, first_name;

#3. Título de la película, duración, nombre y apellido del reparto de aquellas películas que duran más de 2 horas. Ordena por película y apellido.
select title, length, first_name, last_name 
from film f 
inner join film_actor fa on f.film_id = fa.film_id 
inner join actor a on fa.actor_id = a.actor_id
where f.length > 120
order by title, last_name;

#4. Categoría, título y duración de todas las películas que duran entre 100 y 200 minutos y su categoría comienza por S. Ordena por categoría y título.
select c.name, f.title, f.length 
from film_category fc 
inner join film f on fc.film_id = f.film_id
inner join category c on fc.category_id = c.category_id
where (f.length between 100 and 200) and c.name like 'S%'
order by c.name, title;

#5. Películas en las que participa JON CHASE.
select title 
from film f 
inner join film_actor fa on fa.film_id = f.film_id
inner join actor a on a.actor_id = fa.actor_id
where a.first_name = 'JON' and a.last_name = 'CHASE';

#6. Título y categoría de las películas que duran más de 150 minutos, a excepción de las películas de acción (action) y animación (animation). Ordena por categoría y título.
select title, name
from film f
inner join film_category fc on fc.film_id = f.film_id
inner join category c on fc.category_id = c.category_id
where c.name <> 'action' and name <> 'animation' and f.length > 150
order by name, title;

#7. Título, nombre y apellido del reparto de aquellas películas con un reparto inferior a 10 actores. Ordena por película y apellido.
select f.title, a.first_name, a.last_name 
from film f
inner join film_actor fa on fa.film_id = f.film_id
inner join actor a on a.actor_id = fa.actor_id
where fa.film_id in (select film_id from film_actor group by film_id having count(*) < 10)
order by title, last_name;

#8. País y ciudad de España (Spain), Portugal (Portugal), Francia (France) e Italia (Italy). Ordena por país y ciudad.
select country, city
from country co
inner join city cy on cy.country_id = co.country_id
where co.country = 'Spain' or country = 'Portugal' or country = 'France' or country = 'Italy'
#where co.country in ('Spain', 'Portugal', 'France', 'Italy')
order by co.country, cy.city;


#9. País y ciudad de los países con al menos cinco ciudades.
select country, city
from country co
inner join city cy on cy.country_id = co.country_id
where cy.country_id in (select country_id from city group by country_id having count(*) >= 5)
order by co.country, cy.city;

#10. Las ciudades para las que no se asocia dirección (este ejercicio se hizo en el listado 2. Se puede resolver también con una composición externa de tablas).
select city 
from city c
left join address a on c.city_id = a.city_id
where address is null;

#11. Películas sin reparto. Ordena por título.
select title
from film f
left join film_actor fa on f.film_id = fa.film_id
where fa.actor_id is null
order by title;

#12. El reparto que participa en las películas “ACADEMY DINOSAUR” y “YOUTH KICK” (OJO: que participan en ambas películas).
select first_name, last_name
from actor a
inner join film_actor fa on fa.actor_id = a.actor_id
inner join film f on fa.film_id = f.film_id
where f.title = 'ACADEMY DINOSAUR'
intersect
select first_name, last_name
from actor a
inner join film_actor fa on fa.actor_id = a.actor_id
inner join film f on fa.film_id = f.film_id
where f.title = 'YOUTH KICK';


#13. El reparto de la película “PET HAUNTING” que no participa en “TIGHTS DAWN”.
select first_name, last_name
from actor a
inner join film_actor fa on fa.actor_id = a.actor_id
inner join film f on f.film_id = fa.film_id
where f.title = 'PET HAUNTING'
except
select first_name, last_name
from actor a
inner join film_actor fa on fa.actor_id = a.actor_id
inner join film f on f.film_id = fa.film_id
where f.title = 'TIGHTS DAWN';

#14. Título, duración y categoría de todas las películas donde participan los actores que participan en las películas “SUGAR WONKA” y “SPIRITED CASUALTIES” (OJO: que participan en ambas películas).
select f.title, f.length, c.name
from film f
inner join film_category fc on fc.film_id = f.film_id
inner join category c on c.category_id = fc.category_id
inner join film_actor fa on fa.film_id = f.film_id
where actor_id in(
select actor_id
from film_actor
where film_id = (select film_id from film where title = 'SUGAR WONKA')
intersect
select actor_id
from film_actor
where film_id = (select film_id from film where title = 'SPIRITED CASUALTIES')
);

#15. Nombre y apellido distintos que se encuentran en la base de datos, contando actores, clientes (customer) y personal (staff). Ordena por apellido.
select distinct a.first_name, a.last_name
from actor a
union
select distinct c.first_name, c.last_name
from customer c
union 
select distinct s.first_name, s.last_name
from staff s;


#16. Nombres comunes en la base de datos. Ordena por nombre.
select a.first_name, last_name
from actor a
intersect
select s.first_name, last_name
from staff s
intersect
select c.first_name, last_name
from customer c
order by first_name;

#17. Apellidos de actores que no aparecen ni en la tabla de clientes ni en la personal.
select last_name 
from actor a
except
select last_name 
from staff s
except
select last_name
from customer c;

#18. El reparto que participa en las películas “THIEF PELICAN” o “SWEETHEARTS SUSPECTS”.
select first_name, last_name
from actor a
inner join film_actor fa on fa.actor_id = a.actor_id
inner join film f on fa.film_id = f.film_id
where f.title = 'THIEF PELICAN'
union
select first_name, last_name
from actor a
inner join film_actor fa on fa.actor_id = a.actor_id
inner join film f on fa.film_id = f.film_id
where f.title = 'SWEETHEARTS SUSPECTS';

#19. Categoría, total de películas por categoría y duración media de las películas por categoría, de aquellas que tengan 70 o más películas. Ordena por categoría.
select c.name, count(*), avg(f.length) 
from category c
inner join film_category fc on fc.category_id = c.category_id
inner join film f on f.film_id = fc.film_id
group by c.name
having count(*) >= 70;

#20. Ciudades y países de todos los aquellos países con un código entre 10 y 20 a excepción del 13 (por si eres supersticioso). Ordena por país y ciudad.
select country, city
from country co
inner join city cy on cy.country_id = co.country_id
where co.country_id >= 10 and co.country_id <= 20
except
select country, city
from country co
inner join city cy on cy.country_id = co.country_id
where co.country_id = 13
order by country, city;

#21 BONUS TRACK para valientes: Títulos de las películas en cuyo reparto hay alguno que ha participado también en la película “ACADEMY DINOSAUR”. Ordena por título.
select p.title, p.film_id
from film p
where exists 
(select actor_id from film_actor where film_id = p.film_id
intersect
	select fa.actor_id from film_actor fa
    inner join film f on fa.film_id = f.film_id where f.film_id <> p.film_id and f.title = 'ACADEMY DINOSAUR')
order by p.title;
#esta mal