/*
 * 9. Escribe un programa que calcule el área de un rectángulo.
 */
package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		// Area de un rectangulo es (B*A). Traemos la función Scanner y creamos variables
		
		Scanner teclado = new Scanner(System.in);
		
		double base, altura, areaRectangulo;
		
		// Pedimos los valores al usuario de base y altura
		
		System.out.println("Introduzca el valor de la base del rectángulo: ");
		
		base = teclado.nextDouble();
		
		System.out.println("Introduzca el valor de la altura del rectángulo: ");

		altura = teclado.nextDouble();
		
		//Realizamos la operación para calcular el área (b*a) y la guardamos en su respectiva variable
		
		areaRectangulo = (base * altura);
		
		System.out.println("El área del rectangulo es: " + areaRectangulo);
		
	}

}
