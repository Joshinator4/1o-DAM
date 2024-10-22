/*Un supermercado quiere premiar a los clientes que mayor desembolso hacen en sus tiendas.
Para ello lleva un control de las compras que realiza cada cliente, si éstas superan en suma la
cantidad de 300 euros en un mes se les entrega un vale descuento de 50 euros.
Solicita al usuario los siguientes valores:
 Nombre
 Apellidos
 Importe gastado semana 1
 Importe gastado semana 2
 Importe gastado semana 3
 Importe gastado semana 4
Realizar las siguientes acciones:
 Sumar los importes gastados por el usuario
 Calcular la media del importe gastado.
 Comprobar si el importe en suma es mayor o igual que 300 euros, si es indicar al
usuario que tiene un vale descuento de 50 euros, en caso contrario indicar que no es
así.
 Mostrar toda la información en una ficha.
Nombre: Juan
Apellidos: López Pérez
Importe Gastado semana 1: 50 euros
Importe Gastado semana 2: 40 euros
Importe Gastado semana 3: 50 euros
Importe Gastado semana 4: 40 euros
Importe Medio: 45 euros
Lo sentimos pero sus compras no han alcanzado los 300 euros este mes, no dispone de
descuento.
 * 
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// Llamamos al Scanner y creamos variables.
		
		Scanner teclado = new Scanner(System.in);
		
		double gasto1, gasto2, gasto3, gasto4, gastoMedia, gastoMensual;
		String nombre, apellidos;
		
		//Solicitamos datos al usuario y guardamos en sus respecitvas variables
		
		System.out.println("Introduzca su nombre: ");
		
		nombre = teclado.nextLine();
		
		System.out.println("Introduzca sus apellidos: ");
		
		apellidos = teclado.nextLine();
		
		System.out.println("Introduzca su gasto semana 1: ");
		
		gasto1 = teclado.nextDouble();
		
		System.out.println("Introduzca su gasto semana 2: ");
		
		gasto2 = teclado.nextDouble();
		
		System.out.println("Introduzca su gasto semana 3: ");
		
		gasto3 = teclado.nextDouble();
		
		System.out.println("Introduzca su gasto semana 4: ");
		
		gasto4 = teclado.nextDouble();
		
		
		//realizamos calculos y los guardamos en sus respectivas variables
		
		gastoMensual =gasto1 + gasto2 + gasto3 + gasto4;
		
		gastoMedia = (double)((gasto1 + gasto2 + gasto3 + gasto4)/4);
		
		//mostramos por pantalla los datos requeridos por el ejercicio
		
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellidos: " + apellidos);
		System.out.println("Importe gastado en semana1: " + gasto1);
		System.out.println("Importe gastado en semana2: " + gasto2);
		System.out.println("Importe gastado en semana3: " + gasto3);
		System.out.println("Importe gastado en semana4: " + gasto4);
		System.out.println("Importe medio: " + gastoMedia);
		
		//generamos condición para saber si le corresponde al cliente el cheque regalo de 50€ e imprimir en pantalla el correspondiente mesaje
		
		if (gastoMensual>=300){
			
			System.out.println("Este mes tiene usted un cheque regalo de 50€ para gastar en nuestro supermercado");
			
		}
		else {
			System.out.println("Lo sentimos pero sus compras no han alcanzado los 300 euros este mes, no dispone de descuento.");
		}
		

	}

}
