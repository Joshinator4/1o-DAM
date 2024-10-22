/*Realiza un programa en Java que permita introducir por teclado los siguientes datos:

Nombre
Apellido
Día de nacimiento
Mes de nacimiento
Año de nacimiento
Género (M/F)
Se desea crear un identificador de usuario que tenga el siguiente formato:

los dos primeros caracteres de Apellido más
los dos primeros caracteres de Nombre más
Día de nacimiento
Ejemplo:

Nombre: Pedro

Apellido: García

Día de nacimiento: 12

El identificador de usuario será: GaPe12
 * 
 */
package chartAt;

import java.util.Scanner;

public class Uso_del_charAt {

	public static void main(String[] args) {
		// Traemos la función Scanner y creamos variables.
		
		Scanner teclado = new Scanner(System.in);
		
		String nombre, apellido, diaNacimiento, mesNacimiento, yearNacimiento, genero;
		
		//Solicitamos datos al usuario

		System.out.println("Introduce tu nombre: ");
		
		nombre = teclado.nextLine();
				
		System.out.println("Introduce tu apellido: ");
				
		apellido = teclado.nextLine();
				
		System.out.println("Introduce Día de nacimiento: ");
		
		diaNacimiento= teclado.nextLine();
		
		System.out.println("Introduce mes de nacimiento: ");
		
		mesNacimiento= teclado.nextLine();
		
		System.out.println("Introduce año de nacimiento: ");
		
		yearNacimiento= teclado.nextLine();
		
		System.out.println("Introduce tu género: ");
		
		genero= teclado.nextLine();
		
		//imprimimos en pantalla los datos
		
		System.out.println("Nombre: " + nombre);
		
		System.out.println("Apellido: " + apellido);
		
		System.out.println("Día nacimineto: " + diaNacimiento);
		
		//utilizamos metodo .charAt(0) para indicar que se imprima el primer caracter de la variable y .charAt(1) para el segundo caracter
		
		System.out.println("El identificador de usuario es:" + nombre.charAt(0) + nombre.charAt(1) + apellido.charAt(0) + apellido.charAt(1) + diaNacimiento);

	}
		// Si se necesita sacar una letra de un string no existe teclado.nextChar. Hay q hacerlo con teclado.next().charAt(0)<------------------------IMPORTANTE------------------------->
}
