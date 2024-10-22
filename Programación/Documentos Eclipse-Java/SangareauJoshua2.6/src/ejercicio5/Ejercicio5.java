/* Realizar un programa en Java que solicite al usuario una serie de datos:
 Nombre
 Apellidos
 Ciclo Formativo
 Nota académica (entero)
Una vez conocida la nota devolverá un mensaje al usuario en formato de ficha, mostrando
todos los datos así como la nota obtenida en formato palabra (Insuficiente, aprobado, bien,
notable o sobresaliente).
Nombre: Juan
Apellidos: López Pérez
Ciclo Formativo: Desarrollo de Aplicaciones Multiplataforma
Nota académica: 8 (Notable)
 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		// Llamamos al Scanner y creamos variables.
		
				Scanner teclado = new Scanner(System.in);
				
				int nota;
				String nombre, apellidos, ciclo;
				
				//Solicitamos datos al usuario y guardamos en sus respecitvas variables
				
				System.out.println("Introduzca su nombre: ");
				
				nombre = teclado.nextLine();
				
				System.out.println("Introduzca sus apellidos: ");
				
				apellidos = teclado.nextLine();
				
				System.out.println("Introduzca el ciclo formativo: ");
				
				ciclo = teclado.nextLine();
				
				System.out.println("Introduzca su nota académica: ");
				
				nota = teclado.nextInt();
				
				//Imprimimos en pantalla los datos solicitados por el ejercicio
				
				System.out.println("Nombre: " + nombre);
				System.out.println("Apellidos: " + apellidos);
				System.out.println("Ciclo formativo: " + ciclo);
				
				////Creamos las condiciones para las notas generamos if para <5 (insuficiente) y else que desde el 9(incluido) en adelante es sobresaliente
				//dentro del if creamos else if para cada una de las demás notas
				
				if (nota < 5){
					System.out.println("Nota académica: " + nota + " (Insuficiente)");
					}
					
				else if (nota < 6) {
					System.out.println("Nota académica: " + nota + " (Aprobado)");
					}
					
				else if (nota < 7){
					System.out.println("Nota académica: " + nota + " (Bien)");
					}
					
				else if (nota < 9) {
						System.out.println("Nota académica: " + nota + " (Notable)");
					}
				
				else {
						System.out.println("Nota académica: " + nota + " (Sobresaliente)");
						}
	}

}
