/*
 * 10. Escribe un programa que calcule el área de un triángulo.
 */
package ejercicio10;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		// Area de un triangulo es (B*A)/2. Traemos la función Scanner y creamos variables
		
		Scanner teclado = new Scanner(System.in);
		
		double base, altura, areaTriangulo;
		
		// Pedimos los valores al usuario de base y altura
		
		System.out.println("Introduzca el valor de la base del rectángulo: ");
		
		base = teclado.nextDouble();
		
		System.out.println("Introduzca el valor de la altura del rectángulo: ");

		altura = teclado.nextDouble();
		
		//Realizamos la operación para calcular el área (b*a)/2 y la guardamos en su respectiva variable
		
		areaTriangulo = (double)((base * altura)/2);
		
		System.out.println("El área del rectangulo es: " + areaTriangulo);
		
	}

}
