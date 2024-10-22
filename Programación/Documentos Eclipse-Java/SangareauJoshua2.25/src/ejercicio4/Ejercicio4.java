/*4. Escribe un programa que calcule el salario semanal de un trabajador teniendo en cuenta
que las horas ordinarias (40 primeras horas de trabajo) se pagan a 12 euros la hora. A
partir de la hora 41, se pagan a 16 euros la hora.
 * 
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
		byte horas, horasNormales, horasExtra;
		horasNormales = 40;
	    // Variables de salida
		int salarioSemanal;
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca nº de horas trabajadas esta semana:");
	    
	    horas = teclado.nextByte();    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    if (horas <= 40) {
	    	
	    	salarioSemanal = horas * 12;
	    	
	    	System.out.println("Su salario semanal es: " + salarioSemanal);
	    	
	    } else {
	    	
	    	horasExtra = (byte)(horas - horasNormales);
	    	
	    	salarioSemanal = (horasNormales * 12) + (horasExtra * 16);
	    	
	    	System.out.println("Su salario semanal es: " + salarioSemanal);
	    }

	}

}
