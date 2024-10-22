package ejercicioD4;

import java.util.Scanner;

import ejercicioD4.Articulo;

public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		double descuentoIntroducido;
		// Utilizo 6 bloques de try-catch porque cada constructor tiene un error
		// diferente
		try {
			System.out.println("Intentando Instanciaciar el articulo1");
			Articulo articulo1 = new Articulo("pelota", 17.35, 21, 1);
			System.out.println("Se ha instanciado correctamente");
			System.out.println(articulo1.toString());
		} catch (IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}

		try {
			System.out.println("\nIntentando Instanciaciar el articulo2");
			Articulo articulo2 = new Articulo("Lámpara", 85.24, 17, -5);
			System.out.println();
		} catch (IllegalArgumentException excepcion2) {
			System.out.println(excepcion2.getMessage());
		}

		try {
			System.out.println("\nIntentando Instanciaciar el articulo3");
			Articulo articulo3 = new Articulo("teclado", 99.95, 21, -9);
		} catch (IllegalArgumentException excepcion3) {
			System.out.println(excepcion3.getMessage());
		}

		try {
			System.out.println("\nIntentando Instanciaciar el articulo4");
			Articulo articulo4 = new Articulo(120.35, 21, 7);
			System.out.println("Se ha instanciado correctamente");
			System.out.println(articulo4.toString());
		} catch (IllegalArgumentException excepcion4) {
			System.out.println(excepcion4.getMessage());
		}

		try {
			System.out.println("\nIntentando Instanciaciar el articulo5");
			Articulo articulo5 = new Articulo(-120.35, 21, 4);
		} catch (IllegalArgumentException excepcion5) {
			System.out.println(excepcion5.getMessage());
		}
		
		try {
			System.out.println("\nIntentando Instanciaciar el articulo6");
			Articulo articulo6 = new Articulo("jarron", 115.25, 21, 4);
			System.out.println(articulo6.toString());
			System.out.println("Introduzca el descuento:");
			descuentoIntroducido = teclado.nextDouble();
			System.out.printf("precio con descuento: %.2f", articulo6.getPvpDescuento(descuentoIntroducido));
			System.out.println("\nprobando a vender 3 articulos del objeto6: (habia 4 inicialmente)");
			articulo6.vender(3);
			System.out.println("Quedan: " + articulo6.getCuantosQuedan() + " en stock");
			System.out.println("Probando a almacenar 7 articulos del objeto6:");
			System.out.println("Ha sido posible almacenar los articulos: " + articulo6.siONo(articulo6.almacenar(7)));
			System.out.println("Probando a almacenar 18 articulos del objeto6: ");
			System.out.println("Ha sido posible almacenar los articulos: " + articulo6.siONo(articulo6.almacenar(18)) + ". (No se pueden almacenar mas de 25 articulos)");
			System.out.println("Quedan: " + articulo6.getCuantosQuedan() + " articulos en stock");
		} catch (IllegalArgumentException excepcion6) {
			System.out.println(excepcion6.getMessage());
		}
		
	}

}
