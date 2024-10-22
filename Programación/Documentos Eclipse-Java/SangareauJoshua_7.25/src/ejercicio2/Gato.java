package ejercicio2;

import java.time.LocalDate;

public class Gato extends Mascota{
	private String color;
	private boolean peloLargo;
	
	
	public Gato(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, String color, boolean peloLargo) throws IllegalArgumentException{
		super(nombre, edad, estado, fechaNacimiento);
		this.color = color;
		this.peloLargo = peloLargo;
	}
	
	public Gato(String color, boolean peloLargo) {
		super();
		this.color = color;
		this.peloLargo = peloLargo;
	}
	
	public Gato(String nombre) {
		super(nombre);
		this.color = "Negro";
		this.peloLargo = false;
	}
	
	public Gato() {
		super();
		this.color = "Negro";
		this.peloLargo = false;
	}
	
	
	@Override
	public String habla() {
		return "El gato Hace: ¡Miau, Miau!";
	}

	@Override
	public String muestra() {
		return super.muestra() + "Gato [color=" + color + ", peloLargo=" + peloLargo + "]";
	}


	
	
	
}
