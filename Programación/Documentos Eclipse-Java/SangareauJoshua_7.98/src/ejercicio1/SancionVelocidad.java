/*
 * Objetivo: extender el tipo de sasncion a sancion de velocidad
 * Autor: Joshua Sangareau Quesada
 * fecha: 04/04/2024
 *
 */
package ejercicio1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SancionVelocidad extends Sancion{
	//Atributos estaticos finales 
	public static double PRECIO_KM = 10;
	public static double PRECIO_MIN = 100;
	
	//Atributos estaticos de la clase
	private LocalDateTime ahora = LocalDateTime.now();
	
	//metodos de clase.
	private int velocidadMax;
	private int velocidadActual;

	public SancionVelocidad(String matricula, LocalDateTime fecha, String lugarInfraccion, int velocidadMax, int velocidadActual) {
		super(matricula, fecha, lugarInfraccion);
		this.velocidadMax = velocidadMax;
		this.velocidadActual = velocidadActual;
	}
	
	//Metodo que realiza el cálculo del importe de la sancion segun las especificaciones requeridas en cada una de las distintas clases.
	//Metodo heredado de sanción
	@Override
	public double calcularSancion() {
		double devolucion;
		devolucion = PRECIO_MIN;
		devolucion += ((velocidadActual - velocidadMax)*PRECIO_KM);
		
		devolucion = calculoSuplementoDescuento(devolucion);
		return devolucion;
		
	}



	@Override
	public String toString() {
		return super.toString() + "SancionVelocidad [velocidadMax=" + velocidadMax + ", velocidadActual=" + velocidadActual + " la sancion será = " + calcularSancion() +"]\n";
	}
	
	

	
}
