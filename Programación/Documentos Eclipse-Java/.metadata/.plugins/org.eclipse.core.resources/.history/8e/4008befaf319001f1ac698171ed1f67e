package ejercicio1;

/*Autor: Joshua Sangareau Quesada
Fecha: 23 may 2024 
Descripcion: clase Vehiculo
*/
public abstract class Vehiculo implements Comparable<Vehiculo>{
	
	protected String matricula;
	protected String dni;
	protected String telefono;
	protected String modelo;
	
	
	public Vehiculo(String matricula, String dni, String telefono, String modelo) {
		this.matricula = matricula;
		this.dni = dni;
		this.telefono = telefono;
		this.modelo = modelo;
	}


	public String getMatricula() {
		return matricula;
	}


	public String getDni() {
		return dni;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", dni=" + dni + ", telefono=" + telefono + "]";
	}


	@Override
	public int compareTo(Vehiculo o) {
		return this.matricula.compareTo(o.getMatricula());
	}

	//metodo abstracto para calcular el precio segun coche o moto
	public abstract double calcularPrecio(int dias);
	

}
