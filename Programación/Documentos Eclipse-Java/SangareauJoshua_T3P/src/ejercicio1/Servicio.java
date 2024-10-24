/*
 * Objetivo:Clase servicio de la cual heredarán las demas
 * Autor: Joshua Sangareau Quesada
 * fecha: 16/04/2024
 * 
 */
package ejercicio1;

import java.time.LocalDate;

public abstract class Servicio implements Comparable<Servicio>{
	
	private static int contadorId =0;
	
	private String trabajador;
	protected LocalDate fecha_servicio;
	protected String cliente;
	protected String Identificador;
	protected double material;
	protected double manoObra;
	
	public Servicio(String trabajador, LocalDate fecha_servicio, String cliente) {
		this.trabajador = trabajador;
		this.fecha_servicio = fecha_servicio;
		this.cliente = cliente;
		this.Identificador = generarId(fecha_servicio);
		contadorId++;
	}
	
	//este método genera un id para cada objeto instanciado. 
	private String generarId(LocalDate fecha) {
		String devolucion;
		if(contadorId < 10) {
			devolucion = fecha.getYear() + "-00"  + contadorId;
		}else if(contadorId < 100) {
			devolucion = fecha.getYear() + "-0" + contadorId;
		}else {
			devolucion = fecha.getYear() + "-" + contadorId;
		}
		devolucion = fecha.getYear() + "-" + contadorId;
		return devolucion;
	}


	
	public String getTrabajador() {
		return trabajador;
	}


	public LocalDate getFecha_servicio() {
		return fecha_servicio;
	}


	public String getCliente() {
		return cliente;
	}


	public String getIdentificador() {
		return Identificador;
	}


	public void setTrabajador(String trabajador) {
		this.trabajador = trabajador;
	}


	public void setFecha_servicio(LocalDate fecha_servicio) {
		this.fecha_servicio = fecha_servicio;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public void setIdentificador(String identificador) {
		Identificador = identificador;
	}
	
	
	
	public double getMaterial() {
		return material;
	}


	public double getManoObra() {
		return manoObra;
	}


	public void setMaterial(double material) {
		this.material = material;
	}


	public void setManoObra(double manoObra) {
		this.manoObra = manoObra;
	}

	//metodos abstractos para calcular el precio de la mano de obra y el material
	protected abstract double calcularMaterial();
	
	protected abstract double calcularManoObra();


	@Override
	public String toString() {
		return "Servicio [trabajador=" + trabajador + ", fecha_servicio=" + fecha_servicio + ", cliente=" + cliente
				+ ", Identificador=" + Identificador + "]";
	}
	@Override
	public int compareTo(Servicio o) {
		int devolucion = cliente.compareTo(o.cliente);
		if(devolucion == 0) {
			devolucion = fecha_servicio.compareTo(o.fecha_servicio);
		}
		return devolucion;
	}
	
	
	
}
