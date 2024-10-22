/*
 * Objetivo:Clase principal del ejercicio
 * Autor: Joshua Sangareau Quesada
 * fecha: 16/04/2024
 * 
 */
package ejercicio1;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int opcionDeseada;
		Ciclista ciclistaInsertado, ciclistaBorrar, ciclistaModificar, ciclistaRuta;
		ArrayList<Ciclista> listaCiclistas = new ArrayList<>();
		ArrayList<Ruta> listaRutas = new ArrayList<>();
		
		Ciclista ciclista1 = new Ciclista("a", "nombre1", LocalDate.now(), "ModeloA");
		Ciclista ciclista2 = new Ciclista("b", "nombre2", LocalDate.now(), "ModeloB");
		Ciclista ciclista3 = new Ciclista("c", "nombre3", LocalDate.now(), "ModeloC");
		Ruta ruta1 = new Ruta("Nombre1", LocalDate.now(), 100, 60);
		Ruta ruta2 = new Ruta("Nombre2", LocalDate.now(), 20, 5);
		Ruta ruta3 = new Ruta("Nombre3", LocalDate.now(), 80, 40);
		
		listaCiclistas.add(ciclista1);
		listaCiclistas.add(ciclista2);
		listaCiclistas.add(ciclista3);
		listaRutas.add(ruta1);
		listaRutas.add(ruta2);
		listaRutas.add(ruta3);
		
		
		
		
		do {
			System.out.println("Elija un opcion:\n1.-Incluir un ciclista.\n2.-Eliminar un ciclista."
					+ "\n3.-Modificar el modelo de bicicleta de un determinado ciclista.\n4.-Añadir una ruta ciclista a un determinado ciclista.."
					+ "\n5.-Para cada uno de los ciclistas, mostrar las rutas recorridas ordenadas por kms. y y el total de kilómetros recorridos por el ciclista.\n"
					+ "6.-Añadir ruta a distintos ciclistas\n0.-Salir del programa");
			opcionDeseada = teclado.nextInt();
			switch (opcionDeseada) {
				case(1):{
					try {
						ciclistaInsertado = incluirCiclista(teclado, listaCiclistas);
						System.out.println("Mostrando el ciclista creado: " + ciclistaInsertado.toString());
						listaCiclistas.add(ciclistaInsertado);
					}catch(IllegalArgumentException excepcion1) {
						System.out.println(excepcion1.getMessage());
					}
					break;
					
				}case(2):{
					try {
						ciclistaBorrar = borrarCiclista(teclado, listaCiclistas);
						System.out.println("Se va a proceder a borrar el ciclista: " + ciclistaBorrar);
						listaCiclistas.remove(ciclistaBorrar);
					}catch(IllegalArgumentException excepcion2) {
						System.out.println(excepcion2.getMessage());
					}
					
					break;
					
				}case(3):{
					try {
						ciclistaModificar = modificarModelo(teclado, listaCiclistas);
						System.out.println("Modificando la informacion del ciclista ya modificado: \n" + ciclistaModificar.toString());
					}catch(IllegalArgumentException excepcion3) {
						System.out.println(excepcion3.getMessage());
					}
					break;
					
				}case(4):{
					try {
						ciclistaRuta = anhadirRuta(teclado, listaCiclistas);
						System.out.println("Mostrando la informacion del ciclista que se ha añadido la ruta:\n" + ciclistaRuta.toString());
					}catch(IllegalArgumentException excepcion4) {
						System.out.println(excepcion4.getMessage());
					}
					
					break;
					
				}case(5):{
					mostrarInformacion("ciclistas.txt",listaCiclistas);
					break;
					
				}case(6):{
					anhadirRutaVarios(teclado, listaCiclistas);
					System.out.println("Mostrando la información de la lista de los ciclistas con la ruta añadida:\n" + listaCiclistas.toString());
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
	
	//este método sirve para filtrar si existe un ciclista con este dni
	public static boolean comprobarDni (String dni, ArrayList<Ciclista> lista){
		boolean devolucion=true;
		for(Ciclista i: lista) {
			if(i.getDni().equals(dni)) {
				devolucion = false;
			}
		}
		return devolucion;
		
	}
	
	//este método solicita los datos de un ciclista y devuelve un ciclista para añadirlo a la lista 
	public static Ciclista incluirCiclista(Scanner teclado, ArrayList<Ciclista> lista) throws IllegalArgumentException {
		Ciclista devolucion;
		String dni, nombre, modelo;
		int dia, mes, anho;
		LocalDate fecha;
		teclado.nextLine();
		System.out.println("Introduzca el dni del ciclista");
		dni = teclado.nextLine();
		if(comprobarDni(dni, lista)) {
			System.out.println("Introduzca el nombre del ciclista");
			nombre = teclado.nextLine();
			System.out.println("Introduzca el dia de nacimineto");
			dia = teclado.nextInt();
			System.out.println("Introduzca el mes de nacimineto");
			mes = teclado.nextInt();
			System.out.println("Introduzca el año de nacimineto");
			anho = teclado.nextInt();
			fecha = LocalDate.of(anho, mes, dia);
			teclado.nextLine();
			System.out.println("Introduzca el modelo de la bicicleta");
			modelo = teclado.nextLine();
			devolucion = new Ciclista(dni, nombre, fecha, modelo);
		}else {
			throw new IllegalArgumentException("ERROR: este ciclista ya existe");
		}
		return devolucion;
		
	}
	
	//este método borrará el ciclista con dni introducido
	public static Ciclista borrarCiclista(Scanner teclado, ArrayList<Ciclista> lista) {
		Ciclista devolucion = null;
		String dni;
		teclado.nextLine();
		System.out.println("Introduzca el dni del ciclista a eliminar");
		dni = teclado.nextLine();
		if(!comprobarDni(dni, lista)) {
			for(Ciclista i: lista) {
				if(i.getDni().equals(dni)) {
					devolucion = i;
				}
			}
		}else {
			throw new IllegalArgumentException("ERROR: este ciclista no existe, no se borrará nada");
		}
		return devolucion;
	}
	
	//Este método sirve para modificar el modelo de la bici del ciclista
	public static Ciclista modificarModelo(Scanner teclado, ArrayList<Ciclista> lista) {
		Ciclista devolucion = null;
		String dni, modelo;
		teclado.nextLine();
		System.out.println("Introduzca el dni del ciclista a eliminar");
		dni = teclado.nextLine();
		if(!comprobarDni(dni, lista)) {
			for(Ciclista i: lista) {
				if(i.getDni().equals(dni)) {
					System.out.println("Introduzca el nuevo modelo");
					modelo = teclado.nextLine();
					i.setModelo(modelo);
					devolucion = i;
				}
			}
		}else {
			throw new IllegalArgumentException("ERROR: este ciclista no existe, no se modificará el modelo");
		}
		return devolucion;
	}
	
	//este método pedira una ruta y lo introducirá en el ciclistas insertado
	public static Ciclista anhadirRuta(Scanner teclado, ArrayList<Ciclista> lista) {
		Ciclista devolucion = null;
		String dni, nombreRuta;
		int dia, mes, anho, km, tiempo;
		Ruta nuevaRuta;
		LocalDate fecha;
		teclado.nextLine();
		System.out.println("Introduzca el dni del ciclista a insertar la ruta");
		dni = teclado.nextLine();
		if(!comprobarDni(dni, lista)) {
			for(Ciclista i: lista) {
				if(i.getDni().equals(dni)) {
					System.out.println("Introduzca el nombre de la ruta");
					nombreRuta = teclado.nextLine();
					System.out.println("Introduzca el dia que tuvo lugar la ruta");
					dia = teclado.nextInt();
					System.out.println("Introduzca el mes que tuvo lugar la ruta");
					mes = teclado.nextInt();
					System.out.println("Introduzca el año que tuvo lugar la ruta");
					anho = teclado.nextInt();
					fecha = LocalDate.of(anho, mes, dia);
					System.out.println("Introduzca los kilómetros de la ruta");
					km = teclado.nextInt();
					System.out.println("Introduzca el tiempo que tardó en hacerla");
					tiempo = teclado.nextInt();
					nuevaRuta = new Ruta(nombreRuta, fecha, km, tiempo);
					i.anhadirRuta(nuevaRuta);
					devolucion = i;
				}
			}
		}else {
			throw new IllegalArgumentException("ERROR: este ciclista no existe, no se añadirá ninguna ruta");
		}
		return devolucion;
	}
	//este método muestra la información de todos los ciclistas, los kilometros recorridos y las rutas ordenadas por kilómetros
	public static void mostrarInformacion(String nombreArchivo, ArrayList<Ciclista> lista) {
		String imprimir;
		for(Ciclista i: lista) {
			i.ordenarLista();
			System.out.println("Mostrando informacion del ciclista:\n " + i.toString() + "\nKilometros recorridos: " + i.calcularKilometrosRecorridos());
		}
		escribirNuevoArchivo(nombreArchivo, lista);
	}
	
	//este método escribe en un archivo los datos deseados
	public static void escribirNuevoArchivo (String nombreArchivo, ArrayList<Ciclista> lista) {
		String imprimir;
		try {
			FileWriter archivoEscritura = new FileWriter(nombreArchivo);
			for(Ciclista i: lista) {
				imprimir =  i.toString() + "\nKilometros recorridos: " + i.calcularKilometrosRecorridos() + "\n";
				archivoEscritura.write(imprimir);
			}
			archivoEscritura.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//este método pedira una ruta y lo introducirá en los ciclistas deseados
	public static void anhadirRutaVarios(Scanner teclado, ArrayList<Ciclista> lista) {
		Ciclista devolucion = null;
		String dni, nombreRuta;
		int dia, mes, anho, km, tiempo;
		Ruta nuevaRuta;
		LocalDate fecha;
		teclado.nextLine();
		System.out.println("Introduzca el nombre de la ruta");
		nombreRuta = teclado.nextLine();
		System.out.println("Introduzca el dia que tuvo lugar la ruta");
		dia = teclado.nextInt();
		System.out.println("Introduzca el mes que tuvo lugar la ruta");
		mes = teclado.nextInt();
		System.out.println("Introduzca el año que tuvo lugar la ruta");
		anho = teclado.nextInt();
		fecha = LocalDate.of(anho, mes, dia);
		System.out.println("Introduzca los kilómetros de la ruta");
		km = teclado.nextInt();
		System.out.println("Introduzca el tiempo que tardó en hacerla");
		tiempo = teclado.nextInt();
		nuevaRuta = new Ruta(nombreRuta, fecha, km, tiempo);
		teclado.nextLine();
	
		do{
			System.out.println("Introduzca el dni del ciclista a insertar la ruta si no desea insertar mas ciclistas pulse 0");
			dni = teclado.nextLine();
			for(Ciclista i: lista) {
				if(i.getDni().equals(dni)) {
					i.anhadirRuta(nuevaRuta);
				}
			}
		}while(!dni.equals("0"));
	}
}
