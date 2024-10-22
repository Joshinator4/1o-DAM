package ejercicioA2;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
	
		Persona persona1 = new Persona ();
		Persona persona2 = new Persona ();
		
		System.out.println("Introduzca el nombre de la primera persona");
		persona1.nombre = teclado.nextLine();
		
		System.out.println("Introduzca el apellido de la primera persona");
		persona1.apellido = teclado.nextLine();
		
		System.out.println("Introduzca el dni de la primera persona");
		persona1.dni = teclado.nextLine();
		
		System.out.println("Introduzca la edad de la primera persona");
		persona1.edad = teclado.nextByte();
		
		teclado.nextLine();
		
		System.out.println("Introduzca el nombre de la segunda persona");
		persona2.nombre = teclado.nextLine();
		
		System.out.println("Introduzca el apellido de la primera persona");
		persona2.apellido = teclado.nextLine();
		
		System.out.println("Introduzca el dni de la primera persona");
		persona2.dni = teclado.nextLine();
		
		System.out.println("Introduzca la edad de la primera persona");
		persona2.edad = teclado.nextByte();
		
		if(persona1.edad >= 18) {
			System.out.println(persona1.nombre + " " + persona1.apellido + " con dni: " + persona1.dni + " es mayor de edad"  );
		}else {
			System.out.println(persona1.nombre + " " + persona1.apellido + " con dni: " + persona1.dni + " no es mayor de edad"  );
		}
		
		if(persona2.edad >= 18) {
			System.out.println(persona2.nombre + " " + persona2.apellido + " con dni: " + persona2.dni + " es mayor de edad"  );
		}else {
			System.out.println(persona2.nombre + " " + persona2.apellido + " con dni: " + persona2.dni + " no es mayor de edad"  );
		}
		
	}

}
