/*
 * /*
 * Objetivo:
 * Autor: Joshua Sangareau Quesada
 * fecha: 25/01/2024
 */
 
package ejercicio1;

import java.time.LocalDate;

import libtarea3.CuentaBancaria;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		//apartado2
		CuentaBancaria cuenta1;
		CuentaBancaria cuenta2;
		CuentaBancaria cuenta3;
		CuentaBancaria cuenta4;
		CuentaBancaria cuenta5;
		//este objeto esta siendo creado para poder reaizar el apartado 6
		CuentaBancaria cuenta6 = new CuentaBancaria ();
		
		LocalDate fechaCreacion = LocalDate.of(1700, 1, 1);
		
		//apartado3
		//se genera bloque try-catch para que reciba la excepcion del constructor
		try {
			cuenta1 = new CuentaBancaria (saldoAleatorio(), LocalDate.now(), 50);
			System.out.println(cuenta1.toString() + "la fecha es: " + cuenta1.getFechaCreacion() + " el limite de descubierto es: " + cuenta1.getLimiteDescubierto());			
			
		}catch(IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}
	
		//apartado4
		//se genera bloque try-catch para que reciba la excepcion del constructor
		try {
			cuenta2 = new CuentaBancaria (50, fechaCreacion);
			System.out.println("Mostrando resultados de la cuenta 2 : " +cuenta2.toString());
		}catch(IllegalArgumentException excepcion2) {
			System.out.println(excepcion2.getMessage());
		}
		
		//apartado5
		//se genera bloque try-catch por si recibe alguna excpcion al usar los metodos o el constructor
		try {
			cuenta3 = new CuentaBancaria ();
			System.out.printf("\nMostrando resultados de la cuenta 3 %s: ", cuenta3.toString());
		//apartado7
			cuenta3.ingresar(saldoAleatorio());
			System.out.printf("\nMostrando resultados de la cuenta 3 tras ingreasar saldoAleatorio(): %s", cuenta3.toString());
		//apartado8
			cuenta4 = cuenta3;
			System.out.println("\nMostrando resultados de la cuenta 4 :  %s" + cuenta4.toString());
		//apartado9
			cuenta4.embargar(50);
			System.out.printf("\nMostrando resultados de la cuenta 4 tras embargar el 50%%:  %s", cuenta4.toString());
		//apartado10
			cuenta5 = cuenta3;
			System.out.printf("\nMostrando resultados de la cuenta 5 : %s", cuenta5.toString());
		//apartado11
			cuenta5.extraer(saldoAleatorio());
			System.out.printf("\nMostrando resultados de la cuenta 5 al extraer un valor generado por saldoAleatorio(): %s", cuenta5.toString());
		//apartado12
			System.out.printf("\nMostrando resultados de la cuenta3: %s, \ncuenta 4: %s, \ncuenta 5: %s.",cuenta3.toString(),cuenta4.toString(),cuenta5.toString());
		//apartado13
			System.out.printf("\nMostrando resultados de los saldos de las cuentas 3, 4 y 5(son las que se han podido crear): %.2f, %.2f, %.2f y el numero de cuentas embargadas es: %d", cuenta3.getSaldo(), cuenta4.getSaldo(), cuenta5.getSaldo(), CuentaBancaria.getNumCuentasEmbargadas());
		}catch(IllegalArgumentException excepcion3) {
			System.out.println(excepcion3.getMessage());
		}
		
		//apartado6
		//se genera bloque try-catch por si genera excepcion el método
		try{
			cuenta6.ingresar(saldoAleatorio());
			System.out.println("Mostrando resultados de la cuenta 6 : " + cuenta6.toString());
		
		}catch(IllegalArgumentException excepcion4) {
			System.out.println(excepcion4.getMessage());
		}
		
	}
	
	//apartado1
	public static double saldoAleatorio() {
		double devolucion;
		devolucion = 30;
		return devolucion;
	}

}
