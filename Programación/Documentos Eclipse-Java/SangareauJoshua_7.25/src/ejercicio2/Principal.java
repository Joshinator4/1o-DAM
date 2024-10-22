package ejercicio2;

import java.util.Scanner;

public class Principal{

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String nombreIntroducido, nombreMascota;
		int opcionDeseada, opcionDeseadaCrear;
		
		try {
			Perro perro1 = new Perro();
			Gato gato1 = new Gato();
			Loro loro1 = new Loro();
			Canario canario1 = new Canario();
			Inventario inventarioMascotas = new Inventario();
			inventarioMascotas.insertarMascota(perro1);
			inventarioMascotas.insertarMascota(gato1);
			inventarioMascotas.insertarMascota(loro1);
			inventarioMascotas.insertarMascota(canario1);
			do {
				System.out.println("Elija un opcion:\n1.-Mostrar Lista(tipo y nombre).\n2.-Mostrar los datos de una Mascota a partir de su nombre."
						+ "\n3.-Mostrar todos los datos de todos los animales.\n4.-Insertar animales en el inventario.\n5.-Eliminar animales del inventario."
						+ "\n6.-Vaciar el inventario.\n0.-Salir del programa");
				opcionDeseada = teclado.nextInt();
				switch (opcionDeseada) {
				case(1):{
					System.out.println(inventarioMascotas.mostrarLista());
					break;
					
				}case(2):{
					teclado.nextLine();
					System.out.println("Introduzca el nombre de la mascota");
					nombreIntroducido = teclado.nextLine().toLowerCase();
					System.out.println(inventarioMascotas.mostrarDatosMascota(nombreIntroducido));
					break;
					
				}case(3):{
					System.out.println(inventarioMascotas.mostrarTodosDatosMascotas());
					break;
					
				}case(4):{
					System.out.println("Elija que Mascota nueva desea guardar: 1.-Perro 2.-Gato 3.-Loro 4.-Canario");
					opcionDeseadaCrear = teclado.nextInt();
					teclado.nextLine();
					System.out.println("Introduzca el nombre de la Mascota a crear");
					nombreMascota = teclado.nextLine().toLowerCase();
					if(opcionDeseadaCrear == 1) {
						inventarioMascotas.insertarMascota(new Perro(nombreMascota));
					}else if(opcionDeseadaCrear == 2) {
						inventarioMascotas.insertarMascota(new Gato(nombreMascota));
					}else if(opcionDeseadaCrear == 3) {
						inventarioMascotas.insertarMascota(new Loro(nombreMascota));
					}else if(opcionDeseadaCrear == 4) {
						inventarioMascotas.insertarMascota(new Canario(nombreMascota));
					}
					break;
					
				}case(5):{
					teclado.nextLine();
					System.out.println("Introduzca el nombre de la mascota a eliminar");
					nombreIntroducido = teclado.nextLine().toLowerCase();
					inventarioMascotas.eliminarMascota(nombreIntroducido);
					break;
					
				}case(6):{
					System.out.println("Se va a proceder a vaciar el inventario");
					inventarioMascotas.vaciarMascota();
					break;
					
				}case(0):{
					System.out.println("Se va a proceder a cerrar el programa, ¡Hasta Pronto!");
					break;
				}default:{
					System.out.println("Se ha introducido una opcion incorrecta, introduzca un numero de cualquiera de las funciones");
				}
				
				
				}
					
				
			}while(opcionDeseada != 0);
			

		} catch (IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		} catch(IllegalStateException excepcion2) {
			System.out.println(excepcion2.getMessage());
		}catch(Exception excepcion3) {
			System.out.println(excepcion3.getMessage());
		}
		
		
	}
}
