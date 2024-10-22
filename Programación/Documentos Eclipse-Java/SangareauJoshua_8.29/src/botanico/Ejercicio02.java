package botanico;

import java.util.ArrayList;
import java.util.HashSet;

/** Ejercicio 2. Búsqueda de especies de plantas populares
 * @author Profesor
 */
public class Ejercicio02 {

    public static void main(String[] args) {
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes
        final int CANTIDAD_ESPECIES_PLANTAS= 10;
        // Variables de entrada
        ArrayList <String> listaPlantas = new ArrayList<>();
        ArrayList <String> listaPlantas2 = new ArrayList<>();
        ArrayList <String> listaPlantasPopulares = new ArrayList<>();
        HashSet <String> conjuntoPlantasPopulares = new HashSet<>();
        ArrayList <Integer> listaPosicionesPopulares = new ArrayList<>();
        String planta;
        
        
        // Variables auxiliares
       
        // Variables de salida

        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println();
        System.out.println("BÚSQUEDA DE ESPECIES DE PLANTAS POPULARES");
        System.out.println("-----------------------------------------");
        
        
        // No hay, pues se usa un número fijo de elementos aleatorios

        // Rellenamos la lista con aleatorios hasta que haya CANTIDAD_ESPECIES_PLANTAS
        for(int i = 0; i < CANTIDAD_ESPECIES_PLANTAS;i++) {
        	listaPlantas.add(Utilidades.especiePlantaAleatoria());
        	listaPlantas2.add(Utilidades.especiePlantaAleatoria());
        }
        System.out.println("Lista inicial de plantas 1: " + listaPlantas.toString());
        System.out.println("Lista inicial de plantas 2: " + listaPlantas2.toString());
        
        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------

        //PREGUNTAR AQUI, YO LO HAGO ASI, HAY ALGUNA FORMA DE RECORRER LAS 2 ARRAYLIST A LA VEZ???
        // Recorremos a la vez las dos listas
        for(int i= 0; i < listaPlantas.size();i++) {
        	if(listaPlantas.get(i).equals(listaPlantas2.get(i))) {
        		listaPlantasPopulares.add(listaPlantas.get(i));
        		conjuntoPlantasPopulares.add(listaPlantas.get(i));
        		listaPosicionesPopulares.add(i);
        		planta = listaPlantas.get(i);
        		listaPlantas.set(i, ("*"+planta+"*"));
        		listaPlantas2.set(i, ("*"+planta+"*"));
        	}
        }
        

        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        
        System.out.println();
        System.out.println("Lista final de plantas 1: " + listaPlantas.toString());
        System.out.println("Lista final de plantas 2: " + listaPlantas2.toString());
        System.out.println("Lista final de plantas populares: " + listaPlantasPopulares.toString());
        System.out.println("Lista final de posiciones populares: " + listaPosicionesPopulares.toString());
        System.out.println("Conjunto final de plantas populares: " + conjuntoPlantasPopulares.toString());
    }
}