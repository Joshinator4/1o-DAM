package ejercicio7;

public class CuentaException extends Exception{
	
	private double num;
	
	CuentaException(double numero){
		this.num = numero;
	}
	
	public String toString() {
		return "Se ha detectado un error, El numero introducido de retirada o ingreso no debe ser inferior o igual a 0. Se ha introducido: " + this.num;
	}
}
