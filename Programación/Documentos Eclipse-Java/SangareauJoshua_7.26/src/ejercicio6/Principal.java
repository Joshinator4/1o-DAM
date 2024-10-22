package ejercicio6;

public class Principal {

	public static void main(String[] args) {
		iFigura2D listaFiguras [] = new iFigura2D[4];
		try {
			listaFiguras[0] = new Cuadrado(4);
			listaFiguras[1] = new Rectangulo(3, 5);
			listaFiguras[2] = new Triangulo(4, 7);
			listaFiguras[3] = new Circulo(8);
		}catch(IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}catch(Exception excepcion2) {
			System.out.println(excepcion2.getMessage());
		}
		
		for(int i = 0; i < listaFiguras.length; i++) {
			listaFiguras[i].imprimir();
		}
		
		System.out.println("-------------------------------------------------------------------------");
		
		for(int i = 0; i < listaFiguras.length; i++) {
			listaFiguras[i].escalar(2);
		}
		
		for(int i = 0; i < listaFiguras.length; i++) {
			listaFiguras[i].imprimir();
		}
		
		System.out.println("-------------------------------------------------------------------------");
		
		for(int i = 0; i < listaFiguras.length; i++) {
			listaFiguras[i].escalar(0.1);
		}
		
		for(int i = 0; i < listaFiguras.length; i++) {
			listaFiguras[i].imprimir();
		}

	}

}
