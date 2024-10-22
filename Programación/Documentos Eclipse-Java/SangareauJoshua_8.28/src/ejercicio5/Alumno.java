package ejercicio5;

import java.time.LocalDate;

public class Alumno {
	
	private static int contadorCodigo=1;
	
	private int codigoAlumno;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private int codigoCiclo;
	private int cantidadCursosAprobados;
	private LocalDate fechaIngreso;
	
	public Alumno(String nombre, String apellidos, String direccion, String telefono, int codigoCiclo, int cantidadCursosAprobados, LocalDate fechaIngreso) {
		this.nombre=nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.codigoCiclo = codigoCiclo;
		this.cantidadCursosAprobados = cantidadCursosAprobados;
		this.fechaIngreso = fechaIngreso;
		this.codigoAlumno = contadorCodigo;
		contadorCodigo++;
		
	}
	
	public Alumno() {
		this("nombre desconocido", "apellidos desconocidos", "direccion desconocida", "900500200", 0,0, LocalDate.now());
	}

	public static int getContadorCodigo() {
		return contadorCodigo;
	}

	public int getCodigoAlumno() {
		return codigoAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public int getCodigoCiclo() {
		return codigoCiclo;
	}

	public int getCantidadCursosAprobados() {
		return cantidadCursosAprobados;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public static void setContadorCodigo(int contadorCodigo) {
		Alumno.contadorCodigo = contadorCodigo;
	}

	public void setCodigoAlumno(int codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setCodigoCiclo(int codigoCiclo) {
		this.codigoCiclo = codigoCiclo;
	}

	public void setCantidadCursosAprobados(int cantidadCursosAprobados) {
		this.cantidadCursosAprobados = cantidadCursosAprobados;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "Alumno [codigoAlumno=" + codigoAlumno + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", codigoCiclo=" + codigoCiclo
				+ ", cantidadCursosAprobados=" + cantidadCursosAprobados + ", fechaIngreso=" + fechaIngreso + "]";
	}
	
	
	
}
