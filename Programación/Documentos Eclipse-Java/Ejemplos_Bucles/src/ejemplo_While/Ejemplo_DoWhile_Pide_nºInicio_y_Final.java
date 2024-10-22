/*
 * Escribe un programa que solicite dos números por teclado (inicio y fin)
 * y muestre por pantalla todos los números que van desde inicio hasta fin, todos en una misma línea. Este ejercicio ya lo hemos planteado usando un bucle while.
 *  En este caso debes utilizar un bucle do-while.
 */
package ejemplo_While;

import java.util.Scanner;

public class Ejemplo_DoWhile_Pide_nºInicio_y_Final {

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
	    
	    do{
	    
	    	System.out.println("introduzca nº inicio: ");
    	inicio = teclado.nextInt();
    	
    		System.out.println("introduzca nº de final: ");
    	fin = teclado.nextInt();
    	
	    } while(inicio > fin);
	    
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    System.out.println("Secuencia de nº desde " + inicio + " hasta " + fin);
	    
	    do {
	    	System.out.println(inicio);
	    	inicio++;
	    	
	    } while(inicio <= fin);
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   