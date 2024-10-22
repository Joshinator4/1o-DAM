package ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;

public class SocioMejorado {
	
	enum TipoCliente{NORMAL, JUBILADO, INFANTIL}
	
	private static int contadorCliente=1;
	
	private final int codigoCliente;
	
	protected String nombre;
	protected String dni;
	protected TipoCliente tipo;
	protected ArrayList<Curso> arrayCursos;
	
	public SocioMejorado(String nombre, String dni, TipoCliente tipo) {
		this.codigoCliente = contadorCliente;
		this.nombre = nombre;
		this.dni = dni;
		this.tipo = tipo;
		arrayCursos = new ArrayList<>();
		contadorCliente++;
		
	}
	
	//este metodo añade al array de cursos el curso para luego calcular las cuotas
	public void matricularEnCurso(Curso curso) throws IllegalArgumentException{
		if(this.arrayCursos.size() < 5) {
			this.arrayCursos.add(curso);
		}else {
			throw new IllegalArgumentException("No se pueden matricular mas socios, numero maximo alcanzado");
		}
		
	}
	
	//este metodo calcula las cuotas de los socios
	public double calcularCuota() {
		double devolucion=0;
		for(Curso i: this.arrayCursos) {
			devolucion += i.getPrecio();
		}
		if(this.tipo.equals(TipoCliente.NORMAL)) {
			devolucion += 50;
		}else if(this.tipo.equals(TipoCliente.JUBILADO)) {
			devolucion += 50;
			devolucion -= devolucion*0.1;
		}else {
			devolucion += 25;
		}
		
		return devolucion;
	}


	public String getNombre() {
		return nombre;
	}


	public String getDni() {
		return dni;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public int getCodigoCliente() {
		return codigoCliente;
	}

	public ArrayList<Curso> getArrayCursos() {
		return arrayCursos;
	}

	@Override
	public String toString() {
		return "Socio [codigoCliente=" + codigoCliente + ", nombre=" + nombre + ", dni=" + dni + ", tipo=" + tipo
				+ ", cuota=" + calcularCuota() + ", \nCursos matriculados=" + arrayCursos.toString() + "]";
	}


	
	
	
	
	
}