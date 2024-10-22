/*
 * Crea un programa que permita al usuario almacenar una secuencia aritmética en un array y
luego mostrarla. Una secuencia aritmética es una serie de números que comienza por un
valor inicial V, y continúa con incrementos de I. Por ejemplo, con V=1 e I=2, la secuencia sería
1, 3, 5, 7, 9… Con V=7 e I=10, la secuencia sería 7, 17, 27, 37… El programa solicitará al
usuario V, I además de N (nº de valores a crear).

 */
package ejercicio13;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final int CANTIDAD_CAMPOS;
	    // Variables de entrada
		int valorInicial, valorSecuencial, sumaContador = 0;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca la cantidad de campos del array: ");
	    CANTIDAD_CAMPOS = teclado.nextInt();
	    
	    System.out.println("Introduzca el valor inicial: ");
    	valorInicial = teclado.nextInt();
    	
    	System.out.println("Introduzca el valor secuencial: ");
    	valorSecuencial = teclado.nextInt();
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    int [] secuenciaAritmetica = new int [CANTIDAD_CAMPOS];
	    
	    secuenciaAritmetica [0] = valorInicial;
	    sumaContador = valorInicial;
	    
	    for (int i = 1; i < CANTIDAD_CAMPOS; i++) {
	    	sumaContador += valorSecuencial;
	    	secuenciaAritmetica [i] = sumaContador;
	    	
	    }
	    
	    for (int i = 0; i < CANTIDAD_CAMPOS; i++) {
	    	System.out.println("el valor en la posción " + i + " es: " + secuenciaAritmetica [i]);
	    }
	    
	    
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  