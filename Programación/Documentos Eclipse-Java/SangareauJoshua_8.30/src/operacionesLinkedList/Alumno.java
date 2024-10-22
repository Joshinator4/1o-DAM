package operacionesLinkedList;

public class Alumno implements Comparable<Alumno>{
	
	private String grupo;
	private String nombre;
	private int matematicas;
	private int lengua;
	private int fisica;
	private int quimica;
	private int ingles;
	
	
	public Alumno(String grupo, String nombre, int matematicas, int lengua, int fisica, int quimica, int ingles) {
		this.grupo = grupo;
		this.nombre = nombre;
		this.matematicas = matematicas;
		this.lengua = lengua;
		this.fisica = fisica;
		this.quimica = quimica;
		this.ingles = ingles;
	}
	
	


	public String getGrupo() {
		return grupo;
	}




	public String getNombre() {
		return nombre;
	}




	public int getMatematicas() {
		return matematicas;
	}




	public int getLengua() {
		return lengua;
	}




	public int getFisica() {
		return fisica;
	}




	public int getQuimica() {
		return quimica;
	}




	public int getIngles() {
		return ingles;
	}




	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public void setMatematicas(int matematicas) {
		this.matematicas = matematicas;
	}




	public void setLengua(int lengua) {
		this.lengua = lengua;
	}




	public void setFisica(int fisica) {
		this.fisica = fisica;
	}




	public void setQuimica(int quimica) {
		this.quimica = quimica;
	}




	public void setIngles(int ingles) {
		this.ingles = ingles;
	}
	
	




	@Override
	public String toString() {
		return "Alumno [grupo=" + grupo + ", nombre=" + nombre + ", matematicas=" + matematicas + ", lengua=" + lengua
				+ ", fisica=" + fisica + ", quimica=" + quimica + ", ingles=" + ingles + "]";
	}




	@Override
	public int compareTo(Alumno o) {
		int devolucion = 0;
		if(grupo.compareTo(o.grupo)<0) {
			devolucion = -1;
		}else if(grupo.compareTo(o.grupo)>0) {
			devolucion = 1;
		}else {
			if(nombre.compareTo(o.nombre)< 0) {
				devolucion = -1;
			}else if(nombre.compareTo(o.nombre)> 0) {
				devolucion = 1;
			}
		}
		return devolucion;
	}
	
	
	
	
}
