package ejercicio2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// ----------------------------------------------
		// Declaración de variables
		// ----------------------------------------------

		// Constantes
		// Variables de entrada
		byte contadorDiasIguales = 0;
		int dia = 0, mes = 0, anho = 0;
		LocalDate fechaActual = LocalDate.now();
		String nombreDia, nombreDiaComparar;
		boolean banderaMes = false, banderaAnho = false, banderaDia = false;
		// Variables de salida
		// Variables auxiliares
		// Clase Scanner para petición de datos

		Scanner teclado = new Scanner(System.in);

		// ----------------------------------------------
		// Procesamiento
		// ----------------------------------------------

		do {

			try {
				System.out.println("Introduzca su año de nacimiento");
				anho = teclado.nextInt();
				banderaAnho = true;

			} catch (InputMismatchException excepcion1) {
				System.out.println("El año Introducido no es correcto. Vuelva a introducirlo, por favor.");
				teclado.nextLine();
				System.out.println(anho);
			}
		} while ((anho < 1900 || anho > fechaActual.getYear()) || banderaAnho == false);

		LocalDate anhoPrueba = LocalDate.of(anho, 1, 1);

		do {

			try {
				System.out.println("Introduzca su mes de nacimiento");
				mes = teclado.nextInt();
				banderaMes = true;

			} catch (InputMismatchException excepcion2) {
				System.out.println("El mes Introducido no es correcto. Vuelva a introducirlo, por favor.");
				teclado.nextLine();
				System.out.println(mes);
				banderaMes = false;
			}

		} while ((mes < 1 || mes > 12) || banderaMes == false);

		do {
			try {
				System.out.println("Introduzca su dia de nacimiento");
				dia = teclado.nextInt();

				if (anhoPrueba.isLeapYear() && (dia == 29 && mes == 2)) {
					banderaDia = true;

				} else if (anhoPrueba.isLeapYear() == false && (dia == 29 && mes == 2)) {
					banderaDia = false;
					System.out.println("El año no es bisiesto, el dia del mes 2 no puede ser 29");

				} else {
					LocalDate fechaCumpleanhos = LocalDate.of(anho, mes, dia);

					switch (mes) {

					case 1, 3, 5, 7, 8, 10, 12: {
						if (dia > 0 && dia <= fechaCumpleanhos.lengthOfMonth()) {
							banderaDia = true;
						} else {
							banderaDia = false;
							System.out.println(
									"El dia introducido es incorrecto. Por favor vuelva a introducirlo de forma correcta");
						}
						break;
					}

					case 2: {
						if (dia > 0 && dia <= fechaCumpleanhos.lengthOfMonth()) {
							banderaDia = true;
						} else {
							banderaDia = false;
							System.out.println(
									"El dia introducido es incorrecto. Por favor vuelva a introducirlo de forma correcta");
						}

						break;
					}

					case 4, 6, 9, 11: {
						if (dia > 0 && dia <= fechaCumpleanhos.lengthOfMonth()) {
							banderaDia = true;
						} else {
							banderaDia = false;
							System.out.println(
									"El dia introducido es incorrecto. Por favor vuelva a introducirlo de forma correcta");
						}

						break;
					}

					}
				}

			} catch (InputMismatchException excepcion3) {
				System.out.println("Error de lectura. Vuelva a Introducir el dia de forma correcta");
				teclado.nextLine();
				banderaDia = false;
			}

		} while (banderaDia == false);

		LocalDate fechaCumpleanhos = LocalDate.of(anho, mes, dia);
		LocalDate anhoActualComprobar = LocalDate.of(1, 1, 1);
		nombreDia = fechaCumpleanhos.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.printf("El dia que naciste fue: %s", nombreDia);
		System.out.printf("\n\n¿Cuantas veces tu cumpleaños ha caido en %s?\n", nombreDia);
		System.out.println("----------------------------------------------------------");
		
		if ((fechaCumpleanhos.getDayOfMonth() == 29) && fechaCumpleanhos.getMonthValue() == 2) {
			
			anhoActualComprobar = fechaCumpleanhos.plusYears(4);
			
			do {
				
				nombreDiaComparar = anhoActualComprobar.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
				
				if (nombreDia.equalsIgnoreCase(nombreDiaComparar)) {
					contadorDiasIguales++;
					System.out.println(anhoActualComprobar.format(formatoFecha));
				}

				anhoActualComprobar = anhoActualComprobar.plusYears(4);
				
			} while (anhoActualComprobar.getYear() <= fechaActual.getYear());
			
		} else {
			
			anhoActualComprobar = fechaCumpleanhos.plusYears(1);
			
			do {
				nombreDiaComparar = anhoActualComprobar.getDayOfWeek().getDisplayName(TextStyle.FULL,
						new Locale("es", "ES"));
				if (nombreDia.equalsIgnoreCase(nombreDiaComparar)) {
					contadorDiasIguales++;
					System.out.println(anhoActualComprobar.format(formatoFecha));
				}

				anhoActualComprobar = anhoActualComprobar.plusYears(1);
				
			} while (anhoActualComprobar.getYear() <= fechaActual.getYear());
		}

		System.out.printf("Número total de coincidencias: %d", contadorDiasIguales);
	}
}