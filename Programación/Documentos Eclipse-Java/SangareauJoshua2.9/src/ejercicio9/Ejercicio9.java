/*
 * 9. Escribe un programa Java que calcula y escribe la suma y el producto de los 10 primeros
números naturales.
 */
package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int sumatoria, producto;
		sumatoria = 0;
		producto = 1;
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
	    
	    for (int i = 1; i <= 10; i++) {
	    	sumatoria = i + sumatoria;
	    	producto = i * producto;
	    }
	    System.out.println("sumatoria = " + sumatoria);
	    System.out.println("producto = " + producto);
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   