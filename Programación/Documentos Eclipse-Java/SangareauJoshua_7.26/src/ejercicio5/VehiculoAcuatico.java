package ejercicio5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VehiculoAcuatico extends Vehiculo{
	
	protected final int eslora; //Los metros de eslora que tiene el barco siendo el minimo 2m
	
	public VehiculoAcuatico(String matricula, String modelo, int eslora) throws IllegalArgumentException {
		super(matricula, modelo);
		isMatriculaCorrecta(matricula);
		if (eslora >= 2) {
			this.eslora = eslora;
		}else {
			throw new IllegalArgumentException ("ERROR: La eslora debe ser igual o superior a 2m");
		}
	}
	public VehiculoAcuatico(int eslora) throws IllegalArgumentException {
		super("ABCDEF", "Modelo Desconocido");
		this.eslora = eslora;
		
	}
	public VehiculoAcuatico() {
		super("ABCDEF", "Modelo Desconocido");
		this.eslora = 3;
		
	}
	

	public int getEslora() {
		return eslora;
	}
	
	@Override
	protected boolean isMatriculaCorrecta(String matricula) throws IllegalArgumentException{
		boolean devolucion;
		Pattern patAcuatico = Pattern.compile("[a-zA-Z]{3,10}");
	    Matcher matAcuatico = patAcuatico.matcher(matricula);
		if(matAcuatico.matches()) {
			devolucion = true;
	
		}else {
			devolucion = false;
			throw new IllegalArgumentException ("ERROR: en el patrón de la matricula de vehiculo acuatico introducida");
		}
	    return devolucion;
	}


	@Override
	public String toString() {
		return "VehiculoAcuatico [eslora=" + eslora + ", matricula=" + matricula + ", modelo=" + modelo + "]";
	}

	
	

}
