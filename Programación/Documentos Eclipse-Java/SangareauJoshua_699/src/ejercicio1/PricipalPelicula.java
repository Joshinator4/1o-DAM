package ejercicio1;

public class PricipalPelicula {

	public static void main(String[] args) {
		try {
			Pelicula pelicula1 = new Pelicula ("Gandhi", "Attenborough", 191, 1982, 8.1, Pelicula.Genero.DRAMA);
			System.out.println("La pelicula es epica: " + pelicula1.siONo(pelicula1.esPeliculaEpica()));
			System.out.println("La valoracion de la pelicula es: " + pelicula1.calcularValoracion());
			
			Pelicula pelicula2 = new Pelicula ("Thor", "Branagh", 115, 2011, 7.0, Pelicula.Genero.ACCION);
			System.out.println("La pelicula es epica: " + pelicula2.siONo(pelicula2.esPeliculaEpica()));
			System.out.println("La valoracion de la pelicula es: " + pelicula2.calcularValoracion());
			System.out.println("La pelicula es similar: " + pelicula2.siONo(pelicula1.esSimilar(pelicula2)));
			
		}catch(IllegalArgumentException excepcion1){
			System.out.println(excepcion1.getMessage());
		}catch(Exception excepcion2){
			System.out.println(excepcion2.getMessage());
		}
			
		try {
			Pelicula pelicula3 = new Pelicula ("Gandhi", "Attenborough", -191, 1982, 8.1, Pelicula.Genero.DRAMA);
		}catch(IllegalArgumentException excepcion3) {
			System.out.println(excepcion3.getMessage());
		}catch(Exception excepcion4){
			System.out.println(excepcion4.getMessage());
		}
		try {
			Pelicula pelicula4 = new Pelicula ("Gandhi", "Attenborough", 191, 1940, 8.1, Pelicula.Genero.DRAMA);
		}catch(IllegalArgumentException excepcion5) {
			System.out.println(excepcion5.getMessage());
		}catch(Exception excepcion6){
			System.out.println(excepcion6.getMessage());
		}
		
		System.out.println("Minutos acumulados de todas las peliculas: " + Pelicula.duracionTodas);

	}

}
