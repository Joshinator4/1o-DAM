/*
 * Crea un programa que muestre por pantalla cuantas vocales de cada tipo hay (cuantas ‘a’,
cuantas ‘e’, etc.) en una frase introducida por teclado. No se debe diferenciar entre
mayúsculas y minúsculas. Por ejemplo dada la frase “Mi mama me mima” dirá que hay:
Nº de A's: 3
Nº de E's: 1
Nº de I's: 2
Nº de O's: 0
Nº de U's: 0
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		String fraseIntroducida;
		int a=0, e=0, i=0, o=0, u=0;
		char letraActual;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("Introduzca una frase");
	    fraseIntroducida = teclado.nextLine();
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    for (int j = 0; j < fraseIntroducida.length(); j++) {
	    	letraActual = fraseIntroducida.toLowerCase().charAt(j);
	    	
	    	switch(letraActual) {
	    		case 'a':{
	    			a++;
	    			break;
	    		}
	    		case 'e':{
	    			e++;
	    			break;
	    		}
	    		case 'i':{
		    		i++;
		    		break;
	    		}
	    		case 'o':{
		    		o++;
		    		break;
	    		}
	    		case 'u':{
		    		u++;
		    		break;
	    		}
	    		default:
	    	}
	    
	    }
	    
	    System.out.println("Su frase tiene " + a +  " a's " + e +  " e's " + i + " i's "  + o +  " o's " + u +  " u's ");
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  