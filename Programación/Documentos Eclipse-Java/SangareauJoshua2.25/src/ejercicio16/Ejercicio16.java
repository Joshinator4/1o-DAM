/*
 * Escribe un programa que pida un número entero al usuario (int) y luego muestre la suma
de sus cifras. Por ejemplo, dado el número 35 su suma es 8, dado el número 719 su suma
es 17, y dado el 1002 su suma es 3.

 */
package ejercicio16;

import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int sumaCifras = 0;
		int numeroIntroducido, sumaRestos, resto;
		sumaRestos = 0;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("Introduzca un nº: ");
	    numeroIntroducido = teclado.nextInt();
	    
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    while (numeroIntroducido > 0) {
	    	resto = numeroIntroducido % 10;
	    	numeroIntroducido = numeroIntroducido / 10;
	    	sumaRestos += resto;
	    }
	    System.out.println("la suma de cada cifra introducida es: " + sumaRestos);
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   