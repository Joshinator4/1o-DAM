package lectura;
import java.time.LocalDate;

public class Empleado {
	
	private String nombre;
	private LocalDate fechaNacimiento;
	private double salario;
	
	
	public Empleado(String nombre, LocalDate fechaNacimiento, double salario) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.salario = salario;
	}

	

	public String getNombre() {
		return nombre;
	}



	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}



	public double getSalario() {
		return salario;
	}



	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", salario=" + salario + "]";
	}
	
	
	
}
