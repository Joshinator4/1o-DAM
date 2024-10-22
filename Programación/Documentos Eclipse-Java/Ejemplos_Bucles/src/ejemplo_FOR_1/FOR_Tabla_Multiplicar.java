package ejemplo_FOR_1;

import java.util.Scanner;

public class FOR_Tabla_Multiplicar {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
	    // Variables de salida
		int multiplicador, resultado;
		multiplicador = 7;
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    System.out.println("Tabla de multiplicar del " + multiplicador);
	    
	    for (int i = 1; i <= 10 ; i++) {
	    	
	    	resultado = i * multiplicador;
	    	System.out.println(i + " multiplicado por 7 = " + resultado);
	    }
	    
	    System.out.println(".............................. ");
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   