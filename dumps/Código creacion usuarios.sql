use ejercicio_biblioteca;
create user Socio identified by 'password';
grant select on ejemplares to Socio;
grant select on productos to Socio;
grant select on autores to Socio;
grant select on socios to Socio;
grant update (nombre, apellido1, apellido2, direccion, email, telefono, fecha_nacimiento) on socios to Socio;
grant select, update, insert, drop on preferencias to Socio;
set password for Socio = 'contraseñasocio';
create user Bibliotecario identified by 'contraseñabibliotecario';
grant select, insert, update, drop on * to Bibliotecario;
create user Gestor identified by 'contraseñagestor';
grant select, insert, update, drop on * to Gestor with grant option;


