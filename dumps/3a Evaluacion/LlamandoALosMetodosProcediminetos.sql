call escribir_log('asdasdasd', 'asdasfasf', 'asfsfgdfgdfg');

call mover_libros_balda(1, 1, 5, 3, @movimientos);
select @movimientos;

call mover_libros_balda(11, 5, 1, 1, @movimientos);
select @movimientos;

call localizar_ejemplar(1, @estanteria, @balda);
select @estanteria, @balda;

call localizar_ejemplar(200, @estanteria, @balda);
select @estanteria, @balda;

call libro_mas_leido(@titulo, @autor);
select @titulo, @autor;

call autor_mas_leido(@autor, @prestamos1);
select @autor, @prestamos1;

call calcular_cumpleaños();

call proximo_cumpleaños(date(now()), @fecha_cumpleanhos, @socio, @edad);
select @fecha_cumpleanhos, @socio, @edad;

call mover_historico(15);

call borrar_historico_prestamos(curdate(), @prestamos);
select @prestamos;