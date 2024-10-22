/*Escribe un programa que pida la edad por teclado y muestre por pantalla si eres mayor de edad
o no. Implementa y utiliza la función:
boolean esMayorEdad(int a) // Devuelve verdadero si a>=18, falso en caso contrario
 * 
 */
package ejercicio2;

import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int edad;
		boolean mayorEdad;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("Intorduzca su edad: ");
	    edad = teclado.nextInt();
	    
	    mayorEdad = esMayorEdad (edad);

	    if(mayorEdad == true) {
	    	System.out.println("Es usted mayor de edad");
	    } else {
	    	System.out.println("Es usted menor de edad");
	    }
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    
	    
	}
	
	public static boolean esMayorEdad(int x) {
		boolean mayorEdad;
		if (x >= 18) {
			mayorEdad = true;
		} else {
			mayorEdad = false;
		}
		return mayorEdad;
	}
}   
