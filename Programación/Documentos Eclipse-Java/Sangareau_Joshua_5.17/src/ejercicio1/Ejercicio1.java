package ejercicio1;

import java.util.Scanner;

import libtarea3.Dado;

public class Ejercicio1 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		final byte CANTIDAD_DADOS=3;
		int cantidadMaxima, sumaLanzamientos = 0, lanzamiento = 1;
		long dadoPuntuacionMaxima = 0 ;
		long puntuacionMaxima;
		byte ultimoLanzamiento1, ultimoLanzamiento2, ultimoLanzamiento3;
		Dado dadoCreado1 = new Dado();
    	Dado dadoCreado2 = new Dado();
    	Dado dadoCreado3 = new Dado();
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
	    
	    cantidadMaxima = (int)(Math.random()*30+31);
	    
	    
	    	dadoCreado1 = new Dado();
	    	dadoCreado2 = new Dado();
	    	dadoCreado3 = new Dado();
	    	
	    	System.out.println("\t\t       Dado1    Dado2    Dado3");
	    
	    do {
	    		ultimoLanzamiento1 = dadoCreado1.lanzar();
	    		System.out.printf("Lanzamiento numero %d:     %d   ", lanzamiento, ultimoLanzamiento1); 
	    		
	    		ultimoLanzamiento2 = dadoCreado2.lanzar();
	    		System.out.printf("\t   %d", ultimoLanzamiento2);
	    		
	    		ultimoLanzamiento3 = dadoCreado3.lanzar();
	    		System.out.printf("\t    %d", ultimoLanzamiento3);
	    		
	    		System.out.println();
	    		lanzamiento++;
	    		sumaLanzamientos = (int) (dadoCreado1.getSumaPuntuacionHistorica() + dadoCreado2.getSumaPuntuacionHistorica() +dadoCreado3.getSumaPuntuacionHistorica());
	    	
	    }while (sumaLanzamientos < cantidadMaxima);
	    
	    System.out.printf("\n\nLa cantidad Máxima será: %d", cantidadMaxima);
	    
	    
	    System.out.printf("\nJuego Terminado. La suma de los lanzamientos es: %d", (dadoCreado1.getSumaPuntuacionHistorica()+dadoCreado2.getSumaPuntuacionHistorica()+dadoCreado2.getSumaPuntuacionHistorica()));
	    
	    /*puntuacionMaxima = dadoCreado1.getSumaPuntuacionHistorica();
	    dadoPuntuacionMaxima = 1;
	    
	    if(dadoCreado2.getSumaPuntuacionHistorica() > puntuacionMaxima) {
	    	puntuacionMaxima = dadoCreado2.getSumaPuntuacionHistorica();
	    	dadoPuntuacionMaxima = 2;
	    
	    }
	    
	    if(dadoCreado3.getSumaPuntuacionHistorica() > puntuacionMaxima) {
	    	puntuacionMaxima = dadoCreado3.getSumaPuntuacionHistorica();
	    	dadoPuntuacionMaxima = 3;
	    	
	    }else if(dadoCreado1.getSumaPuntuacionHistorica() > puntuacionMaxima) {
	    	dadoPuntuacionMaxima = 1;
	    }
	    */
	    
	    if(dadoCreado1.getSumaPuntuacionHistorica() >= dadoCreado2.getSumaPuntuacionHistorica() && dadoCreado1.getSumaPuntuacionHistorica() >= dadoCreado3.getSumaPuntuacionHistorica()) {
	    	dadoPuntuacionMaxima = dadoCreado1.getSumaPuntuacionHistorica();
	    } else if(dadoCreado2.getSumaPuntuacionHistorica() >= dadoCreado1.getSumaPuntuacionHistorica() && dadoCreado2.getSumaPuntuacionHistorica() >= dadoCreado3.getSumaPuntuacionHistorica()) {
	    	dadoPuntuacionMaxima = dadoCreado2.getSumaPuntuacionHistorica();
	    } else if (dadoCreado3.getSumaPuntuacionHistorica() >= dadoCreado1.getSumaPuntuacionHistorica() && dadoCreado3.getSumaPuntuacionHistorica() >= dadoCreado2.getSumaPuntuacionHistorica()) {
	    	dadoPuntuacionMaxima = dadoCreado3.getSumaPuntuacionHistorica();
	    }
	    
	    if(dadoPuntuacionMaxima == dadoCreado2.getSumaPuntuacionHistorica()) {
	    	
	    	System.out.printf("\nEl dado con más puntuación es el dado2 con una puntuación del ultimo lanzamiento: %d", ultimoLanzamiento2);
	    	System.out.printf("\nEl valor %d ha salido %d veces en todo el juego y se han realizado un total de %d lanzamientos.", ultimoLanzamiento2, Dado.getNumeroVecesCaraGlobal(ultimoLanzamiento2), Dado.getNumeroLanzamientosGlobal());
	    	System.out.printf("\nTodos los lanzamientos del dado 2: %s", dadoCreado2.getSerieHistoricaLanzamientos());
	    	
	    } else if(dadoPuntuacionMaxima == dadoCreado3.getSumaPuntuacionHistorica()) {
	    	
	    	System.out.printf("\nEl dado con más puntuación es el dado3 con una puntuación del ultimo lanzamiento: %d", ultimoLanzamiento3);
	    	System.out.printf("\nEl valor %d ha salido %d veces en todo el juego y se han realizado un total de %d lanzamientos.", ultimoLanzamiento3, Dado.getNumeroVecesCaraGlobal(ultimoLanzamiento3), Dado.getNumeroLanzamientosGlobal());
	    	System.out.printf("\nTodos los lanzamientos del dado 3: %s", dadoCreado3.getSerieHistoricaLanzamientos());
	    	
	    }else if(dadoPuntuacionMaxima == dadoCreado1.getSumaPuntuacionHistorica()) {
	    	
	    	System.out.printf("\nEl dado con más puntuación es el dado1 con una puntuación del ultimo lanzamiento: %d", ultimoLanzamiento1);
	    	System.out.printf("\nEl valor %d ha salido %d veces en todo el juego y se han realizado un total de %d lanzamientos.", ultimoLanzamiento1, Dado.getNumeroVecesCaraGlobal(ultimoLanzamiento1), Dado.getNumeroLanzamientosGlobal());
	    	System.out.printf("\nTodos los lanzamientos del dado 1: %s", dadoCreado1.getSerieHistoricaLanzamientos());
	    	
	    }
	}
	
}