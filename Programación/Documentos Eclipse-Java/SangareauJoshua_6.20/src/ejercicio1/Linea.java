package ejercicio1;

public class Linea {
	private Punto puntoA; // Punto de inicio de la línea
	private Punto puntoB; // Punto final de la línea.
	
	
	
	public Linea(Punto a, Punto b) {
		setLinea(a, b);
	}
	
	//Aqui se podría hacer un pseudoconstructor???? 
	public Linea() {
		puntoA.setX(0);
		puntoA.setY(0);
		puntoB.setX(0);
		puntoB.setY(0);
	}
	
	public void setLinea (Punto a, Punto b) {
		//se genera un filtro para que el punto a sea el que siempre está a la izquierda, la Y no es relevante porque solo indicaría la pendiente (ascendiente o descendiente)
		if(a.getX() < b.getX()) {
			this.puntoA = a;
			this.puntoB = b;
		}else {
			this.puntoA = b;
			this.puntoB = a;
		}
	}
	
	public Punto getPuntoA() {
		return puntoA;
	}
	
	public Punto getPuntoB() {
		return puntoB;
	}
	
	public void mueveDerecha(double derecha) {
		//NO se genera un filtro porque no importa cuanto se mueva a la derecha la línea (puede llegar hasta el máximo del rango de un double)
		puntoA.setX(puntoA.getX() + derecha);
		puntoB.setX(puntoB.getX() + derecha);
	}
	
	public void mueveIzquierda(double izquierda) throws IllegalArgumentException{
		//se genera un filtro para que la línea nunca sea movida por debajo de la coordenada X = 0
		if((puntoA.getX() - izquierda) >= 0) {
			puntoA.setX(puntoA.getX() - izquierda);
			puntoB.setX(puntoA.getX() - izquierda);
		}else {
			throw new IllegalArgumentException("No se puede mover la línea por debajo de la coordenada X = 0");
		}
	}
	
	public void mueveArriba(double arriba) {
		//NO se genera un filtro porque no importa cuanto se mueva hacia arriba la línea (puede llegar hasta el máximo del rango de un double)
		puntoA.setY(puntoA.getY() + arriba);
		puntoB.setY(puntoB.getY() + arriba);
	}
	
	public void mueveAbajo(double abajo) throws IllegalArgumentException{
		//se genera un filtro para que la línea nunca sea movida por debajo de la coordenada Y = 0
		if((puntoA.getY() - abajo) >= 0 ) {
			puntoA.setY(puntoA.getY() - abajo);
			puntoB.setY(puntoB.getY() - abajo);
		} else {
			throw new IllegalArgumentException("No se puede mover la línea por debajo de la coordenada Y = 0");
		}
	}
	
	public String EscribirLinea() {
		return "[(" + puntoA.getX() + "," + puntoA.getY() + "),(" + puntoB.getX() + "," + puntoB.getY() + ")]";
	}
}
