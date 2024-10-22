package ejercicio3;

import java.time.LocalDate;

import ejercicio3.Personal.Genero;

public class Profesor extends Personal{
	
	private String titulacion;
	private String asignatura1;
	private String asignatura2;
	private String tutor;
	private int anyosExperiencia;
	
	public Profesor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, Genero genero, double salario, String telefono, String email,
			String titulacion, String asignatura1, String asignatura2, String tutor, int anyosExperiencia) throws IllegalArgumentException{
		super(dni, nombre, apellidos, fechaNacimiento, genero, salario, telefono, email);
		setTitulacion(titulacion);
		setAsignatura1(asignatura1);
		setAsignatura2(asignatura2);
		setTutor(tutor);
		setAnyosExperiencia(anyosExperiencia);
	}
	
	public Profesor() {
		super();
		setTitulacion("Magisterio");
		setAsignatura1("Lengua");
		setAsignatura2("Matemáticas");
		setTutor("Tutor de ninguna clase");
		setAnyosExperiencia(0);
	}
	
	
	public String getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	public String getAsignatura1() {
		return asignatura1;
	}
	public void setAsignatura1(String asignatura1) {
		this.asignatura1 = asignatura1;
	}
	public String getAsignatura2() {
		return asignatura2;
	}
	public void setAsignatura2(String asignatura2) {
		this.asignatura2 = asignatura2;
	}
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	public int getAnyosExperiencia() {
		return anyosExperiencia;
	}
	public void setAnyosExperiencia(int anyosExperiencia) throws IllegalArgumentException{
		if(anyosExperiencia >= 0) {
			this.anyosExperiencia = anyosExperiencia;
		}else {
			throw new IllegalArgumentException("Lo años de experiencia no pueden ser menores que 0");
		}
	}
	
	public void aumentarSalario() {
		if(this.anyosExperiencia>=5) {
			this.salario = this.salario + (this.salario * 0.05);
		}else if(this.anyosExperiencia>=3) {
			this.salario = this.salario + (this.salario * 0.03);
		}else if(this.anyosExperiencia>=1) {
			this.salario = this.salario + (this.salario * 0.01);
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nProfesor [titulacion=" + titulacion + ", asignatura1=" + asignatura1 + ", asignatura2=" + asignatura2
				+ ", tutor=" + tutor + ", anyosExperiencia=" + anyosExperiencia + "]";
	}
	
	
	
	
}
