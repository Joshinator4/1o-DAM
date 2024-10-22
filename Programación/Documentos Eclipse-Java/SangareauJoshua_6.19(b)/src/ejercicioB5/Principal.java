package ejercicioB5;

import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
		System.out.println("intentando instanciar alumno1");
		try {
			LocalDate fechaNacimiento = LocalDate.of(1992, 8, 22);
			Alumno alumno1 = new Alumno("05462865C", "joshua", "sangareau", fechaNacimiento, 1, true);
			System.out.println(alumno1.toString());
		}catch(IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}
		
		System.out.println("intentando instanciar alumno2");
		try {
			LocalDate fechaNacimiento = LocalDate.of(1889, 8, 22);
			Alumno alumno1 = new Alumno("05462865R", "Pepito", "sangareau", fechaNacimiento, 8, true);
			System.out.println(alumno1.toString());
		}catch(IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}
	}

}
