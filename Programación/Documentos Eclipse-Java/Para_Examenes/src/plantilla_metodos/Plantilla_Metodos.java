package plantilla_metodos;

import java.util.Arrays;

public class Plantilla_Metodos {

	public static void main(String[] args) {
		//Decalaracion de variables
		final byte a=1;
		String nombreVariable = null, nombreOtraVariable = null;
		int [] numeros = new int [a];
		int [] numeros2 = new int [a];
		double numeroClaseMath = 0;
		
		
		//Clase String
		//.substring(int posicion, int (n-1)) devuelve en un string las posiciones que se indican (en este caso de la pos 0 a la (3-1))
		nombreVariable.substring(0, 3);
		//.substring(int posicion) devuelve en un string desde la posicion que se indica hasta el final (en este caso posicion 3 hasta el final)
		nombreVariable.substring(3);
		
		//.charAt(posición) devuelve el carácter de esa que hay en esa posición empieza desde el 0.
		nombreVariable.charAt(0);
		
		//.equals(variable string) compara si son iguales las 2 variables y devuelve un true/false
		nombreVariable.equals(nombreOtraVariable);
		
		//.equalsIgnoreCase(variable string) compara si son iguales las 2 variables ignorando las mayúsculas y devuelve un true/false
		nombreVariable.equalsIgnoreCase(nombreOtraVariable);
		
		//.toLowerCase() convierte todos los caracteres alfabéticos del string a minúsculas
		nombreVariable.toLowerCase();
		
		//.toUpperCase() convierte todos los caracteres alfabéticos del string a mayúsculas
		nombreVariable.toUpperCase();
		
		//.length() devuelve el número de posiciones (incluyendo espacios y todo) del String.
		nombreVariable.length();
		
		//.split(" ") separa el string en otros Strings actuando el espacio como separador. En este caso cada espacio separa cada palabra en otro string 
		nombreVariable.split(" ");
		
		
		
		
		//clase Array
		//Arrays.fill(tipo de variable, numero o variable con la que rellena) elegir tipo de variable. Rellena el array con el numero o variables seleccionado
		Arrays.fill(numeros, 0);
		
		//Arrays.sort(nombre de variable) Elegir tipo de variable. Ordena el array de mayor a menor.
		Arrays.sort(numeros);
		
		//Arrays.toString(nombre de la variable). Elegir tipo de variable. Coge todas las posiciones del array y las junta en un string
		Arrays.toString(numeros);
		
		//Arrays.equals(variable A, variable B) Elegir tipo de variable. Compara dos arrays devolviendo un boolean si son iguales (mismos valores en mismas posiciones)
		Arrays.equals(numeros, numeros2);
		
		// Arrays.compare(variable A, Variable B) Elegir tipo de variable. Compara ambos arrays y devuelve 0 si son iguales y contienen los mismos elementos en el mismo orden
		//y valores menores a 0 si, dentro de los rangos especificados, la primera matriz es lexicográficamente menor que la segunda matriz;
		//y un valor mayor que 0 si, dentro de los rangos especificados, la primera matriz es lexicográficamente mayor que la segunda matriz
		Arrays.compare(numeros, numeros2);
		
		//Arrays.mismatch(variable A, Variable B) Elegir tipo de variable. Devuelve el valor de la primera posición que no sea igual a la otra. Devuelve -1 si no encuentra diferencias
		Arrays.mismatch(numeros, numeros2);
		
		
		
		
		//Clase Math
		//Para elevar una variable o numero a otra variable o numero
		Math.pow(numeroClaseMath, 2);
		
		//Para hacer raíz cuadrada
		Math.sqrt(numeroClaseMath);
		
		//Para hace raíz cubica
		Math.cbrt(numeroClaseMath);
		
		//Math.ceil Devuleve el siguiente nº entero (1,3 --> 2) 
		Math.ceil(numeroClaseMath);
		
		//Math.floor Devuleve el nº entero sin decimales (1,3 --> 1)
		Math.floor(numeroClaseMath);
		
		//Math.round Devuleve el redondeo en nº entero (1,4 --> 1 ó 1,5 --> 2)
		Math.round(numeroClaseMath);
		
		
	}

}
