/*
 * El índice de masa corporal (IMC) se define como el peso en kilogramos dividido por el cuadrado de la altura en metros.

Fórmula del IMC
peso(KG)/altura(M)^2
Diagnóstico según IMC
Valor de IMC	Diagnóstico
< 16	Criterio de ingreso en hospital.
de 16 a 17	Infrapeso.
de 17 a 18	Bajo peso.
de 18 a 25	Peso normal (saludable).
de 25 a 30	Sobrepeso (obesidad de grado I).
de 30 a 35	Sobrepeso crónico (obesidad de grado II).
de 35 a 40	
Obesidad premórbida (obesidad de grado III).
>40	Obesidad mórbida (obesidad de grado IV).
Escribe un programa en Java que calcule el índice de masa corporal (IMC) de una persona e indique el estado en el que se encuentra esa persona en función del valor de IMC.
:
 */
package ejercicioCondicionalFinalDeTeoria;

import java.util.Scanner;

public class Ejercicio2CondicionalesFinalDeTeoria {

	public static void main(String[] args) {
		// Llamamos al Scanner y creamos variables.
		
		Scanner teclado = new Scanner (System.in);
		
		double peso, altura, valorIMC;
		
		System.out.println("Introduzca su peso en KG: ");
		
		peso = teclado.nextDouble();
		
		System.out.println("Introduzca su altura en M: ");
		
		altura = teclado.nextDouble();
		
		valorIMC = (peso/Math.pow(altura, 2));
		
		if (valorIMC < 16 ) {
			System.out.println("Criterio de ingreso en hospital.");
		}
		else if (valorIMC < 17) {
			System.out.println("Infrapeso.");
		}
		else if (valorIMC < 18) {
			System.out.println("Bajo peso.");
		}
		else if (valorIMC < 25) {
			System.out.println("Saludable");
		}
		else if (valorIMC < 30) {
			System.out.println("Sobrepeso (obesidad de grado I).");
		}
		else if (valorIMC < 35) {
			System.out.println("obrepeso crónico (obesidad de grado II).");
		}
		else if (valorIMC < 40){
			System.out.println("Obesidad premórbida (obesidad de grado III).");
		}
		else {
			System.out.println("Obesidad mórbida (obesidad de grado IV).");
		}

	}

}
