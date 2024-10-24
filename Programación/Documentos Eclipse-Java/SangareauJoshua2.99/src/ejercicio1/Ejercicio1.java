/*
 * Diseña un programa en Java que permita monitorizar el nivel de agua de un embalse. El embalse tiene una capacidad fija máxima de 2.000 hm3 (hectómetros cúbicos).

El usuario deberá introducir por el teclado el volumen de agua embalsada en un momento determinado. A partir de esa cantidad, el programa calculará la cantidad de 
hectómetros cúbicos de agua que son necesarios para que el embalse se llene completamente. Igualmente, se calculará el porcentaje que corresponde la cantidad de agua embalsada respecto a 
la capacidad total del embalse.

Si el porcentaje actual de agua embalsada es superior al 95% de la capacidad total del embalse se realizará una liberación controlada de agua de un 10% del volumen de agua embalsada.
En este caso, se debe informar al usuario del porcentaje de liberación que se ha realizado, de cuántos hectómetros cúbicos se han vaciado en esa operación, cual es el volumen actual 
del depósito, y cuál es el porcentaje actual.

Por contra, si el porcentaje actual del embalse es inferior al 95% no se realizará ningún tipo de liberación. En este caso simplemente se mostrará el mensaje "No es necesario considerar 
la liberación controlada de agua en este momento."


Nota: No es necesario que controles valores incoherentes (volumen actual negativo o superior a la capacidad máxima del embalse).
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final short TOTALAGUA;
	    // Variables de entrada
		double liberacion10, cantidadAgua, porcentajeAgua, faltaAgua;
		TOTALAGUA = 2000;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca cantidad de hm3:");
	    cantidadAgua = teclado.nextInt();
	    
	    faltaAgua = TOTALAGUA - cantidadAgua;
	    
	    System.out.println("Falta " + faltaAgua + " hm3 para llenar el embalse");
	    
	    porcentajeAgua = (cantidadAgua*100)/2000;
	    
	    if (porcentajeAgua >= 95 ) {
	    	
	    	liberacion10 = cantidadAgua * 0.1;
	    	
	    	cantidadAgua = cantidadAgua - liberacion10;
	    	
	    	porcentajeAgua = (cantidadAgua*100)/2000;
	    	
	    	System.out.println("Se ha liberado el 10% de capacidad");
	    	System.out.println("La cantidad liberada ha sido: " + liberacion10 + " hm3");
	    	System.out.println("El volumen restante son: " + cantidadAgua + " hm3");
	    	System.out.println("El porcentaje restante es: " + porcentajeAgua + "%");
	    	
	    	
	    } else {
	    	System.out.println("No es necesario considerar la liberación controlada de agua en este momento.");
	    	System.out.println("El porcentaje restante es: " + porcentajeAgua + "%");
	    }
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   