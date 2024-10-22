/*
 * Crea un programa que pida veinte números reales por teclado, los almacene en un array y
luego lo recorra para calcular y mostrar la media: (suma de valores) / nº de valores. 
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
		// Constantes
	    // Variables de entrada
		final byte CANTIDAD_NUMEROS = 20;
		int [] numerosReales = new int [CANTIDAD_NUMEROS];
		int numeroIntroducido, numeroMayor, numeroMenor;
		double mediaTotal, sumaTotal;
		sumaTotal = 0; 
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
	    	    	
	    }
	    
	    for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
	    	sumaTotal += numerosReales [i]; 
	    }
	    
	    mediaTotal = sumaTotal / CANTIDAD_NUMEROS;
	    
	    
	    
	    System.out.println("La media de los números introducidos es: " + mediaTotal);
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  
