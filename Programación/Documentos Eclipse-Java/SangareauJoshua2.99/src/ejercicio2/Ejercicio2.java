/*
 * Escribe un programa en Java que permita calcular el importe a pagar por los clientes del Parque Acuático AquaTrass teniendo en cuenta los siguientes requisitos:

existirán dos tipos de entradas:
Infantil con un precio base de 10,00 €
Adulto con un precio base de 15,00 €.
en caso de que el coste total de las entradas sea superior a 50,00 € se aplicará automáticamente un 5% de descuento. Igualmente, si el importe base total es superior a 100,00 € el descuento será de un 15%.
Además, una vez realizados los descuentos pertinentes se deberá aplicar un IVA del 21% al importe resultante.

El programa solicitará la cantidad de entradas de cada tipo que se desean comprar, realizará todos los cálculos necesarios y mostrará por pantalla los siguientes resultados:

el número de entradas de adulto y de entradas infantiles que comprará el cliente.
el importe total de las entradas antes de aplicar (si procede) el descuento.
el porcentaje de descuento que se aplicará o el texto "No procede descuento en esta compra"en caso de que no se cumplan los requisitos para aplicar descuento
el importe total aplicando el descuento (si procede) pero no el IVA.
el importe total de la compra tras aplicar el descuento que corresponda y el IVA indicado anteriormente.
Por último, el sistema mostrará la cantidad final que deberá pagar el cliente la cual será la parte entera del importe total calculado anteriormente (por ejemplo, si el importe total fuera 32,67 € la cantidad final que debería pagar el cliente sería 32 €).


Importante: Debes mostrar las cantidades decimales con todos los decimales.

Por ahora no controlaremos que la cantidad de entradas introducidas tenga que ser positiva (aunque una cantidad negativa de entradas en nuestro ejemplo no tendría sentido).
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final double infantil = 10;
		final double adulto = 15;
	    // Variables de entrada
		double entradasInfantiles, entradasAdultos, totalEntradas, descuento50, descuento100, precioIva, aumentoIva, totalEntradas1;
		int totalRedondeado;
		descuento100 = 0;
		descuento50 = 0;
		totalEntradas1 = 0;
		precioIva = 0;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca nº de entradas infantiles");
	    entradasInfantiles = teclado.nextDouble();
	    
	    System.out.println("Introduzca nº de entradas de adulto");
	    entradasAdultos = teclado.nextDouble();
	    
	    totalEntradas = (entradasAdultos*15) + (entradasInfantiles*10);
	    
	    if (totalEntradas >= 50 && totalEntradas < 100) {
	    	descuento50 = totalEntradas * 0.05;
	    	totalEntradas1 = totalEntradas - descuento50;
	    	
	    } else if (totalEntradas >= 100) {
	    	descuento100 = totalEntradas * 0.15;
	    	totalEntradas1 = totalEntradas - descuento100;
	    	
	    } else {
	    	totalEntradas1 = totalEntradas;
	    }
	    
	    aumentoIva = totalEntradas1 * 0.21;
	    precioIva = totalEntradas1 + aumentoIva;
	    
	    System.out.println("número de entradas de adulto: " + entradasAdultos + " y de entradas infantiles: " + entradasInfantiles);
	    System.out.println("Importe total sin el IVA y sin descuento: " + totalEntradas);
	    
	    if (totalEntradas >= 100) {
	    	System.out.println("el porcentaje de descuento que se aplicará es el 15%");
	    	System.out.println("el precio con descuento realizado es: " + totalEntradas1 + "€");
	    	System.out.println("el precio total es: " + precioIva + "€");
	    
	    }else if (totalEntradas >= 50) {
	    	System.out.println("el porcentaje de descuento que se aplicará es el 5%");
	    	System.out.println("el precio con descuento realizado es: " + totalEntradas1 + "€");
	    	System.out.println("el precio total es: " + precioIva + "€");
	    
	    } else {
	    	System.out.println("No procede descuento");
	    	System.out.println("el precio sin IVA es: " + totalEntradas1 + "€");
	    	System.out.println("el precio total es: " + precioIva + "€");
	    }
	    
	    totalRedondeado = (int)Math.floor(precioIva);
	    System.out.println(totalRedondeado);
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   