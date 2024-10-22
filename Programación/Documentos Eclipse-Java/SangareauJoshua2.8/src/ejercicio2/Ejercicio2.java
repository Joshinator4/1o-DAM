/*
 * 2 Ejemplo de uso de do-while. Programa Java que muestre los números del 1 al 100
utilizando la instrucción do..while.

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
		int contador;
		contador = 1;
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
	    
	    do {
	    	System.out.println(contador);
	    	contador++;
	    } while (contador <=100);
	    
	
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	   
	    
	}
}   