/*
 * Crea un programa que pida diez números reales por teclado, los almacene en un array, y
luego lo recorra para averiguar el máximo y mínimo y mostrarlos por pantalla.
 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		final byte CANTIDAD_NUMEROS = 10;
		int [] numerosReales = new int [CANTIDAD_NUMEROS];
		int numeroIntroducido, numeroMayor, numeroMenor;
		
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
	    
	    numeroMayor = numerosReales [0];
	    numeroMenor = numerosReales [0];
	    
	    for (int i = 1; i < CANTIDAD_NUMEROS; i++) {
	    	
	    	if (numerosReales [i] > numeroMayor) {
	    		numeroMayor = numerosReales [i];
	    		
	    	}
	    	
	    	if (numerosReales [i] < numeroMenor) {
	    		numeroMenor = numerosReales [i];
	    	}
	    }
	       
	    
	    System.out.println("El número menor es: " + numeroMenor + " y el mayor es: " + numeroMayor);
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  