package ejercicio1;

public class Atleta {
	
	private String nombre;
	private int edad;
	private double altura;
	
	public Atleta (String nombre, int edad, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
	}
	
	public Atleta() {
		this("nombre desconocido", 20, 1.75);
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public double getAltura() {
		return altura;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	

}
