/*Se deberá realizar un programa en java el cual haciendo uso de la entrada estándar solicite los
 * siguientes datos al usuario:
 * Nombre
 * Apellidos
 * Sexo (M/F)
 * Dirección
 * Edad
 * Altura
 * Peso 
 * Cada uno de los datos se almacenará en una variable del tipo correspondiente.
 * Por último mostraremos por pantalla los valores correspondientes a cada uno de los datos introducidos por el usuario, mostrando 
 * cada dato en una linea.
 * Ejemplo: Nombre: Javier 
 */

package ejercicio1;

	// Para llamar función Scanner (se puede poner Scanner teclado=new Scanner(System.in) y dejando el ratón en Scanner nos dirá import Scanner)
	// Limpiamos Scanner solo cuando haya que cambiar de Número a String

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		//Crearemos la entrada de Scanner asignada a una palabra (teclado en este caso)	
		
		Scanner teclado = new Scanner(System.in);
		
		// crearemos la variable nombre en este caso 
		
		String nombre;
		
		//Solicitamos datos al usuario
		
		System.out.println("Escriba su nombre: ");
		
		// llamamos a la variable como teclado.next(el método que corresponda)	en este caso .nextline
		
		nombre = teclado.nextLine();
		
		//Realizamos lo mismo para atodos los datos requeridos
		
		String apellidos;
		
		System.out.println("Escriba sus apellidos: ");
		
		apellidos = teclado.nextLine();
		
		String sexo;
		
		System.out.println("Introduzca su sexo, escriba (H/M)");
		
		sexo = teclado.nextLine();
		
		String direccion;
		
		System.out.println("Escriba su direccion: ");
		
		direccion = teclado.nextLine();
		
		byte edad;
		
		System.out.println("Escriba su edad:");
		
		edad = teclado.nextByte();
		
		short altura;
		
		System.out.println("Escriba su altura:");
		
		altura = teclado.nextShort();
		
		double peso;
		
		System.out.println("Introduzca su peso:");
		
		peso = teclado.nextDouble();
		
		// Imprimimos en pantalla todos los datos cada uno en una línea (\n para saltar de línea) (utilizar + para añadir variables, más texto o el salto de línea)
		
		System.out.println("Su nombre es: " + nombre + "\n" + "Sus apellidos son: " + apellidos + "\n" + "Su sexo es: " + sexo + "\n" +
				"Su direccion es: " + direccion + "\n" + "Su edad es: " + edad + "\n" +  "Su altura es: " + altura +"\n" + "Su peso es: " + peso + "\n");
		
		
		
				}

}
