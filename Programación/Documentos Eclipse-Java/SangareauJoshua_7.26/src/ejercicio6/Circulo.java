package ejercicio6;

public class Circulo implements iFigura2D{
	
	private double radio;
	
	public Circulo(double radio) throws IllegalArgumentException{
		if(radio <= 0) {
			throw new IllegalArgumentException ("ERROR: El radio no puede ser inferio o igual a 0");
		}else {
			this.radio = radio;
		}
	}
	
	public Circulo() {
		this(6);
	}
	
	
	@Override
	public double perimetro() {
		return (this.radio*2)*Math.PI;
	}

	@Override
	public double area() {
		return Math.pow(radio, 2)*Math.PI;
	}

	@Override
	public void escalar(double escala) {
		this.radio = this.radio*escala;
		
	}

	@Override
	public void imprimir() {
		System.out.println("Circulo [Radio: " + this.radio  + " Perímetro: " + perimetro() + " Area: " + area() + "]");
		
	}

}
