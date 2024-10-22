package ejercicio2;

import javax.naming.ldap.InitialLdapContext;

public class Cafetera {
	//Atributos de clase
	private double capacidadMaxima; //Capacidad maxima que tiene la cafetera
	private double cantidadActual; //cantidad actual de cafe que contiene la cafetera
	
	//Constructores de la clase
	public Cafetera(double maxima, double actual)throws IllegalArgumentException {
		if(maxima < actual) {
			setMaxima(maxima);
			setActual(maxima);
			throw new IllegalArgumentException("ERROR: se ha creado la cafetera totalmente llena pero ha sobrado " + (actual - maxima) + "c.c");
		}
		setMaxima(maxima);
		setActual(actual);
	}

	public Cafetera(double maxima) {
		this(maxima, maxima);
	}

	public Cafetera() {
		this(1000, 0);
	}
	
	//Metodos de la clase
	//Este metodo llena la cafetera, si sobra cantidad se llena al maximo la cafetera y se lanza excepcion avisando lo que ha sobrado
	public void llenarCafetera(double cantidad) throws IllegalArgumentException {
		if(cantidad < 0) {
			throw new IllegalArgumentException("ERROR: No se puede llenar la cafetera con una cantidad negativa");
		}else if(cantidad > this.capacidadMaxima) {
			setActual(this.capacidadMaxima);
			throw new IllegalArgumentException("ERROR: se ha llenado la cafetera pero ha sobrado " + (cantidad - this.capacidadMaxima) + "c.c");
		}else {
			setActual(cantidad);
		}
	}
	
	//Este método simula el llenado de una taza con el cafe de la cafetera. Restará la cantidad servida a la cantidadActual y/o lanzara una excepcion 
	// avisando de que no ha podido ser llenada del todo la taza y mostrará la cantidad que ha faltado para llenar la taza
	public double servirTaza(int cantidad) throws IllegalArgumentException {
		double cantidadAhora = getActual();
		double falta;
		if (cantidad > getActual()) {
			setActual(0);
			falta = cantidad - cantidadAhora;
			throw new IllegalArgumentException("No se ha podido rellenar la taza, han faltado: " + (cantidad - cantidadAhora) + "c.c para rellenar la taza entera");
		}else {
			setActual(getActual() - cantidad);
			falta = 0;
		}
		return falta;
	}
	
	//Este metodo pone la cantidad de café actual en cero.
	public void vaciarCafetera(){
		setActual(0);
	}
	
	//Este metodo añade a la cafetera la cantidad de café indicada. Lanzará excepción avisando de la cantidad 
	public void agregarCafe(int agregado) throws IllegalArgumentException{
		llenarCafetera(agregado);
	}
	
	//Setters y getters de la clase
	public void setMaxima(double maxima) {
		this.capacidadMaxima = maxima;
	}
	
	public void setActual(double actual){
		this.cantidadActual = actual;
	}
	
	public double getMaxima() {
		return this.capacidadMaxima;
	}	
	
	public double getActual() {
		return this.cantidadActual;
	}
	
	public String toString() {
		return String.format("La capacidad máxima de la cafetera es: %f y la cantidad actual es: %f", getMaxima(), getActual());
	}
}
