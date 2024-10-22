package ejemplosCompuesto;

import java.util.Scanner;

public class Ejemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
		
		long numero;
		
		System.out.println("Introduzca un nº: ");
		
		numero = teclado.nextLong();
		
		// Si el resto del numero al dividirlo entre 2 (numero % 2) es 0 (==0), el nº es par.
		
		if(numero % 2==0 && numero>=10) {
		
		System.out.println("El numero es par y mayor de 10");
		
		}	

	}

}
