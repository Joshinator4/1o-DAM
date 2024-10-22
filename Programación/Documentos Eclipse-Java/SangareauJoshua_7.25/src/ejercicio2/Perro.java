package ejercicio2;

import java.time.LocalDate;

public class Perro extends Mascota{
	
	private String raza;
	private boolean pulgas;
	
	public Perro(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, String raza, boolean pulgas) {
		
		super(nombre, edad, estado, fechaNacimiento);
		this.raza = raza;
		this.pulgas = pulgas;
	}
	
	public Perro(String raza, boolean pulgas) {
		super();
		this.raza = raza;
		this.pulgas = pulgas;
	}
	
	public Perro(String nombre) {
		super(nombre);
		this.raza = "Raza Desconocida";
		this.pulgas = false;
		
	}
	
	public Perro() {
		super();
		this.raza = "Raza Desconocida";
		this.pulgas = false;
		
	}

	@Override
	public String habla() {
		return  "El perro hace: ¡Guau, Guau!";
	}

	@Override
	public String muestra() {
		return super.muestra() + "Perro [raza=" + raza + ", pulgas=" + pulgas + "]";
	}
	
	
}
