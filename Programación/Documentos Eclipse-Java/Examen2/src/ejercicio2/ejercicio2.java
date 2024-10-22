package ejercicio2;

import java.util.Scanner;

/*objetivo: crear un programa que genere 30 números aleatorios entre 0 y 100 y los muestre por pantalla y realice: 
 * 1 pedir un numero entre 0 y 100 y mostrar todos los valores menores que el numero introducido y sus posiciones
 * 2 pedirá dos posiciones y mostrará los valores pares que haya entre las 2
 * autor: Francisco Javier Maartín-Lunas Escobar
 * fecha: 29/11/2022*/
public class ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		final int CANT=30;
		int num [] = new int[CANT];
		int numMenoresA, pos1, pos2;
		//damos valores aleatorios a num[] 
		for (int i=0; i< CANT; i++) {
			num[i] = (int) (Math.random()*(100-0));
		}
		
		System.out.println("Inserte un número: ");
		numMenoresA = entrada.nextInt();
		
		//según numMenoresA mostrará los números menores a él y su posición
		for (int i=0; i< CANT; i++) {
			if (numMenoresA > num[i]) {
				System.out.println("El número "+num[i]+" es menor que "+numMenoresA+" y se encuentra en la posición "+i);
			}
		}
		System.out.println("Inserte dos posiciones entre 0 y 29: ");
		pos1 = entrada.nextInt();
		pos2 = entrada.nextInt();
		
		//según las posiciones diremos i es par o no
		while (pos1 <= pos2) {
			if (num[pos1] % 2 ==0) {
				System.out.println("El número "+num[pos1]+" es par");
			}
			pos1++;
		}
	}

}
