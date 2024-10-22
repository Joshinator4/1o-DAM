package ejercicio5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VehiculoAereo extends Vehiculo{
	
	protected final int numeroAsientos; //Numero de asientos que tendrá el vehiculo aereo siendo mínimo 8 asientos
	
	public VehiculoAereo(String matricula, String modelo, int numeroAsientos) throws IllegalArgumentException {
		super(matricula, modelo);
		isMatriculaCorrecta(matricula);
		if (numeroAsientos >= 8) {
			this.numeroAsientos = numeroAsientos;
		}else {
			throw new IllegalArgumentException ("ERROR: El numero de asientos debe ser superior o igual a 8");
		}
	}
	
	public VehiculoAereo(int numeroAsientos) throws IllegalArgumentException {
		super("ABCD123456", "Modelo Desconocido");
		if (numeroAsientos >= 8) {
			this.numeroAsientos = numeroAsientos;
		}else {
			throw new IllegalArgumentException ("ERROR: El numero de asientos debe ser superior o igual a 8");
		}
	}
	
	public VehiculoAereo(){
		super("ABCD123456", "Modelo Desconocido");
		this.numeroAsientos = 40;
	}

	
	
	public int getNumeroAsientos() {
		return numeroAsientos;
	}

	@Override
	protected boolean isMatriculaCorrecta(String matricula) throws IllegalArgumentException{
		boolean devolucion;
		Pattern patAereo = Pattern.compile("[a-zA-Z]{4}[0-9]{6}");
	    Matcher matAereo = patAereo.matcher(matricula);
		if(matAereo.matches()) {
			devolucion = true;
	
		}else {
			devolucion = false;
			throw new IllegalArgumentException ("ERROR: en el patrón de la matricula de vehiculo aereo introducida");
		}
	    return devolucion;
	}

	@Override
	public String toString() {
		return "VehiculoAereo [Numero de Asientos=" + numeroAsientos + ", matricula=" + matricula + ", modelo=" + modelo + "]";
	}
}
