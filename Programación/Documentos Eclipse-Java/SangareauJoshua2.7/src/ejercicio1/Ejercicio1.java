/*Realizar un programa en Java que ayudará a un equipo de Recursos Humanos a realizar una
serie de entrevistas al usuario:
 En primer lugar se solicitarán al usuario los siguientes datos:
o Nombre, apellidos, edad y salario deseado
 Si el salario deseado supera los 30.000 euros o la edad es superior a 45 años el
candidat@ queda descartado. Mostramos un mensaje indicándolo y termina el
programa. " Lo sentimos pero no cumple nuestro perfil"
 En caso contrario continuamos con la entrevista, preguntando los siguientes
datos:
o Años de experiencia
o Proyectos trabajados anteriormente
 Si los años de experiencia superan los 2 y ha trabajado en más de 3 proyectos
será contratado. Mostraremos un mensaje "Enhorabuena. Ha sido
contratado"
 En caso contrario mostrar un mensaje: . " Lo sentimos pero no cumple
nuestro perfil"

 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// Llamamos al Scanner y creamos variables.
		
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
			}
			
		}
		
	}

}
