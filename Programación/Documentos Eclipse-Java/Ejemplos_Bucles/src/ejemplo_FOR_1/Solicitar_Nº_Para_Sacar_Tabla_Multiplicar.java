/*Escribe en Java un programa que solicite un número n para calcular la tabla de multiplicar de ese número n usando un bucle tipo for.
Una vez lo tengas hecho, añade a la entrada de datos una comprobación para que el número n introducido esté obligatoriamente entre 1 y 10.
 Si no es así, se volverá a solicitar el número hasta que esté dentro de ese rango.
 */
package ejemplo_FOR_1;

import java.util.Scanner;

public class Solicitar_Nº_Para_Sacar_Tabla_Multiplicar {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numeroTabla;
	    // Variables de salida
		int resultado;
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    
	    //Utilizamos bucle do-while para la entrada de datos sea correcta. hacemos que (do) pida datos una y otra vez si (while) el nº introducido
	    //está entre menores que 1 o mayores que 10 (numeroTabla < 1 || numeroTabla > 10)
	    
	    do{
	    	System.out.println("Por favor, introduzca nº comprendido entre 1 y 10");
	    	numeroTabla = teclado.nextInt();
	    } while (numeroTabla < 1 || numeroTabla > 10);
	    	
	    	//al estar entre 1 y 10 sale del bucle do-while y realiza el bucle for, inicializando i en 1, la condición de salida es mayor o igual que 10 (<= 10) y dandole el operando sumatoria i++
	    	//para que vaya sumando 1 a i cada vez que repite el bucle.
	    	//ponemos operacion (resultado = numeroTabla * i;) para que haga la multiplicación e imprimimos por pantalla cada resultado
	    	
	    for (int i = 1; i <= 10; i++) {
	    	resultado = numeroTabla * i;
	    	System.out.println(i + " multiplicado por" + numeroTabla + " = " + resultado);
	    }
	    	//terminará el bucle for cuando i sea mayor que 10.

	    //----------------------------------------------
	    //              Salida de resultados 
	    //----------------------------------------------
	    
	    
	}
}   