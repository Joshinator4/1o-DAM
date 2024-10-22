
/*1*/ select first_name, last_name 
from actor
limit 10;

/*2*/ select distinct first_name
from actor
order by first_name asc;

/*3*/ select distinct last_name
from actor
order by last_name desc;

/*4*/ select distinct first_name, last_name
from actor
order by last_name, first_name;


/*5*/ select first_name, last_name
from actor
where first_name = 'angela';

/*6*/  select actor_id, first_name, last_name
from actor
where first_name = 'ADAM'
order by actor_id desc;

/*7*/ select country_id
from country
where country = 'spain';

/*8*/ select city_id, city
from city 
where country_id = 87;

/*9*/ select *
from customer
where last_name = 'jones';

/*10*/ select name
from language
where language_id >= 3;

/*11*/ select title, release_year
from film
where language_id = 1;

/*12*/ select title, length
from film
where length < 120;

/*13*/ select actor_id
from actor
where first_name = 'antonio' and last_name = 'banderas';

/*14*/ select address
from address
where postal_code < 10000;

/*15*/ select address 
from address
where address_id = 10;

/*16*/ select address, postal_code
from address
where postal_code is not null and postal_code <> ''
order by postal_code asc;

/*17*/ select address
from address
where phone is null /*<>''*/
order by district;

/*18*/ select title
from film
where rating = 'G';

/*19*/ select address
from address
where city_id = (1, 146, 181, 388, 459)
order by district, address;

/*20*/ select actor_id
from film_actor
where film_id = 6