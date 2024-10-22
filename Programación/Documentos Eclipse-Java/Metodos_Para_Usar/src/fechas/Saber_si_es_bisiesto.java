package fechas;

public class Saber_si_es_bisiesto {

	public static boolean saberSiEsBisiesto (int x) {
		boolean bisiesto = false;
		if ((x % 4 == 0) && ((x % 100 != 0) || (x % 400 == 0))) {
			bisiesto = true;
		}
		else {
			bisiesto = false;
		}
		return bisiesto;
			
	}
}
