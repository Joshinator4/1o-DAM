package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte NUMEROPROVINCIAS = 8, NUMERODIAS = 31;
	    // Variables de entrada
		String[] nombreProvincias = {"sevilla", "malaga", "granada", "jaen", "almeria", "córdoba", "Huelva", "cádiz"};
		int[][] datos = new int [NUMEROPROVINCIAS][NUMERODIAS];
		int media[] = new int [NUMEROPROVINCIAS];
		String nombreMediaMax; 
		int mediaMax, diaMin;
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
	    for(int i = 0; i < NUMEROPROVINCIAS; i++) {
	    	media[i] = 0;
	    	for(int j = 0; j < NUMERODIAS; j++) {
	    		datos[i][j] = (int)(Math.random()*400)+101;
	    		System.out.println("la provincia " + nombreProvincias[i] + datos[i][j]);
	    		media[i] += datos[i][j];
	    	}
	    	media[i] = (int)(media[i]/NUMERODIAS);
	    }
	    nombreMediaMax = nombreProvincias[0];
    	mediaMax = media [0];
	    for(int i = 0; i < NUMEROPROVINCIAS; i++) {
	    	if (media [i] > mediaMax) {
	    		nombreMediaMax = nombreProvincias[i];
	    		mediaMax = media [i];
	    	}
	    }
	    System.out.println("La provincia con la tasa media mas alta es: " + nombreMediaMax + " con una media de: " + mediaMax);
	    
	    for (int i = 0; i < NUMEROPROVINCIAS; i++) {
	    	diaMin = datos [i][0];
	    	for (int j = 0; j < NUMERODIAS; i++) {
	    		if (datos [i][j] < diaMin) {
	    			diaMin = datos [i][j];
	    		}
	    	}
	    	System.out.println("En la provincia " + nombreProvincias[i] + "con " + diaMin);
	    }
	    
	    for (int i = 0; i < NUMERODIAS; i++) {
	    	
	    }
	    
	    
	}
}   