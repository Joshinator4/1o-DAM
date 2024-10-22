/* Pedimos la hora en numero enteros (ej: 15H), día y mes de la hora (ej: 23 de octubre), pedimos el año (ej: 1989) y pedimos nombre de quien lo realiza (Ej: marcos)
 * Sacar por pantalla todos ellos en lineas diferentes, con un mismo Syso
 */

package scanner;

import java.util.Scanner;

public class EjercicioScanner1 {
	
	public static void main(String[] args) {
	
	Scanner teclado = new Scanner (System.in);
	
//Nombramos las variables	
	
	String hora;
	String diames;
	short year;
	String nombre;
	
//Solicitamos datos al usuario

	System.out.println("Introduzca la hora: ");

//Asignamos la variable a teclado con su método correspondiente
	
	hora = teclado.nextLine();
	
	System.out.println("Introduzca dia y mes: ");
	
	diames = teclado.nextLine();
	
	System.out.println("Introduzca el año: ");
	
	year = teclado.nextShort();

//Limpiamos Scanner (por venir de una variable numérica)
	
	teclado.nextLine();
	
	System.out.println("Introduzca su nombre: ");
	
	nombre = teclado.nextLine();
	
	System.out.println("Estos son los datos introucidos: " + "\n" + "Hora: " + hora  + "\n" + "Día y mes: " + diames + "\n" + "Año: " + year +"\n" + "Datos introducidos por: " + nombre);
	
	}

}
