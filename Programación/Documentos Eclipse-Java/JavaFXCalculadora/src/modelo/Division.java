package modelo;

public class Division {
	
	private double a;
	private double b;
	
	public Division(double a, double b) {
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
	
	public double dividir() {
		return a / b;
	}

}
