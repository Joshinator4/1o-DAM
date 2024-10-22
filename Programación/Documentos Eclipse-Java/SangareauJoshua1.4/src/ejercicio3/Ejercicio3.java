/*Realizar un programa en Java que dadas dos variables a y b cuyos valores se pedirán al
 * usuario, intercambie los valores de a y b, y los muestre por pantalla.
 * Nota: las variables tienen que cambiar de valor
 * 
 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
		
		double a, b, aux;
		
		System.out.println("introduzca valor de la variable a: ");
		
		a = teclado.nextDouble();
		
		System.out.println("introduzca valor de la variable b: ");
		
		b = teclado.nextDouble();
		
		aux = a;
		a = b;
		b = aux;
		
		System.out.println("El valor de la variable a es: " + a + " el valor de la variable b es: " + b);

	}

}
