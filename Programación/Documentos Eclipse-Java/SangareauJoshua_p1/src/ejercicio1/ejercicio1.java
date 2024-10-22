package ejercicio1;

import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		byte dia, mes;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    System.out.println("Introduzca el mes en número: ");
	    mes = teclado.nextByte();
	    
	    System.out.println("Introduzca el día: ");
	    dia = teclado.nextByte();
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    //genero un switch para la variable mes. si se introduce un mes que sea cual sea el diá cae en una estación u otra no genero if
	    //si se introduce un mes en el cual hay 2 estaciones, genero un if para diferenciar la variable dia y saber que días quedan en cada estación.
	    
	    switch (mes) {
	    case (1):
	    	System.out.println("Es Invierno.");
	    break;
	    
	    case (2):
	    	System.out.println("Es Invierno.");
	    break;
	    
	    case (3):
	    	if (dia <=19) {
	    	System.out.println("Es Invierno.");
	    	} else {
	    		System.out.println("Esprimavera");
	    	}
	    break;
	    
	    case (4):
	    	System.out.println("Es Primavera.");
	    break;
	    
	    case (5):
	    	System.out.println("Es Primavera.");
	    break;
	    
	    case (6):
	    	if(dia<=20) {
	    		System.out.println("Es Primavera");
	    	} else {
	    		System.out.println("Es Verano");
	    	}
	    break;
	    
	    case (7):
	    		System.out.println("Es Verano");
	    break;
	    
	    case (8):
    		System.out.println("Es Verano");
	    break;
	    
	    case (9):
	    	if (dia <=22) {
    		System.out.println("Es Verano");
	    	} else {
	    		System.out.println("Es Otoño");
	    	}
	    break;
	    
	    case (10):
    		System.out.println("Es Otoño");
	    break;
	    
	    case (11):
    		System.out.println("Es Otoño");
	    break;
	    
	    case(12):
	    	if (dia<=20) {
	    		System.out.println("Es Otoño");
	    		
	    	} else {
	    		System.out.println("Es invierno");
	    	}
	    break;
	    
	    }
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}  