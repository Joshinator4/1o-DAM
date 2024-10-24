/*Autor: Joshua Sangareau Quesada
Fecha: 20 may 2024 
Descripcion: clase Principal
*/
package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ejercicio1.SocioBaloncesto.TipoPosicion;

public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		ArrayList<Socio> listaSocios = new ArrayList<Socio>();
		File archivoSocioFutbol = new File("SociosFutbol.txt");
		File archivoSocioBaloncesto = new File("SociosBaloncesto.txt");
		File archivoPartidosFutbol = new File("PartidosFutbol.txt");
		File archivoPartidosBaloncesto = new File("PartidosBaloncesto.txt");
		File archivoCuotas = new File("CuotasSocios.txt");
		
		int opcionDeseada;
		do {
			System.out.println("Elija un opcion:\n1 - Crear socios.\n2 - Insertar la participación de los socios"
					+ "\n3 - Mostrar los socios que practican fútbol ordenados por nombre y las actuaciones realizadas ordenadas por fecha."
					+ "\n4 - Mostrar los socios que practican baloncesto ordenados por nombre y las actuaciones realizadas ordenadas por fecha."
					+ "\n5 - Mostrar la información del socio que ha marcado más goles.\n6 - Mostrar la información del socio que más puntos ha conseguido."
					+ "\n7 - Mostrar el dni y nombre de los socios que no han participado en ninguna competición"
					+ "\n8 - Exportar los datos de los socios con las cuotas a un archivo\n0 - Salir del programa");
			opcionDeseada = teclado.nextInt();
			switch (opcionDeseada) {
			case (1): {
				listaSocios.addAll(lectorSocios(archivoSocioFutbol, 1));
				listaSocios.addAll(lectorSocios(archivoSocioBaloncesto, 2));
				break;

			}
			case (2): {
				lectorPartidos(listaSocios, archivoPartidosFutbol, 1);
				lectorPartidos(listaSocios, archivoPartidosBaloncesto, 2);
				break;
				
			}
			case (3): {
				System.out.println(mostrarSocios(listaSocios, "SocioFutbol")); 
				break;

			}
			case (4): {
				System.out.println(mostrarSocios(listaSocios, "SocioBaloncesto")); 				
				break;

			}
			case (5): {
				System.out.println(mostrarMayorGoleador(listaSocios));
				break;

			}
			case (6): {
				System.out.println(mostrarMayorEncestador(listaSocios));
				break;

			}
			case (7): {
				System.out.println(mostrarNoParticipantes(listaSocios));
				break;

			}case (8): {
				System.out.println("Escribiendo los datos de las cuotas en documento llamado CuotasSocios.txt");
				escribirSocios(listaSocios, archivoCuotas);
				break;

			}
			case (0): {
				System.out.println("Se va a proceder a salir del programa");
				break;
			}
			default: {
				System.out.println(
						"Se ha introducido una opcion incorrecta, introduzca un numero de cualquiera de las funciones");
			}

			}

		} while (opcionDeseada != 0);

	}
	
	//Este metodo convierte el string en un tipo enumerado de TipoPosicion
	public static TipoPosicion convertirEnum(String posicion) {
		TipoPosicion devolucion = null;
		if(posicion.equalsIgnoreCase("BASE")) {
			devolucion = TipoPosicion.BASE;
		}else if(posicion.equalsIgnoreCase("ESCOLTA")) {
			devolucion = TipoPosicion.ESCOLTA;
		}else if(posicion.equalsIgnoreCase("ALERO")) {
			devolucion = TipoPosicion.ALERO;
		}else if(posicion.equalsIgnoreCase("PIVOT")) {
			devolucion = TipoPosicion.PIVOT;
		}
		return devolucion;
		
	}
	
	//este método escribe la informacion de los socios en un archivo. Recibe la lista de los socios y el archivo en el que escribirá
	public static void escribirSocios(ArrayList<Socio> listaSocios, File archivo) {
		try {
			FileWriter archivoEscritura = new FileWriter(archivo);
			for(Socio i: listaSocios) {
				if(i instanceof SocioFutbol) {
					archivoEscritura.write(i.getDni()+ ";" + i.getNombre() +";" + i.getTelefono() + ";" + ((SocioFutbol)i).getNombreEquipo() + ";" + i.calcularCuota()+ "\n");
				}else {
					archivoEscritura.write(i.getDni()+ ";" + i.getNombre() +";" + i.getTelefono() + ";" + ((SocioBaloncesto)i).getPosicion() + ";" + i.calcularCuota() + "\n");
				}
				
			}
			archivoEscritura.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	//Metodo que realiza la lectura del archivo para crear los socios de un tipo u otro (futbol o baloncesto)
	//el parametro tipo se uiliza para saber si es SocioFutbol o SocioBaloncesto para llamar a un constructor u otro
	public static ArrayList<Socio> lectorSocios(File archivo, int tipo) {
		ArrayList<Socio> lista = new ArrayList<Socio>();
		try {
			Scanner lector = new Scanner (archivo);
			SocioBaloncesto.TipoPosicion posicion;
			while(lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] lineaSeparada = linea.split(";"); 
				if(filtrarDni(lista, lineaSeparada[1])) {
					if(tipo == 1) {
						SocioFutbol socio = new SocioFutbol(lineaSeparada[0], lineaSeparada[1], lineaSeparada[2], lineaSeparada[3]);
						lista.add(socio);
						
					}else {
						posicion = convertirEnum(lineaSeparada[3]);
						SocioBaloncesto socio1 = new SocioBaloncesto(lineaSeparada[0], lineaSeparada[1], lineaSeparada[2], posicion);
						lista.add(socio1);
						
					}
						
				}else {
					System.out.println("Dni: " + lineaSeparada[1] + " ya existe. no se añadirá el socio");
				}				
		
			}
			lector.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	//este metodo realiza la lectura de los partidos y los añade a sus respectivos socios
	public static void lectorPartidos(ArrayList<Socio> listaSocios, File archivo, int tipo) {
		try {
			Scanner lector = new Scanner (archivo);
			while(lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] lineaSeparada = linea.split(";"); 
				int posicionEnLaLista = filtrarIdentificador(listaSocios, Integer.parseInt(lineaSeparada[0]));
				if(posicionEnLaLista >= 0 && tipo == 1) {
					PartidoFutbol partido = new PartidoFutbol(LocalDate.parse(lineaSeparada[1]), Integer.parseInt(lineaSeparada[2]), Integer.parseInt(lineaSeparada[3]), Integer.parseInt(lineaSeparada[4]));
					listaSocios.get(posicionEnLaLista).agregarListaPartidos(partido);
					
				}else if(filtrarIdentificador(listaSocios, Integer.parseInt(lineaSeparada[0])) >= 0 && tipo == 2){
					PartidoBaloncesto partido1 = new PartidoBaloncesto(LocalDate.parse(lineaSeparada[1]), Integer.parseInt(lineaSeparada[2]), Integer.parseInt(lineaSeparada[3]), Integer.parseInt(lineaSeparada[4]), Integer.parseInt(lineaSeparada[5]));
					listaSocios.get(posicionEnLaLista).agregarListaPartidos(partido1);
		
				}else {
					System.out.println("El Identificador de socio " + lineaSeparada[0] +" no existe, no se añadirá ningun partido");
				}
			}
			lector.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//este método filtra si existe el dni en la lista de socios para no permitir crear 2 socios con el mismo dni
	public static boolean filtrarDni(ArrayList<Socio> lista, String dni) {
		boolean devolucion = true;
		Socio socio;
		Iterator<Socio> iterador = lista.iterator();
		while(iterador.hasNext() && devolucion == true) {
			socio = iterador.next();
			if(socio.getDni().equals(dni)) {
				devolucion = false;
			}
		}
		return devolucion;
		
	}
	
	//este método filtra los identificadores de los socios para no dejar crear partidos con un identificador que no existe
	public static int filtrarIdentificador(ArrayList<Socio> lista, int identificador) {
		int devolucion = -1;
		for(Socio i: lista) {
			if(i.getIdentificador() == identificador) {
				devolucion = lista.indexOf(i);
			}
		}
		return devolucion;
		
	}
	
	//Este método recorre la lista y muestra la informacion del socio segun el tipo introducido en el parametro tipoSocio
	public static String mostrarSocios(ArrayList<Socio> lista, String tipoSocio) {
		String devolucion="";
		for(Socio i: lista) {
			if(i.getClass().getSimpleName().equals(tipoSocio)) {
				devolucion += i.toString();
			}
		}
		return devolucion;
	}
	
	//este metodo recorre la lista para quedarse con el maximo goleador. Recorre los partidos de cada jugador para sumar sus goles
	public static String mostrarMayorGoleador(ArrayList<Socio> lista) {
		String devolucion = "";
		int golesMax = 0, goleador = 0;
		for(Socio i: lista) {
			if(i instanceof SocioFutbol) {
				if(((SocioFutbol) i).calcularGoles() > golesMax) {
					golesMax = ((SocioFutbol) i).calcularGoles();
					goleador = lista.indexOf(i);
				}
			}
		}
		devolucion = lista.get(goleador).toString() + "cantidad goles total: " + golesMax;
		
		return devolucion;
	}
	
	//este metodo recorre la lista para quedarse con el maximo anotador. Recorre los partidos de cada jugador para sumar sus puntuaciones
	public static String mostrarMayorEncestador(ArrayList<Socio> lista) {
		String devolucion = "";
		int puntosMax = 0, anotador = 0;
		for(Socio i: lista) {
			if(i instanceof SocioBaloncesto) {
				if(((SocioBaloncesto) i).calcularPuntos() > puntosMax) {
					puntosMax = ((SocioBaloncesto) i).calcularPuntos();
					anotador = lista.indexOf(i);
				}
			}
		}
		devolucion = lista.get(anotador).toString() + "cantidad puntos totales anotados: " + puntosMax;
		
		return devolucion;
	}
	public static String mostrarNoParticipantes(ArrayList<Socio> lista) {
		String devolucion = "";
		for(Socio i: lista) {
			if(i.comprobarSiHajugado()) {
				devolucion += "Dni: " + i.getDni() + " nombre: " + i.getNombre() + " ||";
			}
			
		}
		devolucion += ".\nNo han participado en ninguna competición";
		return devolucion;
	}

}
