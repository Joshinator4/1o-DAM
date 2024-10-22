/*
 * 11. Escribe un programa Java que suma independientemente los pares y los impares de los números
comprendidos entre 100 y 200, y luego muestra por pantalla ambas sumas.

 */
package ejercicio11;

import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int sumatoriaPares, sumatoriaImpares;
		sumatoriaPares = 0;
		sumatoriaImpares = 0;
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
	    
	    for (int i = 100; i <= 200; i++) {
	    	if (i%2 == 0) {
	    		sumatoriaPares = i + sumatoriaPares;
	    	} else {
	    		sumatoriaImpares = i +sumatoriaImpares;
	    	}
	    }
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    System.out.println("sumatoria de nº pares es: " + sumatoriaPares);
	    System.out.println("sumatoria de nº impares es: " + sumatoriaImpares);
	    
	}
}   
