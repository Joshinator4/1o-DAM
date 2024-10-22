package matematicas;

import java.util.Scanner;

public class Tabla_Multiplicar_con_Array {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte NUMERO_MULTIPLICADORES = 10;
	    // Variables de entrada
		int[]tabla = new int [NUMERO_MULTIPLICADORES];
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
	    //llamamos al método (en la llamada a un array se pone solo el nombre, en este caso tabla)
	    hacerTablaMultiplicar(tabla, numeroIntroducido);
	    for (int i = 0; i < NUMERO_MULTIPLICADORES; i++) {
	    	System.out.println(numeroIntroducido + " multiplicado por "+ (i+1) + " = " +  tabla [i]);
	    	
	    }
	    
	    
	    
	}
	//No devuelve nada (por eso es void) solo le da valores al array modificando el array original
	public static void hacerTablaMultiplicar (int [] x, int y) {
		for(int i = 0; i < 10; i++) {
			x [i] = y * (i+1);
		}
	}
	
}   