package ejercicioA5;

import java.io.File;

public class PrincipalA5 {

	public static void main(String[] args) {
		File archivo = new File("DOCS/Alfabeto");
		borraTodo(archivo);
		archivo = new File("DOCS/MisCosas/FOTOS");
		borraTodo(archivo);
		archivo = new File("DOCS/MisCosas/LECTURAS");
		borraTodo(archivo);
		archivo = new File("DOCS/MisCosas");
		borraTodo(archivo);
		archivo = new File("DOCS");
		borraTodo(archivo);
		/*SE PRUEBA QUE BORRE: FUNCIONA CORRECTAMENTE. SE VUELVE A DESCARGAR LA CARPETA DOCUMNETOS ORIGINAL PARA PODER PROBAR TODOS LOS EJERCICIOS*/
	}
	
	public static boolean borraTodo(File archivo) throws IllegalArgumentException {
		boolean devolucion=false;
		
		do {
			if(archivo.isFile()) {
				devolucion = true;
				archivo.delete();
			}else if(archivo.isDirectory()) {
				File[] archivosGuardar = archivo.listFiles();
				for(int i = 0; i < archivosGuardar.length; i++) {
					System.out.println(archivosGuardar[i].toString());
					System.out.println(archivosGuardar[i].delete());
				}
				archivo.delete();
				devolucion = true;
			}else {
				devolucion = false;
				throw new IllegalArgumentException("ERROR: El archivo introducido no existe. No se ha borrado nada.");
			}
		}while(devolucion==false);
		
		return devolucion;
		
	}
}
