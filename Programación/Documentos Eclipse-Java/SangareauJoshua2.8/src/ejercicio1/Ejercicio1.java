/*
 * 1 Ejemplo de uso de while: Programa Java que muestre los números del 1 al 100 utilizando
la instrucción while.
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
	    while(contador <= 100){
	    	System.out.println(contador);
	    	contador++;
	    	
	    }
	
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   