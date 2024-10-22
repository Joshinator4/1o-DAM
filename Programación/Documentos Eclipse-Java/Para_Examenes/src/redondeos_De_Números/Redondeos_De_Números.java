/*Realizar un programa en Java que solicite al usuario un valor y lo almacene en una variable de
 * tipo double.
 * Busca información en la documentación de la API de Java sobre la clase Math. A partir de dicho
 * dato aplicarle las siguientes funciones de la clase Math y mostrar los valores por pantalla:
 *  ceil,
 *  floor,
 *  round
 * 
 */
package redondeos_De_Números;

import java.util.Scanner;

public class Redondeos_De_Números {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		
		double primerValor, valorCeil, valorFloor, valorRound;
		
		System.out.println("Introduzca un valor: ");
		
		primerValor = teclado.nextDouble();
		
		// Math.ceil Devuleve el siguiente nº entero (1,3 --> 2) 
		valorCeil = Math.ceil(primerValor);
		
		// Math.floor Devuleve el nº entero sin decimales (1,3 --> 1)
		valorFloor = Math.floor(primerValor);
		
		// Math.round Devuleve el redondeo en nº entero (1,4 --> 1 ó 1,5 --> 2)
		valorRound = Math.round(primerValor);
		
		System.out.println("el valor ceil es: " + valorCeil + " el valor floor es:" + valorFloor + " el valor round es: " + valorRound);	
		
	}

}
