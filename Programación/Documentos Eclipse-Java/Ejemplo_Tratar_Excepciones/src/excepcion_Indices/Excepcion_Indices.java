package excepcion_Indices;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepcion_Indices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] colores = {"azul", "amarillo", "rojo", "verde", "negro"};
		
		boolean fueraDeLimites = true;
		
		int campoIntroducido;
		
		Scanner teclado = new Scanner(System.in);
		
		while (fueraDeLimites) {
			
		
			try {
				System.out.println("Introduzca el campo para ver el color");
				campoIntroducido = teclado.nextInt();
				System.out.println(colores[campoIntroducido]);
				fueraDeLimites = false;
		
			}catch(ArrayIndexOutOfBoundsException excepcion1) {
				System.err.println("Has introducido un campo fuera del rango del array");
			}catch(InputMismatchException excepcion2) {
				System.err.println("Debes introducir un número");
			}catch(Exception excepcion3) {
				System.err.println("Hay algún error, vulve a introducir el campo");
			}
			
			teclado.nextLine();
		}
	}

}
