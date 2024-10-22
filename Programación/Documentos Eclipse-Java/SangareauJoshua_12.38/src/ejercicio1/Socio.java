package ejercicio1;

import java.util.ArrayList;

/*Autor: Joshua Sangareau Quesada
Fecha: 20 may 2024 
Descripcion: clase Socio
*/
public abstract class Socio implements Comparable<Socio>{
	
	private static int contadorSocio=1;
	
	protected String nombre;
	protected String dni;
	protected String telefono;
	protected int identificador;
	
	
	public Socio(String nombre, String dni, String telefono){
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.identificador = contadorSocio;
		contadorSocio ++;
		
	}


	public static int getContadorSocio() {
		return contadorSocio;
	}


	public String getNombre() {
		return nombre;
	}


	public String getDni() {
		return dni;
	}


	public String getTelefono() {
		return telefono;
	}


	public int getIdentificador() {
		return identificador;
	}


	public static void setContadorSocio(int contadorSocio) {
		Socio.contadorSocio = contadorSocio;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public abstract void agregarListaPartidos(Partido partido);
	
	public abstract int calcularCuota();
	
	public abstract boolean comprobarSiHajugado();

	@Override
	public String toString() {
		return "Socio [nombre=" + nombre + ", dni=" + dni + ", telefono=" + telefono + ", identificador="
				+ identificador + "]";
	}
	


	public int compareTo(Socio o) {
		return this.nombre.compareTo(o.getNombre());
	}
	
	
	

}
