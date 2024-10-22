package ejemplo_nºPrimo;

import java.util.Scanner;

public class Ejemplo_nºPrimo {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numeroDeseado, contador;
		boolean primo;
		primo = true;
		contador = 2;
		
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca un nº: ");
	    numeroDeseado = teclado.nextInt();

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    do {
	    	
	    	if (numeroDeseado % contador == 0 && numeroDeseado != 2) {
	    		
	    		primo = false;
	    	}	
	    	contador++;
	    	
	    } while (contador < numeroDeseado && primo == true);
	    
	    if (primo == true) {
	    	System.out.println("Este nº es primo");
	    	
	    } else {
	    	System.out.println("Este nº no es primo");
	    }
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   