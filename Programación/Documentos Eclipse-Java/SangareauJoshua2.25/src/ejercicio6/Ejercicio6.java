/*
 * 6. Realiza un programa que resuelva una ecuación de segundo grado (del tipo ax2 + bx + c= 0).
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
		double numeroA, numeroX, numeroB, numeroC;
	    // Variables de salida
		double resultadoDeX1, resultadoDeX2, raizCuadrada;
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
	    
	    System.out.println("Introduzca el valor de b:");
	    numeroC = teclado.nextDouble();

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    raizCuadrada = Math.pow(numeroB, 2) - (4 * numeroA * numeroC);
	    resultadoDeX1 = (-numeroB + Math.sqrt(raizCuadrada))/2;
	    resultadoDeX2 = (-numeroB - Math.sqrt(raizCuadrada))/2;
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    System.out.println("x1= " + resultadoDeX1 + ", x2= " + resultadoDeX2);

	}

}
