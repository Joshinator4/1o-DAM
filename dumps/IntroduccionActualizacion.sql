update tabla set
campo1 = valor1,
campo2 = valor2,
campo3 = null
#...
where;

use examen_ud5;

update  clientes set -- nombre de la tabla -- 
telefono = '600600600'
where nombre = 'Ozzy';
#(da error)si queremos usar esto, desactivar el entorno seguro. edit-preferences-sqlEditor-abajo del todo la casilla(safe updates....)

update  clientes set
telefono = '600600600'
where id = 5;
#esto si lo deja lanzar debido a que se usa la clave primaria de la tabla


#En una actualizacion, la subconsulta en where no puede hacer referencia a la misma tabla a la que esta actualizando 