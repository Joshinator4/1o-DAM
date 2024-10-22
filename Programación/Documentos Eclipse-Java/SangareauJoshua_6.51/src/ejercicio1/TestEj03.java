package ejercicio1;

/**
 * Programa de pruebas del <b>ejercicio 03</b>  de la clase <code>ComputadorVuelo</code>
 * @author profesorado
 */
public class TestEj03 {

    /**
     * Se crea un constructor privado para evitar que la clase pueda instanciarse
     */
    private TestEj03() {

    }

    /**
     * M�todo main del programa de pruebas
     */
    public static void main(String[] args) {
        // Cabecera de salida de las pruebas
        System.out.println("CASO DE PRUEBAS 03: GETTERS Y M�TODOS EST�TICOS");
        System.out.println("------------------------------------------------\n");

        // Se prueban los atributos p�blicos de la clase antes de crear las aeronaves
        System.out.println("------------------------------------------------------------");
        System.out.println(" - PRUEBA 01 - ATRIBUTOS P�BLICOS (antes de crear objetos)  ");
        System.out.println("------------------------------------------------------------");
        System.out.println(TestUtilidades.consultaAtributosEstaticos());

        // Se crean varios objetos de tipo ComputadorVuelo almacenados en un array
        // utilizando un m�todo de pruebas de la clase TestUtilidades (por defecto, crea 5 aeronaves de ejemplo).
        System.out.println("------------------------------------------------------------");
        System.out.println(" - PRUEBA 02 - Creaci�n de objetos y uso de getters()       ");
        System.out.println("------------------------------------------------------------");
        ComputadorVuelo[] arrayAeronaves = TestUtilidades.crearArrayAeronavesDatosPrueba();
        System.out.println("Array de dispositivos creado con �xito\n");

        // Se leen los atributos de cada aeronave usando los getter() pertinentes
        TestUtilidades.consultarAtributosArrayAeronaves(arrayAeronaves);

        // Se prueban los atributos p�blicos de la clase despu�s de crear las aeronaves
        System.out.println("------------------------------------------------------------");
        System.out.println(" - PRUEBA 03 - ATRIBUTOS P�BLICOS (despu�s de crear objetos)");
        System.out.println("------------------------------------------------------------");
        System.out.println(TestUtilidades.consultaAtributosEstaticos());
    }
}
