package ejercicio3;

public class Colegio {

	public static void main(String[] args) {
		
		try {
			Personal personal1 = new Personal();
			System.out.println("Creado personal1");
			System.out.println("Años que faltan para jubilarse: " + personal1.anyosJubilacion());
			System.out.println("Se le aumenta un 10% el salario (1000€ salario inicial)");
			personal1.aumentoSalario(10);
			System.out.println(personal1.toString());
		}catch(IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}
		
		try {
			Profesor profesor1 = new Profesor();
			System.out.println("\nCreado profesor1");
			System.out.println("Se le aumentan los años de experiencia en 5");
			profesor1.setAnyosExperiencia(5);
			System.out.println("Se le aumenta el salario (1000€ salario inicial) segun los años de experiencia");
			profesor1.aumentarSalario();
			System.out.println(profesor1.toString());
		}catch(IllegalArgumentException excepcion2) {
			System.out.println(excepcion2.getMessage());
		}
		
		try {
			PAS pas1 = new PAS();
			System.out.println("\nCreado pas1");
			System.out.println("Se le cambia el idioma aleman y chino a si conocido");
			pas1.cambioIdioma("chino");
			pas1.cambioIdioma("aleman");
			System.out.println("Se muestra la cantidad de idiomas conocidos: " + pas1.numeroIdiomas());
			System.out.println(pas1.toString());
		}catch(IllegalArgumentException excepcion2) {
			System.out.println(excepcion2.getMessage());
		}
		
	}

}
