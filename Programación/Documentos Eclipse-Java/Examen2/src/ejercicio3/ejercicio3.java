package ejercicio3;

/*objetivo: crear un programa que: 
 * 1 muestra la provincia con la tasa media mensual más alta
 * 2 esta función calcula el día con la tasa de Covid más baja para cada provincia
 * 3 calcula para cada día del mes la provincia con la tasa de Covid más baja
 *autor: Francisco Javier Martín-Lunas Escobar
 *fecha: 29/11/2022*/
public class ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int NUMPROV=3;
		final int DIASMES=30;
		String provincia [] = new String [NUMPROV];
		int tasaCovid [][] = new int [NUMPROV][DIASMES];
		provincia[0] = "Málaga";
		provincia[1] = "Cádiz";
		provincia[2] = "Córdoba";
		
		for (int i=0; i < NUMPROV; i++) {
			for (int j=0; j < DIASMES; j++) {
				tasaCovid[i][j] = (int) (Math.random()*(500-100));

			}
		}
		mediaMesMasAlta (tasaCovid, provincia);
		diaTasaMasBaja (tasaCovid, provincia);
		diaTasaMasBajaEntreProvincias (tasaCovid, provincia);
	}
	//esta función muestra la provincia con la tasa media mensual más alta
	public static void mediaMesMasAlta (int tasaCovid [][], String provincia[]) {
		int media, cont, mediaMasAlta=0;
		for (int i=0; i < 3; i++) {
			media = 0;
			cont = 0;
			for (int j=0; j < 30; j++) {
				media = cont + tasaCovid[i][j];

			}
			media = media / 30;
			if(mediaMasAlta < media) {
				mediaMasAlta = media;
			}
		}
		for (int i=0; i < 3; i++) {
			media = 0;
			cont = 0;
			for (int j=0; j < 30; j++) {
				media = cont + tasaCovid[i][j];

			}
			media = media / 30;
			if(mediaMasAlta == media) {
				System.out.println("La media más alta es de "+provincia[i]+" y es de "+mediaMasAlta);
				break;
			}
		}
	}
	//esta función calcula el día con la tasa de Covid más baja para cada provincia
	public static void diaTasaMasBaja (int tasaCovid [][], String provincia[]) {
		int diaTasaMasBaja, dia;
		for (int i=0; i < 3; i++) {
			diaTasaMasBaja = tasaCovid[i][0];
			dia = tasaCovid[i][0];
			for (int j=0; j < 30; j++) {
				if (diaTasaMasBaja > tasaCovid[i][j]) {
					diaTasaMasBaja = tasaCovid[i][j];
					dia = j;
				}
			}
			System.out.println("La día con la tasa de covid más baja de "+provincia[i]+" es el día "+dia);
		}
	}
	//esta función calcula para cada día del mes la provincia con la tasa de Covid más alta
	public static void diaTasaMasBajaEntreProvincias (int tasaCovid [][], String provincia[]) {
		int diaTasaMasBaja, provinciaMasBaja;
		for (int j=0; j < 30; j++) {
			diaTasaMasBaja = tasaCovid[0][j];
			for (int i=0; i < 3; i++) {
				if (diaTasaMasBaja < tasaCovid[i][j]) {
					diaTasaMasBaja = tasaCovid[i][j];
					provinciaMasBaja = i;
				}
			}
			for (int i=0; i <= 2; i++) {
				if (diaTasaMasBaja == tasaCovid[i][j]) {
					provinciaMasBaja = i;
					System.out.println("La provincia con el día con la tasa de covid más baja en el día "+(j+1)+" es "+provincia[diaTasaMasBaja]);

				}
			}
		}
	}

}
