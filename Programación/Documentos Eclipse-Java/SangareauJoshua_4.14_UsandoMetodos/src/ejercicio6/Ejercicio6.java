/*
 * Escribe un programa que pida cinco precios y muestre por pantalla el precio de venta de cada
uno tras aplicarle un 21% de IVA. Implementa y utiliza la función:
double precioConIVA(double precio) // Devuelve el precio tras sumarle un 21% de IVA

 */
package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		double precioIntroducido;
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
	    
	    for(int i = 0; i < 5; i++) {
	    	System.out.println("Introduzca un el precio " + (i+1) + "para aplicarle el 21% de IVA");
	    	precioIntroducido = teclado.nextDouble();
	    	
	    	System.out.println("El precio introducido con IVA es: " + precioConIVA(precioIntroducido));
	    	
	    }
	   
	}
	
	public static double precioConIVA (double x) {
		double precioIva; 
		precioIva = (x * 0.21) + x;
		return precioIva;
	}
}  