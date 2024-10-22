/*
 * Crea un programa que pida la usuario dos valores N y M y luego cree un array de tamaño N
que contenga M en todas sus posiciones. Luego muestra el array por pantalla.
 */
package ejercicio15;

import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final int TAMANNO;
	    // Variables de entrada
		int valorIntroducido;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca el tamaño del array: ");
	    TAMANNO = teclado.nextInt();
	    
	    System.out.println("Introduzca el valor a introducir en todos lo campos del array: ");
	    valorIntroducido = teclado.nextInt();

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    int [] valores = new int [TAMANNO];
	    
	    for (int i = 0; i < TAMANNO; i++) {
	    	valores [i] = valorIntroducido;
	    	System.out.println("El valor en la posición " + i + " es: " + valores [i]);
	    }
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   
