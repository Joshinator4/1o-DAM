/*Se nos plantea la posibilidad de hacer un programa que calcule la calificación de un examen a partir de las preguntas acertadas, falladas y no contestadas.

Implementa un programa en Java que calcule la nota de un examen de tipo test de 20 preguntas.

El programa debe solicitar por teclado dos números enteros: número de preguntas acertadas y número de preguntas falladas y a partir de ahí calcular la nota final teniendo en cuenta que cada fallo
restará la mitad de un acierto, y que obviamente las preguntas sin contestar ni restarán ni sumarán. La nota final deberá estar entre 0 y 10. Si la suma del número de preguntas acertadas y el número
de preguntas falladas supera el total de preguntas (20), entonces no se llevará a cabo ningún cálculo y se mostrará por pantalla el mensaje "Datos erróneos". 
Si los datos son correctos deberán entonces calcularse la calificación no numérica del examen y mostrarse por pantalla ambas calificaciones: la cuantitativa (numérica) y la cualtiativa (no numérica).
 * 
 */
package ejemploscompuestointermedio;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// Llamamos a escaner y declaramos variables:
		
		Scanner teclado = new Scanner(System.in);
		
		int correctas, incorrectas;
		double operacionIncorrectas, operacionTotal, operacionNota=0;
		
		System.out.println("Introduzca nº de preguntas acertadas: ");
		
		correctas = teclado.nextInt();
		
		System.out.println("Introduzca nº de preguntas no acertadas: ");
		
		incorrectas = teclado.nextInt();
		
		//creamos condición que si la suma de las pregurtas acertadas y falladas son mas de 20 salga el mensjae de datos erróneos,
		//en caso contrario (else) realizamos operaciones y generamos otra condicón (if) con sus repesctivos else if indentados para poder representar las
		//notas con su valor numérico y su valor cualitativo.
		
		if ((correctas +incorrectas) > 20 ) {
			
			System.out.println("Datos erróneos");
		}
		
		else {
			//operación de las no acertadas resta 0,5 por cada una
			
			operacionIncorrectas = (incorrectas * 0.5);
			
			//restamos la operacion anterior a las prguntas acertadas
			
			operacionTotal = (correctas - operacionIncorrectas);
			
			//el resultado lo dividimos entre 2 para que el resultado sea una nota de 0 a 10
			
			operacionNota = (operacionTotal/2);
		
			//Como ya se ha explicado en el comentario de arriba esta condición estará indentada al else de la condición anterior
			
			if (operacionNota < 5){
				System.out.println("Nota académica: " + operacionNota + " (Insuficiente)");
				}
				
			else if (operacionNota < 6) {
				System.out.println("Nota académica: " + operacionNota + " (Aprobado)");
				}
				
			else if (operacionNota < 7){
				System.out.println("Nota académica: " + operacionNota + " (Bien)");
				}
				
			else if (operacionNota < 9) {
					System.out.println("Nota académica: " + operacionNota + " (Notable)");
				}
			
			else {
					System.out.println("Nota académica: " + operacionNota + " (Sobresaliente)");
					}
			//Esta es la forma anterior ralizada en casa. Funciona pero es más lógico realizarlo como se ha quedado hecho
			//if (operacionNota >= 5 && operacionNota <6){
			//System.out.println("Nota académica: " + operacionNota + " (Aprobado)");
			//}
			//else if (operacionNota >= 6 && operacionNota < 7) {
			//System.out.println("Nota académica: " + operacionNota + " (bien)");
			//}
			//else if (operacionNota >= 7 && operacionNota < 9) {
			//System.out.println("Nota académica: " + operacionNota + " (Notable)");
			//}
			//else if (operacionNota >= 9) {
			//System.out.println("Nota académica: " + operacionNota + " (Sobresaliente)");
			//}
			//else if (operacionNota < 5){
			//System.out.println("Nota académica: " + operacionNota + " (Insuficiente)");
			//}
		}
		
	}

}
