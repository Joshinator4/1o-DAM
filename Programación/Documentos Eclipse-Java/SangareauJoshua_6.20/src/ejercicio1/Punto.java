package ejercicio1;

public class Punto {
	private double x; //coordenada X del punto
	private double y; //coordenada Y del punto
	
	//se realiza un filtro para que las coordenadas no sean nunca negativas
	public Punto(double x, double y) throws IllegalArgumentException {
		setX(x);
		setY(y);
	}
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	
	public void setX(double x) {
		if(x < 0) {
			throw new IllegalArgumentException("No se pueden usar coordenadas negativas");
		}else {
			this.x = x;
		}
	}
	public void setY(double y) {
		if(y <0) {
			throw new IllegalArgumentException("No se pueden usar coordenadas negativas");
		}else {
			this.y = y;
		}
	}
}
