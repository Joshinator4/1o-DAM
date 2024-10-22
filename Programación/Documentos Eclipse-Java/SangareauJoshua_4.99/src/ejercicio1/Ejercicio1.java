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
	    /*for(int i = 0; i < MESES; i++) {
	    System.out.println("El mes menos lluvioso fue: " + mesMenosLluvioso(datos, i));
	    }*/
	    
	    System.out.println("La media de los 3 meses es: " + mediaMeses(datos));
	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
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
		int diaMenosLluvia = 45, devolucion=5;
		
			for(int j = 0; j < 30; j++) {
				if(diaMenosLluvia < datos [j][mes]) {
					diaMenosLluvia = datos [j][mes];
					devolucion = j+1;
				}
			}
			return devolucion;
		}
		
	public static int mediaMeses (int [][] datos) {
	int sumaValores=0, mediaTotal;
	
		for(int i = 0; i < 30; i++) {
			for (int j = 0; j < 3; j++) {
				sumaValores += datos [i][j];
			}
		}
		mediaTotal = (int) sumaValores / 90;
		return mediaTotal;
		
	}
	
	
} 