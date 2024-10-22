package ejercicio7;

import java.util.Scanner;

public class PlayamarBank {

	public static void main(String[] args) {
		
		double cantidadIngreso, cantidadRetirada;
		boolean banderaPrograma = true, banderaConstructor = false;
		int opcionDeseada;
		String cuentaBancaria, titular;

		Scanner teclado = new Scanner(System.in);
		/*
		 * 1. Datos de la cuenta. Mostrará el IBAN, el titular y el saldo. 2. IBAN.
		 * Mostrará el IBAN. 3. Titular. Mostrará el titular. 4. Saldo. Mostrará el
		 * saldo disponible. 5. Ingreso. Pedirá la cantidad a ingresar y realizará el
		 * ingreso si es posible. 6. Retirada. Pedirá la cantidad a retirar y realizará
		 * la retirada si es posible. 7. Movimientos. Mostrará una lista con el
		 * historial de movimientos. 8. Salir. Termina el programa.
		 */
		do {
			try {
				System.out.println("Introduzca una cuenta bancaria valida");
				cuentaBancaria = teclado.nextLine();
				System.out.println("Introduzca el nombre y apellido del titular");
				titular = teclado.nextLine();
				
				CuentaBancaria playamarAhorro = new CuentaBancaria(cuentaBancaria, titular);
				banderaConstructor = true;
				do {
					try {
					
						System.out.println("\n1. Datos de la cuenta. \n2. IBAN. \n3. Titular. \n4. Saldo. \n5. Ingreso. \n6. Retirada. \n7. Movimientos. \n8. Salir.\nIntroduzca la opcion deseada:");
						opcionDeseada = teclado.nextInt();
						switch (opcionDeseada) {
						case 1: {
							System.out.printf("Sus datos son: IBAN: %s, titular: %s, Saldo: %.2f \n", playamarAhorro.getCuentaBancaria(),playamarAhorro.getTitular(), playamarAhorro.getSaldo());
							break;
						}
						case 2: {
							System.out.printf("Su IBAN es: %s \n", playamarAhorro.getCuentaBancaria());
							break;
						}
						case 3: {
							System.out.printf("El titular es: %s \n",playamarAhorro.getTitular());
							break;
						}
						case 4: {
							System.out.printf("Su saldo es: %.2f \n", playamarAhorro.getSaldo());
							break;
						}
						case 5:{
							System.out.println("Introduzca la cantidad a ingresar: ");
							cantidadIngreso = teclado.nextDouble();
							playamarAhorro.ingreso(cantidadIngreso);
							break;
						}
						case 6:{
							System.out.println("Introduzca la cantidad a retirar: ");
							cantidadRetirada = teclado.nextDouble();
							playamarAhorro.retirada(cantidadRetirada);
							break;
						}
						case 7:{
							System.out.println(playamarAhorro.consultaMovimientos());
							break;
						}
						case 8 :{
							System.out.println("Gracias por usar nuestros servicios ¡Hasta pronto!");
							banderaPrograma = false;
							break;
						}
						default:
							System.out.println("Numero introducido incorrecto, por favor introduzca un numero dentro del rango del programa");
							break;
						}
					
					}catch (IllegalArgumentException excepcion3) {
						System.out.println(excepcion3.getMessage());
					}catch(CuentaException excepcion4) {
						System.out.println(excepcion4);
						excepcion4.printStackTrace();
					}catch(AvisarHaciendaException excepcion5) {
						System.out.println(excepcion5);
						excepcion5.printStackTrace();
					}catch (Exception excepcion6) {
						System.out.println(excepcion6.getMessage());
					}
				} while (banderaPrograma == true);
				
			} catch (IllegalArgumentException excepcion1) {
				System.out.println(excepcion1.getMessage());
			} catch (Exception excepcion2) {
				System.out.println(excepcion2.getMessage());
			}
			
				
		}while(banderaConstructor == false);
	
	}

}
