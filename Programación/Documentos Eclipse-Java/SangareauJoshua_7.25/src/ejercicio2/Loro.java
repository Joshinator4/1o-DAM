package ejercicio2;

import java.time.LocalDate;

public class Loro extends Ave{
	
	private String origen;
	private boolean habla;
	
	public Loro(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, String pico, boolean vuela, String origen, boolean habla) throws IllegalArgumentException{
		super(nombre, edad, estado, fechaNacimiento, pico, vuela);
		setOrigen(origen);
		setHabla(habla);
	}
	
	public Loro(String pico, boolean vuela, String origen, boolean habla) {
		super(pico, vuela);
		setOrigen(origen);
		setHabla(habla);
	}
	
	public Loro(String nombre) {
		super(nombre);
		setOrigen("Origen Desconocido");
		setHabla(false);
	}
	
	public Loro() {
		super();
		setOrigen("Origen Desconocido");
		setHabla(false);
	}
	
	

	public String getOrigen() {
		return origen;
	}



	public void setOrigen(String origen) {
		this.origen = origen;
	}



	public boolean isHabla() {
		return habla;
	}



	public void setHabla(boolean habla) {
		this.habla = habla;
	}



	@Override
	public String volar() {
		return "El loro tiene un aleteo horizontal";
	}

	@Override
	protected String habla() {
		String devolucion;
		if(this.habla == true) {
			devolucion = "El loro dice: buenos dias";
		}else {
			devolucion = "El loro no habla";
		}
		return devolucion;
	}
	
	@Override
	public String muestra() {
		return super.muestra() + "Loro [origen=" + origen + ", habla=" + habla + "]";
	}

}
