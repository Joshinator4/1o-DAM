/*
 * Escribe un programa que pida un número entero por teclado y muestre por pantalla si es
positivo, negativo o cero. Implementa y utiliza la función:
int dimeSigno(int a) // Devuelve -1 si es negativo, 0 si es igual a 0, 1 si es positivo
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
		int numeroIntroducido;
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
	    
	    System.out.println("Introduzca un número: ");
	    numeroIntroducido = teclado.nextInt();
	    
	    if(dimeSigno(numeroIntroducido) == 1) {
	    	System.out.println("Su número es positivo.");
	    } else if(dimeSigno(numeroIntroducido) == -1) {
	    	System.out.println("Su número es negativo.");
	    } else {
	    	System.out.println("Su numero es 0.");
	    }
	    
	}
	
	public static int dimeSigno(int x) {
		int signo;
		if(x > 0) {
			signo = 1;
		} else if(x < 0) {
			signo = -1;
		} else {
			signo = 0;
		}
		return signo;
	}
}   