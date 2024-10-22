/*
 * Objetivo:Clase Curso con los atributos y metodos necesrios para esta clase
 * Autor: Joshua Sangareau Quesada
 * fecha: 21/03/2024
 * 
 */
package ejercicio1;

public class Curso {
	
	private static int contadorCurso = 1;
	
	private final int codigoCurso;
	
	
	private String nombre;
	private String descripcion;
	private double precio;
	private int maxAlumnos;
	private int contadorAlumnos = 0;
	
	
	public Curso(String nombre, String descripcion, double precio, int maxAlumnos) {
		
		this.codigoCurso = contadorCurso;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.maxAlumnos = maxAlumnos;
		contadorCurso++;
		
	}

	public String getNombre() {
		return nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public int getMaxAlumnos() {
		return maxAlumnos;
	}
	
	

	public int getCodigoCurso() {
		return codigoCurso;
	}

	


	public int getContadorAlumnos() {
		return contadorAlumnos;
	}

	public void setContadorAlumnos(int contadorAlumnos) {
		this.contadorAlumnos = contadorAlumnos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public void setMaxAlumnos(int maxAlumnos) {
		this.maxAlumnos = maxAlumnos;
	}

	@Override
	public String toString() {
		return "Curso [codigoCurso=" + codigoCurso + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + ", maxAlumnos=" + maxAlumnos + "]";
	}
	
	
	
	
}
