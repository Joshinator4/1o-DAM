/*
 * Realiza un programa que dado un valor en kilómetros nos lo traduce a millas. El programa debe
tener una función que reciba como parámetro una cantidad en kilómetros y nos la devuelva en
millas
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
		double numeroIntroducido;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca los kilómetros a transformar en millas");
	    numeroIntroducido = teclado.nextDouble();
	    
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    System.out.println(numeroIntroducido + " kilómetros son: " + pasarKilometrosAMillas (numeroIntroducido) + " millas");
	    
	    
	    
	}
	
	public static double pasarKilometrosAMillas (double x) {
		double millas = x / 1.60934;
		return millas;
	}
	
} 