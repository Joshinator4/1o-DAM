package ejercicio1;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList <Atleta> guardarAtletas = new ArrayList<>();
		Atleta atleta1 = new Atleta();
		Atleta atleta2 = new Atleta();
		Atleta atleta3 = new Atleta();
		Atleta atleta4 = new Atleta("Joshua", 31, 1.85);
		Atleta atleta5 = new Atleta("Rafa", 17, 1.80);
		
		guardarAtletas.add(atleta1);
		guardarAtletas.add(atleta2);
		guardarAtletas.add(atleta3);
		guardarAtletas.add(atleta4);
		guardarAtletas.add(atleta5);
		
		System.out.println("Mostrando la media de edad " + calcularPromedioEdades(guardarAtletas));
		System.out.println("Mostrando la media de altura " + calcularPromedioTallas(guardarAtletas));
		System.out.println("Mostrando cuantos son mayores de edad " + cantidadMayoresEdad(guardarAtletas));
		System.out.println("Mostrando cuantos son menores de edad " + cantidadMenoresEdad(guardarAtletas));
		System.out.println("Mostrando nombres de los que sobrepasan la media " + nombreMasAltosMedia(guardarAtletas));
		
	}
	
	//PREGUNTAR AQUI: no me deja pasarle el array list por parametro, por eso lo creo estatico en la calse principal fuera del main ERROR: Type mismatch: cannot convert from element type Object to Atleta
	public static double calcularPromedioEdades(ArrayList <Atleta> lista) {
		double devolucion = 0;
		for(Atleta i: lista) {
			devolucion += i.getEdad();
		}
		devolucion= devolucion/lista.size();
		return devolucion;
	}
	
	public static double calcularPromedioTallas(ArrayList <Atleta> lista) {
		double devolucion = 0;
		for(Atleta i: lista) {
			devolucion += i.getAltura();
		}
		devolucion= devolucion/lista.size();
		return devolucion;
	}
	
	public static int cantidadMayoresEdad(ArrayList <Atleta> lista) {
		int devolucion = 0;
		for(Atleta i: lista) {
			if(i.getEdad()>=18) {
				devolucion+=1;
			}
		}
		return devolucion;
		
	}
	
	public static int cantidadMenoresEdad(ArrayList <Atleta> lista) {
		int devolucion = 0;
		for(Atleta i: lista) {
			if(i.getEdad()<18) {
				devolucion+=1;
			}
		}
		return devolucion;
		
	}
	
	public static String nombreMasAltosMedia(ArrayList <Atleta> lista) {
		String devolucion = "";
		double media = calcularPromedioTallas(lista);
		for(Atleta i: lista) {
			if(i.getAltura()>media) {
				devolucion += i.getNombre() + ", ";
			}
		}
		if(devolucion.isEmpty()) {
			devolucion = "No hay nadie por encima de la media";
		}else {
			devolucion += " Estos son los Atletas por encima de la media";
		}
		return devolucion;
	}
		

}
