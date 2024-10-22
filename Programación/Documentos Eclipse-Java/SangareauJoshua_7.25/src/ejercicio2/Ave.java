package ejercicio2;

import java.time.LocalDate;

public abstract class Ave extends Mascota{
	protected String pico;
	protected boolean vuela;
	protected boolean estaVolando;
	
	public Ave(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, String pico, boolean vuela) throws IllegalArgumentException{
		super(nombre, edad, estado, fechaNacimiento);
		this.pico = pico;
		this.vuela = vuela;
	}
	public Ave(String pico, boolean vuela) {
		super();
		this.pico = pico;
		this.vuela = vuela;
	}
	public Ave(String nombre) {
		super(nombre);
		this.pico = "Tipo Desconocido";
		this.vuela = true;
	}
	
	public Ave() {
		super();
		this.pico = "Tipo Desconocido";
		this.vuela = true;
	}
	
	public abstract String volar();

	@Override
	public String muestra() {
		return super.muestra() + "Ave [pico=" + pico + ", vuela=" + vuela + "]";
	}
}
