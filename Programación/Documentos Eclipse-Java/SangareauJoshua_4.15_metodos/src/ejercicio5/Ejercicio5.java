/*
 * Crea un método posicionJugador. Este método recibe como parámetro un número entero y
devuelve una cadena de texto.
Comprobaremos que el número se encuentra entre 1 y 16, en caso contrario devolveremos un
mensaje: Número introducido incorrecto.
El programa asigna una posición en un hipotético campo de juego en función del número
recibido:
1-Portero,
del 2 al 5 defensas,
6 al 8 centrocampistas,
del 9 al 11 delanteros,
del 12 al 16 suplentes.
El programa pedirá el nombre al usuario de forma que el mensaje sea:
Luis, con el dorsal 8 juega el próximo partido como centrocampista.
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

		public static void main(String[] args) {
			//----------------------------------------------
		    //          Declaración de variables 
		    //----------------------------------------------
			
		    // Constantes
		    // Variables de entrada
			byte dorsal;
			String nombreJugador;
		    // Variables de salida
		    // Variables auxiliares
		    // Clase Scanner para petición de datos
			
		    Scanner teclado = new Scanner(System.in);
		    
		    //----------------------------------------------
		    //                Entrada de datos 
		    //----------------------------------------------
		    
		    System.out.println("Introduzca el numero del dorsal del jugador");
		    dorsal = teclado.nextByte();
		    
		    teclado.nextLine();
		    
		    if (dorsal > 0 && dorsal < 17) {
		    	System.out.println("Introuduzca el nombre del jugador");
		    	nombreJugador = teclado.nextLine();
		    	System.out.println(nombreJugador + " con el dorsal " + dorsal + " juega el próximo partido como " + posicionJugador(dorsal));
		    } else {
				System.out.println("Número introducido incorrecto.");
			}

		    //----------------------------------------------
		    //                 Procesamiento 
		    //----------------------------------------------
		    
		  
		    
		}
		
	public static String posicionJugador(int x) {
		String posicion = null;
		
		switch (x) {
			case 1: {
				posicion = "portero";
				break;
			}
			case 2, 3, 4, 5: {
				posicion = "defensa";
				break;
			}
			case 6, 7, 8: {
				posicion = "centrocampista";
				break;
			}
			case 9, 10, 11: {
				posicion = "delantero";
				break;
			}
			default: {
				posicion = "suplente";
			}
		}
		return posicion;
			

	}
}
