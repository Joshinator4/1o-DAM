/*Realizar un programa en Java que solicite al usuario los siguientes datos:
 * Edad
 * El usuario quiere acceder a unos estudios para los que se requiere ser mayor de edad.
 * Comprobaremos la edad y en caso de ser menor de 18 años mostraremos el siguiente
 * mensaje: No tiene la edad requerida para realizar estos estudios.
 * En caso de cumplir el requisito de edad se le solicitarán los siguientes datos:
 *  Nombre
 *  Apellidos
 *  Fecha de Nacimiento
 * Una vez recopilados se le mostrará el siguiente mensaje:
 * Nombre: Juan
 * Apellidos: López Pérez
 * Edad: 25
 * Usted ha sido admitido 
 */
package condicionales;

// Se han importado estos paquetes de java por necesidad del calculo de las fechas
//import java.time.format.DateTimeFormatter; para añadir el formato deseado de fecha. con DateTimeFormatter.ofPattern("dd/MM/yyyy")
//import java.time.LocalDate; para introducir el fecha generada por el usuario en el formato ya generado e introducir la fecha actual con 
//LocalDate.parse(fechaNacimiento, formatoFecha); y LocalDate.now(); respectivamente.
//import java.time.Period; para comparar las fechas y generar el tiempo transcurrido entre una y ota con tiempoTranscurrido = Period.between(fechaNac2, fechaActual);
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class IF_Formato_Fecha_Calcular_Edad_Con_Fecha_Nacimiento {
	
	public static void main(String[] args) {
		// Llamamos al Scanner y creamos variables.
		
		byte edad;
		String nombre, apellidos, fechaNacimiento;
		
		Scanner teclado = new Scanner(System.in);
		
		//Pedimos la edad
		
		System.out.println("Introduzca su edad: ");
		
		edad = teclado.nextByte();
		
		//Limpiamos Scanner 
		
		teclado.nextLine();
		
		//creamos condición para si tiene menos de 18 años no es admitido y si tien 18 o más será admitido y se le presentara el mesaje solicitado
		
		if (edad>=18) {
			
			//pedimos datos a usuario e introducimos en respectivas variables
			System.out.println("Introduzca su nombre: ");
		
			nombre = teclado.nextLine();
		
			System.out.println("Introduzca sus apellidos: ");
		
			apellidos = teclado.nextLine();
		
			System.out.println("Introduzca su fecha de nacimiento en formato dd/mm/yyyy: ");
		
			fechaNacimiento = teclado.nextLine();
			
			//generamos una variable de tipo DateTimeFormatter para despues darle la funcion DateTimeFormatter.ofPattern("dd/MM/yyyy") y crear el formato 
			//deseado de introdución de fecha de nacimiento, en mi  caso dd/MM/yyyy. MUY IMPORTANTE sea la MM en mayúsculas y los años con yyyy
			
			DateTimeFormatter formatoFecha;
			
			formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			//generamos variable de tipo LocalDate para guaradar o añadir la fecha introducida por el usuario en el formato anteriormente realizado
			//con la función LocalDate.parse(fechaNacimiento, formatoFecha)
			
			LocalDate fechaNac2;
			
			fechaNac2 = LocalDate.parse(fechaNacimiento, formatoFecha);
			
			//generamos otra variable de tipo LocalDate para añadirle la fecha actual con función LocalDate.now()
			
			LocalDate fechaActual;
			
			fechaActual = LocalDate.now();
			
			//Generamos variable de tipo Period para guardar el tiempo transcurrido entre la variable LocalDate fechaActual (LocalDate.now) anteriormente realizada,
			//y la fecha de nacimiento ya en el formato generado por DateTimeFormatter.ofPattern("dd/MM/yyyy"):
			//compara ambas fechas y saca resultado, con la función Period.between(fechaNac2, fechaActual);
			
			Period tiempoTranscurrido;
			
			tiempoTranscurrido = Period.between(fechaNac2, fechaActual);
			//Imprimimos por pantalla lo que solicita el ejercicio.
			
			System.out.println("Nombre: " + nombre);
			System.out.println("Apellidos: " + apellidos);
			System.out.println("Fecha de nacimiento: " + fechaNacimiento);
			
			//Usamos printf para imprimir el formato ya realizado anteriormente, se escribe texto y "%s" para cada uno de los datos
			//al terminar el texto que se desea imprimir, poner los argumentos (en este caso los años, meses y dias transcurridos) 
			//con las funciones (variable).getYears(), (variable).getMonths(), (variable).getDays()
			
			System.out.printf("Tu edad es: %s años, %s meses y %s días" + "\n",
					tiempoTranscurrido.getYears(), tiempoTranscurrido.getMonths(), tiempoTranscurrido.getDays());
			System.out.println("Usted ha sido admitido");
		
		}
		//Generamos else por si no se cumple la condición anteriormente generada con if, salga el mensaje deseado
		else {
			System.out.println("No tiene la edad requerida para realizar estos estudios.");
		}
		
		
		
	}	
}
