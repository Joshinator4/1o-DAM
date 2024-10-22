/*
 * programa solicita a usuario serie de numero positivos hasta que introduzca 0
 */
package ejemplo_nºpositivos;

import java.util.Scanner;

public class Ejemplo_nºpositivos_hasta_que_se_introduzca0 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		//acumuladores sumaPares y sumaImpares
		//contadores numeroIntroducido
		int sumaImpares, sumaPares, numeroIntroducido, contadorPar, contadorImpar;
		sumaPares = 0; 
		sumaImpares = 0;
		contadorPar = 0;
		contadorImpar = 0;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    do {
	    	
	    	do {
	    		System.out.println("introduzca un nº positivo (no puede ser negativo)");
	    		numeroIntroducido = teclado.nextInt();
	    		
	    	} while (numeroIntroducido < 0);
	    	
	    	if (numeroIntroducido % 2 == 0) {
	    		sumaPares = numeroIntroducido + sumaPares;
	    		
	    	} else {
	    		sumaImpares = numeroIntroducido + sumaImpares;
	    		
	    	}
	    	
	    } while(numeroIntroducido != 0);
	    
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    System.out.println("la suma de nº pares es " + sumaPares);
	    System.out.println("la suma de nº pares es " + sumaImpares);
	    
	}
}   
