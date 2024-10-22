/*
 * Objetivo:Clase que simula un ciclista
 * Autor: Joshua Sangareau Quesada
 * fecha: 16/04/2024
 * 
 */
package ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Ciclista {
	
	
	private final String dni;
	private final String nombre;
	private final LocalDate fechaNacimineto;
	
	private String modelo;
	private ArrayList<Ruta> listaRutas;
	
	
	public Ciclista(String dni, String nombre, LocalDate fechaNacimineto, String modelo) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimineto = fechaNacimineto;
		this.modelo = modelo;
		listaRutas = new ArrayList<>();
		
	}
	//este metodo añade una ruta a la lista de rutas de cada ciclista
	public void anhadirRuta (Ruta ruta) {
		this.listaRutas.add(ruta);
	}
	
	//este método suuma todos los kilometros recorridos de cada ruta que ha realizado y lo devuelve como un entero
	public int calcularKilometrosRecorridos() {
		int devolucion = 0;
		for(Ruta i: listaRutas) {
			devolucion += i.getKilometros();
		}
		return devolucion;
	}
	//este método ordena la lista de rutas
	public void ordenarLista() {
		Collections.sort(listaRutas);
	}


	public String getDni() {
		return dni;
	}


	public String getNombre() {
		return nombre;
	}


	public LocalDate getFechaNacimineto() {
		return fechaNacimineto;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	@Override
	public String toString() {
		return "Ciclista [dni=" + dni + ", nombre=" + nombre + ", fechaNacimineto=" + fechaNacimineto + ", modelo="
				+ modelo + ", listaRutas=" + listaRutas.toString() + "]\n";
	}


	
	
	
	
}
