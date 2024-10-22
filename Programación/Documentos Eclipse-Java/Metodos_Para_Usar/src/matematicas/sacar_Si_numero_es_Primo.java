package matematicas;

public class sacar_Si_numero_es_Primo {
	public static boolean esPrimo(int x) {
		boolean primo = true;
		for (int i = 2; i < x; i++) {
			if (x % i == 0) {
				primo = false;
			} 
		}
		return primo;

	}
}
