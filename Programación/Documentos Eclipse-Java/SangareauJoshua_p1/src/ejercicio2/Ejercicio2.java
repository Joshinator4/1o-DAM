package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		//declaramos una variable contador (i) y la inicializamos a 100 para que sea entre 100 y 400
		int i;
		i = 100;
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
	    
	    //Generamos un bucle while debido a que no sabemos cuantas veces se repetirá, dentro del bucle generamos condición if para múltiplos de 5 con la funcion % (resto de la división) = 0 para saber que es múltiplo
	    //y la función && i % 15 != 0  para que nos diga los múltiplos de 5 pero no de 15
	    //y un else if  para los múltiplos de 15 con la misma función.
	    //Ambos múltiplos se mostrarán.
	    //Generamos un else if para los múltiplos de 9 igual que en el caso anterior, se imprimirá en pantalla
	    
	    
	    while (i >= 100 && i <= 400) {
	    	if (i % 5 == 0 && i % 15 != 0) {
	    		System.out.println("Este numero es multiplo de 5 y no de 15: " + i);
	
  
    		} else if (i % 15 == 0) {
    			System.out.println("Este número es múltiplo de 5 y de 15: " + i);
    		} else if (i % 9 == 0) {
    			System.out.println("Este número es múltiplo de 9: " + i);
    		}
	    	//hacemos que el contador sume 1 en cada vuelta del bucle para que vaya desde 100 al 400
	    	i++;
	    }
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	      
			
	}
}