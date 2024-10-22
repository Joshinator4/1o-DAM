/*
 * 5. Escribe un programa Java que lea un número positivo N y calcule y visualice su factorial N!
Siendo el factorial:
0! = 1
1! = 1
2! = 2 * 1
3! = 3 * 2* 1
N! = N * (N-1) * (N-2) * … * 1
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int factorial, numeroFactorizar;
		factorial = 1;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("introduzca el nº a factorizar");
	    numeroFactorizar = teclado.nextInt();
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    for (int i = 1; i <= numeroFactorizar; i++) {
	    	factorial = i * factorial;
	    	
	    }
	    System.out.println("Este es el factorial de " + numeroFactorizar + ": " + factorial);
	    
	    //Tambien se puede realizar con i-- en este caso sería de la siguiente forma:
	    //for (int i = numeroFactorizar; i > 0; i--){
	    //factorial = i * factorial;
	    //}
	
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   