package ejercicioA3;

import java.io.File;

public class PrincipalA3 {
	
	public static void main(String[] args) {
		
		File archivo = new File("Documentos");
		/*cambiarNombre(archivo, "DOCS");
		archivo = new File("DOCS/Fotografias");
		cambiarNombre(archivo, "DOCS/FOTOS");
		archivo = new File("DOCS/Libros");
		cambiarNombre(archivo, "DOCS/LECTURAS");
		//COMO RECORRER TODOS LOS ARCHIVOS */
		archivo = new File("DOCS/FOTOS");
		quitarExtension(archivo);
		archivo = new File("DOCS/LECTURAS");
		quitarExtension(archivo);
		
		
	}
	
	public static void cambiarNombre(File archivo, String nombre) {
		File archivoNuevo = new File(nombre);
		if(!archivo.renameTo(archivoNuevo)) {
			throw new IllegalArgumentException("ERROR: no existe la ruta");
		}
		
	}
	
	public static void quitarExtension(File archivo) {
		File [] arrayArchivos = archivo.listFiles();
		for(int i = 0; i < arrayArchivos.length; i++) {
			String nombre = arrayArchivos[i].getName();
			nombre = nombre.substring(0, nombre.lastIndexOf("."));
			cambiarNombre(arrayArchivos[i], nombre);
		}
	}
}
