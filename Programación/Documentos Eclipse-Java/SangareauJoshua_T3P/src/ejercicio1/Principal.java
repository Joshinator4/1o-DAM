/*
 * Objetivo:Clase principal del ejercicio
 * Autor: Joshua Sangareau Quesada
 * fecha: 25/04/2024
 * 
 */
package ejercicio1;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		ArrayList<Servicio> listaServicios = new ArrayList<>();
		int opcionDeseada;
		LocalDate fechaFicticia = LocalDate.now();
		
		RevisionAlarma alarma1 = new RevisionAlarma(fechaFicticia, "vcliente1", 3, "modelo1");
		RevisionAlarma alarma2  = new RevisionAlarma(fechaFicticia, "cliente2", 6, "modelo2");
		RevisionAlarma alarma3  = new RevisionAlarma(fechaFicticia, "cliente3", 9, "modelo3");
		Pintura pintura1 = new Pintura("Pepito", fechaFicticia, "cliente4", 100, 10.3);
		Pintura pintura2 = new Pintura("Juanito", fechaFicticia, "cliente5", 150, 9);
		Pintura pintura3 = new Pintura("Antonio", fechaFicticia, "cliente6", 40, 12.5);
		
		listaServicios.add(alarma1);
		listaServicios.add(alarma2);
		listaServicios.add(alarma3);
		listaServicios.add(pintura1);
		listaServicios.add(pintura2);
		listaServicios.add(pintura3);
		
		
		do {
			System.out.println("Elija un opcion:\n1.-Almacenar un servicio de pintura.\n2.-Almacenar un servicio de revisión de alarma."
					+ "\n3.-Mostrar los servicios realizados un determinado día.\n4.-Mostrar todos servicios de pintura con importe total inferior a una cantidad solicitada al usuario."
					+ "\n5.-Eliminar un servicio.\n"
					+ "6.-Exportar todos los servicios del sistema ordenados por cliente y fecha al fichero\n0.-Salir del programa");
			opcionDeseada = teclado.nextInt();
			switch (opcionDeseada) {
				case(1):{
					Servicio servicio = incluirPintura(teclado);
					System.out.println("Mostrando si se ha añadido el servicio: " +  listaServicios.add(servicio));	
					if(servicio != null) {
						System.out.println("Mostrando la información del servicio almacenada: " + servicio.toString());
					}
			
					break;
					
				}case(2):{
					Servicio servicio = incluirRevisionAlarma(teclado);
					System.out.println("Mostrando si se ha añadido el servicio: " +  listaServicios.add(servicio));	
					System.out.println("Mostrando la información del servicio almacenada: " + servicio.toString());
					
					break;
					
				}case(3):{
					System.out.println("Mostrando la informacion de los servicios realizados en la fecha solicitada: \n" + buscarPorDia(teclado, listaServicios).toString());
					break;
				}case(4):{
					System.out.println("Mostrando la informacion de los servicios de pintura con importe inferior al solicitado a continuación: \n" + buscarPintura(teclado, listaServicios).toString());
					break;
				}case(5):{
					Servicio servicioEliminar = eliminarServicio(teclado, listaServicios);
					System.out.println("Mostrando la informacion del servicio a eliminar: " + servicioEliminar.toString());
					listaServicios.remove(servicioEliminar);
					break;
				}case(6):{
					Collections.sort(listaServicios);
					System.out.println("Se va a proceder a escribir la informacion en el fichero servicios.txt ordenados por cliente");
					escribirNuevoArchivo(listaServicios);
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
	
	//este método escribira la informacion del arraylist pasado por parámetro en un archivo 
	public static void escribirNuevoArchivo (ArrayList<Servicio> lista) {
		
		try {
			FileWriter archivoEscritura = new FileWriter("servicios.txt");
			for(Servicio i: lista) {
					archivoEscritura.write(i.toString());
			}
			archivoEscritura.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
}
	
	//este método eliminará un servicio de la lista segun el identificador añadido por el usuario
	public static Servicio eliminarServicio(Scanner teclado, ArrayList<Servicio> lista) {
		Servicio devolucion = null;
		String identificador;
		teclado.nextLine();
		System.out.println("Introduzca el identificador del servicio a eliminar");
		identificador = teclado.nextLine();
		for(Servicio i: lista) {
			if(i.getIdentificador().equals(identificador)) {
				devolucion = i;
			}
		}
		return devolucion;
	}
	
	//Este método pide la información al usuario, crea el objetoy devuelve un objeto pintura para añadirlo a la lista
	public static Pintura incluirPintura(Scanner teclado) throws IllegalArgumentException{
		Pintura devolucion = null;
		String  trabajador, cliente;
		int dia, mes, anho, superficie;
		double precioPint;
		LocalDate fecha;
		teclado.nextLine();
		System.out.println("Introduzca el nombre del trabajador");
		trabajador = teclado.nextLine();
		
			System.out.println("Introduzca el nombre del cliente");
			cliente = teclado.nextLine();
			System.out.println("Introduzca el dia del servicio");
			dia = teclado.nextInt();
			System.out.println("Introduzca el mes del servicio");
			mes = teclado.nextInt();
			System.out.println("Introduzca el año del servicio");
			anho = teclado.nextInt();
			fecha = LocalDate.of(anho, mes, dia);
			System.out.println("Introduzca la superficie");
			superficie = teclado.nextInt();
			System.out.println("Introduzca el precio de la pintura");
			precioPint = teclado.nextDouble();
			try{
				devolucion = new Pintura(trabajador, fecha, cliente, superficie, precioPint);
			}catch(IllegalArgumentException excepcion1) {
				System.out.println(excepcion1.getMessage());
				System.out.println("No se creará el servicio");
			}
		
		return devolucion;
		
	}
	//Este método pide la información al usuario, crea el objeto y devuelve un objeto RevisionAlarma para añadirlo a la lista
	public static RevisionAlarma incluirRevisionAlarma(Scanner teclado) {
		RevisionAlarma devolucion;
		String  cliente, modelo;
		int dia, mes, anho, sensores;
		LocalDate fecha;
		teclado.nextLine();
			System.out.println("Introduzca el nombre del cliente");
			cliente = teclado.nextLine();
			System.out.println("Introduzca el dia del servicio");
			dia = teclado.nextInt();
			System.out.println("Introduzca el mes del servicio");
			mes = teclado.nextInt();
			System.out.println("Introduzca el año del servicio");
			anho = teclado.nextInt();
			fecha = LocalDate.of(anho, mes, dia);
			teclado.nextLine();
			System.out.println("Introduzca el modelo");
			modelo = teclado.nextLine();
			System.out.println("Introduzca la cantidad de sensores");
			sensores = teclado.nextInt();
			devolucion = new RevisionAlarma(fecha, cliente, sensores, modelo);
		
		return devolucion;
		
	}
	
	//Este método busca por la fecha introducida por el usuario y devuelve una lista con los servicio que coincidan con la fecha
	public static ArrayList<Servicio> buscarPorDia(Scanner teclado, ArrayList<Servicio> lista) {
		ArrayList<Servicio> devolucion = new ArrayList<Servicio>();
		LocalDate fecha;
		int dia, mes, anho;
		teclado.nextLine();
		System.out.println("Introduzca el dia del servicio");
		dia = teclado.nextInt();
		System.out.println("Introduzca el mes del servicio");
		mes = teclado.nextInt();
		System.out.println("Introduzca el año del servicio");
		anho = teclado.nextInt();
		fecha = LocalDate.of(anho, mes, dia);
		for(Servicio i: lista) {
			if(i.getFecha_servicio().equals(fecha)){
				devolucion.add(i);
			}
		}
		return devolucion;
		
	}
	//Este método busca por el importe introducido por el usuario y devuelve una lista con los servicio  de  pintura que sean menores que el importe introducido por el usuario
	public static ArrayList<Servicio> buscarPintura(Scanner teclado, ArrayList<Servicio> lista) {
		ArrayList<Servicio> devolucion = new ArrayList<>();
		double importe=0;
		teclado.nextLine();
		System.out.println("Introduzca el importe total");
		importe = teclado.nextDouble();
		for(Servicio i: lista) {
			if(((i.getManoObra() + i.getMaterial()) < importe) && !i.getTrabajador().equals("Manuel Fernández")){
				devolucion.add(i);
			}
		}
		return devolucion;
		
	}
	
	

}
