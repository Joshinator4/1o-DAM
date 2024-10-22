/*Ejercicio B5 - Diccionario
 * Implementa un programa que cree la carpeta ‘Diccionario’ con tantos archivos como letras del
 * abecedario (A.txt, B.txt… Z.txt). Introducirá en cada archivo las palabras de ‘diccionario.txt’ que
 * comiencen por dicha letra.
 */
package ejercicioB5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class PrincipalB5 {

	public static void main(String[] args) {
		
		File archivo = new File("Documentos/diccionario");
		File archivo2 = new File("Documentos/diccionario.txt");
		anhadirDocumento(archivo);
		lectorEscritor(archivo, archivo2);
		
		//PREGUNTAR AQUI. EN DICCIONARIO.TX HAY ALGUNAS PALABRAS QUE EMPIEZAN CON - (GUION). ES UN ERROR?? 

	}
	
	//Este método crea un directorio si se puede.
	public static void anhadirDocumento(File archivo) {
		archivo.mkdir();
	}
	
	//Este método recibe un objeto file con la ruta donde generar cada archivo con la letra. Hace un bucle para recorrer las posiciones del codigo Asci 
	//  A-Z son las posiciones 65-90. Genera un String (nombreRuta) con la ruta y el archivo a crear. que es la letra de la 
	// Por cada
	public static void anhadirDocumentoAZYEscribir(File archivo, ArrayList<String> lista) {
		String nombreRuta;
		FileWriter escritor;
		for(int i = 65; i <=90; i++) {
			nombreRuta = archivo.getParentFile()+ "/" + archivo.getName() + "/" + Character.toString((char)i) + ".txt";
			System.out.println(nombreRuta);
			File archivoIntroducir = new File(nombreRuta);
			try {
				escritor = new FileWriter(archivoIntroducir);
				for(String j: lista) {
					//Aqui se filtra para que cada palabra que empiece con la correspondiente letra vaya a su archivo correspondiente.
					//se filta por letra mayuscula (65-90) y por letra minúscula (97-122) por eso se suma 32 a i.
					if(j.charAt(0) == Character.toString((char)i).charAt(0) || j.charAt(0) == Character.toString((char)(i+32)).charAt(0)) {
						escritor.write(j + "\n");
					}
				}
				escritor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
				
		}
	}
	
	//este metodo recibe la ruta del archivo de donde deber leer(archivoLeer) y la ruta donde debe escribir(archivoRutaEscribir). Genera una un arrayList llamando
	//método lectorArchivos y lo mete en el arrayList(listaPalabras). Luego llama al método anhadirDocumentoAZYEscribir que creará los archivos en la ruta y escribirá las
	//palabras que empiezan por cada letra en su respectivo archivo.
	public static void lectorEscritor(File archivoRutaEscribir, File archivoLeer) {
		ArrayList<String> listaPalabras = new ArrayList<>();
		listaPalabras.addAll(lectorArchivos(archivoLeer));
		System.out.println(listaPalabras.toString());
		anhadirDocumentoAZYEscribir(archivoRutaEscribir, listaPalabras);
		
	}
	
	//Este método lee de un archivo, genera y devuelve un ArrayList con todos los datos del archivo
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
	

}
