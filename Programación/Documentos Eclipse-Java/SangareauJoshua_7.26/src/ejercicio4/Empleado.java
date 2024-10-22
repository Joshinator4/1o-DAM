package ejercicio4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Empleado {
	
	private static int numeroEmpleado = 1;
	
	private final String nombre;
	private final String dni;
	private final int idEmpleado;
	
	private double sueldo; //salario mensual del empleado
	private int edad;
	private String telefono;
	private String direccion;
	
	public Empleado(String nombre, String dni, double sueldo) throws IllegalArgumentException{
		if(nombre.isEmpty() || nombre.equals(null)) {
			throw new IllegalArgumentException("El nombre no puede estar vacio o ser nulo");
		}else {
			this.nombre = nombre;
		}
		if(isDniCorrecto(dni)) {
			this.dni = dni;
		}else {
			throw new IllegalArgumentException("");
		}
		this.idEmpleado = numeroEmpleado;
		setSueldo(sueldo);
		setEdad(edad);
		setTelefono(telefono);
		setDireccion(direccion);
		numeroEmpleado++;
	}
	
	
	
	public int getIdEmpleado() {
		return idEmpleado;
	}



	public Empleado() {
		this("Nombre Desconocido", "00000000T", 999.99);
	}
	
	
	
	
	public double getSueldo() {
		return sueldo;
	}




	public void setSueldo(double sueldo) {
		if(sueldo >= 850) {
			this.sueldo = sueldo;
		}else {
			throw new IllegalArgumentException("El salario no puede ser inferior a 850 € al mes"); 
		}
	}




	public int getEdad() {
		return edad;
	}




	public void setEdad(int edad) {
		this.edad = edad;
	}




	public String getTelefono() {
		return telefono;
	}




	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}




	public String getDireccion() {
		return direccion;
	}




	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	public String getNombre() {
		return nombre;
	}




	public String getDni() {
		return dni;
	}
	
	//este metodo calcula el salario neto del trabajador
	public double sueldoNeto() {
		double devolucion;
		if(this.sueldo*12 < 12000) {
			devolucion = (this.sueldo * 12) - ((this.sueldo * 12) * 0.2);
		}else if(this.sueldo*12 >= 12000 && this.sueldo*12 <= 25000) {
			devolucion = (this.sueldo * 12) - ((this.sueldo * 12) * 0.3);
		} else {
			devolucion = (this.sueldo * 12) - ((this.sueldo * 12) * 0.4);
		}
		
		return devolucion;
	}


	//este metodo filtra si el patron y la letra del dni son correctos o no
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
		return "Empleado [nombre=" + nombre + ", dni=" + dni + ", idEmpleado=" + idEmpleado + ", sueldo=" + sueldo
				+ ", edad=" + edad + ", telefono=" + telefono + ", direccion=" + direccion + "] ";
	}
	
	public String toStringReducido() {
		return "Empleado [dni=" + dni + ", sueldo bruto = " + sueldo + " sueldo neto = " + sueldoNeto() + "€ ] ";
	}
	
	
}
