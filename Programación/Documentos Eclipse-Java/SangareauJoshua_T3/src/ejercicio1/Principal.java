package ejercicio1;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ejercicio1.Coche.Estado;

/*Autor: Joshua Sangareau Quesada
Fecha: 23 may 2024 
Descripcion: clase Principal
Incluir un estacionamiento para un vehículo si hay disponibilidad. Si no hay disponibilidad hay que indicarlo.
Exportar todos los vehículos estacionados a un documento de texto mostrando toda la información ordenados por matrícula.
Mostrar la información de los coches con estado de conservación “nuevo”.
Buscar si está estacionado un vehículo a partir de su matrícula mostrando toda la información.
Calcular el precio del estacionamiento de un vehículo a partir de su matrícula que debe existir en el sistema. El número de días se pedirá al usuario.
Eliminar un vehículo a partir de su matrícula. Se informará en el caso de que no exista la matrícula.
Calcular el número de estacionamientos de coches y motocicletas disponibles.
*/
public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in); 
		ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
		int opcionDeseada;
		String nombreArchivo = "ListaVehiculos.txt";
	
		Coche coche1 = new Coche("1a", "1", "1234", "modelo1", 0, Estado.NUEVO );
		Coche coche2 = new Coche("2a", "2", "1234", "modelo2", 500, Estado.DAÑADO );
		Coche coche3 = new Coche("3a", "3", "1234", "modelo3", 900, Estado.DAÑADO_PARCIAL );
		Coche coche4 = new Coche("4a", "4", "1234", "modelo4", 0, Estado.NUEVO );
		
		Moto moto1 = new Moto("1b", "5", "1234", "modelo5", 2, true);
		Moto moto2 = new Moto("2b", "5", "1234", "modelo6", 1, false);
		Moto moto3 = new Moto("3b", "6", "1234", "modelo7", 0, true);
		Moto moto4 = new Moto("4b", "7", "1234", "modelo8", 2, false);
		
		listaVehiculos.add(moto4);
		listaVehiculos.add(coche1);
		listaVehiculos.add(coche2);
		
		listaVehiculos.add(coche4);
		listaVehiculos.add(moto1);
		listaVehiculos.add(moto3);
		listaVehiculos.add(moto2);
		
		listaVehiculos.add(coche3);
		
		try {
			do {
				System.out.println("Elija un opcion:\n1 - Crear estacionamiento.\n2 - Exportar vehiculos"
						+ "\n3 - Mostrar los coches nuevos.\n4 - Buscar si está estacionado un vehículo a partir de su matrícula"
						+ "\n5.- Calcular el precio del estacionamiento de un vehículo a partir de su matrícula"
						+ "\n6.- Eliminar un vehículo a partir de su matrícula. Se informará en el caso de que no exista la matrícula"
						+ "\n7.- Calcular el número de estacionamientos de coches y motocicletas disponibles. \n0 - Salir del programa");
				opcionDeseada = teclado.nextInt();
				switch (opcionDeseada) {
				case (1): {
					try {
						crearEstacionamiento(teclado, listaVehiculos);
					break;
					}catch(IllegalArgumentException ex) {
						System.out.println(ex.getMessage());
					}
	
				}
				case (2): {
					Collections.sort(listaVehiculos);
					escribirNuevoArchivo(nombreArchivo, listaVehiculos);
					break;
	
				}
				case (3): {
					System.out.println("Mostrando los coches en estado nuevo:");
					System.out.println(mostrarNuevos(listaVehiculos));
					break;
					
				}
				case (4): {
					System.out.println(mostrarSiExisteVehiculo(teclado, listaVehiculos));
					break;
					
				}
				case (5): {
					System.out.println(calcularPrecio(teclado, listaVehiculos));
					break;
					
				}
				case (6): {
					System.out.println("Mostrando la información del vehiculo a eliminar: " + eliminarVehiculo(teclado, listaVehiculos));
					break;
					
				}
				case (7): {
					System.out.println("Espacios disponibles: ");
					System.out.println(mostrarEspaciosDisponibles(listaVehiculos));
					break;
					
				}
				case (0): {
					System.out.println("Se va a proceder a cerrar el programa, ¡Hasta Pronto!");
				
					break;
				}
				default: {
					System.out.println(
							"Se ha introducido una opcion incorrecta, introduzca un numero de cualquiera de las funciones");
				}
	
				}
	
			} while (opcionDeseada != 0);
		}catch(InputMismatchException ex1) {
			System.out.println("Se ha introducido una letra o caracter no valido, por favor introduzca solo números");
		}
	}
	
	//Este metodo convierte el string en un tipo enumerado de TipoPosicion
		public static Estado convertirEnum(String posicion) {
			Estado devolucion = null;
			if(posicion.equalsIgnoreCase("NUEVO")) {
				devolucion = Estado.NUEVO;
			}else if(posicion.equalsIgnoreCase("DAÑADO PARCIAL")) {
				devolucion = Estado.DAÑADO_PARCIAL;
			}else if(posicion.equalsIgnoreCase("DAÑADO")) {
				devolucion = Estado.DAÑADO;
			}
			return devolucion;
			
		}
	
	//este método muestra los coches que tengan en estado del vehiculo nuevo
	public static String mostrarNuevos(ArrayList<Vehiculo> listaVehiculos) {
		String devolucion = "";
		for(Vehiculo i:listaVehiculos) {
			if(i instanceof Coche ) {
				if(((Coche)i).getEstado() == Estado.NUEVO) {
					devolucion += i.toString() + "\n";
				}
				
			}
		}
		return devolucion;
	}
	
	//Este metodo crea un nuevo estacionamiento, solicitando la informacion necesaria para cada vehículo y filtrando si hay disponibilidad  de espacio o no
	public static void crearEstacionamiento(Scanner teclado, ArrayList<Vehiculo> listaVehiculos) {
		String matricula, dni, telefono, modelo, estadoStr;
		Estado estado;
		int km, tipo, espejos, casco;
		boolean cascoBool;
		teclado.nextLine();
		System.out.println("Introduzca matricula del vehiculo");
		matricula = teclado.nextLine();
		System.out.println("Introduzca el dni del cliente");
		dni = teclado.nextLine();
		System.out.println("Introduzca el telefono del cliente");
		telefono = teclado.nextLine();
		System.out.println("Introduzca el modelo");
		modelo = teclado.nextLine();
		
		System.out.println("Introduzca el tipo de vehiculo: 1 para coche, 2 para moto");
		tipo = teclado.nextInt();
		
		if(tipo == 1) {
			if(quedaEspacio(listaVehiculos, 1)) {
				System.out.println("Introduzca los kilometros del coche");
				km = teclado.nextInt();
				teclado.nextLine();
				System.out.println("Introduzca el estado del coche siendo posible estas opciones: NUEVO, DAÑADO PARCIAL, DAÑADO");
				estadoStr = teclado.nextLine();
				estado = convertirEnum(estadoStr);
				listaVehiculos.add(new Coche(matricula, dni, telefono, modelo, km, estado));
			}else {
				System.out.println("No queda espacio para más coches");
			}
			
		}else {
			if(quedaEspacio(listaVehiculos, 2)) {
				System.out.println("Introduzca la cantidad de espejos");
				espejos = teclado.nextInt();
				teclado.nextLine();
				System.out.println("Introduzca si contiene casco: 1 si. 2 no");
				casco = teclado.nextInt();
				if(casco == 1){
					cascoBool = true;
				}else {
					cascoBool = false;
				}
				listaVehiculos.add(new Moto(matricula, dni, telefono, modelo, espejos, cascoBool));
			}else {
				System.out.println("No queda espacio para más motos");
			}
		}
		
	}
	
	//este metodo privado será llamado por crearEstacionamiento para comprobar que hay espacio para un nuevo vehiculo coche o moto.
	//devuelve false si no hay espacio para más coches o motos
	private static boolean quedaEspacio(ArrayList<Vehiculo> listaVehiculos, int tipo) {
		boolean devolucion = true;
		int contadorMoto=0, contadorCoche=0;
		for(Vehiculo i: listaVehiculos) {
			if(i.getClass().getSimpleName().equalsIgnoreCase("Coche")) {
				contadorCoche ++;
			}else {
				contadorMoto ++;
			}
		}
		if(contadorMoto >= 25 && tipo == 2) {
			devolucion = false;
		}else if(contadorCoche >= 100 && tipo == 1) {
			devolucion = false;
		}
		return devolucion;
	}

	//Este método escribirá en el archivo especificado la informacion de los vehículos creados hasta el momento
	public static void escribirNuevoArchivo (String nombreArchivo, ArrayList<Vehiculo> listaVehiculos) {
		
		try {
			FileWriter archivoEscritura = new FileWriter(nombreArchivo);
			for(Vehiculo i: listaVehiculos) {
				if(i instanceof Coche) {
					archivoEscritura.write(i.getMatricula() + ";" + i.getDni() + ";" + i.getTelefono() + ";" + i.getModelo() + ";" + ((Coche) i).getKilometros() + ";" + ((Coche) i).getEstado() + "\n");
				}else if(i instanceof Moto) {
					archivoEscritura.write(i.getMatricula() + ";" + i.getDni() + ";" + i.getTelefono() + ";" + i.getModelo() + ";" + ((Moto) i).getEspejos() + ";" + ((Moto) i).isCasco() + "\n");
				}
			}
			archivoEscritura.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Este metodo mostrará la informacion del vehiculo buscado por su matruicula. Si no esta estacionado lo indica
	public static String mostrarSiExisteVehiculo(Scanner teclado, ArrayList<Vehiculo> listaVehiculos) {
		String devolucion = "", matricula;
		teclado.nextLine();
		System.out.println("Introduzca la matricula a buscar");
		matricula = teclado.nextLine();
		for(Vehiculo i: listaVehiculos) {
			if(i.getMatricula().equals(matricula)) {
				devolucion = i.toString() +"\nSi está estacionado el vehiculo con la matricula introducida";
			}
		}
		if(devolucion.isEmpty()) {
			devolucion = "No hay ningún vehículo estacionado con esa matrícula";
		}
		return devolucion;
		
	}
	
	//Este metodo solicita la matricula y los dias para realizar el calculo del precio del estacionamiento filtrando si es coche o moto y si está en el estacionamiento o no
	public static String calcularPrecio(Scanner teclado, ArrayList<Vehiculo> listaVehiculos) {
		String matricula;
		int dias;
		String devolucion = "";
		teclado.nextLine();
		System.out.println("Introduzca la matricula a buscar");
		matricula = teclado.nextLine();
		
		for(Vehiculo i: listaVehiculos) {
			if(i.getMatricula().equals(matricula)) {
				System.out.println("Introduzca los dias a estacionar");
				dias = teclado.nextInt();
				if(i instanceof Coche) {
					devolucion = "El coche con matricula " + matricula + " debe pagar: " + ((Coche) i).calcularPrecio(dias) + "€ por estar: " + dias + " dias.";
				}else {
					devolucion = "la moto con matricula " + matricula + " debe pagar: " + ((Moto) i).calcularPrecio(dias) + "€ por estar: " + dias + " dias.";
				}
			}
		}
		if(devolucion.isEmpty()) {
			System.out.println("No existe esta matrícula de vehiculo en el parking");
		}
		return devolucion;
	}
	
	//este metodo solicita la matricula y si existe el vehiculo en el parking lo elimina
	public static String eliminarVehiculo(Scanner teclado, ArrayList<Vehiculo> listaVehiculos) {
		String matricula;
		String devolucion = "";
		teclado.nextLine();
		System.out.println("Introduzca la matricula del vehiculo a eliminar");
		matricula = teclado.nextLine();
		boolean salir = false; 
		Iterator<Vehiculo> iterador = listaVehiculos.iterator();
		while(iterador.hasNext() && salir == false) {
			Vehiculo i = iterador.next();
			if(i.getMatricula().equals(matricula)) {
				devolucion = i.toString();
				listaVehiculos.remove(i);
				salir = true;
			}
		}
		if(devolucion.isEmpty()) {
			System.out.println("No existe esta matrícula de vehiculo en el parking");
		}
		return devolucion;
	}
	
		
	//Este método realiza el cálculo para indicar cuantos estacionamientos quedan para cada tipo de vehículo
	public static String mostrarEspaciosDisponibles(ArrayList<Vehiculo> listaVehiculos) {
		int contadorMoto=0, contadorCoche=0, espacioMoto=25, espacioCoche=100;
		String devolucion = "";
		for(Vehiculo i: listaVehiculos) {
			if(i.getClass().getSimpleName().equalsIgnoreCase("Coche")) {
				contadorCoche ++;
			}else {
				contadorMoto ++;
			}
		}
		
		devolucion = "Espacios para moto: " + (espacioMoto - contadorMoto) + " Espacio para coches: " + (espacioCoche - contadorCoche);
		return devolucion;
	}
}
