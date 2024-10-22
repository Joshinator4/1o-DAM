/* Ejercicio B4 - Nombre y apellidos
 * Implementa un programa que genere aleatoriamente nombres de persona (combinando nombres
 * y apellidos de ‘usa_nombres.txt’ y ‘usa_apellidos.txt’). Se le pedirá al usuario cuántos nombres de
 * persona desea generar y a qué archivo añadirlos (por ejemplo ‘usa_personas.txt’).
 */
package ejercicioB4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class PrincipalB4 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		ArrayList<String> listaNombres = new ArrayList<>();
		ArrayList<String> listaApellidos = new ArrayList<>();
		File archivoNombres = new File("Documentos/usa_nombres.txt");
		File archivoApellidos = new File("Documentos/usa_apellidos.txt");
		
		listaNombres.addAll(lectorArchivos(archivoNombres));
		listaApellidos.addAll(lectorArchivos(archivoApellidos));
		System.out.println("Mostrando cantidad de nombres que tiene la lista: " + listaNombres.size());
		System.out.println("Mostrando cantidad de apellidos que tiene la lista: " + listaApellidos.size());
		
		escribirNuevoArchivo("Documentos/usa_personas.txt", listaNombres, listaApellidos, teclado);
		
		

	}
	
	//Este método lee de un archivo y genera un ArrayList de tipo String y devuelve el ArrayList creado1
	public static ArrayList<String> lectorArchivos(File archivo) {
		ArrayList<String> devolucion = new ArrayList<>();
		try {
			Scanner lector = new Scanner (archivo);
			
			while(lector.hasNextLine()) {
				String linea = lector.nextLine(); 
				devolucion.add(linea);
		
			}
			lector.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return devolucion;
	}
	
	
	//este metodo escribe al final de un archivo. REcibe un nombre para el archivo, 2 listas (lista de nombres y lista de apellidos) y el teclado para solicitar la cantidad de nombres y apellidos aleatorios 
	public static void escribirNuevoArchivo (String nombreArchivo, ArrayList<String> lista1, ArrayList<String> lista2, Scanner teclado) {
		int cantidadCrear;
		System.out.println("Introduzca la cantidad de nombres aleatorios a crear");
		cantidadCrear = teclado.nextInt();
		try {
			FileWriter archivoEscritura = new FileWriter(nombreArchivo, true);
			for(int i = 0; i < cantidadCrear; i++) {
				archivoEscritura.write(lista1.get((int)(Math.random()*lista1.size())) + " " + lista2.get((int)(Math.random()*lista2.size())) + "\n");
			}
			archivoEscritura.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
