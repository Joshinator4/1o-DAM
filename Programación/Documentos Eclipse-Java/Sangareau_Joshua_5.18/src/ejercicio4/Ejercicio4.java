/*
 * 4. Implementa un programa que cree un vector de enteros de tamaño N (número aleatorio
entre 1 y 100) con valores aleatorios entre 1 y 10. Luego se le preguntará al usuario qué
posición del vector quiere mostrar por pantalla, repitiéndose una y otra vez hasta que se
introduzca un valor negativo. Maneja todas las posibles excepciones.
 */
package ejercicio4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte TAMANHO = (byte) Math.ceil(Math.random()*100);
		
	    // Variables de entrada
		int campoDeseado = 0;
		int [] valores = new int [TAMANHO];
		boolean banderaCorrecto = false;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    for (int i = 0; i < TAMANHO ; i++) {
	    	valores [i] = (int) Math.ceil(Math.random()*10);
	    	
	    } 
	    
	    do {
	    	try {
	    		System.out.println("Introduzca un número entero de campo del array a mostrar entre 0 y " + (TAMANHO - 1) + " o negativo si quiere finalizar de visualizar los valores de los campos del array");
	    		campoDeseado = teclado.nextInt();
	    		if(campoDeseado >= 0) {
	    			System.out.println(valores [campoDeseado]);
	    		}else {
	    			banderaCorrecto = true;
	    		}
	    		
	    		
	    	}catch(InputMismatchException excepcion1) {
	    		System.out.println("No se ha introducido un valor entero para ver el campo del array. Introduzca un valor entero entre 0 y " + (TAMANHO - 1) + " o negativo si quiere finalizar de visualizar los valores de los campos del array");
	    		banderaCorrecto = false;
	    		teclado.nextLine();
	    		excepcion1.printStackTrace();
	    		
	    	}catch(ArrayIndexOutOfBoundsException  excepcion2) {
	    		System.out.println("Se ha introducido un valor de campo incorrecto saliendose de la cantidad de campos existentes en el array. Introduzca un valor entre 0 y " + (TAMANHO - 1) + " o negativo si quiere finalizar de visualizar los valores de los campos del array");
	    		banderaCorrecto = false;
	    		teclado.nextLine();
	    		excepcion2.printStackTrace();
	    		
	    	}catch (Exception excepcion3) {
	    		System.out.println("Se ha prodcido un error. Vuelva a introducir un valor entero entre 0 y " + (TAMANHO - 1) + " o negativo si quiere finalizar de visualizar los valores de los campos del array");
	    		banderaCorrecto = false;
	    		teclado.nextLine();
	    		excepcion3.printStackTrace();
	    		
	    	}
	    	
	    	//PREGUNTAR AQUI: SI SE TIENE QUE CONTROLAR EL NegativeArraySizeException ya que al introducir el numero negativo lo q se busca es q termine el bucle
	    	
	    }while (campoDeseado >= 0 || banderaCorrecto == false);

	    
	}
}