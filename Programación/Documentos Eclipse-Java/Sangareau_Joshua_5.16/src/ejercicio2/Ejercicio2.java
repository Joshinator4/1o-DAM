package ejercicio2;

import java.util.Scanner;
import libtarea3.Dado;

public class Ejercicio2 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		int numeroCaras = 0;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    

	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    //Imprimimos con formato los metodos estáticos (metodos que se aplican a la clase, no al objeto) solicitados por el ejercicio
	    System.out.printf("Numero total de dados creados: %d", Dado.getNumeroDadosCreados());
	    System.out.printf("\nNumero total de lanzamientos: %d", Dado.getNumeroLanzamientosGlobal());
	    System.out.printf("\nCantidad de veces que han salido las caras con valores 1, 2, 3 y 4: %d, %d, %d, %d, respectivamente\n", Dado.getNumeroVecesCaraGlobal(1), Dado.getNumeroVecesCaraGlobal(2), Dado.getNumeroVecesCaraGlobal(3), Dado.getNumeroVecesCaraGlobal(4));
	    
	    //Generamos un array para meter los resultados aleatorios de las caras de los dados
	    Dado [] dado = new Dado [10];
    	  
	    //Generamos un bucle que recorrerá las 10 posiciones del array (los 10 dados generados)
	    for(int i = 0; i < 10; i++) {
    		//Dentro del bucle generamos un bloque try-catch para captar las excepciones generadas por las caras
	    	//que se generen aleatoriamente que no le valgan al constructor(4, 6, 8, 12, 20)
	    	try {
	    			numeroCaras = (int)Math.ceil(Math.random()*8);
	    			//primero generamos aletaoriamente el numero de caras del dado y lo metemos en cada campo del array
    	    		dado[i] = new Dado(numeroCaras);
    	    		
    	    		//Si es correcto el numero de caras seguirá su proceso imprimiendo con formato lo siguiente,
    	    		System.out.printf("\nIntento: " + (i+1) + " Intentando crear dado de %d caras. Correcto: Creado dado de %d caras\n" ,dado[i].getNumeroCaras(), dado[i].getNumeroCaras());
    	    		
    	    		//Se genera un bucle para lanzar el dado con su metodo correspondiente tantas veces como caras tiene el dado
    	    		for(int j = 0; j < dado[i].getNumeroCaras(); j++) {
    	    		dado[i].lanzar();
    	    		}
    	    		
    	    		//Se imprime con formato los resultados de los lanzamientos, etc
    	    		System.out.printf("Lo lanzamos %d veces: %s\n", dado[i].getNumeroLanzamientos(), dado[i].getSerieHistoricaLanzamientos());
    	    		System.out.printf("Suma total de los lanzamientos del dado: %f", dado[i].getSumaPuntuacionHistorica());
    		
    	    //Recogemos las excepciones (La clase dado lanza esta excepcion) y se muestra con formato
	    	}catch(IllegalArgumentException excepcion1) {
	    		
	    		System.out.printf("\nIntento: " + (i+1) + " Intentando crear dado de %d caras. Error. Numero de caras no válido: %d", numeroCaras, numeroCaras);
	    	}
	    }
	    
	    ////Se vuelve a imprimir con formato los metodos estáticos (metodos que se aplican a la clase, no al objeto) Ahora con el ejercicio terminado
	    System.out.printf("\n\nNumero total de dados creados: %d", Dado.getNumeroDadosCreados());
	    System.out.printf("\nNumero total de lanzamientos: %d", Dado.getNumeroLanzamientosGlobal());
	    System.out.printf("\nCantidad de veces que han salido las caras con valores 1 = %d veces, 2 = %d veces, 3 = %d veces y 4 = %d veces:", Dado.getNumeroVecesCaraGlobal(1), Dado.getNumeroVecesCaraGlobal(2), Dado.getNumeroVecesCaraGlobal(3), Dado.getNumeroVecesCaraGlobal(4));
	    
    	
	}

}
