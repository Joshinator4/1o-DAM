/*
 * Realiza un programa que calcule el porcentaje de descuento que nos han hecho al comprar algo.
Se debe solicitar la cantidad sin descuento y la cantidad con el descuento aplicado. Se debe
crear una función a la que le pasemos ambos valores y nos devuelva el descuento (en %).
 */
package ejercicio13;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		double numeroSinDescuento, numeroConDescuento;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca la cantidad sin descuento");
	    numeroSinDescuento = teclado.nextDouble();
	    
	    System.out.println("Introduzca la cantidad con descuento ya aplicado");
	    numeroConDescuento = teclado.nextDouble();

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    System.out.println("El porcentaje de descuento realizado es el " + sacarPorcentajeDescuento (numeroSinDescuento, numeroConDescuento) + "%");
	    
	    
	    
	}
	
	public static double sacarPorcentajeDescuento(double x, double y) {
		double porcentaje;
		porcentaje = 100 - ((y * 100) / x);
		return porcentaje;
	
	}
} 