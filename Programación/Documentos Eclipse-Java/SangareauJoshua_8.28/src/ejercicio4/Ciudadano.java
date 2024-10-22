package ejercicio4;

public class Ciudadano {
	
	enum TipoSexo{MASCULINO, FEMENINO,};
	enum TipoEstadoCivil{CASADO, SOLTERO, VIUDO, DIVORCIADO};
	
	private String nombre;
	private int edad;
	private TipoSexo sexo;
	private TipoEstadoCivil estadoCivil;
	
	public Ciudadano (String nombre,int edad, TipoSexo sexo, TipoEstadoCivil estadoCivil) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
	}
	
	public Ciudadano() {
		this("Nombre desconocido", 30, TipoSexo.MASCULINO, TipoEstadoCivil.SOLTERO);
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

	@Override
	public String toString() {
		return "Ciudadano [nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", estadoCivil=" + estadoCivil
				+ "]";
	}
	
	
}
