package ejercicio9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Cliente {
	
	private static int contadorClaves = 1;
		
	private String nombre;
	private String email;
	private ArrayList <String> listaTelefonos;
	//ESTE HASHMAP TIENE Q SER <INTEGER, PRODUCTO> o <INTEGER, STRING>LA CLAVE ES LA CANTIDAD Y EL VALOR ES EL NOMBRE DEL PRODUCTO??????
	private HashMap <Integer, Producto>compras;
	
	
	public Cliente(String nombre, String email) {
		
		this.nombre = nombre;
		this.email = email;
		this.listaTelefonos = new ArrayList<>();
		this.compras = new HashMap <>();
	} 
	
	public Cliente() {
		this("Nombre Desconocido", "emilio@emilio.es");
		
	}
	
	//PREGUNTAR AQUI SI ESTA BIEN TODO
	public void addCompra(String nombreProducto, int cantidad) {
	
		
		boolean sePuede = true;
		int cantidadAntigua=0, claveAntigua;
		Iterator <Map.Entry<Integer, Producto>> iterador = compras.entrySet().iterator();
			while (iterador.hasNext()){
				Map.Entry<Integer, Producto> entrada = iterador.next();
				if(entrada.getValue().getNombreProducto().equals(nombreProducto)) {
					cantidadAntigua = entrada.getValue().getCantidad();
					claveAntigua = entrada.getKey();
					this.compras.put(claveAntigua, new Producto(nombreProducto, (cantidadAntigua+cantidad)));
					sePuede = false;
				}

			}
		
		if(sePuede == true) {
			compras.put(contadorClaves, new Producto(nombreProducto, cantidad));
			contadorClaves++;
		}
			/*for(Entry<Integer, Producto> i: this.compras.entrySet()){
				if(i.getValue().getNombreProducto().equals(nombreProducto)) {
					this.compras.replace(i.getKey(), new Producto(nombreProducto, (i.getValue().getCantidad()+cantidad)));
				}else {
					this.compras.put(contadorClaves, new Producto(nombreProducto, cantidad));
					contadorClaves++;
				}
			}*/
		
	}

	//PREGUNTAR AQUI POR QUÉ NO ME DEJA BORRAR UNA POSICION DEL HASHMAP CON EL ITERADOR SI SE SUPONE QUE EL ITERADOR ES PARA DEJARME MODIFICAR EL HASHMAP MIENTRAS LO RECORRO
	public void eliminarProducto(String nombreProducto) {
		int key = 0;
		Iterator <Map.Entry<Integer, Producto>> iterador = compras.entrySet().iterator();
		
		while (iterador.hasNext()){
			Map.Entry<Integer, Producto> entrada = iterador.next();
			if(entrada.getValue().getNombreProducto().equals(nombreProducto)) {
				key=entrada.getKey();
				//this.compras.remove(key);
			}

		}
		if(key!=0) {
			this.compras.remove(key);
		}
		
	}
	
	public ArrayList<String> verProductos() {
		ArrayList<String> devolucion = new ArrayList<String>();
		Iterator <Map.Entry<Integer, Producto>> iterador = compras.entrySet().iterator();
		do{
			Map.Entry<Integer, Producto> entrada = iterador.next();
			devolucion.add(entrada.getValue().getNombreProducto());

		}while (iterador.hasNext());
		
		/*for(Map.Entry<Integer, Producto> i: this.compras.entrySet()){
			devolucion.add(i.getValue().toString());
		}*/
		return devolucion;
		
	}
	
	public int totalUnidades() {
		int devolucion = 0;
		for(Entry<Integer, Producto> i: this.compras.entrySet()){
			devolucion += i.getValue().getCantidad();
			
		}
		return devolucion;
	} 
	
	//PREGUNTAR AQUI SI EL CONTAIS COGERIA PARTE DEL TELEFONO O HAY QUE HACER UN PATRON O ALGO ASI
	public void addTelefono(String telefono) throws IllegalArgumentException{
		
		if(this.listaTelefonos.contains(telefono)) {
			throw new IllegalArgumentException("ERROR: El telefono introducido ya existe");
		}else {
			this.listaTelefonos.add(telefono);
		}
		
	}
	
	
	public String getTelefono(int indice) {
		String devolucion;
		devolucion = listaTelefonos.get(indice);
		return devolucion;
		
	}
	
	public ArrayList <String> buscarTelefono(String telefono) {
		ArrayList <String> listaTelefonosMetodo = new ArrayList <>();
		for(String i: listaTelefonos) {
			if(i.contains(telefono)) {
				listaTelefonosMetodo.add(i);
			}
		}
		return listaTelefonosMetodo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
