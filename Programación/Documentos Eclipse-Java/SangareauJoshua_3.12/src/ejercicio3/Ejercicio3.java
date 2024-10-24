/*
 * Crea un programa que pida por teclado tres cadenas de texto: nombre y dos apellidos.
Luego mostrará un código de usuario (en mayúsculas) formado por la concatenación de
las tres primeras letras de cada uno de ellos. Por ejemplo si se introduce “Lionel”, “Tarazón” y
“Alcocer” mostrará “LIOTARALC”.

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
		String nombre, apellido1, apellido2;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("Introduzca su nombre");
	    nombre = teclado.nextLine();
	    
	    System.out.println("Introduzca su primer apellido");
	    apellido1 = teclado.nextLine();
	    
	    System.out.println("Introduzca su segundo apellido");
	    apellido2 = teclado.nextLine();

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    //System.out.print(nombre.charAt(0)); 
	    //System.out.print(nombre.charAt(1));
	    //System.out.print(nombre.charAt(2));
	    //System.out.print(apellido1.charAt(0));
	    //System.out.print(apellido1.charAt(1));
	    //System.out.print(apellido1.charAt(2));
	    //System.out.print(apellido2.charAt(0));
	    //System.out.print(apellido2.charAt(1));
	    //System.out.print(apellido2.charAt(2));
	    
	    System.out.println(nombre.substring(0, 3)+ apellido1.substring(0, 3) + apellido2.substring(0, 3));
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  