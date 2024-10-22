package array_Billetes;

import java.util.Scanner;

public class Array_Billetes {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int cantidadIntroducida, restoBilletes, cantidadBilletes;
		int[] billetes = {500, 200, 100, 50, 20, 10, 5};
		restoBilletes = 1;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("Introduzca una cantidad múltiplo de 5:");
	     cantidadIntroducida = teclado.nextInt();
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	     
	     for (int i = 0; i < billetes.length; i++) {
	    	 cantidadBilletes = cantidadIntroducida / billetes [i];
	    	 System.out.println(cantidadBilletes + " billetes de " +billetes [i]);
	    	 cantidadIntroducida = cantidadIntroducida % billetes [i];
	     }
	     
	     
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
} 