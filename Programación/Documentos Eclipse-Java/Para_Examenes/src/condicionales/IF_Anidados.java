/* El siguiente programa será una mejora del anterior. Aprovecharemos el código realizado
anteriormente, pero añadiremos una nueva comprobación.
Veamos el punto al que nos referimos:
 Si los años de experiencia superan los 2 y ha trabajado en más de 3 proyectos
será contratado. Mostraremos un mensaje "Enhorabuena. Ha sido
contratado"
 Si el trabajador tiene más de 5 años de experiencia o ha trabajado en más de 5
proyectos se le asignará como salario anual: 30.000 euros. En caso opuesto
25.000. Se le mostrará por pantalla un mensaje indicándole el salario a percibir.
 */
package condicionales;

import java.util.Scanner;

public class IF_Anidados {

	public static void main(String[] args) {
		//  Llamamos al Scanner y creamos variables.
		
		Scanner teclado = new Scanner (System.in);
		
		String nombre, apellidos;
		byte edad, experiencia, proyectosTrabajados;
		int salarioDeseado;
		
		//Pedimos datos al usuario
		
		System.out.println("Introduzca su nombre: ");
		
		nombre = teclado.nextLine();
		
		System.out.println("Introduzca sus apellidos: ");
		
		apellidos = teclado.nextLine();
		
		System.out.println("Introduzca su edad: ");
		
		edad = teclado.nextByte();
		
		System.out.println("Introduzca el salario que desea percibir: ");
		
		salarioDeseado = teclado.nextInt();
		
		//Generamos 1ª condición solicitada por RRHH
		
		if (salarioDeseado >30000 || edad >45) {
			
			System.out.println("Lo sentimos pero no cumple nuestro perfil");
		} else {
			
			//Si cumple los requesitos, solicitamos mas datos
			
			System.out.println("Introduzca los años de experiencia");
			
			experiencia = teclado.nextByte();
			
			teclado.nextLine();
			
			System.out.println("Introduzca cantidad de proyectos en los que haya trabajado anteriormente");
			
			proyectosTrabajados = teclado.nextByte();
			
			//Generamos segunda condicion (anidada en else de la anterior) solicitada por RRHH.
			
			if (experiencia < 2 || proyectosTrabajados < 3) {
				
				System.out.println("Lo sentimos pero no cumple nuestro perfil");
			} else {
				System.out.println("Enhorabuena. Ha sido contratado");
				
				//generamos una tercera condición segun los años y proyectos se le pagará más o menos (>5años trabjados y >5proyectos trabajados = 30000)
				
				if (experiencia < 5 || proyectosTrabajados < 5) {
					
					System.out.println("Su salario será 25000€");
				} else {
					System.out.println("Su salario será 30000€");
				}
			}
			
		}

	}

}
