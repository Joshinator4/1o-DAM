package ejemplo_temperaturas;

import java.util.Scanner;

public class Ejemplo_temperaturas {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte DIA_TOTAL = 31;
		final byte MES_TOTAL = 12;
	    // Variables de entrada
		int [] [] temperaturas = new int [MES_TOTAL] [DIA_TOTAL];
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
	    
	    for (int mes = 0; mes < MES_TOTAL; mes++) {
	    	
	    	for (int dia = 0; dia < DIA_TOTAL; dia++) {
	    		temperaturas [mes] [dia] = (int)(Math.random()*41);
	    		
	    	}
	    	
	    }
	    
	    for (int mes = 0; mes < MES_TOTAL; mes++) {
	    	
	    	System.out.print("temeperaturas del mes " + mes + ": ");
	    	for (int dia = 0; dia < DIA_TOTAL; dia++) {
	    		
	    		System.out.print(temperaturas [mes] [dia] + " ");
	    	}
	    	System.out.println();
	    	
	    }
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  