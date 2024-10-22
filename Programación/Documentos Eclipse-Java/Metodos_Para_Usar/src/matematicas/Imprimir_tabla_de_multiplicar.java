package matematicas;

public class Imprimir_tabla_de_multiplicar {

	public static void imprimirTablaMultiplicar (int x) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(x + " multiplicado por " + i + " = " + x*i);
		}
	}
}