/*
 * 1. Implementa un programa que pida al usuario un valor entero A utilizando un nextInt() (de
Scanner) y luego muestre por pantalla el mensaje “Valor introducido: …”. Se deberá tratar la
excepción InputMismatchException que lanza nextInt() cuando no se introduce un entero
válido. En tal caso se mostrará el mensaje “Valor introducido incorrecto”.
 */
package ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// ----------------------------------------------
		// Declaración de variables
		// ----------------------------------------------

		// Constantes
		// Variables de entrada
		int valorIntroducido;
		boolean banderaCorrecto;
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
				System.out.println("Introduzca un valor entero");
				valorIntroducido = teclado.nextInt();
				System.out.println("Valor introducido correcto: " + valorIntroducido);
				banderaCorrecto = true;

			} catch (InputMismatchException excepcion1) {
				System.out.println("Valor introducido incorrecto");
				excepcion1.printStackTrace();
				banderaCorrecto = false;
				teclado.nextLine();

			}
		} while (banderaCorrecto == false);

	}
}