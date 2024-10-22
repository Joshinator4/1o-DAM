/*
 * Crea un programa para realizar cálculos relacionados con la altura (en metros) de personas.
Pedirá un valor N y luego almacenará en un array N alturas introducidas por teclado. Luego
mostrará la altura media, máxima y mínima así como cuántas personas miden por encima y
por debajo de la media.
 */
package ejercicio10;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int medirPersonas, contadorEncima, contadorDebajo;
		double sumaAlturas, mediaAltura, alturaMaxima, alturaMinima;
		sumaAlturas = 0;
		alturaMaxima = 0;
		alturaMinima = 10;
		contadorEncima = 0;
		contadorDebajo = 0;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("Introduzca el numero de personas que desa medir: ");
	    medirPersonas = teclado.nextInt();
	    double [] medidas = new double [medirPersonas];
	   
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    for (int i = 0; i < medirPersonas; i++) {
	    	System.out.println("Introduzca la altura de la persona " + i);
	    	medidas [i] = teclado.nextDouble();
	    	sumaAlturas += medidas [i];
	    }
	    
	    mediaAltura = sumaAlturas / medirPersonas;
	    
	    
	    for (int i = 0; i < medirPersonas; i++) {
	    	
	    	if(medidas [i] < alturaMinima) {
	    		alturaMinima = medidas [i];
	    	}
	    	
	    	if (medidas [i] > alturaMaxima) {
	    		alturaMaxima = medidas [i];
	    	}
	    	
	    	if (medidas [i] < mediaAltura) {
	    		contadorDebajo++;
	    		
	    	} else if (medidas [i] > mediaAltura) {
	    		contadorEncima++;
	    	} 
	    }
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    System.out.println("La media de altura es: " + mediaAltura);
	    System.out.println("La altura máxima es: " + alturaMaxima);
	    System.out.println("La altura mínima es: " + alturaMinima);
	    System.out.println("La cantidad de medidas por encima de la media es: " + contadorEncima);
	    System.out.println("La cantidad de medidas por debajo de la media es: " + contadorDebajo);
	    
	}
}   