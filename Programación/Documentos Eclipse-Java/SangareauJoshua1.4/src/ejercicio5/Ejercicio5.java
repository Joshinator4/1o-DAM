/*Realiza un programa en Java que solicite dos números al usuario y calcule lo siguiente:
 * Qué número es menor, y lo muestre por pantalla. método: Math.min()
 * El valor del primer número elevado al segundo y lo muestre por pantalla. método Math.pow()
 * La raíz cuadrada del primer número y la muestre por pantalla. Método Math.sqrt()
 * Un valor aleatorio (random) del segundo número y lo muestre por pantalla.
 * <Para realizar algunos de estos apartados, tendrás que buscar en la documentación de la API de
 * Java la función correspondiente. 
 */
package ejercicio5;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		// Llamamos al Scanner y declaramos la variables
		
		Scanner teclado = new Scanner(System.in);
		
		double numeroA, numeroB, numeroElevado, numeroMenor, raizCuadrada, numeroAleatorio;
		
		System.out.println("Introduzca el valor de A: ");
		
		numeroA = teclado.nextDouble();
		
		System.out.println("Introduzca el valor de B: ");
		
		numeroB = teclado.nextDouble();
		
		// se puede hacer con if pero este ejercicio esta hecho para hacer con metodo math
		//if (numeroA>numeroB)	{
		//	System.out.println("el nº más pequeño es: "+ numeroB);
		//}else {
		//	System.out.println("el nº mas pequeño es: " + numeroA);
		//}
		
		
		//Los métodos estan apuntados al final de cada frase en el comentario del principio.
		numeroMenor = Math.min(numeroA, numeroB);
		
		System.out.println("el nº que es menor es: " + numeroMenor);
		
		numeroElevado = Math.pow(numeroA, numeroB);
		
		System.out.println("el valor del primer núero elevado al segundo es: " + numeroElevado);
		
		raizCuadrada = Math.sqrt(numeroA);
		
		System.out.println("el valor de la raíz cuadrada del primer nº es: " + raizCuadrada);
		
		//Math.Random da valores desde el 0,0 hasta el 1,0. Para ponerle que genere el número que queramos hay q ponerle (*"el numero que queramos o variable que hayamos creado")
		// ejemplo como el de abajo Math.Random()*numeroB
		
		numeroAleatorio = Math.random()*numeroB;
		
		System.out.println("Ul valor aleatorio del segundo nº es: " + numeroAleatorio);

	}

}
