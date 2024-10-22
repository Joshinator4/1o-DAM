package ejercicio2;

public class PrincipalCafetera {

	public static void main(String[] args) {
		//se genera varaible contador para saber el numero de tazas que se han llenado
		int tazasLlenas=1, numeroTaza = 1;
		double faltaCafe = 0;
		
		//Una cafetera vacía que se llene con 250cc y que sirva tazas de café hasta que se agote. las tazas tienen 60 c.c
		try {
			Cafetera cafetera1 = new Cafetera ();
			cafetera1.agregarCafe(250);
			do {
				System.out.print("Sirviendo la taza: " + tazasLlenas + " ");
				cafetera1.servirTaza(60);
				tazasLlenas++;
				System.out.print("Se ha llenado correctamente\n");
			}while(cafetera1.getActual() > 0 );
						
		}catch(IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}
		
		//Una cafetera llena y que sirva 50 cafés de 50 cc cada uno. Llenar la cafetera cada vez
		//que haga falta informando al usuario.
		
		Cafetera cafetera2 = new Cafetera (565, 485);
		do {
			try {
				if(cafetera2.getActual() == 0) {
				System.out.println("Se va a rellenar la cafetera con: 530c.c");
				cafetera2.llenarCafetera(530);
				System.out.println("Se va llenar el faltante de la taza numero" + numeroTaza);
				cafetera2.servirTaza((int)faltaCafe);
				numeroTaza++;
				}
				System.out.println("Llenando la taza: " + numeroTaza);
				faltaCafe = cafetera2.servirTaza(50);
				numeroTaza++;
									
			}catch(IllegalArgumentException excepcion2) {
				System.out.println(excepcion2.getMessage());
			}
		}while(numeroTaza < 51);

	}

}
