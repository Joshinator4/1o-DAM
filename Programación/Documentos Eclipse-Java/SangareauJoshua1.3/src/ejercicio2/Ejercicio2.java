/*Se deberá realizar un programa que solicite al usuario datos relativos a un equipo de fútbol. Haciendo uso para ello de las variables que sean necesarias:
 * En primer lugar solicitará el nombre del equipo
 * Solicitará el nombre del estadio
 * Solicitará el año de fundación
 * Solicitará el nombre del capitán
 *  Mostrará por pantalla los datos de la siguiente manera:
 *  **********************************************************************************************
 *  ******* Nombre del Equipo: Torremolinos ***********************************************
 *  ******** Fundado en: 2016 ****************************************************************
 *  ******* Estadio: Campus******************************************************************
 *  ****** Capitán: Javi M************************************************************* * 
 */

package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// Llamamos la función scanner:
		
		Scanner teclado = new Scanner (System.in);
		
		// Nombraremos todas las variables
		String nombredelequipo;
		String nombredelestadio;
		short fundacion;
		String nombredelcapitan;
		
		// Pedimos los datos al usuario
		
		System.out.println("Introduzca el nombre de su equipo: ");
		
		nombredelequipo = teclado.nextLine();
		
		System.out.println("Introduzca el nombre del estadio: ");
		
		nombredelestadio = teclado.nextLine();
		
		System.out.println("Introduzca año de fundación: ");
		
		fundacion = teclado.nextShort();
		
		//Limpiamos función Scanner: Tras leer cualquier dato numérico, bien sea int o double hay un problema con la clase Scanner si después trato de leer un carácter
		// Tras leer cada dato numérico añadir un .nextLine(),en este caso teclado.nextLine() de esta forma el buffer no queda en un salto de línea intermedio 
		//y puedo seguir leyendo correctamente los datos indistintamente del tipo a tratar.
		
		teclado.nextLine();
		
		System.out.println("Introduzca nombre del capitán: ");
		
		nombredelcapitan = teclado.nextLine();
		
		System.out.println("*******Nombre del equipo: " + nombredelequipo + "***********************************************");
		System.out.println("*******Fundado en: " + fundacion + "***********************************************");
		System.out.println("*******Estadio: " + nombredelestadio + "***********************************************");
		System.out.println("*******Capitán: " + nombredelcapitan + "***********************************************");
		

		
		//Esto ocurre porque al pedir el nombre, nextLine() se encuentra que en el flujo de datos ya hay un retorno de carro, el que nextInt() o nextShort() o nextByte()
		//o nextLong() dejó abandonado.
		//Entonces nextLine() se confunde, piensa que el usuario ya ha terminado de teclear el nombre y da por finalizada la entrada de datos.
		//Por eso, siempre que intentemos leer un String con nextLine(), después de haber leído un valor numérico, esa lectura fallará.
		//Solución: al terminar de leer datos numéricos, hagamos un nextLine() para eliminar cualquier retorno de carro que haya quedado en el input.
	}

}
