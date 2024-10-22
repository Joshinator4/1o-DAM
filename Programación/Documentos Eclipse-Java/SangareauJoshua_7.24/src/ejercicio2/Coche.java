package ejercicio2;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coche {
	
	protected String matricula;
	protected String nombrePropietario;
	protected final LocalDate Fecha_Matriculacion;
	protected int cilindrada;
	protected int potencia;
	
	
	public Coche(String matricula, String nombrePropietario, LocalDate fecha, int cilindrada, int potencia) throws IllegalArgumentException {
		Pattern patMatricula = Pattern.compile("[0-9]{4}[A-Z]{3}");
		Matcher matMatricula = patMatricula.matcher(matricula);
		if(matMatricula.matches()) {
			this.matricula = matricula;
		}else {
			throw new IllegalArgumentException("El patrón de la matrícula no es correcto");
		}
		setNombrePropietario(nombrePropietario);
		this.Fecha_Matriculacion = fecha;
		setCilindrada(cilindrada);
		setPotencia(potencia);
	}
	
	public Coche() {
		this("9999AAA", "Pepito Perez", LocalDate.now(), 2000, 150);
	}


	public String getMatricula() {
		return matricula;
	}


	public String getNombrePropietario() {
		return nombrePropietario;
	}


	public void setNombrePropietario(String nombrePropietario) throws IllegalArgumentException {
		if(nombrePropietario.isEmpty() || nombrePropietario == null) {
			throw new IllegalArgumentException("El nombre del propietario nopuede estar vacío");
		}else {
			this.nombrePropietario = nombrePropietario;
		}
	}


	public int getCilindrada() {
		return cilindrada;
	}


	public void setCilindrada(int cilindrada) throws IllegalArgumentException {
		if(cilindrada > 0) {
			this.cilindrada = cilindrada;
		} else {
			throw new IllegalArgumentException("La cilindrada debe ser superior a 0");
		}
	}


	public int getPotencia() {
		return potencia;
	}


	public void setPotencia(int potencia)  {
		if(potencia > 0) {
			this.potencia = potencia;
		} else {
			throw new IllegalArgumentException("La potencia debe ser superior a 0");
		}
		
	}


	public LocalDate getFecha_Matriculacion() {
		return Fecha_Matriculacion;
	}

	public String toString() {
		return "Coche [Matricula: " + matricula + ", Nombre del Propietario: " + nombrePropietario + ", Fecha Matriculacion: "
				+ Fecha_Matriculacion + ", Cilindrada: " + cilindrada + ", Potencia: " + potencia + "]";
	}
	
}
