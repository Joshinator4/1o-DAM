/*Realizar un programa en Java que solicite al usuario los siguientes datos:
 * Edad
 * Nota académica
 * El usuario quiere acceder a unos estudios para los que se requieren dos condiciones. Por un
 * lado ser mayor de 18 años y además haber obtenido una nota académica mayor de 7.
 * Comprobar si los datos introducidos cumplen ambas condiciones. De ser así mostrar un
 * mensaje por pantalla: "Usted ha sido admitido en el curso, cumple las condiciones
 * requeridas". En caso contrario mostrar el siguiente mensaje "Lo sentimos, no ha sido
 * admitido en el curso ya que no cumple los requisitos mínimos" 
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// Llamamos al Scanner y creamos variables.
		
		Scanner teclado = new Scanner(System.in);
		
		byte edad;
		double notaAcademica;
		
		//Pedidmos la edad y la nota academica. Se las asignamos a las variables correspondientes
		
		System.out.println("Introduzca su edad:");
		
		edad = teclado.nextByte();
		
		System.out.println("Introduzca su nota academica:");
		
		notaAcademica = teclado.nextDouble();
		
		//Creamos el if con la doble condición edad mayor de 18 y nota academica mayor de 7
		
		if (edad>18 && notaAcademica>7) {
			
			System.out.println("Usted ha sido admitido en el curso, cumple las condiciones requeridas");
			
		}
		
		//creamos el else para en caso de que no cumpla alguna de las dos condiciones salga el mensaje deseado
		
		else {
			System.out.println("Lo sentimos, no ha sido admitido en el curso ya que no cumple los requisitos mínimos");
		}
		
		
		
	}

}
