/*
 * 4 Utilizando un bucle while solicita al usuario que introduzca valores positivos, almacena
la suma de todos estos valores, así como la cantidad de números introducidos. El bucle
parará cuando introduzca un 0. En ese momento el programa mostrará por pantalla la
cantidad de números mayores de 0 introducidos así como la media de los mismos.
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numeroIntroducido, totalIntroducidos, valorTotal;
		double mediaIntroducidos;
		valorTotal = 0;
		totalIntroducidos = 0;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    numeroIntroducido = 7;
	    
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    while (numeroIntroducido != 0){
	    	
	    	 System.out.println("Introduzca un nº positivo");
	    	 numeroIntroducido = teclado.nextInt();
	    	 if (numeroIntroducido > 0) {
	    		 valorTotal = numeroIntroducido + valorTotal;
	    		 totalIntroducidos++;
	    	 }
	    	 
	    }
	    mediaIntroducidos = valorTotal/totalIntroducidos;
	
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    System.out.println("la media de los números positivos que ha indroducido es: " + mediaIntroducidos );
	    System.out.println("el total de números positivos que ha indroducido es: " + totalIntroducidos );
	    
	}
}   
