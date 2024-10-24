/*
 * Objetivo:Clase Pintura hereda de servicio
 * Autor: Joshua Sangareau Quesada
 * fecha: 25/04/2024
 * 
 */
package ejercicio1;

import java.time.LocalDate;

public class Pintura extends Servicio{

	private int superficie;
	private double precioPint;
	
	public Pintura(String trabajador, LocalDate fecha_servicio, String cliente, int superficie, double precioPint)  throws IllegalArgumentException{
		super(trabajador, fecha_servicio, cliente);
		if(superficie > 0) {
			this.superficie = superficie;
		}else {
			throw new IllegalArgumentException("ERROR la superficie no puede ser negativa");
		}
		
		this.precioPint = precioPint;
		this.material = calcularMaterial();
		this.manoObra = calcularManoObra();
		
	}
	
	//metodo heredado para calcular el precio del material
	@Override
	protected double calcularMaterial() {
		double devolucion;
		devolucion = (double)superficie*7.8*precioPint;
		return devolucion;
	}
	//metodo heredado para calcular el precio de la mano de obra 
	@Override
	protected double calcularManoObra() {
		double devolucion;
		if(superficie < 50) {
			devolucion = (double)(superficie/10)*7.5;
			devolucion += devolucion*0.15;
		}else {
			devolucion = (double)superficie/10*7.5;
		}
		
		return devolucion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public double getPrecioPint() {
		return precioPint;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public void setPrecioPint(double precioPint) {
		this.precioPint = precioPint;
	}

	@Override
	public String toString() {
		return super.toString() + "Pintura [superficie=" + superficie + ", precioPint=" + precioPint + ", material=" + material
				+ ", manoObra=" + manoObra + "]\n";
	}
	//método compare de la clase q ordena por el cliente
	@Override
	public int compareTo(Servicio o) {
		int devolucion = cliente.compareTo(o.cliente);
		if(devolucion == 0) {
			devolucion = fecha_servicio.compareTo(o.fecha_servicio);
		}
		return devolucion;
	}
	
	
	
}
