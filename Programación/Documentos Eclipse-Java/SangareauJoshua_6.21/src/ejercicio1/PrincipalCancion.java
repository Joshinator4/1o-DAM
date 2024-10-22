package ejercicio1;

public class PrincipalCancion {

	public static void main(String[] args) {
		
		try {
			Cancion cancion1 = new Cancion(null, "");
		}catch (IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}
		
		
		//PREGUNTAR AQUI SI ES ESTO LO QUE SE PIDE EN EL EJERCICIO
		try {
			//instanciando 2 objetos de tipo canción
			Cancion cancion2 = new Cancion();
			//poniendo titulo a la cancion1
			cancion2.ponTitulo("No woman no cry");
			//clonar la cancion2
			Cancion cancion3 = new Cancion(cancion2);
			//NO LO PIDE PERO YO AQUI CAMBIO EL AUTOR DE LA CANCION QUE SE HA CLONADO DE LA ANTERIOR
			cancion3.ponAutor("Bob Marley");
			//crear una variable de refencia a la cancion clonada
			Cancion cancion4 = cancion3;
			//cambiando el autor de la variable refencia
			cancion4.ponAutor("pepito");
			//cancion3.ponAutor(cancion4.dameAutor());
			System.out.println("\nCanción2: " + cancion2.toString() + "\nCanción3: " + cancion3.toString() + "\nCanción4: " + cancion4.toString());
		}catch (IllegalArgumentException excepcion2) {
			System.out.println(excepcion2.getMessage());
		}
	}

}
