/*
 * 11. Escribe un programa que calcule el total de una factura a partir de la base imponible.
 */
package ejercicio11;

import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		// Traemos la función Scanner y creamos variables. Declaramos IVA como constante y la inicializamos a 0.21 (21%)
		
		Scanner teclado = new Scanner(System.in);
		
		double baseImponible, aumentoIva, costeTotal;
		final double IVA;
		
		IVA = 0.21;
		
		System.out.println("Introduzca coste de los productos: ");
		
		//Realizamos las operaciones pertinentes y las guardamos en su respectiva variable
		
		baseImponible = teclado.nextDouble();
		
		aumentoIva = (baseImponible * IVA);
		
		costeTotal = (baseImponible + aumentoIva);
		
		//Por último mostramos en pantalla los resultados.
		
		System.out.println("Base imponible:" + baseImponible + "€");
		System.out.println("IVA:" + aumentoIva + "€");
		System.out.println("Importe Total:" + costeTotal + "€");
	}

}
