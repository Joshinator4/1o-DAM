/*
 * Ejercicio 1
 * Realizar un programa en Java que solicite al usuario dos números, num1 y num2.
 *  Comprobar si num1 es mayor que num2, si es al revés o si son iguales.
 *  Mostrar por pantalla al usuario un mensaje informando del resultado
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// Llamamos al Scanner y creamos variables.
		
		Scanner teclado = new Scanner(System.in);
		
		int num1, num2;
		
		System.out.println("Introduzca el primer nº: ");
		
		num1 = teclado.nextInt();
		
		System.out.println("Introduzca el segundo nº: ");
		
		num2 = teclado.nextInt();
		
		//creamos la condicion if con num1 mayor que num2 
		
		if (num1>num2) {
			System.out.println("el primer nº es mayor que el segundo");
		}
		// Hacemos un else if para que se cumpla una 2ª condición 
		else if(num1==num2){
			System.out.println("el primer nº es igual al segundo nº");
			}
		//Por ultimo hacemos un else por si no se cumple ninguna de las 2 condiciones
		else {
			System.out.println("el primer nº es menor que el segundo");
		}
		

	}

}
