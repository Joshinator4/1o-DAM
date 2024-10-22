/* nombre: Joshua Sangareau Quesada
 * Fecha: 15/12/2023
 * 
 */

package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
		final byte DIAS=30, MESES=3;
		
	    // Variables de entrada
		int mesMenosLluvioso;
		int [][] datos = {{26,29,26},{19,2,24},{21,8,1},{11,5,24},{9,2,12},{7,20,19},{29,12,28},{11,10,20},
	    		{7,11,5},{21,13,29},{26,16,10},{7,10,18},{28,4,28},{29,14,7},{14,23,13},{11,29,2},
	    		{20,13,27},{25,21,11},{1,3,19},{29,21,15},{15,15,20},{24,21,21},{25,12,25},{8,4,8},
	    		{26,10,21},{26,2,7},{30,29,23},{15,20,20},{5,27,0},{8,28,24}};
		double mes0, mes1, mes2, mediaTotal;
		
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    for(int i = 0; i < MESES; i++) {
	    		System.out.println("El dia que mas llovio del mes " + i +" fue el dia: " + diaLlovioMas(datos, i));
	    }
	    System.out.println("El mes menos lluvioso fue: " + mesMenosLluvioso(datos));
	    mesMenosLluvioso = mesMenosLluvioso(datos);
	    
	    System.out.println("El dia que menos llovio del mes: " + mesMenosLluvioso + " es: " + valorDiaMenosLluvioso(datos, mesMenosLluvioso));
	    
	    
	    System.out.println("La media del mes 0 es: " + mediaCadaMes(datos, 0));
	    mes0 = mediaCadaMes(datos, 0);
	    
	    System.out.println("La media del mes 1 es: " + mediaCadaMes(datos, 1));
	    mes1 = mediaCadaMes(datos, 1);
	    
	    System.out.println("La media del mes 2 es: " + mediaCadaMes(datos, 2));
	    mes2 = mediaCadaMes(datos, 2);
	    
	    System.out.println("La media de los 3 meses es: " + mediaTodosLosMeses(mes0, mes1, mes2));
	    mediaTotal = mediaTodosLosMeses(mes0, mes1, mes2);
	    
	    System.out.println("¿La media del mes 0 es superior a la media total? " + mesPorEncimaDeLaMedia (mediaTotal, mes0));
	    System.out.println("¿La media del mes 1 es superior a la media total? " + mesPorEncimaDeLaMedia (mediaTotal, mes1));
	    System.out.println("¿La media del mes 2 es superior a la media total? " + mesPorEncimaDeLaMedia (mediaTotal, mes2));
	    
	}
	
	public static int diaLlovioMas (int [][] datos, int mes) {
		int devolucion = 0, diaMas = 0;
		for (int i = 0; i < 30; i++) {
			if(datos[i][mes] > diaMas) {
				diaMas = datos[i][mes];
				devolucion = i+1;
			}
		}
		return devolucion;
	}
	
	public static int mesMenosLluvioso (int [][] datos) {
		int devolucion=5, sumaLluvia=0, mesMenosLluvia= 10000;
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 30; j++) {
				sumaLluvia += datos [j][i];
			}
			if(sumaLluvia < mesMenosLluvia) {
				devolucion = i;
				mesMenosLluvia = sumaLluvia;
			}
			sumaLluvia = 0;
		}
		
		return devolucion;
	}
	
	public static int valorDiaMenosLluvioso (int [][] datos, int mes) {
		int diaMenosLluvia = 45, devolucion=35;
		
			for(int j = 0; j < 30; j++) {
				if(datos [j][mes] < diaMenosLluvia ) {
					diaMenosLluvia = datos [j][mes];
					devolucion = j+1;
				}
			}
			return devolucion;
		}
		
	public static double mediaCadaMes (int [][] datos, int mes) {
	double sumaValores=0, mediaMes;
	
		for(int i = 0; i < 30; i++) {
				sumaValores += datos [i][mes];
		}
		mediaMes = sumaValores / 30;
		return mediaMes;
		
	}
	public static double mediaTodosLosMeses (double mes0, double mes1, double mes2) {
		double mediaTotal;
		mediaTotal = (mes0 + mes1 + mes2)/3;
		return mediaTotal;
	}
	public static String mesPorEncimaDeLaMedia (double mediaTotal, double mes) {
		String mediaSuperior;
		if(mes > mediaTotal) {
			mediaSuperior = "La media si es superior a la media total";
		} else {
			mediaSuperior = "La media no es superior a la media total";
		}
		return mediaSuperior;
	}
	
} 