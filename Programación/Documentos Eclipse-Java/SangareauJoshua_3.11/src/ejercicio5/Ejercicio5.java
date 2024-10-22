/*Necesitamos crear un programa para registrar sueldos de hombres y mujeres de una
empresa y detectar si existe brecha salarial entre ambos. El programa pedirá por teclado la
información de N personas distintas (valor también introducido por teclado). Para cada
persona, pedirá su género (0 para varón y 1 para mujer) y su sueldo. Esta información debe
guardarse en una única matriz. Luego se mostrará por pantalla el sueldo medio de cada
género.
 * 
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final int CANTIDAD_PERSONAS; 
	    // Variables de entrada
		byte genero;
		int varones = 0, mujeres = 0;
		double salarioIntroducido, sumaSalariosVarones = 0, sumaSalariosMujeres = 0, mediaVaron = 0, mediaMujer =  0;
		
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca cantidad de persanas en la empresa: ");
	    CANTIDAD_PERSONAS = teclado.nextInt();

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    double [] empresa = new double [CANTIDAD_PERSONAS];
	    
	    for(int persona = 0; persona < CANTIDAD_PERSONAS; persona++) {
	    	System.out.println("Introduzca genero de la persona " + (persona + 1) + " (0 para varón y 1 para mujer)");
	    	genero = teclado.nextByte();
	    	
	    	System.out.println("Introduzca salario de la persona " + (persona + 1));
	    	salarioIntroducido = teclado.nextInt();
	    	empresa[persona] = salarioIntroducido;
	    	if (genero == 0) {
	    		sumaSalariosVarones += salarioIntroducido;
	    		varones++;
	    		
	    	} else {
	    		sumaSalariosMujeres += salarioIntroducido;
	    		mujeres++;
	    		
	    	}
	    }
	    
	    if(varones != 0) {
	    mediaVaron = sumaSalariosVarones / varones;
	    }else {
			mediaVaron = 0;
		}
	    
	    if(mujeres !=0) {
	    	mediaMujer = sumaSalariosMujeres / mujeres;
		}else {
			mediaMujer = 0;
		}
	   
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    System.out.println("El salario medio de los varones es: " + mediaVaron);
	    System.out.println("El salario medio de las mujeres es: " + mediaMujer);
	}
} 