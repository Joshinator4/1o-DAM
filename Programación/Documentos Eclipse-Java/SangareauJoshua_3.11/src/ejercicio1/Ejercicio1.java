/*
 * Crea un programa que cree una matriz de tamaño 5x5 que almacene los números del 1 al 25
y luego muestre la matriz por pantalla.

 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte TAMANNO1 = 5, TAMANNO2 = 5;
	    // Variables de entrada
		int [][]bidimensional = new int [TAMANNO1][TAMANNO2];
		int contador = 1;
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
	    
	    for (int i = 0; i < TAMANNO1; i++) {
	    	for (int j = 0; j < TAMANNO2; j++) {
	    		bidimensional[i][j] = contador;
	    		contador++;
	    		//Usamos print y fuera del bucle interior println para hacer que salga en forma de tabla en la consola
	    		System.out.print( bidimensional[i][j] + " ");
	    	}
	    	System.out.println();
	    }
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   