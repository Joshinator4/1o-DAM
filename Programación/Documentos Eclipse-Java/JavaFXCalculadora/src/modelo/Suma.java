package modelo;

public class Suma {
	private double a;
	private double b;
	
	public Suma(double a, double b) {
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
	
	public double suma() {
		return a + b;
	}
	
}
