package ejercicio14;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		// Traemos la función Scanner y creamos variables.
		
		Scanner teclado = new Scanner(System.in);

		double megaB, kiloB, resultadoMB;
		
		//Solicitamos los megabytes
		
		System.out.println("Introduzca los Kilobytes a convertir: ");
		
		kiloB = teclado.nextDouble();
		
		//Realizamos la operación para la conversión
		
		resultadoMB = (double)(kiloB / 1000);
		
		//Mostramos en pantalla la solución
		
		System.out.println(kiloB + " KiloBytes son: " + resultadoMB + " MegaBytes");
		

	}

}
