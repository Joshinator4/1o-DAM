package Comprobación_DNI_y_FechaNacimiento;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comprobación_DNI_y_FechaNacimiento {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		String dniIntroducido, fechaNacimiento;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca su DNI");
	    dniIntroducido = teclado.nextLine();
	    
	    System.out.println("Introduzca su fecha de nacimiento en formato dd/mm/aaaa");
	    fechaNacimiento = teclado.nextLine();
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    Pattern patDni = Pattern.compile("[0-9]{1,8}[a-zA-Z]");
	    Matcher matDni = patDni.matcher(dniIntroducido);
	    
	    if(matDni.matches()) {
	    	System.out.println("El patron del DNI coincide");
	    } else {
	    	System.out.println("El patron no del DNI coincide");
	    }
	    
	    Pattern patFecha = Pattern.compile("[0-9]{1,2}/[0-9]{1,2}/[0-9]{1,4}");
	    Matcher matFecha = patFecha.matcher(fechaNacimiento);
	    
	    if(matFecha.matches()) {
	    	System.out.println("El formato de la fecha coincide");
	    } else {
	    	System.out.println("El formato de la fecha no coincide");
	    }
	    
	}
}   
