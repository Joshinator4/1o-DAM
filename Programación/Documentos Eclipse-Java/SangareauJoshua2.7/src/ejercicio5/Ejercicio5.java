/*Ejercicio5(2 puntos)
Vamos a realizar una calculadora:
 El programa solicitará al usuario dos valores (num1 y num2)
 Posteriormente solicitará la operación a realizar con un menú de selección
 El programa realizará con los dos valores la operación que ha indicado el usuario y
mostrará el resultado por pantalla.
Introduzca el valor 1:
Introduzca el valor 2:
Indique la operación que quiere realizar (Inserte un número):
(1) Suma
(2) Resta
(3) Multiplicación
(4) División
-----------------------------
Resultado:

 */
package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		//  Llamamos al Scanner y creamos variables.
		
		Scanner teclado = new Scanner (System.in);
		
		byte operacion;
		double num1, num2, resultado;
		
		//Pedimos datos al usuario
		
		System.out.println("Introuzca el primer valor: ");
		
		num1 = teclado.nextDouble();
		
		System.out.println("Introuzca el segundo valor: ");
		
		num2 = teclado.nextDouble();
		
		System.out.println("Introuzca el nº de operación que desea realizar:" + "\n" + "(1)Suma" + "\n" + "(2)Resta" + "\n" + "(3)Multiplicación" + "\n" + "(4)División");
		
		operacion = teclado.nextByte();
		
		//Realizamos la condición con if en este caso, según el nº introducido se hará un calculo u otro.
		//Creo que sería mas correcto con switch
		
		//if (operacion == 1) {
			
			//resultado = num1 + num2;
			
			//System.out.println("Resultado: " + resultado);
			
		//} else if (operacion == 2) {
			
			//resultado = num1 - num2;
			
			//System.out.println("Resultado: " + resultado);
			
		//} else if (operacion == 3) {
			
			//resultado = num1 * num2;
			
			//System.out.println("Resultado: " + resultado);
			
		//} else {
			
			//resultado = num1 / num2;
			
			//System.out.println("-----------------------------");
			//System.out.println("Resultado: " + resultado);
		//}
		
		//Realizamos la condición con switch en este caso, según el nº introducido se hara un calculo u otro
		
		switch (operacion) {
		
			case (1): {
			resultado = num1 + num2;
			
			System.out.println("Resultado: " + resultado);
			
			break;
			
			} case (2): {
			resultado = num1 - num2;
			
			System.out.println("Resultado: " + resultado);
			
			break;
			
			} case (3): {
				resultado = num1 * num2;
				
				System.out.println("Resultado: " + resultado);
				
				break;
				
			//Otra opcion es usar case(4) para la división y usar default para avisar que el numero de operación introducido no es correcto, pero no lo pide el ejercicio
				
			} default: {
				resultado = num1 / num2;
				
				System.out.println("-----------------------------");				
				System.out.println("Resultado: " + resultado);
			}
		
		}
	}

}
