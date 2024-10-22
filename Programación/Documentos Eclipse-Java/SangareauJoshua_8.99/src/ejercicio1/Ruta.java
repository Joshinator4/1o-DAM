/*
 * Objetivo:Clase que simula una ruta+-
 * Autor: Joshua Sangareau Quesada
 * fecha: 16/04/2024
 * 
 */
package ejercicio1;

import java.time.LocalDate;

public class Ruta implements Comparable<Ruta>{
	
	private String nombreRuta;
	private LocalDate fecha;
	private int kilometros;
	private int tiempo; //se guarda el tiempo en minutos
	
	
	public Ruta(String nombreRuta, LocalDate fecha, int kilometros, int tiempo) {
		this.nombreRuta = nombreRuta;
		this.fecha = fecha;
		this.kilometros = kilometros;
		this.tiempo = tiempo;
	}
	
	


	public int getKilometros() {
		return kilometros;
	}




	@Override
	public String toString() {
		return "Ruta [nombreRuta=" + nombreRuta + ", fecha=" + fecha + ", kilometros=" + kilometros + ", tiempo="
				+ tiempo + "]";
	}


	@Override
	public int compareTo(Ruta o) {
		int devolucion;
		if(kilometros > o.getKilometros()) {
			devolucion = 1;
		}else if(kilometros == o.getKilometros()){
			devolucion = 0;
		}else {
			devolucion = -1;
		}
		return devolucion;
	}



	
	
	
}
