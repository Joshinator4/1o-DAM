package ejercicio4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ejercicio4.Ciudadano.TipoEstadoCivil;
import ejercicio4.Ciudadano.TipoSexo;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		//PREGUNTAR AQUI: CUANDO EL EJERCICIO DICE consultar rápidamente A QUE TIPO DE COLECCION SE REFIERE?? ArrayList es lo mas rápido
		ArrayList <Ciudadano> listaCiudadanos = new ArrayList<>();
		boolean bandera = true;
		int numeroIntroducido, numeroSexo, numeroEstadoCivil;
		TipoSexo sexoIntroducido;
		TipoEstadoCivil estadoIntroducido;
		
		Ciudadano ciudadano1 = new Ciudadano();
		Ciudadano ciudadano2 = new Ciudadano("Joshua", 31, TipoSexo.MASCULINO, TipoEstadoCivil.SOLTERO);
		Ciudadano ciudadano3 = new Ciudadano("Rafa", 31, TipoSexo.MASCULINO, TipoEstadoCivil.CASADO);
		Ciudadano ciudadano4 = new Ciudadano("Richard", 50, TipoSexo.MASCULINO, TipoEstadoCivil.VIUDO);
		Ciudadano ciudadano5 = new Ciudadano("Leticia", 40, TipoSexo.FEMENINO, TipoEstadoCivil.DIVORCIADO);
		Ciudadano ciudadano6 = new Ciudadano("Maria", 19, TipoSexo.FEMENINO,TipoEstadoCivil.CASADO);
		Ciudadano ciudadano7 = new Ciudadano("Lucia", 27, TipoSexo.FEMENINO,TipoEstadoCivil.VIUDO);
		Ciudadano ciudadano8 = new Ciudadano("Natalia", 67, TipoSexo.FEMENINO,TipoEstadoCivil.DIVORCIADO);
		
		listaCiudadanos.add(ciudadano1);
		listaCiudadanos.add(ciudadano2);
		listaCiudadanos.add(ciudadano3);
		listaCiudadanos.add(ciudadano4);
		listaCiudadanos.add(ciudadano5);
		listaCiudadanos.add(ciudadano6);
		listaCiudadanos.add(ciudadano7);
		listaCiudadanos.add(ciudadano8);
		
		do {
			System.out.println("Introduzca el numero de opcion a realizar\n1.-Cantidad de personas del sexo deseado\n2.-Cantidad de personas del estado civil deseado\n"
					+ "3.-Cantidad de personas en el rango de edad deseado\n4.-Cantidad de personas con el sexo y estado civil deseado");
			numeroIntroducido = teclado.nextInt();
			switch(numeroIntroducido) {
				case (1):{
					System.out.println("Introduzca el sexo deseado: 1.- Masculino 2.- Femenino");
					numeroIntroducido = teclado.nextInt();
					if(numeroIntroducido == 1) {
						System.out.println("cantidad de ciudadanos de sexo masculino: " + cantidadCiudadanosPorSexo(TipoSexo.MASCULINO, listaCiudadanos)); 
					}else if(numeroIntroducido == 2) {
						System.out.println("cantidad de ciudadanos de sexo femenino: " + cantidadCiudadanosPorSexo(TipoSexo.FEMENINO, listaCiudadanos)); 
					}else {
						System.out.println("El numero introducido es incorrecto");
					}
					break;
					
				}case (2):{
					System.out.println("Introduzca el estado civil deseado: 1.- soltero 2.- casado 3.-viudo 4.-divorciado");
					numeroIntroducido = teclado.nextInt();
					if(numeroIntroducido == 1) {
						System.out.println("cantidad de ciudadanos de estado civil soltero: " + cantidadCiudadanosPorEstadoCivil(TipoEstadoCivil.SOLTERO, listaCiudadanos)); 
					}else if(numeroIntroducido == 2) {
						System.out.println("cantidad de ciudadanos de estado civil casado: " + cantidadCiudadanosPorEstadoCivil(TipoEstadoCivil.CASADO, listaCiudadanos)); 
					}else if(numeroIntroducido == 3) {
						System.out.println("cantidad de ciudadanos de estado civil viudo: " + cantidadCiudadanosPorEstadoCivil(TipoEstadoCivil.VIUDO, listaCiudadanos));
					}else if(numeroIntroducido == 4) {
						System.out.println("cantidad de ciudadanos de estado civil divorciado: " + cantidadCiudadanosPorEstadoCivil(TipoEstadoCivil.DIVORCIADO, listaCiudadanos));
					}else {
						System.out.println("El numero introducido es incorrecto");
					}
					break;
				
				}case(3):{
					System.out.println("Introduzca el rango de edad deseado por décadas (multiplos de 10. Tambien se puede introducir 0)");
					numeroIntroducido = teclado.nextInt();
					System.out.println("cantidad de ciudadanos en el rango de edad introducido: " + cantidadCiudadanosPorDecada(numeroIntroducido, listaCiudadanos));
					break;
					
				}case(4):{
					System.out.println("Introduzca el sexo deseado: 1.- Masculino 2.- Femenino");
					numeroSexo = teclado.nextInt();
					if(numeroSexo == 1) {
						sexoIntroducido =TipoSexo.MASCULINO;
					}else if(numeroSexo == 2) {
						sexoIntroducido =TipoSexo.FEMENINO;
					}else {
						System.out.println("Numero introducido incorrecto, por defecto se pondra masculino");
						sexoIntroducido =TipoSexo.MASCULINO;
					}
					System.out.println("Introduzca el estado civil deseado: 1.- soltero 2.- casado 3.-viudo 4.-divorciado");
					numeroEstadoCivil = teclado.nextInt();
					
					if(numeroEstadoCivil == 1) {
						estadoIntroducido = TipoEstadoCivil.SOLTERO;
					}else if(numeroEstadoCivil == 2) {
						estadoIntroducido = TipoEstadoCivil.CASADO;
					}else if(numeroEstadoCivil == 3) {
						estadoIntroducido = TipoEstadoCivil.VIUDO;
					}else if(numeroEstadoCivil == 4) {
						estadoIntroducido = TipoEstadoCivil.DIVORCIADO;
					}else {
						System.out.println("Numero introducido incorrecto por defecto se pondra soltero");
						estadoIntroducido = TipoEstadoCivil.SOLTERO;
					}
					System.out.println("Mostrando cantidad de ciudadanos con el sexo y estado civil introducidos: " + cantidadCiudadanosPorSexoYEstadoCivil(sexoIntroducido, estadoIntroducido, listaCiudadanos));
					break;
					
				}case(0):{
					System.out.println("Se va a proceder a salir del programa, ¡Hasta pronto!");
					bandera = false;
					break;
					
				}default:{
					System.out.println("Numero incorecto introduzca un numero del 1 al 4");
					break;
				}
				
				}
		
	
		
		}while(bandera==true);

	}
	
	public static int cantidadCiudadanosPorSexo(TipoSexo sexo, ArrayList <Ciudadano> lista) {
		int devolucion = 0;
		for(Ciudadano i: lista) {
			if(i.getSexo().equals(sexo)) {
				devolucion += 1;
			}
		}
		return devolucion;
	}
	
	public static int cantidadCiudadanosPorEstadoCivil(TipoEstadoCivil estadoCivil, ArrayList <Ciudadano> lista) {
		int devolucion = 0;
		for(Ciudadano i: lista) {
			if(i.getEstadoCivil().equals(estadoCivil)) {
				devolucion += 1;
			}
		}
		return devolucion;
	}
	
	public static int cantidadCiudadanosPorDecada(int decada, ArrayList <Ciudadano> lista) {
		int devolucion = 0;
		for(Ciudadano i: lista) {
			if(i.getEdad()>= decada && i.getEdad()<=(decada+9)) {
				devolucion += 1;
			}
		}
		return devolucion;
	}
	
	
	public static int cantidadCiudadanosPorSexoYEstadoCivil(TipoSexo sexo, TipoEstadoCivil estadoCivil, ArrayList <Ciudadano> lista) {
		int devolucion = 0;
		for(Ciudadano i: lista) {
			if(i.getSexo().equals(sexo) && i.getEstadoCivil().equals(estadoCivil)) {
				devolucion += 1;
			}
		}
		return devolucion;
	}
}
