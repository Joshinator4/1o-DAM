/*
 * Escribir un programa en Java que transforme en euros la cantidad que se introduce como dato
 * en pesetas (1 euro son 166,386 pesetas) y viceversa. Primero solicitar la cantidad en euros y
 * transformarlo en pesetas mostrando el resultado por pantalla. A continuación hacer lo propio
 * pero al revés, pidiendo pesetas y pasándolo a euros.
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// declaramos funciones

		Scanner teclado = new Scanner (System.in);
		
		double importeEuros, importePesetas, valorEuros, valorPesetas;
			
		
		System.out.println("Introduzca impoprte en €: ");
		
		//damos valor a variable importeEuros con el scanner y llamamos damos a la variable valorPesetas con la operación matemática.
		
		importeEuros = teclado.nextDouble();
				
		valorPesetas = (importeEuros * 166.386);
		
		System.out.println("El valor en pesetas es: " + valorPesetas + "ptas.");
		
		System.out.println("Introduzca importe en Ptas: ");
		
		//damos valor a variable importePesetas con el scanner y llamamos damos a la variable valorEuros con la operación matemática.
		
		importePesetas = teclado.nextDouble();
		
		valorEuros = (double)(importePesetas / 166.386);
		
		System.out.println("El valor en Euros es: " + valorEuros + " €");
	}

}
