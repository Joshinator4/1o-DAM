package ejercicioB3;

public class Persona implements Comparable<Persona>{
	
	private String nombre;
	private String apellido;
	
	
	public Persona(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	


	public String getNombre() {
		return nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + "]";
	}




	@Override
	public int compareTo(Persona o) {
		int devolucion;
		if(apellido.compareTo(o.getApellido()) < 0) {
			devolucion = -1;
		}else if(apellido.compareTo(o.getApellido()) > 0) {
			devolucion = 1;
		}else {
			if(nombre.compareTo(o.getNombre()) < 0) {
				devolucion = -1;
			}else if(nombre.compareTo(o.getNombre()) > 0) {
				devolucion = 1;
			}else {
				devolucion = 0;
			}
		}
		return devolucion;
	}
	
	
	
	
	
}
