package ejercicio2;

import java.util.HashSet;

public class Inventario {
	
	protected HashSet <Mascota> guardarMascotas;
	
	public Inventario() {
		guardarMascotas = new HashSet <Mascota>();
	}
	
	public String mostrarLista() {
		String devolucion = "";
		int numeroMascota = 0;
		for(Mascota i: guardarMascotas) {
			if(i instanceof Perro) {
				devolucion += "Mascota " + numeroMascota + " Es de tipo Perro, y su nombre es: " + i.getNombre() + "\n"; 
				numeroMascota++;
			}else if(i instanceof Gato) {
				devolucion += "Mascota " + numeroMascota + " Es de tipo Gato, y su nombre es: " + i.getNombre() + "\n";
				numeroMascota++;
			}else if(i instanceof Loro) {
				devolucion += "Mascota " + numeroMascota + " Es de tipo Loro, y su nombre es: " + i.getNombre() + "\n"; 
				numeroMascota++;
			}else if(i instanceof Canario) {
				devolucion += "Mascota " + numeroMascota + " Es de tipo Canario, y su nombre es: " + i.getNombre() + "\n"; 
				numeroMascota++;
			}
		}
		if(devolucion.isEmpty()) {
			devolucion = "No hay mascotas en el inventario";
		}
		return devolucion;
	}
	
	public String mostrarDatosMascota(String nombreIntroducido) {
		String devolucion="";
		for(Mascota i: guardarMascotas) {
			if(i.getNombre().equals(nombreIntroducido)) {
				System.out.println(i.muestra());
			}
		}
		if(devolucion.isEmpty()) {
			devolucion = "No existe esa mascota con ese nombre en el inventario";
		}
		return devolucion;
		
	}
	
	public String mostrarTodosDatosMascotas() {
		String devolucion="";
		for(Mascota i: guardarMascotas) {
			System.out.println(i.muestra()); 
		}
		if(devolucion.isEmpty()) {
			devolucion = "No hay mascotas en el inventario";
		}
		return devolucion;
		
	}
	
	public void insertarMascota(Mascota mascota) {
		guardarMascotas.add(mascota);
	}
	
	public void eliminarMascota(String nombreMascota) {
		for(Mascota i: guardarMascotas) {
			if(i.getNombre().equals(nombreMascota)) {
				guardarMascotas.remove(i);
			}
		}
	}
	
	public void vaciarMascota() {
		guardarMascotas.clear();
	}
	
	
	
}
