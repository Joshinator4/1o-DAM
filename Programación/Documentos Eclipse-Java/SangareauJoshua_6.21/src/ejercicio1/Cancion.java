package ejercicio1;

public class Cancion {

	//Atributos de objeto
	private String titulo;
	private String autor;
	
	
	//Constructores de la clase
	public Cancion(String titulo, String autor)  throws IllegalArgumentException{
		ponTitulo(titulo);
		ponAutor(autor);
	}
	
	public Cancion() throws IllegalArgumentException{
		this("Titulo Desconocido", "Autor Anonimo");
	}
	
	//Constructor-clonador
	public Cancion(Cancion x) {
		this.titulo = x.titulo;
		this.autor = x.autor;
	}
	
	
	
	//Metodos setters y getters
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public void setTitulo(String titulo) throws IllegalArgumentException {
		if(titulo == null || titulo.isEmpty()) {
			throw new IllegalArgumentException("ERROR: el titulo no puede ser nulo o cadena de texto vacía");
		}
		this.titulo = titulo;
	}
	
	public void setAutor(String autor)  throws IllegalArgumentException{
		if(autor == null || autor.isEmpty()) {
			throw new IllegalArgumentException("ERROR: el autor no puede ser nulo o cadena de texto vacía");
		}
		this.autor = autor;
	}
	
	//devuelve el nombre del título
	public String dameTitulo(){
		return getTitulo();
	}
	
	//devuelve el titulo del autor
	public String dameAutor() {
		return getAutor();
	}
	
	//Agrega un titulo a una cancion
	public void	ponTitulo(String titulo) throws IllegalArgumentException{
		setTitulo(titulo);
	}
	//Agrega el nombre del autor a una cancion
	public void ponAutor(String autor)  throws IllegalArgumentException{
		setAutor(autor);
	}
	
	//Clona la cancion pasada como argumento
	public void clonarCancion(Cancion x) {
		this.titulo = x.titulo;
		this.autor = x.autor;
	}
	
	//Devuelve un string con los valores de los atributos de la clase Cancion
	public String toString() {
		return String.format("Título de la canción: %s, autor de la canción: %s", getTitulo(), getAutor());
	}
}
