/*
 * Realiza un programa que diga si un número introducido por teclado es par y/o divisible
entre 5.
 */
package ejercicio10;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numeroIntroducido;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca un número: ");
	    numeroIntroducido = teclado.nextInt();

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    if (numeroIntroducido % 5 == 0 && numeroIntroducido % 2 == 0) {
	    	System.out.println("El numero introducido es par y múltiplo de 5");
	    	
	    } else if (numeroIntroducido % 5 == 0 && numeroIntroducido % 2 != 0) {
	    	System.out.println("Este número es múltiplo de 5 pero no es par");
	    	
	    } else if (numeroIntroducido % 5 != 0 && numeroIntroducido % 2 == 0) {
	    	System.out.println("Este número es par pero no es múltiplo de 5");
	    	
	    } else {
	    	System.out.println("Este número ni es par ni es múltiplo de 5");
	    }
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   