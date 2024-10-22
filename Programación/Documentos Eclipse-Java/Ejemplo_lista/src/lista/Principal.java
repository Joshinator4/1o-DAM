package lista;

import java.util.LinkedList;

public class Principal {

	public static void main(String[] args) {

		Persona persona1 = new Persona("2345", "pepe", 30);
		Persona persona2 = new Persona("2346", "carlos", 34);
		Persona persona3 = new Persona("2347", "marcos", 10);
		
		LinkedList <Persona> lista = new LinkedList<>();
		lista.add(persona1);
		lista.add(persona2);
		lista.add(persona3);
		
		for(Persona i: lista) {
			System.out.println(i.toString());
		}
		System.out.println("Cantidad de objetos Persona en la lista:" + lista.size());
		persona1.setNombre("Juan");
		for(Persona i: lista) {
			System.out.println(i.toString());
		}
		lista.get(0).setNombre("Juanito");
		for(Persona i: lista) {
			System.out.println(i.toString());
		}
		Persona persona4 = lista.remove(1);
		for(Persona i: lista) {
			System.out.println(i.toString());
		}
	}

}
