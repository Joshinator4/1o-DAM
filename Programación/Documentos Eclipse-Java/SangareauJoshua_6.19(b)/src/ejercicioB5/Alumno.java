package ejercicioB5;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alumno {
	public final static int LIMITE_MODULOS = 7; // Numero de modulos máximo al que se puede matricular cada alumno;
	public final static int LIMITE_ALUMNOS = 50; // Número máximo de alumnos perimitidos en la academia
	
	private static double mediaAprobados; // La media de aprobados de todos los alumnos de la academia
	private static int numeroAlumno; // Numero asignado a cada alumno
	private static int numeroAlumnosModulosAprobados; // Cantidad de alumnos con todos los módulos aprobados
	
	private String apellidosAlumno; // Apellidos del alumno
	private boolean beca; //Si el alumno esta vecado o no
	private String dniAlumno; // DNI del alumno
	private LocalDate fechaNacimiento; // Fecha de nacimiento del alumno
	private String nombreAlumno; // Nombre del alumno
	private int numeroModulos; // Cantidad de modulos matriculados por cada alumno
	

	public Alumno(String dniAlumno, String nombreAlumno, String apellidosAlumno, LocalDate fechaNacimiento, int numeroModulos, boolean beca) throws IllegalArgumentException{
		if(nombreAlumno == null || nombreAlumno.isEmpty()) {
			throw new IllegalArgumentException ("El nombre es null o has metido una cadena de texto vacía");
		}
		
		LocalDate fechaError = LocalDate.of(1900, 01, 01);
		if(fechaNacimiento.isBefore(fechaError)) {
			throw new IllegalArgumentException ("Error en la fecha de creación el año debe ser mayor que 1900");
		}
		if(numeroModulos > 7) {
			throw new IllegalArgumentException ("Error en el numero de modulos a matricular. El numero de módulos máximo es 7");
		}
		Pattern patDni = Pattern.compile("[0-9]{1,8}[a-zA-Z]");
	    Matcher matDni = patDni.matcher(dniAlumno);
		if(!matDni.matches()) {
			throw new IllegalArgumentException ("Error en el patrón del dni introducido");
		}
		
	    if (!isDniCorrecto(dniAlumno)) {
	    	throw new IllegalArgumentException ("Error en la letra del dni introducido");
	    }
		
		this.dniAlumno = dniAlumno;
		this.nombreAlumno = nombreAlumno;
		this.apellidosAlumno = apellidosAlumno;
		this.fechaNacimiento = fechaNacimiento;
		this.numeroModulos = numeroModulos;
		this.beca = beca;
	}
	
	public Alumno(String dniAlumno, String nombreAlumno, String apellidosAlumno) {
		this(dniAlumno, nombreAlumno, apellidosAlumno, LocalDate.now(), 0, false);
	}
	
	public Alumno() {
		this("00000000T", "nombrePorDefecto", "apellidoPorDefecto", LocalDate.now(), 0, false);
	}
	public String toString() {
		String devolucion;
		devolucion = "dni: " + this.dniAlumno + ", nombre: " + this.nombreAlumno + ", apellidos: " + this.apellidosAlumno + ", fecha de nacimiento: " + this.fechaNacimiento + " numero de módulos matriculado: "
				+ this.numeroModulos + " está becado: " + siONo(this.beca);
		return devolucion;
		
	}
	private boolean isDniCorrecto (String dniAlumno) {
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
		    }
		}else {
			devolucion = false;
		}
	    return devolucion;
		
	}
	private String siONo (boolean x) {
		String devolucion;
		if(x) {
			devolucion = "Si";
		} else {
			devolucion = "No";
		}
		return devolucion;
	}
}