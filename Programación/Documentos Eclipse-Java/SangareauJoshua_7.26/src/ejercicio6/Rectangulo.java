package ejercicio6;

public class Rectangulo implements iFigura2D{
	
	private double base;
	private double altura;
	
	public Rectangulo(double base, double altura)  throws IllegalArgumentException{
		if(base <= 0) {
			throw new IllegalArgumentException ("ERROR: La base no puede ser inferio o igual a 0");
		}else {
			this.base = base;
		}
		if(altura <= 0) {
			throw new IllegalArgumentException ("ERROR: La altunra no puede ser inferio o igual a 0");
		}else {
			this.altura = altura;
		}
	}
	
	public Rectangulo() {
		this(4,3);
	}
	
	
	@Override
	public double perimetro() {
		return (this.base*2) + (this.altura*2);
	}
	
	@Override
	public double area() {
		return this.base * this.altura;
	}
	
	@Override
	public void escalar(double escala) {
		this.altura = this.altura * escala;
		this.base = this.base * escala;
	}
	
	
	@Override
	public void imprimir() {
		System.out.println("Rectangulo [Base: " + this.base + " Altura: " + this.altura + " Perímetro: " + perimetro() + " Area: " + area() + "]");
		
	}
	
}
