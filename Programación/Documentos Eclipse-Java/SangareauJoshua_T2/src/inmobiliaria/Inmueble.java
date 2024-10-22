/*
 * Objetivo:CRECION DE UNA CLASE INMUEBLE
 * Autor: Joshua Sangareau Quesada
 * fecha: 11/03/2024
 */

package inmobiliaria;

import java.time.LocalDate;

public class Inmueble {
	
	//atributos estaticos finales
	public static final int MAX_SUP = 150;
	public static final int MIN_SUP = 60;
	public static final int DEFECTO_SUP = 100;
	public static final String PROP_DEFECTO = "Sin propietario";
	public static final String DIREC_DEFECTO = "Sin direccion";
	
	//atributos estaticos de clase
	private static int contadorInmueble= 1;
	
	//atributos de objeto
	protected int superficie;
	protected String propietario;
	protected LocalDate fecha;
	protected String direccion;
	
	public Inmueble(int superficie, String propietario, String direccion) throws IllegalArgumentException {
		if(superficie < MIN_SUP || superficie > MAX_SUP) {
			throw new IllegalArgumentException("La superficie no puede ser menor a 60 o superior a 150 metros cuadrados");
		}else {
			this.superficie = superficie;
		}
		this.propietario = propietario;
		this.fecha = LocalDate.now();
		this.direccion = direccion;
		contadorInmueble++;
		
	}
	
	public Inmueble() {
		this(DEFECTO_SUP, PROP_DEFECTO, DIREC_DEFECTO);
	}
	
	
	
	
	public int getSuperficie() {
		return superficie;
	}

	public String getPropietario() {
		return propietario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getDireccion() {
		return direccion;
	}

	private String sacarIdentificador() {
		String devolucion = null, cambiar;
		LocalDate dataAnho = LocalDate.now();
		int anho = dataAnho.getYear();
		cambiar = Integer.toString(contadorInmueble);
		if (cambiar.length() == 1) {
			devolucion = anho + "000" + cambiar;
		}else if (cambiar.length() == 2) {
			devolucion = anho + "00" + cambiar;
		}else if (cambiar.length() == 3) {
			devolucion = anho + "0" + cambiar;
		}else if (cambiar.length() == 4) {
			devolucion = anho + cambiar;
		}
		return devolucion;
	}

}
