package botanico;

import java.util.HashSet;

/**
 * Ejercicio 1. Creando jardín botánico
 * @author Profesor
 */
public class Ejercicio01 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes
    	final int CANTIDAD_ESPECIES_PLANTAS = 5;
        // Variables de entrada
        HashSet <String> guardarEspecies = new HashSet<>(); 
        HashSet <String> guardarEspecies2 = new HashSet<>(); 
        HashSet <String> guardarEspecies3 = new HashSet<>();
        //HashSet <String> guardarEspecies4 = new HashSet<>();
        //HashSet <String> guardarEspecies5 = new HashSet<>();
        // Variables auxiliares
        
        // Variables de salida
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        
        // No hay, pues se usa un número fijo de elementos aleatorios
        
        System.out.println("CONJUNTOS DE ESPECIES DE PLANTAS");
        System.out.println("--------------------------------");

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        
        // Rellenamos los conjuntos con especies de plantas aleatorias hasta que haya CANTIDAD_ESPECIES_PLANTAS
        do {
    	   guardarEspecies.add(Utilidades.especiePlantaAleatoria());
    	   guardarEspecies2.add(Utilidades.especiePlantaAleatoria());
       	}while(guardarEspecies.size() < CANTIDAD_ESPECIES_PLANTAS);
        
        
        // Unión de los dos conjuntos
        guardarEspecies3.addAll(guardarEspecies);
        guardarEspecies3.addAll(guardarEspecies2);
        
        // Intersección de los conjuntos
        /*TAMBIEN SE PODRIA HACER ASI
         * for(String i: guardarEspecies) {
        	if(guardarEspecies2.contains(i)) {
        		guardarEspecies4.add(i);
        	}
        }
        */
        HashSet <String> guardarEspecies4 = new HashSet<>(guardarEspecies);
        guardarEspecies4.retainAll(guardarEspecies2);
         
        
        // Diferencia de los conjuntos
        
        HashSet <String> guardarEspecies5 = new HashSet<>(guardarEspecies2);
        guardarEspecies5.removeAll(guardarEspecies);
        
        /*
         * TAMBIEN SE PODRIA HACER ASI
        for(String i: guardarEspecies2) {
        	if(guardarEspecies.contains(i)) {
  
        	}else {
        		guardarEspecies5.add(i);
        	}
        }
        */
        
        //----------------------------------------------
        //              Salida de Resultados 
        //----------------------------------------------
        
        // Recorremos el conjunto y mostramos su contenido por pantalla
        System.out.println("conjunto1" + guardarEspecies.toString());
        System.out.println("conjunto2" +guardarEspecies2.toString());
        System.out.println("conjunto3, Unión C1 y C2:" +guardarEspecies3.toString());
        System.out.println("conjunto4, Intersección C1 y C2:" +guardarEspecies4.toString());
        System.out.println("conjunto5, Diferencia C2-C1:" +guardarEspecies5.toString());
    }
}