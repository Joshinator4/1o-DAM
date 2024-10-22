package ejercicioB2;

public class Alumno implements Comparable<Alumno>{
	
	
	private String nombre;
	private String apellido;
	private double media;

	public Alumno(String nombre, String apellido, double media) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.media = media;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}



	public double getMedia() {
		return media;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public void setMedia(double media) {
		this.media = media;
	}




	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", media=" + media + "]\n";
	}


	@Override
	public int compareTo(Alumno o) {
		int devolucion = 0;
		if(media > o.getMedia()) {
			devolucion = -1;
		}else if(media < o.getMedia()) {
			devolucion = 1;
		}else {
			devolucion = 0;
		}
		return devolucion;
	}
	
	
	
	
}
