package ejercicio1;

public class Principal {

	public static void main(String[] args) {
		Astro listaAstros [] = new Astro [150]; //Array de Astros que guardará para cada planeta y cada satélite creado
		int contadorAstros = 0;
		
		try {
			Planeta tierra = new Planeta();
			listaAstros [contadorAstros] = tierra;
			contadorAstros++;
			Planeta marte = new Planeta();
			listaAstros [contadorAstros] = marte;
			contadorAstros++;
			Planeta venus = new Planeta();
			listaAstros [contadorAstros] = venus;
			contadorAstros++;
			Satelite satelite1 = new Satelite(1);
			listaAstros [contadorAstros] = satelite1;
			contadorAstros++;
			Satelite satelite2 = new Satelite(1);
			listaAstros [contadorAstros] = satelite2;
			contadorAstros++;
			Satelite satelite3 = new Satelite(2);
			
			tierra.agregarSateliteAPlaneta(satelite1);
			tierra.agregarSateliteAPlaneta(satelite2);
			marte.agregarSateliteAPlaneta(satelite3);
			
			System.out.println(tierra.muestra());
			System.out.println(marte.muestra());	
								

		} catch (IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		} catch (IllegalStateException excepcion2) {
			System.out.println(excepcion2.getMessage());
		} catch (Exception excepcion3) {
			System.out.println(excepcion3.getMessage());
		}
	}
	

}
