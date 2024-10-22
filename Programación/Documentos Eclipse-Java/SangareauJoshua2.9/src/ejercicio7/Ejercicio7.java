/*
 * 7. Escribe un programa Java que lea 100 números no nulos y luego muestre un mensaje indicando
cuántos son positivos y cuantos negativos. 
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
		int contador, numeroIntroducido, contadorNegativos, contadorPositivos, i;
		contador = 0;
		i = 0;
		contadorNegativos = 0;
		contadorPositivos = 0;
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
	    
	    while (i < 10) {
	    	System.out.println("Introduzca un nº no nulo: ");
	    	numeroIntroducido = teclado.nextInt();
	    	i++;
	    	if (numeroIntroducido < 0) {
	    		contadorNegativos++;
	    	} else if (numeroIntroducido == 0){
	    		System.out.println("No introduzca numeros nulos");
	    		i--;
	    	} else {
	    		contadorPositivos++;
	    	}
	    }
	    
	    
	    //for (int i = 0; i < 100; i++) {
	    	//System.out.println("Introduzca un nº no nulo");
	    	//numeroIntroducido = teclado.nextInt();
	    	
	    	//if (numeroIntroducido < 0) {
	    		//contadorNegativos++;
	    	//} else if (numeroIntroducido == 0){
	    		//System.out.println("No introduzca numeros nulos");
	    		//i--;
	    	//}else {
	    		//contadorPositivos++;
	    	//}
	    	
		//}
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    System.out.println("Has introducido " + contadorPositivos + " números positivos y " + contadorNegativos + " numeros negativos");
	    
	    
	}
}   