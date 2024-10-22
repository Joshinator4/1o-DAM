package botanico;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/** Ejercicio 3. Calendario de especies de plantas
 * @author Profesor
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        
        // Constantes
        final int MAXIMO_DIAS = 7;
        // Variables de entrada
        HashMap <LocalDate, String> mapa = new HashMap<>();
        LocalDate hoy = LocalDate.now();
        int contadorDias=0;
        String  planta;
        // Variables auxiliares
        
        // Variables de salida
        

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        //LA SALIDA NO ES CORRECTA. ORDENA DE MAYOR A MENOR, NO SE COMO ORDENAR AL REVES
        //NO SE SI EXISTE UN METODO PARA REALIZAR EL CODIGO REALIZADO ABAJO
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        do {
        	planta = Utilidades.especiePlantaAleatoria();
        	if(!mapa.containsValue(planta)) {
        		mapa.put(hoy.plusDays(contadorDias), planta);
        		contadorDias++;
        	}
        }while(mapa.size() < MAXIMO_DIAS);
        System.out.println("CALENDARIO DE ESPECIES DE PLANTAS");
        System.out.println("---------------------------------");
        System.out.println(mapa.toString());
        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        
   
        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        
 
    }
}