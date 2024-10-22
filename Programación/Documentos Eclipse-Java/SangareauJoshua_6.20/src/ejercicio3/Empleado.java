package ejercicio3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Empleado {
	// NIF, apellidos, nombre, sueldo base, pago por hora extra, horas extra
	// realizadas en el
	// mes, tipo (porcentaje) de IRPF, casado o no y número de hijos y cantidad de
	// empleados.

	//Atributos estaticos de clase
	private static int numeroTotalEmpleados = 0;
	
	// Atributos de objeto
	private String nifEmpleado; // Dni o ducumento de identidad del empleado
	private String nombreEmpleado; // Nombre del empleado
	private String apellidosEmpleado; //Apellidos del empleado
	private double sueldoBase; // Sueldo base del empleado sin aplicar deducciones por impuestos ni aumentos por horas extra
	private double precioHoraExtra; // A cuanto se le pagará la hora extra al empleado
	private int cantidadHorasExtra; // cantidad de horas extra realizadas en el mes
	private int irpf; // Cantidad de irpf a aplicar al empleado
	private int numeroHijos; // Cantidad de hijos que tiene el empleado
	private boolean casado; // Este atributo guaradará si esta casado o el empleado

	// Constructores de la clase
	public Empleado(String nifEmpleado, String nombreEmpleado, String apellidosEmpleado, double sueldoBase, double precioHoraExtra, int cantidadHorasExtra, int irpf, int numeroHijos, boolean casado) 
			throws IllegalArgumentException {
		setNif(nifEmpleado);
		setNombreEmpleado(nombreEmpleado);
		setApellidosEmpleado(apellidosEmpleado);
		setSueldoBase(sueldoBase);
		setPrecioHoraExtra(precioHoraExtra);
		setCantidadHorasExtra(cantidadHorasExtra);
		setIrpf(irpf);
		setNumeroHijos(numeroHijos);
		this.casado = casado;
		numeroTotalEmpleados++;
	}
	
	public Empleado (String nifEmpleado, String nombreEmpleado, String apellidosEmpleado) throws IllegalArgumentException {
		this(nifEmpleado, nombreEmpleado, apellidosEmpleado, 1025.55, 6.41, 0, 13, 0, false);
	}

	public Empleado() {
		this("00000000T", "empleadoAnonimo", "apellidosDesconocidos", 1025.55, 6.41, 0, 13, 0, false);
	}

	// Setters y getters de la clase. Se generan filtros en los setters
	public String getNifEmpleado() {
		return this.nifEmpleado;
	}

	public String getNombreEmpleado() {
		return this.nombreEmpleado;
	}
	
	public String getApellidosEmpleado() {
		return this.apellidosEmpleado;
	}

	public double getSueldoBase() {
		return this.sueldoBase;
	}

	public double getPrecioHoraExtra() {
		return this.precioHoraExtra;
	}

	public int getCantidadHorasExtra() {
		return this.cantidadHorasExtra;
	}

	public int getIrpf() {
		return this.irpf;
	}

	public int getNumeroHijos() {
		return this.numeroHijos;
	}

	public boolean getCasado() {
		return this.casado;
	}

	public void setNif(String nifEmpleado) throws IllegalArgumentException {
		if (isDniCorrecto(nifEmpleado)) {
			this.nifEmpleado = nifEmpleado;
		}
	}

	public void setNombreEmpleado(String nombreEmpleado) throws IllegalArgumentException {
		// se genera un filtro para que el nombre siempre tenga que estar especificado
		if (nombreEmpleado == null || nombreEmpleado.isEmpty()) {
			throw new IllegalArgumentException("ERROR: El nombre es null o se ha introducido una cadena de texto vacía");
		}
		this.nombreEmpleado = nombreEmpleado;
	}
	
	public void setApellidosEmpleado(String apellidosEmpleado) throws IllegalArgumentException{
		// se genera un filtro para que el nombre siempre tenga que estar especificado
		if (apellidosEmpleado == null || apellidosEmpleado.isEmpty()) {
			throw new IllegalArgumentException("ERROR: Los apellidos son null o se ha introducido una cadena de texto vacía");
		}
		this.apellidosEmpleado = apellidosEmpleado;
	}

	public void setSueldoBase(double sueldoBase) throws IllegalArgumentException {
		// se genera un filtro para que el salirio base nunca pueda ser inferior al salario minimo interprofesional (la cantidad es inventada)
		if (sueldoBase < 1025.55) {
			throw new IllegalArgumentException("ERROR: El sueldo base del empleado no puede ser inferior a 1025.55€, que es el sueldo mínimo");
		}
		this.sueldoBase = sueldoBase;
	}

	public void setPrecioHoraExtra(double precioHoraExtra) throws IllegalArgumentException  {
		// se genera filtro para que las horas por lo menos, se paguen igual que el precio de las horas normales
		double precioHoraNormal = this.sueldoBase / 160;
		if (precioHoraExtra < precioHoraNormal) {
			throw new IllegalArgumentException("ERROR: El precio de la hora extra debe ser como mínimo igual que el precio de la hora que está dentro de la jornada del empleado: "
				+ precioHoraNormal + "€/hora");
		}
		this.precioHoraExtra = precioHoraExtra;
	}
	
	//Se genera este metodo setter sobrecargado para que se calcule solo el precio de la hora extra sin tener que introducir ningun parámetro (calcula e precio según el salario base)
	public void setPrecioHoraExtra() {
		this.precioHoraExtra = this.sueldoBase/160;
	}
	
	public void setCantidadHorasExtra(int cantidadHorasExtra)  throws IllegalArgumentException {
		//se genera filtro para que las horas extra no superen las 60 al mes
		if (cantidadHorasExtra > 60) {
			throw new IllegalArgumentException("ERROR: La cantidad de horas extra supera las perimitidas: 60");
		}
		this.cantidadHorasExtra = cantidadHorasExtra;
	}
	
	public void setIrpf (int irpf) throws IllegalArgumentException{
		//se genera filtro para que no se ponga un IRPF menor que 0
		if(irpf < 0) {
			throw new IllegalArgumentException("ERROR: El IRPF no puede ser menor que 0");
		}
		this.irpf = irpf;
	}
	
	public void setNumeroHijos(int numeroHijos) throws IllegalArgumentException{
		//se genera filtro para que no se ponga un numero de hijos negativo
		if(numeroHijos < 0) {
			throw new IllegalArgumentException("ERROR: El numero de hijos no puede ser negativo");
		}
		this.numeroHijos = numeroHijos;
	}
	
	public void setCasado(boolean casado) throws IllegalStateException{
		//Se genera filtro para que no se introduzca un estado civil igual al que ya se tiene
		if(this.casado == casado) {
			throw new IllegalArgumentException("ERROR: El estado civil ya es igual al introducido");
		}
		this.casado = casado;
	}
	
	public double complemento() {
		return this.precioHoraExtra * this.cantidadHorasExtra;
	}
	
	public double sueldoBruto() {
		return this.sueldoBase + complemento();
	}
	
	//Este método calcula el IRPF a aplicar en el salario bruto del empleado. Si es menor que 0, el IRPF se pondrá a 0;
	public double calculoRetenciones() {
		int irpf = this.irpf;
		if(casado == true) {
			irpf = irpf - 2;
		}
		if(this.numeroHijos > 0) {
			irpf = irpf - this.numeroHijos;
		}
		if(irpf < 0) {
			irpf = 0;
		}
		return sueldoBruto() * (double)irpf/100;
	}
	
	//Este método calcula el sueldo neto del empleado
	public double sueldoNeto() {
		return sueldoBruto() - calculoRetenciones();
	}
	
	//Este método devuelve un String con la información básica del empleado
	public String verEmpleado() {
		return String.format("Nif: %s, nombre: %s, apellidos: %s, sueldo base: %.2f, precio de la hora extra: %.2f€, cantidad horas extra: %d, tipo de IRPF: %d, numero de hijos: %d, estado civil: %b"
				, getNifEmpleado(), getNombreEmpleado(), getApellidosEmpleado(), getSueldoBase(), getPrecioHoraExtra(), getCantidadHorasExtra(), getIrpf(), getNumeroHijos(), getCasado());
	}
	
	//Este metodo devuelve un String con la informacion completa del empleado
	public String verTodoEmpleado() {
		return String.format("Nif: %s, nombre: %s, apellidos: %s, sueldo base: %.2f, precio de la hora extra: %.2f€, cantidad horas extra: %d, tipo de IRPF: %d, numero de hijos: %d, estado civil: %b\n"
				+ "complemento por horas extra: %.2f€, sueldo bruto: %.2f€, retencion por IRPF: %.2f€, sueldo neto: %.2f€."
				, getNifEmpleado(), getNombreEmpleado(), getApellidosEmpleado(), getSueldoBase(), getPrecioHoraExtra(), getCantidadHorasExtra(), getIrpf(), getNumeroHijos(), getCasado(),
				complemento(), sueldoBruto(), calculoRetenciones(), sueldoNeto());
	}
	
	////Este metodo devuelve un String con la informacion economica del empleado
	public String verDatosEconomicos() {
		return String.format("complemento por horas extra: %.2f€, sueldo bruto: %.2f€, retencion por IRPF: %.2f€, sueldo neto: %.2f€."
				,complemento(), sueldoBruto(), calculoRetenciones(), sueldoNeto());
	}
	//Este método genera una copia de los atributos de otro objeto
	public void copia (Empleado e) {
		this.nifEmpleado = e.nifEmpleado;
		this.nombreEmpleado = e.nombreEmpleado;
		this.apellidosEmpleado = e.apellidosEmpleado;
		this.sueldoBase = e.sueldoBase;
		this.precioHoraExtra = e.precioHoraExtra;
		this.cantidadHorasExtra = e.cantidadHorasExtra;
		this.sueldoBase = e.sueldoBase;
		this.numeroHijos = e.numeroHijos;
		this.casado = e.casado;
	}
	
	//seria correcto hacer asi el método?
	public static int numeroTotalEmpleados() {
		return numeroTotalEmpleados;
	}

	// este metodo filta el nif para saber si es un nif correcto
	private boolean isDniCorrecto(String nifEmpleado) throws IllegalArgumentException {
		boolean devolucion;
		Pattern patDni = Pattern.compile("[0-9]{1,8}[a-zA-Z]");
		Matcher matDni = patDni.matcher(nifEmpleado);
		if (matDni.matches()) {
			devolucion = true;

			String numeroDni = nifEmpleado.substring(0, 8);
			int numeroDniComprobar = Integer.parseInt(numeroDni);
			char[] letraDni = { 'T', 'R', 'w', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
					'V', 'H', 'L', 'C', 'K', 'E' };
			int operacion;
			operacion = numeroDniComprobar % 23;
			if (letraDni[operacion] == nifEmpleado.toUpperCase().charAt(8)) {
				devolucion = true;
			} else {
				devolucion = false;
				throw new IllegalArgumentException("ERROR: en la letra del dni introducido");
			}
		} else {
			devolucion = false;
			throw new IllegalArgumentException("ERROR: en el patrón del dni introducido");
		}
		return devolucion;

	}
}
