/*
 * Crea un programa que cree un array de enteros de tamaño 100 y lo rellene con valores
enteros aleatorios entre 1 y 10 (utiliza 1 + Math.random()*10). Luego pedirá un valor N y
mostrará en qué posiciones del array aparece N. 
 */
package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte TAMANNO = 100;
	    // Variables de entrada
		int [] valoresAleatorios = new int [TAMANNO];
		byte numeroIntroducido;
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
	    
	    for (int i = 0; i < TAMANNO; i++) {
	    	valoresAleatorios [i] = 1 + (int)(Math.random()*10);

	    }
	    
	    System.out.println("Introduzca un valor entre 1 y 10: ");
	    numeroIntroducido = teclado.nextByte();
	    
	    for (int i = 0; i < TAMANNO; i++) {
	    	if (valoresAleatorios [i] == numeroIntroducido) {
	    		System.out.println("la posicion " + i +" del array es el mismo numero al introducido");
	    	}
	    }
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   