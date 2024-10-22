/*
 * Escribe un programa que pida dos números enteros por teclado y muestre por pantalla cual es el
mínimo. Implementa y utiliza la función:
int minimo(int a, int b) // Devuelve el menor entre a y b

 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numeroIntroducido1, numeroIntroducido2;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("Introduzca un numero: ");
	    numeroIntroducido1 = teclado.nextInt();
	    
	    System.out.println("Introduzca el segundo numero");
	    numeroIntroducido2 = teclado.nextInt();

	    
	    System.out.println("El numero minimo es: " + minimo(numeroIntroducido1, numeroIntroducido2));
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    
	    
	    
	}
	
	public static int minimo(int x, int y) {
		int min;
		if(x > y) {
			min = y;
		} else {
			min = x;
		}
		return min;
		
	}
}   