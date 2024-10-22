/*El siguiente código pregunta al usuario por la velocidad (en kilómetros por hora) y el tiempo (en segundos) de un vehículo.
 * formato a entregar
 * Kilometros por hora: (introduce usuario)
 * Tiempo en segundos: (introduce usuario)
 * Distancia recorrida en kilómetros:
 * Distancia recorrida en metros:
 */
package calculodistancia;

import java.util.Scanner;

public class Calculodistancia {

	    public static void main(String args[]) {
	    	
	      Scanner teclado=new Scanner(System.in);
	      
	      double velocidad;
	      double segundos;
	      double distanciakm;
	      double distanciam;
	      double tiempoenh;
	      
	      System.out.print("Velocidad en kilometros por hora: ");
	      
	      velocidad=teclado.nextDouble();
	      
	      System.out.print("Tiempo en segundos: ");
	      
	      segundos=teclado.nextDouble();
	      
	      tiempoenh = (segundos / 3600);
	      
	      distanciakm = (velocidad * tiempoenh);
	      
	      distanciam = (distanciakm * 1000);
	      
	      System.out.println("Distancia recorrida en kilómetros " + distanciakm + "\n" + "Distancia recorrida en metros: " + distanciam);
	      
	    }
	}

