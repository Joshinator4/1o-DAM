package ejercicio1;

public class Humano {
	
	protected String nombre;
	protected String apellido;
	
	public Humano (String nombre, String apellido){
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Humano (){
		this("Juan", "García");
	}
	
	public String getNombreCompleto() {
		return this.apellido + ", " + this.nombre;
	}
	
}
