package ejercicio3;

import java.util.ArrayList;
import java.util.Collections;

import ejercicio3.Trabajador.TipoEstadoCivil;
import ejercicio3.Trabajador.TipoSexo;

public class Principal {
	
	public static void main(String[] args) {
		
		ArrayList <Trabajador> arrayTrabajadores = new ArrayList <>();
		Trabajador trabajador1 = new Trabajador();
		Trabajador trabajador2 = new Trabajador("Antonio", 25, TipoSexo.MASCULINO, TipoEstadoCivil.SOLTERO, 1525.32);
		Trabajador trabajador3 = new Trabajador("Rosa", 25, TipoSexo.FEMENINO, TipoEstadoCivil.CASADO, 1725.82);
		Trabajador trabajador4 = new Trabajador("Juan", 25, TipoSexo.MASCULINO, TipoEstadoCivil.CASADO, 200.38);
		Trabajador trabajador5 = new Trabajador("Maria", 25, TipoSexo.FEMENINO, TipoEstadoCivil.SOLTERO, 1825.93);
		
		arrayTrabajadores.add(trabajador1);
		arrayTrabajadores.add(trabajador2);
		arrayTrabajadores.add(trabajador3);
		arrayTrabajadores.add(trabajador4);
		arrayTrabajadores.add(trabajador5);
		
		System.out.println("Mostrando los trabajadores ordenados por sexo y estado civil");
		System.out.println(mostrarOrdenadoPorSexoYEstadoCivil(arrayTrabajadores));
		System.out.println("Mostrando cantidad de trabajadores masculinos");
		System.out.println(numeroTrabajadoresMasculinos(arrayTrabajadores));
		System.out.println("Mostrando cantidad de trabajadoras casadas");
		System.out.println(cantidadTrabajadorasCasadas(arrayTrabajadores));
		System.out.println("Mostrando suma total de sueldos de los trabajadores");
		System.out.println(sumaDeSueldos(arrayTrabajadores));
		
	}
	public static String mostrarOrdenadoPorSexoYEstadoCivil(ArrayList<Trabajador> lista) {
		String devolucion="";
		Collections.sort(lista);
		for(Trabajador i: lista) {
			devolucion += i.toString() + "\n";
		}
		return devolucion;
		
	}
	
	public static int numeroTrabajadoresMasculinos(ArrayList<Trabajador> lista) {
		int devolucion = 0;
		for(Trabajador i: lista) {
			if(i.getSexo().equals(TipoSexo.MASCULINO)) {
				devolucion += 1;
			}
		}
		return devolucion;
			
	}
	
	public static int cantidadTrabajadorasCasadas(ArrayList<Trabajador> lista) {
		int devolucion = 0;
		for(Trabajador i: lista) {
			if(i.getSexo().equals(TipoSexo.FEMENINO) && i.getEstadoCivil().equals(TipoEstadoCivil.CASADO)) {
				devolucion += 1;
			}
		}
		return devolucion;
		
	}
	
	public static double sumaDeSueldos(ArrayList<Trabajador> lista) {
		double devolucion = 0;
		for(Trabajador i: lista) {
			devolucion += i.getSalarioBase();
		}
		return devolucion;
	}
	
}
