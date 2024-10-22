package longitud_De_Palabra_length;

import java.util.Scanner;

public class Uso_Del_Length {

	public static void main(String[] args) {
		// Se usa .length() para que devuelva la longitud del string (nº de letras que contiene)
		
		Scanner teclado = new Scanner(System.in);
		
		String palabra;
		
		System.out.println("Introduzca una palabra");
		
		palabra = teclado.nextLine();
		
		//Usamos palabra.length() para que nos diga la cantidad de letras que tiene nuestra palabrao frase (suma los espacios también)
		
		System.out.println("Su palabra tiene: " + palabra.length() + " letras");
		
	}

}
