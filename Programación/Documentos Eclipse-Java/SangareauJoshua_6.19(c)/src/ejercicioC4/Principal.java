package ejercicioC4;

import ejercicioC4.Articulo;

public class Principal {

	public static void main(String[] args) {

		// Utilizo 5 bloques de try-catch porque cada constructor tiene un error
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

	}

}
