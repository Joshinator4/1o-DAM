package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte CANTIDADNUMEROS = 30;
	    // Variables de entrada
		byte [] numeros = new byte [CANTIDADNUMEROS];
		byte numeroIntroducido, posicionIntroducida1, posicionIntroducida2;
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
	    
	    
	    for(int i = 0; i < CANTIDADNUMEROS; i++ ) {
	    	numeros [i] = (byte)(Math.random()*101);
	    	System.out.println(numeros [i]);
	    }
	    
	    System.out.println("Introduzca un numero:");
	    numeroIntroducido = teclado.nextByte();
	    
	    for(int i = 0; i < CANTIDADNUMEROS; i++ ) {
	    	if(numeros[i] < numeroIntroducido) {
	    		System.out.println("el número " + numeros[i] + " está en la posicion: " + i + " del array ");
	    	}
	    }
	    do {
	    	System.out.println("Introduzca la posición 1  para mostrar los numeros pares entre las 2 posiciones" );
		    posicionIntroducida1 = teclado.nextByte();
	    } while (posicionIntroducida1<0 && posicionIntroducida1>=30);
	    do {
	    	System.out.println("Introduzca la posición 2  para mostrar los numeros pares entre las 2 posiciones" );
		    posicionIntroducida2 = teclado.nextByte();
	    } while (posicionIntroducida2<0 && posicionIntroducida1>=30);
	    
	    
	    if(posicionIntroducida1 < posicionIntroducida2) {
	    	for(int i = posicionIntroducida1; i < posicionIntroducida2; i++ ) {
	    		if (numeros[i]%2==0) {
	    			System.out.println("Este número es par: " + numeros [i] + " de la posición " + i);
	    		}
	    	}
	    }
	    if(posicionIntroducida2 < posicionIntroducida1) {
	 	   for(int i = posicionIntroducida2; i < posicionIntroducida1; i++ ) {
	 		   if (numeros[i]%2==0) {
	 	    		System.out.println("Este número es par: " + numeros [i] + " de la posición " + i);
	 		   }
	 	   }	
	    	
	    }
	    
	    
	    }
}   