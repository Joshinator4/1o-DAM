/*1. Escribe un programa que pida por teclado un día de la semana y que diga qué asignatura
toca a primera hora ese día.
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		//Llamamos al Scanner y creamos variables.
		
		Scanner teclado = new Scanner (System.in);
		
		String dia;
		
		System.out.println("Introduzca día de la semana (de lunes a viernes):");
		
		dia = teclado.nextLine();
		
		switch (dia) {
			
			case "lunes": {
			
			System.out.println("La asignatura de primera hora es Sistemas Informáticos");
			
			break;
			
			} case "martes": {
			
			System.out.println("La asignatura de primera hora es Lenguaje de marcas");
			
			break;
			
			} case "miércoles": {
				
				System.out.println("La asignatura de primera hora es Base de Datos");
			
			break;
			
			} case "jueves": {
				
				System.out.println("La asignatura de primera hora es Entornos de Desarrollo");
				
			break;
			
			} default: {
				
				System.out.println("La asignatura de primera hora es Formación y Orientación Laboral");
			}
		
		}
	
	}

}
