package cajeroAutomatico;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CajeroAutomatico {

	public static void main(String[] args) {
		int pinIntroducido, numeroIntentos = 0;
		boolean pinCorrecto;
		
		Scanner teclado = new Scanner(System.in);
		try {
			Tarjeta tarjetaJuan = new Tarjeta ("ES3812345678912345678912", 0, 1234);
			System.out.println("Hola, introduzca su tarjeta o libreta, por favor.");
			do {
				System.out.println("A continuación, introuzca su numero secreto (PIN).");
				pinIntroducido = teclado.nextInt();
				if(comprobarPinTarjeta(pinIntroducido, tarjetaJuan)) {
					pinCorrecto = true;
					numeroIntentos = 0;
				}else {
					pinCorrecto = false;
					numeroIntentos++;
					if(numeroIntentos == 3) {
						System.out.println("El PIN introducido es incorrecto, se ha intentado 3 veces fallidas. Contacte con su banco");
					}else {
						System.out.println("El PIN introducido es incorrecto, por favor vuelva a intentarlo, tiene: " + (3-numeroIntentos) + " Intentos mas");
					}
				}
			}while(pinCorrecto == false);
			
			System.out.println("");
			
		}catch(IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}catch(InputMismatchException excepcion2) {
			System.out.println(excepcion2.getMessage());
		}catch (Exception excepcion3) {
			System.out.println(excepcion3.getMessage());
		}
	}
	
	public static boolean comprobarPinTarjeta(int pin, Tarjeta tarjeta) {
		
		boolean devolucion;
		if(pin == tarjeta.getPinTarjeta()) {
			devolucion = true;
		}else {
			devolucion = false;
		}
		return devolucion;
	}
	
	public static boolean comprobarPinLibreta(int pin, Libreta libreta) {
		
		boolean devolucion;
		if(pin == libreta.getPinLibreta()) {
			devolucion = true;
		}else {
			devolucion = false;
		}
		return devolucion;
	}

}
