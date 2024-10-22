package ejercicioD3;

import ejercicioD3.Rectangulo;

public class Principal {

	public static void main(String[] args) {
		
		try {
			System.out.println("Instanciando el rectangulo objeto1");
			Rectangulo objeto1 = new Rectangulo (0, 0, 5, 5);
			System.out.println("Rectángulo creado correctamente");
			System.out.println("Cambiando el valor de y1 a 7");
			objeto1.setX1(7);
		} catch (IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		} 
		
		try {
			System.out.println("Instanciando el rectangulo objeto2");
			Rectangulo objeto2 = new Rectangulo (7, 9, 2, 3);
		} catch (IllegalArgumentException excepcion2) {
			System.out.println(excepcion2.getMessage());
		}
		try {
			System.out.println("Instanciando el rectangulo objeto3");
			Rectangulo objeto3 = new Rectangulo (2, 9, 7, 3);
		} catch (IllegalArgumentException excepcion3) {
			System.out.println(excepcion3.getMessage());
		}
		try {
			System.out.println("Instanciando el rectangulo objeto4");
			Rectangulo objeto4 = new Rectangulo (-4, 9, 2, 3);
		} catch (IllegalArgumentException excepcion4) {
			System.out.println(excepcion4.getMessage());
		}
		try {
			System.out.println("Instanciando el rectangulo objeto5");
			Rectangulo objeto5 = new Rectangulo (2, -5, 7, 3);
		} catch (IllegalArgumentException excepcion5) {
			System.out.println(excepcion5.getMessage());
		}
		
		try {
			System.out.println("Instanciando el rectangulo objeto6");
			Rectangulo objeto6 = new Rectangulo (0, 0, 5, 5);
			System.out.println("Rectángulo creado correctamente");
			System.out.println("Cambiando el valor de y2 a 0");
			objeto6.setY2(0);
		} catch (IllegalArgumentException excepcion6) {
			System.out.println(excepcion6.getMessage());
		} 
		
		try {
			System.out.println("Instanciando el rectangulo objeto7");
			Rectangulo objeto7 = new Rectangulo (0, 0, 5, 5);
			System.out.println("Probando lo setter x1y1, x2y2");
			objeto7.setX1Y1(1, 1);
			objeto7.setX2Y2(6, 6);
			System.out.println("(" + objeto7.getX1() + "," + objeto7.getY1() + ")" + "(" + objeto7.getX2() + "," + objeto7.getY2() + ")");
			System.out.println("Probando metodos getArea() y getPerimetro() del objeto7");
			System.out.println("El área del objeto7 es: " + objeto7.getArea() + " y el perímetro es: " + objeto7.getPerimetro());
		} catch (IllegalArgumentException excepcion7) {
			System.out.println(excepcion7.getMessage());
		} 
		
	}

}
