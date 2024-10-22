package mostrar_Horas_y_minutos_con_fecha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Mostrar_Horas_y_minutos_con_fecha {

	public static void main(String[] args) {


		LocalDateTime ahora = LocalDateTime.now();
		LocalDate fechaCumpleanhos = LocalDate.of(1992, 8, 22);
		
		System.out.println(ahora);
	
		DateTimeFormatter salidaPorPantalla = DateTimeFormatter.ofPattern("'Son las' HH ':' mm 'del dia' dd 'del mes' MM 'del año' yyyy");
		System.out.println(ahora.format(salidaPorPantalla));
		
		
		long cantidadDias = fechaCumpleanhos.until(ahora, ChronoUnit.DAYS);
		System.out.println(cantidadDias+ " dias");
		
		long cantidadSemanas = fechaCumpleanhos.until(ahora, ChronoUnit.WEEKS);
		System.out.println(cantidadSemanas+ " semanas");
		
		long cantidadMeses = fechaCumpleanhos.until(ahora, ChronoUnit.MONTHS);
		System.out.println(cantidadMeses+ " meses");
		
		long cantidadAnhos = fechaCumpleanhos.until(ahora, ChronoUnit.YEARS);
		System.out.println(cantidadAnhos+ " años");
	}

}
