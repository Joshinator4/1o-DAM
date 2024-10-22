/*
 * 8. Realiza un minicuestionario con 10 preguntas tipo test sobre el módulo Sistemas
Informáticos que se imparte en el curso. Cada pregunta acertada sumará un punto. El
programa mostrará al final la calificación obtenida.

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
		char respuesta;
		byte contadorNota;
		contadorNota = 0;
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
	    
	    for (int i = 1; i <= 10; i++) {
	    	System.out.println("introduzca respuesta pregunta " + i + ":");
	    	respuesta = teclado.next().charAt(0);
	    	switch(i) {
	    	
	    		case (1): {
	    		
	    			if (respuesta == 'a') {
	    			contadorNota++;
	    			}
	    			break;
	    
	    		}case (2): {
	    		
	    			if (respuesta == 'c') {
	    			contadorNota++;
	    			}
	    			break;
	    			
	    		} case (3): {
	    		
	    			if (respuesta == 'b') {
	    			contadorNota++;
	    			}
	    			break;
	    			
	    		} case (4): {
	    		
	    			if (respuesta == 'a') {
	    			contadorNota++;
	    			}
	    			break;
	    			
	    		} case (5): {
	    		
	    			if (respuesta == 'c') {
	    			contadorNota++;
	    			}
	    			break;
	    			
	    		} case (6): {
	    		
	    			if (respuesta == 'a') {
	    			contadorNota++;
	    			}
	    			break;
	    			
	    		} case (7): {
	    		
	    			if (respuesta == 'c') {
	    			contadorNota++;
	    			}
	    			break;
	    			
	    		} case (8): {
	    		
	    			if (respuesta == 'a') {
	    			contadorNota++;
	    			}
	    			break;
	    			
	    		} case (9): {
	    		
	    			if (respuesta == 'a') {
	    			contadorNota++;
	    			}
	    			break;
	    			
	    		} default: {
	    			if (respuesta == 'b') {
	    			contadorNota++;
	    			}
	    		}	
	    	
	    		
	    		
	    	}
	    }
	    
	    System.out.println("Su nota es: " + contadorNota);
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   