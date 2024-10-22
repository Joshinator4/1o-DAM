/*
 * Escribe un programa que solicite dos números por teclado (inicio y fin) y muestre por pantalla todos los números que van desde inicio hasta fin, todos en una misma línea.
 */
package ejemplo_FOR_1;

import java.util.Scanner;

public class Ejercicios_resueltos_FOR {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int inicio, fin;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("Introduzca el 1er nº: ");
	    inicio = teclado.nextInt();
	    
	    System.out.println("Introduzca el 1er nº: ");
    	fin = teclado.nextInt();
	    
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    for (int i = inicio; i < fin; i++) {
	    	System.out.println(i);
	    }
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   