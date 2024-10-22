package excepcion_Int;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepcion_Int {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);

		boolean correcto= false;
		int operacion, numeroIntroducido1, numeroIntroducido2;
		
		do {
			try {

				System.out.println("Introduzca el primer numero");
				numeroIntroducido1 = teclado.nextInt();
				
				System.out.println("Introduzca el segundo numero");
				numeroIntroducido2 = teclado.nextInt();
		
				operacion = numeroIntroducido1 / numeroIntroducido2;

				System.out.println("El resultado es: " + operacion);
				
				correcto = true;
			
			} catch (ArithmeticException excepcion1) {
				System.out.println("Has introducido el divisor = 0");

			} catch (InputMismatchException excepcion2) {
				System.out.println("Has itroducido un texto o cadena de caracteres, tienes que introducir numeros");
				teclado.nextLine();
				
			} catch (Exception excepcion3) {
				System.out.println("Hay algun error, vuelve a intenatarlo");
			
			}
		} while(correcto == false);
	}

}
