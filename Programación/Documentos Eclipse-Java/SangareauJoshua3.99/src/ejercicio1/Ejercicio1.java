/*
 * Objetivo:Disponemos de una tabla con los resultados de 6 seis partidos de fútbol de primera división. En la primera columna está el número de goles marcados por el equipo que juega como local y en la segunda columna el número de goles del equipo visitante. Para facilitar las pruebas, el número de goles será un número aleatorio entre 0 y 5.

Crea una aplicación que solicite una apuesta para cada uno de los seis partidos:

1: gana el equipo local.
X: empate.
2: gana el equipo visitante.
A continuación, el programa informará del número de aciertos de la apuesta y mostrará la combinación ganadora, indicando los aciertos y los fallos de la apuesta del usuario.

Consideraciones:

No hay que validar las entradas de datos.
Opcionalmente, se podrá incluir el nombre de los equipos participantes.
Solo se podrán usar las clases System y Scanner.

 * Autor: Joshua Sangareau Quesada
 * fecha: 17/11/2023
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte NUMPARTIDOS=6, LOCALVISITANTE=2, CANTIDADEQUIPOS=12;
	    // Variables de entrada
		String quiniela;
		char quinielaCaracter, victoriaCaracter;
		int[][] resultados = new int [NUMPARTIDOS][LOCALVISITANTE]; 
		String [] victoria = new String [NUMPARTIDOS];
		int acertado=0, fallo=0;
		//este array sería para los nombres del equipo (no me da tiempo a hacerlo)
		String [] nombreEquipos = new String [CANTIDADEQUIPOS];
		
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

	    
	    //Este bucle genera resultados aleatorios y da los resultados
	    for(int equipo = 0; equipo < NUMPARTIDOS; equipo++) {
	    	for(int locVisitantente = 0; locVisitantente < LOCALVISITANTE; locVisitantente++) {
	    		resultados [equipo][locVisitantente] = (int)(Math.random()*5);
	    	}
	    	System.out.println("El resultado del partido " + (equipo+1) + " es: " + resultados [equipo][0] + "-" + resultados [equipo][1]);
	    }
	    
	    
	    //Le damos instrucciones al usuario de como introducir la quiniela
	    System.out.println("Introduzca :");
    	System.out.println("1: gana el equipo local.");
    	System.out.println("X empate.");
    	System.out.println("2: gana el equipo visitante.");
    	
    	//este bucle recorre los resultados para generar 1, x o 2 para la quiniela.
    	for(int equipo = 0; equipo < NUMPARTIDOS; equipo++) {
    		if (resultados [equipo][0] > resultados [equipo][1]) {
    			victoria [equipo] = "1";
    		}  else if (resultados [equipo][0] == resultados [equipo][1]) {
    			victoria [equipo] = "x";
    		} else {
    			victoria [equipo] = "2";
    		}
    	}
    	
    	
    	//Este bucle pide la quiniela al usuario y recorre la combinación ganadora para saber numero de aciertos y fallos
	    for(int equipo = 0; equipo < NUMPARTIDOS; equipo++){
	    	System.out.println("Introduzca resultado del partido " + (equipo + 1));
	    	quiniela = teclado.next();
	    	quinielaCaracter = quiniela.charAt(0);
	    	victoriaCaracter = victoria [equipo].charAt(0);
	    	if (quinielaCaracter == victoriaCaracter) {
	    		acertado++;
	    	} else {
	    		fallo++;
	    	}
	    				
	    }
	    
	    //Por ultimo imprimimos resultados
	    System.out.println("la combinanación ganadora es: ");
	    for (int i = 0; i < NUMPARTIDOS; i++) {
	    	System.out.println("La combinación ganadora es: " + victoria [i]);
	    }
	    
	    System.out.println("El numero de aciertos es: " + acertado + " y el número de fallos es: " + fallo);
	    
	    	
	    
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   