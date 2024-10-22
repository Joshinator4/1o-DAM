package ejercicio3_terminado;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte CANTIDADDIAS = 31, CANTIDADPROVINCIAS = 8;
	    // Variables de entrada
		String [] nombreProvincias = new String[CANTIDADPROVINCIAS];
		int [][] datos = new int [CANTIDADPROVINCIAS][CANTIDADDIAS];
		int diaMin, datosMin, datoMasAlto;
		String diaAlto, provinciaMediaAlta, provinciaBaja, provinciaMasAlta;
		double tasaMedia, maxMedia, sumaDatos;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    nombreProvincias [0] = "Sevilla";
	    nombreProvincias [1] = "Málaga";
	    nombreProvincias [2] = "Cádiz";
	    nombreProvincias [3] = "Córdoba";
	    nombreProvincias [4] = "Huelva";
	    nombreProvincias [5] = "Granada";
	    nombreProvincias [6] = "Jaén";
	    nombreProvincias [7] = "Almería";
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
		
	    for(int i = 0; i < CANTIDADPROVINCIAS; i++) {
	    	System.out.print(nombreProvincias[i]);
	    	for (int j = 0; j < CANTIDADDIAS; j++) {
	    		datos [i][j] = (int)(Math.random()*400)+101;
	    		System.out.print(" " + datos [i][j] + " ");
	    	}
	    	
	    	System.out.println();
	    }
	    
	    
	    provinciaMediaAlta = nombreProvincias [0];
	    maxMedia = 0;
	    for(int i = 0; i < CANTIDADPROVINCIAS; i++) {
	    	tasaMedia = 0;
	    	sumaDatos = 0;
	    	for (int j = 0; j < CANTIDADDIAS; j++) {
	    		sumaDatos += datos [i][j];
	    	}
	    	tasaMedia = sumaDatos / CANTIDADDIAS;
	    	if(tasaMedia > maxMedia) {
	    		maxMedia = tasaMedia;
	    		provinciaMediaAlta = nombreProvincias[i];
	    	} 
	    }
	    System.out.println("La provincia con la tasa media mensual mas alta es: " + provinciaMediaAlta + " con una tasa media de: " + maxMedia);
	    
	    for(int i = 0; i < CANTIDADPROVINCIAS; i++) {
	    	datosMin = 500;
	    	diaMin = 0;
	    	for (int j = 0; j < CANTIDADDIAS; j++) {
	    		if(datos[i][j] < datosMin) {
	    			datosMin = datos [i][j];
	    			diaMin = j + 1;
	    		}
	    	}
	    	System.out.println("Para la provincia: " + nombreProvincias [i] + " el día con la tasa mas baja fue el día: " + diaMin);
	    }
	    
	    for (int i = 0; i < CANTIDADDIAS;i++) {
	    	provinciaMasAlta = nombreProvincias[0];
	    	datoMasAlto = datos[0][i];
	    	for(int j = 0; j < CANTIDADPROVINCIAS; j++) {
	    		if (datos [j][i] > datoMasAlto) {
	    			datoMasAlto = datos[j][i];
	    			provinciaMasAlta = nombreProvincias[j];
	    		}
	    	}
	    	System.out.println("El dato más alto del día: " + (i+1) + " es: " + provinciaMasAlta + " con una tasa de: " + datoMasAlto);
	    	
	    }
	    
	}
} 