/* Ejercicio B1 - Máximo y mínimo
 * Implementa un programa que muestre por pantalla los valores máximos y mínimos del archivo
 * ‘numeros.txt’.
 */
package ejercicioB1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class PrincipalB1 {

	public static void main(String[] args) {
		
		File archivo = new File("Documentos/numeros.txt");
		ArrayList<Integer> listaNumeros = new ArrayList<>();
		
		listaNumeros.addAll(lectorArchivos(archivo));
		Collections.sort(listaNumeros);
		System.out.println("Mostrando el valor minimo del archivo numeros.txt: " + listaNumeros.get(0));
		System.out.println("Mostrando el valor máximo del archivo numeros.txt: " + listaNumeros.get(listaNumeros.size()-1));
		
	}

	public static LinkedList<Integer> lectorArchivos(File archivo) {
		LinkedList<Integer> devolucion = new LinkedList<>();
		try {
			Scanner lector = new Scanner (archivo);
			while(lector.hasNextLine()) {
				String linea = lector.nextLine();
				Integer numero = Integer.parseInt(linea);
				devolucion.add(numero);
		
			}
			lector.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return devolucion;
	}
}
