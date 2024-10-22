package operacionesTreeSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class Principal {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		TreeSet<Alumno> listaAlumnos = new TreeSet <Alumno>();
		NavigableSet<Alumno> listaAlumnosOrdenadaInverso;
		SortedSet<Alumno> listaSortedClonadaOrdenada ;
		NavigableSet<Alumno> listaNavigableClonada;
		ArrayList<Alumno> listaNotas2 = new ArrayList <>();
		File archivo = new File("notas1.txt");
		Alumno alumno1;
		Alumno alumno2;
		
		//1. Importa los registros contenidos en el documento notas1.txt a un TreeSet, donde la información tiene el siguiente formato:
		 //grupo;nombre,matemáticas;lengua;física;química;inglés
		listaAlumnos.addAll(lectorArchivos(archivo));
		
		//2. Muestra el número de registros que contiene.
		System.out.println("Mostrando el numero de registros que contiene el treeset" + listaAlumnos.size());
		
		
		//3. Ordena los registros por grupo y nombre.
		escribirNuevoArchivo("TreeSetArchivos/ListaOrdenada.txt", listaAlumnos, false);
		
		//4. Clona el TreeSet y ordena los elementos en orden inverso. 
		listaAlumnosOrdenadaInverso = listaAlumnos.descendingSet();
		escribirNuevoArchivo("TreeSetArchivos/ListaOrdenadaInverso.txt", listaAlumnosOrdenadaInverso, false);
		
		
		//5. Añade el registro abajo indicado.
		  //1º ESO A;Plaza Gallego, Juan;1;1;3;1;1
		alumno1 = new Alumno("1º ESO A", "Plaza Gallego, Juan",1,1,3,1,1);
		System.out.println("Mostrando si es posible añadir al alumno1: " + listaAlumnos.add(alumno1));
		
		//6. Añade el registro abajo indicado.
		 // 1º ESO A;Suárez Cano, Francisco José;2;3;4;1;2
		alumno2 = new Alumno("1º ESO A", "Suárez Cano, Francisco José",2,3,4,1,2);
		System.out.println("Mostrando si es posible añadir al alumno2: " + listaAlumnos.add(alumno2));
		
		//7. Importa los registros contenidos en el documento notas2.txt en un arraylist.
		archivo = new File("notas2.txt");
		listaNotas2.addAll(lectorArchivos(archivo));
		
		//8. Inserta los registros contenidos en el arraylist anterior en el TreeSet.
		listaAlumnos.addAll(listaNotas2);
		
		//9. Comprueba que el registro del punto 4 está en el conjunto. Clona el conjunto a otro SortedSet y realiza las siguientes operaciones:
		//me imagino q es el del apartado 5 
		System.out.println("Mostrando los datos del registro del punto 5, si existe: " + listaAlumnos.contains(alumno1));
		listaSortedClonadaOrdenada = new TreeSet <Alumno>(listaAlumnos); 
		
		//10. Muestra el último objeto del conjunto.
		System.out.println("Mostrando el ultimo objeto del conjunto: " + listaSortedClonadaOrdenada.last().toString());
		
		//11. Muestra el primer objeto del conjunto.
		System.out.println("Mostrando el primer objeto del conjunto: " + listaSortedClonadaOrdenada.first().toString());
		
		//12. Exporta todos los elementos del conjunto anteriores a "1º ESO C".
		Alumno alumno3 = new Alumno ("1º ESO C", "", 0,0,0,0,0);
		escribirNuevoArchivo("TreeSetArchivos/anteriores1C.txt", listaSortedClonadaOrdenada.tailSet(alumno3), false);
		
		//13. Exporta todos los elementos del conjunto posteriores a "1º ESO C". Clona el conjunto a otro NavigableSet y realiza las siguientes operaciones:
		escribirNuevoArchivo("TreeSetArchivos/posteriores1C.txt", listaSortedClonadaOrdenada.headSet(alumno3), false);
		listaNavigableClonada = listaAlumnos;
		
		//14. Exporta todos los elementos ordenados en orden inverso.
		listaNavigableClonada = listaNavigableClonada.descendingSet();
		escribirNuevoArchivo("TreeSetArchivos/navigableInverso.txt", listaNavigableClonada, false);
		
		//15. Muestra y elimina el primer elemento del conjunto.
		System.out.println("Mostrando la informacion del alumno a eliminar: " + listaNavigableClonada.pollFirst().toString());
		
		//16. Muestra y elimina el último elemento del conjunto.
		System.out.println("Mostrando la informacion del alumno a eliminar: " + listaNavigableClonada.pollLast().toString());
	}
	
	public static Collection<Alumno> lectorArchivos(File archivo) {
		Collection<Alumno> devolucion = new TreeSet<>();
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
	public static Alumno buscarPrimerAlumnoGrupo(String grupo, Collection<Alumno> lista) {
		Iterator<Alumno> iterador = lista.iterator();
		boolean encontrado = false;
		Alumno alumno = null;
		Alumno devolucion = null;
		while(iterador.hasNext() && encontrado == false) {
			alumno = iterador.next();
			if(alumno.getGrupo().equals(grupo)) {
				encontrado = true;
				devolucion = alumno;
			}
			
		}
		return devolucion;
		
	}
	

}
