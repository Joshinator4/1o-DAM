package ejercicio5;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VehiculoTerrestre extends Vehiculo{
	
	private final int numeroRuedas; 
	
	
	public VehiculoTerrestre(String matricula, String modelo, int numeroRuedas) throws IllegalArgumentException{
		
		super(matricula, modelo);
		isMatriculaCorrecta(matricula);
		if(numeroRuedas > 4 || numeroRuedas < 2) {
			throw new IllegalArgumentException("ERROR: El numero de ruedas debe ser mayor o igual a 2 y menor o igual que 4");
		}else {
			this.numeroRuedas = numeroRuedas;
		}
				
	}
	
	public VehiculoTerrestre(int numeroRuedas){
		super("1234AAA", "Modelo Desconocido");
		if(numeroRuedas > 4 || numeroRuedas < 2) {
			throw new IllegalArgumentException("ERROR: El numero de ruedas debe ser mayor o igual a 2 y menor o igual que 4");
		}else {
			this.numeroRuedas = numeroRuedas;
		}
	}
	
	public VehiculoTerrestre(){
		super("1234AAA", "Modelo Desconocido");
		this.numeroRuedas = 4;
	}
	
	
	public int getNumeroRuedas() {
		return numeroRuedas;
	}

	@Override
	protected boolean isMatriculaCorrecta(String matricula) throws IllegalArgumentException{
		boolean devolucion;
		Pattern patTerrestre = Pattern.compile("[0-9]{4}[a-zA-Z]{3}");
	    Matcher matTerrestre = patTerrestre.matcher(matricula);
		if(matTerrestre.matches()) {
			devolucion = true;
	
		}else {
			devolucion = false;
			throw new IllegalArgumentException ("ERROR: en el patrón de la matricula de vehiculo terrestre introducida");
		}
	    return devolucion;
		}

	@Override
	public String toString() {
		return "VehiculoTerrestre [numeroRuedas=" + numeroRuedas + ", matricula=" + matricula + ", modelo=" + modelo + "]";
	}

	
}
