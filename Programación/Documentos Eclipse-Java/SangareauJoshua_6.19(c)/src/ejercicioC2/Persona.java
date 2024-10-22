/*Añade a Persona el constructor de abajo y corrige el main para utilizarlo:
 * 
	public Persona(String dni, String nombre, String apellidos, int edad)
		{ this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		}
		
Ten en cuenta que no es obligatorio que los parámetros del constructor se llamen igual que los
atributos del objeto (en tal caso no sería necesario utilizar this). Podríamos hacerlo así:

	public Persona(String id, String nom, String ap, int
		e) { dni = id;
		nombre =
		nom; apellidos
		= ap; edad = e;
		}
		
Tampoco es obligatorio pasar al constructor todos los atributos de la clase. Podríamos decidir
por ejemplo que en nuestro software todas las personas deben tener nombre, apellidos y edad,
pero no es obligatorio el DNI (recién nacidos y niños). Este constructor también sería válido:

	public Persona(String nom, String ap, int e)
		{ nombre = nom;
		apellidos = ap;
		edad = e;
		}
		
Una clase puede tener tantos constructores como quieras siempre y cuando tengan distinto
número y/o tipo de parámetros (para que no haya ambigüedad en cual utilizar).

 * 
 */
package ejercicioC2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona {
	private String dni; // DNI de la persona	
	private String nombre; // Nombre de la persona
	private String apellidos; //Apellido de la persona
	private int edad; //Edad de la persona

	public Persona(String dni, String nombre, String apellidos, int edad){
	setDni(dni);
	setNombre(nombre);
	setApellidos(apellidos);
	setEdad(edad);
	}
	
	public Persona(String nombre, String apellidos, int edad){
	this("00000000T", nombre, apellidos, edad);
	}
	
	public Persona() {
		this("00000000T", "anónimo", "apellidoAnónimo", 0);
	}
	
	public String getDni() {
		return this.dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public void setDni(String dni) throws IllegalArgumentException {
		Pattern patDni = Pattern.compile("[0-9]{1,8}[a-zA-Z]");
	    Matcher matDni = patDni.matcher(dni);
		if(matDni.matches()) {
			String numeroDni = dni.substring(0, 8);
			int numeroDniComprobar = Integer.parseInt(numeroDni);
			char [] letraDni =  {'T', 'R', 'w', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		    int operacion;
		    operacion = numeroDniComprobar % 23;
		    if (letraDni[operacion] == dni.toUpperCase().charAt(8)) {
		    	this.dni = dni;
		    }else {
		    	throw new IllegalArgumentException ("ERROR: El dni introducido no es correcto, la letra no es correcta con la numeración introducida");
		    }
		}else {
			throw new IllegalArgumentException ("ERROR: El patrón del dni introducido no es correcto, el dni introducido debe contener 8 números seguidos de una letra");
		}	
	}
	
	public void setNombre (String nombre) throws IllegalArgumentException {
		if (nombre.isEmpty() || nombre == null) {
			throw new IllegalArgumentException ("ERROR: El nombre introducido no debe ser cadena de texto vacía o null");
		}else {
			this.nombre = nombre;
		}
	}

	public void setApellidos (String apellidos) throws IllegalArgumentException{
		if (apellidos.isEmpty() || apellidos == null) {
			throw new IllegalArgumentException ("ERROR: Los apellidos introducidos no debe ser cadena de texto vacía o null");
		}else {
			this.apellidos = apellidos;
		}
	}
	
	public void setEdad (int edad) throws IllegalArgumentException{
		if(edad < 0 || edad > 120) {
			throw new IllegalArgumentException ("ERROR: Ha introducido una edad incorrecta, por favor introduzca una edad en el rango de 0-120");
		}else {
			this.edad = edad;
		}
	}
	
	public String toString() {
		String devolucion;
		devolucion = "dni: " + getDni() + ", nombre: " + getNombre() + ", apellidos: " + getApellidos() + ", edad: " + getEdad();
		return devolucion;
		
	}
}
