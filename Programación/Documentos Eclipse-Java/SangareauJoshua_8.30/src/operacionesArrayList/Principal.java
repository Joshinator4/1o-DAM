package operacionesArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		//Apartado 1 
		File archivo = new File("ArrayListArchivos/notas1.txt");
		ArrayList<Alumno> listaAlumnos = new ArrayList <>();
		lectorArchivos(listaAlumnos, archivo);
		
		//apartado 2
		System.out.println("Mostrando el tamaño de la lista tras la importacion: " + listaAlumnos.size());
		
		//apartado 3
		Collections.sort(listaAlumnos);
		escribirNuevoArchivo("ArrayListArchivos/AlumnosOrdenados.txt", listaAlumnos, false);
		
		//apartado 4
		Alumno nuevoAlumno = new Alumno("1º ESO D", "López Muro, Rosario", 3, 3, 4, 4, 3);
		listaAlumnos.add(nuevoAlumno);
		
		//apartado 5
		Alumno nuevoAlumno2 = new Alumno("1º ESO B", "Duarte Durán, Alba", 2, 3, 4, 1, 3);
		listaAlumnos.add((listaAlumnos.size()/2)-1, nuevoAlumno2);
		
		//apartado 6
		System.out.println("Mostrando la posicion del objeto añadido en el apartado 4: " + listaAlumnos.indexOf(nuevoAlumno));
		System.out.println("Mostrando la posicion del objeto añadido en el apartado 5: " + listaAlumnos.indexOf(nuevoAlumno2));
		//No se puede hacer así porque hay varios Alumnos con los mismos datos.
		//Si se hace así se queda con la posicion del primer alumno que se encuentra con esos datos
		/*Iterator<Alumno> iterador = listaAlumnos.iterator();
		boolean encontrado = false;
		Alumno alumno;
		int posicion = 0;
		while(iterador.hasNext() && encontrado == false) {
			alumno = iterador.next();
			if(alumno.getNombre().equals("Duarte Durán, Alba") && alumno.getGrupo().equals("1º ESO B")) {
				posicion = listaAlumnos.indexOf(alumno);
				encontrado = true;
			}
		}*/
		
		//apartado 7
		escribirNuevoArchivo("ArrayListArchivos/notas2.txt", listaAlumnos, true);
		
		//apartado 8
		System.out.println("El registro de Alejandro Cordero Benitez se encuentra en la posicion: " + buscadorPosicionesAlumnos(listaAlumnos, "Cordero Benítez, Alejandro", "1º ESO B"));
			
		//apartado 9 
		System.out.println("El registro de Natali Zoodsma Villalón se encuentra en la posicion: " + buscadorPosicionesAlumnos(listaAlumnos, "Zoodsma Villalón, Natali", "1º ESO C"));
			
		//apartado 10
		System.out.println("Borrando el alumno de la posicion mitad + 1: " + listaAlumnos.remove((listaAlumnos.size()/2)).toString());
		
		//apartado 11
		for(int i = 0; i < 10; i++) {
			listaAlumnos.remove(i);
		}
		
		//apartado 12
		System.out.println("Se han borrado: " + borrarAlumnosConMatematicas2(listaAlumnos) + " registros");
		
		//apartado 13
		escribirArchivoMedias("ArrayListArchivos/mediasCadaRegistro.txt", listaAlumnos, false);		
		
		//apartado 14
		ArrayList<Alumno> listaAlumnos1A = new ArrayList <>();
		ArrayList<Alumno> listaAlumnos1B = new ArrayList <>();
		ArrayList<Alumno> listaAlumnos1C = new ArrayList <>();
		ArrayList<Alumno> listaAlumnos1D = new ArrayList <>();
		ArrayList<Alumno> listaAlumnos1E = new ArrayList <>();
		for(Alumno i: listaAlumnos) {
			if(i.getGrupo().equals("1º ESO A")) {
				listaAlumnos1A.add(i);
			}else if(i.getGrupo().equals("1º ESO B")) {
				listaAlumnos1B.add(i);
			}else if(i.getGrupo().equals("1º ESO C")) {
				listaAlumnos1C.add(i);
			}else if(i.getGrupo().equals("1º ESO D")) {
				listaAlumnos1D.add(i);
			}else if(i.getGrupo().equals("1º ESO E")) {
				listaAlumnos1E.add(i);
			}
		}
		OrdenarPorNombre ordenar =  new OrdenarPorNombre();
		Collections.sort(listaAlumnos1A, ordenar);
		Collections.sort(listaAlumnos1B, ordenar);
		Collections.sort(listaAlumnos1C, ordenar);
		Collections.sort(listaAlumnos1D, ordenar);
		Collections.sort(listaAlumnos1E, ordenar);
		
		escribirNuevoArchivo("ArrayListArchivos/lista1ºA.txt", listaAlumnos1A, false);
		escribirNuevoArchivo("ArrayListArchivos/lista1ºB.txt", listaAlumnos1B, false);	
		escribirNuevoArchivo("ArrayListArchivos/lista1ºC.txt", listaAlumnos1C, false);	
		escribirNuevoArchivo("ArrayListArchivos/lista1ºD.txt", listaAlumnos1D, false);	
		escribirNuevoArchivo("ArrayListArchivos/lista1ºE.txt", listaAlumnos1E, false);	
		
		//apratado 15 
		imprimirMedias(listaAlumnos1A, "1º ESO A");
		imprimirMedias(listaAlumnos1B, "1º ESO B");
		imprimirMedias(listaAlumnos1C, "1º ESO C");
		imprimirMedias(listaAlumnos1D, "1º ESO D");
		imprimirMedias(listaAlumnos1E, "1º ESO E");
		
		//aparatado 16
		System.out.println("Mostrando las 10 mejores notas del grupo 1ª ESO A: \n" + mostrarMejoresNotas(listaAlumnos1A));
		System.out.println("Mostrando las 10 mejores notas del grupo 1ª ESO B: \n" + mostrarMejoresNotas(listaAlumnos1B));
		System.out.println("Mostrando las 10 mejores notas del grupo 1ª ESO C: \n" + mostrarMejoresNotas(listaAlumnos1C));
		System.out.println("Mostrando las 10 mejores notas del grupo 1ª ESO D: \n" + mostrarMejoresNotas(listaAlumnos1D));
		System.out.println("Mostrando las 10 mejores notas del grupo 1ª ESO e: \n" + mostrarMejoresNotas(listaAlumnos1E));
		
	}
	
	
	public static void lectorArchivos(ArrayList<Alumno> lista, File archivo) {
		try {
			Scanner lector = new Scanner (archivo);
			
			while(lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] lineaSeparada = linea.split(";"); 
				Alumno alumno = new Alumno(lineaSeparada[0], lineaSeparada[1], Integer.parseInt(lineaSeparada[2]),Integer.parseInt(lineaSeparada[3]),
						Integer.parseInt(lineaSeparada[4]),Integer.parseInt(lineaSeparada[5]), Integer.parseInt(lineaSeparada[6]));
				lista.add(alumno);
		
			}
			lector.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int buscadorPosicionesAlumnos(ArrayList<Alumno> lista, String nombre, String grupo) {
		int devolucion = 0;
		Iterator<Alumno> iterador = lista.iterator();
		boolean encontrado = false;
		Alumno alumno;
		while(iterador.hasNext() && encontrado == false) {
			alumno = iterador.next();
			if(alumno.getNombre().equals(nombre) && alumno.getGrupo().equals(grupo)) {
				encontrado = true;
				devolucion =  lista.indexOf(alumno);
			}
		}
		return devolucion;
	}
	
	public static int borrarAlumnosConMatematicas2(ArrayList<Alumno> lista) {
		Alumno alumno;
		Iterator<Alumno> iterador2 = lista.iterator();
		int devolucion = 0;
		while(iterador2.hasNext()) {
			alumno = iterador2.next();
			if(alumno.getMatematicas() == 2) {
				devolucion++;
				iterador2.remove();
			}
		}
		return devolucion;
	}
	
	public static void imprimirMedias(ArrayList<Alumno> lista, String grupo) {
		System.out.println("\n\nEstas son las medias de cada asignatura de " + grupo + ":");
		System.out.printf("Matemáticas= %.2f", sacarMedia(lista, 1));
		System.out.printf("\nLengua= %.2f", sacarMedia(lista, 2));
		System.out.printf("\nFísca= %.2f", sacarMedia(lista, 3));
		System.out.printf("\nQuímica= %.2f", sacarMedia(lista, 4));
		System.out.printf("\nInglés= %.2f", sacarMedia(lista, 5));
		System.out.println("\n////////////////////////////////////////////////////////////////////////////////");
	}
	
	public static void escribirNuevoArchivo (String nombreArchivo, ArrayList<Alumno> lista, boolean sobreescribir) {
	
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
	
	public static void escribirArchivoMedias (String nombreArchivo, ArrayList<Alumno> lista, boolean sobreescribir) {
		try {
			FileWriter archivoEscritura = new FileWriter(nombreArchivo, sobreescribir);//si ponemos true se situa al final del archivo y false hace uno nuevo y pisa si existe uno anterior. Si no se pone se creara el archivo EmpleadoEscritura.txt y si existe lo pisa.
			for(Alumno i: lista) {
				int notasSumadas = i.getMatematicas() + i.getLengua() + i.getFisica() + i.getQuimica() + i.getIngles();
				double mediaNotas = (double)notasSumadas/5;
				archivoEscritura.write(i.getGrupo() + ";" + i.getNombre() + ";" + i.getMatematicas() + ";" + i.getLengua()  
				+ ";" + i.getFisica() + ";" + i.getQuimica() + ";" + i.getIngles() + "; NOTA MEDIA: " + mediaNotas + "\n");
			}
			archivoEscritura.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static double sacarMedia(ArrayList<Alumno> lista, int asignatura) {
		double devolucion = 0;
		if(asignatura == 1) {
			for(Alumno i: lista) {
				devolucion += i.getMatematicas();
				
			}
			devolucion = devolucion/lista.size();
		}else if(asignatura == 2) {
			for(Alumno i: lista) {
				devolucion += i.getLengua();
				
			}
			devolucion = devolucion/lista.size();
		}else if(asignatura == 3) {
			for(Alumno i: lista) {
				devolucion += i.getFisica();
				
			}
			devolucion = devolucion/lista.size();
		}else if(asignatura == 4) {
			for(Alumno i: lista) {
				devolucion += i.getQuimica();
				
			}
			devolucion = devolucion/lista.size();
		}else if(asignatura == 5) {
			for(Alumno i: lista) {
				devolucion += i.getIngles();
				
			}
			devolucion = devolucion/lista.size();
		}
		return devolucion;
	}
	
	public static String mostrarMejoresNotas(ArrayList<Alumno> lista) {
		String devolucion = "";
		Collections.sort(lista, new OrdenarPorNotaNombre());
		for(int i = 0; i < 10; i++) {
			devolucion += "Nota: " + lista.get(i).getMatematicas() + " nombre: " + lista.get(i).getNombre() + "\n";
		}
		return devolucion;
	}
	

}
