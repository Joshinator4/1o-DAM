package ejercicio1;

import java.util.Scanner;

import ejercicio1.VehiculoTransporte.TipoVehiculoTransporte;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		InventarioVehiculos inventario = new InventarioVehiculos();
		
		boolean salirPrograma = false;
		int numeroIntroducido, asientosIntroducidos, cargaIntroducida, numDias, vehiculoIntroducido;
		String matriculaIntroducida;
		
		do {
			System.out.println("Introduzca la opcion deseada: \n1.-Creacion de vehiculo\n2.-Saber precio de alquiler introduciendo los dias y la matricula\n3.-Saber precio de alquiler de toda la flota introduciendo los dias");
			numeroIntroducido = teclado.nextInt();
			teclado.nextLine();
			switch (numeroIntroducido) {
			case(1):{
				System.out.println("Introduzca: \n1.-Para crear un coche \n2.-para crear minibus \n3.-para crear camion \n4.- para crear furgoneta ");
				vehiculoIntroducido = teclado.nextInt();
				teclado.nextLine();
				System.out.println("Introduzca la matricula en formato AAAA111");
				matriculaIntroducida = teclado.next();
				try {
					if(vehiculoIntroducido == 1) {
						System.out.println("Introduzca cantidad de asientos del coche");
						asientosIntroducidos = teclado.nextInt();
						inventario.crearVehiculoTransporte(matriculaIntroducida, asientosIntroducidos, vehiculoIntroducido);
					}else if(vehiculoIntroducido == 2) {
						System.out.println("Introduzca cantidad de asientos del minibus");
						asientosIntroducidos = teclado.nextInt();
						inventario.crearVehiculoTransporte(matriculaIntroducida, asientosIntroducidos, vehiculoIntroducido);
					}else if(vehiculoIntroducido == 3) {
						System.out.println("Introduzca la tara maxima del camion");
						cargaIntroducida = teclado.nextInt();
						inventario.crearVehiculoCarga(matriculaIntroducida, cargaIntroducida, vehiculoIntroducido);
					}else if(vehiculoIntroducido == 4) {
						System.out.println("Introduzca la tara maxima de la furgoneta");
						cargaIntroducida = teclado.nextInt();
						inventario.crearVehiculoCarga(matriculaIntroducida, cargaIntroducida, vehiculoIntroducido);
					}else {
						System.out.println("Opcion incorrecta introduzca un numero del 1 al 4");
					}
				}catch(IllegalArgumentException excepcion1) {
						System.out.println(excepcion1.getMessage());
				}	
				break;
				
			}case(2):{
				System.out.println("Introduzca la matricula en formato AAAA111");
				matriculaIntroducida = teclado.nextLine();
				System.out.println("Introduzca la cantidad de dias a alquilar");
				numDias = teclado.nextInt();
				System.out.println(inventario.obtenerPrecioAlquiler(matriculaIntroducida, numDias)); 
				break;
				
			}case(3):{
				System.out.println("Introduzca la cantidad de dias a alquilar");
				numDias = teclado.nextInt();
				System.out.println("Este son los precios de todos los vehiculos: " + inventario.mostrarTodosLosPrecios(numDias));
				break;
				
			}case(0):{
				System.out.println("Se va a proceder a cerrar el programa, ¡Hasta Pronto!");
				salirPrograma = true;
				break;
				
			}default:{
				System.out.println("Se ha introducido una opcion incorrecta, introduzca un numero de cualquiera de las funciones");
				break;
				
			}
			
			
			}
		}while(salirPrograma == false);

	}

}
