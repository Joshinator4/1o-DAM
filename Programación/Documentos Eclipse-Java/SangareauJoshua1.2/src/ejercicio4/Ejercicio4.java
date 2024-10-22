/*Crearemos un programa en el que definiremos e inicializaremos variables de los siguientes tipos:
 *  Un byte.
 *  Un short.
 *  Un entero
 *  Un caracter
 *  Un número decimal
 *  Una cadena de caracteres
 *  A continuación mostraremos por pantalla un mensaje indicando el tipo de variable que es y el valor con el que lo hemos inicializado:
 */
package ejercicio4;

public class Ejercicio4 {

	public static void main(String[] args) {
		// A continuación definiremos, inicializaremos e imprimiremos en pantalla cada variable:
		
		byte leon;
		leon = 15;
		
		System.out.println("El valor de la variable de tipo byte (leon) es: " + leon);
		
		short cebra;
		cebra = 2350;
		
		System.out.println("El valor de la variable de tipo short (cebra) es: " + cebra);
		
		int gacela;
		gacela = 230537;
						
		System.out.println("El valor de la variable de tipo int (gacela) es: " + gacela);
		
		char vaca;
		vaca = 'c';
		
		System.out.println("El valor de la variable de tipo char (vaca) es: " + vaca);
		
		double lobo;
		lobo = 3.5874;
						
		System.out.println("El valor de la variable de tipo double (lobo)  es: " + lobo);
		
		String oveja;
		oveja = "lana37";
						
		System.out.println("El valor de la variable de tipo string (oveja) es: " + oveja);
		

	}

}
