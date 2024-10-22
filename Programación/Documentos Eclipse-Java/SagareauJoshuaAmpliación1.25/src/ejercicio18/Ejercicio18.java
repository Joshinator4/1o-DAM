/*18. Una empresa de transporte por carretera ha adquirido vehículos nuevos que viajan más
 * rápido que los antiguos. Les gustaría conocer cómo afectará esto a la duración de los
 * viajes. Supóngase que la reducción media que se consigue del tiempo total de viaje es del 15%.
 * Escribir un programa en Java que lea el horario de salida y llegada antiguo, calcule el
 * nuevo horario de llegada y muestre en pantalla el nuevo tiempo de viaje y la nueva hora
 * de llegada.
 * Nota: Las horas se dan en el formato hhmm, un entero. Por ejemplo las 11:30, sería el
 * entero 1130.
 * DateFormat formatoOrigen = new SimpleDateFormat("HHmmss.00");
 * DateFormat formatoDestino = new SimpleDateFormat("HH:mm:ss");
 * Date fecha = formatoOrigen.parse("090230.00");
 * String fechaFormato = formatoDestino.format(fecha);
 * System.out.println(fechaFormato);
 */
package ejercicio18;

import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		// Traemos la función Scanner y creamos variables. Declaramos MEJORA como constante y la inicializamos a 0.15 (15%)
		
		Scanner teclado = new Scanner(System.in);
				
		final double MEJORA = 0.15;
		int horaSalidaA, horaLlegadaA, horaSalidaN, resultado;
		double hora, reduccionHora, horasMenos, aux, horaLlegadaN;
		
		//Solicitamos al usuario horario de salida y llegada antiguo.
		
		System.out.println("Introduzca hora de salida antigua en formato hhmm: ");
		
		horaSalidaA = teclado.nextInt();
		
		System.out.println("Introduzca hora de llegada antigua en formato hhmm: ");
		
		horaLlegadaA = teclado.nextInt();
		
		resultado = (horaLlegadaA - horaSalidaA);
		
		hora = (double)resultado/100*60;
		
		reduccionHora = (hora * MEJORA);
		
		horasMenos = (hora - reduccionHora);
		
		aux = horasMenos / 60 * 100;
		
		horaLlegadaN = (int)(horaLlegadaA - aux);
		
		System.out.println("Nueva hora de llegada: " + horaLlegadaN + "\n" + "Nuevo tiempo de viaje: " + horasMenos);
	}

}
