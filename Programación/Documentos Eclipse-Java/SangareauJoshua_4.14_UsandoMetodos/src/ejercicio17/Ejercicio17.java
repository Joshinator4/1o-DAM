/*
 * Realiza un programa que nos pida número enteros hasta que se introduzca el 0, diciéndonos,
para cada número introducido si es primo o no. Hay que recordar que un número es primo si es
divisible por si mismo y por 1. El 1 no es primo por convenio. Se debe crear una función que
pasándole un número entero devuelva si es primo o no.
 */
package ejercicio17;

import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		// ----------------------------------------------
		// Declaración de variables
		// ----------------------------------------------

		// Constantes
		// Variables de entrada
		int numeroIntroducido;
		// Variables de salida
		// Variables auxiliares
		// Clase Scanner para petición de datos

		Scanner teclado = new Scanner(System.in);

		// ----------------------------------------------
		// Entrada de datos
		// ----------------------------------------------

		// ----------------------------------------------
		// Procesamiento
		// ----------------------------------------------

		do {
			System.out.println("Introuzca un numero para saber si es primo o no: ");
			numeroIntroducido = teclado.nextInt();

			if ((esPrimo(numeroIntroducido) == true || numeroIntroducido == 2) && numeroIntroducido != 0) {
				System.out.println("El numero introducido es primo");
				
			}else if(numeroIntroducido == 0) {
				
			}else {
				System.out.println("El numero no es primo");
			}
		} while (numeroIntroducido != 0);

	}

	public static boolean esPrimo(int x) {
		boolean primo = true;
		for (int i = 2; i < x; i++) {
			if (x % i == 0) {
				primo = false;
			} 
		}
		return primo;

	}
}