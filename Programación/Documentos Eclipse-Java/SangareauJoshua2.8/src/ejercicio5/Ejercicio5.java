/*
 * Pedir 10 números. Mostrar la media de los números positivos, la media de los números
negativos y la cantidad de ceros.

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
		int numeroIntroducido, sumaPositivos, sumaNegativos, mediaPositivos, contadorCeros, mediaNegativos, contadorPositivo,contadorNegativo;
		sumaPositivos = 0;
		sumaNegativos = 0;
		contadorCeros = 0;
		contadorPositivo = 0;
		contadorNegativo = 0;
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
	    
	    for (int i = 1; i <= 10; i++){
	    	System.out.println("Introduzca un nº");
	    	numeroIntroducido = teclado.nextInt();
	    	
	    	if (numeroIntroducido > 0) {
	    		sumaPositivos = numeroIntroducido + sumaPositivos;
	    		contadorPositivo++;
	    		
	    	} else if (numeroIntroducido == 0) {
	    		contadorCeros++;
	    		
	    	} else {
	    		sumaNegativos = numeroIntroducido + sumaNegativos;
	    		contadorNegativo++;
	    	}
	    	
	    }  
	
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    if (contadorPositivo > 0) {
	    	mediaPositivos = sumaPositivos/contadorPositivo;
	    	System.out.println("La media de los nº positivos es: " + mediaPositivos);	
	    
	    } else {
	    	System.out.println("No se puede hacer la media de los nº positivos");
	    	
	    }
	    if (contadorNegativo > 0) {
	    	mediaNegativos = sumaNegativos/contadorNegativo;
	    	System.out.println("La media de los nº negativos es: " + mediaNegativos);
	    
	    } else {
	    	System.out.println("No se puede hacer la media de los nº negativos");
	    	
	    }
	    
	    System.out.println("La cantidad de numeros 0 es: " + contadorCeros);	
	}
}   