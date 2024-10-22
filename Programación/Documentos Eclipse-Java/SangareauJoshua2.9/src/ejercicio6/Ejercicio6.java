/*
 * 6. Escribe un programa Java que lea 100 números no nulos y luego muestre un mensaje de si ha
leído algún número negativo o no
 */
package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int contador, numeroIntroducido, i;
		i= 0;
		contador = 0;
		boolean banderaNegativos;
		banderaNegativos = false;
		
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
	    
	    while (i < 100) {
	    	System.out.println("Introduzca un nº no nulo");
	    	numeroIntroducido = teclado.nextInt();
	    	i++;
	    	if (numeroIntroducido < 0) {
	    		banderaNegativos = true;
	    	}else if (numeroIntroducido == 0){
	    		System.out.println("No introduzca numeros nulos");
	    		i--;
	    	}
	    }
	    
	    
	    //for (int i = 0; i < 100; i++) {
	    	//System.out.println("Introduzca un nº no nulo");
	    	//numeroIntroducido = teclado.nextInt();
	    	
	    	//if (numeroIntroducido < 0) {
	    		//banderaNegativos = true;
	    	//}else if (numeroIntroducido == 0){
	    		//System.out.println("No introduzca numeros nulos");
	    		//i--;
	    	//}
	    //}
	    
	    if(banderaNegativos == true) {
	    	System.out.println("He encontrado numeros negativos");
	    }else {
	    	System.out.println("No se ha encontrado números negativos");
	    }
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   