/*
 * Objetivo: extender el tipo de sasncion a sancion de aparcamiento
 * Autor: Joshua Sangareau Quesada
 * fecha: 04/04/2024
 *
 */
package ejercicio1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SancionAparcamiento extends Sancion{
	//Atributos estaticos finales 
	public static final double PRECIO_MAX = 100;
	public static final double PRECIO_MIN = 50;
	
	//Atributos estaticos de la clase
	private static LocalDateTime ahora = LocalDateTime.now();
	
	//metodos de clase.
	private boolean grua;

	public SancionAparcamiento(String matricula, LocalDateTime fecha, String lugarInfraccion, boolean grua) {
		super(matricula, fecha, lugarInfraccion);
		this.grua = grua;
	}
	
	//Metodo que realiza el cálculo del importe de la sancion segun las especificaciones requeridas en cada una de las distintas clases.
		//Metodo heredado de sanción
		@Override
		public double calcularSancion() {
			double devolucion;
			if(this.grua == true) {
				devolucion = PRECIO_MAX + PRECIO_MIN;
			}else {
				devolucion = PRECIO_MIN;
			}
						
			devolucion = calculoSuplementoDescuento(devolucion);
			return devolucion;
			
		}

	@Override
	public String toString() {
		return super.toString() + "SancionAparcamiento [grua=" + grua + " la sancion será = " + calcularSancion() + "]\n";
	}	
	

}
