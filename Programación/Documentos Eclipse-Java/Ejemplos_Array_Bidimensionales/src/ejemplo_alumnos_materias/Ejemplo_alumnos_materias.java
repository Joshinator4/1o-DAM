package ejemplo_alumnos_materias;

import java.util.Scanner;

public class Ejemplo_alumnos_materias {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte ALUMNOS_TAMANNO = 15;
		final byte ASIGNATURAS_TAMANNO = 7;
	    // Variables de entrada
		double [] [] arrayNotas = new double [ALUMNOS_TAMANNO] [ASIGNATURAS_TAMANNO];
		double notaMax;
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
	    
	    for (int alumno = 0; alumno < ALUMNOS_TAMANNO; alumno++) {
	    	for (int asignatura = 0; asignatura < ASIGNATURAS_TAMANNO; asignatura++) {
	    		arrayNotas[alumno] [asignatura] = Math.ceil(Math.random()*100-1)/10;
	    		System.out.println("La nota del alumno " + alumno + " de la asignatura: " + asignatura + " es: " + arrayNotas[alumno][asignatura]);
	    	}
	    }
	    
	   
	    
	    for (int asignatura = 0; asignatura < ASIGNATURAS_TAMANNO; asignatura++) {
	    	notaMax = arrayNotas[0][asignatura];
	    	for (int alumno = 0; alumno < ALUMNOS_TAMANNO; alumno++) {
	    		if (arrayNotas[alumno][asignatura] >= notaMax) {
	    			notaMax = arrayNotas[alumno][asignatura];
	    		}
	    	}
	    	for (int alumno = 0; alumno < ALUMNOS_TAMANNO; alumno++) {
	    		if(arrayNotas[alumno][asignatura] == notaMax) {
	    			System.out.println("EL alumno " + alumno + " tiene la nota máxima en la asignatura: " + asignatura + ". La nota máxima es: " + notaMax);
	    		}
	    	}
	    }
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  