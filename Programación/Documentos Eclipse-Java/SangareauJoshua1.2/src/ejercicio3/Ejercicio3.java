/*
 * Realizaremos un programa que realice los siguientes pasos:
 * Crea dos variables de tipo int, num1 y num2, inicializa ambas variables a 0.
 * Crea dos variables de tipo double, val1 y val2, no las inicialices.
 * Crea dos variables de tipo String nombre y apellidos, inicialízalas con tu nombre y apellido.
 * Muestra por pantalla el valor de las variables num1 y num2 con un texto que lo acompañe.
 * Asigna un valor cualquiera acorde a su tipo a val1 y val2.
 * Muestra por pantalla el siguiente mensaje, haciendo uso de las variables nombre y apellido.
 * Mi nombre es (-------------) y mis apellidos (-----------------)
 */

package ejercicio3;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		// Crearemos las variables:
		
		
		int num1, num2;
		num1 = 0;
		num2 = 0;
		
		double val1, val2;
		
		String nombre, apellidos;
		nombre = "Joshua";
		apellidos = "Sangareau Quesada";
		
		// Imprimiremos en pantalla lo requerido:
	
		System.out.println("este es el valor de num1: " + num1);
		System.out.println("este es el valor de num2: " + num2);
		
		// Asignaremos un valor a val1 y val2 acorde a su tipo
		
		val1 = 37.52986;
		val2 = 10578.856795;
		
		//Mostraremos mensaje en pantalla de nombre y apellido
		
		System.out.println("mi nombre es: " + nombre + " y mis apellidos son: " + apellidos);
		
		
		
		

	}

}
