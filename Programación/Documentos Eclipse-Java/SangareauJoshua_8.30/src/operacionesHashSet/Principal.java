package operacionesHashSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		HashSet<Alumno> conjuntoAlumnos = new HashSet<> ();
		HashSet<Alumno> conjuntoAlumnos2 = new HashSet<> ();
		HashSet<Alumno> interseccionNotas3 = new HashSet<> ();
		ArrayList<Alumno> listaOrdenada;
		ArrayList<Alumno> listaNotas2 = new ArrayList<>();
		ArrayList<Alumno> listaNotas3 = new ArrayList<>();
		File archivo = new File("notas1.txt");
		
		//1. Importa los registros contenidos en el documento notas1.txt a un HashSet, donde la información tiene el siguiente formato:
		 	//grupo;nombre,matemáticas;lengua;física;química;inglés
		conjuntoAlumnos.addAll(lectorArchivos(archivo));
		
		//2. Muestra el número de registros que contiene.
		System.out.println("Mostrando cantidad de registros de la lista de alumnos :" + conjuntoAlumnos.size());
		
		//3. Ordena los registros por grupo y nombre. Pista: https://www.baeldung.com/java-sort-hashset
		listaOrdenada = new ArrayList<>(conjuntoAlumnos);
		Collections.sort(listaOrdenada);
		escribirNuevoArchivo("HashSetArchivos/AlumnosOrdenados.txt", listaOrdenada, false);
		
		//4. Añade el registro abajo indicado.
			//1º ESO A;Plaza Gallego, Juan;1;1;3;1;1
		Alumno alumno1 = new Alumno ("1º ESO A", "Plaza Gallego, Juan", 1, 1, 3, 1, 1);
		System.out.println("Mostrando si se puede añadir a Plaza Gallego, Juan:" +  conjuntoAlumnos.add(alumno1));
		
		//5. Añade el registro abajo indicado.
			//1º ESO A;Suárez Cano, Francisco José;2;3;4;1;2
		Alumno alumno2 = new Alumno ("1º ESO A", "Suárez Cano, Francisco José", 2, 3, 4, 1, 2);
		System.out.println("Mostrando si se puede añadir a Suárez Cano, Francisco José:" + conjuntoAlumnos.add(alumno2)); 
		
		//6. Importa los registros contenidos en el documento notas2.txt en un arraylist.
		archivo = new File("notas2.txt");
		listaNotas2.addAll(lectorArchivos(archivo));
		
		//7. Inserta los registros contenidos en el arraylist anterior en el HashSet.
		conjuntoAlumnos.addAll(listaNotas2);
		escribirNuevoArchivo("HashSetArchivos/Notas1+Notas2.txt", conjuntoAlumnos, false);
		
		//8. Comprueba que el registro del punto 4 está en el conjunto.
		System.out.println("Mostrando si el registro del punto 4 está en el conjunto: " + conjuntoAlumnos.contains(alumno1));
		
		//9. Comprueba que el registro del punto 5 está en el conjunto.
		System.out.println("Mostrando si el registro del punto 5 está en el conjunto: " + conjuntoAlumnos.contains(alumno2));
		
		//10. Crea un arraylist con los registros contenidos en notas3.txt.
		archivo = new File("Notas3.txt");
		listaNotas3.addAll(lectorArchivos(archivo));
		
		//11. Aplica la intersección del HashSet y del arraylist del punto anterior. Muestra el resultado.
		interseccionNotas3.retainAll(listaNotas3);
		escribirNuevoArchivo("HashSetArchivos/InterseccionNotas3.txt", listaNotas3, false);
		
		//12. Crea un HashSet e inserta el arraylist anterior. Inserta los objetos creados en el punto 4 y 5.
		conjuntoAlumnos2.addAll(listaNotas3);
		System.out.println("Mostrando si se puede añadir a Plaza Gallego, Juan:" + conjuntoAlumnos2.add(alumno1));
		System.out.println("Mostrando si se puede añadir a Suárez Cano, Francisco José:" + conjuntoAlumnos2.add(alumno2));
		
		//13. Aplica la intersección de los dos HashSet. Muestra su contenido.
		conjuntoAlumnos.retainAll(conjuntoAlumnos2);
		escribirNuevoArchivo("HashSetArchivos/InterseccionConjuntos.txt", conjuntoAlumnos, false);
		
		//14. Busca y muestra el registro con nombre “Romero Farfán, Estefanía”.
		System.out.println("Mostrando el registro con nombre Romero Farfán, Estefanía: "+ buscarAlumno("Romero Farfán, Estefanía", conjuntoAlumnos));
		
		//15. Busca y muestra el registro con nombre “Gutiérrez Martín, Marina”.
		System.out.println("Mostrando el registro con nombre Gutiérrez Martín, Marina: "+ buscarAlumno("Gutiérrez Martín, Marina", conjuntoAlumnos));
		
		//16. Elimina el objeto insertado en el punto 4.
		System.out.println("Mostrando si se ha eliminado el objeto insertado en el punto 4: " + conjuntoAlumnos.remove(alumno1));
		
		//17. Elimina el objeto insertado en el punto 5.
		System.out.println("Mostrando si se ha eliminado el objeto insertado en el punto 5: " + conjuntoAlumnos.remove(alumno2));
		
		//18. Exporta el HashSet original a un documento de texto.
		escribirNuevoArchivo("HashSetArchivos/ConjuntoOriginal.txt", conjuntoAlumnos, false);
	}
	
	public static Collection<Alumno> lectorArchivos(File archivo) {
		Collection<Alumno> devolucion = new HashSet<>();
		try {
			Scanner lector = new Scanner (archivo);
			
			while(lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] lineaSeparada = linea.split(";"); 
				Alumno alumno = new Alumno(lineaSeparada[0], lineaSeparada[1], Integer.parseInt(lineaSeparada[2]),Integer.parseInt(lineaSeparada[3]), 
						Integer.parseInt(lineaSeparada[4]),Integer.parseInt(lineaSeparada[5]), Integer.parseInt(lineaSeparada[6]));
				devolucion.add(alumno);
		
			}
			lector.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return devolucion;
	}
	
	public static void escribirNuevoArchivo (String nombreArchivo, Collection<Alumno> lista, boolean sobreescribir) {
			
			try {
				FileWriter archivoEscritura = new FileWriter(nombreArchivo, sobreescribir);
				for(Alumno i: lista) {
					if(sobreescribir == true) {
						archivoEscritura.write("\n" + i.getGrupo() + ";" + i.getNombre() + ";" + i.getMatematicas() + ";" + i.getLengua()  
						+ ";" + i.getFisica() + ";" + i.getQuimica() + ";" + i.getIngles() );
					}else {
						archivoEscritura.write(i.getGrupo() + ";" + i.getNombre() + ";" + i.getMatematicas() + ";" + i.getLengua()  
						+ ";" + i.getFisica() + ";" + i.getQuimica() + ";" + i.getIngles()  + "\n");
					}
					
				}
				archivoEscritura.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
	}
	public static Alumno buscarAlumno(String nombre, Collection<Alumno> lista) {
		Iterator<Alumno> iterador = lista.iterator();
		boolean encontrado = false;
		Alumno alumno = null;
		Alumno devolucion = null;
		while(iterador.hasNext() && encontrado == false) {
			alumno = iterador.next();
			if(alumno.getNombre().equals(nombre)) {
				encontrado = true;
				devolucion = alumno;
			}
			
		}
		return devolucion;
		
	}

}
