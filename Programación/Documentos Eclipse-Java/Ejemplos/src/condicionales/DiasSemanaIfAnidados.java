package condicionales;

import java.util.Scanner;

public class DiasSemanaIfAnidados {

	public static void main(String[] args) {
		// Llamamos a escaner y declaramos variables:
		
		Scanner teclado = new Scanner(System.in);
		
		byte dia;
		
		System.out.println("Introduzca el nº de día de la semana:");
		
		dia = teclado.nextByte();
		
		//realizamos lo solicitado con if anidados:
		
		if (dia < 0 || dia > 7) {
			System.out.println("Día no válido");	
		}
		
		else if (dia <6) {
			System.out.println("Es día laborable");
		}
		
		else {
			System.out.println("Es fin de semana");
		}
		
		//Realizamos misma operación con switch
		
		switch (dia) {
		case (1): case (2): case(3): case (4): case(5):{
			System.out.println("Es día laborable");
			break;
		}
		
		case(6): case(7):{
			System.out.println("Es fin de semana");
			break;
		}
		
		default: {
			System.out.println("Día no válido");
		}
		
		
		}
		
		
	}

}
