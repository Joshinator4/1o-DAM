DROP TABLE IF EXISTS Disponible_en ;
DROP TABLE IF EXISTS Plataformas ;
DROP TABLE IF EXISTS Peliculas ;

--
-- Estructura de las tablas
--
create database gestion_peliculas;
use gestion_peliculas;

create table peliculas(
codigo int,
titulo varchar(100),
sinopsis varchar(200),
fEstreno date,
primary key (codigo)
);

create table plataformas(
codigo int,
nombre varchar(50),
urlLogotipo varchar(200),
primary key (codigo)
);

create table disponible_en(
codPelicula int,
codPlataforma int,
fDisponibilidad date,
primary key(codPelicula, codPlataforma, fDisponibilidad),
foreign key (codPelicula) references peliculas (codigo),
foreign key (codPlataforma) references plataformas (codigo)
);

