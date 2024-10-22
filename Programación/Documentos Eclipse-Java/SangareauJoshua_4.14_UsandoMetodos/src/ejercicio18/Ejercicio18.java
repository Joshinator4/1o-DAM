/*
 * . El NIF (o letra asociada a un DNI) se obtiene de la siguiente manera: Se divide el número de DNI
entre 23 y el resto es codificado por una letra según la siguiente equivalencia:
0: "T", 1: "R", 2: "W", 3: "A", 4: "G", 5: "M", 6: "Y", 7: "F", 8: "P", 9: "D",10:"X", 11: "B", 12: "N",
13: "J", 14: "Z", 15: "S", 16: "Q", 17: "V", 18: "H", 19: "L", 20: "C", 21: "K", 22: "E".
Escribe un programa que pida el DNI y muestre por pantalla la letra asociada. Para ello se
deberá crear una función a la que se le pase el número y devuelva la letra.
Ejemplo: para el DNI 56321122 el NIF es ‘X’
 */
package ejercicio18;

import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {

		// ----------------------------------------------
		// Declaración de variables
		// ----------------------------------------------

		// Constantes
		// Variables de entrada
		int dniIntroducido;
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
		
		System.out.println("Introduzca los numeros de su DNI para decirle la letra que le corresponde");
		dniIntroducido = teclado.nextInt();
		
		
		System.out.println("La letra de su DNI es: " + sacarLetraDni (dniIntroducido));
		
	}
	
	public static char sacarLetraDni (int x) {
		char letraDni = 0 ;
		int operacion;
		operacion = x%23;
		
		switch (operacion) {
			case (0):{
				letraDni = 'T';
			
				break;
			}
			case (1):{
				letraDni = 'R';
			
				break;
			}
			case (2):{
				letraDni = 'W';
			
				break;
			}
			case (3):{
				letraDni = 'A';
			
				break;
			}
			case (4):{
				letraDni = 'G';
			
				break;
			}
			case (5):{
				letraDni = 'M';
			
				break;
			}
			case (6):{
				letraDni = 'Y';
			
				break;
			}
			case (7):{
				letraDni = 'F';
			
				break;
			}
			case (8):{
				letraDni = 'P';
			
				break;
			}
			case (9):{
				letraDni = 'D';
			
				break;
			}
			case (10):{
				letraDni = 'X';
			
				break;
			}
			case (11):{
				letraDni = 'B';
			
				break;
			}
			case (12):{
				letraDni = 'N';
			
				break;
			}
			case (13):{
				letraDni = 'J';
			
				break;
			}
			case (14):{
				letraDni = 'Z';
			
				break;
			}
			case (15):{
				letraDni = 'S';
			
				break;
			}
			case (16):{
				letraDni = 'Q';
			
				break;
			}
			case (17):{
				letraDni = 'V';
			
				break;
			}
			case (18):{
				letraDni = 'H';
			
				break;
			}
			case (19):{
				letraDni = 'L';
			
				break;
			}
			case (20):{
				letraDni = 'C';
			
				break;
			}
			case (21):{
				letraDni = 'K';
			
				break;
			}
			case (22):{
				letraDni = 'E';
			
				break;
			}
			default:{
				
			}
		
		}
		return letraDni;
	}
	
}