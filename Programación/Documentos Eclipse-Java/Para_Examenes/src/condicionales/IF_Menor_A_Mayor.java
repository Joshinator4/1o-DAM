/*Este ejercicio supone una variación del ejercicio anterior. Una vez solicitados los datos al
usuario y almacenada en la correspondiente variable la nota obtenida se harán las siguientes
comprobaciones:
 Si la nota obtenida es menor que 0 o mayor que 10, mostrará un mensaje por pantalla
que dirá: " La nota académica indicada es incorrecta"
 En caso contrario, procederá con el programa tal y como se mostraba anteriormente.
 Añadiremos al programa anterior un caso más, en caso de obtener una nota académica
de 10, el valor mostrado será "Matrícula de Honor"
 */
package condicionales;

import java.util.Scanner;

public class IF_Menor_A_Mayor {

	public static void main(String[] args) {
		// ESTE EJERCICO ES IGUAL AL EJERCICO 5 CON ALGUNAS MODIFICACIONES
		// Llamamos al Scanner y creamos variables.

		Scanner teclado = new Scanner(System.in);

		int nota;
		String nombre, apellidos, ciclo;

		// Solicitamos datos al usuario y guardamos en sus respecitvas variables

		System.out.println("Introduzca su nombre: ");

		nombre = teclado.nextLine();

		System.out.println("Introduzca sus apellidos: ");

		apellidos = teclado.nextLine();

		System.out.println("Introduzca el ciclo formativo: ");

		ciclo = teclado.nextLine();

		System.out.println("Introduzca su nota académica: ");

		nota = teclado.nextInt();

		// Imprimimos en pantalla los datos solicitados por el ejercicio

		System.out.println("Nombre: " + nombre);
		System.out.println("Apellidos: " + apellidos);
		System.out.println("Ciclo formativo: " + ciclo);

		// Creamos las condiciones para las notas generamos if para que si las notas son
		// <0 o >10 se imprima en pantalla la nota academica es incorrecta. Usamos else
		// if con <5 etc
		// con su respectiva nota cualitativa y else ya reconoce que el último nº es el
		// 10
		// dentro del if creamos else if para cada una de las demás notas

		if (nota < 0 || nota > 10) {
			System.out.println("La nota académica indicada es incorrecta");
					
		} else if (nota < 5) {
			System.out.println("Nota académica: " + nota + " (Insuficiente)");
					
		} else if (nota < 6) {
			System.out.println("Nota académica: " + nota + " (Aprobado)");
					
		} else if (nota < 7) {
			System.out.println("Nota académica: " + nota + " (Bien)");
					
		} else if (nota < 9) {
			System.out.println("Nota académica: " + nota + " (Notable)");
					
		} else if (nota < 10) {
			System.out.println("Nota académica: " + nota + " (Sobresaliente)");
					
		} else {
			System.out.println("Nota académica: " + nota + " (Matrícula de Honor)");
		}

	}

}