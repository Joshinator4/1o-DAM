package ejercicio6;

public class Cuadrado implements iFigura2D {

	private double lado;
	
	public Cuadrado(double lado) throws IllegalArgumentException {
		if(lado <= 0) {
			throw new IllegalArgumentException ("ERROR: el lado no puede ser inferio o igual a 0");
		}else {
			this.lado = lado;
		}
	}
	
	public Cuadrado() throws IllegalArgumentException {
		this(3);
	}
	
	@Override
	public double perimetro() {
		return this.lado*4;
	}

	@Override
	public double area() {
		return this.lado*this.lado;
	}

	@Override
	public void escalar(double escala) {
		this.lado = this.lado*escala;
	}

	@Override
	public void imprimir() {
		System.out.println("Cuadrado [Lado: " + this.lado + " Perímetro: " + perimetro() + " Area: " + area() + "]");
		
	}

}
