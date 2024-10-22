create table personas(
nif char(9),
nombre varchar(40) not null,
apellidos varchar(40),
primary key (nif)
);
create index idx_nombre on personas (nombre);
alter table personas modify apellidos varchar(50);
create table prodcutos(
id_producto int auto_increment not null,
descripcion varchar(50) not null,
precio decimal(5, 2) not null,
tipo int default '1' not null,
primary key (id_producto)
);
create index idx_precio on productos (precio asc);
create user examen identified by 'contraseña';
grant  select, insert, update on * to examen