package ejercicio1;

import java.time.LocalDate;

/*Autor: Joshua Sangareau Quesada
Fecha: 20 may 2024 
Descripcion: clase Partido
*/
public class Partido implements Comparable<Partido>{
	
	private LocalDate fecha;
	private int minutosJugados;
	
	
	public Partido(LocalDate fecha, int minutosJugados) {
		this.fecha = fecha;
		this.minutosJugados = minutosJugados;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public int getMinutosJugados() {
		return minutosJugados;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public void setMinutosJugados(int minutosJugados) {
		this.minutosJugados = minutosJugados;
	}


	@Override
	public String toString() {
		return "Partido [fecha=" + fecha + ", minutosJugados=" + minutosJugados + "]";
	}


	@Override
	public int compareTo(Partido o) {
		return this.fecha.compareTo(o.getFecha());
	}
	
	
	
}
