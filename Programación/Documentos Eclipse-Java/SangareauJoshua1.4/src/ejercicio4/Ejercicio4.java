/*Realizar un programa en Java que solicite al usuario un valor y lo almacene en una variable de
 * tipo double.
 * Busca información en la documentación de la API de Java sobre la clase Math. A partir de dicho
 * dato aplicarle las siguientes funciones de la clase Math y mostrar los valores por pantalla:
 *  ceil,
 *  floor,
 *  round
 * 
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		
		double primerValor, valorCeil, valorFloor, valorRound;
		
		System.out.println("Introduzca un valor: ");
		
		primerValor = teclado.nextDouble();
		
		valorCeil = Math.ceil(primerValor);
		
		valorFloor = Math.floor(primerValor);
		
		valorRound = Math.round(primerValor);
		
		System.out.println("el valor ceil es: " + valorCeil + " el valor floor es:" + valorFloor + " el valor round es: " + valorRound);	
		
	}

}
