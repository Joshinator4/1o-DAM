/*
 * 13. Escribe un programa Java donde el usuario "piensa" un número del 1 al 100 y el ordenador
intenta adivinarlo. Es decir, el ordenador irá proponiendo números una y otra vez hasta
adivinarlo (el usuario deberá indicarle al ordenador si es mayor, menor o igual al número que ha
pensado).
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
		String respuesta;
		final byte NUMEROPENSADO;
		int numeroMaximo, numeroMinimo, numeroPropuesto;
		numeroMaximo = 100;
		numeroMinimo = 1;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca el nº pensado: ");
	    NUMEROPENSADO = teclado.nextByte();
	    
	    teclado.nextLine();
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    do {
	    	numeroPropuesto = (numeroMinimo + numeroMaximo)/2;
	    	System.out.println("¿Es " + numeroPropuesto + " el número que has pensado?");
	    	System.out.println("Responde con mayor, menor o igual");
	    	respuesta = teclado.nextLine();
	    	
	    	if ("mayor".equals(respuesta)) {
	    		numeroMinimo = numeroPropuesto +1;
	    		
	    	} else if ("menor".equals(respuesta)) {
	    		numeroMaximo = numeroPropuesto -1;
	    		
	    	} else if ("igual".equals(respuesta)){
	    		System.out.println("¡He acertado el numero!");
	    		
	    	} else {
	    		System.out.println("No entiendo su respuesta, por favor introduzca mayor, menor o igual");
	    	}
	    			
	    		} while(numeroPropuesto != NUMEROPENSADO);
	    			
	    	
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  