/*
 * Realiza un programa Java que permita la introducción de dos números reales. Estos números representarán el radio de la circunferencia y la altura del cilindro.
 * Una vez introducidos los números por teclado, el programa calculará el volumen de dicho cilindro siguiendo la fórmula indicada y escribirá por pantalla el resultado.
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// Volumen de un cilindro: PI*r^2*h pi=Math.PI 
		
		// Traemos la función Scanner y creamos variables.
		
		Scanner teclado = new Scanner(System.in);
		
		double radio, altura, volumen;
		final Double PI;
		PI = 3.1415927;
		
		//Solicitamos el radio y la altura del cilindro al usuario.
		
		System.out.println("Introduzca el radio del cilindro en CM: ");
		
		radio = teclado.nextDouble();
		
		System.out.println("Introduzca la altura del cilindro en CM: ");
		
		altura = teclado.nextDouble();
		
		//haremos la operacion, aplicando la fórmula, para hayar el volumen. Utilizamos Math.pow para el exponente
		
		volumen = PI * Math.pow(radio, 2) * altura;
		
		System.out.println("El volumen del cilindro es: " + volumen + " CM");
		
		
	}

}
