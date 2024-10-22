/*
 * Crea un programa que cree un array de enteros e introduzca la siguiente secuencia de
valores: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc. hasta introducir 10 diez veces, y luego la
muestre por pantalla. En esta ocasión has de utilizar Arrays.fill().

 */
package ejercicio16;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte TAMANNO = 55;
	    // Variables de entrada
		int[] secuenciaValores = new int [TAMANNO];
		int contador = 0;
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
	    
	    
	    for (int i = 1; i <= 10; i++) {
	    	for(int j = 1 ; j <= i;j++) {
	    		Arrays.fill(secuenciaValores, i);
	    		System.out.println("El valor en la posición " + contador + " es: " + i);
	    		contador++;
	    	}
	    	
	    }
	   
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   