/*
 * . Crea un programa que cree un array de tamaño 30 y lo rellene con valores aleatorios entre 0
y 9 (utiliza Math.random()*10). Luego ordena los valores del array y los mostrará por
pantalla.

 */
package ejercicio18;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte TAMANNO = 30;
	    // Variables de entrada
		int [] aleatorios = new int [TAMANNO];
		int aux;
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
	    	aleatorios [i] = (int)(Math.random()*10);

	    }
	    
	    Arrays.sort (aleatorios);
	    
	    for(int i = 0; i < TAMANNO; i++) {
	    	System.out.println(aleatorios[i]);
	    }
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   