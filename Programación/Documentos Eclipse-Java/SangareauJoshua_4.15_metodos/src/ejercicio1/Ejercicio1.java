/*
 * Crea un método llamado comparaNombres, el cual devolverá el booleano true en el caso de
que los dos nombres introducidos como parámetros sean iguales y false en caso contrario.
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		boolean nombres;
		String nombre1, nombre2;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("introduzca el primer nombre:");
	    nombre1 = teclado.nextLine();

	    System.out.println("introduzca el segundo nombre:");
	    nombre2 = teclado.nextLine();
	    
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    nombres = comparaNombres(nombre1, nombre2);
	    
	    if(nombres == true) {
	    	System.out.println("Los nombres son iguales (ignorando las mas mayúsculas)");
	    } else {
	    	System.out.println("Los nombres no son iguales");
	    }
	    
	    
	}
	
	public static boolean comparaNombres (String x, String y) {
		boolean nombres;
		if(x.equalsIgnoreCase(y)) {
			nombres = true;
		} else {
			nombres = false;
		}
		
		return nombres;
	}
}