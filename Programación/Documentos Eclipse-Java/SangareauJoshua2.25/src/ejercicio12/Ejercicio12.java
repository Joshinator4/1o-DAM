/*
 * 12. Escribe un programa que muestre los N primeros números de la secuencia de fibonacci.
La secuencia de fibonacci comienza por 1, 1, y a continuación cada valor es la suma de
los dos valores anteriores: 1, 1, 2, 3, 5, 8, 13… El valor N lo introduce el usuario.
 */
package ejercicio12;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numero1, numero2, numeroFibonacci = 0, sumaNumeros;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	     
	    System.out.println("Introduzca un nº a secuenciar con Fibonacci: ");
	    numero1 = teclado.nextInt();

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    numero2 = numero1;
	    sumaNumeros = numero1 +numero2;
	    System.out.print(numero1 + ", " + numero2 + ", " + sumaNumeros + ", ");
	    while (numeroFibonacci < 10000000) {
	    	numeroFibonacci = numero1 + numero2;
	    	numero1 = numero2;
	    	numero2 = numeroFibonacci;
	    	numeroFibonacci = numero2 + numero1;
	    	System.out.print(numeroFibonacci + ", ");
	    }
	    
	    System.out.println("etc.");
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   