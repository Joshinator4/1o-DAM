/*Realiza un programa que pida una hora por teclado y que muestre luego buenos días,
buenas tardes o buenas noches según la hora.
Se utilizarán los tramos de 6 a 12, de 13 a 20 y de 21 a 5. respectivamente. Sólo se tienen
en cuenta las horas, los minutos no se deben introducir por teclado.

 * 
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		byte hora;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca la hora en formato (24h sin minutos)");
	    
	    hora = teclado.nextByte();
	   
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    if (hora < 6 || hora > 21) {
	    	
	    	System.out.println("Bunas noches");
	    	
	    } else if (hora > 5 && hora < 13) {
	    	
	    	System.out.println("Buenas días");
	    	
	    } else {
	    	
	    	System.out.println("Buenas tardes");
	    }
	    
	}

}
