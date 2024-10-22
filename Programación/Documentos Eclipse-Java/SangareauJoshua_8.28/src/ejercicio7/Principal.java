package ejercicio7;

import java.util.ArrayList;
import java.util.Scanner;

import ejercicio6.Ingrediente;
import ejercicio6.Pedido;

public class Principal {

	public static void main(String[] args) {

		Scanner teclado = new Scanner (System.in);
		
		ArrayList <Venta> listaVentas = new ArrayList<>();
		for(int i = 1; i <= 12; i++) {
			listaVentas.add(new Venta(i, 0));
		}
		
		boolean salirPrograma = false,salirOpcion;
		int numeroIntroducido, numeroVentas, ventaAnho = 0, ventaMesA = 0, mesMasVenta, cantidadMaxima = 0;
		int [] arrayVentas = new int [12];
		String devolver;
		
		
		do {
			System.out.println("Introduzca la opcion deseada: \n1.-Introducir ventas al mes del año solicitado\n2.-Mostrar ventas introducidas en el apartado opcion 1"
					+ "\n3.-Mostrar ventas del año.\n4.-Mostrar ventas de los meses que empiezan por A.\n"
					+ "5.-Mostrar el mes con mas ventas.\n6.-Salir del programa.");
			numeroIntroducido = teclado.nextInt();
			switch(numeroIntroducido) {
				case (1):{
					salirOpcion = false;
					do {
						System.out.println("Introduzca el numero del mes o 0 si desea salir");
						numeroIntroducido = teclado.nextInt();
						if(numeroIntroducido !=0 && numeroIntroducido <= 12) {
							System.out.println("Introduzca el numero de ventas del mes seleccionado");
							numeroVentas = teclado.nextInt();
							arrayVentas[numeroIntroducido-1]= numeroVentas;
							for(Venta i: listaVentas) {
								if(i.getNumeroMes() == numeroIntroducido) {
									i.setVentasMes(numeroVentas);
								}
							}
						}else if(numeroIntroducido == 0) {
							salirOpcion = true;
						}else {
							System.out.println("El numero de mes es incorrecto.");
						}
					}while(salirOpcion == false);
					break;
					
				}case (2):{
					System.out.println("Se va a proceder a mostrar las ventas de la opcion anterior");
					for(int i= 0; i < 12; i++) {
						if(arrayVentas[i]!=0) {
							for(Venta j: listaVentas) {
								if(j.getNumeroMes() == (i+1)) {
									System.out.println(j.saberVentas());
								}
							}
							arrayVentas[i]= 0;
						}
					}
					break;
					
				}
				case (3):{
					for(Venta i: listaVentas) {
						ventaAnho += i.getVentasMes();
					}
					System.out.println("Ventas del año:" + ventaAnho);
					
				}case (4):{
					for(Venta i: listaVentas) {
						if(i.saberNombre().charAt(0) == 'A') {
							ventaMesA += i.getVentasMes();
						}
					}
					System.out.println("Las ventas de los meses que empiezan por A son: " + ventaMesA);
					break;
					
				}case (5):{
					mesMasVenta = 1;
	
					for(Venta i: listaVentas) {
						if(i.getVentasMes() > cantidadMaxima) {
							cantidadMaxima = i.getVentasMes();
							mesMasVenta = i.getNumeroMes();
						}
					}
					for(Venta i: listaVentas) {
						if(i.getNumeroMes() == mesMasVenta) {
							System.out.println("El mes con mas ventas del año es: " + i.getNombreMes() + " con " + i.getVentasMes() + " ventas");
						}
					}
					
					break;
					
				}case (6):{
					System.out.println("Se va a proceder a cerrar el programa de pedidos");
					salirPrograma = true;
					break;
					
				}default:{
					System.out.println("Opcion incorrecta. Vuelva a introducir una opcion correcta (1-4 o 0)");
					break;
				}
			}
			
		}while(salirPrograma == false);

	}

}
