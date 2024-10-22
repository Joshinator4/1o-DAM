/*
 * Crea un programa que cree una matriz de 10x10 e introduzca los valores de las tablas de
multiplicar del 1 al 10 (cada tabla en una fila). Luego mostrará la matriz por pantalla.

 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte TAMANNO1 = 10, TAMANNO2 = 10;
	    // Variables de entrada
		int[][] multiplicar = new int [TAMANNO1][TAMANNO2];
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
				multiplicar [i][j] = (i + 1)*(j + 1);
				System.out.println("El resultado de  " + (i + 1) + " multiplicado por " + (j + 1) + " es: " + multiplicar [i][j]);
			}
		}
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   