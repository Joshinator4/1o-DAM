package ejercicio1;

import java.time.LocalDate;

/*Autor: Joshua Sangareau Quesada
Fecha: 20 may 2024 
Descripcion: clase PartidoBaloncesto
*/
public class PartidoBaloncesto extends Partido{

	private int puntos;
	private int asistencias;
	private int tapones;
	
	
	public PartidoBaloncesto(LocalDate fecha, int minutosJugados, int puntos, int asistencias, int tapones) {
		super(fecha, minutosJugados);
		this.puntos = puntos;
		this.asistencias = asistencias;
		this.tapones = tapones;
	}

	public int getPuntos() {
		return puntos;
	}


	public int getAsistencias() {
		return asistencias;
	}


	public int getTapones() {
		return tapones;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}


	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}


	public void setTapones(int tapones) {
		this.tapones = tapones;
	}


	@Override
	public String toString() {
		return super.toString() + "PartidoBaloncesto [puntos=" + puntos + ", asistencias=" + asistencias + ", tapones=" + tapones + "],\n";
	}
	
	
	
	
	
}
