package operacionesLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import operacionesArrayList.Alumno;

public class Principal {
	
	public static void main(String[] args) {
		
		LinkedList<Alumno> listaAlumnos = new LinkedList<>();
		LinkedList<Alumno> listaAlumnos2 = new LinkedList<>();
		File archivo = new File("notas1.txt");
		File archivo2 = new File("notas2.txt");
		
		//1. Importa los registros contenidos en el documento notas1.txt, donde la información tiene el
		//siguiente formato:
			//grupo;nombre,matemáticas;lengua;física;química;inglés
		listaAlumnos.addAll(lectorArchivos(archivo));
				
		
		//2. Muestra el número de registros que contiene.
		System.out.println("Mostrando la cantidad de registros que tiene la lista: " + listaAlumnos.size());
		
		
		//3. Ordena los registros por grupo y nombre.
		Collections.sort(listaAlumnos);
		escribirNuevoArchivo("LinkedListArchivos/AlumnosOrdenados", listaAlumnos, false);
		
		//4. Añade el registro abajo indicado en la mitad de la lista.
			//1º ESO A;Plaza Gallego, Juan;1;1;3;1;1
		Alumno alumno1 = new Alumno("1º ESO A", "Plaza Gallego, Juan", 1, 1, 3, 1, 1);
		listaAlumnos.add((listaAlumnos.size()-1)/2, alumno1);
		
		//5. Añade el mismo registro al principio de la lista.
		listaAlumnos.addFirst(alumno1);
		
		//6. Importa los registros contenidos en el documento notas2.txt en una lista auxiliar.
		listaAlumnos2.addAll(lectorArchivos(archivo2));
		
		//7. Añade la lista auxiliar al principio de la lista original.
		listaAlumnos.addAll(0, listaAlumnos2);
		escribirNuevoArchivo("LinkedListArchivos/Notas1MasNotas2", listaAlumnos, false);
		
		//8. Muestra el registro que está en la primera posición de la lista.
		System.out.println("Mostrando el registro de la primera posicion de la lista original: " + listaAlumnos.get(0).toString());
		
		//9. Muestra el registro que está en la última posición posición de la lista.
		System.out.println("Mostrando el registro de la ultima posicion de la lista: " + listaAlumnos.getLast());
		
		
		//10. Muestra el registro que está en la mitad de la lista.
		System.out.println("Mostrando el registro que está en la mitad de la lista: " + listaAlumnos.get((listaAlumnos.size()-1)/2));
		
		
		//11. ¿Qué posición ocupa la primera ocurrencia del registro insertado?
		System.out.println("Mostrando la primera coincidencia del registro insertado: " + listaAlumnos.indexOf(alumno1));
		
		//12. Qué posición ocupa la última ocurrencia del registro insertado?
		System.out.println("Mostrando la ultima coincidencia del registro insertado: " + listaAlumnos.lastIndexOf(alumno1));
		
		//13. ¿El siguiente registro está en la lista? 1º ESO E;Postigo Vázquez, Salvador;3;6;5;3;4
		Alumno alumno2 = new Alumno("1º ESO E", "Postigo Vázquez, Salvador", 3, 6, 5, 3,4);
		System.out.println("Mostrando si existe el registro Postigo Vázquez, Salvador en la lista: " + listaAlumnos.contains(alumno2));
		
		//14. ¿Y éste? 1º ESO A;García Fernández, María;6;5;6;5;5
		Alumno alumno3 = new Alumno("1º ESO A", "García Fernández, María", 6, 5, 6, 5, 5);
		System.out.println("Mostrando si existe el registro García Fernández, María en la lista: " + listaAlumnos.contains(alumno3));
		
		//15. Elimina la primera ocurrencia del registro insertado y muestra su posición y contenido.
		System.out.println("Mostrando la posicion e informacion del registro que se va a eliminar \n(se borrará la primera coincidencia del registro que se encuentre):\nPosicion:" 
		+ listaAlumnos.indexOf(alumno1) + " Informacion: " + listaAlumnos.get(listaAlumnos.indexOf(alumno1)).toString());
		listaAlumnos.removeFirstOccurrence(alumno1);
		
		//16. Elimina el registro que ocupa la posición media de la lista mostrando su contenido.
		System.out.println("Mostrando la informacion del registro de la posicion media de la lista que se va a borrar:\n" + listaAlumnos.remove((listaAlumnos.size()-1)/2));
		
		//17. Elimina el registro cuyo nombre es: Carrillo Segura, Félix, indicando su posición y contenido.
		System.out.println("Borrando el registro de nombre Carrillo Segura, Félix");
		borrarAlumno("Carrillo Segura, Félix", listaAlumnos);
		
		//18. Elimina el registro cuyo nombre es: Robles Ortiz, Rafael, indicando su posición y contenido.
		System.out.println("Borrando el registro de nombre Carrillo Segura, Félix");
		borrarAlumno("Robles Ortiz, Rafael", listaAlumnos);
		
		//19. Intenta simular una pila (LIFO, Last In, Last Out) con la lista original. Realiza dos inserciones y extracciones detallando su funcionamiento.
		listaAlumnos.push(alumno1); //El método push() añade un objeto al principio de la lista o pila en este caso.
		listaAlumnos.push(alumno2);
		escribirNuevoArchivo("LinkedListArchivos/Pila", listaAlumnos, false);
		System.out.println("Eliminando: " + listaAlumnos.pop().toString()); //El método pop() elimina el primer registro de la lista o pila en este caso
		System.out.println("Eliminando: " + listaAlumnos.pop().toString());
		
		//20. Intenta simular una cola (FIFO First In, First out) con la lista original. Realiza dos inserciones y extracciones detallando su funcionamiento.
		listaAlumnos.offer(alumno1); //El método offer() añade al final de la lista o cola en este caso el objeto indicado.
		listaAlumnos.offer(alumno2);
		escribirNuevoArchivo("LinkedListArchivos/Cola", listaAlumnos, false);
		System.out.println("Elimiando la cabeza de la lista (el primero): " + listaAlumnos.poll().toString()); //El método poll() elimina el primer elemento de la lista o cola en este caso.
		System.out.println("Elimiando la cabeza de la lista (el primero): " + listaAlumnos.poll().toString());
		
		
	}
	
	public static LinkedList<Alumno> lectorArchivos(File archivo) {
		LinkedList<Alumno> devolucion = new LinkedList<>();
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
	
	public static void escribirNuevoArchivo (String nombreArchivo, LinkedList<Alumno> lista, boolean sobreescribir) {
		
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
	
	public static void borrarAlumno(String nombre, LinkedList<Alumno> lista) {
		Iterator<Alumno> iterador = lista.iterator();
		boolean encontrado = false;
		Alumno alumno;
		while(iterador.hasNext() && encontrado == false) {
			alumno = iterador.next();
			if(alumno.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("Mostrando la posicion y la informacion del registro con nombre " + nombre);
				System.out.println("Posicion: " + lista.indexOf(alumno) + " Informacion: " + alumno.toString());
				lista.remove(alumno);
				encontrado = true;
			}
			
		}
		if(encontrado == false) {
			System.out.println("No existe ningun alumno con este nombre para poder borrarlo");
		}
		
	}
	

}
