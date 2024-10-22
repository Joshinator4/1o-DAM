create database cuentas_corrientes;
use cuentas_corrientes;
create table clientes (
dni varchar(9),
nombre varchar(20),
telefono varchar(20),
direccion varchar(100),
primary key (dni) 
);

create table cuentas (
numero_cuenta int auto_increment,
dni_cliente varchar(9),
situacion varchar(20),
saldo double,
primary key(numero_cuenta),
foreign key (dni_cliente) references clientes (dni) on delete restrict on update cascade
);

create table movimientos (
numero_cuenta int,
importe double,
fecha_hora datetime,
tipo varchar(30),
cuenta_transferida int,
concepto varchar(50),
foreign key (numero_cuenta) references cuentas (numero_cuenta) on delete cascade on update cascade
);