/*
 * Necesitamos crear un programa para mostrar el ranking de puntuaciones de un torneo de
ajedrez con 8 jugadores. Se le pedirá al usuario que introduzca las puntuaciones de todos los
jugadores (habitualmente valores entre 1000 y 2800, de tipo entero) y luego muestre las
puntuaciones en orden descendente (de la más alta a la más baja).
 */
package ejercicio19;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    final byte JUGADORES = 8;
		// Variables de entrada
		int [] puntuaciones = new int [JUGADORES];
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    for (int i = 0; i < JUGADORES; i++) {
	    	System.out.println("Introduzca la puntuación de cada jugador " );
	    	puntuaciones [i] = teclado.nextInt();
	    }
	    
	    Arrays.sort(puntuaciones);
	    
	    for (int i = (JUGADORES-1); i >= 0; i--) {
	    	System.out.println("La puntuación del jugador " + i + " es: " + puntuaciones[i]);
	    
	    }
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   