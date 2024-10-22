/*
 * . Crea un programa que pida al usuario 20 valores enteros e introduzca los 10 primeros en un
array y los 10 últimos en otro array. Por último, comparará ambos arrays y le dirá al usuario
si son iguales o no.
 */
package ejercicio17;

import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte TAMANNO_ARRAY1= 10;
		final byte TAMANNO_ARRAY2= 10;
		final byte TAMANNO_TOTAL = 20;
	    // Variables de entrada
		int valorIntroducido;
		int [] numerosIntroducidos = new int [TAMANNO_TOTAL];
		int[] array1 = new int [TAMANNO_ARRAY1];
		int[] array2 = new int [TAMANNO_ARRAY2];
		boolean banderaArrays = true;
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
	    
	    
	   
	    for(int i = 0; i < TAMANNO_TOTAL; i++) {
	    	System.out.println("Introduzca el valor" + (i+1) + ": ");
		    valorIntroducido = teclado.nextInt();
	    	numerosIntroducidos [i] = valorIntroducido;
	    }
	    
	    for (int i = 0; i < TAMANNO_ARRAY1; i++) {
	    	array1 [i] = numerosIntroducidos [i];
	    }
	   
	    for (int i = 0; i < TAMANNO_ARRAY2; i++) {
	    	array2 [i] = numerosIntroducidos [i+10];
	    }
	    //Aqui debería habe usado el método Array.equals(array1, array2) y la condición sería if (Array.equals(array1, array2)){} etc....
	    int k = 0;
	    while (k < TAMANNO_ARRAY1 && banderaArrays == true) {
	    	if (array1 [k] == array2 [k]) {
	    		banderaArrays = true;
	    	
	    	} else {
	    		banderaArrays = false;;
	    	}
	    	k++;
	    }
	    
	    if (banderaArrays == true) {
	    	System.out.println("Los 2 arrays son iguales");
	    } else {
	    	System.out.println("Los 2 arrays son no iguales");
	    }
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   