/*
 * Crea un método llamado productosDescuento que devolverá un valor double. Recibirá como
parámetros tres valores (double precio, int cantidad, int descuento).
El método calculará el precio a pagar, multiplicando la cantidad de productos por el precio, y
aplicando el descuento (en porcentaje) correspondiente.
El programa mostrará un mensaje por pantalla como aparece a continuación:
Usted ha adquirido cantidad de productos nombreProducto, a un precio de precio euros la
unidad.
El precio a pagar es (precio sin descuento), pero al aplicarle el descuento del descuento% el
precio final a pagar es: (precio con descuento).

 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		double precio, precioFinal;
		int cantidad, descuento;
		String nombreProducto;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca el nombre del producto");
	    nombreProducto = teclado.nextLine();
	    System.out.println("Introduzca el precio del producto");
	    precio = teclado.nextDouble();
	    System.out.println("Introduzca la cantidad que desea");
	    cantidad = teclado.nextInt();
	    System.out.println("Introduzca el descuento a realizar");
	    descuento = teclado.nextInt();
	    
	    
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    precioFinal = productosDescuento(precio, cantidad, descuento);
	    
	   System.out.println("Usted ha adquirido " + cantidad +" de productos " + nombreProducto + ", a un precio " + precio +" euros la unidad.");
	   System.out.println("El precio a pagar es " + (precio * cantidad) + " pero al aplicarle el descuento del " + descuento + "% el precio final a pagar es: " + precioFinal);
	    
	}
	
	public static double productosDescuento (double x , int y, int z) {
		double precioFinal, descuento;
		descuento = (double) z/100;
		precioFinal = (x * y) - (x * y * descuento);
		return precioFinal;
		
	}
}