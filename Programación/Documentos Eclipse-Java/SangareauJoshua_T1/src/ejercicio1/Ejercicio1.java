package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		final byte CANTIDADNUMEROS=4;
		double numeroIntroducido, operacion, mediaOperacion, max;
		byte contadorVueltas = 1;
		char opcionIntroduciaChar;
		String opcionIntroduciaString;
		boolean bandera = false;
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
	    
	    do {
	    	System.out.println("Introduzca una de las opciones propuestas:");
	    	System.out.println("a)SUMAR");
	    	System.out.println("b)MULTIPLICAR");
	    	System.out.println("c)CALCULAR MEDIA");
	    	System.out.println("d)MOSTRAR MÁXIMO");
	    	System.out.println("z)SALIR");
	    	opcionIntroduciaString = teclado.nextLine();
	    	opcionIntroduciaChar = opcionIntroduciaString.charAt(0);
	    	
	    	switch (opcionIntroduciaChar) {
	    		case 'a':{
	    			operacion=0;
	    			for(int i = 0; i < CANTIDADNUMEROS; i++) {
	    				System.out.println("Introduzca el numero " + (i+1));
	    				numeroIntroducido = teclado.nextDouble();
	    				operacion += numeroIntroducido; 
	    			}
	    			System.out.println("El resultado de su operación (suma) es: " + operacion);
	    			contadorVueltas++;
	    			bandera = false;
	    			break;
	    		}
	    		case 'b':{
	    			operacion=1;
	    			for(int i = 0; i < CANTIDADNUMEROS; i++) {
	    				System.out.println("Introduzca el numero " + (i+1));
	    				numeroIntroducido = teclado.nextDouble();
	    				operacion *= numeroIntroducido; 
	    			}
	    			System.out.println("El resultado de su operación (multiplicación) es: " + operacion);
	    			contadorVueltas++;
	    			bandera = false;
	    			break;
	    		}
	    		case 'c':{
	    			operacion=0;
	    			mediaOperacion=0;
	    			for(int i = 0; i < CANTIDADNUMEROS; i++) {
	    				System.out.println("Introduzca el numero " + (i+1));
	    				numeroIntroducido = teclado.nextDouble();
	    				operacion += numeroIntroducido; 
	    			}
	    			mediaOperacion = operacion / 4;
	    			System.out.println("El resultado de su operación (media) es: " + mediaOperacion);
	    			contadorVueltas++;
	    			bandera = false;
	    			break;
	    			
	    		}
	    		
	    		case 'd':{
	    			max = 0;
	    			operacion=0;
	    			for(int i = 0; i < CANTIDADNUMEROS; i++) {
	    				System.out.println("Introduzca el numero " + (i+1));
	    				numeroIntroducido = teclado.nextDouble();
	    				if (numeroIntroducido > max) {
	    					max = numeroIntroducido;
	    				}
	    			}
	    			System.out.println("El resultado de su operación (numero máximo) es: " + max);
	    			contadorVueltas++;
	    			bandera = false;
	    			break;
	    		}
	    		
	    		case 'z':{
	    			bandera = true;
	    			System.out.println("Usted ha salido");
	    			break;
	    		}
	    		
	    		
	    		default:{
	    			System.out.println("La opcion introducida no es correcta, introduzca una opción valida");
	    		}
	    	}
			
	 
	    	
	    	teclado.nextLine();
	    }while (bandera == false && contadorVueltas <= 3 );
	  
	    
	    
	}
}   