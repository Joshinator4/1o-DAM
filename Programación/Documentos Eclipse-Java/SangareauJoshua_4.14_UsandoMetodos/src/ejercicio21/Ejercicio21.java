/*
 * 21. Escribe un programa que muestre un menú con 2 opciones: “1.Circunferencia” y “2.Área”.
En ambas se le pedirá al usuario que introduzca un radio y luego se le mostrará el cálculo
oportuno. Implementa las funciones:
int menu() // Muestra el menú y devuelve el número elegido
double pideRadio() // Pide que se introduzca el radio y lo devuelve
double circunferencia(double r) // Calcula la circunferencia y la devuelve
double area(double r) // Calcula el área y la devuelve
Modifica el programa añadiendo otra opción llamada “Volumen”, permitiendo que el usuario
también pueda solicitar el cálculo del volumen. Añade la función:
double volumen(double r) // Calcula el volumen y lo devuelve
Modifica el programa añadiendo otra opción llamada “Todas” en la que se pida el radio una sola vez
y se muestren los tres cálculos posibles (circunferencia, área y volumen).
Modifica el programa anterior de modo que el proceso se repita una y otra vez (mostrar menú ->
realizar el cálculo -> volver a mostrar menú). Añade una opción más llamada “Salir” que terminará
el programa si es elegida.

 */
package ejercicio21;

import java.util.Scanner;

public class Ejercicio21 {

	public static void main(String[] args) {
		// ----------------------------------------------
		// Declaración de variables
		// ----------------------------------------------

		// Constantes
		// Variables de entrada
		int menu;
		double radio = 0;
		boolean salir = false;
		// Variables de salida
		// Variables auxiliares
		// Clase Scanner para petición de datos

		Scanner teclado = new Scanner(System.in);

		// ----------------------------------------------
		// Entrada de datos
		// ----------------------------------------------

		// ----------------------------------------------
		// Procesamiento
		// ----------------------------------------------

		do {
			menu = menu();
			radio = pideRadio();
			switch (menu) {
				

				case 1: {
					System.out.println("La circunferencia del círculo es: " + circunferencia(radio));
					
					break;
				} 
				case 2: {
					System.out.println("El área del círculo es: " + area(radio));
					
					break;

				}
				case 3: {
					System.out.println("El volumen del círculo es: " + volumen(radio));
					
					break;
				} 
				case 4: {
					System.out.println("El área es: " + area(radio));
					System.out.println("La circunferencia es: " + circunferencia(radio));
					System.out.println("El volumen es: " + volumen(radio));
					
					break;
				}
				default:{
					System.out.println("La opción introducida es incorrecta");
					break;
				}
			}
		
		} while (menu == 5);

	}

	// Muestra el menú y devuelve el número elegido
	public static int menu() {
		Scanner teclado = new Scanner(System.in);
		int numeroIntroducido;
		do {
			System.out.println(
					"Introduczca 1 para hallar la Circunferencia. 2 para hallar la Área. 3 para hallar el el volumen. 4 para todas las funciones juntas. 5 Salir del programa");
			numeroIntroducido = teclado.nextInt();
			if (numeroIntroducido < 0 || numeroIntroducido > 5) {
				System.out.println("La opción introducida es incorrecta.");
			}
		} while (numeroIntroducido < 0 || numeroIntroducido > 5);
		return numeroIntroducido;
	}

	// Pide que se introduzca el radio y lo devuelve
	public static double pideRadio() {
		Scanner teclado = new Scanner(System.in);
		double radioIntroducido;
		System.out.println("Introduczca el radio.");
		radioIntroducido = teclado.nextDouble();
		return radioIntroducido;
	}

	// Calcula la circunferencia y la devuelve (diametro * PI)
	public static double circunferencia(double r) {
		double circunferencia;
		circunferencia = (r * 2) * Math.PI;
		return circunferencia;
	}

	// Calcula el área y la devuelve
	public static double area(double r) {
		double area;
		area = Math.PI * Math.pow(r, 2);
		return area;
	}

	// Calcula el volumen y lo devuelve
	public static double volumen(double r) {
		double volumen;
		volumen = (double) 4 / 3 * Math.PI * Math.pow(r, 3);
		return volumen;
	}


	
}