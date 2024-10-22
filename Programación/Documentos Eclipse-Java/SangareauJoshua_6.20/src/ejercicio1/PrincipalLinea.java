package ejercicio1;

public class PrincipalLinea {

	public static void main(String[] args) {
		
		try {
			Punto punto1 = new Punto (1, 5);
			Punto punto2 = new Punto (3, 8);
			Linea linea1 = new Linea (punto1, punto2);
			System.out.println(linea1.EscribirLinea());
			System.out.println("\nmoviendo la linea a la derecha 5");
			linea1.mueveDerecha(5);
			System.out.println(linea1.EscribirLinea());
			System.out.println("\nmoviendo la línea a la izquierda 3");
			linea1.mueveIzquierda(3);
			System.out.println(linea1.EscribirLinea());
			System.out.println("\nmoviendo la línea hacia arriba 4");
			linea1.mueveArriba(4);
			System.out.println(linea1.EscribirLinea());
			System.out.println("\nmoviendo la línea hacia abajo 2");
			linea1.mueveAbajo(2);
			System.out.println(linea1.EscribirLinea());
		}catch (IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}
		
		try {
			Punto punto3 = new Punto (0,0);
			System.out.println("\nProbando filtro para coordenadas negativas x-1");
			punto3.setX(-1);
		}catch (IllegalArgumentException excepcion3) {
			System.out.println(excepcion3.getMessage());
		}
		
		try {
			Punto punto4 = new Punto (0,0);
			System.out.println("Probando filtro para coordenadas negativas y-1");
			punto4.setY(-1);
		}catch (IllegalArgumentException excepcion4) {
			System.out.println(excepcion4.getMessage());
		}
		
		try {
			Punto punto5 = new Punto (0, 2);
			Punto punto6 = new Punto (4, 6);
			Linea linea2 = new Linea (punto5, punto6);
			System.out.println("\n" + linea2.EscribirLinea());
			System.out.println("moviendo la linea a la izquierda 5");
			linea2.mueveIzquierda(5);			
		}catch (IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}
		
		try {
			Punto punto7 = new Punto (0, 2);
			Punto punto8 = new Punto (4, 6);
			Linea linea3 = new Linea (punto7, punto8);
			System.out.println("\n" + linea3.EscribirLinea());
			System.out.println("moviendo la linea hacia abajo 5");
			linea3.mueveAbajo(5);			
		}catch (IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}
	}

}
