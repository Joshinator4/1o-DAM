/*
 * Crea un programa que cree dos arrays de enteros de tamaño 100. Luego introducirá en el
primer array todos los valores del 1 al 100. Por último, deberá copiar todos los valores del
primer array al segundo array en orden inverso, y mostrar ambos por pantalla.
 */
package ejercicio11;

import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte TAMANNO = 100;
	    // Variables de entrada
		int [] primerosNumeros = new int [TAMANNO];
		int [] segundosNumeros = new int [TAMANNO];
		int j = 0;
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
	    
	    for (int i = 0; i < TAMANNO; i++) {
	    	primerosNumeros [i] = 1 + i;
	    	
	    	System.out.println("El numero de la posicion " + i + " del primer array es: " + primerosNumeros [i]);
	    }
	    
	    for (int i = 99; i >= 0; i--) {
	    	segundosNumeros [i] = primerosNumeros [j];
	    	
	    	j++;
	    	System.out.println("El numero de la posicion " + i + " del segundo array es: " + segundosNumeros [i]);
	    }
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   