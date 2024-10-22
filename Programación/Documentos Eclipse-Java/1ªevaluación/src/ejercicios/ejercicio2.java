/*objetivo: crear un programa de Java que calcule los múltiplos de 5 o 9 y los que sean múltiplos de 5 indicar también si son múltiplos de 15
 						   autor: Francisco Javier Martín-Lunas Escobar
 						   fecha 21/10/2022
 */
package ejercicios;

import java.util.Scanner;

public class ejercicio2 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner entrada = new Scanner(System.in);
			int a;
			double c;
			System.out.println("Eliga etree 9 o 5 para realizar sus múltiplos entre 50 y 500");
			a = entrada.nextInt();
			if (a==5) {
				System.out.println("Es múltiplos de 5: ");
				for (int i=50; i<=500; i++) {
					if (i%5==0) {
						System.out.println(i);
					} 	 
				}
				System.out.println("Los múltiplos de 5 que son múltiplos de 15 son: ");
				for (int i=50; i<=500; i++) {
					if (i%5==0 && i%15==0) {
						System.out.println(i);
					} 
				}
			} else {
				if (a==9) {
					System.out.println("Es múltiplos de 9: ");
					for (int i=50; i<=500; i++) {
						if (i%9==0) {
							System.out.println(i);
						} 
					}
				}
			}

		}

	}