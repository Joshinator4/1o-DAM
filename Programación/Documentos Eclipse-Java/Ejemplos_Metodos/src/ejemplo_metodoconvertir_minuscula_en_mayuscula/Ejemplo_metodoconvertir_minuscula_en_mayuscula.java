package ejemplo_metodoconvertir_minuscula_en_mayuscula;

import java.util.Scanner;

public class Ejemplo_metodoconvertir_minuscula_en_mayuscula {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		String fraseIntroducida;
		char letraIntroducida;
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
	    System.out.println("Introduzca una letra");
	    fraseIntroducida = teclado.nextLine();
	    letraIntroducida = fraseIntroducida.charAt(0);
	    
	    if(esMinuscula(letraIntroducida) == true) {
	    	System.out.println("Su letra en mayúscula es: " + minusculaAMayuscula (letraIntroducida));
	    }
	    
	    
	}
	public static boolean esMinuscula(char x) {
		boolean minuscula;
		if (x >= 'a' && x <= 'z') {
			minuscula = true;
		}else {
			minuscula = false;
		}
		return minuscula;
	}
	
	public static char minusculaAMayuscula (char x ) {
		char mayuscula;
		mayuscula = (char)((int)x - (int)'a' + (int)'A');
			return mayuscula;
		
	}
}   