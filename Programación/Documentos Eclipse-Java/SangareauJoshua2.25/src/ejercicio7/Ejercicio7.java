/*
 * 7. Escribe un programa que nos diga el horóscopo a partir del día y el mes de nacimiento.
 */
package ejercicio7;

import java.util.Scanner;

public class Ejercicio7 {
		
		public static void main(String[] args) {
			//----------------------------------------------
		    //          Declaración de variables 
		    //----------------------------------------------
			
		    // Constantes
		    // Variables de entrada
			byte dia;
			String mes;
		    // Variables de salida
		    // Variables auxiliares
		    // Clase Scanner para petición de datos
			
		    Scanner teclado = new Scanner(System.in);
		    
		    //----------------------------------------------
		    //                Entrada de datos 
		    //----------------------------------------------
		    System.out.println("Introduzca su mes de nacimiento en letras: ");
		    mes = teclado.nextLine();
		    
		    System.out.println("Introduzca su dia de nacimiento ");
		    dia = teclado.nextByte();

		    //----------------------------------------------
		    //                 Procesamiento 
		    //----------------------------------------------
		    
		    mes = mes.toLowerCase();
		    
		    switch (mes) {
		    
		    case ("enero"):
		    	if (dia < 21 ) {
		    		System.out.println("Eres Capricornio");
		    	} else {
		    		System.out.println("Eres Acuario");
		    	} 
	    	break;
	    	
		    case ("febrero"):
		    	if (dia < 19 ) {
		    		System.out.println("Eres Acuario");
		    	} else {
		    		System.out.println("Eres Piscis");
		    	} 
	    	break;
	    	
		    case ("marzo"):
		    	if (dia < 21 ) {
		    		System.out.println("Eres Piscis");
		    	} else {
		    		System.out.println("Eres Aries");
		    	} 
	    	break;
		    
		    case ("abril"):
		    	if (dia < 21 ) {
		    		System.out.println("Eres Aries");
		    	} else {
		    		System.out.println("Eres Tauro");
		    	} 
	    	break;
	    	
		    case ("mayo"):
		    	if (dia < 21 ) {
		    		System.out.println("Eres Tauro");
		    	} else {
		    		System.out.println("Eres Géminis");
		    	} 
	    	break;
	    	
		    case ("junio"):
		    	if (dia < 21 ) {
		    		System.out.println("Eres Géminis");
		    	} else {
		    		System.out.println("Eres Cáncer");
		    	} 
	    	break;
	    	
		    case ("julio"):
		    	if (dia < 23 ) {
		    		System.out.println("Eres Cáncer");
		    	} else {
		    		System.out.println("Eres Leo");
		    	} 
		    break;
		    
		    case ("agosto"):
		    	if (dia < 23 ) {
		    		System.out.println("Eres Leo");
		    	} else {
		    		System.out.println("Eres Virgo");
		    	} 
	    	break;
	    	
		    case ("septiembre"):
		    	if (dia < 23 ) {
		    		System.out.println("Eres Virgo");
		    	} else {
		    		System.out.println("Eres Libra");
		    	} 
	    	break;
	    	
		    case ("octubre"):
		    	if (dia < 23 ) {
		    		System.out.println("Eres Libra");
		    	} else {
		    		System.out.println("Eres Escorpio");
		    	} 
	    	break;
	    	
		    case ("noviembre"):
		    	if (dia < 24 ) {
		    		System.out.println("Eres Escorpio");
		    	} else {
		    		System.out.println("Eres Sagitario");
		    	} 
	    	break;
	    	
		    case ("diciembre"):
		    	if (dia < 22 ) {
		    		System.out.println("Eres Sagitario");
		    	} else {
		    		System.out.println("Eres Capricornio");
		    	} 
	    	break;
		    }
		    
		    
		    //----------------------------------------------
		    //              Salida de resultados 
		    //----------------------------------------------
		    
		    
		
	} 
}