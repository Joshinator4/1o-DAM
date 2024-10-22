/*
 * 13. Realiza un conversor de Mb a Kb.
 */
package ejercicio13;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		// Traemos la función Scanner y creamos variables.
		
		Scanner teclado = new Scanner(System.in);

		double megaB, kiloB, resultadoKB;
		
		//Solicitamos los megabytes
		
		System.out.println("Introduzca los Megabytes a convertir: ");
		
		megaB = teclado.nextDouble();
		
		//Realizamos la operación para la conversión
		
		resultadoKB = (megaB * 1000);
		
		//Mostramos en pantalla la solución
		
		System.out.println(megaB + " MegaBytes son: " + resultadoKB + " KiloBytes");
		
		
	}

}
