package ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		ArrayList <Ingrediente> listaIngredientes = new ArrayList <>();
		ArrayList <Pedido> listaPedidoCocina = new ArrayList <>();
		
		int numeroIntroducido, codigoIntroducido;
		boolean salirPrograma = false, salirPedido;
		
		for(int i = 20; i < 70; i++) {
			Integer numero = (i-19);
			String nombre = "Ingrediente" + Integer.toString(numero);
			listaIngredientes.add(new Ingrediente(nombre, i+5, i-15));
		}
		
		do {
			System.out.println("Introduzca la opcion deseada: \n1.-Nuevo pedido\n2.-Pedido por defecto\n3.-Listado de ingredientes a pedir."
					+ "\n4.-Mostrar pedido introduciendo codigo de pedido.\n5.-Mostrar ingrediente.\n0.-Salir del programa.");
			numeroIntroducido = teclado.nextInt();
			switch(numeroIntroducido) {
				case (1):{
					listaPedidoCocina.add(nuevoPedido(listaIngredientes));		
					break;
					
				}case (2):{
					System.out.println("Realizando pedido por defecto");
					listaPedidoCocina.add(nuevoPedidoPorDefecto(listaIngredientes));
					break;
					
				}
				case (3):{
					System.out.println(mostrarIngredientesAPedir(listaIngredientes)); 
					break;
					
				}case (4):{
					System.out.println("Introduzca codigo de pedido para mostrarlo");
					codigoIntroducido = teclado.nextInt();
					for(Pedido i: listaPedidoCocina){
						if(i.getCodigoPedido() == codigoIntroducido) {
							System.out.println(i.toString());;
						}
					}
					break;
					
				}case (5):{
					System.out.println("Introduzca codigo de ingrediente para mostrarlo");
					codigoIntroducido = teclado.nextInt();
					for(Ingrediente i: listaIngredientes){
						if(i.getCodigoIngrediente() == codigoIntroducido) {
							System.out.println(i.toString());;
						}
					}
					break;
					
				}case (0):{
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
	
	//Hago aqui el metodo porque al ser solo 1 restaurante no voy a crear una clase inventario con los ingredientes. 
	//Si no fuese así este metodo iría en la clase inventario
	private static String mostrarIngredientesAPedir(ArrayList <Ingrediente> lista) {
		String devolucion="Listado de ingredientes a pedir:\n";
		for(Ingrediente i: lista) {
			if(i.getCantidadExistencia() <= i.getCantidadMinima()) {
				devolucion += "Ingrediente codigo:" + i.getCodigoIngrediente() + ". Pedir minimo: " + ((i.getCantidadMinima() - i.getCantidadExistencia()) + (i.getCantidadMinima()*2))  +  " unidades para tener veces el minimo\n";
			}
		}
		return devolucion;
	}
	private static Pedido nuevoPedido(ArrayList <Ingrediente> lista) {
		Scanner teclado = new Scanner(System.in);
		boolean salirPedido = false;
		int codigoIntroducido, cantidadIntroducida;
		Pedido pedido1 = new Pedido();
		do {
			System.out.println("Introduzca codigo de ingrediente a pedir o pulse 0 para finalizar el pedido");
			codigoIntroducido = teclado.nextInt();
			if(codigoIntroducido != 0) {
				System.out.println("Introduzca la cantidad a pedir");
				cantidadIntroducida = teclado.nextInt();
				pedido1.peticionCocina(codigoIntroducido, cantidadIntroducida);
		
			}else {
				pedido1.enviarPedidoACocina(lista);
				salirPedido = true;
			}	
			
		}while(salirPedido == false);
		return pedido1;
	}
	private static Pedido nuevoPedidoPorDefecto(ArrayList <Ingrediente> lista) {
		Pedido pedido1 = new Pedido();
		for(int j = 1; j<=50; j++) {
			if(j < 25) {
				pedido1.peticionCocina(j, (j+5));
			}else {
				pedido1.peticionCocina(j, (j-5));
			}
		}
		pedido1.enviarPedidoACocina(lista);
		return pedido1;
	}
	
}
