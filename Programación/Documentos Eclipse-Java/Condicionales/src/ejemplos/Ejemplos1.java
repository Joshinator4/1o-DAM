package ejemplos;

import java.util.Scanner;

public class Ejemplos1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		
		byte edad;
		
		System.out.println("Introduzca su edad: ");
		
		edad = teclado.nextByte();
		
		if(edad>=18){
		
			System.out.println("Usted es mayor de edad");
		}
		
	}	
	

}
