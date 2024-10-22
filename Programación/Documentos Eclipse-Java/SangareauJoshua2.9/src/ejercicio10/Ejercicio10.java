/*
 * 10. Escribe un programa Java que lee una secuencia de notas (con valores que van de 0 a 10) que
termina con el valor -1 y nos dice si hubo o no alguna nota con valor 10.
 */
package ejercicio10;

import java.util.Scanner;

public class Ejercicio10 {
	
	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		byte numeroIntroducido , contador10;
		contador10 = 0;
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
	    
	    do {
	    	System.out.println("Por favor introduzca nota entre 0 y 10");
	    	numeroIntroducido = teclado.nextByte();
	    	
	    	if(numeroIntroducido < 0 && numeroIntroducido != -1 || numeroIntroducido > 10) {
	    		System.out.println("nota errónea");
	    	}else {
	    		if (numeroIntroducido == 10) {
	    			contador10++;
	    		}
	    	}
	    	
	    } while (numeroIntroducido != -1);
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    System.out.println("Usted ha introducido " + contador10 + " veces la nota 10");
	    
	}
} 
