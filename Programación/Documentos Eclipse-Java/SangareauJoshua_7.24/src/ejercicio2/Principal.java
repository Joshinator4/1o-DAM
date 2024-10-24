package ejercicio2;

import java.time.LocalDate;
import java.util.Scanner;

import ejercicio2.Deportivo.Traccion;

public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		LocalDate fecha = LocalDate.now();
		
		try {
			
			Coche choche1 = new Coche ("5567DTL", "Joshua", fecha, 1800, 105);
			
		}catch(IllegalArgumentException exception1) {
			System.out.println(exception1.getMessage());
		}
		
		try {
			System.out.println("Intentando crear coche2:");
			Coche choche2 = new Coche ("556DTL", "Joshua", fecha, 1800, 105);
			
		}catch(IllegalArgumentException exception2) {
			System.out.println(exception2.getMessage());
		}
		
		try {
			System.out.println("Intentando crear coche3:");
			Coche choche2 = new Coche ("5567DTL", "", fecha, 1800, 105);
			
		}catch(IllegalArgumentException exception3) {
			System.out.println(exception3.getMessage());
		}
		
		try {
			System.out.println("Intentando crear coche4:");
			Coche choche2 = new Coche ("5567DTL", "Joshua", fecha, 0, 105);
			
		}catch(IllegalArgumentException exception4) {
			System.out.println(exception4.getMessage());
		}
		
		try {
			System.out.println("Intentando crear coche4:");
			Coche choche2 = new Coche ("5567DTL", "Joshua", fecha, 1900, 0);
			
		}catch(IllegalArgumentException exception5) {
			System.out.println(exception5.getMessage());
		}
		
		try{
			Deportivo deportivo1 = obtenerDeportivo();
			System.out.println(deportivo1.toString());
		}catch(IllegalArgumentException excepcion6) {
			System.out.println(excepcion6.getMessage());
		}catch(IllegalAccessError excepcion7) {
			System.out.println(excepcion7.getMessage());
		}

	}
	
	public static  Deportivo obtenerDeportivo() {
		Scanner teclado = new Scanner (System.in);
		System.out.println("Introduzca la matrícula del deportivo:");
		String matricula = teclado.nextLine();
		System.out.println("Introduzca el nombre del propietario del deportivo:");
		String nombre = teclado.nextLine();
		System.out.println("Introduzca el año de matriculación del deportivo:");
		int anho = teclado.nextInt();
		System.out.println("Introduzca el mes de matriculación del deportivo:");
		int mes = teclado.nextInt();
		System.out.println("Introduzca el dia de matriculación del deportivo:");
		int dia = teclado.nextInt();
		LocalDate fecha = LocalDate.of(anho, mes, dia);
		System.out.println("Introduzca la cilindrada del deportivo");
		int cilindrada = teclado.nextInt();
		System.out.println("Introduzca la potencia del deportivo");
		int potencia = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduzca la traccion del vehiculo");
		String traccion = teclado.nextLine();
		
		Deportivo deportivoMetodo = new Deportivo (matricula, nombre, fecha, cilindrada, potencia, traccion);
		return deportivoMetodo;
	}

}
