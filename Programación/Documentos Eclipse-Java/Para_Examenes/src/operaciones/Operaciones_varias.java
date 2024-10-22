/*Realiza un programa Java que permita la introducción de tres números enteros. El programa realizará los cálculos necesarios para determinar:

un tercio del primer número más la mitad del tercer número.
el cuadrado de la mitad de la suma del segundo número más el tercero.
si el triple de la suma del segundo más el tercer número menos el primero es par.
la suma del primero más el segundo, multiplicado por la diferencia del tercero menos el primero y todo ello partido por el segundo número.

Para realizar estas comprobaciones dispones de operadores relacionales tales como igual (==), menor que (<), mayor que (>), etc.
 Ten en cuenta que el resultado de la aplicación de operadores relacionales será un valor de tipo boolean, es decir un valor que será true o false.

Recuerda también que puedes obtener el resto de una división entera entre dos números utilizando el operador módulo (%).
 Este operador también te puede ayudar para determinar si un número es divisible entre otro (si el resultado de la división a%b es igual a 0, significará que a es divisible entre b).
 * 
 */
package operaciones;

import java.util.Scanner;

public class Operaciones_varias {

	public static void main(String[] args) {
		//Traemos la función Scanner y creamos variables.
		
		Scanner teclado = new Scanner(System.in);
		
		int numero1, numero2, numero3;
		double operacion1, operacion2, operacion3, operacion4, operacion6, operacion7;
		boolean operacion5;
		
		//Solicitamos al usuario los 3 números al usuario
		
		System.out.println("Introduzca el primer nº: ");
		
		numero1 = teclado.nextInt();
		
		System.out.println("Introduzca el segundo nº: ");
		
		numero2 = teclado.nextInt();
		
		System.out.println("Introduzca el tercer nº: ");
		
		numero3 = teclado.nextInt();
		
		//realizamos cálculos. en operacion1 convertir a double el resultado de las divisiones
		//operacion2 convertir a double el resultado de la division entera.
		//operacion 3 usar Math.pow para exponente
		//operacion 5 asignarla a variable boolean
		//operacion 6 
		
		operacion1 = (double)1/3 * numero1 + numero3 * (double)1/2;
		
		operacion2 = (double)(numero2 + numero3)/2;
		
		//Math.pow es para elevar un nº o variable a un exponente
		
		operacion3 = Math.pow(operacion2, 2);
		
		operacion4 = 3 * (numero2 + numero3 - numero1);
		
		//Para saber si el nº es par realizamos operación5 ( si operación5 lo hemos creado en variable boolean, el resultado será true o false)
		
		operacion5 = (operacion4 % 2 == 0);
		
		operacion6 = (numero1 + numero2) * (numero3 - numero1);
		
		operacion7 = (double)(operacion6/numero2);
		
		System.out.println("resultados");
		
		System.out.println(operacion1);
		
		System.out.println(operacion3);
		
		System.out.println(operacion5);
		
		System.out.println("Valor de la suma del primero más el segundo, multiplicado por la diferencia del tercero menos el primero y todo ello partido por el segundo número: " + operacion7);
	}

}
