/*
 * Implementa un programa que pida dos valores int A y B utilizando un nextInt() (de Scanner),
calcule A/B y muestre el resultado por pantalla. Se deberán tratar de forma independiente
las dos posibles excepciones, InputMismatchException y ArithmeticException, mostrando
en cada caso un mensaje de error diferente en cada caso.

 */
package ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// ----------------------------------------------
		// Declaración de variables
		// ----------------------------------------------

		// Constantes
		// Variables de entrada
		int valorIntroducido1 = 0, valorIntroducido2 = 0;
		double division;
		boolean banderaCorrecto = false;

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
			try {
				System.out.println("Introduzca un valor entero A:");
				valorIntroducido1 = teclado.nextInt();
				System.out.println("Introduzca otro valor entero B:");
				valorIntroducido2 = teclado.nextInt();
				banderaCorrecto = true;

			} catch (InputMismatchException excepcion1) {
				System.out.println("Valor introducido incorrecto");
				excepcion1.printStackTrace();
				banderaCorrecto = false;
				teclado.nextLine();
			}
		
			try {
				division = valorIntroducido1 / valorIntroducido2;
				banderaCorrecto = true;
				System.out.println(division);

			} catch (ArithmeticException excepcion2) {
				System.out.println("Hay un error de calculo");
				excepcion2.printStackTrace();
				banderaCorrecto = false;
				teclado.nextLine();
				
			}catch(Exception excepcion3) {
				banderaCorrecto = false;
				teclado.nextLine();
				excepcion3.printStackTrace();
			}
		} while (banderaCorrecto == false);
	}
}