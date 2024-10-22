package ejercicio3;

import java.time.LocalDate;

import ejercicio3.Personal.Genero;

public class PAS extends Personal{
	
	private boolean aleman;
	private boolean chino;
	private boolean ingles;
	private String areaAtencion;
	
	public PAS (String dni, String nombre, String apellidos, LocalDate fechaNacimiento, Genero genero, double salario, String telefono, String email,
			boolean aleman, boolean chino, boolean ingles, String atencion) {
		
		super(dni, nombre, apellidos, fechaNacimiento, genero, salario, telefono, email);
		this.aleman = aleman;
		this.chino = chino;
		this.ingles =  ingles;
		setAreaAtencion(atencion);
	}
	
	public PAS () {
		super();
		this.aleman = false;
		this.chino = false;
		this.ingles = false;
		setAreaAtencion("Sin area asignada");
	}

	public boolean isAleman() {
		return aleman;
	}


	public boolean isChino() {
		return chino;
	}


	public boolean isIngles() {
		return ingles;
	}


	public String getAreaAtencion() {
		return areaAtencion;
	}

	public void setAreaAtencion(String areaAtencion) {
		this.areaAtencion = areaAtencion;
	}
	
	public int numeroIdiomas() {
		int devolucion=0;
		if(this.aleman == true ) {
			devolucion += 1;
		}
		if(this.chino == true ) {
			devolucion += 1;
		}
		if( this.ingles == true) {
			devolucion += 1;
		}
		
		return devolucion;
	}

	@Override
	public String toString() {
		return super.toString() + "PAS [aleman=" + siONo(aleman) + ", chino=" + siONo(chino) + ", ingles=" + siONo(ingles) + ", areaAtencion=" + areaAtencion
				+ "]";
	}
	
	public void cambioIdioma(String idioma){
		idioma.toLowerCase();
		if(idioma.equals("aleman")) {
			if(this.aleman == false) {
				this.aleman = true;
			}else {
				this.aleman = false;
			}
		}
		if(idioma.equals("chino")) {
			if(this.chino == false) {
				this.chino =true;
			}else {
				this.chino = false;
			}
		}
		if(idioma.equals("ingles")) {
			if(this.ingles == false) {
				this.ingles = true;
			}else {
				this.ingles = false;
			}
		}
		if(!idioma.equals("aleman")&&!idioma.equals("chino")&&!idioma.equals("ingles")) {
			throw new IllegalStateException("El idioma introducido es incorrecto, solo se aceptan aleman, chino e ingles");
		}
	}
	
	public String siONo(boolean metodo) {
		String devolucion;
		if(metodo == true) {
			devolucion = "Si";
		}else {
			devolucion = "No";
		}
		return devolucion;
	}
}
