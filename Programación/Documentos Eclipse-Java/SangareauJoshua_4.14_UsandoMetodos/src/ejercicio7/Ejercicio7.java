/*
 * Escribe un programa que pida el ancho y alto de un rectángulo y muestre por pantalla su área y
su perímetro. Implementa y utiliza las funciones:
double perimetroRectangulo(double ancho, double alto) // Devuelve el perímetro
double areaRectangulo(double ancho, double alto) // Devuelve el área
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
		double ancho, alto;
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
	    
	    System.out.println("Introduzca el ancho del retangulo");
	    ancho = teclado.nextDouble();
	    
	    System.out.println("Introduzca el alto del retangulo");
	    alto = teclado.nextDouble();
	    
	    System.out.println("El área del rectángulo es: " + areaRectangulo (ancho, alto) + " y el perímetro del rectángulo es: " + perimetroRectangulo(ancho, alto));
	    
	    
	}
	
	public static double areaRectangulo(double x, double y) {
		double area;
		area = x * y;
		return area;
	}
	
	public static double perimetroRectangulo(double x, double y) {
		double perimetro;
		perimetro = 2 * (x + y);
		return perimetro;
	}
}  