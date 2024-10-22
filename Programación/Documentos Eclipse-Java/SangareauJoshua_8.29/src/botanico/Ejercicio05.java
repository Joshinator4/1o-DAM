package botanico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Ejercicio 5. Ordenación de especies de plantas (por nombre y longitud)
 * @author Profesor
 */
public class Ejercicio05 {

    public static void main(String[] args) {
        
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        
        // Constantes
    	final int CANTIDAD_ESPECIES_PLANTAS= 5;
        // Variables de entrada
    	List<String> listaPlantas = new ArrayList<>();
    	String nuevaPlanta;
        // Variables auxiliares
        
        // Variables de salida

        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
    	do {
    		nuevaPlanta = Utilidades.especiePlantaAleatoria();
    		if(!listaPlantas.contains(nuevaPlanta)) {
    			listaPlantas.add(nuevaPlanta);
    		}
    	}while(listaPlantas.size() < CANTIDAD_ESPECIES_PLANTAS);
        
    	System.out.println("Contenido inicial de la lista:");
    	for(int i = 0; i < listaPlantas.size(); i++) {
    		System.out.println((i+1)+ ". " + listaPlantas.get(i));
    	}
    	
        System.out.println("\nORDENACIÓN DE ESPECIES DE PLANTAS POR NOMBRE (alfabetico)");
        System.out.println("---------------------------------");
        Collections.sort(listaPlantas, new ComparadorEspeciePlantaPorNombre());
        for(int i = 0; i < listaPlantas.size(); i++) {
    		System.out.println((i+1)+ ". " + listaPlantas.get(i));
    	}
        System.out.println("\nORDENACIÓN DE ESPECIES DE PLANTAS POR LONGITUD");
        System.out.println("---------------------------------");
        Collections.sort(listaPlantas, new ComparadorEspeciePlantaPorLongitud());
        for(int i = 0; i < listaPlantas.size(); i++) {
    		System.out.println((i+1)+ ". " + listaPlantas.get(i));
    	}
        
        //----------------------------------------------
        //     Procesamiento + Salida de resultados
        //----------------------------------------------

        
    }
}