/*
 * Crea un método llamado indicaMesDias que devolverá una cadena de texto.
 El método recibirá un valor entero.
 Comprobará que el valor oscile entre 1 y 12 (ambos inclusive)
En caso contrario devolverá un mensaje indicando que el mes es incorrecto.
 En caso de ser correcto devolverá un mensaje indicando el mes al que se refiere y el
número de días del mes: Ejemplo: " Enero, 31 días".

 */
package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// ----------------------------------------------
		// Declaración de variables
		// ----------------------------------------------

		// Constantes
		// Variables de entrada
		int mes;
		// Variables de salida
		// Variables auxiliares
		// Clase Scanner para petición de datos

		Scanner teclado = new Scanner(System.in);

		// ----------------------------------------------
		// Entrada de datos
		// ----------------------------------------------

		System.out.println("Introduzca el número del mes: ");
		mes = teclado.nextInt();

		// ----------------------------------------------
		// Procesamiento
		// ----------------------------------------------

		System.out.println(indicaMesDias(mes));

	}

	public static String indicaMesDias(int x) {
		Scanner teclado = new Scanner(System.in);
		String mes = null;

		switch (x) {
		case 1: {
			mes = "Enero, 31 días";
			break;
		}
		case 2: {
			mes = "Febrero, 28 días";
			break;
		}
		case 3: {
			mes = "Marzo, 31 días";
			break;
		}
		case 4: {
			mes = "Abril, 30 días";
			break;
		}
		case 5: {
			mes = "Mayo, 31 días";
			break;
		}
		case 6: {
			mes = "Junio, 30 días";
			break;
		}
		case 7: {
			mes = "Julio, 31 días";
			break;
		}
		case 8: {
			mes = "Agosto, 31 días";
			break;
		}
		case 9: {
			mes = "Septiembre, 30 días";
			break;
		}
		case 10: {
			mes = "Octubre, 31 días";
			break;
		}
		case 11: {
			mes = "Noviembre, 30 días";
			break;
		}
		case 12: {
			mes = "Diciembre, 31 días";
			break;
		}
		default: {
			mes = "El número del mes introducido es incorrecto, vuelva a introducirlo ";
		}

		}

		return mes;

	}
}