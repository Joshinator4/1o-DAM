package ejercicio2;

import ejercicio1.Cancion;

public class PrincipalCD {

	public static void main(String[] args) {
		try {
			Cancion cancion1 = new Cancion("hola", "hola");
			Cancion cancion2 = new Cancion("adios", "adios");
			Cancion cancion3 = new Cancion("pepe", "pepe");
			Cancion cancion4 = new Cancion("lalala", "lalala");
			Cancion cancion5 = new Cancion();
			Cancion cancion6 = new Cancion();

			CD unCd = new CD();
			unCd.agrega(cancion1);
			unCd.agrega(cancion2);
			unCd.agrega(cancion3);
			System.out.println("Mostrando el numero de canciones que tiene el CD: " + unCd.numeroCanciones());
			unCd.elimina(2);
			System.out.println("Mostrando el numero de canciones que tiene el CD: " + unCd.numeroCanciones());
			System.out.println(unCd.dameCancion(2));
			CD otroCd = new CD (unCd);
			otroCd.agrega(cancion4);
			otroCd.agrega(cancion5);
			System.out.println(unCd.toString());
			System.out.println(otroCd.toString());

		} catch (IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		} catch (IllegalStateException excepcion2) {
			System.out.println(excepcion2.getMessage());
		}

	}
}
