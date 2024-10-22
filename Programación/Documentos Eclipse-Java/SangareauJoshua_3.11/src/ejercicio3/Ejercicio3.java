/*
 * Crea un programa que cree una matriz de tamaño NxM (tamaño introducido por teclado) e
introduzca en ella NxM valores (también introducidos por teclado). Luego deberá recorrer la
matriz y al final mostrar por pantalla cuántos valores son mayores que cero, cuántos son
menores que cero y cuántos son igual a cero.
 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final int TAMANNO_N, TAMANNO_M;
		
	    // Variables de entrada
		int numeroIntroducido, contadorNegativos = 0, contadorPositivos = 0, igualesCero = 0;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca el número de filas que tendrá el array");
	    TAMANNO_N = teclado.nextInt();
	    
	    System.out.println("Introduzca el número de columnas que tendrá el array");
	    TAMANNO_M = teclado.nextInt();
	    
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    // se declara aquí el array para que primero se pida el tamaño de ambos arrays. si  se crea arriba da error.
	    int [][] valores = new int [TAMANNO_N][TAMANNO_M];
	    
	    for (int i = 0; i < TAMANNO_N; i++) {
	    	for (int j = 0; j < TAMANNO_M; j++) {
	    		System.out.println("Introduzca el valor de esta casilla");
	    		numeroIntroducido = teclado.nextInt();
	    		valores [i][j] = numeroIntroducido;
	    		
	    	}
	    	
	    }
	    
	    for (int i = 0; i < TAMANNO_N; i++) {
	    	for (int j = 0; j < TAMANNO_M; j++) {
	    		if(valores[i][j] < 0) {
	    			contadorNegativos++;
	    		} else if (valores[i][j] == 0) {
	    			igualesCero++;
	    		} else {
	    			contadorPositivos++;
	    		}
	    	}
	    	
	    }
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    System.out.println("La cantidad de numeros mayores que cero es: " + contadorPositivos);
	    System.out.println("La cantidad de numeros menores que cero es: " + contadorNegativos);
	    System.out.println("La cantidad de numeros iguales que cero es: " + igualesCero);
	}
}   