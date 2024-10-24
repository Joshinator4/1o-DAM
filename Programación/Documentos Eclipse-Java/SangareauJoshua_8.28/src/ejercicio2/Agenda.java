package ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Agenda{

	protected ArrayList <Contacto> arrayAgenda;
	/*
	//Se puede hacer asi tambien com Lamda
	protected Comparator<Contacto> ordenarNombre = (o1, o2) -> o1.getNombre().compareTo(o2.getNombre());
	*/
	public Agenda() {
		arrayAgenda = new ArrayList<>();
	}
	
	
	public void ingresarDatos(Contacto contacto) {
		arrayAgenda.add(contacto);
	}
	
	public void ingresarDatos() {
		arrayAgenda.add(new Contacto());
	}
	
	public String consultaDatosPorNombre(String nombre) {
		String devolucion = "";
		for(Contacto i: arrayAgenda) {
			if(i.getNombre().equals(nombre.toLowerCase())) {
				devolucion = i.toString();
			}
		}
		if(devolucion.isEmpty()) {
			devolucion = "No hay contactos con ese nombre";
		}
		return devolucion;
	}
	
	public String mostrarDatosOrdenados() {
		String devolucion = "";
		Collections.sort(this.arrayAgenda);
		for(Contacto i: arrayAgenda) {
			devolucion += i.toString() + "\n";
		}
		if(devolucion.isEmpty()) {
			devolucion = "No hay ningun contacto guardado en la agenda";
		}
		return devolucion;
	}
	
	public String mostrarContactosporCumpleaños(LocalDate fecha) {
		String devolucion = "";
		for(Contacto i: arrayAgenda) {
			if(i.getFechaNacimiento().equals(fecha)) {
				devolucion += i.toString();
			}
		}
		return devolucion;
	}
	
	
	
	
}
