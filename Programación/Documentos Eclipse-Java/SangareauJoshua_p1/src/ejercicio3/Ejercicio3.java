package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		
		//Nombramos las variables y las iniciamos a 0, para evitar el error de variable no inicializada
		byte numeroIntroducido;
		int contadorDecena0, contadorDecena1, contadorDecena2, contadorDecena3, contadorDecena4, contadorDecena5, contadorDecena6, contadorDecena7, contadorDecena8, contadorDecena9;
		double mediaDecena0, mediaDecena1, mediaDecena2, mediaDecena3, mediaDecena4, mediaDecena5, mediaDecena6, mediaDecena7, mediaDecena8, mediaDecena9;
		contadorDecena0 = 0;
		contadorDecena1 = 0;
		contadorDecena2 = 0;
		contadorDecena3 = 0;
		contadorDecena4 = 0; 
		contadorDecena5 = 0;
		contadorDecena6 = 0;
		contadorDecena7 = 0;
		contadorDecena8 = 0;
		contadorDecena9 = 0;
		mediaDecena0 = 0;
		mediaDecena1 = 0;
		mediaDecena2 = 0;
		mediaDecena3 = 0;
		mediaDecena4 = 0;
		mediaDecena5 = 0;
		mediaDecena6 = 0;
		mediaDecena7 = 0;
		mediaDecena8 = 0;
		mediaDecena9 = 0;
		
		
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
	    //Realizaremos un bucle do_while para que al menos me pida 1 vez el numero. anidamos if y else if con cada uno de sus respectivos contadores para cada cifra incluida en esa decena
	    // y iremos sumando las cifras introducidas en la media para posteriormente realizar los cálculos de la media
	    do {
	    	System.out.println("Introduzca un número");
	    	numeroIntroducido = teclado.nextByte();
	    	
	    	if (numeroIntroducido <= 9 && numeroIntroducido > 0) {
	    		contadorDecena0++;
	    		mediaDecena0 = mediaDecena0 + numeroIntroducido;
	    		
	    	} else if (numeroIntroducido <= 19 && numeroIntroducido > 0) {
	    		contadorDecena1++;
	    		mediaDecena1 = mediaDecena1 + numeroIntroducido;
	    		
	    	} else if (numeroIntroducido <= 29 && numeroIntroducido > 0) {
	    		contadorDecena2++;
	    		mediaDecena2 = mediaDecena2 + numeroIntroducido;
	    		
	    	} else if (numeroIntroducido <= 39 && numeroIntroducido > 0) {
	    		contadorDecena3++;
	    		mediaDecena3 = mediaDecena3 + numeroIntroducido;
	    		
	    	} else if (numeroIntroducido <= 49 && numeroIntroducido > 0) {
	    		contadorDecena4++;
	    		mediaDecena4 = mediaDecena4 + numeroIntroducido;
	    		
	    	} else if (numeroIntroducido <= 59 && numeroIntroducido > 0) {
	    		contadorDecena5++;
	    		mediaDecena5 = mediaDecena5 + numeroIntroducido;
	    		
	    	} else if (numeroIntroducido <= 69 && numeroIntroducido > 0) {
	    		contadorDecena6++;
	    		mediaDecena6 = mediaDecena6 + numeroIntroducido;
	    		
	    	} else if (numeroIntroducido <= 79 && numeroIntroducido > 0) {
	    		contadorDecena7++;
	    		mediaDecena7 = mediaDecena7 + numeroIntroducido;
	    		
	    	} else if (numeroIntroducido <= 89 && numeroIntroducido > 0) {
	    		contadorDecena8++;
	    		mediaDecena8 = mediaDecena8 + numeroIntroducido;
	    		
	    	} else if (numeroIntroducido <= 100 && numeroIntroducido > 0) {
	    		contadorDecena9++;
	    		mediaDecena9 = mediaDecena9 + numeroIntroducido;
	    		
	    	} else {
	    		System.out.println("Este valor será ignorado");
	    	}
	    } while (numeroIntroducido != 0);
	    
	    //Realizamos el cálculo para cada una de las medias, utilizamos el if para que si la cantidad introducida es mayor de 0 haga la operación, en caso contrario pondrá que la media es = a 0
	    // ya que si dividimos 0/0 da error
	    
	    if (mediaDecena0 > 0) {
	    mediaDecena0 = mediaDecena0 / contadorDecena0;
	    } else {
	    	mediaDecena0 = 0;
	    }
	    
	    if (mediaDecena1 > 0) {
		    mediaDecena1 = mediaDecena1 / contadorDecena1;
		} else {
		    	mediaDecena1 = 0;
		}
	    
	    if (mediaDecena2 > 0) {
		    mediaDecena2 = mediaDecena2 / contadorDecena2;
	    } else {
		    	mediaDecena2 = 0;
	    }
	    
	    if (mediaDecena3 > 0) {
		    mediaDecena3 = mediaDecena3 / contadorDecena3;
	    } else {
	    	mediaDecena3 = 0;
	    }
	    
	    if (mediaDecena4 > 0) {
		    mediaDecena4 = mediaDecena4 / contadorDecena4;
	    } else {
		    	mediaDecena4 = 0;
	    }
	    
	    if (mediaDecena5 > 0) {
		    mediaDecena5 = mediaDecena5 / contadorDecena5;
	    } else {
		    	mediaDecena5 = 0;
	    }
	    
	    if (mediaDecena6 > 0) {
		    mediaDecena6 = mediaDecena6 / contadorDecena6;
	    } else {
		    	mediaDecena6 = 0;
	    }
	    
	    if (mediaDecena7 > 0) {
		    mediaDecena7 = mediaDecena7 / contadorDecena7;
	    } else {
		    	mediaDecena7 = 0;
	    }
	    
	    if (mediaDecena8 > 0) {
		    mediaDecena8 = mediaDecena8 / contadorDecena8;
	    } else {
		    	mediaDecena8 = 0;
	    }
	    
	    if (mediaDecena9 > 0) {
		    mediaDecena9 = mediaDecena9 / contadorDecena9;
	    } else {
		    	mediaDecena9 = 0;
	    }
	    
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    // Por último imprimiremos los resultados.
	    System.out.println("cantidad de numero es la decena0 es :" + contadorDecena0 + " y la media es: " + mediaDecena0);
	    System.out.println("cantidad de numero es la decena1 es :" + contadorDecena1 + " y la media es: " + mediaDecena1);
	    System.out.println("cantidad de numero es la decena2 es :" + contadorDecena2 + " y la media es: " + mediaDecena2);
	    System.out.println("cantidad de numero es la decena3 es :" + contadorDecena3 + " y la media es: " + mediaDecena3);
	    System.out.println("cantidad de numero es la decena4 es :" + contadorDecena4 + " y la media es: " + mediaDecena4);
	    System.out.println("cantidad de numero es la decena5 es :" + contadorDecena5 + " y la media es: " + mediaDecena5);
	    System.out.println("cantidad de numero es la decena6 es :" + contadorDecena6 + " y la media es: " + mediaDecena6);
	    System.out.println("cantidad de numero es la decena7 es :" + contadorDecena7 + " y la media es: " + mediaDecena7);
	    System.out.println("cantidad de numero es la decena8 es :" + contadorDecena8 + " y la media es: " + mediaDecena8);
	    System.out.println("cantidad de numero es la decena9 es :" + contadorDecena9 + " y la media es: " + mediaDecena9);
	    
	    
	}
}  