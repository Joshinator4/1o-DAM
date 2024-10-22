/*6 Leer un número y mostrar su cuadrado, repetir el proceso hasta que se introduzca un
número negativo.
 * 
 */
package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numeroIntroducido;
		double numeroCuadrado;
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
	    	System.out.println("Introdzca un nº:");
	    	numeroIntroducido = teclado.nextInt();
	    	if(numeroIntroducido > 0) {
	    	numeroCuadrado = Math.pow(numeroIntroducido, 2);
	    	System.out.println(numeroCuadrado);
	    	}
	    } while (numeroIntroducido > 0);
	
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   