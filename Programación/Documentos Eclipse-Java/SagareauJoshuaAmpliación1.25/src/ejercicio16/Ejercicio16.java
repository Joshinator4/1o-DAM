/*16. Escribir un programa en Java para calcular la superficie y el volumen de una esfera a
 * partir del valor del radio (supóngase que es un valor positivo). 
 */
package ejercicio16;

import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {
		// Superficie esfera: 4*PI*r^2 pi=Math.PI Volumen de esfera: 4/3*PI*r^3
		// Traemos la función Scanner y creamos variables.
		
		Scanner teclado = new Scanner(System.in);
		
		double radio, volumenE, superficieE, resultadodiv;
		
		//Solicitamos el radio de la esfera al usuario.
		
		System.out.println("Introduzca el radio de la esfera en CM: ");
		
			radio = teclado.nextDouble();
		
			//haremos la operacion, aplicando la fórmula, para hayar la superficie. Utilizamos Math.PI para usar el numero PI y Math.pow para el exponente
		
			superficieE = (4*Math.PI*Math.pow(radio,2));
			
			//haremos la operacion, aplicando la fórmula, para hayar el volumen. Utilizamos Math.PI para usar el numero PI y Math.pow para el exponente
			
			volumenE = (double)4/3*Math.PI*(Math.pow(radio, 3));
			
			//Por último mostramos en pantalla los resultados
		
		System.out.println("La superficie de la esfera es: " + superficieE + " CM" + "\n" + "El volumen de la esfera es: " + volumenE + " CM");
		
		

	}

}
