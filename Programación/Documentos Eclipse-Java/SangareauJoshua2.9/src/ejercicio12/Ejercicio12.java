/*
 * 12. Escribe un programa Java que calcule el valor A elevado a B (A^B) sin hacer uso del operador de
potencia (^), siendo A y B valores introducidos por teclado, y luego muestre el resultado por
pantalla.
 */
package ejercicio12;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numeroA, numeroB, resultado;
		resultado = 1; 
		
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca numero A:");
	    numeroA = teclado.nextInt();
	    
	    System.out.println("Introduzca numero B:");
	    numeroB = teclado.nextInt();

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    for (int i = 1; i <= numeroB; i++) {
	    	
	    	resultado = resultado * numeroA;
	    }
	    	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    System.out.println("El resultado es = " + resultado);
	}
}   