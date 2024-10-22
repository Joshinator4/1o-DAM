/*
 * Realiza un programa que lea una fecha introduciendo el día, mes y año por separado y nos diga
si la fecha es correcta o no. Se debe crear una función donde le pasemos los datos y devuelva si
es correcta o no.
 */
package ejercicio10;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		byte dia, mes;
		int year;
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
	    
	    System.out.println("Introduzca el día");
	    dia = teclado.nextByte();
	    
	    System.out.println("Introduzca el mes");
	    mes = teclado.nextByte();
	    
	    System.out.println("Introduzca el año");
	    year = teclado.nextInt();
	    
	    
	    if (verificadorFecha (dia, mes, year) == true) {
	    	System.out.println("La fecha introducida es correcta");
	    	
	    } else {
	    	System.out.println("La fecha introducida no es correcta");
	    }
	    
	}
	
	public static boolean verificadorFecha (byte x, byte y, int z) {
		boolean correcto;
		
		if(z > 0 && z <= 2023) {
			correcto = true;
			
			switch (y) {
				case 1, 3 , 5 , 7 , 8, 10, 12 :{
					if(x > 0 && x <= 31) {
						correcto = true;
					}else {
						correcto = false;
					}
					break;
				}
				case 4, 6, 9, 11 :{
					if(x > 0 && x <= 30) {
						correcto = true;
					}else {
						correcto = false;
					} 
					break;
				}
				case 2: {
					if(x > 0 && x <= 29) {
						correcto = true;
						if(x == 29) {
							if(saberSiEsBisiesto(z)==true) {
								correcto = true;
							}else {
								correcto = false;
							}
						}
					}else {
						correcto = false;
					}
					
					break;
				}
				default:{
				correcto = false;
				}
			}
		}else {
			correcto = false;
		}
		
		return correcto;
		
	}
	
	public static boolean saberSiEsBisiesto (int x) {
		boolean bisiesto = false;
		if ((x % 4 == 0) && ((x % 100 != 0) || (x % 400 == 0))) {
			bisiesto = true;
		}
		else {
			bisiesto = false;
		}
		return bisiesto;
			
	}
	
}   
