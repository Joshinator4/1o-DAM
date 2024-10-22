package ejercicio1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		ArrayList<Sancion> listaSanciones = new ArrayList<>();
		Sancion sancionCreada;
		
		int opcionDeseada;
		
		LocalDateTime fechaFicticia = LocalDateTime.of(2024, 4, 1, 0, 0);
		
		SancionAlcohol sancion1 = new SancionAlcohol("a",fechaFicticia, "lugar desconocido", 0.7);
		SancionAparcamiento sancion2 = new SancionAparcamiento("b",fechaFicticia, "lugar desconocido", true);
		SancionVelocidad sancion3 = new SancionVelocidad("c",fechaFicticia, "lugar desconocido", 100, 105);
		listaSanciones.add(sancion1);
		listaSanciones.add(sancion2);
		listaSanciones.add(sancion3);
		
		//Bucle que ejecuta el programa
		do {
			System.out.println("Elija un opcion:\n1.-Insertar una sanción.\n2.-Buscar las sanciones a partir de una matrícula."
					+ "\n3.-Mostrar todas las sanciones."
					+ "\n0.-Salir del programa");
			opcionDeseada = teclado.nextInt();
			switch (opcionDeseada) {
				case(1):{
					sancionCreada = pedirSancion(teclado);
					listaSanciones.add(sancionCreada);	
					System.out.println(mostrarSancion(sancionCreada));
					break;
					
				}case(2):{
					System.out.println(buscarSancion(teclado, listaSanciones));
					break;
					
				}case(3):{
					Collections.sort(listaSanciones);
					System.out.println(listaSanciones.toString());		
					break;
					
				}case(0):{
					System.out.println("Se va a proceder a cerrar el programa, ¡Hasta Pronto!");
					break;
				}default:{
					System.out.println("Se ha introducido una opcion incorrecta, introduzca un numero de cualquiera de las funciones");
				}

			}
				
		}while(opcionDeseada != 0);
	}
	
	//Este metodo pedirá todos los datos para crear la sanción
	public static Sancion pedirSancion(Scanner teclado) {
		Sancion devolucion = null;
		String matricula, lugar;
		int dia, mes, anho, tipo, saberGrua, velocidadMax, velocidadAct;
		LocalDateTime fecha;
		boolean grua = false;
		double tasa;
		teclado.nextLine();
		System.out.println("Introduzca los datos de la sancion:");
		System.out.println("Introduzca la matricula:");
		matricula = teclado.nextLine();
		System.out.println("Introduzca el lugar de la infraccion");
		lugar = teclado.nextLine();
		System.out.println("Introduzca el dia");
		dia = teclado.nextInt();
		System.out.println("Introduzca el mes");
		mes = teclado.nextInt();
		System.out.println("Introduzca el año");
		anho = teclado.nextInt();
		fecha = LocalDateTime.of(anho, mes, dia, 00, 00);
		System.out.println("Introduzca 1 para sancion de aparcamiento, 2 para sancion de velocidad, 3 para sancion de alcoholemia");
		tipo = teclado.nextInt();
		if(tipo == 1) {
			System.out.println("¿Se lo llevo la grua? 1.-si, 2.-no");
			saberGrua = teclado.nextInt();
			if(saberGrua == 1){
				grua = true;
			}else if(saberGrua == 2){
				grua = false;
			}else {}
			devolucion = new SancionAparcamiento(matricula, fecha, lugar, grua);
		}else if(tipo == 2) {
			System.out.println("Introduzca la velocidad maxima");
			velocidadMax = teclado.nextInt();
			System.out.println("Introduzca la velocidad de la infraccóon");
			velocidadAct = teclado.nextInt();
			devolucion = new SancionVelocidad(matricula, fecha, lugar, velocidadMax, velocidadAct);
		}else if(tipo == 3) {
			System.out.println("Introduzca la tasa de alcoholemia");
			tasa = teclado.nextDouble();
			devolucion = new SancionAlcohol(matricula, fecha, lugar, tasa);
		}
		mostrarSancion(devolucion);
		return devolucion;
		
	}
	
	//Este metodo muesta la sancion pasada por parámetro, solo se usara en el metodo pedirSancion
	public static String mostrarSancion(Sancion sancion) {
		return sancion.toString();
	}
	
	//Este metodo pide la matricula al usuario, solo se usará en el método buscarSancion
	public static String predirMatricula(Scanner teclado) {
		String devolucion;
		System.out.println("Introduzca la matricula para buscar las posibles sanciones");
		devolucion = teclado.nextLine();
		return devolucion;
		
	}
	
	//Este metodo busca sanciones en la lista por la matricula
	public static String buscarSancion(Scanner teclado, ArrayList<Sancion> listaSanciones) {
		String  devolucion = "", matricula;
		boolean tieneSanciones = false;
		teclado.nextLine();
		matricula = predirMatricula(teclado);
		for(Sancion i: listaSanciones) {
			if(i.getMatricula().equals(matricula)) {
				devolucion += i.toString() + "\n";
				tieneSanciones = true;
			}
		}
		if(tieneSanciones == false) {
			devolucion = "No tiene sanciones esta matricula";
		}
		
		return devolucion;
		
	}

}
