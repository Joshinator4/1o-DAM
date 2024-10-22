package tiendaFiguras;

public class Dimension {
	
	private double alto;
	private double ancho;
	private double profundidad;
	
	
	public Dimension(double alto, double ancho, double profundidad) {
		this.alto = alto;
		this.ancho = ancho;
		this.profundidad = profundidad;
	}


	public Dimension() {
		this(0, 0, 0);
	}


	public double getAlto() {
		return alto;
	}


	public double getAncho() {
		return ancho;
	}


	public double getProfundidad() {
		return profundidad;
	}


	public void setAlto(double alto) {
		this.alto = alto;
	}


	public void setAncho(double ancho) {
		this.ancho = ancho;
	}


	public void setProfundidad(double profundidad) {
		this.profundidad = profundidad;
	}

	public double getVolumen(double alto, double ancho, double profundidad) {
		return alto*ancho*profundidad;
	}


	@Override
	public String toString() {
		return "Dimension [alto=" + alto + ", ancho=" + ancho + ", profundidad=" + profundidad + "]";
	}
	
	
	
}
