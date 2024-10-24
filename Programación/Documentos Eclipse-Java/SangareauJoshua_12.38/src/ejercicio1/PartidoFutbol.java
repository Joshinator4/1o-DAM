package ejercicio1;

import java.time.LocalDate;

/*Autor: Joshua Sangareau Quesada
Fecha: 20 may 2024 
Descripcion: clase PartidoFutbol
*/
public class PartidoFutbol extends Partido{
	
	private int goles;
	private int kmRecorridos;
	
	
	public PartidoFutbol(LocalDate fecha, int minutosJugados, int goles, int kmRecorridos) {
		super(fecha, minutosJugados);
		this.goles = goles;
		this.kmRecorridos = kmRecorridos;
	}



	public int getGoles() {
		return goles;
	}


	public int getKmRecorridos() {
		return kmRecorridos;
	}


	public void setGoles(int goles) {
		this.goles = goles;
	}


	public void setKmRecorridos(int kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}


	@Override
	public String toString() {
		return super.toString() +  "PartidoFutbol [goles=" + goles + ", kmRecorridos=" + kmRecorridos + "],\n";
	}
	
	
	
}
