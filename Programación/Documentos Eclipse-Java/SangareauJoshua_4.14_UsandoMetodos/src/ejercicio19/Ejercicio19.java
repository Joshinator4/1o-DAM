/*
 * Realiza un programa que permita comprobar si una terna de valores enteros (3 valores) se ajusta
a la ecuación de Pitágoras: x ² + y ² = z ². El programa solicita al usuario los valores x, y, z. Se
deberá crear una función a la que se le pase x, y, z y devuelva si son iguales o no.
Por ejemplo: 3 ² + 4 ² = 5 ².
 */
package ejercicio19;

import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numeroIntroducido1, numeroIntroducido2, numeroIntroducido3;
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
	    System.out.println("Introduzca el primero de 3 valores (este será el valor del cateto grande)");
	    numeroIntroducido1 = teclado.nextInt();
	    
	    System.out.println("Introduzca el segundo de 3 valores (este será el valor del cateto pequeño)");
	    numeroIntroducido2 = teclado.nextInt();
	    
	    System.out.println("Introduzca el tercero de 3 valores (este será el valor de la hipotenusa)");
	    numeroIntroducido3 = teclado.nextInt();
	    
	    if (sacarSiSeCumplePitagoras(numeroIntroducido1, numeroIntroducido2, numeroIntroducido3)) {
	    	System.out.println("Se cumple Pitágoras");
	    } else {
	    	System.out.println("No se cumple Pitágoras");
	    }
	}
	
	public static boolean sacarSiSeCumplePitagoras(int x, int y, int z) {
		boolean seCumplePitagoras = false;
		if (Math.pow(x, 2) + Math.pow(y, 2) == Math.pow(z, 2)) {
			seCumplePitagoras = true;
		}else {
			seCumplePitagoras = false;
		}
		return seCumplePitagoras;
		
	}
}