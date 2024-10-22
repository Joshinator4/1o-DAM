package ejercicioA5;

import java.time.LocalDate;

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
	
}
