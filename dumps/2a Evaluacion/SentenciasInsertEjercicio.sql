use inserciones;

insert into socios (nif, nombre, apellido1, direccion, telefono, fecha_nacimiento, fecha_alta) 
values ('DNI1', 'nombre1', 'apellido1', 'direccion1', 'telefono1', '1992-08-22', '2023-12-20'),
('DNI2', 'nombre2', 'apellido2', 'direccion2', 'telefono2', '1992-08-22', '2023-12-20'),
('DNI3', 'nombre3', 'apellido3', 'direccion3', 'telefono3', '1992-08-22', '2023-12-20'),
('DNI4', 'nombre4', 'apellido4', 'direccion4', 'telefono4', '1992-08-22', '2023-12-20'),
('DNI5', 'nombre5', 'apellido5', 'direccion5', 'telefono5', '1992-08-22', '2023-12-20');

insert into empresas (empresa_id, cif, nombre, sede)
values ('0', 'cif1', 'nombre1', '1'),
('0', 'cif2', 'nombre2', '2'),
('0', 'cif3', 'nombre3', '3'),
('0', 'cif4', 'nombre4', '4'),
('0', 'cif5', 'nombre5', '5');

insert into contactos (contacto_id, nombre, apellido1, direccion, telefono, empresa_id)
values('0', 'nombre1', 'apellido1', 'direccion1', 'telefono1', '1'),
('0', 'nombre2', 'apellido2', 'direccion2', 'telefono2', '2'),
('0', 'nombre3', 'apellido3', 'direccion3', 'telefono3', '3'),
('0', 'nombre4', 'apellido4', 'direccion4', 'telefono4', '4'),
('0', 'nombre5', 'apellido5', 'direccion5', 'telefono5', '5');

insert into libros (libro_id, titulo, fecha_publicacion, paginas, empresa_id)
values ('0', 'titulo1', '2022-8-10', '200', '1'),
('0', 'titulo2', '2022-8-10', '200', '2'),
('0', 'titulo3', '2022-8-10', '200', '3'),
('0', 'titulo4', '2022-8-10', '200', '4'),
('0', 'titulo5', '2022-8-10', '200', '5');

insert into ejemplares (signatura, fecha_adquisicion, estanteria, balda, precio, libro_id)
values ('1', '2022-8-10', '1', '1', '23.99', 1),
('2', '2022-8-10', '3', '3', '23.99', 2),
('3', '2022-8-10', '2', '2', '23.99', 3),
('4', '2022-8-10', '4', '4', '23.99', 4),
('5', '2022-8-10', '5', '5', '23.99', 5);

insert into prestamos (ejemplar, socio, fecha_prestamo)
values ('1', 'DNI1', '2022-8-10'),
('2', 'DNI2', '2022-8-10'),
('3', 'DNI3', '2022-8-10'),
('4', 'DNI4', '2022-8-10'),
('5', 'DNI5', '2022-8-10');

insert into preferencias (socio, autor_id)
values('DNI1', '2'),
('DNI2', '1'),
('DNI3', '5');

insert into creadores (libro_id, autor_id)
values ('1', '2'),
('1', '3'),
('2', '1'),
('3', '5'),
('4', '4'),
('5', '3');

insert into nacionalidades (autor_id, pais_id)
values ('1', '2'),
('1', '3'),
('2', '1'),
('3', '4'),
('4', '5'),
('5', '3');