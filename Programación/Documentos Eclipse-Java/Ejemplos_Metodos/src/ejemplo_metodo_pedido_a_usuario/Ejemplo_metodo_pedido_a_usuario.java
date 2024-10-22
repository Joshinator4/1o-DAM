package ejemplo_metodo_pedido_a_usuario;

import java.util.Scanner;

public class Ejemplo_metodo_pedido_a_usuario {
	public static void main(String[] args) {
		
		int funcionIntroducida;
		double numero1, numero2;
	    Scanner teclado = new Scanner(System.in);
	    
	    System.out.println("Introduzca la funcion a realizar: 1-suma. 2-resta. 3-multiplicar. 4-dividir");
	    funcionIntroducida = teclado.nextInt();
	    
	    System.out.println("Introduzca el primer número");
	    numero1 = teclado.nextDouble();
	    
	    System.out.println("Introduzca el primer número");
	    numero2 = teclado.nextDouble();
	    
	    
	    //Imprimimos por pantalla el resultado del metodo con los 2 numeros y la función a realizar (suma, resta, multiplicación o división)
	    System.out.println("El resultado de su operación es: " + operacion(numero1, numero2, funcionIntroducida));
	}
	
	
	//Generamos un método que haga una de las funciones segun z (funcion introducida) se puede hacer con switch tambien
	public static double operacion(double x, double y, int z) {
		double resultado = 0;
		if(z == 1) {
			resultado = x + y;
		}else if(z == 2) {
			resultado = x - y;
		}else if(z == 3) {
			resultado = x * y;
		}else {
			resultado = x / y;
		}
		return resultado;
	}
}
