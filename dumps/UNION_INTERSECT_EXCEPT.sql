select actor_id, first_name from actor union select category_id, name from category;

select country_id, country from country where country like 'a%' union select country_id, country from country where country like 'b%' order by 2;

select country_id, country from country where country like 'a%' union all select country_id, country from country where country like '%a' order by 2;

select country_id, country from country where country like 'a%' intersect select country_id, country from country where country like '%a' order by 2;

select country_id, country from country where country like 'a%' except select country_id, country from country where country like '%a' order by 2;

select country_id, country from country where country like 'a%'
except
(
select country_id, country from country where country like '%a'
union
select country_id, country from country where country like '%b'
)
 order by 2;