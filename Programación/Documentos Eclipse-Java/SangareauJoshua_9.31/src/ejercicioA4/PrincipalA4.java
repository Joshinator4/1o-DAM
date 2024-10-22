package ejercicioA4;

import java.io.File;
import java.nio.charset.Charset;

public class PrincipalA4 {

	public static void main(String[] args) {


		/*File archivo = new File ("DOCS/MisCosas");
		anhadirDocumento(archivo);
		archivo = new File ("DOCS/Alfabeto");
		anhadirDocumento(archivo);
		archivo = new File ("DOCS/FOTOS");
		cambiarNombre(archivo, "DOCS/MisCosas/FOTOS");
		archivo = new File ("DOCS/LECTURAS");
		cambiarNombre(archivo, "DOCS/MisCosas/LECTURAS");*/
		
		File archivo = new File("DOCS/Alfabeto");
		anhadirDocumentoAZ(archivo);

	}
	
	public static void anhadirDocumento(File archivo) {
		archivo.mkdir();
	}
	
	public static void cambiarNombre(File archivo, String nombre) {
		File archivoNuevo = new File(nombre);
		if(!archivo.renameTo(archivoNuevo)) {
			throw new IllegalArgumentException("ERROR: no existe la ruta");
		}		
	}
	//65-90
	public static void anhadirDocumentoAZ(File archivo) {
		String nombre;
		for(int i = 65; i <=90; i++) {
			nombre = archivo.getParentFile()+ "/" + archivo.getName() + "/" + Character.toString((char)i);
			System.out.println(nombre);
			File archivoIntroducir = new File(nombre);
			anhadirDocumento(archivoIntroducir);
			
		}
	}
}
