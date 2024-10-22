/*
 * 4. Escribe una función que muestre por pantalla un triángulo como el del ejemplo. Deberá recibir
dos parámetros: el carácter que se desea imprimir y el número de líneas del triángulo.

 */
package ejercicio14;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		char caracterDeseado;
		int filasIntroducidas;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("Introduzca el caracter deseado");
	    caracterDeseado = teclado.next().charAt(0);
	    
	    System.out.println("Introduzca el numero de líneas que tendrá la piramide");
	    filasIntroducidas = teclado.nextInt();
	    
	    hacerTriangulo(caracterDeseado, filasIntroducidas);
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    
	    
	}
	
	public static void hacerTriangulo(char x, int y) {
		
		for(int i = 1; i <= y; i++) {
			for(int j = (i-1); j < y-1 ; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < (i*2)-1; k++) {
				System.out.print(x);
			}
			
			System.out.println();
		}
	}
} 