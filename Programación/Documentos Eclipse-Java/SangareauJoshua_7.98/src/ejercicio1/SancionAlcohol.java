/*
 * Objetivo: extender el tipo de sasncion a sancion de alcoholemia
 * Autor: Joshua Sangareau Quesada
 * fecha: 04/04/2024
 *
 */
package ejercicio1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SancionAlcohol extends Sancion {
	//Atributos estaticos finales 
	public static double PRECIO_MIN = 100;
	public static double PRECIO_DECIMA = 50;
	public static double TASA = 0.5;
	
	//Atributos estaticos de la clase
	private LocalDateTime ahora = LocalDateTime.now();
	
	//metodos de clase.
	private double tasaAlcoholemia;
	

	public SancionAlcohol(String matricula, LocalDateTime fecha, String lugarInfraccion, double tasa) {
		super(matricula, fecha, lugarInfraccion);
		this.tasaAlcoholemia = tasa;
	}

	//Metodo que realiza el cálculo del importe de la sancion segun las especificaciones requeridas en cada una de las distintas clases.
	//Metodo heredado de sanción
	@Override
	public double calcularSancion() {
		double devolucion;
		devolucion = PRECIO_MIN;
		devolucion += ((tasaAlcoholemia-TASA)*10*PRECIO_DECIMA);
		
		devolucion = calculoSuplementoDescuento(devolucion);
		return devolucion;
	}

	@Override
	public String toString() {
		return super.toString() + "SancionAlcohol [tasaAlcoholemia=" + tasaAlcoholemia + " la sancion será = " + calcularSancion() + "]\n";
	}
	
	

}
