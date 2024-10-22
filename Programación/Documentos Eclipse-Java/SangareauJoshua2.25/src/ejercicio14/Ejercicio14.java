/*
 * Escribe un programa que pregunte un número X al usuario y diga si es primo o no.
Un número es primo si solo es divisible por 1 y por él mismo.
 */
package ejercicio14;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numeroIntroducido, contador = 2;
		boolean primo = true;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("Introduzca un número: ");
	    numeroIntroducido = teclado.nextInt();
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    do {
	    	if (numeroIntroducido % contador == 0 && contador != 2) {
	    		primo = false;
	    	}
	    	
	    	contador++;
	    } while (contador < numeroIntroducido && primo == true);
	    
	    if (primo == true) {
	    	System.out.println("Este numero es primo");
	    
	    } else {
	    	System.out.println("Este número no es primo");
	    }
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   