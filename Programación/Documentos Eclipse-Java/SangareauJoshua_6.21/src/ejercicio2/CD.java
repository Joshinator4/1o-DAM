package ejercicio2;

import ejercicio1.Cancion;

public class CD {
	
	public static final int CANCIONES_MAXIMAS = 10;
	private int contador;
	private Cancion [] canciones;
	
	//Constructores de clase
	public CD() {
		canciones = new Cancion [CANCIONES_MAXIMAS];
		contador = 0;
	}
	//Constructor/clonador
	public CD (CD cd) {
		canciones = new Cancion [CANCIONES_MAXIMAS];
		for(int i = 0; i < cd.numeroCanciones(); i++) {
			this.canciones[i] = cd.canciones[i];
			this.contador++;
		}
	}
	
	//Devuelve el numero de canciones que tiene el CD
	public int numeroCanciones() {
		return this.contador;
	}
	
	//Devuelve la cancion de la pista del CD indicada
	public Cancion dameCancion(int pista) {
		return canciones[pista-1];
	}
	
	//Sustituye una cancion ya grabada por otra nueva
	public void grabaCancion(int pista, Cancion c) throws IllegalArgumentException {
		if(pista < 1 || pista > 10) {
			throw new IllegalArgumentException ("La pista no puede ser menor que 1 o mayor que 10");
		}
		canciones [pista-1] = c;
	}
	
	//añade una cancion nueva al CD
	public void agrega(Cancion cancion) throws IllegalStateException{
		if(contador > CANCIONES_MAXIMAS) {
			throw new IllegalStateException("El disco no tiene capacidad para mas canciones");
		}
		canciones[contador] = cancion;
		contador++;
	}
	
	//este metodo borra la pista (1-10, no es campo del array) que se introduzca en el main
	public void elimina(int posicion) throws IllegalStateException{
		if (canciones[posicion] == null) {
			throw new IllegalStateException("El estado de la cancion introducida ya es null (está vacio)");
		}
		for(int i = posicion - 1; i < numeroCanciones()-1; i++) {
			canciones[i] = canciones [i+1];
		}
		contador--;
	}
	
	//Imprime todas las posiciones del array canciones
	public String toString () {
		String devolucion = "";
		for(int i = 0; i < numeroCanciones(); i++) {
			devolucion += "Pista " + (i+1) + canciones[i].toString() + "\n";
		}
		return devolucion;
	}
}
