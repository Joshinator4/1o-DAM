package ejercicio1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Vehiculo {
	private String matricula;

	public Vehiculo (String matricula)throws IllegalArgumentException{
		if(isMatriculaCorrecta(matricula)) {
			this.matricula = matricula;
		}
		
	}
	
	protected boolean isMatriculaCorrecta(String matricula) throws IllegalArgumentException{
		boolean devolucion;
		Pattern patTerrestre = Pattern.compile("[0-9]{4}[a-zA-Z]{3}");
	    Matcher matTerrestre = patTerrestre.matcher(matricula);
		if(matTerrestre.matches()) {
			devolucion = true;
	
		}else {
			devolucion = false;
			throw new IllegalArgumentException ("ERROR: en el patrón de la matricula del vehiculo introducida");
		}
	    return devolucion;
	}
	
	public abstract String obtenerPrecioAlquiler(int numDias);

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + "]";
	}
	
	
}
