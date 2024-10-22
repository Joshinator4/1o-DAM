/*
 * Objetivo: Crear una clase automovil segun lo solictado por el ejercicio
 * Autor: Joshua Sangareau Quesada
 * fecha: 20/2/2024
 */
package ejercicio1;

public class Principal {

	public static void main(String[] args) {
		Automovil [] electricos = new Automovil [50];
		int contadorBucle = 0;
		try {
			//apartado1
			System.out.println("Apartado1: Creando el automovil 1");
			Automovil automovil1 = new Automovil();
			System.out.println("Creado automovil1 correctamente");
			System.out.println(automovil1.toString());
			//apartado2
			System.out.println("Apartado2: Acelerando 80km/h el automovil 1");
			automovil1.acelerar(80);
			System.out.println("Velocidad actual: " + automovil1.getVelocidadActual());
			//apartado3
			System.out.println("Apartado3: frenando 30km/h el automovil 1");
			automovil1.frenar(30);
			System.out.println("Velocidad actual: " + automovil1.getVelocidadActual());
			//apartado4
			System.out.println("Apartado4: Acelerando 20km/h por encima de la velocidad maxima el automovil 1");
			automovil1.acelerar(automovil1.getVelocidadMaxima() + 20);
			System.out.println("Velocidad actual: " + automovil1.getVelocidadActual());
			
			
		}catch(IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}catch(Exception excepcion2) {
			System.out.println(excepcion2.getMessage());
		}
		
		try {
			//apartado5 
			System.out.println("Apartado5: Creando el automovil 2");
			Automovil automovil2 = new Automovil("leon", 2024, Automovil.TipoMotor.COMBUSTION, 200);
			System.out.println(automovil2.toString());
		}catch(IllegalArgumentException excepcion3) {
			System.out.println(excepcion3.getMessage());
		}catch(Exception excepcion4) {
			System.out.println(excepcion4.getMessage());
		}
		
		System.out.println(Automovil.cantidadTotalVehiculos);
		try {
			//apartado6
			System.out.println("Apartado6: Creando array con 50 automoviles electricos");
			
			do {
				try {
					
					electricos[contadorBucle] = new Automovil ("electrico", 2024, Automovil.TipoMotor.ELECTRICO, (int)((Math.random()*20)+230));
					System.out.println(electricos[contadorBucle].toString());
					contadorBucle++;
				}catch (IllegalArgumentException excepcion7) {
					System.out.println("Intentado crear el coche" + (contadorBucle+1));
					System.out.println(excepcion7.getMessage());
				}
			}while(contadorBucle < 50);
			
		}catch(IllegalArgumentException excepcion5) {
			System.out.println(excepcion5.getMessage());
		}catch(Exception excepcion6) {
			System.out.println(excepcion6.getMessage());
		}
		
		//apartado7 
		System.out.println("Apartado7: Mostrando la cantidad de automoviles creados: " + Automovil.cantidadTotalVehiculos + "\nMostrando la cantidad de vehículos electricos creados hasta el momento: " + Automovil.cantidadTotalElectricos);
	}

}
