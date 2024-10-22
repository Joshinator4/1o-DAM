package tiendaFiguras;

public class Superheroe {
	
	private String nombre;
	private String descripcion;
	private boolean capa;
	
	
	public Superheroe(String nombre) {
		this.nombre = nombre;
		
	}


	public String getNombre() {
		return nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public boolean isCapa() {
		return capa;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public void setCapa(boolean capa) {
		this.capa = capa;
	}


	@Override
	public String toString() {
		return "Superheroe [nombre=" + nombre + ", descripcion=" + descripcion + ", capa=" + capa + "]";
	}
	
	
	
	

}
