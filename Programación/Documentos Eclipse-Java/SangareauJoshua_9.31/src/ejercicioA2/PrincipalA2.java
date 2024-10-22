package ejercicioA2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PrincipalA2 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		String nombreArchivo = null;
		int opcionDeseada;
		boolean salir = false;
		File archivo;
		
		do {
			System.out.println("Introduzca el nombre del archivo para mostrar su información o introduzca intro para salir");
			nombreArchivo = teclado.nextLine();
			System.out.println("Introduzca 1 para mostrar mas informacion o 2 para mostrar solo nombre");
			opcionDeseada = teclado.nextInt();
			if(nombreArchivo.isEmpty()) {
				salir = true;
			}else {
				archivo = new File(nombreArchivo);
				try {
					if(opcionDeseada == 1) {
						muestraInfoRuta(archivo, true);
					}else {
						muestraInfoRuta(archivo, false);
					}
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
			}
			
		}while(salir == false);
		
		System.out.println("Se ha salido del programa.");
	}
	
	public static void muestraInfoRuta(File ruta, boolean info) throws FileNotFoundException {
		if(ruta.isFile()) {
			System.out.println("El nombre del archivo es: " + ruta.getName());
		}else if(ruta.isDirectory()) {
			System.out.println("Contenido de " + ruta.getAbsolutePath() + " :");
			File[] lista = ruta.listFiles();
			Arrays.sort(lista);
			String directorios = "", archivos = ""; 
			for(int i = 0; i < lista.length; i++) {
				if(lista[i].isFile() && info == true) {
					archivos += "Nombre: A" + lista[i].getName() + " tamaño en bytes: " + lista[i].length() + " ultima modificación: " + lista[i].lastModified() + " milisegundos o " + (((lista[i].lastModified()/1000)/60)/60)/24 + " dias" +  "\n";
				}else if(lista[i].isFile() && info == false) {
					archivos += "Nombre: A" + lista[i].getName() + "\n";
				}else if(lista[i].isDirectory() && info == true) {
					directorios += "Nombre: *" + lista[i].getName() + " tamaño en bytes: " + lista[i].length() + " ultima modificación" + lista[i].lastModified() + " milisegundos o " + (((lista[i].lastModified()/1000)/60)/60)/24 + " dias" + "\n";
				}else {
					directorios += "Nombre: *" + lista[i].getName() + "\n";
				}
			}
			System.out.println(directorios + archivos);
		}else if (ruta.exists() == false) {
			throw new FileNotFoundException("ERROR: El archivo con el nombre especificado no existe");
		}		
		
	}
}
