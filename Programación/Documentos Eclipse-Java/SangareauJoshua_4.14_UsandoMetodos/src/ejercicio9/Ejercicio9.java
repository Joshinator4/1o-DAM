/*
 * Realiza un programa que pida introducir tres valores enteros y nos diga cuál de ellos es el más
pequeño. Impleméntalo creando únicamente una función a la que le pasemos dos valores (no
tres) y nos devuelva el mínimo de los dos valores.

 */
package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int valor1, valor2, valor3, minimoProvisional, minimoTotal;
		
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
	    
	    System.out.println("Introduzca el primero de 3 valores: ");
	    valor1 = teclado.nextInt();
	    
	    System.out.println("Introduzca el segundo de 3 valores: ");
	    valor2 = teclado.nextInt();
	    
	    System.out.println("Introduzca el tercero de 3 valores: ");
	    valor3 = teclado.nextInt();
	    
	    minimoProvisional = sacarMinimo (valor1, valor2);
	    minimoTotal = sacarMinimo (minimoProvisional, valor3);
	    
	    System.out.println("el valor mínimo es: " + minimoTotal);
	    
	}
	
	
	public static int sacarMinimo (int x, int y) {
		
		int min;
		if (x > y) {
			min = y; 
		} else {
			min = x;
		}
		return min;
	}
}   