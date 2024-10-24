/*8 Aplicación senderismo:
En primer lugar, se solicitarán al usuario una serie de datos:
 Nombre
 Apellidos
 Edad (se controlará que la edad introducida sea superior a 17 y menor a 45,
mientras no introduzca un valor correcto mostraremos el mensaje “Esa edad no es
correcta” y volveremos a preguntar.
 Número rutas realizadas
 Distancia última ruta
A partir de estos datos el sistema solicitará que introduzca los datos de una serie de 5
caminatas. Se pedirá de cada caminata:
 Distancia
 Número de participantes
 Ciudad
Tras los 5 registros tendremos que ser capaces de mostrar por pantalla los siguientes
resultados en la siguiente ficha:

---------------------------------------------------------
Nombre:
Edad:
Número de rutas realizadas:
Distancia media (5 últimas rutas):
Distancia más larga de las últimas 5 rutas:
Ciudad de la ruta más larga:
---------------------------------------------------------
 */
package ejercico8;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		String nombre, apellidos, ciudadRuta, ciudadLarga;
		ciudadLarga = null;
		byte edad;
		int numeroRutas, distanciaUltima, distanciaRuta, numeroParticipantes, rutaLarga, totalRuta, distanciaMedia;
		rutaLarga = 0;
		totalRuta = 0;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca su nombre: ");
	    nombre = teclado.nextLine();
	    
	    System.out.println("Introduzca sus apellidos: ");
	    apellidos = teclado.nextLine();
	    
	    do {
	    System.out.println("Introduzca su edad");
	    edad = teclado.nextByte();
	    
	    	if (edad < 17 || edad > 45) {
	    	System.out.println("Esa edad no es correcta");
	    	}
	    } while (edad < 17 || edad > 45);
	    
	    System.out.println("Introduzca nº de rutas realizadas: ");
	    numeroRutas = teclado.nextInt();
	    
	    System.out.println("Introduzca distancia de la última ruta realizada: ");
	    distanciaUltima = teclado.nextInt();
	   

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    for (int i = 1; i <= 5; i++) {
	    	System.out.println("Introduzca distancia en km, para ruta " + i + ":");
	    	distanciaRuta = teclado.nextInt();
	    	
	    	System.out.println("Introduzca el número de participantes de la ruta " + i + ":");
	    	numeroParticipantes = teclado.nextInt();
	    	teclado.nextLine();
	    	
	    	System.out.println("Introduzca el nombre de la ciudad " + i + ":");
	    	ciudadRuta = teclado.nextLine();
	    	
	    	totalRuta += distanciaRuta;
	    	
	    	if (distanciaRuta > rutaLarga) {
	    		rutaLarga = distanciaRuta;
	    		ciudadLarga = ciudadRuta;
	    		
	    	} 
	    }
	    distanciaMedia = totalRuta / 5;
	    System.out.println("Nombre: " + nombre);
	    System.out.println("Edad: " + edad);
	    System.out.println("Total rutas realizadas: " + numeroRutas);
	    System.out.println("Distancia media de las 5 rutas: " + distanciaMedia + "Km");
	    System.out.println("La distancia más larga de las 5 rutas es: " + rutaLarga);
	    System.out.println("La ciudad de la ruta más larga de las 5 rutas es: " + ciudadLarga);
	    
	    
	}
}   