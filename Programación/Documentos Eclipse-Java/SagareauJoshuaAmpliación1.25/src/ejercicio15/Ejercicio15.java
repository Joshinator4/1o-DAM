/*15. Escribir un programa en Java que transforme una temperatura en grados Fahrenheit a
 * grados Celsius (Info: 0ºC==32F y c=(F-32)/1.8) 
 */
package ejercicio15;

import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		// Traemos la función Scanner y creamos variables.
		
		Scanner teclado = new Scanner(System.in);

		double gradosF, resultadoC;
		
		//Solicitamos grados Fahrenheit al usuarioy se lo asignamos a su variable correspondiente
		
			System.out.println("Introduzca los grados Fahrenheit: ");
			
			gradosF = teclado.nextDouble();
			
		// Realizaremos el cáluclo
			
			resultadoC = ((gradosF-32)/1.8);
			
		//Imprimiremos por pantalla el resultado en ºC (grados Celsius)
			
			System.out.println("El resultado en grados Celsius es:" + resultadoC +"ºC");
				

	}

}
