package ejercicioC5;

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
			LocalDate fechaNacimiento = LocalDate.of(1989, 8, 22);
			Alumno alumno2 = new Alumno("05462865R", "Pepito", "sangareau", fechaNacimiento, 7, true);
		}catch(IllegalArgumentException excepcion2) {
			System.out.println(excepcion2.getMessage());
		}
		
		System.out.println("intentando instanciar alumno3");
		try {
			LocalDate fechaNacimiento = LocalDate.of(1989, 8, 22);
			Alumno alumno3 = new Alumno("05462R865", "Pepito", "sangareau", fechaNacimiento, 7, true);
		}catch(IllegalArgumentException excepcion3) {
			System.out.println(excepcion3.getMessage());
		}
		
		System.out.println("intentando instanciar alumno4");
		try {
			LocalDate fechaNacimiento = LocalDate.of(1989, 8, 22);
			Alumno alumno4 = new Alumno("05462865C", "", "sangareau", fechaNacimiento, 7, true);
		}catch(IllegalArgumentException excepcion4) {
			System.out.println(excepcion4.getMessage());
		}
		
		System.out.println("intentando instanciar alumno5");
		try {
			LocalDate fechaNacimiento = LocalDate.of(1989, 8, 22);
			Alumno alumno5 = new Alumno("05462865C", "Pepito", "", fechaNacimiento, 7, true);
		}catch(IllegalArgumentException excepcion5) {
			System.out.println(excepcion5.getMessage());
		}
		
		System.out.println("intentando instanciar alumno6");
		try {
			LocalDate fechaNacimiento = LocalDate.of(1889, 8, 22);
			Alumno alumno6 = new Alumno("05462865C", "Pepito", "sangareau", fechaNacimiento, 7, true);
		}catch(IllegalArgumentException excepcion6) {
			System.out.println(excepcion6.getMessage());
		}
		
		System.out.println("intentando instanciar alumno7");
		try {
			LocalDate fechaNacimiento = LocalDate.of(1989, 8, 22);
			Alumno alumno7 = new Alumno("05462865C", "Pepito", "sangareau", fechaNacimiento, 9, true);
			System.out.println(alumno7.toString());
		}catch(IllegalArgumentException excepcion7) {
			System.out.println(excepcion7.getMessage());
		}
	}

}
