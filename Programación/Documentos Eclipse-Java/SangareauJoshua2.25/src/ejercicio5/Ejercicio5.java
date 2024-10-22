/*
 * 5. Realiza un programa que resuelva una ecuación de primer grado (del tipo ax + b = 0).
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
		double numeroA, numeroX, numeroB;
	    // Variables de salida
		double resultadoDeX;
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca el valor de a:");
	    numeroA = teclado.nextDouble();
	    
	    System.out.println("Introduzca el valor de b:");
	    numeroB = teclado.nextDouble();
	    
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    resultadoDeX = (-numeroB)/numeroA;
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    System.out.println("X= " + resultadoDeX);

	}

}
