package ejercicio5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Vehiculo {
	
	protected final String matricula; // Matricula del vehiculo, cada tipo de vehiculo tendrá su patron de matrícula
	protected final String modelo; // EL modelo del vehiculo
	
	public Vehiculo(String matricula, String modelo) throws IllegalArgumentException{
		this.matricula = matricula;
		this.modelo = modelo;
	}

	protected abstract boolean isMatriculaCorrecta (String matricula);

	
	public abstract String toString();
	
	
}
