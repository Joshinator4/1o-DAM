package modelo;

public class Multiplicacion {

	private double a;
	private double b;
	
	public Multiplicacion(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public void setA(int a) {
		this.a = a;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	public double multiplicar() {
		return a * b;
	}
}
