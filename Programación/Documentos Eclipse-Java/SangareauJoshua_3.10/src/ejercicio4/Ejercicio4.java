/*
 * Crea un programa que pida veinte números enteros por teclado, los almacene en un array y
luego muestre por separado la suma de todos los valores positivos y negativos.
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		// Constantes
	    // Variables de entrada
		final byte CANTIDAD_NUMEROS = 20;
		int [] numerosReales = new int [CANTIDAD_NUMEROS];
		int numeroIntroducido, numeroMayor, numeroMenor, sumaNegativos, sumaPositivos;
		sumaNegativos = 0; 
		sumaPositivos = 0;
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
	    
	    for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
	    	System.out.println("Introduzca el numero " + (i + 1) + ": ");
	    	numeroIntroducido = teclado.nextInt();
	    	numerosReales [i] = numeroIntroducido;
	    	
	    	if (numeroIntroducido < 0) {
	    		sumaNegativos += numeroIntroducido;
	    		
	    	} else {
	    		sumaPositivos += numeroIntroducido;
	    	}
	    	    	
	    }
	    
	    System.out.println("La suma de los números negativos es: " + sumaNegativos + " y la de los positivos es: " + sumaPositivos);
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  
