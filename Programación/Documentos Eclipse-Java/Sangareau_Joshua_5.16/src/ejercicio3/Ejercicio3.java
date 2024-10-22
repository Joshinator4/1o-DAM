package ejercicio3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int horaIntroducida = 25,minutosIntroducidos = 61;
		String salida = null;
		
		LocalTime horaInicio = LocalTime.of(8, 00);
	    LocalTime horaFinal = LocalTime.of(14, 00);
	    
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    //Generamos un bucle do-while con dentro un bloque try-catch para captar y tratar las posibles excepciones generadas.
	    //el bucle controla que las horas introducidas sean dentro del rango solicitado y el try-catch las excepciones generadas por meter
	    //otro tipo de valor que no sea un int
	    do {
	    	try {
	    		System.out.println("Introduzca la hora de 0-23h");
	    		horaIntroducida = teclado.nextInt();
	    			    		
	    	} catch(InputMismatchException excepcion1) {
	    		System.out.println("Hora errónea vuelva a introducirla con los parámetros solicitados");
	    	}
	    	//Limpiar el teclado para que no se haga el bucle infinito
	    	teclado.nextLine();
	    	
	    } while(horaIntroducida < 0 || horaIntroducida > 23);
	    
	    //Generamos un bucle do-while con dentro un bloque try-catch para captar y tratar las posibles excepciones generadas.
	    //el bucle controla que los minutos introducidos sean dentro del rango solicitado y el try-catch las excepciones generadas por meter
	    //otro tipo de valor que no sea un int
	    do {
	    	try {
	    		System.out.println("Introduzca los minutos de 0-59");
	    		minutosIntroducidos = teclado.nextInt();
	    		
	    	} catch(InputMismatchException excepcion1) {
	    		System.out.println("Minutos erróneos vuelva a introducirla con los parámetros solicitados");
	    		
	    	}
	    	//Limpiar el teclado para que no se haga el bucle infinito
	    	teclado.nextLine();
	    } while(minutosIntroducidos < 0 || minutosIntroducidos > 59);
	
	    //generamos aquí el bojeto horaValida con las horas y minutos pedidos anteriormente al usuario
	    LocalTime horaValida = LocalTime.of(horaIntroducida, minutosIntroducidos);
	    DateTimeFormatter formatoHora =  DateTimeFormatter.ofPattern("HH:mm");
	    
	    //Imprimimos con formato ya generado la hora introducida por el usuario
	    System.out.printf("Hora introducida " + horaValida.format(formatoHora) + "\n");
	    
	    //Generamos un bloque de condicionales para generar un String con la información que solicita el ejercicio.
	    //Se usan los métodos de la clase LocalTime para realizar las condiciones
	    if(horaValida.isBefore(horaInicio)) {
	    	salida = ("Aún no ha comenzado la jornada. Faltan "+ horaValida.until(horaInicio, ChronoUnit.MINUTES) + " minutos para comenzar");
	    }else if (horaValida.isAfter(horaInicio.minusMinutes(1)) && horaValida.isBefore(horaInicio.plusHours(2))){
	    	salida = "Clase correspondiente: Programación";
	    	
	    }else if(horaValida.isAfter(horaInicio.plusHours(2).minusMinutes(1)) && horaValida.isBefore(horaInicio.plusHours(4))) {
	    	salida = "Clase correspondiente: Sistemas Informáticos";
	    
	    }else if (horaValida.isAfter(horaInicio.plusHours(4).minusMinutes(1)) && horaValida.isBefore(horaInicio.plusHours(6))) {
	    	salida = "Clase correspondiente: Entornos de Desarrollo";
	    	
	    } else {
	    	salida = ("Clase correspondiente: La jornada ya ha finalizado. Han pasado " + horaFinal.until(horaValida, ChronoUnit.MINUTES) + " minutos desde el fin. ");
	    	
	    }
	    
	    System.out.printf("%s", salida);
	    
	    
	}

}
