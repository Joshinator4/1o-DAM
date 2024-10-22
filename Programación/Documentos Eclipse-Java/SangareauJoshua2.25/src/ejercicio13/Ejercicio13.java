/*
 * . Escribe un programa que tire un dado de 6 caras 100 veces y luego muestre el nº y % de
veces que ha salido cada número.

 */
package ejercicio13;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		byte dado, contador1 = 0, contador2 = 0, contador3 = 0, contador4 = 0, contador5 = 0, contador6 = 0;
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
	    
	    for (int i = 0 ; i < 100; i++) {
	    	dado = (byte)(Math.random()*6+1);
	    	
	    	switch (dado) {
	    	case (1):
	    		contador1++;
	    		break;
    		
	    	case (2):
	    		contador2++;
	    		break;
	    		
	    	case (3):
	    		contador3++;
	    		break;
	    		
	    	case (4):
	    		contador4++;
	    		break;
	    		
	    	case (5):
	    		contador5++;
	    		break;
	    		
	    	case (6):
	    		contador6++;
	    		break;
	    	
	    	}
	    }
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    System.out.println("El numero 1 ha salido: " + contador1 + " veces y tiene un porcentaje de: " + contador1 + "%");
	    System.out.println("El numero 2 ha salido: " + contador2 + " veces y tiene un porcentaje de: " + contador2 + "%");
	    System.out.println("El numero 3 ha salido: " + contador3 + " veces y tiene un porcentaje de: " + contador3 + "%");
	    System.out.println("El numero 4 ha salido: " + contador4 + " veces y tiene un porcentaje de: " + contador4 + "%");
	    System.out.println("El numero 5 ha salido: " + contador5 + " veces y tiene un porcentaje de: " + contador5 + "%");
	    System.out.println("El numero 6 ha salido: " + contador6 + " veces y tiene un porcentaje de: " + contador6 + "%");
	    
	    
	}
}   