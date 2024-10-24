package ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Contacto implements Comparable <Contacto>{
	
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private LocalDate fechaNacimiento;
	
	public Contacto(String nombre, String direccion, String telefono, String email, LocalDate fechaNacimiento) {
		this.nombre = nombre.toLowerCase();
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		
	}
	
	public Contacto() {
		this("pepito", "Calle desengaño 2", "900500200", "emilio@emilio.es", LocalDate.of(1990, 11, 19));
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	


	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	
	
	@Override
	public int compareTo(Contacto o) {
		return this.nombre.compareTo(o.getNombre());
	}

}
