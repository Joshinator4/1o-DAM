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
package ejercicioB2;

public class Persona {
	String dni; // DNI de la persona	
	String nombre; // Nombre de la persona
	String apellidos; //Apellido de la persona
	int edad; //Edad de la persona

	public Persona(String dni, String nombre, String apellidos, int edad){
	this.dni = dni;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.edad = edad;
	}
	
	public Persona(String nombre, String apellidos, int edad){
	this(null, nombre, apellidos, edad);
	}
	
	public Persona() {
		this(null, null, null, 0);
	}
	
	//ASI PIENSO QUE SERIA UN TO STRING
	//public String toString() {
		//String devolucion;
		//devolucion = "dni: " + this.dni + ", nombre: " + this.nombre + ", apellidos: " + this.apellidos + ", edad: " + this.edad;
		//return devolucion;
		
	//}
}
