/*Ejercicios de entrada/salida.
 * 1. Escribir un programa en Java que pregunte ¿Cómo te llamas?, lea el nombre que
 * introduces por teclado, por ejemplo Alberto y escriba en pantalla Hola Alberto.
 */
package ejercicioEntradaSalida1;

import java.util.Scanner;

public class EjercicioEntradaSalida1 {

	public static void main(String[] args) {
		// TODO Llamamos al Scanner y creamos variables.
		
		String nombre;
		
		Scanner teclado = new Scanner(System.in);
		
		//Ejercicio 1:
		
		System.out.println("Introduce tu nombre: ");
		
		nombre = teclado.nextLine();
		
		System.out.println("Hola " + nombre);
		
		
	}

}
