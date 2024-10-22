package ejercicioB3;

import ejercicioB3.Rectangulo;

public class Principal {

	public static void main(String[] args) {
		
		try {
			System.out.println("Instanciando el rectangulo objeto1");
			Rectangulo objeto1 = new Rectangulo (0, 0, 5, 5);
			System.out.println("Rectángulo creado correctamente");
		} catch (IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		} 
		
		try {
			System.out.println("Instanciando el rectangulo objeto2");
			Rectangulo objeto2 = new Rectangulo (7, 9, 2, 3);
		} catch (IllegalArgumentException excepcion2) {
			System.out.println(excepcion2.getMessage());
		}

	}

}
