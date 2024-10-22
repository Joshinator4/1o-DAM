/*
 * 1. Crea un programa que pida diez números reales por teclado, los almacene en un array, y
luego muestre todos sus valores.

 */
package ejercicio1;


import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		final byte cantidadNumeros = 10;
		int [] numerosReales = new int [cantidadNumeros];
		int numeroIntroducido;
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
	    }
	    
	    for (int i = 0; i < cantidadNumeros; i++) {
	    	System.out.println("El valor introducido en el campo " + (i + 1) + " es: " + numerosReales [i]);
	    }
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  