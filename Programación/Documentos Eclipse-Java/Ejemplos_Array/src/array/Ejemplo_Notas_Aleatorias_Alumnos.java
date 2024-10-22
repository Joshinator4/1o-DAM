package array;

import java.util.Scanner;

public class Ejemplo_Notas_Aleatorias_Alumnos {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int [] notas = new int [10];
		int acumulador;
		double media;
		acumulador = 0;
		media = 0;
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
	    
	    for (int i = 0; i < notas.length; i++) {
	    	
	    	notas [i] = (int)(Math.random()*10+1);
	    }
	    
	    for (int i = 0; i < notas.length; i++) {
	    	System.out.println("nota del alumno " + (i + 1)  + " es: " + notas [i]);
	    	acumulador += notas [i];
	    }
	    
	    media = (double)acumulador / notas.length;
	    
    	System.out.println("La media es: " + media);
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  