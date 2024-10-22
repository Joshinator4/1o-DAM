/*
 * Objetivo:Clase Socio con los atributos y metodos necesrios para esta clase
 * Autor: Joshua Sangareau Quesada
 * fecha: 21/03/2024
 * 
 */
package ejercicio1;

import java.util.Arrays;

public class Socio {
	
	/*enum TipoCliente{NORMAL, JUBILADO, INFANTIL}
	
	private static int contadorCliente=1;
	
	private final int codigoCliente;
	
	protected String nombre;
	protected String dni;
	protected TipoCliente tipo;
	protected double cuota=0;
	protected Curso[] arrayCursos;
	protected int contadorCurso=0;
	
	public Socio(String nombre, String dni, TipoCliente tipo) {
		this.codigoCliente = contadorCliente;
		this.nombre = nombre;
		this.dni = dni;
		this.tipo = tipo;
		arrayCursos = new Curso[5];
		contadorCliente++;
		
	}
	
	//este metodo añade al array de cursos el curso para luego calcular las cuotas
	public void matricularEnCurso(Curso curso) {
		if(contadorCurso < 5) {
			this.arrayCursos[contadorCurso]=curso;
			contadorCurso++;
		}
		
	}
	
	//este metodo calcula las cuotas de los socios
	public void calcularCuota() {
		this.cuota = 0;
		for(int i =0; i<5; i++) {
			if(arrayCursos[i] != null) {
			this.cuota += arrayCursos[i].getPrecio();
			}
		}
		
		if(this.tipo.equals(TipoCliente.NORMAL)) {
			this.cuota += 50;
		}else if(this.tipo.equals(TipoCliente.JUBILADO)) {
			this.cuota += 50;
			this.cuota -= this.cuota*0.1;
		}else {
			this.cuota += 25;
		}
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


	@Override
	public String toString() {
		return "Socio [codigoCliente=" + codigoCliente + ", nombre=" + nombre + ", dni=" + dni + ", tipo=" + tipo
				+ ", cuota=" + cuota + ", \nCursos matriculados=" + Arrays.toString(arrayCursos) + "]";
	}

*/
	
	
	
	
	
}
