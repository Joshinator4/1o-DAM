/*
 * 2. Escribir un programa en Java que pregunte tu nombre, dirección y teléfono y escriba en
 * pantalla una ficha.
 */
package ejercicioEntradaSalida2;

import java.util.Scanner;

public class EjercicioEntradaSalida2 {

	public static void main(String[] args) {
		
	//Ejercicio 2. Pide una ficha (no se biena a que se refiere la ficha) (no sé como cerrar la parte derecha de la ficha con "|" porque no cuadrarían según lo escrito.
		
		//Importamos Scanner y declaramos variables
		
		String nombre, direccion;
		int telefono;
		
		Scanner teclado = new Scanner(System.in);
		
		//pedimos datos al usuario y los grabamos en las variables
		
		System.out.println("Introduce tu nombre: ");
				
		nombre = teclado.nextLine();
				
		System.out.println("Introduce tu dirección: ");
				
		direccion = teclado.nextLine();
				
		System.out.println("Introduce tu teléfono: ");
				
		telefono = teclado.nextInt();
		
		//Imprimimos en pantalla la ficha
				
		System.out.println("-----------------------------------------------------------------------------------");
				
		System.out.println("|******Nombre: " + nombre + "*****");
				
		System.out.println("|******Dirección: " + direccion + "*****");
				
		System.out.println("|******Teléfono: " + telefono + "*****");
				
		System.out.println("-----------------------------------------------------------------------------------");

	}

}
