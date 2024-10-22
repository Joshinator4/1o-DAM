package ejercicio2;

import java.time.LocalDate;

public class Canario extends Ave{
	private String color;
	private boolean canta;
	
	public Canario(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, String pico, boolean vuela, String color, boolean canta) throws IllegalArgumentException{
		super(nombre, edad, estado, fechaNacimiento, pico, vuela);
		setColor(color);
		setCanta(canta);
	}
	
	public Canario(String pico, boolean vuela, String color, boolean canta) {
		super(pico, vuela);
		setColor(color);
		setCanta(canta);
	}
	
	public Canario(String nombre) {
		super(nombre);
		setColor("Color Desconocido");
		setCanta(false);
		
	}
	
	public Canario() {
		super();
		setColor("Color Desconocido");
		setCanta(false);
	}
	
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isCanta() {
		return canta;
	}

	public void setCanta(boolean canta) {
		this.canta = canta;
	}

	@Override
	public String volar() {
		return "El canario tiene un aleteo vertical";
	}

	@Override
	protected String habla() {
		return "El canario dice: ¡Pio, Pio!";
	}

	@Override
	public String muestra() {
		return super.muestra() + "Canario [color=" + color + ", canta=" + canta + "]";
	}
	
	
	
}
