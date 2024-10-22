package ejercicio3;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Personal {
	enum Genero {masculino, femenino}
	
	private static LocalDate fechaFicticia = LocalDate.now();
	private static LocalDate fechaFicticiaNacimiento = LocalDate.of(1990, 8, 25);
	
	protected String dni;
	protected String nombre;
	protected String apellidos;
	protected final LocalDate fechaNacimiento;
	protected final Genero genero;
	protected double salario;
	protected String telefono;
	protected String email;
	
	
	public Personal (String dni, String nombre, String apellidos, LocalDate fechaNacimiento, Genero genero, double salario, String telefono, String email) throws IllegalArgumentException {
		if(isDniCorrecto(dni)) {
			this.dni=dni;
		}
		setNombre(nombre);
		setApellidos(apellidos);
		this.fechaNacimiento= fechaNacimiento;
		this.genero = genero;
		setSalario(salario);
		setTelefono(telefono);
		setEmail(email);
	}
	
	public Personal() {
		this("00000000T", "Pepito", "perez", fechaFicticiaNacimiento, Genero.femenino, 1000, "678547896", "anonimo@gmail.com");
	}
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) throws IllegalArgumentException {
		if(nombre.isEmpty() || nombre == null) {
			throw new IllegalArgumentException("El nombre debe estar rellenado");
		}
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) throws IllegalArgumentException{
		if(apellidos.isEmpty() || apellidos == null) {
			throw new IllegalArgumentException("El nombre debe estar rellenado");
		}
		this.apellidos = apellidos;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) throws IllegalArgumentException{
		if(salario >= 1000) {
			this.salario = salario;
		}else {
			throw new IllegalArgumentException("El salario no puede ser inferior a 1100");
		}
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getDni() {
		return dni;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public Genero getGenero() {
		return genero;
	}

	public void aumentoSalario (double porcentaje) {
		double aumento;
		aumento = porcentaje / 100;
		setSalario(getSalario() + (getSalario()*aumento));
	}
	
	public int anyosJubilacion() {
		int devolucion;
		devolucion = 65 - (fechaFicticia.getYear() - this.fechaNacimiento.getYear());
		return devolucion;
	}



	private boolean isDniCorrecto (String dniAlumno) throws IllegalArgumentException{
		boolean devolucion;
		Pattern patDni = Pattern.compile("[0-9]{1,8}[a-zA-Z]");
	    Matcher matDni = patDni.matcher(dniAlumno);
		if(matDni.matches()) {
			devolucion = true;
			
			String numeroDni = dniAlumno.substring(0, 8);
			int numeroDniComprobar = Integer.parseInt(numeroDni);
			char [] letraDni =  {'T', 'R', 'w', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		    int operacion;
		    operacion = numeroDniComprobar % 23;
		    if (letraDni[operacion] == dniAlumno.toUpperCase().charAt(8)) {
		    	devolucion = true;
		    }else {
		    	devolucion = false;
				throw new IllegalArgumentException ("ERROR: en la letra del dni introducido");
		    }
		}else {
			devolucion = false;
			throw new IllegalArgumentException ("ERROR: en el patrón del dni introducido");
		}
	    return devolucion;
	}

	public String toString() {
		return "Personal [Dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha de nacimiento="
				+ fechaNacimiento + ", genero=" + genero + ", salario=" + salario + ", telefono=" + telefono
				+ ", email=" + email + "]";
	}
	
}
