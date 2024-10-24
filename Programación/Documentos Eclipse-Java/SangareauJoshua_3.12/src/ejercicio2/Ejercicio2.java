/*
 * 2. Crea un programa que pida dos cadenas de texto por teclado y luego indique si son iguales,
además de si son iguales sin diferenciar entre mayúsculas y minúsculas.
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		String fraseIntroducida1, fraseIntroducida2;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca la primera fase");
	    fraseIntroducida1 = teclado.nextLine();
	    
	    System.out.println("Introduzca la segunda frase");
	    fraseIntroducida2 = teclado.nextLine();

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    
	    if(fraseIntroducida1.equals(fraseIntroducida2)) {
	    	System.out.println("Las dos frases son iguales");
	    } else {
	    	System.out.println("Las dos frases no son iguales");
	    }
	    
	    if (fraseIntroducida1.equalsIgnoreCase(fraseIntroducida2)) {
	    	System.out.println("Las dos frases son iguales ignorando las mayúsculas o minúsculas");
	    } else {
	    	System.out.println("Las dos frases no son iguales ignorando las mayúsculas o minúsculas");
	    }
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  