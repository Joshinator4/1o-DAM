/*
 * Se necesita un programa que solicite el nombre de alumnos y la nota de 4 materias para N alumnos
(solicitado por teclado y mayor de 5).
El programa mostrará:
a) la nota obtenida por cada alumno en cada materia. La salida será la siguiente:
Nombre Matemáticas Lengua Inglés Filosofía
----------------------------------------------------------------------------
Alberto     6         5      4       7
…….
b) la nota media de cada materia.
c) Para cada materia, el nombre del alumno con la nota más alta.
d) Número de aprobados y suspensos para cada materia.
e) (Opcional) Para cada materia, ranking con los tres alumnos (sus nombres y nota) con
mejores notas.
Para simplificar:
• No hay que controlar el valor de N.
Por último, debes tener en cuenta que:
• se valorará que se minimice el número de líneas y condiciones. Intenta utilizar los
operadores lógicos para que el código sea lo más claro, legible y eficiente posible.
• procura evitar verificaciones innecesarias.
• las únicas clases y métodos que puedes usar en el programa son los de System y Scanner,
que utilizamos para la E/S por consola. Aparte de éstas, no puedes usar ninguna otra clase,
método o herramienta, ni de la API de Java ni propia, para resolver el ejercicio.
 */
package ejercicio_materias_alumnos_Extendido;

import java.util.Scanner;

public class Ejercicio_materias_alumnos_Extendido {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final int CANTIDAD_ALUMNOS, MATERIAS = 4;
	    // Variables de entrada
		double sumaAsignatura, mediaAsignatura;
		byte contadorAprobados, contadorSuspensos;
		int notaMax, notaMax2, notaMax3;
		String nombreNotaMax, nombreNotaMax2, nombreNotaMax3;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("Introduzca cantidad de alumnos");
	    CANTIDAD_ALUMNOS = teclado.nextInt();    
	    
	    teclado.nextLine();
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    int [][] notas = new int [CANTIDAD_ALUMNOS][MATERIAS];
	    String [] alumnos = new String [CANTIDAD_ALUMNOS];
	    String [] asignaturas = new String [MATERIAS];
	    asignaturas [0] = "Matematicas";
	    asignaturas [1] = "Lengua";
	    asignaturas [2] = "Inglés";
	    asignaturas [3] = "Filosofía";
	    
	    //bucle para pedir nombre de cada alumno (i) notas de cada asignatura (j)
	    for (int i = 0; i < CANTIDAD_ALUMNOS; i++) {
	    	System.out.println("Introduzca el nombre del alumno");
	    	alumnos [i] = teclado.nextLine();
	    
	    	for(int j = 0; j < MATERIAS; j++) {
	    		
	    		System.out.println("Introduzca la nota de la asignatura " + asignaturas[j]);
	    		notas [i][j] = teclado.nextInt();
	    	}
	    	teclado.nextLine();
	    	
	    }
	    
	    //bucle para mostrar por pantalla las notas
	    
	    System.out.println("Nombre     | Matematicas    |   lengua     |  Inglés     | Filosofía  ");
	    System.out.println("--------------------------------------------------------");
	    for (int i = 0; i < CANTIDAD_ALUMNOS; i++) {
	    	System.out.print(alumnos [i] + "\t" + "\t");
	    	for (int j = 0; j < MATERIAS; j++) {
	    		System.out.print(notas[i][j] + "\t" + "\t");
	    	} 
	    	System.out.println();
	    }
	   
	    //bucle para hacer la media. Suma todas las notas de cada asignatura y las divide entre el numero de alumnos
	    for (int i = 0; i < MATERIAS; i++) {
	    	mediaAsignatura = 0;
	    	sumaAsignatura = 0;
	    	for (int j = 0; j < CANTIDAD_ALUMNOS; j++) {
	    		sumaAsignatura += notas [j][i];
	    	}	
	    	mediaAsignatura = sumaAsignatura / CANTIDAD_ALUMNOS;
	    	System.out.println("La media de la asignatura " + asignaturas [i] + " es: " + mediaAsignatura);
	    }
	    
	    
	    //bucle para mostrar quien tiene la nota más alta y cual es
	    for(int i = 0 ; i < MATERIAS; i++) {
	    	nombreNotaMax = alumnos [0];
	    	notaMax = notas[0][i];
	    	for (int j = 0; j < CANTIDAD_ALUMNOS; j++) {
	    		if (notas [j][i] > notaMax) {
	    			notaMax = notas [j][i];
	    			nombreNotaMax = alumnos [j];
	    		} 
	    		
	    	}
	    	System.out.println("El alumno que tiene la nota más alta en la asignatura " + asignaturas[i] + " es: " + nombreNotaMax + " con una nota de: " + notaMax); 
	    }
	    
	    
	    //bucle para mostrar el número de aprobados y suspensos
	    for (int i = 0; i < MATERIAS; i++) {
	    	contadorAprobados = 0;
	    	contadorSuspensos = 0;
	    	for(int j = 0; j < CANTIDAD_ALUMNOS; j++) {
	    		if(notas[j][i] > 4) {
	    			contadorAprobados++;
	    		} else {
	    			contadorSuspensos++;
	    		}
	    	}
	    	System.out.println("la cantidad de alumnos aprobados en la asignatura " + asignaturas [i] + " es: " + contadorAprobados);
	    	System.out.println("la cantidad de alumnos suspensos en la asignatura " + asignaturas [i] + " es: " + contadorSuspensos);
	    	
	    }
	    
	    //bucle para el ranking
	    for(int i = 0; i < MATERIAS; i++) {
	    	nombreNotaMax = alumnos [0];
	    	nombreNotaMax2 = alumnos [0];
	    	nombreNotaMax3 = alumnos [0];
	    	notaMax = 0;
	    	notaMax2 = 0;
	    	notaMax3 = 0;
	    	for (int j = 0; j < CANTIDAD_ALUMNOS; j++) {
	    		if(notas [j][i] >= notaMax) {
	    			notaMax3 = notaMax2;
	    			nombreNotaMax3 = nombreNotaMax2;
	    			notaMax2 = notaMax;
	    			nombreNotaMax2 = nombreNotaMax;
	    			notaMax = notas [j][i];
	    			nombreNotaMax = alumnos [j];
	    		} else if (notas[j][i] >= notaMax2) {
	    			notaMax3 = notaMax2;
	    			nombreNotaMax3 = nombreNotaMax2;
	    			notaMax2 = notas [j][i];	
	    			nombreNotaMax2 = alumnos [j];
	    		} else if (notas[j][i] >= notaMax3) {
	    			notaMax3 = notas [j][i];
	    			nombreNotaMax3 = alumnos [j];
	    		}
	    	}
	    	System.out.println("El ranking de la asignatura: " + asignaturas[i] + " es: 1º " + nombreNotaMax + " con una nota de " + notaMax + ", 2º: " + nombreNotaMax2 + " con una nota de "
	    	+ notaMax2 + ", 3º: " + nombreNotaMax3 + " con una nota de " + notaMax3);
	    }
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  