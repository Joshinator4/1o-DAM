/*
 * Crea un programa que cree un array con 100 números reales aleatorios entre 0.0 y 1.0,
utilizando Math.random(), y luego le pida al usuario un valor real R. Por último, mostrará
cuántos valores del array son igual o superiores a R.

 */
package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte REPETICIONES = 100;
	    // Variables de entrada
		double [] numerosAleatorios = new double [REPETICIONES];
		double numeroIntroducido;
		int contadorValores;
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
	    
	    for (int i = 0; i < REPETICIONES; i++ ) {
	    	numerosAleatorios [i] = Math.ceil(Math.random()*(10 - 1) + 0.1) / 10;
	    	System.out.println(numerosAleatorios [i]);
	    }
	    
	    System.out.println("Introduzca un número entre 0,1 y 1,0");
	    numeroIntroducido = teclado.nextDouble(); 
	    
	    for (int i = 0; i < REPETICIONES; i++) {
	    	if (numerosAleatorios [i] >= numeroIntroducido) {
	    		contadorValores++;
	    	}
	    }
	    
	    System.out.println(contadorValores + " valores son iguales o superiores a " + numeroIntroducido);
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   