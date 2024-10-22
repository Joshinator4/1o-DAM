package ejemplo_Metodo_tabla_multiplicar;

import java.util.Scanner;

public class Imprimir_tabla_de_multiplicar {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte NUMERO_MULTIPLICADORES = 10;
	    // Variables de entrada
		//int[]tabla = new int [NUMERO_MULTIPLICADORES];
		int numeroIntroducido;
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
	    
	    System.out.println("Introduzca un número para que se le muestre su tabla de multiplicar");
	    numeroIntroducido = teclado.nextInt();
	    
	    System.out.println("Esta es la tabla de multiplicar del numero introducido");
	    
	    imprimirTablaMultiplicar (numeroIntroducido);
	}
	
	public static void imprimirTablaMultiplicar (int x) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(x + " multiplicado por " + i + " = " + x*i);
		}
	}
}   
