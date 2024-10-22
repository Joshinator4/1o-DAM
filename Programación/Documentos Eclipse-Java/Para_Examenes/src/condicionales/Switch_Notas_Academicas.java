/*Haciendo uso de un switch case solicitar al usuario una nota en valor entero. Indicar la
calificación correspondiente a cada caso. Desde 0 hasta 10, en caso opuesto, en el default
indicar que la nota introducida no es correcta.
 */
package condicionales;

import java.util.Scanner;

public class Switch_Notas_Academicas {

	public static void main(String[] args) {
		// Llamamos al Scanner y creamos variables.
		
		Scanner teclado = new Scanner (System.in);
		
		int nota;
		
		System.out.println("Introduzca su nota en valor entero:");
		
		nota = teclado.nextInt();
		
		switch (nota) {
			case (1): case (2): case (3): case (4):{
				System.out.println("Insuficiente");
				break;
			
			} case (5):{
				System.out.println("Aprobado");
				break;
			
			} case (6):{
				System.out.println("Bien");
				break;
			
			} case (7): case(8): {
				System.out.println("Notable");
				break;
			
			} case (9): case(10):{
				System.out.println("Sobresaliente");
				break;
			}
			
		 default: 
			 System.out.println("La nota introducida no es correcta");
		}	
		

	}

}
