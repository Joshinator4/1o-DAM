package mayormenoredad;

import java.util.Scanner;

public class Mayormenoredad2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int edad;
		String nombre; 
		
		Scanner teclado = new Scanner(System.in);
		
//		System.out.println("dame tu edad: ");
		
//		edad = teclado.nextInt()
				
//		System.out.println("Tu edad es: " + edad);
		
		// Pido cadena de caracteres
		System.out.println("dame tu nombre: ");
		nombre = teclado.nextLine();
		
		System.out.println("Tu nombre es: " + nombre);
		
		char letraInicial;
		
		letraInicial = nombre.charAt(0);
		
		System.out.println("la primera letra de tu nombre es: " + letraInicial);
		
		int numCaracteres;
		
		numCaracteres = nombre.length();
		
		System.out.println("Tu nombre tiene " + numCaracteres +" letras");
		
		
		
		
		
	}

}
