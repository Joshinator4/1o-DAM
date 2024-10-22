/*
 * Objetivo:CRECION DE UNA CLASE CASA
 * Autor: Joshua Sangareau Quesada
 * fecha: 11/03/2024
 */
package inmobiliaria;

import java.time.LocalDate;

public class Vivienda extends Inmueble{
	
	
	//Atributo estaticos
	private static LocalDate fecha_defecto = LocalDate.of(2001, 1, 1);
	//Atributos de objeto
	private int numHabitaciones;
	private int numBanhos;
	private LocalDate fechaConst;
	private double valorMetro;
	
	public Vivienda(int superficie, String propietario, String direccion, int habitaciones, int banhos, double valor, LocalDate fecha) throws IllegalArgumentException {
		super(superficie, propietario, direccion);
		this.numHabitaciones = habitaciones;
		this.numBanhos = banhos;
		this.fechaConst = fecha;
		this.valorMetro = this.superficie * valor;
		if(this.fechaConst.getYear() < 2000) {
			this.valorMetro = this.valorMetro * 0.6;
		}
		
	}
	public Vivienda(int habitaciones, int banhos, double valor, LocalDate fecha) throws IllegalArgumentException {
		super();
		this.numHabitaciones = habitaciones;
		this.numBanhos = banhos;
		this.fechaConst = fecha;
		this.valorMetro = this.superficie * valor;
		if(this.fechaConst.getYear() < 2000) {
			this.valorMetro = this.valorMetro * 0.6;
		}
	}
	
	public Vivienda() throws IllegalArgumentException {
		super();
		this.numHabitaciones = 2;
		this.numBanhos = 1;
		this.fechaConst = fecha_defecto;
		this.valorMetro = this.superficie * 1000;
		if(this.fechaConst.getYear() < 2000) {
			this.valorMetro = this.valorMetro * 0.6;
		}
	}
	public int getNumHabitaciones() {
		return numHabitaciones;
	}
	
	public int getNumBanhos() {
		return numBanhos;
	}
	
	public LocalDate getFechaConst() {
		return fechaConst;
	}
	
	public double getValorMetro() {
		return valorMetro;
	}
	
	
	
		
}


