/*
 * Crea un programa que cree un array de tamaño 1000 y lo rellene con valores enteros
aleatorios entre 0 y 99 (utiliza Math.random()*100). Luego pedirá por teclado un valor N y se
mostrará por pantalla si N existe en el array, además de cuantas veces.

 */
package ejercicio20;

import java.util.Scanner;

public class Ejercicio20 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final int TAMANNO = 1000;
	    // Variables de entrada
		int [] valores = new int [TAMANNO];
		int numeroIntroducido, contadorValores;
		boolean banderaValores;
		banderaValores = false;
		contadorValores = 0;
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
	    	valores [i] = (int)(Math.random()*100);
	    	System.out.println("La posición " + i + " tiene el valor: " + valores [i]);
	    }
	    
	    System.out.println("Introduzca un número del 0 al 99");
	    numeroIntroducido = teclado.nextInt();
	    
	    for (int i = 0; i < TAMANNO; i++) {
	    	if (valores [i] == numeroIntroducido) {
	    		banderaValores = true;
	    		contadorValores++;
	    	}
	    }
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    if(banderaValores == true) {
	    	System.out.println("El numero " + numeroIntroducido + " existe en el array y se repite " + contadorValores + " veces");
	    } else {
	    	System.out.println("El numero " + numeroIntroducido + " no se encuentra en los números del array");
	    }
	    
	    
	}
} 