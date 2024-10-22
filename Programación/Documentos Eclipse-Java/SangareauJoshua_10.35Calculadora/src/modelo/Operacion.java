package modelo;

public class Operacion {
	
	private double a;
	private double b;
	private int operar;
	
	public Operacion(double a, double b, int operar) {
		this.a = a;
		this.b = b;
		this.operar = operar;
	}
	
	public Operacion(double a, int operar) {
		this(a, 0, operar);
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public void setA(double a) {
		this.a = a;
	}

	public void setB(double b) {
		this.b = b;
	}
	
	public int getOperar() {
		return operar;
	}

	public void setOperar(int operar) {
		this.operar = operar;
	}
	
	public double dividir() {
		return a / b;
	}
	
	public double multiplicar() {
		return a * b;
	}
	
	public double restar() {
		return a - b;
	}
	
	public double sumar() {
		return a + b;
	}

	
	
	
}
