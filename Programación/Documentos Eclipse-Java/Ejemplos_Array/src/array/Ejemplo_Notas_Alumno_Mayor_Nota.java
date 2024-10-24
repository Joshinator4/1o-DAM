package array;

import java.util.Scanner;

public class Ejemplo_Notas_Alumno_Mayor_Nota {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int [] notas = new int [10];
		int acumuladorAprobados, acumuladorSuspensos, notaMayor, alumno;
		double mediaSuspensos, mediaAprobados;
		acumuladorAprobados = 0;
		acumuladorSuspensos = 0;
		mediaSuspensos = 0;
		mediaAprobados = 0;
		notaMayor = 0;
		alumno = 1;
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
	    notaMayor = notas [0];
	    
	    for (int i = 1; i < notas.length; i++) {
	    	
	    	if (notas [i] > notaMayor) {
	    		notaMayor = notas [i];
	    		alumno = i;
	    	}
	    }
	    
	    for (int i = 1; i < notas.length; i++) {
	    	if(notas [i] == notaMayor) {
	    		System.out.println("El alumno " + i + " Tiene la nota mayor " + notaMayor);
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