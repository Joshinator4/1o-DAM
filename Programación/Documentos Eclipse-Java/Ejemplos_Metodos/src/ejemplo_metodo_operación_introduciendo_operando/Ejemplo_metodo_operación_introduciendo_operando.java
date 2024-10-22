package ejemplo_metodo_operación_introduciendo_operando;

import java.util.Scanner;

public class Ejemplo_metodo_operación_introduciendo_operando {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		String operando;
		int numeroIntroducido1, numeroIntroducido2;
		char operandoChar;
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
	    System.out.println("Introduzca el primer numero:");
	    numeroIntroducido1 = teclado.nextInt();
	    
	    System.out.println("Introduzca el segundo numero: ");
	    numeroIntroducido2 = teclado.nextInt();
	    
	    teclado.nextLine();
	    
	    System.out.println("Introduzca el operando: ");
	    operando = teclado.nextLine();
	    
	    operandoChar = operando.charAt(0);
	    
	    if (validacion(operandoChar) == true) {
	    	System.out.println("El resultado es " + operacion(numeroIntroducido1, numeroIntroducido2, operandoChar));
	    	
	    } else {
	    	System.out.println("El operando o caracter introducido no es correcto.");
	    }
	    
	    
	    
	    
	}
	
	public static double operacion (int x, int y, char z) {
		double resultado=0;
		if(z == '+') {
			resultado = x + y;
		}else if(z == '-') {
			resultado = x - y;
		}else if(z == '*') {
			resultado = x * y;
		} else if (z == '/') {
			resultado = (double)x / y;
		}else if (z == '%') {
			resultado = x % y;
		} 
		return resultado;
	}
	
	public static boolean validacion (char x) {
		boolean val;
		if (x == '+') {
			val = true;
		}else if(x == '-') {
			val = true;
		}else if (x == '*') {
			val = true;
		}else if(x == '/') {
			val = true;
		}else if (x == '%') {
			val = true;
		} else {
			val = false;
		}
		return val;
	}
	
}   