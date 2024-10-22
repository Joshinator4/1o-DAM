/*
 * Ejercicio B3 - Ordenando archivos
 * Implementa un programa que pida al usuario un nombre de archivo A para lectura y otro nombre
 * de archivo B para escritura. Leerá el contenido del archivo A (por ejemplo ‘usa_personas.txt’) y lo
 * escribirá ordenado alfabéticamente en B (por ejemplo ‘usa_personas_sorted.txt’).
 */
package ejercicioB3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class PrincipalB3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		String nombreArchivoLeer, nombreArchivoEscribir;
		
		System.out.println("Introduzca el nombre del archivo del que desea leer");
		nombreArchivoLeer = teclado.nextLine();
		System.out.println("Introduzca el nombre en el archivo que desea escribir");
		nombreArchivoEscribir = teclado.nextLine();
		File archivo = new File ("Documentos/"+nombreArchivoLeer);
		leerEscribirOrdenar(archivo, nombreArchivoEscribir);
	}
	
	public static ArrayList<Persona> lectorArchivos(File archivo) {
		ArrayList<Persona> devolucion = new ArrayList<>();
		try {
			Scanner lector = new Scanner (archivo);
			
			while(lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] lineaSeparada = linea.split(" "); 
				Persona persona = new Persona(lineaSeparada[0], lineaSeparada[1]);
				devolucion.add(persona);
			}
			lector.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return devolucion;
	}
	
	public static void escribirNuevoArchivo (String nombreArchivo, ArrayList<Persona> lista) {
		
		try {
			FileWriter archivoEscritura = new FileWriter(nombreArchivo);
			for(Persona i: lista) {
				archivoEscritura.write(i.getApellido() + " " + i.getNombre() + "\n");
			}
			archivoEscritura.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void leerEscribirOrdenar(File archivo, String nombreArchivo) {
		ArrayList<Persona> listaPersonas= new ArrayList<>();
		listaPersonas.addAll(lectorArchivos(archivo));
		Collections.sort(listaPersonas);
		escribirNuevoArchivo("Documentos/"+nombreArchivo, listaPersonas);
		
	}

}
