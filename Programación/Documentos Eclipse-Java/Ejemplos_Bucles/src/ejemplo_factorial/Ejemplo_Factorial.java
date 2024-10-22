package ejemplo_factorial;

import java.util.Scanner;

public class Ejemplo_Factorial {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numeroDeseado;
		long factorial;
		factorial = 1;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
		System.out.println("Introduzca el nº deseado para sacar el factorial: ");
		numeroDeseado = teclado.nextInt();
		
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
		//realización hacia arriba
		for (int i = 1; i <= numeroDeseado; i++) {
			factorial = i * factorial;
		}
		System.out.println("el factorial de nº introducido es: " + factorial );
		//realización hacia abajo
		//for (int i = numeroDeseado; i > 0; i--) {
			//factorial = i * factorial;
		//}
			
		
		//System.out.println("el factorial de nº introducido es: " + factorial );
	
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   