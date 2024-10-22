/*
 * Crea un programa que pida dos valores enteros P y Q, luego cree un array que contenga
todos los valores desde P hasta Q, y lo muestre por pantalla.
 */
package ejercicio7;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		final int  VALORARRAY;
		int [] valorEntero;
		int valorP, valorQ;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Un número, el bucle recorrerá hasta el siguiente nº que introduzca: ");
	    valorP = teclado.nextInt();
	    
	    System.out.println("Introduzca el numéro hasta el que llegará el bucle: ");
	    valorQ = teclado.nextInt();
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    if (valorP < valorQ) { 
	    	VALORARRAY = valorQ - valorP;
	    	valorEntero = new int [VALORARRAY+1];
	    
	    	for (int i = 0; i <= VALORARRAY; i++) {
	    		valorEntero [i] = valorP;
	    		System.out.println("El número de la posición: " + (i) + " es: " + valorP);
	    		valorP++;
	    	
	    		
	    	
	    	}
	    	
	    } else {
	    	VALORARRAY = valorP - valorQ;
	    	valorEntero = new int [VALORARRAY+1];
	    	
	    	for (int i = 0; i <= VALORARRAY; i++) {
	    		valorEntero [i] = valorP;
	    		System.out.println("El número de la posición: " + (i) + " es: " + valorP);
	    		valorP--;
	    	
	    	}
	    }
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  