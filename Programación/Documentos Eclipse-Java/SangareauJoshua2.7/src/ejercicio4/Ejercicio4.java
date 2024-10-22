/*Solicitar al usuario la nota media obtenida en 4 asignaturas, la nota será de tipo double.
 Calcular la nota media y mostrarla al usuario
 Mostrar la nota media pero redondeada hacia arriba
 Mostrar la nota media redondeada hacia abajo
Una vez obtenida la nota media comprobar si supera el 8, en ese caso mostrar un mensaje por
pantalla indicando que puede acceder a estudios deseados.
En caso opuesto mostrarle un mensaje indicando que la nota media obtenida no es suficiente
para acceder a los estudios que deseaba.
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// Llamamos al Scanner y creamos variables.
		
		Scanner teclado = new Scanner (System.in);
		
		double nota1, nota2, nota3, nota4, notaMedia;
		
		System.out.println("Introduzca nota1:");
		
		nota1 = teclado.nextDouble();
		
		System.out.println("Introduzca nota2:");
		
		nota2 = teclado.nextDouble();
		
		System.out.println("Introduzca nota3:");
		
		nota3 = teclado.nextDouble();
		
		System.out.println("Introduzca nota4:");
		
		nota4 = teclado.nextDouble();
		
		notaMedia = (nota1 + nota2 + nota3 + nota4)/4;
		
		System.out.println("La nota media es: " + notaMedia);
		
		System.out.println("La nota media redondeada hacia arriba es: " + Math.ceil(notaMedia));
		
		System.out.println("La nota media redondeada hacia abajo es: " + Math.floor(notaMedia));
		
		if (notaMedia < 8) {
			
			System.out.println("Lo sentimos, la nota media obtenida no es suficiente para acceder a los estudios que desea.");
		
		} else {
			
			System.out.println("Enhorabuena, usted puede acceder a los estudios deseados.");
		}
		

	}

}
