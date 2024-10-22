/*
 * Crea un programa que pida dos valores enteros N y M, luego cree un array de tamaño N,
escriba M en todas sus posiciones y lo muestre por pantalla.

 */
package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte POSICIONES;
	    // Variables de entrada
		double valorPosiciones;
		double [] valorN; 
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("Introduzca un número para la cantidad de posiciones del array: ");
	    POSICIONES = teclado.nextByte();
	    
	    System.out.println("Introduzca un número para qu todo el array tenga ese valor: ");
	    valorPosiciones = teclado.nextDouble();
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    valorN = new double [POSICIONES];
	    
	    for (int i = 0; i < POSICIONES; i++) {
	    	valorN [i] = valorPosiciones;
	    	System.out.println("El valor de la posición: " + (i+1) + " es: " + valorN [i]);
	    }
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  