/*
 * 9. Escribe un programa que ordene tres números enteros introducidos por teclado.
 */
package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {
	
		
		public static void main(String[] args) {
			//----------------------------------------------
		    //          Declaración de variables 
		    //----------------------------------------------
			
		    // Constantes
		    // Variables de entrada
			byte numeroIntroducido, numeroIntroducido2, numeroIntroducido3, numeroMayor, numeroMenor, numeroIntermedio;
			numeroMayor = 0;
			numeroMenor = 123;
			numeroIntermedio = 0;
			
		    // Variables de salida
		    // Variables auxiliares
		    // Clase Scanner para petición de datos
			
		    Scanner teclado = new Scanner(System.in);
		    
		    //----------------------------------------------
		    //                Entrada de datos 
		    //----------------------------------------------
		    

		    //----------------------------------------------
		    //                 Procesamiento 
		    //---------------------------------------------
		    System.out.println("Introduzca el primer nº ");
		    numeroIntroducido = teclado.nextByte();
		    numeroMayor = numeroIntroducido;
		    
		    System.out.println("Introduzca el segundo nº ");
		    numeroIntroducido2 = teclado.nextByte();
		    if(numeroIntroducido2 > numeroMayor) {
		    	numeroMenor = numeroMayor;
		    	numeroMayor = numeroIntroducido2;
		    } else {
		    	numeroMenor = numeroIntroducido2;
		    }
		    System.out.println("Introduzca el tercer nº ");
		    numeroIntroducido3 = teclado.nextByte();
		    if (numeroIntroducido3 > numeroMenor && numeroIntroducido3 < numeroMayor) {
		    	numeroIntermedio = numeroIntroducido3;
		    } else if (numeroIntroducido3 > numeroMayor){
		    	numeroIntermedio = numeroMayor;
		    	numeroMayor = numeroIntroducido3;
		    	
		    } else {
		    	numeroIntermedio = numeroMenor;
		    	numeroMenor = numeroIntroducido3;
		    }
		    
		    
		    //----------------------------------------------
		    //              Salida de resultados 
		    //----------------------------------------------
		    
		    System.out.println("el numero menor es: " + numeroMenor);
		    System.out.println("el numero intermedio es: " + numeroIntermedio);
		    System.out.println("el numero mayor es: " + numeroMayor);
		    
	}
}