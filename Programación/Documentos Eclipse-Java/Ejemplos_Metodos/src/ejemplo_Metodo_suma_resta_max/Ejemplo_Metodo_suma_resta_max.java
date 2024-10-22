package ejemplo_Metodo_suma_resta_max;

import java.util.Scanner;

public class Ejemplo_Metodo_suma_resta_max {

	public static void main(String[] args) {
		double a, b;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el numero a");
		a = teclado.nextInt();
		System.out.println("Introduzca el numero a");
		b = teclado.nextInt();
		
		//Imprimimos los métodos 
		System.out.println( suma(a,b));
		System.out.println( resta(a,b));
		System.out.println( maximo(a,b));

	}
	
	//Generamos métodos que hagan las operaciones 
	public static double suma (double x, double y) {
		return x + y;
	}
	public static double resta (double x, double y) {
		return x - y;
	}
	public static double maximo (double x, double y) {
		double max=0;
		if(x >= y) {
			max = x;
		}else {
			max = y;
		}
		return max;
	}
	
}
