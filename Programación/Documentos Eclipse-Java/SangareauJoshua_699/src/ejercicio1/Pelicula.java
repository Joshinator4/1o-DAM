package ejercicio1;

public class Pelicula {
	enum Genero {ACCION, COMEDIA, DRAMA, SUSPENSO};
	
	public static int duracionTodas = 0;//cantidad de tiempo de películas en minutos. Será la duración total de todas las películas.
	
	private String nombre;//es el nombre de la película.
	private String director; // representa el nombre del director de la película.
	private int duracion; // duración de la película en minutos. La duración nunca podrá ser negativa.
	private int anho; //representa el año de realización de la película. Nunca podrá ser inferior a 1950.
	private double calificacion; // es la valoración de la película por parte de sus usuarios.
	private Genero generoPelicula;
	
	public Pelicula(String nombre, String director,int duracion, int anho, double calificacion, Genero genero) {
		this.nombre = nombre;
		this.director = director;
		if(duracion<0) {
			throw new IllegalArgumentException("La duracion de la película no puede ser negativa");
		}else {
			this.duracion = duracion;
		}
		if(anho < 1950) {
			throw new IllegalArgumentException("La pelicula no puede ser anterior a 1950");
		}
		this.calificacion = calificacion;
		this.generoPelicula = genero;
		duracionTodas += this.duracion;
	}
	
	public int getDuracion() {
		return this.duracion;
	}
		
	//Un método esPeliculaEpica, el cual devuelve un valor verdadero si la duración de la película 
	//es mayor o igual a tres horas, en caso contrario devuelve falso.
	public boolean esPeliculaEpica () {
		boolean devolucion;
		if(this.duracion > 180) {
			devolucion = true;
		}else {
			devolucion = false;
		}
		return devolucion;
	}
	
	/*
	 * Un método calcularValoración, el cual devuelve una valoración subjetiva según:
	De 0 a 2 , valoración muy mala.
	De 2 a 5, mala.
	De 5 a 7, regular.
	De 7 a 8, buena.
	De 8 a 10, excelente.
	 */
	
	public String calcularValoracion(){
		String devolucion = null;
		if(this.calificacion >= 0 && this.calificacion < 2) {
			devolucion = "Muy mala";
		}else if(this.calificacion >= 2 && this.calificacion < 5){
			devolucion = "Mala";
		}else if(this.calificacion >= 5 && this.calificacion < 7) {
			devolucion = "Regular";
		}else if(this.calificacion >= 7 && this.calificacion < 8) {
			devolucion = "Buena";
		}else if(this.calificacion >= 8 && this.calificacion < 10) {
			devolucion = "Excelente";
		}
		return devolucion;
	}
	
	
	//Un método esSimilar, compara la película actual con otra película que se le pasa como parámetro. Si ambas películas son del mismo 
	//género y tienen la misma valoración, devuelve verdadero; en caso contrario, devuelve falso.
	public boolean esSimilar (Pelicula peli) {
		boolean devolucion;
		if(peli.generoPelicula == this.generoPelicula && peli.calcularValoracion() == calcularValoracion()) {
			devolucion = true;
		}else {
			devolucion = false;
		}
		return devolucion;
	}
	
	//Un método que devuelva todos los valores de los atributos.
	public String toString() {
		return String.format("nombre: %s, director: %s, duracion: %d, año: %d, calificacion: %.2f, genero: %s", this.nombre, this.director, this.duracion, this.anho, this.calificacion, this.generoPelicula);
	}
	public String siONo(boolean metodo) {
		String devolucion;
		if(metodo == true) {
			devolucion = "Si";
		}else {
			devolucion = "No";
		}
		return devolucion;
	}
	
	
	
	
}
