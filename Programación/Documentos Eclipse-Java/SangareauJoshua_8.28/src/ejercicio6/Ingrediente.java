package ejercicio6;

public class Ingrediente implements Comparable<Ingrediente> {
	
	private static int contadorCodigo = 1;
	
	private int codigoIngrediente;
	private String nombreIngrediente;
	private int cantidadExistencia;
	private int cantidadMinima;
	
	
	public Ingrediente(String nombreIngrediente, int cantidadExistencia, int cantidadMinima) {
		this.codigoIngrediente = contadorCodigo;
		this.nombreIngrediente = nombreIngrediente;
		this.cantidadExistencia = cantidadExistencia;
		this.cantidadMinima = cantidadMinima;
		contadorCodigo++;
	}
	
	public Ingrediente() {
		this("Ingrediente desconocido", 25, 5);
		
	}


	public int getCodigoIngrediente() {
		return codigoIngrediente;
	}


	public String getNombreIngrediente() {
		return nombreIngrediente;
	}


	public int getCantidadExistencia() {
		return cantidadExistencia;
	}


	public int getCantidadMinima() {
		return cantidadMinima;
	}


	public void setCodigoIngrediente(int codigoIngrediente) {
		this.codigoIngrediente = codigoIngrediente;
	}


	public void setNombreIngrediente(String nombreIngrediente) {
		this.nombreIngrediente = nombreIngrediente;
	}


	public void setCantidadExistencia(int cantidadExistencia) {
		int restante = this.cantidadExistencia;
		if(cantidadExistencia < 0) {
			this.cantidadExistencia = 0;
			System.out.println("Se ha agotado el ingrediente" + this.codigoIngrediente +", solo se ha podido proporcionar: " + restante + " unidades de ingrediente" );
			
		}else {
			this.cantidadExistencia = cantidadExistencia;
		}
	}


	public void setCantidadMinima(int cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}


	@Override
	public String toString() {
		return "Ingrediente [codigoIngrediente=" + codigoIngrediente + ", nombreIngrediente=" + nombreIngrediente
				+ ", cantidadExistencia=" + cantidadExistencia + ", cantidadMinima=" + cantidadMinima + "]";
	}
	

	//PREGUNTAR AQUISI EL ARRAYLIST SIN COMPARE LOS ORDENARIA SOLO???
	@Override
	public int compareTo(Ingrediente o) {
		int devolucion;
		if(this.codigoIngrediente < o.getCodigoIngrediente()) {
			devolucion = 1;
		}else if(this.codigoIngrediente > o.getCodigoIngrediente()) {
			devolucion = -1;
		}else {
			devolucion = 0;
		}
		return devolucion;
	}
	
	
	
}
