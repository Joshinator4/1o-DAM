package crearTablaOrdenada;

public class Libro implements Comparable<Libro>{
	
	private int id_libro;
	private String titulo;
	private int id_autor;
	public Libro(int id_libro, String titulo, int id_autor) {
		
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.id_autor = id_autor;
	}
	
	
	public String getTitulo() {
		return titulo;
	}


	public int getId_libro() {
		return id_libro;
	}


	public int getId_autor() {
		return id_autor;
	}


	@Override
	public int compareTo(Libro o) {
		return this.titulo.compareTo(o.getTitulo());
	}
	
	
}
