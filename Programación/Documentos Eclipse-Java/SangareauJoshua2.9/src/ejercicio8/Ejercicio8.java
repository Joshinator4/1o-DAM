/*
 * 8. Escribe un programa Java que lea una secuencia de números no nulos hasta que se introduzca
un 0, y luego muestre si ha leído algún número negativo, cuantos positivos y cuantos negativos.
 */
package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numeroIntroducido;
		int contadorNegativos, contadorPositivos;
		boolean banderaNegativos;
		banderaNegativos = false;
		contadorNegativos = 0;
		contadorPositivos = 0;
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
	    
	    do {
	    	System.out.println("Introduzca un nº ");
	    	numeroIntroducido = teclado.nextInt();
	    	if (numeroIntroducido < 0) {
	    		contadorNegativos++;
	    		banderaNegativos = true;
	    	} else if(numeroIntroducido > 0) {
	    		contadorPositivos++;
	    	}
	    	
	    	
	    } while (numeroIntroducido != 0); 
	    
	
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    System.out.println("Has introducido " + contadorPositivos + " números positivos y " + contadorNegativos + " numeros positivos");
	    
	    if(banderaNegativos == true) {
	    	System.out.println("He encontrado numeros negativos");
	    }else {
	    	System.out.println("No se ha encontrado números negativos");
	    }
	}
}   