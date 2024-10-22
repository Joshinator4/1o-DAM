/*
 * Crea un método llamado accesoBecaUsa. Este método recibe como parámetros los siguientes
datos:
 edad
 nota académica
 renta
 nivel de Idioma (Boolean)
El método analizará los datos recibidos y hará las siguientes comprobaciones:
 Si el nivel de idioma no es el requerido, devolverá: "No apto"
Página 2 de 4
DAM1/DAW1. Programación
 Si la edad es mayor de 30 devolverá: "No apto"
 Si cumple las condiciones anteriores se comprobará lo siguiente:
o Si la nota es superior a 9:" Apto"
o Si la nota es inferior a 5:" No Apto"
o Si la nota es 6, 7 u 8 y la renta menor a 20.000 "Apto", en caso contrario "No
apto".

 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		char respuestaIdioma;
		byte edad, nota;
		boolean idioma;
		double renta;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca su edad");
	    edad = teclado.nextByte();
	    
	    System.out.println("Introduzca su nota academica");
	    nota = teclado.nextByte();
	    
	    System.out.println("Introduzca su renta");
	    renta = teclado.nextDouble();
	    
	    System.out.println("Introduzca s/n si su nivel de idioma es el requerido (s) o no (n)");
	    respuestaIdioma = teclado.next().charAt(0);
	    
	    if(respuestaIdioma == 's') {
	    	idioma = true;
	    } else {
	    	idioma = false;
	    }

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	   System.out.println(accesoBecaUsa (edad, nota, renta, idioma));
	    
	    
	}
	public static String accesoBecaUsa (byte x, byte y, double z, boolean w) {
		String situacion = null;
		if (w == false) {
			situacion = "No Apto";
			
		} else if (x >=30) {
			situacion = "No Apto";
			
		} else {
			if(y >= 9 ) {
				situacion = "Apto";
				
			} else if (y < 5) {
				situacion = "No Apto";
				
			} else {
				if(y > 5 && y < 9 && z < 20000) {
					situacion = "Apto";
				} else {
					situacion = "No Apto";
				}
			}
		}
		
		return situacion;
		
	}
}