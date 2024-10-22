package ejemplo_While;

import java.util.Scanner;

public class Ejemplo_While_Tabla_Multiplicar {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numeroTabla;
		numeroTabla = 1;
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
	    
	    while (numeroTabla <= 10) {
	    	
	    	System.out.println(numeroTabla + " multiplicado por 7= " + numeroTabla*7);
	    	numeroTabla++;
	    	
	    }
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   