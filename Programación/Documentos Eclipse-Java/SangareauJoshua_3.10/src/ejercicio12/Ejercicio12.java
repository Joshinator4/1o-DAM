/*
 * Crea un programa que cree un array de 10 enteros y luego muestre el siguiente menú con
distintas opciones:
a. Mostrar valores.
b. Introducir valor.
c. Salir.
La opción ‘a’ mostrará todos los valores por pantalla. La opción ‘b’ pedirá un valor V y una
posición P, luego escribirá V en la posición P del array. El menú se repetirá indefinidamente
hasta que el usuario elija la opción ‘c’ que terminará el programa.
 */
package ejercicio12;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte TAMANNO = 10;
	    // Variables de entrada
		String funcionDeseada;
		int [] numerosEnteros = new int [TAMANNO];
		int valorIntroducido, campoIntroducido;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //--------------------------------------------
	    
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    for (int i = 0; i < TAMANNO; i++) {
	    	numerosEnteros [i] = 1 + (int)(Math.random()*100);
	
	    }
	    
	    do {
	    	
	    	System.out.println("Introduzca la funcion deseada en formato: a, b, c");
		    funcionDeseada = teclado.next();
		    
	    	switch (funcionDeseada) {
	    	
	    		case ("a"):{
	    			for (int i = 0; i < TAMANNO; i++) {
	    		    	System.out.println("El campo " + i + " tiene el valor: " + numerosEnteros [i]);
	    		    	
	    			}
	    			break;
	    		}
	    		case ("b"):{
	    			System.out.println("Introduzca un valor: ");
	    			valorIntroducido = teclado.nextInt();
	    			System.out.println("Introduzca un campo entre 0 y 9 donde cambiar el valor anteriormente introducido: ");
	    			campoIntroducido = teclado.nextInt();
	    			
	    			while (campoIntroducido < 0 || campoIntroducido > 9) {
	    				
		    				System.out.println("Campo introducido erróneo, por favor introduzca un número entre 0 y 9.");
		    				campoIntroducido = teclado.nextInt();
		    				
	    			}
	    			numerosEnteros [campoIntroducido] = valorIntroducido;
	    			
    				System.out.println("El nuevo valor del campo " + campoIntroducido + " es: " + valorIntroducido);
	    			 	
    				break;
	    		}
	    		default: {
	    			System.out.println("El programa ha terminado");
	    		}
	    	} 
	    } while (funcionDeseada.equals("a") || funcionDeseada.equals("b"));
	    
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   