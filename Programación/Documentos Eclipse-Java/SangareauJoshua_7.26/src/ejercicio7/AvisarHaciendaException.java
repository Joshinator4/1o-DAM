package ejercicio7;

public class AvisarHaciendaException extends Exception{
	
	private double movimiento;
	
	AvisarHaciendaException(double ingreso){
		//super("Se ha realizado un ingreso de: " + ingreso + "€. A partir de 3000€ se debe avisar a hacienda"); SE PUEDE HACER ASI Y NO SE USA EL TOSTRING NI EL ATRIBUTO
		this.movimiento = ingreso;
	}
	
	public String toString() {
		return "Se ha realizado un ingreso de: " + this.movimiento + "€. A partir de 3000€ se debe avisar a hacienda";
		
	}
}
