package ejercicio6;

public class Triangulo implements iFigura2D{

	private double ancho;
	private double alto;
	
	public Triangulo(double ancho, double alto)  throws IllegalArgumentException{
		if(ancho <= 0) {
			throw new IllegalArgumentException ("ERROR:El ancho no puede ser inferio o igual a 0");
		}else {
			this.ancho = ancho;
		}
		if(alto <= 0) {
			throw new IllegalArgumentException ("ERROR: El alto no puede ser inferio o igual a 0");
		}else {
			this.alto = alto;
		}
	}
	
	public Triangulo() {
		this(5,3);
	}
	
	
	@Override
	public double perimetro() {
		return ancho*3;
	}
	@Override
	public double area() {
		return (ancho*alto)/2;
	}
	@Override
	public void escalar(double escala) {
		this.alto = this.alto * escala;
		this.ancho = this.ancho * escala;		
		
	}
	@Override
	public void imprimir() {
		System.out.println("Triángulo [Ancho: " + this.ancho + " Alto: " + this.alto + " Perímetro: " + perimetro() + " Area: " + area() + "]");
		
	}
	
}
