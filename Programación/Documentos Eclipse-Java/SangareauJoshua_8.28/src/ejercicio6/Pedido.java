package ejercicio6;

import java.util.ArrayList;
import java.util.Scanner;

public class Pedido implements Comparable<Pedido>{
	
	private static int contadorPedidos = 1;
	
	private int codigoPedido;
	private int [] listaPedido; //se pondra como maximo un pedido con 50 ingredientes
	
	
	public Pedido() {
		this.listaPedido = new int [50];
		this.codigoPedido = contadorPedidos;
		contadorPedidos++;
	}
	
	
	public void peticionCocina(int codigoIngrediente, int cantidadRequerida) {
		this.listaPedido[codigoIngrediente-1] = cantidadRequerida;
	}
	
	

	public void enviarPedidoACocina(ArrayList <Ingrediente> lista) {
		for(int i = 1; i <= 50; i++) {
			if(listaPedido[i-1]==0) {
				
			}else {
				for(Ingrediente j: lista) {
					if(j.getCodigoIngrediente() == i) {
						j.setCantidadExistencia(j.getCantidadExistencia() - listaPedido[i-1]);
					}
				}
			}
		}
	}
	

	public int getCodigoPedido() {
		return codigoPedido;
	}


	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	

	@Override
	public String toString() {
		String devolucion = "Pedido " + this.codigoPedido + "[";
		for(int i = 1; i <= 50; i++) {
			if(listaPedido[i-1] != 0) {
				devolucion += "\ncodigo de Ingrediente: " + i + " cantidad solicitada: " + listaPedido[i-1];
			}
		}
		devolucion += "]\n";
		return devolucion;
	}


	@Override
	public int compareTo(Pedido o) {
		int devolucion;
		if(this.codigoPedido < o.getCodigoPedido()) {
			devolucion = 1;
		}else if(this.codigoPedido > o.getCodigoPedido()) {
			devolucion = -1;
		}else {
			devolucion = 0;
		}
		return devolucion;
	}
	
	
	

}
