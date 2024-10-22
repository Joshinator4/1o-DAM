package ejercicio4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Empresa {
	
	private final String nombre;
	private final String cif;
	
	private String telefono;
	private String direccion;
	private HashSet<Empleado> empleados;
	
	public Empresa(String nombre, String cif) throws IllegalArgumentException{
		if(nombre.isEmpty() || nombre.equals(null)) {
			throw new IllegalArgumentException("El nombre no puede estar vacio o ser nulo");
		}else {
			this.nombre = nombre;
		}
		if(isCifCorrecto(cif)) {
			this.cif = cif;
		}else {
			throw new IllegalArgumentException("");
		}
		this.empleados = new HashSet <>();
	}
	
	public Empresa() {
		this("Empresa Desconocida", "D00000000");
		this.empleados = new HashSet <>();
	}
	
	public void añadirEmpleado() {
		empleados.add(new Empleado());

	}
	
	
	public void añadirEmpleado(Empleado empleado) {
		empleados.add(empleado);
		
	}
	
	public void eliminarEmpleado(int idEmpleado) {
		for(Empleado i: empleados) {
			if (i.getIdEmpleado() == idEmpleado) {
				empleados.remove(i);
			}
		}
	}
	
	
	public String mostrarEmpleados() {
		String devolucion = "";
		for(Empleado i : empleados) {
			devolucion += i.toString() + "\n";
		}
		if(devolucion.isEmpty()) {
			devolucion = "No hay empleados en la empresa";
		}
		return devolucion;
	}
	
	public String mostrarEmpleadosNeto() {
		String devolucion = "";
		for(Empleado i : empleados) {
			devolucion += i.toStringReducido() + "\n";
		}
		if(devolucion.isEmpty()) {
			devolucion = "No hay empleados en la empresa";
		}
		return devolucion;
	}
	
	public String calcularBrutosEmpresa() {
		String devolucion;
		double total = 0;
		for(Empleado i : empleados) {
			total += (i.getSueldo()*12);
		}
		devolucion = "Total de sueldos brutos anuales = " + total;
		if(total == 0) {
			devolucion = "No hay empleados en la empresa";
		}
		return devolucion;
	}
	
	public String calcularNetosEmpresa() {
		String devolucion;
		double total = 0;
		for(Empleado i : empleados) {
			total += i.sueldoNeto();
		}
		devolucion = "Total de sueldos netos anuales = " + total;
		if(total == 0) {
			devolucion = "No hay empleados en la empresa";
		}
		return devolucion;
	}
	
	
	
	//este metodo filtrara para que el patron del Cif introducido sea correcto
	private boolean isCifCorrecto (String cifEmpresa) throws IllegalArgumentException{
		boolean devolucion;
		Pattern patCif = Pattern.compile("[a-zA-Z][0-9]{8}");
	    Matcher matCif = patCif.matcher(cifEmpresa);
		if(matCif.matches()) {
			devolucion = true;
	
		}else {
			devolucion = false;
			throw new IllegalArgumentException ("ERROR: en el patrón del Cif introducido");
		}
	    return devolucion;
		
	}

	public String toString() {
		return "Empresa [nombre=" + nombre + ", cif=" + cif + ", telefono=" + telefono + ", direccion=" + direccion
				+ "]";
	}
	
	
}
