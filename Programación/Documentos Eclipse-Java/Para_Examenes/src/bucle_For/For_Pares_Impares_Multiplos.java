package bucle_For;

import java.util.Scanner;

public class For_Pares_Impares_Multiplos {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
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
	    
	    //El bucle for tiene 3 partes,
	    //1ºexpresión_inicialización: la variable int i (que siempre se inicializa dentro de for) se inicializa ( este caso =1) y se finaliza la parte con (;),
	    //2ºexpresión_finalización: hasta donde va a llegar este caso (<21), 
	    //3ºexpresión de iteración o repetición: a la varaible i cuanto se le va a sumar o restar este caso se le suma 1 cada vez (i++) hasta que llegue al punto de finalización.
	    //En los bucles for siempre se usaran i, j ,k en este orden para darle nombre a las variables.
	    for (int i = 1; i < 21 ; i++) {
	    	
	    	if(i % 2 == 0) {
	    		System.out.println("el nº " + i + " es par");
	    		
	    		if (i % 3 == 0) {
	    			System.out.println("el nº " + i + " es par y múltiplo de 3");
	    			
	    			//Al llegar a un nº par y múltiplo de 3 deseamos que salga un bucle hasta ese nº sin incluirlo, desde el 1 hasta el nº:
	    			//Ponemos una segunda variable inicializada en 1 y le decimos que |j| tiene que ser menor que |i| y se suma 1 cada vez hasta llegar al número de |i|
	    			//y pedimos que imprima por pantalla los valores de |j| hasta llegar al valor de |i|
	    			//Cuando llegue este punto finalizará el bucle hasta el próximo múltiplo de 3.
	    			for (int j = 1; j < i; j++) {
	    				System.out.println(j);
	    			}
	    		}
	    		
	    	//	Usamos else para los nº impares
	    	} else {
	    		
	    		
	    		if (i % 5 == 0) {
	    			System.out.println("el nº " + i + " es impar y múltiplo de 5");
	    			
	    			//Al llegar a un nº par y múltiplo de 5 deseamos que salga un bucle hasta ese nº sin incluirlo, esta vez desde el número hasta 0:
	    			//Ponemos segunda variable |j| y la igualamos a |i|. despues ponemos que |j| es mayor que 0. Por ultimo ponemos q se le reste 1 a |j|, cuando llegue a 0 terminará el bucle
	    			for (int j = i; j > 0; j--) {
		    			System.out.println(j);
		    		}
	    		}
	    		System.out.println("el nº " + i + " es impar");
	    	}
	    	
	    }
	    
	 
	    
	}
}  