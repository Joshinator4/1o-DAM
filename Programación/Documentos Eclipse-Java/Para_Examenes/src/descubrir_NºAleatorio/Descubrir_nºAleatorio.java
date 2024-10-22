package descubrir_NºAleatorio;

import java.util.Scanner;

public class Descubrir_nºAleatorio {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		byte numeroCreado = (byte)(Math.random()*10+1), numeroIntroducido;
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
	    	System.out.println("Introduzca un nº");
		    numeroIntroducido = teclado.nextByte();
	    	if (numeroCreado > numeroIntroducido) {
	    		System.out.println("El nº a adivinar es mayor"); 
	    		
	    	} else if (numeroIntroducido == numeroCreado){
	    		System.out.println("ha acertado el número, enhorabuena");
	    		
	    	}else {
	    		System.out.println("El nº a adivinar es menor"); 
	    	}
	    } while (numeroIntroducido != numeroCreado);
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   
