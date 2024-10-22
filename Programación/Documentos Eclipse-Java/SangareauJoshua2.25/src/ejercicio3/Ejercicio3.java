/*
 * Escribe un programa en que dado un número del 1 a 7 escriba el correspondiente nombre
del día de la semana
 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {
	
	public static void main(String[] args) {
	//----------------------------------------------
    //          Declaración de variables 
    //----------------------------------------------
	
    // Constantes
    // Variables de entrada
	byte dia;
    // Variables de salida
    // Variables auxiliares
    // Clase Scanner para petición de datos
	
    Scanner teclado = new Scanner(System.in);
    
    //----------------------------------------------
    //                Entrada de datos 
    //----------------------------------------------
    
    System.out.println("Introduzca nº del 1-7:");
    
    dia = teclado.nextByte();

    //----------------------------------------------
    //                 Procesamiento 
    //----------------------------------------------
    
    switch (dia) {
    
    case (1):{
    	System.out.println("Lunes");	
	break;
    	
    } case (2):{
    	System.out.println("Martes");
    break;
    	
    } case (3):{
    	System.out.println("Miércoles");
    break;
    	
    } case (4):{
    	System.out.println("Jueves");
    break;
    	
    } case (5):{
    	System.out.println("Viernes");
    break;
    	
    } case (6):{
    	System.out.println("Sábado");
    break;
    	
    } default: {
    	
    	System.out.println("Domingo");
    	
    }
    }
  }
}
