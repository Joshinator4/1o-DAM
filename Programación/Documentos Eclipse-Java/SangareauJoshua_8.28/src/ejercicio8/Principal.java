package ejercicio8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

import ejercicio5.Alumno;
import ejercicio8.DiaTemperatura.DiaSemana;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		ArrayList <DiaTemperatura> listaDias = new ArrayList<>(); 
		
		boolean salirPrograma = false;
		int numeroIntroducido, temperaturaMaxima=0;
		double mediaTemperaturaMes = 0;
		String diaCaluroso;
		
		do {
			System.out.println("Introduzca el numero de opcion a realizar\n1.-Rellenar las temperaturas\n2.-Mostrar las temperaturas ordenadas por temperatura media de mayor a menor\n"
					+ "3.-Visualizar la temperatura media del mes.\n4.-Día o días más calurosos del mes"
					+ "\n0.- Salir del programa");
			numeroIntroducido = teclado.nextInt();
			switch(numeroIntroducido) {
				case (1):{
					for(DiaTemperatura i : listaDias) {
						i.setTemperaturaMedia((int)(Math.random()*41));
					}
					break;
					
				}case (2):{
					Collections.sort(listaDias, new ComparadorTemperaturas());;
					for(DiaTemperatura i : listaDias) {
						System.out.println(i.toString());
					}
					break;
				
				}case(3):{
					for(DiaTemperatura i : listaDias) {
						mediaTemperaturaMes += i.getTemperaturaMedia();
					}
					mediaTemperaturaMes = mediaTemperaturaMes/31;
					System.out.printf("La media de temperatura del mes es: %.2f\n", mediaTemperaturaMes);
					break;
					
				}case(4):{
					diaCaluroso = "";
					for(DiaTemperatura i : listaDias) {
						if(i.getTemperaturaMedia() > temperaturaMaxima) {
							temperaturaMaxima = i.getTemperaturaMedia();
						}
					break;
					}
					
					for(DiaTemperatura i : listaDias) {
						if(i.getTemperaturaMedia() == temperaturaMaxima) {
							diaCaluroso += i.toString() + "\n";
						}
					}
					System.out.println(diaCaluroso);
					break;
					
				}case(0):{
					System.out.println("Se va a proceder a salir del programa, ¡Hasta pronto!");
					salirPrograma = false;
					break;
					
				}default:{
					System.out.println("Numero incorecto introduzca un numero del 1 al 4 o 0");
					break;
				}
				
				}
		
	
		
		}while(salirPrograma == false);

	}
	
	private static void insertarDias(ArrayList <DiaTemperatura> lista) {
		for(int i = 0; i < 31; i++) {
			if( i == 0 || i == 0+7 || i == 0+14 || i == 0+21 || i == 0+28) {
				lista.add(new DiaTemperatura((i+1), DiaSemana.LUNES));
			}else if( i == 0+1 || i == 0+8 || i == 0+15 || i == 0+22 || i == 0+29) {
				lista.add(new DiaTemperatura((i+1), DiaSemana.MARTES));
			}else if( i == 0+2 || i == 0+9 || i == 0+16 || i == 0+23 || i == 0+30) {
				lista.add(new DiaTemperatura((i+1), DiaSemana.MIERCOLES));
			}else if( i == 0+3 || i == 0+10 || i == 0+17 || i == 0+24) {
				lista.add(new DiaTemperatura((i+1), DiaSemana.JUEVES));
			}else if( i == 0+4 || i == 0+11 || i == 0+18 || i == 0+25) {
				lista.add(new DiaTemperatura((i+1), DiaSemana.VIERNES));
			}else if( i == 0+5 || i == 0+12 || i == 0+19 || i == 0+26) {
				lista.add(new DiaTemperatura((i+1), DiaSemana.SABADO));
			}else if( i == 0+6 || i == 0+13 || i == 0+20 || i == 0+27) {
				lista.add(new DiaTemperatura((i+1), DiaSemana.DOMINGO));
			}
			
		}
	}

}
