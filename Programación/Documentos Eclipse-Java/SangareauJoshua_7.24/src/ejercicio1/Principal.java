package ejercicio1;

public class Principal {

	public static void main(String[] args) {

		Humano humano1 = new Humano ("Antonio", "Gámez");
		
		Ciudadano ciudadano1 = new Ciudadano ("Juan", "Sánchez", "78549632V");
		
		Ciudadano ciudadano2 = new Ciudadano ("Ivan", "Barros", "12345678J");
		
		System.out.println(humano1.getNombreCompleto());
		System.out.println(ciudadano1.getNombreCompleto());
		System.out.println(ciudadano2.getNombreCompleto());
		
		System.out.println("Informe:\nDatos humano1: " + humano1.getNombreCompleto() + ",\nDatos de ciudadano1: " + ciudadano1.identificacion() 
		+ "\nDatos de ciudadano2: " + ciudadano2.identificacion());
	}

}
