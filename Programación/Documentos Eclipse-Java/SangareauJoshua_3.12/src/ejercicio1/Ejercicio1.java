/*
 * 1. Crea un programa que pida una cadena de texto por teclado y luego muestre cada palabra
de la cadena en una línea distinta.

 */
package ejercicio1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		String fraseIntroducida;
		
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca una frase");
	    fraseIntroducida = teclado.nextLine();
	    
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    String [] frase = fraseIntroducida.split(" ");
	    
	    System.out.println(frase.length);
	    
	    for (int i = 0; i < frase.length; i++) {
	    	System.out.println(frase[i]);
	    }
	    
	    System.out.printf("%s\n\n", Arrays.toString(frase));
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  