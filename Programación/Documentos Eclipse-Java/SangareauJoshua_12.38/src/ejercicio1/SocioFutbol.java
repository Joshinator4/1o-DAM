package ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/*Autor: Joshua Sangareau Quesada
Fecha: 20 may 2024 
Descripcion: clase SocioFutbol
*/
public class SocioFutbol extends Socio{

	
	private String nombreEquipo;
	private ArrayList<Partido> partidosFutbol;
	
	
	public SocioFutbol(String nombre, String dni, String telefono, String nombreEquipo) {
		super(nombre, dni, telefono);
		this.nombreEquipo = nombreEquipo;
		this.partidosFutbol = new ArrayList<Partido>();
	}
	
	
	
	public String getNombreEquipo() {
		return nombreEquipo;
	}



	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}



	public void agregarListaPartidos(Partido partido) {
		partidosFutbol.add(partido);
	}
	
	public int calcularGoles() {
		int devolucion = 0;
		for(Partido i: partidosFutbol) {
			if(i instanceof PartidoFutbol) {
				devolucion += ((PartidoFutbol) i).getGoles();
			}
		}
		return devolucion;
	}
	
	
	public boolean comprobarSiHajugado() {
		return this.partidosFutbol.isEmpty();
	}


	@Override
	public int calcularCuota() {
		return this.partidosFutbol.size() * 3 + 30;
	}
	
	@Override
	public String toString() {
		Collections.sort(this.partidosFutbol);
		return super.toString() + "SocioFutbol [nombreEquipo=" + nombreEquipo + ", partidosFutbol=" + partidosFutbol + " cuota final: " + calcularCuota() + "],\n";
	}

	
	
	
}
