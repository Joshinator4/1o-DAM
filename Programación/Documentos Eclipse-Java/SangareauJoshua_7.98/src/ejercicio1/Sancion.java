/*
 * Objetivo:Para la gestión de sanciones de tráfico de un municipio se necesita: la matrícula del vehículo, fecha y hora, lugar de la infracción.
 * Autor: Joshua Sangareau Quesada
 * fecha: 04/04/2024
 *
 */
package ejercicio1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Sancion implements Comparable<Sancion>{
	
	//Atributos estaticos de la clase
	private LocalDateTime ahora = LocalDateTime.now();
		
	//metodos de clase.
	protected String matricula;
	protected LocalDateTime fecha;
	protected String lugarInfraccion;
	
	
	
	
	public Sancion(String matricula, LocalDateTime fecha, String lugarInfraccion) {
		this.matricula = matricula;
		this.fecha = fecha;
		this.lugarInfraccion = lugarInfraccion;
	}
	
	//metodo declarado abstracto para obligar a las clases que heredan que lo implementen
	public abstract double calcularSancion();
	
	
	//metodos getters y setters de la clase
	public String getMatricula() {
		return matricula;
	}
	
	public double calculoSuplementoDescuento(double precio) {
		double devolucion = precio;
		
		if(Math.abs(ChronoUnit.DAYS.between(fecha, ahora)) > 90) {
			devolucion = devolucion*1.25;
		}else if(Math.abs(ChronoUnit.DAYS.between(fecha, ahora)) < 30) {
			devolucion -= (devolucion*0.1);
		}
		return devolucion;
	}

	@Override
	public String toString() {
		return "Sancion [matricula=" + matricula + ", fecha=" + fecha + ", lugarInfraccion=" + lugarInfraccion + "]";
	}
	
	//Metodo comparador para ordenar las sanciones en el listado por matricula
	@Override
	public int compareTo(Sancion o) {
		return this.matricula.compareTo(o.getMatricula());
	}
	
	
}
