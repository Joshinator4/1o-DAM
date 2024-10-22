/*
 * Ejercicio B2 - Notas de alumnos
 * El archivo ‘alumnos_notas.txt’ contiene una lista de 10 alumnos y las notas que han obtenido en
 * cada asignatura. El número de asignaturas de cada alumno es variable. Implementa un programa
 * que muestre por pantalla la nota media de cada alumno junto a su nombre y apellido, ordenado
 * por nota media de mayor a menor.
 */
package ejercicioB2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class PrincipalB2 {

	public static void main(String[] args) {
		
		File archivo = new File ("Documentos/alumnos_notas.txt");
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		listaAlumnos.addAll(lectorArchivos(archivo));
		Collections.sort(listaAlumnos);
		System.out.println("Mostrando la lista de alumnos ordenada por la nota media de los alumnos en orden descediente:\n" + listaAlumnos.toString());
		
		
	}
	
	public static ArrayList<Alumno> lectorArchivos(File archivo) {
		ArrayList<Alumno> devolucion = new ArrayList<>();
		try {
			Scanner lector = new Scanner (archivo);
			
			while(lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] lineaSeparada = linea.split(" "); 
				String nombre = null, apellido = null;
				double media = 0;
				int numero;
				for(int i = 0; i < lineaSeparada.length; i++) {
					if(i == 0){
						nombre = lineaSeparada[i];
					}else if(i == 1) {
						apellido = lineaSeparada[i];
					}else {
						numero = Integer.parseInt(lineaSeparada[i]);
						media += numero;
					}
				}
				media /= lineaSeparada.length - 2;
				Alumno alumno = new Alumno(nombre, apellido, media);
				devolucion.add(alumno);
		
			}
			lector.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return devolucion;
	}

}
