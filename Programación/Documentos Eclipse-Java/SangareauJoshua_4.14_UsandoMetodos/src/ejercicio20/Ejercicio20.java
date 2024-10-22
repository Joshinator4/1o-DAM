/*
 * 20. Escribe un programa que imprima las tablas de multiplicar del 1 al 10. Implementa una función
que reciba un número entero como parámetro e imprima su tabla de multiplicar.

 */
package ejercicio20;

import java.util.Scanner;

public class Ejercicio20 {

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
		for(int i = 1; i <= 10; i++) {
			System.out.println("La tabla de multiplicar del " + i + " es: ");
			for(int j = 1; j <= 10; j++) {
				System.out.println(i + "x" + j + "=" + (i*j));
			}
		}
		
		System.out.println("Introduzca un número para imprimir su tabla de multiplicar: ");
		numeroIntroducido = teclado.nextInt();
		
		imprimirTablaMultiplicar(numeroIntroducido);
	}
	
	
	public static void imprimirTablaMultiplicar (int x) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(x + " multiplicado por " + i + " = " + x*i);
		}
	}
}
