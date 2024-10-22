package array;

import java.util.Scanner;

public class Ejemplo_Notas_Suspensos_Aprobados {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int [] notas = new int [10];
		int acumuladorAprobados, acumuladorSuspensos;
		double mediaSuspensos, mediaAprobados;
		acumuladorAprobados = 0;
		acumuladorSuspensos = 0;
		mediaSuspensos = 0;
		mediaAprobados = 0;
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
	    	System.out.println("El numero generado es: " + notas [i]);
	    	
	    	if (notas [i] < 5) {
	    		acumuladorSuspensos++;
	    		mediaSuspensos += notas [i];
	    	} else {
	    		acumuladorAprobados++;
	    		mediaAprobados += notas[i];
	    	}
	    }
	    
	    mediaAprobados = (double)mediaAprobados / acumuladorAprobados;
	    mediaSuspensos = (double)mediaSuspensos / acumuladorSuspensos;
	    
	    if (acumuladorAprobados > 0 ) {
	    	System.out.println("La media de los aprobados es: " + mediaAprobados);
	    }else {
	    	System.out.println("No se puede hacer la media");
	    }
	    
	    if (acumuladorSuspensos > 0 ) {
	    	System.out.println("La media de los suspensos es: " + mediaSuspensos);
	    } else {
	    	System.out.println("No se puede hacer la media");
	    }
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  