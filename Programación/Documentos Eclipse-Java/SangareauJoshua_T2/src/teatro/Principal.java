/*
 * Objetivo: Utilizar la clase teatro
 * Autor: Joshua Sangareau Quesada
 * fecha: 11/03/2024
 */

package teatro;

import libtarea3.Teatro;

public class Principal {

	public static void main(String[] args) {
		
		
		//Apartado2
		System.out.println("\nPRIMER TEATRO");
		Teatro teatro1 = new Teatro();
		System.out.println(teatro1.toString());
		
		try {
			
			//Apartado3
			
			teatro1.comprarEntradas(100);
		}catch(IllegalStateException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}
		
		try {
			
			//apartado 4
			
			teatro1.asignarObra("La verbena de la paloma");
			System.out.println(teatro1.getObra());
						
			
		}catch(IllegalStateException excepcion3) {
			System.out.println(excepcion3.getMessage());
		}catch(IllegalArgumentException excepcion4) {
			System.out.println(excepcion4.getMessage());
		}
		
		try {
			
			//apartado 5 
			teatro1.comprarEntradas(entradasAleatoria());
			System.out.println(teatro1.getEntradasVendidas());
			
			
		}catch(IllegalStateException excepcion5) {
			System.out.println(excepcion5.getMessage());
			teatro1.comprarEntradas(teatro1.getAforo());
			System.out.println(teatro1.getEntradasVendidas());
		}catch(IllegalArgumentException excepcion6) {
			System.out.println(excepcion6.getMessage());
		}
		
		try {
			
			//apartado 6
			System.out.println("\nSEGUNDO TEATRO");
			Teatro teatro2 = new Teatro("Cervantes", 500);
			System.out.println(teatro2.toString());
			
			//apartado7 
			
			teatro1.traspasarObra(teatro2);
			System.out.println(teatro2.getObra());
			
			//apartado 8
			teatro2.comprarEntradas(entradasAleatoria());
			teatro2.getEntradasVendidas();
			
			//apartado 9
			System.out.println(teatro2.getEntradasVendidas());
			
		}catch(IllegalStateException excepcion7) {
			System.out.println(excepcion7.getMessage());
		}catch(IllegalArgumentException excepcion8) {
			System.out.println(excepcion8.getMessage());
		}
		
		try {
			
			//apartado 10
			System.out.println("\nCLONANDO CERVANTES");
			Teatro teatro3 = new Teatro("Soho Málaga");
			
			
		}catch(IllegalStateException excepcion8) {
			System.out.println(excepcion8.getMessage());
		}catch(IllegalArgumentException excepcion9) {
			System.out.println(excepcion9.getMessage());
		}
		
		//apartado11.1 
		System.out.println(Teatro.getTeatrosTotales());
		
		//apartado11.2
		System.out.println(Teatro.getObrasActivas());
		
		//apartado11.3
		System.out.println(Teatro.getEntradasVendidasTotales());
		
		
		
	}
	
	//APARTADO1 
	public static int entradasAleatoria() {
		int devolucion;
		devolucion = (int)(Math.random()*16);
		devolucion = devolucion *100;
		return devolucion;
	}

}
