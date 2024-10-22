/*
 * nombre: Joshua Sangareau Quesada
 * fecha: 12/01/2024
 * descripcion del ejercicio: Se usará una librería para utilizar sus métodos e imprimirlos por pantalla, instanciando objetos y creando variables de reeferencia que apuntan a sus respectivos objetos
 * Se usara siempre que haya que imprimir valores el printf (imprimir con formato)
 */
package ejercicio1;

import java.time.format.DateTimeFormatter;

import libtarea3.Bombilla;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		//respondiendo el apatado 1.-
		//genero variables de referencia
		Bombilla bombilla1;
		Bombilla bombilla2;
		Bombilla bombilla3;
		
		//Se imprime por pantalla las bombillas creadas y encendidas, con sus metodos correspondientes, en este caso no hay ninguna de las 2 para los 2 casos
		System.out.println("1.-CONSULTA INICIAL DE VALORES GLOBALES");
		System.out.println("---------------------------------------");
		//respondiendo el apatado 2.1-
		System.out.printf("Numero de bombillas creadas: %d\n",Bombilla.getBombillasCreadas());
		//respondiendo el apatado 2.2-
		System.out.printf("Numero de bombillas encendidas: %d\n", Bombilla.getBombillasEncendidas());
		
		
		//respondiendo el apatado 3.1-
		System.out.println();
		System.out.println("2.-CREACIÓN Y USO DE BOMBILLAS");
		System.out.println("---------------------------------------");
		System.out.println("Creación de bombillas (constructores)");
		System.out.println("---------------------------------------");
		//Realizo bloque try-catch para tratar la excepcion de crear un objeto con parámetros incorrectos (alguno de los argumentos no es correcto)
		try{
			bombilla1 = new Bombilla(true, 250);
		}catch (IllegalArgumentException excepcion1) {
			System.out.println("Intentando crear una bombilla encendida con una potencia no válida.");
			System.out.println("ERROR: " + excepcion1.getMessage());
		}
		
		//respondiendo el apatado 3.2-
		//Realizo bloque try-catch para tratar la excepcion de crear un objeto con parámetros incorrectos (alguno de los argumentos no es correcto).
		//En este caso el primer argumento (encendida o apagada) lo pondra por defecto el constructor
		try {
			bombilla2 = new Bombilla(5);
		}catch(IllegalArgumentException excepcion2) {
			System.out.println("\nIntentando crear una bombilla con una potencia no válida.");
			System.out.println("ERROR: " + excepcion2.getMessage());
		}
		
		//Instancio los objetos con el operador new, generando punteros(bombilla1, bombilla2, bombilla3) que apuntan a sus respectivos objetos
		//cada uno usará un constructor diferente (apartados 3.3- 3.4- 3.5-)
		
		//respondiendo el apatado 3.3-
		System.out.println("\nCreando bombilla encendida con una potencia válida con un constructor con dos parámetros...");
		bombilla1 = new Bombilla(true, 100);
		System.out.printf("Bombilla 1 creada %s", bombilla1.toString());
		
		//respondiendo el apatado 3.4-
		System.out.println("\n\nCreando bombilla encendida con potencia por defecto usando un constructor con un parámetro...");
		bombilla2 = new Bombilla(true);
		System.out.printf("Bombilla 2 creada %s", bombilla2.toString());
		
		//respondiendo el apatado 3.5-
		System.out.println("\n\nCreando bombilla con valores por defecto usando un constructor sin parámetros...");
		bombilla3 = new Bombilla();
		System.out.printf("Bombilla 3 creada %s", bombilla3.toString());
		
		System.out.println("\n\nManipulación de bombillas (métodos)");
		System.out.println("---------------------------------------");
		//respondiendo el apatado 4.1-
		//Realizo bloque try-catch para tratar la excepcion de encender una bombilla que ya está encendida.
		try{
			bombilla1.encender();
		}catch (IllegalStateException excepcion3) {
			System.out.println("\nEncendiendo la primera bombilla.");
			System.out.println("ERROR: " + excepcion3.getMessage());
		}
		
		//respondiendo el apatado 4.2- (no se realiza el metodo esperar porque no existe libreria)
		//genero un bucle for para realizar 6 veces el metodo conmutar
		for(int i = 0; i < 6; i++) {
			System.out.println("\nConmutando estado de la Bombilla 1");
			bombilla1.conmutar();
			System.out.printf("Estado de Bombilla 1: %s\n", bombilla1.toString());
		}
		
		//respondiendo el apatado 4.3-
		try{
		System.out.println("\nApagando la Bombilla 2...");
		bombilla2.apagar();
		}catch (IllegalStateException excepcion3) {
			System.out.println("ERROR: " + excepcion3.getMessage());
		}
		//respondiendo el apatado 4.4-
		//Uso el metodo correspondiente para encender la bombilla 3
		try{
		System.out.println("\nEncendiendo la Bombilla 3...");
		bombilla3.encender();
		}catch (IllegalStateException excepcion3) {
			System.out.println("ERROR: " + excepcion3.getMessage());
		}
		
		//respondiendo el apatado 5.1-
		//Uso el metodo correspondiente para obtener el atributo potencia de la bombilla1 e imprimirlo con formato
		System.out.println("\nPrueba de los getters de la primera bombilla creada:");
		System.out.println("-----------------------------------------------------------");
		System.out.printf("\nLa potencia de la bombilla1 es: %.2f\n", bombilla1.getPotencia());
		
		//respondiendo el apatado 5.2-
		//Uso el metodo correspondiente para obtener el atributo estado de la bombilla1 e imprimirlo con formato
		if(bombilla1.getEstado()) {
			System.out.println("La bombilla está encendida");
		}else {
			System.out.println("La bombilla está apagada");
		}
		
		//respondiendo el apatado 5.3-
		//Uso el metodo correspondiente para obtener el ultima vez encendida de la bombilla1
		//se formatea la salida con DateTimeFormatter
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.println("La ultima vez que se encendió fué " + bombilla1.getUltimaVezEncendida().format(formatoFecha));
		
		//respondiendo el apatado 5.4-
		//Uso el metodo correspondiente para obtener el atributo numero de veces encendida de la bombilla1 e imprimirlo con formato
		System.out.printf("Numero de veces encendida: %d\n", bombilla1.getVecesEncendida());
		
		//respondiendo el apatado 5.5-
		//Uso el metodo correspondiente para obtener el atributo tiempo que lleva encendida de la bombilla1 e imprimirlo con formato
		System.out.printf("Tiempo que lleva encendida: %.2f\n", bombilla1.getTiempoEncendida());
		
		//respondiendo el apatado 5.6-
		//Uso el metodo correspondiente para obtener el atributo potencia consumida de la bombilla1 e imprimirlo con formato
		System.out.printf("La potencia consumida es: %.2f WS\n", bombilla1.getPotenciaConsumida());
		
		
		//Se imprime por pantalla las bombillas creadas y encendidas, con sus metodos correspondientes, en este caso si habrá bombillas creadas y bombillas encendidas
		//respondiendo el apatado 6.1-
		System.out.println("\n3.-CONSULTA FINAL DE VALORES GLOBALES");
		System.out.printf("\nNúmero de bombillas creadas hasta el momento: %d\n",Bombilla.getBombillasCreadas());
		
		//respondiendo el apatado 6.2-
		System.out.printf("Número de bombillas encendidas en este momento: %d\n", Bombilla.getBombillasEncendidas());
		
	}

}
