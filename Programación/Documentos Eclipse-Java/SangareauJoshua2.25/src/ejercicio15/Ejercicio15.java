/*
 * Escribe un programa que dada una cantidad de euros que el usuario introduce por teclado
(múltiplo de 5 €) mostrará los billetes de cada tipo que serán necesarios para alcanzar
dicha cantidad (utilizando billetes de 500, 200, 100, 50, 20, 10 y 5). Hay que indicar el
mínimo de billetes posible.
Por ejemplo, si el usuario introduce 145 el programa indicará que será necesario 1 billete
de 100 €, 2 billetes de 20 € y 1 billete de 5 € (no será válido por ejemplo 29 billetes de 5,
que, aunque sume 145 €, no es el mínimo número de billetes posible).
 */
package ejercicio15;

import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int cantidadIntroducida, restoBilletes, cantidadBilletes;
		int[] billetes = {500, 200, 100, 50, 20, 10, 5};
		restoBilletes = 1;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("Introduzca una cantidad múltiplo de 5:");
	     cantidadIntroducida = teclado.nextInt();
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	     
	     for (int i = 0; i < billetes.length; i++) {
	    	 cantidadBilletes = cantidadIntroducida / billetes [i];
	    	 System.out.println(cantidadBilletes + " billetes de " +billetes [i]);
	    	 cantidadIntroducida = cantidadIntroducida % billetes [i];
	     }
	     
	     
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   