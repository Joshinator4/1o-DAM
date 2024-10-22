package Ejercicio1;

import java.util.Scanner;

/*objetivo: crear un programa que realice los ieguiente: 
 * 1 iniciar un sistema al usuario que muestre 4 opciones, si el valor dado por el usuario es distinto a las opciones diremos que es incorrecto 
 * 2 pedir 4 números
 * 3 la opción 1 hara una suma de los números
 * 4 la opción 2 multiplicara los números 
 * 5 la opción 4 calculara la media de los números
 * 6 la opción 4 claculará el mayor entre los números usando una función en la cual solo se le pueda pasar 2 parámetros
 * autor: Francisco Javier Maartín-Lunas Escobar
 * fecha: 29/11/2022*/
public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}
	public static void menu () {
		Scanner entrada = new Scanner(System.in);
		int menu, num1, num2, num3, num4, mayor1, mayor2;
			System.out.println("Eliga una de las 4 opciones para calcular: [1 Suma] [2 Multiplicar] [3 Media] [4 Mayor]");
			menu = entrada.nextInt();
			if (menu <= 0 || menu >= 5) {
				System.out.println("El valor introducido es erroneo.");
			}
			switch (menu) {
				case 1:
				{
					num1 = numero();
					num2 = numero();
					num3 = numero();
					num4 = numero();
					suma (num1, num2, num3, num4);
					break;
				}
				case 2:
				{
					num1 = numero();
					num2 = numero();
					num3 = numero();
					num4 = numero();
					mult (num1, num2, num3, num4);
					break;

				}
				case 3:
				{
					num1 = numero();
					num2 = numero();
					num3 = numero();
					num4 = numero();
					media (num1, num2, num3, num4);
					break;

				}
				case 4:
				{
					num1 = numero();
					num2 = numero();
					num3 = numero();
					num4 = numero();
					mayor1 = mayor (num1, num2); 
					mayor2 = mayor (num3, num4); 
					System.out.println("El mayor de los 4 números es: "+mayor (mayor1, mayor2));
					break;

				}
			}
		
	}
	//esta función pide el número
	public static int numero () {
		Scanner entrada = new Scanner(System.in);
		int numero;
		System.out.println("Inserte un número: ");
		numero = entrada.nextInt();
		return numero;
	}
	//esta función calcula la suma
	public static void suma (int num1, int num2, int num3, int num4) {
		int suma;
		suma = num1 + num2 + num3 + num4;
		System.out.println("La suma de los números es: "+suma);

	}
	//esta función calcula la multiplicación
	public static void mult (int num1, int num2, int num3, int num4) {
		int mult;
		mult = num1 * num2 * num3 * num4;
		System.out.println("La multiplicación de los números es: "+mult);

	}
	//esta función calcula la media
	public static void media (int num1, int num2, int num3, int num4) {
		int media;
		media = (num1 + num2 + num3 + num4) / 4;
		System.out.println("La media de los números es: "+media);
	}
	//esta función calcula el mayor
	public static int mayor (int num1, int num2) {
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}
}
