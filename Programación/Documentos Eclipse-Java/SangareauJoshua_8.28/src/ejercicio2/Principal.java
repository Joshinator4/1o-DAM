package ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		LocalDate cumpleIntroducido;
		String nombreIntroducido;
		int numeroIntroducido, anho, mes, dia, numeroIntroducido2;
		boolean bandera = true;
		
		Agenda agenda1 = new Agenda();
		Contacto contacto1 = new Contacto("Joshua", "calle de mentira 2", "915784742", "joshua@email.com", LocalDate.of(1992, 8, 22));
		Contacto contacto2 = new Contacto("Rafa", "calle alegria 3", "935284745", "rafa@email.com", LocalDate.of(1992, 3, 8));
		Contacto contacto3 = new Contacto("Richard", "calle de verdad 5", "952857893", "richard@email.com", LocalDate.of(1998, 2, 1));
		Contacto contacto4 = new Contacto("Fede", "calle Argentina 8", "+20 78523695", "fede@email.com", LocalDate.of(2002, 6, 30));
		
		System.out.println("Bienvenido a su agenda\n");
				
		do {
			
			System.out.println("Introduzca el numero deseado para ejecutar las opciones: \n1.- Ingresar datos (nuevo contacto)");
			System.out.println("2.- Consultar Contacto por nombre.\n3.- Mostrar los datos de los contactos ordenados por nombre");
			System.out.println("4.- Dar fecha para saber que contacto cumplen años en esa fecha\n0.- Salir.");
			numeroIntroducido = teclado.nextInt();
			teclado.nextLine();
			switch(numeroIntroducido) {
			
				case (1):{
					System.out.println("Introduzca la opcion deseada:\n1.-Ingresar contacto por defecto.\n2.-Ingresar Contacto ya creado");
					numeroIntroducido2 = teclado.nextInt();
					switch(numeroIntroducido2) {
						case (1):{
							teclado.nextLine();
							agenda1.ingresarDatos();
							break;
						}case (2):{
							System.out.println("Introduzca la opcion deseada:\n1.-contacto1\n2.-contacto2\n3.-contacto3\n4.-contacto4");
							numeroIntroducido = teclado.nextInt();
							switch(numeroIntroducido) {
								case (1):{
									agenda1.ingresarDatos(contacto1);
									break;
								}case (2):{
									agenda1.ingresarDatos(contacto2);
									break;
								}case (3):{
									agenda1.ingresarDatos(contacto3);
									break;
								}case (4):{
									agenda1.ingresarDatos(contacto4);
									break;
								}default:{
									System.out.println("Numero incorecto introduzca un numero del 0 al 4");
									break;
								}	
							}
						}
					}
					break;
				}case(2):{
					System.out.println("Introduzca el nombre del contacto");
					nombreIntroducido = teclado.nextLine();
					System.out.println(agenda1.consultaDatosPorNombre(nombreIntroducido));
					break;
					
				}case(3):{
					System.out.println(agenda1.mostrarDatosOrdenados());
					break;
					
				}case(4):{
					System.out.println("Introduzca el año");
					anho = teclado.nextInt();
					System.out.println("Introduzca el mes");
					mes = teclado.nextInt();
					System.out.println("Introduzca el dia");
					dia = teclado.nextInt();
					cumpleIntroducido = LocalDate.of(anho, mes, dia);
					System.out.println(agenda1.mostrarContactosporCumpleaños(cumpleIntroducido));
					break;
					
				}case(0):{
					System.out.println("Se va a proceder a salir del programa, ¡Hasta pronto!");
					bandera = false;
					break;
					
				}default:{
					System.out.println("Numero incorecto introduzca un numero del 1 al 4");
					break;
					
				}
			}
		}while(bandera == true);
		
	}
	
}
