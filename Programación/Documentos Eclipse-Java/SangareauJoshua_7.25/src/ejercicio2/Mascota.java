package ejercicio2;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public abstract class Mascota {
	
	private static LocalDate fechaNacimientoGenerica = LocalDate.of(2023, 2, 7);
	
	protected String nombre;
	protected int edad;
	protected boolean estado;
	protected LocalDate fechaNacimiento;
	
	
	public Mascota(String nombre, int edad, boolean estado, LocalDate fechaNacimiento) throws IllegalArgumentException{
		setNombre(nombre.toLowerCase());
		if(edad < 0) {
			throw new IllegalArgumentException("La edad no puede ser menor que 0");
		}else {
			this.edad = edad;
		}
		this.estado = estado;
		this.fechaNacimiento = fechaNacimiento;
	}
	public Mascota(String nombre) {
		
		this(nombre, 0, true, fechaNacimientoGenerica);
	}
	
	public Mascota() {
		
		this("Mascota Anonima", 0, true, fechaNacimientoGenerica);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre.isEmpty()) {
			throw new IllegalArgumentException("Se debe introducir algun nombre");
		}
		this.nombre = nombre.toLowerCase();
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getEdad() {
		return edad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	protected abstract String habla();
	
	//Este metodo devuelve la cantidad en dias y años, meses y dias que le falata a la mascota para morir
	public String morir() {
		LocalDate hoy = LocalDate.now();
	    String devolucion;
        /*Fecha de fallecimiento*/
        LocalDate fechaMuerte = fechaNacimiento.plusYears(15);
        //Se genera un objeto Period para comprar la fecha de hoy y la de el fallecimiento y se usa
        //chronoUnit para guardar los dias que hay entre una fecha y otra
        Period periodo = Period.between(hoy, fechaMuerte);
        long totalDias = ChronoUnit.DAYS.between(hoy, fechaMuerte);
        
        devolucion = "Quedan " + periodo.getYears() + " años, " + periodo.getMonths() + " meses y "
                + periodo.getDays() + " días para su fallecimiento. ("
                + totalDias + " días en total)";
        
        return devolucion;
	}
	
	//Este metodo devuelve la cantidad en dias y meses y dias que le falata a la mascota para su siguiente cumpleaños
	public String cumpleaños() {
		LocalDate hoy = LocalDate.now();
	    String devolucion;
        /*Fecha de nacimiento.*/
        LocalDate siguienteCumple = fechaNacimiento.withYear(hoy.getYear());

        /*Si el cumpleaños ya ocurrió este año, agrega 1 año*/
        if (siguienteCumple.isBefore(hoy) || siguienteCumple.isEqual(hoy)) {
        	siguienteCumple = siguienteCumple.plusYears(1);
        }
        
        //Se genera un objeto Period para comprar la fecha de hoy y la del siguiente cumpleaños y se usa
        //chronoUnit para guardar los dias que hay entre una fecha y otra
        Period periodo = Period.between(hoy, siguienteCumple);
        long totalDias = ChronoUnit.DAYS.between(hoy, siguienteCumple);

        /*Cuando totalDias=365 hoy es el cumpleaños*/
        if (totalDias == 365 || totalDias == 366) {
            devolucion = "¡Su cumpleaños es hoy. Felicidades!";
            
        } else {
            devolucion = "Quedan " + periodo.getMonths() + " meses y "
                    + periodo.getDays() + " días para su próximo cumpleaños. ("
                    + totalDias + " días en total)";
        }
        return devolucion;
	}
	
	public String muestra() {
		return "Mascota [nombre=" + nombre + ", edad=" + edad + ", estado=" + estado + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	
	
}
