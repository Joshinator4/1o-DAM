
/*
 * Escribe un programa que cree un array de tamaño 50 con los números naturales comprendidos
entre 50 y 99. Luego muestra la suma total y la media. Implementa una función que calcule la
suma de un array y otra que calcule la media de un array.

 */
package ejemplo_Suma_y_Media_de_un_Array;

import java.util.Scanner;

public class Ejemplo_Suma_y_Media_de_un_Array {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte TAMANNO_ARRAY = 50;
	    // Variables de entrada
		int [] numeros = new int [TAMANNO_ARRAY];
		int contador = 50;
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
	    
	    for (int i = 0; i < TAMANNO_ARRAY; i++) {
	    		numeros [i] = contador;
	    	contador++;
	    }
	    
	   System.out.println("La suma total de los numeros del array es: " + sumaDelArray(numeros, TAMANNO_ARRAY));
	   
	   System.out.println("La media de los numeros del array es: " + mediaDelArray(sumaDelArray(numeros, TAMANNO_ARRAY),TAMANNO_ARRAY));
	}
	
	
	public static int sumaDelArray (int [] x, int y) {
		int sumaTotal=0;
		for(int i = 0; i < y; i++) {
			sumaTotal += x[i];
		}
		return sumaTotal;
	}
	
	public static double mediaDelArray (int x, int y) {
		double media = (double)x / y ;
		return media;
		
	}
}