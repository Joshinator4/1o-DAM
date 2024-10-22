#1. Crea una vista jugadores_españoles con el código, nombre de jugador, altura, peso, equipo, ciudad, conferencia y división de los jugadores con procedencia de España (en la base de datos se registra como “Spain”).
create or replace view jugadores_españoles (codigo, nombre, altura, peso, nombre_equipo, ciudad, conferencia, division)as
select j.codigo, j.nombre, j.altura, j.peso, j.nombre_equipo, e.ciudad, e.conferencia, e.division
from jugadores j
inner join equipos e on j.Nombre_equipo = e.nombre
where j.Procedencia = 'Spain';

#2. Crea una vista estadisticas_españoles con el nombre de jugador, temporada y estadísticas (puntos, rebotes, asistencias, tapones) de los jugadores españoles. Ordena por nombre y temporada.
create or replace view estadisticas_españoles (nombre, temporada, puntos, rebotes, asistencias, tapones)as
select j.nombre, es.temporada, es.Puntos_por_partido, es.Rebotes_por_partido, es.Asistencias_por_partido, es.Tapones_por_partido
from jugadores j 
inner join estadisticas es on j.codigo = es.jugador
where j.procedencia = 'Spain'
order by j.nombre, es.temporada;

#3. Crea una tabla palizas_05_06 con la información de los partidos de la temporada 05/06 que acabaron con una victoria local por 20 puntos o más. 
create table palizas_05_06 as
select *
#select p.codigo, p.equipo_local, p.equipo_visitante, p.puntos_local, p.puntos_visitante, p.temporada
from partidos p
where p.temporada = '05/06' and (p.puntos_local - p.puntos_visitante) >= 20;

#4. Añade a la tabla palizas_05_06 las victorias visitantes por 20 puntos o más de la temporada 05/06.
insert into palizas_05_06 
(select *
#select p.codigo, p.equipo_local, p.equipo_visitante, p.puntos_local, p.puntos_visitante, p.temporada
from partidos p
where p.temporada = '05/06' and (p.puntos_visitante - p.puntos_local) >= 20);

#5. Crea una vista contador_palizas_locales_05_06 con el nombre de cada equipo y el contador de victorias ganadas por paliza como local.
create or replace view contador_palizas_locales_05_06 (equipo_local, contador_victorias_por_paliza)as
select p.equipo_local, count(p.equipo_local)
from partidos p 
where p.temporada = '05/06' and (p.puntos_local - p.puntos_visitante) >= 20
group by p.equipo_local;


#6. Crea la vista valoraciones_lakers con el nombre de jugador, procedencia, temporada, estadísticas (puntos, rebotes, asistencias, tapones) y valoración de cada jugador de los Lakers. Ordena por nombre y temporada.
#NOTA: la valoración de un jugador es un número que valora la aportación del jugador al partido. Por cada punto, asistencia, rebote o tapón se suma un punto.
create or replace view valoraciones_lakers (nombre, procedecia, etemporada, Puntos_por_partido, Asistencias_por_partido, Tapones_por_partido, Rebotes_por_partido, valoracion)as
select j.nombre, j.procedencia, es.temporada, es.Puntos_por_partido, es.Asistencias_por_partido, es.Tapones_por_partido, es.Rebotes_por_partido,
(es.Puntos_por_partido + es.Asistencias_por_partido + es.Tapones_por_partido + es.Rebotes_por_partido)
from jugadores j
inner join estadisticas es on j.codigo = es.jugador
where j.Nombre_equipo = 'Lakers'
order by nombre, temporada;


#7. Crea la vista dobles_dobles con el nombre de jugador, equipo y promedio de las estadísticas contando todas las temporadas (puntos, rebotes, asistencias, tapones) de aquellos jugadores con doble doble.
#NOTA: un doble doble consiste en conseguir doble dígito (es decir, 10 o más) en dos estadísticas (dos de las cuatro que tenemos en la base de datos).
#AYUDA: la función if() te permite controlar qué estadística tiene doble dígito. Por ejemplo, if(puntos>=10,1,0) vale 1 si el jugador tiene 10 o más puntos y 0 si no. Si
#haces lo mismo para el resto de estadísticas y sumas las cuatro expresiones, tendrás un doble doble si obtienes un valor de 2 o superior.
create or replace view dobles_dobles (nombre, equipo, media_puntos, media_asistencias, media_tapones, media_rebotes, doble_doble)as
select j.nombre, j.nombre_equipo, avg(es.Puntos_por_partido), avg(es.Asistencias_por_partido), avg(es.Tapones_por_partido), avg(es.Rebotes_por_partido),
(if(avg(es.Puntos_por_partido)>=10,1,0) + if(avg(es.Asistencias_por_partido)>=10,1,0) + if(avg(es.Tapones_por_partido)>=10,1,0) +if(avg(es.Rebotes_por_partido)>=10,1,0))
from jugadores j
inner join estadisticas es on j.codigo = es.jugador
group by j.Nombre, j.Nombre_equipo
having (if(avg(es.Puntos_por_partido)>=10,1,0) + if(avg(es.Asistencias_por_partido)>=10,1,0) +if(avg(es.Tapones_por_partido)>=10,1,0) +if(avg(es.Rebotes_por_partido)>=10,1,0))>=2;


#8. Crea la vista puntos_equipo con el nombre del equipo, la temporada, el total de puntos que ha anotado como local en la temporada y el total como visitante. Ordena por equipo y temporada.
#AYUDA: lo mismo que se pueden sumar los valores de un campo, también se pueden sumar los resultados de un if. Es decir, se puede hacer sum(if(expresión…)) y sumar 
#para un equipo los partidos en los que ha jugado como local (lo mismo para los puntos de visitante).
create or replace view puntos_equipo (nombre_equipo, temporada, puntos_como_local, puntos_como_visitante)as
select e.nombre, p.temporada, sum(if(p.equipo_local = e.nombre, p.puntos_local, 0)), sum(if(p.equipo_visitante = e.nombre, p.puntos_visitante, 0))
from equipos e
inner join partidos p on e.nombre = p.equipo_local or e.nombre = p.equipo_visitante
group by e.nombre, p.temporada
order by e.nombre, p.temporada;

#9. Crea la vista bases con el código, nombre de jugador, procedencia, equipo y ciudad en el que juega de aquellos jugadores que juegan en el puesto de base (posición = ‘G’). Ordena por nombre de jugador.
create or replace view bases (nombre_jugador, procedencia, nombre_equipo, ciudad, posicion) as
select j.Nombre, j.procedencia, e.nombre, e.ciudad, j.posicion
from jugadores j 
inner join equipos e on j.Nombre_equipo = e.Nombre
where j.Posicion = 'G'
order by j.nombre;

#10. Crea la vista bases_jugones con el nombre de jugador, procedencia, equipo y ciudad en el que juega y promedio de puntos contando todas las temporadas de aquellos 
#jugadores que juegan en el puesto de base y anotan 10 o más puntos por partido. Ordena por jugador.
create or replace view bases_jugones (nombre_jugador, procedencia, nombre_equipo, ciudad, media_puntos) as 
select j.nombre, j.procedencia, e.nombre, e.ciudad, avg(es.Puntos_por_partido)
from jugadores j 
inner join equipos e on j.Nombre_equipo = e.Nombre
inner join estadisticas es on j.codigo = es.jugador
where j.Posicion = 'G' 
group by j.nombre, j.procedencia, e.nombre, e.ciudad
having avg(es.Puntos_por_partido)>= 10
order by j.nombre;
