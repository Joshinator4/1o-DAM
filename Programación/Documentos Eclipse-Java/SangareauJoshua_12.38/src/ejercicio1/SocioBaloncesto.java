package ejercicio1;

import java.util.ArrayList;
import java.util.Collections;

/*Autor: Joshua Sangareau Quesada
Fecha: 20 may 2024 
Descripcion: clase SocioBaloncesto
*/
public class SocioBaloncesto extends Socio{
	
	enum TipoPosicion{BASE, ESCOLTA, ALERO, PIVOT};
	
	private TipoPosicion posicion;
	
	
	private ArrayList<Partido> partidosBaloncesto;


	public SocioBaloncesto(String nombre, String dni, String telefono, TipoPosicion posicion) {
		super(nombre, dni, telefono);
		this.posicion = posicion;
		this.partidosBaloncesto = new ArrayList<Partido>();
	}
	
	
	
	public TipoPosicion getPosicion() {
		return posicion;
	}



	public void setPosicion(TipoPosicion posicion) {
		this.posicion = posicion;
	}



	public int calcularPuntos() {
		int devolucion = 0;
		for(Partido i: partidosBaloncesto) {
			if(i instanceof PartidoBaloncesto) {
				devolucion += ((PartidoBaloncesto) i).getPuntos();
			}
		}
		return devolucion;
	}
	
	@Override
	public boolean comprobarSiHajugado() {
		return this.partidosBaloncesto.isEmpty();
	}

	
	@Override
	public void agregarListaPartidos(Partido partido) {
		partidosBaloncesto.add(partido);
		
	}

	@Override
	public int calcularCuota() {
		return this.partidosBaloncesto.size() * 5 + 30;
	}
	
	@Override
	public String toString() {
		Collections.sort(this.partidosBaloncesto);
		return super.toString() + "SocioBaloncesto [posicion=" + posicion + ", partidosBaloncesto=" + partidosBaloncesto + " cuota final: " + calcularCuota() + "],\n";
	}

	


	



	
	

}
