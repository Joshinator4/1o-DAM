package ejercicioC2;

public class Principal {

	public static void main(String[] args) {
		
		//genero bloques try-catch diferentes para ver que saltan las excepciones generadas por los distintos errores al instanciar los objetos
		try {
			System.out.println("Instanciando persona1");
			Persona persona1 = new Persona("05462865C","juan", "perez", 18);
			System.out.println(persona1.toString());
		}catch (IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}
		
		try {
			System.out.println("Instanciando persona2");
			Persona persona2 = new Persona();
			System.out.println(persona2.toString());
		}catch(IllegalArgumentException excepcion2) {
			System.out.println(excepcion2.getMessage());
		}
		
		try {
			System.out.println("Instanciando persona3");
			Persona persona3 = new Persona("05462865F", "juan", "perez", 19);
			System.out.println(persona3.toString());
		}catch(IllegalArgumentException excepcion3) {
			System.out.println(excepcion3.getMessage());
		}
		try {
			System.out.println("Instanciando persona4");
			Persona persona4 = new Persona("05462865C", "", "perez", 19);
			System.out.println(persona4.toString());
		}catch(IllegalArgumentException excepcion4) {
			System.out.println(excepcion4.getMessage());
		}
		try {
			System.out.println("Instanciando persona5");
			Persona persona5 = new Persona("05462865C", "juan", "", 19);
			System.out.println(persona5.toString());
		}catch(IllegalArgumentException excepcion5) {
			System.out.println(excepcion5.getMessage());
		}
		try {
			System.out.println("Instanciando persona6");
			Persona persona6 = new Persona("05462865C", "juan", "perez", -1);
			System.out.println(persona6.toString());
		}catch(IllegalArgumentException excepcion6) {
			System.out.println(excepcion6.getMessage());
		}
		try {
			System.out.println("Instanciando persona7");
			Persona persona7 = new Persona("0546C865", "juan", "perez", -1);
			System.out.println(persona7.toString());
		}catch(IllegalArgumentException excepcion7) {
			System.out.println(excepcion7.getMessage());
		}

	}

}
