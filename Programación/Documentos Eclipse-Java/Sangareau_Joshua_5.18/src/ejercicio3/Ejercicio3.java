/*
 * 3. Implementa un programa que cree un vector tipo double de tamaño 5 y luego, utilizando un
bucle, pida cinco valores por teclado y los introduzca en el vector. Tendrás que manejar la/las
posibles excepciones y seguir pidiendo valores hasta rellenar completamente el vector.

 */
package ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// ----------------------------------------------
		// Declaración de variables
		// ----------------------------------------------

		// Constantes
		final byte TAMANHO = 5;
		boolean banderaCorrecto = false;
		// Variables de entrada
		double[] valores = new double[TAMANHO];
		// Variables de salida
		// Variables auxiliares
		// Clase Scanner para petición de datos

		Scanner teclado = new Scanner(System.in);

		// ----------------------------------------------
		// Procesamiento
		// ----------------------------------------------
		
		for (int i = 0; i < TAMANHO; i++) {
			try {
				System.out.println("Introduzca el campo " + i);
				valores[i] = teclado.nextDouble();

			} catch (InputMismatchException excepcion1) {
				System.out.println("Se ha introducido un valor incorrecto. Introduzcalo de nuevo de forma correcta");
				teclado.nextLine();
				i--;
				excepcion1.printStackTrace();
				
			}catch(Exception excepcion2) {
				System.out.println("Se ha producido algún error. Vuelva a introducir el valor de forma correcta");
				teclado.nextLine();
				i--;
				excepcion2.printStackTrace();
			}
		}

	}
}
