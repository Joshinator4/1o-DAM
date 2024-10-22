
package ejercicio1;

/**
 * Programa de pruebas del <b>ejercicio 07</b>  de la clase <code>ComputadorVuelo</code>
 * @author profesorado
 */
public class TestEj06 {
    /**
     * Se crea un constructor privado para evitar que la clase pueda instanciarse
     */
    private TestEj06 ()
    {
        
    }    
    
    /**
     * M�todo main del programa de pruebas
     */
    public static void main (String[] args)
    {
        // Cabecera de salida de las pruebas
        System.out.println("CASO DE PRUEBAS 06: m�todo toString()                         ");
        System.out.println("------------------------------------------------------------\n");
        
        // Se crea una aeronave aeronave de prueba
        ComputadorVuelo aeronave = TestUtilidades.crearAeronave("EC-FA3", "Eurostar Evektor EV-97", "Pepito P�rez");
        
        System.out.println("\n----------------------------------------------------------");
        System.out.println(" - PRUEBA 01 - Visualizaci�n del estado del objeto          ");
        System.out.println("------------------------------------------------------------");
        
        // Se realizan algunas operaciones b�sicas para leer el estado de la aeronave
        System.out.println("EC-FA3 va a despegar...");
        aeronave.despegar(ComputadorVuelo.VUELO_ESCUELA, 150, 2000);
        
        // Se imprime el estado de la aeronave
        System.out.println(aeronave.toString() + "\n");
        
        // Se modifican algunos par�metros de estado del objeto
        System.out.println("EC-FA3 cambia de rumbo, velocidad y altitud...");
        aeronave.setRumbo(90);
        aeronave.setVelocidad(190);
        aeronave.setAltitud(2500);
        
        // Se imprime el estado de la aeronave
        System.out.println(aeronave.toString() + "\n");
        
        // Se registra la operaci�n de aterrizaje
        System.out.println("EC-FA3 va a aterrizar ...");
        aeronave.aterrizar("LEBA", "LEDE", 150);
        
        // Se imprime el estado de la aeronave
        System.out.println(aeronave.toString() + "\n");

        // Se realiza un nuevo despegue
        System.out.println("EC-FA3 va a despegar ...");
        aeronave.despegar(ComputadorVuelo.VUELO_PRIVADO, 200, 3000);
        
        // Se imprime el estado de la aeronave
        System.out.println(aeronave.toString() + "\n");
        
        // Se modifican algunos par�metros de estado del objeto
        System.out.println("EC-FA3 cambia de rumbo, velocidad y altitud...");
        aeronave.setRumbo(270);
        aeronave.setVelocidad(150);
        aeronave.setAltitud(1500);
        
        // Se imprime el estado de la aeronave
        System.out.println(aeronave.toString() + "\n");
        
        // Se registra la operaci�n de aterrizaje
        System.out.println("EC-FA3 va a aterrizar ...");
        aeronave.aterrizar("LEBA", "LEDE", 90);

        // Se imprime el estado de la aeronave
        System.out.println(aeronave.toString());        
    }
}