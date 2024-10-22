/*12. Escribe un programa que calcule el salario semanal de un empleado en base a las horas
 * trabajadas, a razón de 12 euros la hora.
 */
package ejercicio12;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		// Traemos la función Scanner y creamos variables.
		
		Scanner teclado = new Scanner(System.in);
		
		byte jornadaSemanal;
		final byte salarioHora = 12;
		short salarioSemanal;
		
		// Solicitamos el nº de horas trabajadas en la semana
		
		System.out.println("Introduzca nº de horas trabajadas esta semana: ");
		
		jornadaSemanal = teclado.nextByte();
		
		//Realizamos el cálculo multiplicando el nº de horas introducido por los 12€ que se gana por hora
		
		salarioSemanal = (short)(salarioHora * jornadaSemanal);
		
		System.out.println("El importe recibido semanal es: " + salarioSemanal);
		

	}

}
