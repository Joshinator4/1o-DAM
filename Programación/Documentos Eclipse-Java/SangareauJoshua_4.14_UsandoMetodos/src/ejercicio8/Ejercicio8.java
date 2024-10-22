/*
 * Escribe un programa que pida un valor N entero y luego muestre: el sumatorio desde 1 a N, el
productorio de 1 a N y el valor intermedio entre 1 y N. Implementa y utiliza las funciones:
int suma1aN(int n) // Devuelve la suma de enteros de 1 a n
int producto1aN(int n) // Devuelve el producto de enteros de 1 a n
double intermedio1aN(int n) // Devuelve el valor intermedio entre 1 y n
 */
package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numeroIntroducido;
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
	    System.out.println("Introduzca un numero N:");
	    numeroIntroducido = teclado.nextInt();
	    
 	    System.out.println("El sumatorio del número N introducido es: " + suma1aN(numeroIntroducido) + ", el productorio es: " + producto1aN(numeroIntroducido) +
 	    		" y el numero intermedio de 1 y N es: " + intermedio1aN(numeroIntroducido));
	    
	}
	
	public static int suma1aN(int x) {
		int sumatorio = 1;
		for (int i = 2; i <= x; i++) {
			sumatorio += i;
		}
		return sumatorio;
	}
	
	public static int producto1aN(int x) {
		int productorio = 1;
		for(int i = 2; i <= x ; i++) {
			productorio *= i;
		}
		return productorio;
	}
	
	public static double intermedio1aN(int x) {
		double intermedio;
		intermedio = (double)(x + 1)/2;
		return intermedio;
	}
}  