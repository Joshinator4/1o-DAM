package ejercicio2;

import java.time.LocalDate;

public class Deportivo extends Coche {
	enum Traccion {delantera, total}
	
	private Traccion traccion;
	
	
	public Deportivo(String matricula, String nombrePropietario, LocalDate fecha, int cilindrada, int potencia, String traccion) throws IllegalArgumentException{
		super(matricula, nombrePropietario, fecha, cilindrada, potencia);
		traccion.toLowerCase();
		if(traccion.equals("delantera")) {
			this.traccion = Traccion.delantera;
		}else if(traccion.equals("total")){
			this.traccion = Traccion.total;
		}else {
			throw new IllegalAccessError("ell tipo de traccion no es correcto");
		}
	}


	@Override
	public String toString() {
		return super.toString() + "Deportivo [traccion=" + traccion + "]";
	}
}
