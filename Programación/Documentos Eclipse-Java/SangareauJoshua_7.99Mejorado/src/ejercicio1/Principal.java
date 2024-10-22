/*
 * Objetivo:Clase Principal del ejercicio guimnasio, esta clase llamara a los metodos
 * Autor: Joshua Sangareau Quesada
 * fecha: 21/03/2024
 * 
 */

package ejercicio1;
/*
import java.util.HashSet;
import java.util.Scanner;

import ejercicio1.Socio.TipoCliente;

public class Principal {
	
	public static void main(String[] args) {
		
	Scanner teclado = new Scanner(System.in);
	
	HashSet<Socio> listaSocios = new HashSet<>();
	HashSet<Curso> listaCursos = new HashSet<>();
	
	int opcionDeseada, numeroIntroducido, adultoAsociado, maxAlumnos, codigoCurso;
	String nombreIntroducido, dniIntroducido, descripcionIntroducido;
	double precio;
	
	
	do {
		System.out.println("Elija un opcion:\n1.-Añadir socio.\n2.-Añadir curso."
				+ "\n3.-Matricular socio en curso\n4.-Mostrar informacion de los socios"
				+ "\n0.-Salir del programa");
		opcionDeseada = teclado.nextInt();
		switch (opcionDeseada) {
		case(1):{
			System.out.println("Introduzca 1 para normal, 2 para jubilado o 3 para infantil");
			numeroIntroducido = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Introduzca el nombre");
			nombreIntroducido = teclado.nextLine();
			System.out.println("Introduzca el dni");
			dniIntroducido = teclado.nextLine();
			try {
				if(numeroIntroducido == 1) {
					anhadirSocio(nombreIntroducido, dniIntroducido,TipoCliente.NORMAL, listaSocios);
				}else if(numeroIntroducido == 2) {
					anhadirSocio(nombreIntroducido, dniIntroducido,TipoCliente.JUBILADO, listaSocios);
				}else if(numeroIntroducido == 3) {
					System.out.println("Introduzca el adulto al que está asociado, si no esta asociado introduzca 0");
					adultoAsociado = teclado.nextInt();
					anhadirSocioInfantil(nombreIntroducido, dniIntroducido, TipoCliente.INFANTIL, adultoAsociado, listaSocios);
				}else {
					System.out.println("El numero introducido es incorrecto");
				}
			}catch(IllegalArgumentException excepcion1) {
				System.out.println(excepcion1.getMessage());
			}
			break;
			
		}case(2):{
			teclado.nextLine();
			System.out.println("Introduzca el nombre del curso");
			nombreIntroducido = teclado.nextLine();
			System.out.println("Introduzca la descripcion del curso");
			descripcionIntroducido = teclado.nextLine();
			System.out.println("Introduzca el precio");
			precio = teclado.nextDouble();
			System.out.println("Introduzca el numero maximo de alumnos");
			maxAlumnos = teclado.nextInt();
			try {
				anhadirCurso(nombreIntroducido, descripcionIntroducido, precio, maxAlumnos, listaCursos);
			}catch(IllegalArgumentException excepcion2) {
				System.out.println(excepcion2.getMessage());
			}
			
			break;
			
		}case(3):{
			teclado.nextLine();
			System.out.println("Introduzca el dni del socio");
			dniIntroducido = teclado.nextLine();
			System.out.println("Introduzca el codigo del curso");
			codigoCurso = teclado.nextInt();
			try {
				matricularSocio(dniIntroducido, codigoCurso, listaSocios, listaCursos);
			}catch(IllegalArgumentException excepcion2) {
				System.out.println(excepcion2.getMessage());
			}
			
			break;
			
		}case(4):{
			System.out.println("Mostrando la informacion de los Socios: \n " + informeSocios(listaSocios));
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
	
	
	//este metodo crea y añade un socio a la lista de socios
	public static void anhadirSocio(String nombre, String dni, TipoCliente tipo, HashSet<Socio> lista) throws IllegalArgumentException{
		boolean sePuede=true;
		for(Socio i: lista) {
			if(i.getDni().equals(dni)) {
				sePuede = false;
			}
		}
		if(sePuede == true) {
			lista.add(new Socio(nombre, dni, tipo));
		}else {
			throw new IllegalArgumentException("Este dni ya existe no se creará el socio");
		}
	}	
	
	//este metodo crea y añade un socio infantil a la lista de socios
	public static void anhadirSocioInfantil(String nombre, String dni,TipoCliente tipo, int codigoAdulto, HashSet<Socio> lista) throws IllegalArgumentException{
		boolean sePuedeDni=true, sePuedeAdulto=false;
		for(Socio i: lista) {
			if(i.getDni().equals(dni)) {
				sePuedeDni = false;
			}
			if(i.getCodigoCliente() == codigoAdulto) {
				sePuedeAdulto = true;
			}
		}
		if(codigoAdulto==0) {
			sePuedeAdulto=true;
		}
		if(sePuedeDni == true) {
			if(sePuedeAdulto==true) {
				lista.add(new SocioInfantil(nombre, dni, tipo, codigoAdulto));
			}else {
				throw new IllegalArgumentException("Este codigo de socio no existe no se creará al socio infantil");
			}
			
		}else {
			throw new IllegalArgumentException("Este dni ya existe no se creará el socio");
		}
	}	
	
	//este metodo añade y crea un curso a la lista de cursoss
	public static void anhadirCurso(String nombre, String descripcion, double precio, int maxAlumnos, HashSet<Curso> lista) throws IllegalArgumentException{
		boolean sePuede=true;
		for(Curso i: lista) {
			if(i.getNombre().equalsIgnoreCase(nombre)) {
				sePuede = false;
			}
		}
		if(sePuede == true) {
			lista.add(new Curso(nombre, descripcion, precio, maxAlumnos));
		}else {
			throw new IllegalArgumentException("El nombre del curso ya existe. no se crerá");
		}
	}
	
	//Este metodo matricula a un socio en un curso, guardará en ambas clases la iformacion pertinente
	public static void matricularSocio(String dni, int codigoCurso, HashSet<Socio> listaSocio, HashSet<Curso> listaCurso) throws IllegalArgumentException{
		boolean sePuedeCurso=false, sePuedeDni =false, sePuedeCantidad = false;
		for(Socio i: listaSocio) {
			if(i.getDni().equalsIgnoreCase(dni)) {
				sePuedeDni = true;
			}
		}
		for(Curso i: listaCurso) {
			if(i.getCodigoCurso() == codigoCurso) {
				sePuedeCurso = true;
				if(i.getContadorAlumnos()+1 <= i.getMaxAlumnos()) {
					sePuedeCantidad = true;
				}
			}
		}
		if(sePuedeCurso == true && sePuedeDni == true && sePuedeCantidad == true) {
			for(Curso i: listaCurso) {
				if(i.getCodigoCurso() == codigoCurso) {
					i.matricularAlumno(dni);
					for(Socio j: listaSocio) {
						if(j.getDni().equalsIgnoreCase(dni)) {
							j.matricularEnCurso(i);
						}
					}
				}
				
			}
			
		}else if(sePuedeCurso == false || sePuedeDni == false) {
			throw new IllegalArgumentException("El codigo del curso o el dni del socio no existen");
		}
		else if(sePuedeCantidad == false) {
			throw new IllegalArgumentException("No se pueden matricular mas socios, numero maximo alcanzado");
		}
	}
	
	//Este metodo muestra los datos de los socios
	public static String informeSocios(HashSet<Socio> listaSocio) {
		String devolucion= "Este es listado de socios:";
		
		for(Socio i: listaSocio) {
			i.calcularCuota();
			devolucion+= "\n" + i.toString();
		}
		return devolucion;
	}
	
}
*/