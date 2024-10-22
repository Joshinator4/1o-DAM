package ejercicio1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import libtarea3.CuentaBancaria;
import libtarea3.Dado;

public class Ejercicio1 {

	public static void main(String[] args) {
		// ----------------------------------------------
		// Declaración de variables
		// ----------------------------------------------

		// Constantes
		// Variables de entrada
		
		LocalDate fechaCreacionErronea = LocalDate.of(2027, 12, 14);
		DateTimeFormatter fechaEspana = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaCreacionCorrecta = LocalDate.of(2021, 07, 01);
		
		String respuestaembargada;
		boolean correcto = false;
		double saldoNoValido = -200.0;
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
		
		//Realizamos el control de excepciones sabiendo que se va a crear el objeto cuentaPrivada con una fecha incorrecta
		try {
			CuentaBancaria cuentaPrivada = new CuentaBancaria(8.5, fechaCreacionErronea);
		
		} catch(IllegalArgumentException excepcion1) {
			System.out.print("Intentando crear cuenta privada con una fecha no válida.\n"+ "Error: Parámetros de creación de la cuenta inválidos. Fecha de creación no válida: ");
			System.out.print(fechaCreacionErronea.format(fechaEspana));
			//El error venia del .getMonth esto coge el nombre del mes, con .getMonthValue() no da el error poque coge el dato en forma de numero, no el nombre del mes
			System.out.printf(" fecha no valida: %d/%d/%d\n\n", fechaCreacionErronea.getDayOfMonth(), fechaCreacionErronea.getMonthValue(), fechaCreacionErronea.getYear());
		}
		
		//Realizamos el control de excepciones sabiendo que se va a crear el objeto cuentaConjunta con un saldo inicial incorrecto
		try {
			CuentaBancaria cuentaConjunta = new CuentaBancaria(saldoNoValido);
		
		}catch (IllegalArgumentException excepcion2){
			System.out.print("Intentando crear cuenta privada con un saldo no válido.\nError: Parámetros de creación de la cuenta inválidos. ");
			
			System.out.printf("Saldo inicial erróneo %.2f", saldoNoValido);
			
			
		}
		
		//Creamos el objeto deseado y imprimimos por pantalla con formato
		CuentaBancaria cuentaPrivada = new CuentaBancaria(1000.0, fechaCreacionCorrecta, -200.0);
		
		System.out.println("\n\nCreando cuenta privada válida con un constructor con tres parámetros... ");
		System.out.printf("Cuenta privada creada: Id: %d - saldo: %.2f - embargada: %b", cuentaPrivada.getId(), cuentaPrivada.getSaldo(), cuentaPrivada.isEmbargada() );
		
		//Creamos el objeto deseado y imprimimos por pantalla con formato
		CuentaBancaria cuentaConjunta = new CuentaBancaria(200.0, fechaCreacionCorrecta);
		
		System.out.println("\n\nCreando cuenta conjunta válida usando un constructor con dos parámetros...");
		System.out.printf("Cuenta conjunta creada: Id: %d - saldo: %.2f - embargada: %b", cuentaConjunta.getId(), cuentaConjunta.getSaldo(), cuentaConjunta.isEmbargada());
		
		//Creamos el objeto deseado y imprimimos por pantalla con formato
		CuentaBancaria cuentaFamiliar = new CuentaBancaria();
		
		System.out.println("\n\nCreando cuenta familiar válida usando un constructor sin parámetros...");
        System.out.printf("Cuenta familiar creada: Id: %d - saldo: %.2f - embargada: %b", cuentaFamiliar.getId(), cuentaFamiliar.getSaldo(), cuentaFamiliar.isEmbargada());
        
        //Imprimimos con fomato la prueba de los getters
        System.out.println("\n\nPrueba de los getters de la cuenta privada:");
        System.out.println("-------------------------------------------");
        System.out.printf("Id: %d\n", cuentaPrivada.getId());
        System.out.println("Fecha de creación: " +cuentaPrivada.getFechaCreacion());
        System.out.printf("Límite de descubierto: %.2f\n", cuentaPrivada.getLimiteDescubierto());
        System.out.printf("Esta embargada: %b\n", cuentaPrivada.isEmbargada());
        System.out.printf("Esta descubierta: %b\n", cuentaPrivada.isDescubierta());
        System.out.printf("Dias con la cuenta creada: %d\n\n", cuentaPrivada.getDiasCuenta() );
		
        System.out.println("Realización de operaciones sobre las cuentas");
        System.out.println("--------------------------------------------");
        System.out.println("Ingresamos 100 euros en la cuenta familiar...\n"
        		+ "Extraemos 100 euros de la cuenta conjunta...\n"
        		+ "Transferimos 1100 euros de la cuenta privada a la familiar...");
        
        //Se realiza las acciones solicitadas por el ejercicio con sus respectivos métodos.
        cuentaFamiliar.ingresar(100);
        cuentaConjunta.extraer(100);
        cuentaPrivada.transferir(1100, cuentaFamiliar);
        
      //Imprimimos con fomato los resultados finales.
        System.out.println("\nEstado final de las cuentas:"); 
        System.out.println("---------------------------");
        
        if(cuentaPrivada.isEmbargada()) {
        	respuestaembargada = "Si";
        }else {
        	respuestaembargada = "No";
        }
        System.out.printf("Estado final de Cuenta privada: Id: %d - saldo: %.2f - embargada: %s", cuentaPrivada.getId(), cuentaPrivada.getSaldo(), respuestaembargada );
        
        if(cuentaConjunta.isEmbargada()) {
        	respuestaembargada = "Si";
        }else {
        	respuestaembargada = "No";
        }
        System.out.printf("\nEstado final Cuenta conjunta: Id: %d - saldo: %.2f - embargada: %s", cuentaConjunta.getId(), cuentaConjunta.getSaldo(), respuestaembargada);
        
        if(cuentaFamiliar.isEmbargada()) {
        	respuestaembargada = "Si";
        }else {
        	respuestaembargada = "No";
        }
        System.out.printf("\nEstado final Cuenta familiar: Id: %d - saldo: %.2f - embargada: %s", cuentaFamiliar.getId(), cuentaFamiliar.getSaldo(), respuestaembargada);
        
        
	}
}