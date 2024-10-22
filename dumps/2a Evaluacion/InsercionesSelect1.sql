#1. Crea una tabla equipos_south e incluye nombre, ciudad y conferencia de los equipos cuya división empieza por south.
create table equipos_south as 
select nombre, ciudad, conferencia 
from equipos 
where division like'south%';

#2. Crea una tabla equipos_backup con toda la información de la tabla equipos, pero cambiando la información de la división según la siguiente tabla: 
#DIVISIÓN  SE CAMBIA POR  la información de la división según la siguiente tabla:
#Atlantic 		1
#SouthEast 		2
#Central		3
#Pacific 		4
#SouthWest 		5
#NorthWest 		6
create table equipos_backup as 
select nombre, ciudad, conferencia, 
CASE Division when 'Atlantic' then 1 when 'SouthEast' then 2 when 'Central' then 3 when 'Pacific' then 4 when 'SouthWest' then 5 when 'NorthWest' then 6 END as division
from equipos;

#3. Crea una tabla plantilla_cleveland con el nombre y procedencia de los jugadores de Cleveland.
create table plantilla_cleveland as
select nombre, procedencia 
from jugadores 
where Nombre_equipo = 'Cavaliers';

#4. Crea la tabla resumen_temporada con la temporada y las medias de puntos, rebotes, asistencias y tapones de la temporada “00/01”.
create table resumen_temporada as
select temporada, avg(Puntos_por_partido) as puntos, avg(Asistencias_por_partido) as asistencias, avg(Tapones_por_partido) as tapones, avg(Rebotes_por_partido)  as rebotes
from estadisticas es
where es.temporada = '00/01';


#5. Crea la tabla gigantes con el nombre de jugador, nombre y ciudad del equipo de aquellos jugadores que miden 6 pies y 10 pulgadas o más (aproximadamente 2.08 metros o más).
create table gigantes as
select j.nombre as nombre_jugador, e.nombre as nombre_equipo, e.ciudad as ciudad_equipo
from jugadores j
inner join equipos e on j.Nombre_equipo = e.nombre
where j.altura >= '6-10';

#6. Añade en la tabla resumen_temporada las medias de todas las temporadas excepto la “00/01”.
insert into resumen_temporada (temporada, puntos, asistencias, tapones, rebotes)
select temporada, avg(Puntos_por_partido), avg(Asistencias_por_partido), avg(Tapones_por_partido), avg(Rebotes_por_partido)
from estadisticas es
where es.temporada <> '00/01'
group by temporada;
#having es.temporada <> '00/01'

#7. Añade también en la tabla gigantes la información de los jugadores entre 6 pies y 7 pulgadas y 6 pies y 10 pulgadas (los jugadores con 6-10 ya se insertaron en el ejercicio 5, no deben insertarse de nuevo).
insert into gigantes (nombre_jugador, nombre_equipo, ciudad_equipo)
select j.nombre as nombre_jugador, e.nombre as nombre_equipo, e.ciudad as ciudad_equipo
from jugadores j
inner join equipos e on j.Nombre_equipo = e.nombre
where j.altura between '6-7' and '6-9' ;

#8. Crea una vista gordos con el nombre y peso de los jugadores que pesen más de 100 Kg (Recuerda que la base de datos guarda la información en libras y para convertir a Kg hay que dividir por 2,20462).
create or replace view gordos (nombre, peso) as
select j.nombre, j.peso/2.20462 
from jugadores j
where j.peso/2.20462 > 100; 

#9. Añade a la vista gordos el jugador Sofoklis Schortsanitis con un peso de 196 Kg.
#No se puede insertar en la vista Ya que no contiene el campo obligatorio codigo y porque no se puede insertar datos en campos modificados(en este caso el peso, ya que se convierten pulgadas en KG)
#Se prodria insertar directamente en la base de datos nba
insert into jugadores (nombre, peso, codigo) values ('Sofoklis Schortsanitis', (196*2.20462), '614'); 


#10. Crea la vista anotadores_06_07 con el nombre y puntos por partido de aquellos jugadores que promediaron 10 o más puntos por partido.
create or replace view anotadores_06_07 (nombre, puntos_por_partido) as
select j.nombre, es.Puntos_por_partido
from jugadores j
inner join estadisticas es on j.codigo = es.jugador
where es.puntos_por_partido >= 10 and temporada = '06/07';


#11. Crea la vista jugadores_oeste con el nombre, equipo y posición de los jugadores de equipos de la conferencia oeste. La posición debe mostrarse del siguiente modo:
#   POSICIÓN   SE CAMBIA POR
#     G             Base
#   F-G o G-F     Escolta
#     F            Alero
#   C-F o F-C    Ala-pívot
#     C             Pívot

create or replace view jugadores_oeste (nombre, equipo, posicion) as
select j.nombre, j.nombre_equipo,
case j.posicion when 'G' then 'Base' when 'F-G' then 'Escolta'when 'G-F' then 'Escolta' when 'F' then 'Alero' when 'C-F' then 'Ala-pívot' when 'F-C' then 'Ala-pívot' when 'C' then 'Pívot' else 'Error'end  
from jugadores j
inner join equipos eq on j.Nombre_equipo = eq.Nombre
where eq.conferencia = 'West';
#se puede usar tambien
#case
#		when posicion = 'G' then 'Base' 
#		when posicion = 'F-G' then 'Escolta'
#		when posicion = 'G-F' then 'Escolta' 
#		when posicion = 'F' then 'Alero' 
#		when posicion = 'C-F' then 'Ala-pívot'
#		when posicion = 'F-C' then 'Ala-pívot' 
#		when posicion = 'C' then 'Pívot' 
#		else 'Error'
#end


#12. Crea la vista estadisticas_05_06 con el nombre, equipo y estadísticas por partido de todos los jugadores en la temporada “05/06”. Si hay alguna estadística sin informar 
#debe aparecer el mensaje “Sin datos” en lugar de NULL.
create or replace view estadisticas_05_06 (nombre, equipo, Puntos_por_partido ,Asistencias_por_partido, Tapones_por_partido,Rebotes_por_partido) as
select j.nombre, j.nombre_equipo, if(e.Puntos_por_partido = 0, 'Sin datos', e.Puntos_por_partido), if(e.Asistencias_por_partido = 0,'Sin datos', e.Asistencias_por_partido),
if(e.Tapones_por_partido = 0,'Sin datos', e.Tapones_por_partido), if(e.Rebotes_por_partido = 0, 'Sin datos', e.Rebotes_por_partido)
from jugadores j
inner join estadisticas e on j.codigo = e.jugador
where e.temporada = '05/06';


#13. Crea la vista victorias_locales_07_08 con los nombres de equipos, ciudades de los equipos y puntuación de los equipos de aquellos partidos de la temporada “07/08” con victoria local.
create or replace view victorias_locales_07_08 (nombre_equipo_local, ciudad_local, puntos_local, nombre_equipo_visitante, ciudad_visitante, puntos_visitante) as
select p.equipo_local, e.ciudad, p.puntos_local, p.equipo_visitante, eq.ciudad, p.puntos_visitante
from equipos e
inner join partidos p on e.Nombre = p.equipo_local
inner join equipos eq on p.equipo_visitante = eq.nombre
where p.temporada = '07/08' and p.puntos_local > p.puntos_visitante;

#14. Crea la vista paquetes con los nombres de los jugadores que han promediado menos de 5 puntos por partido contando todas las temporadas.
create or replace view paquetes (nombre, puntos_por_partido_media) as
select j.nombre, avg(e.Puntos_por_partido)
from jugadores j
inner join estadisticas e on j.codigo = e.jugador
group by e.jugador
having avg(puntos_por_partido)<5;


#15. Crea la vista mvp con el jugador, equipo, ciudad y puntos por partido del máximo anotador por temporada.
create or replace view mvp (nombre, nombre_equipo, ciudad, puntos_por_partido, temporada) as
select j.nombre, eq.nombre, eq.ciudad, es.Puntos_por_partido, es.temporada
from jugadores j
inner join equipos eq on eq.nombre = j.Nombre_equipo
inner join estadisticas es on j.codigo = es.jugador
where es.Puntos_por_partido >= all (select Puntos_por_partido from estadisticas es2 where es2.temporada = es.temporada); -- Esta opcion es más rapida que utilizando in
#where es.Puntos_por_partido in (select max(Puntos_por_partido) from estadisticas es2 where es2.temporada = es.temporada);


