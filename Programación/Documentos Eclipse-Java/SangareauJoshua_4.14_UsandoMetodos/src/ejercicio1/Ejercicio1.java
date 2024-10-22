/*Escribe un programa que pida dos números reales por teclado y muestre por pantalla el
resultado de multiplicarlos. Implementa y utiliza la función:
double multiplica(double a, double b) // Devuelve la multiplicación de dos números
 * 
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
			//----------------------------------------------
		    //          Declaración de variables 
		    //----------------------------------------------
			
		    // Constantes
		    // Variables de entrada
			double numeroPrimero, numeroSegundo;
		    // Variables de salida
		    // Variables auxiliares
		    // Clase Scanner para petición de datos
			
		    Scanner teclado = new Scanner(System.in);
		    
		    //----------------------------------------------
		    //                Entrada de datos 
		    //----------------------------------------------
		    System.out.println("Introuzca el primer numero: ");
		    numeroPrimero = teclado.nextDouble();
		    
		    System.out.println("Introuzca el segundo numero: ");
		    numeroSegundo = teclado.nextDouble();
		    

		    //----------------------------------------------
		    //                 Procesamiento 
		    //----------------------------------------------
		    
		    System.out.println(multiplica(numeroPrimero, numeroSegundo));
		    
		    
		}
	
	public static double multiplica(double x, double y) {
		double resultado;
		resultado = x * y;
		return resultado;
	}
}
