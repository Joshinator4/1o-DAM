package ejercicio3;

import java.util.ArrayList;
import java.util.Comparator;

public class Trabajador implements Comparable<Trabajador>{
	
	enum TipoSexo{FEMENINO, MASCULINO};
	enum TipoEstadoCivil{CASADO, SOLTERO};
	
	/*
	//PREGUNTAR AQUI: COMO SE HARIA DE LA OTRA FORMA??? CON EL INTERFAZ COMPARATOR Y EL METODO
	public static final Comparator<Trabajador> compararSexo = (o1, o2) -> o1.getSexo().compareTo(o2.getSexo());
	public static final Comparator<Trabajador> compararEstadoCivil = (o1, o2) -> o1.getEstadoCivil().compareTo(o2.getEstadoCivil());
	public static final Comparator<Trabajador> comparadorTotal = compararSexo.thenComparing(compararEstadoCivil);
	*/
	
	private String nombre;
	private int edad;
	private TipoSexo sexo;
	private TipoEstadoCivil estadoCivil;
	private double salarioBase;
	
	
	
	public Trabajador(String nombre, int edad, TipoSexo sexo, TipoEstadoCivil estadoCivil,double salarioBase) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.salarioBase = salarioBase;
	}
	
	public Trabajador() {
		this("pepito", 25, TipoSexo.MASCULINO, TipoEstadoCivil.SOLTERO, 1500);
	}
	

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public TipoSexo getSexo() {
		return sexo;
	}

	public TipoEstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setSexo(TipoSexo sexo) {
		this.sexo = sexo;
	}

	public void setEstadoCivil(TipoEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	@Override
	public String toString() {
		return "Trabajador [nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", estadoCivil=" + estadoCivil
				+ ", salarioBase=" + salarioBase + "]";
	}

	//se compara con el segundo tipo solo si es igual el primer compare
	//PREGUNTAR AQUI: 1 mete antes que -1?
	@Override
	public int compareTo(Trabajador o) {
		int devolucion;
		if((this.sexo.compareTo(o.getSexo()) < 0)) {
			devolucion = -1;
		}else if((this.sexo.compareTo(o.getSexo()) > 0)) {
			devolucion = 1;
		}else {
			if((this.estadoCivil.compareTo(o.getEstadoCivil())) < 0) {
				devolucion = -1;
			}else if((this.estadoCivil.compareTo(o.getEstadoCivil())) > 0) {
				devolucion = 1;
			}else {
				devolucion = 0;
			}
		}
		return devolucion;
	}
	
	
	
}
