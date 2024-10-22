/*Se deberá realizar un programa que realice los siguientes pasos:
 * Crea dos variables de tipo int, num1 y num2, inicializa ambas variables a 1.
 * Crea dos variables de tipo char, car1 y car2, asígnales cualquier valor.
 * Crea dos variables de tipo String cargo y nombre, inicializa ambas con tus datos. (El cargo lo puedes inventar)
 * Muestra por pantalla el valor de las variables num1 y num2 con un texto que lo acompañe.
 * Asigna el valor 15 a la variable num1. Asigna el valor 20 a la variable num2. Vuelve a mostrar el valor de dichas variables.
 * Muestra por consola el valor de las variables car1 y car2 con un texto que lo acompañe.
 * Muestra por pantalla el siguiente mensaje, haciendo uso de las variables nombre y cargo:
 * 
 * Bienvenido, <cargo> <nombre>.
 * Ejemplo: Bienvenido, capitán Gómez,
 * donde “capitán” es el cargo y “Gómez” es el nombre. 
 */

package ejericio3;

public class Ejercicio3 {

	public static void main(String[] args) {
		// Crearemos las variables y las inicializamos como solicita el ejercicio:
		
		int num1, num2;
		char car1, car2;
		String cargo, nombre;
		
		num1 = 1;
		num2 = 1;
		
		car1 = 'f';
		car2 = 'b';
		
		nombre = "Joshua";
		cargo = "empleado";
		
		System.out.println("Estos son los valores de las variables num1: " + num1 + " y num2: " + num2);
		
		num1 = 15;
		num2 = 20;
		
		System.out.println("Estos son los nuevos valores de las variables num1: " + num1 + " y num2: " + num2);
		
		System.out.println("Estos son los valores de las variables car1: " + car1 + " y car2: " + car2);
		
		
		System.out.println("Bienvenido, " + cargo + " " + nombre);
		
		

	}

}
