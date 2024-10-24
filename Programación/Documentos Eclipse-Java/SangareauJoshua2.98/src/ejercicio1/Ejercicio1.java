/*
 * Objetivo:Vamos a programar el sistema de control de una máquina expendedora de bebidas. Para ello, la máquina informará al usuario de las bebidas
 *  de que dispone así como su precio a través de un menú de opciones (de valores enteros). Se solicita al usuario el número del menú correspondiente a la bebida elegida.  

Debe existir una opción “0” para salir. Mostrando el mensaje de despedida "Gracias por usar la Máquina Expendedora. ¡Hasta luego!" y no haciendo nada más.
Si la opción elegida por el usuario no es correcta se debe volver a mostrar el menú de opciones y solicitar una nueva opción.
Si la  opción seleccionada es válida, el usuario introducirá una cantidad de dinero para realizar el pago de la bebida seleccionada. 
Si la cantidad de dinero es inferior al precio se mostrará el mensaje: “Dinero insuficiente. Su dinero será devuelto.” y el usuario podrá introducir otra cantidad de dinero hasta tres
intentos y el programa finalizará.
Si la cantidad de dinero es igual o superior al precio se calculará la diferencia entre la cantidad introducida y el precio de la bebida. Se informará del cambio devuelto y el programa finalizará.
NOTA: Se valorará el uso de un tipo enumerado para definir los tipos de bebidas (COCACOLA, PEPSI,AGUA, ZUMO, SALIR)

Debes tener en cuenta que:

Se valorará que se minimice el número de líneas y condiciones. Intenta utilizar los operadores lógicos siempre que te sea posible;
Para determinar las acciones en cada caso dentro del menú de usuario puedes aprovechar el uso de la estructura "switch";
Las únicas clases y métodos que puedes usar en el programa son los de System y Scanner, que utilizamos para la E/S por consola. Aparte de estas, no puedes usar ninguna otra clase, método o herramienta, ni de la API de Java ni propia, para resolver el ejercicio;
El código deberá incluir diferentes tipos de comentarios internos tanto de una línea como multilínea.
 * Autor: Joshua Sangareau Quesada
 * fecha: 07/11/2023
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final double COCA = 1.5, PEPSI = 1.4, AGUA = 1, ZUMO = 1.95;
	    // Variables de entrada
		byte numeroIntroducido, intentos = 1;
		double monedas, devolucion;
		boolean banderaDinero = false;
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
	    
	    //se da la bienvenida y se muestra el menu principal 
	    System.out.println("Bienvenido a la máquina expendedora: ");
	    System.out.println("Marque alguna de las opciones: ");
	    System.out.println("1-COCA-COLA, precio:" + COCA + "€");
	    System.out.println("2-PEPSI, precio: " + PEPSI + "€");
	    System.out.println("3-AGUA, precio:" + AGUA + "€");
	    System.out.println("4-ZUMO, precio:" + ZUMO + "€");
	    System.out.println("0-SALIR");
	    
	    //se inicia bucle con petcion de introducir el número del menú
	    
	    do{
	    	System.out.println("Introduzca el número de la opción deseada: ");
	    	numeroIntroducido = teclado.nextByte();
	    	
	    	//se utiliza switch con cada uno de los casos del menú, en cada caso, se genera otro bucle para 3 intentos en caso de ser menor la cantidad
	    	// de monedas introducidas, si se introduce justo se entrega la bebida y se cambia la bandera a true para que salga del bucle y en caso de que se introduce mas dinero del necesario se entrega 
	    	//la bebida y se le devuelve el dinero que le sobra
	    	//en el caso que se introduzca 0 se sale del programa y en caso de número erróneo se le dice al usuario y se pide de nuevo número de menu
	    	switch (numeroIntroducido) {
	    		
	    		case 1:{
	    		
	    			do {
	    				System.out.println("Introduzca monedas");
		    			monedas = teclado.nextDouble();
		    			
	    				if(monedas < COCA) {
	    					System.out.println("Dinero insuficiente. Su dinero será devuelto.");
	    					intentos++;
	    				} else if (monedas == COCA) {
	    					System.out.println("aquí tiene su bebida");
	    					banderaDinero = true;
	    				} else {
	    					devolucion = monedas - COCA;
	    					System.out.println("aquí tiene su bebida");
	    					System.out.println("Le sobra: " + devolucion + "€");
	    					banderaDinero = true;
	    				}
	    			
	    			} while (intentos <= 3 && banderaDinero == false);
	    			
	    			break;
	    		
	    		} 
	    		case 2: {
	    			
    				do {
    					System.out.println("Introduzca monedas");
    	    			monedas = teclado.nextDouble();
    	    			
    					if(monedas < PEPSI) {
    						System.out.println("Dinero insuficiente. Su dinero será devuelto.");
    						intentos++;
    					} else if (monedas == PEPSI) {
    						System.out.println("aquí tiene su bebida");
    						banderaDinero = true;
    					} else {
    						devolucion = monedas - PEPSI;
    						System.out.println("aquí tiene su bebida");
    						System.out.println("Le sobra: " + devolucion + "€");
    						banderaDinero = true;
    					}
    			
    				} while (intentos <= 3 && banderaDinero == false);
    				
    				break;
    				
	    		} 
	    		case 3: {
	    			
    		
    				do {
    					System.out.println("Introduzca monedas");
    	    			monedas = teclado.nextDouble();
    	    			
    					if(monedas < AGUA) {
    						System.out.println("Dinero insuficiente. Su dinero será devuelto.");
    						intentos++;
    					} else if (monedas == AGUA) {
    						System.out.println("aquí tiene su bebida");
    						banderaDinero = true;
    					} else {
    						devolucion = monedas - AGUA;
    						System.out.println("aquí tiene su bebida");
    						System.out.println("Le sobra: " + devolucion + "€");
    						banderaDinero = true;
    					}
    			
    				} while (intentos <= 3 && banderaDinero == false);
    				
    				break;
	    			
	    		} 
	    		case 4: {
	    			
    				do {
    					System.out.println("Introduzca monedas");
    	    			monedas = teclado.nextDouble();
    	    			
    					if(monedas < ZUMO) {
    						System.out.println("Dinero insuficiente. Su dinero será devuelto.");
    						intentos++;
    					} else if (monedas == ZUMO) {
    						System.out.println("aquí tiene su bebida");
    						banderaDinero = true;
    					} else {
    						devolucion = monedas - ZUMO;
    						System.out.println("aquí tiene su bebida");
    						System.out.println("Le sobra: " + devolucion + "€");
    						banderaDinero = true;
    					}
    			
    				} while (intentos <= 3 && banderaDinero == false);
    				
    				break;
    				
	    		} 
	    		case 0:{
	    			System.out.println("Gracias por usar la Máquina Expendedora. ¡Hasta luego!");
	    			
	    			break;
	    		
	    		} 
	    		default :{
	    			System.out.println("Número introducido erróneo.");
	    			System.out.println("1-COCA-COLA, precio:" + COCA + "€");
	    		    System.out.println("2-PEPSI, precio: " + PEPSI + "€");
	    		    System.out.println("3-AGUA, precio:" + AGUA + "€");
	    		    System.out.println("4-ZUMO, precio:" + ZUMO + "€");
	    		    System.out.println("0-SALIR");
	    		    System.out.println("Seleccione una opción de las mostradas");
	    			numeroIntroducido = teclado.nextByte();
	    		    
	    		}
	    	}
	    
	    }while(numeroIntroducido != 0);
	    
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   