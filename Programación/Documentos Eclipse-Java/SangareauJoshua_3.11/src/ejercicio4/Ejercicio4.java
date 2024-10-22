/*
 * Necesitamos crear un programa para almacenar las notas de 4 alumnos (llamados “Alumno
1”, “Alumno 2”, etc.) y 5 asignaturas. El usuario introducirá las notas por teclado y luego el
programa mostrará la nota mínima, máxima y media de cada alumno.
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte TAMANNO_ALUMNOS = 4, TAMANNO_ASIGNATURAS = 5;
	    // Variables de entrada
		double [][] notas = new double [TAMANNO_ALUMNOS][TAMANNO_ASIGNATURAS];
		double notaIntroducida, notaMax, notaMin, notaMedia, sumaMedia = 0;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    for (int alumno = 0; alumno < TAMANNO_ALUMNOS; alumno++) {
	    	for(int asignatura = 0; asignatura < TAMANNO_ASIGNATURAS; asignatura++) {
	    		System.out.println("Introduzca la nota del alumno " + (alumno + 1) + " de la asignatura " + (asignatura + 1));
	    		notaIntroducida = teclado.nextDouble();
	    		notas [alumno][asignatura] = notaIntroducida;
	    	}
	    }
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    for (int alumno = 0; alumno < TAMANNO_ALUMNOS; alumno++) {
	    	notaMax = notas[alumno][0];
		    notaMin = notas [alumno] [0];
		    sumaMedia = notas [alumno][0];
		    
		    for (int asignatura = 1; asignatura < TAMANNO_ASIGNATURAS; asignatura++) {
		    	if (notas[alumno][asignatura] > notaMax) {
		    		notaMax = notas[alumno][asignatura];
		    	} 
		    	
		    	if (notas[alumno][asignatura] < notaMin) {
		    		notaMin = notas[alumno][asignatura];
		    	}
		    	sumaMedia += notas[alumno][asignatura];
		    }
		    
		    notaMedia = sumaMedia / TAMANNO_ASIGNATURAS;
		    
		    System.out.println(" La nota mas alta del alumno " + (alumno + 1) + " es: " + notaMax);
		    System.out.println(" La nota mas baja del alumno " + (alumno + 1) + " es: " + notaMin);
		    System.out.println(" La nota media del alumno " + (alumno + 1) + " es: " + notaMedia);
		    
		    
	    }
	    
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   