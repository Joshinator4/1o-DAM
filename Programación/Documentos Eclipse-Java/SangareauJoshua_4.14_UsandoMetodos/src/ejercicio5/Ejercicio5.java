/*
 * Escribe un programa que pida un valor entero en millas y muestre su equivalente en kilómetros.
Recuerda que una milla son 1,60934 kilómetros. Implementa y utiliza la función:
double millas_a_kilometros(int millas) // Devuelve la conversión de millas a kilómetros
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
		int millas;
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
	    
	    System.out.println("Introduzca las millas en numero entero");
	    millas = teclado.nextInt();
	    
	    System.out.println("La conversion de las millas introducidas a km es: " + millas_a_kilometros(millas) + "km");
	}
	
	public static double millas_a_kilometros(int x) {
		double km;
		km = x * 1.60934;
		return km;
	}
}   