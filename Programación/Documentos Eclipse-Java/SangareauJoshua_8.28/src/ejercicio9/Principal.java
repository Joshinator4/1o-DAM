package ejercicio9;

import java.util.Collections;
import java.util.Scanner;

import ejercicio8.ComparadorTemperaturas;
import ejercicio8.DiaTemperatura;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		Cliente cliente1 = new Cliente("Joshua", "Joshua@gmail.com");
		
		
		boolean salirPrograma = false;
		int numeroIntroducido;
		String stringIntroducido;
		cliente1.addTelefono("679437876");
		cliente1.addTelefono("679897875");
		cliente1.addTelefono("660505826");
		cliente1.addTelefono("660528796");
		cliente1.addTelefono("687452578");
		cliente1.addTelefono("625874586");
		cliente1.addCompra("camiseta",4);
		cliente1.addCompra("pantalon",5);
		cliente1.addCompra("zapatilla",8);
		
		do {
			System.out.println("Introduzca el numero de opcion a realizar\n1.-añadir telefono\n2.-Introducir un indice para mostrar el telefono\n"
					+ "3.-Buscar telefono.\n4.-añadir compra.\n5.-eliminar producto por nombre\n6.-ver productos ordenados\n"
					+ "7.-ver total unidades que se han comprado\n0.-Salir del programa");
			numeroIntroducido = teclado.nextInt();
			switch(numeroIntroducido) {
				case (1):{
					teclado.nextLine()
;					System.out.println("Introduzca el nuemro de telefono a añadir");
					stringIntroducido = teclado.nextLine();
					try {
						cliente1.addTelefono(stringIntroducido);
					}catch(IllegalArgumentException excepcion1){
						System.out.println(excepcion1.getMessage());
					}
					
					break;
					
				}case (2):{
					
					System.out.println("Introduzca el indice del telefono a mostrar");
					numeroIntroducido = teclado.nextInt();
					try {
						System.out.println(cliente1.getTelefono(numeroIntroducido));
					}catch(IndexOutOfBoundsException excepcion2) {
						System.out.println("No existe telefono con ese indice");
					}	
					break;
				
				}case(3):{
					teclado.nextLine();
					System.out.println("Introduzca el telefono que desea buscar");
					stringIntroducido = teclado.nextLine();
					System.out.println(cliente1.buscarTelefono(stringIntroducido));
					break;
					
				}case(4):{
					teclado.nextLine();
					System.out.println("Introduzca el nombre del producto comprado");
					stringIntroducido = teclado.nextLine();
					System.out.println("Introduzca la cantidad comprada");
					numeroIntroducido = teclado.nextInt();
					cliente1.addCompra(stringIntroducido, numeroIntroducido);
					break;
					
				}case(5):{
					teclado.nextLine();
					System.out.println("Introduzca el nombre del producto a eliminar");
					stringIntroducido = teclado.nextLine();
					cliente1.eliminarProducto(stringIntroducido);
					break;
					
				}case(6):{
					System.out.println(cliente1.verProductos().toString());
					break;
					
				}case(7):{
					System.out.println("Total de unidades compradas: " + cliente1.totalUnidades());
					break;
					
				}case(0):{
					System.out.println("Se va a proceder a salir del programa, ¡Hasta pronto!");
					salirPrograma = false;
					break;
					
				}default:{
					System.out.println("Numero incorecto introduzca un numero del 1 al 4 o 0");
					break;
				}
				
				}
		
	
		
		}while(salirPrograma == false);
		
		
	}

}
