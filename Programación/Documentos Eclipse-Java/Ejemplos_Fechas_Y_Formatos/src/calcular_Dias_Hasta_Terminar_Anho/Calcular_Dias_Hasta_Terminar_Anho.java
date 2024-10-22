package calcular_Dias_Hasta_Terminar_Anho;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Calcular_Dias_Hasta_Terminar_Anho {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//LocalDate hoy = LocalDate.now();
		
		//System.out.println(hoy);
		
		//LocalDate finalAnho = LocalDate.of(2024,01,01);
		
		//Period cantidadDias = Period.between(hoy, finalAnho);
		
		//System.out.println(cantidadDias);
		
		LocalDateTime hoy = LocalDateTime.now();
		
		LocalDate fecha = LocalDate.of(2024, 01, 01);
		
        LocalTime hora = LocalTime.of(0,0,0,0);
		
		LocalDateTime finalAnho = LocalDateTime.of(fecha, hora);
		
		long cantidadHoras = ChronoUnit.HOURS.between(hoy, finalAnho);
		
		System.out.println(cantidadHoras);
	}

}
