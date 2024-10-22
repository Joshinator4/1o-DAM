package botanico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/** Ejercicio 4. Clasificación de especies de plantas coincidentes 
 * (con el mismo nombre y en la misma posición)
 * @author Profesor
 */
public class Ejercicio04 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------

        // Constantes
    	final int CANTIDAD_ESPECIES_PLANTAS= 20;
        // Variables de entrada
    	ArrayList<String> listaPlantas = new ArrayList<>();
    	ArrayList<String> listaPlantas2 = new ArrayList<>();
        Map <String, List<Integer>> mapaListas = new TreeMap<>();
        // Variables auxiliares
        
        // Variables de salida

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        for(int i = 0; i < CANTIDAD_ESPECIES_PLANTAS; i++) {
        	listaPlantas.add(Utilidades.especiePlantaAleatoria());
        	listaPlantas2.add(Utilidades.especiePlantaAleatoria());
        }
        
        
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        
        System.out.println("CLASIFICACIÓN DE COINCIDENTES");
        System.out.println("-----------------------------");
        System.out.println(listaPlantas.toString());
        System.out.println(listaPlantas2.toString());
        

        
        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------
        
        for(int i = 0; i < CANTIDAD_ESPECIES_PLANTAS; i++) {
        	boolean yaExiste=false;
        	if(listaPlantas.get(i).equals(listaPlantas2.get(i))) {
        		
        		
        		if(mapaListas.containsKey(listaPlantas.get(i))) {
        			mapaListas.get(listaPlantas.get(i)).add(i);
        			
        		}else {
        			mapaListas.put(listaPlantas.get(i), new ArrayList<Integer>());
        			mapaListas.get(listaPlantas.get(i)).add(i);
        		}

        	}
        }
        System.out.println("\nClasificación de coincidencias:");
        System.out.println(mapaListas.toString());

        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        

    }
}