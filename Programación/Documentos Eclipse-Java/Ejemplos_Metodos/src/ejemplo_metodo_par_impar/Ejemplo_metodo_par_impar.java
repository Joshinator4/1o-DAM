package ejemplo_metodo_par_impar;

import java.util.Scanner;

public class Ejemplo_metodo_par_impar {

	public static void main(String[] args) {
		
		// Variables
		double numero1, numero2;
		boolean par;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("A continuación le pediremos 2 números, si el primero es par la operacion será una suma, si es un número impar la operación será una resta.");
		System.out.println("Introduzca un número: ");
		numero1 = teclado.nextDouble();
		
		System.out.println("Introduzca el segundo número:");
		numero2 = teclado.nextDouble();
		
		//esta variable se hace para meter el resultado del método esPar y luego usarla para el método operacion
		par = esPar(numero1,numero2);
		
		System.out.println("El resultado es: ");
		System.out.println(operacion(numero1, numero2, par));
		
	}
	
	//creamos un metodo para controlar si es par o no devolviendo un boolean
	public static boolean esPar(double x, double y) {
		boolean par;
		if (x % 2 == 0) {
			par = true;
		} else {
			par = false;
		}
		return par;
	}
	
	//creamos un metodo para realizar la operacion con 3 parámetros (primer y segundo numero y el boolean generado por el otro método) se controlará si es true o false el boolean para realizar
	//una operacion u otra.
	public static double operacion(double x, double y, boolean z) {
		double resultado = 0;
		if(z == true) {
			resultado = x + y; 
		} else {
			resultado = x - y; 
		}
		return resultado;
	}
	
}
