/*
 * Escribe un programa que cree un array del tamaño indicado por teclado y luego lo rellene con
valores aleatorios (utiliza Math.random()). Implementa la función que rellena un array con
valores aleatorios.

 */
package ejercicio16;

import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {

		// ----------------------------------------------
		// Declaración de variables
		// ----------------------------------------------

		// Constantes
		final int TAMANNO_ARRAY;
		// Variables de entrada
		// Variables de salida
		// Variables auxiliares
		// Clase Scanner para petición de datos

		Scanner teclado = new Scanner(System.in);

		// ----------------------------------------------
		// Entrada de datos
		// ----------------------------------------------
		
		System.out.println("Introduzca un valor que será el tamaño del array: ");
		TAMANNO_ARRAY = teclado.nextInt();
		
		int[] valoresAleatorios = new int [TAMANNO_ARRAY];
		
		rellenarArrayNumerosAleatorios(valoresAleatorios, TAMANNO_ARRAY);
		for (int i = 0 ; i < TAMANNO_ARRAY; i++) {
			System.out.println(valoresAleatorios[i]);
		}
		// ----------------------------------------------
		// Procesamiento
		// ----------------------------------------------
		

	}
	
	public static void rellenarArrayNumerosAleatorios(int [] x, int y) {
		for(int i = 0; i < y; i++) {
			x [i] = (int)(Math.random()*100);
		}
	}
	
	
}