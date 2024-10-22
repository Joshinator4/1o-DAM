package ejemplo_FOR_1;

import java.util.Scanner;

public class Ejemplo_For_2 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
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
	    
	    for (int i = 1; i <21 ; i++) {
	    	
	    	if(i % 2 == 0) {
	    		System.out.println("el nº " + i + " es par");
	    		
	    		if (i % 3 == 0) {
	    			System.out.println("el nº " + i + " es par y múltiplo de 3");
	    			
	    			for (int j = 1; j < i; j++) {
	    				System.out.println(j);
	    			}
	    		}
	    		
	    	} else {
	    		
	    		if (i % 5 == 0) {
	    			System.out.println("el nº " + i + " es impar y múltiplo de 5");
	    		
	    			for (int j = i; j > 0; j--) {
		    			System.out.println(j);
		    		}
	    		}
	    		System.out.println("el nº " + i + " es impar");
	    	}
	    	
	    }
	    
	 
	    
	}
}   