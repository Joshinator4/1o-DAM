#1. La ciudad, conferencia y división de los Knicks.
select ciudad, conferencia, division
from equipos
where nombre = 'Knicks';

#2. Las divisiones que existen ordenadas por su nombre.
select distinct division
from equipos
order by division;

#3. Las conferencias y el número de equipos por conferencia.
select conferencia, count(*)
from equipos
group by conferencia;

#4. Las conferencias que existen y el número de divisiones por conferencia.
select conferencia, count(distinct division)
from equipos
group by conferencia;


#5. Las ciudades con más de un equipo.
select ciudad 
from equipos
group by ciudad
having count(ciudad)>1;

#6. Nombre, altura y posición de los jugadores de los Bulls ordenados por nombre.
select nombre, altura, posicion
from jugadores
where Nombre_equipo = 'Bulls'
order by nombre; 

#7. Nombre, altura, equipo del jugador más alto de la NBA.
select nombre, altura, Nombre_equipo
from jugadores
where altura = (select max(altura) from jugadores);

#8. Nombre, ciudad, conferencia y división de los equipos junto con el nombre y altura del jugador o jugadores más altos de cada equipo. Ordena por equipo y nombre del jugador.
select e.nombre, e.ciudad, e.conferencia, e.division, j.nombre, j.altura
from equipos e
inner join jugadores j on e.nombre = j.Nombre_equipo
where j.altura in (select max(altura) from jugadores where Nombre_equipo = e.nombre)
order by e.Nombre, j.nombre;



#9. Equipo, ciudad y pesos medios (en Kg) de los jugadores de los equipos de la conferencia Este. Ordena por equipo y ciudad. NOTA: el peso está almacenado en libras. Para convertir libras a Kg hay que dividir
#por 2,20462.
select e.Nombre, e.ciudad, avg(j.peso/2.20462)
from equipos e
inner join jugadores j on e.Nombre = j.Nombre_equipo
where conferencia = 'east'
group by e.nombre, e.ciudad
order by e.nombre, e.ciudad;

#10. Jugador y media de estadísticas contando todas las temporadas (puntos, asistencias, rebotes, tapones) de los jugadores de los Lakers. Redondea las cifras a dos decimales. Ordena por jugador.
select j.nombre, round(avg(Puntos_por_partido), 2), round(avg(e.Asistencias_por_partido), 3), round(avg(e.Rebotes_por_partido), 2),  round(avg(e.Tapones_por_partido), 2)
from jugadores j 
inner join estadisticas e on e.jugador = j.codigo
where j.nombre_equipo = 'lakers'
group by e.jugador
order by e.jugador;

#11. Nombre, equipo, ciudad y rebotes por partido del máximo reboteador por partido de la conferencia oeste en la temporada 07/08.
select j.nombre, j.nombre_equipo, eq.ciudad, e.Rebotes_por_partido
from jugadores j
inner join estadisticas e on j.codigo = e.jugador
inner join equipos eq on j.nombre_equipo = eq.nombre
where eq.conferencia = 'west' and e.temporada = '07/08' and e.Rebotes_por_partido = 
(select max(Rebotes_por_partido) from estadisticas e
inner join jugadores j on e.jugador = j.codigo
inner join equipos eq on j.nombre_equipo = eq.nombre
where eq.conferencia = 'west' and e.temporada = '07/08');


#12. Temporada, nombre del jugador, nombre y ciudad del equipo y puntos por partido de los máximos anotadores por partido de cada temporada. Ordena por temporada.
select e.temporada, j.nombre, eq.nombre, eq.ciudad, e.puntos_por_partido
from jugadores j 
inner join estadisticas e on e.jugador = j.codigo
inner join equipos eq on j.nombre_equipo = eq.nombre
where e.Puntos_por_partido in (select max(es.puntos_por_partido) from estadisticas es where es.temporada = e.temporada)
order by e.temporada;

#13. Jugadores, equipo y ciudad de los que promedian más de 10 puntos y rebotes en la temporada 05/06. Ordena por jugador.
select j.nombre, j.nombre_equipo, eq.ciudad, e.Puntos_por_partido, e.Rebotes_por_partido
from jugadores j
inner join equipos eq on j.nombre_equipo = eq.nombre
inner join estadisticas e on e.jugador = j.codigo
where e.puntos_por_partido > 10 and e.rebotes_por_partido > 10 and e.temporada = '05/06'
group by e.jugador
order by j.nombre;
#revisar

#14. Equipo y ciudad, mínimo de puntos, máximo y promedio (jugando como local) de los equipos de la división Pacific en la temporada 03/04. Ordena por equipo.
select p.equipo_local, eq.ciudad, min(p.puntos_local), max(p.puntos_local), avg(p.puntos_local)
from partidos p
inner join equipos eq on eq.nombre = p.equipo_local 
where eq.division = 'pacific' and p.temporada = '03/04'
group by p.equipo_local
order by p.equipo_local;

#15. Temporada, nombre y ciudad de los equipos y resultado de la victoria local más abultada.
select p.temporada, eq.nombre, eq.ciudad, p.puntos_local, p.puntos_visitante, eq2.nombre, eq2.ciudad
from partidos p
inner join equipos eq on p.equipo_local = eq.nombre
inner join equipos eq2 on p.equipo_visitante = eq2.nombre
where (p.puntos_local - p.puntos_visitante) = (select max(puntos_local - puntos_visitante) from partidos);


#16. Equipo, ciudad, conferencia, división y número de victorias como local en la temporada 05/06 de todos los equipos con al menos 10 victorias. Ordena por nombre de equipo.
select eq.nombre, eq.ciudad, eq.conferencia, eq.division, count(*)
from equipos eq
inner join partidos p on eq.nombre = p.equipo_local
where (p.puntos_local > p.puntos_visitante) and p.temporada = '05/06'
group by eq.nombre
having count(*) >= 10
order by eq.nombre;


#17. Jugadores sin datos estadísticos. Ordena por nombre.
select j.nombre
from jugadores j
where j.codigo not in(select e.jugador from estadisticas e)
order by j.nombre;

#18. Las procedencias con 10 o más jugadores. Ordena por número de jugadores en orden descendente.
select procedencia, count(*)
from jugadores
group by Procedencia
having count(*) >= 10
order by procedencia desc;

#19. Equipo, ciudad, victorias locales, victorias como visitante, partidos totales jugados en la temporada 06/07. Ordena por equipo.
select eq.nombre, eq.ciudad,
(select count(*) from partidos p where p.puntos_local > p.puntos_visitante and p.temporada = '06/07' and p.equipo_local = eq.nombre) as victorias_local,
(select count(*) from partidos p where p.puntos_local < p.puntos_visitante and p.temporada = '06/07' and p.equipo_local = eq.nombre) as victorias_visitante,
(select count(*) from partidos p where p.temporada = '06/07' and p.equipo_local = eq.nombre) + (select count(*) from partidos p where p.temporada = '06/07' and p.equipo_visitante = eq.nombre) as partidos_totales
from equipos eq
order by eq.nombre;

#20. Temporada, nombre de jugador y puntos por partido de los jugadores con promedio igual o superior a la media de la temporada, para las estadísticas entre 04/05 y 07/08.
#Ordena por temporada (ascendente) y puntos por partido (descendente).
select e.temporada, j.nombre, e.Puntos_por_partido
from estadisticas e
inner join jugadores j on e.jugador = j.codigo
where (e.temporada between '04/05' and '07/08') and e.Puntos_por_partido >= (select avg(puntos_por_partido) from estadisticas es where es.temporada = e.temporada)
order by e.temporada asc, e.puntos_por_partido desc;

