/*Escribe un programa en Java que lea dos valores reales a y b desde teclado e intercambie esos valores
 * de a y b si el contenido de a fuera mayor que el de b. En caso contrario no se llevará a cabo el intercambio.
 */
package ejercicioCondicionalFinalDeTeoria;

import java.util.Scanner;

public class Ejercicio1CondicionalesFinalDeTeoria {

	public static void main(String[] args) {
		// Llamamos al Scanner y creamos variables.
		
		int valorA, valorB, aux;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("introduzca valor de A");
		
		valorA = teclado.nextInt();
		
		System.out.println("introduzca valor de B");
		
		valorB = teclado.nextInt();
		
		if (valorB > valorA) {
			
			aux = valorB;
			
			valorB = valorA;
			
			System.out.println("Tras el intercambio,  los valores de las variables son: A: " + aux + " B: " + valorB);
		}
		else {
			System.out.println("Los valores no han sido intercambiados. A: " + valorA + " B:" + valorB);
		}
	}

}
