/*
 * Objetivo:Clase Revision Alarma hereda de Servicio
 * Autor: Joshua Sangareau Quesada
 * fecha: 25/04/2024
 * 
 */
package ejercicio1;

import java.time.LocalDate;

public class RevisionAlarma extends Servicio{
	
	private int sensores;
	private String modelo;

	
	public RevisionAlarma(LocalDate fecha_servicio, String cliente, int sensores, String modelo) {
		super("Manuel Fernández", fecha_servicio, cliente);
		this.sensores = sensores;
		this.modelo = modelo;
		this.material = calcularMaterial();
		this.manoObra = calcularManoObra();
		
	}

	//metodo heredado para calcular el precio del material
	@Override
	protected double calcularMaterial() {
		double devolucion=0;
		return devolucion;
	}
	//metodo heredado para calcular el precio de la mano de obra 
	@Override
	protected double calcularManoObra() {
		double devolucion;
		devolucion = sensores/3*40;
		
		return devolucion;
	}


	public int getSensores() {
		return sensores;
	}


	public String getModelo() {
		return modelo;
	}


	public void setSensores(int sensores) {
		this.sensores = sensores;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	@Override
	public String toString() {
		return super.toString() + "RevisionAlarma [sensores=" + sensores + ", modelo=" + modelo +  ", material=" + material
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
