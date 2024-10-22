/*
 * Crea un programa que pida diez números reales por teclado, los almacene en un array, y
luego muestre la suma de todos los valores.

 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		final byte cantidadNumeros = 10;
		int [] numerosReales = new int [cantidadNumeros];
		int numeroIntroducido, numeroTotal;
		numeroTotal = 0;
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
	    
	    for (int i = 0; i < cantidadNumeros; i++) {
	    	System.out.println("Introduzca el numero " + (i + 1) + ": ");
	    	numeroIntroducido = teclado.nextInt();
	    	numerosReales [i] = numeroIntroducido;
	    	numeroTotal += numerosReales [i];
	    }
	    
	    System.out.println("La suma de todos los valores introducidos es: " + numeroTotal);
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  