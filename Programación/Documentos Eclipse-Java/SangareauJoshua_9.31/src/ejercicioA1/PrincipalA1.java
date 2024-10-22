package ejercicioA1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrincipalA1 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		String nombreArchivo = "";
		boolean salir = false;
		File archivo;
		
		do {
			System.out.println("Introduzca el nombre del archivo para mostrar su información o introduzca intro para salir");
			nombreArchivo = teclado.nextLine();
			if(nombreArchivo.isEmpty()) {
				salir = true;
			}else {
				archivo = new File(nombreArchivo);
				try {
					muestraInfoRuta(archivo);
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
			}
			
		}while(salir == false);
		
		System.out.println("Se ha salido del programa.");
	}
	
	public static void muestraInfoRuta(File ruta) throws FileNotFoundException {
		if(ruta.isFile()) {
			System.out.println("El nombre del archivo es: " + ruta.getName());
		}else if(ruta.isDirectory()) {
			System.out.println("Contenido de " + ruta.getAbsolutePath() + " :");
			File[] lista = ruta.listFiles();
			String directorios = "", archivos = ""; 
			for(int i = 0; i < lista.length; i++) {
				if(lista[i].isFile()) {
					archivos += "A" + lista[i].getName() + "\n";
				}else {
					directorios += "*" + lista[i].getName() + "\n";
				}
			}
			System.out.println(directorios + archivos);
		}else if (ruta.exists() == false) {
			throw new FileNotFoundException("ERROR: El archivo con el nombre especificado no existe");
		}
	}
}
