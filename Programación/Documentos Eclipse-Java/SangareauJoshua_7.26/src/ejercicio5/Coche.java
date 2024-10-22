package ejercicio5;

public class Coche extends VehiculoTerrestre{
	
	private boolean aireAcondicionado; //Si tiene o no aire acondicionado el coche
	
	public Coche(String matricula, String modelo, int numeroRuedas, boolean aire) throws IllegalArgumentException {
		super(matricula, modelo, numeroRuedas);
		this.aireAcondicionado = aire;
	}
	
	public Coche (boolean aire){
		super();
		setAireAcondicionado(aire);
	}
	
	public Coche (){
		super();
		setAireAcondicionado(false);
	}
	
	
	
	public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(boolean aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}

	@Override
	public String toString() {
		return super.toString() + "Coche [Aire Acondicionado = " + siONo(this.aireAcondicionado) + "]";
	}
	
	//Este metodo sirve para mostrar si o no en vez de true o false
	private String siONo (boolean x) {
		String devolucion;
		if(x) {
			devolucion = "Si";
		} else {
			devolucion = "No";
		}
		return devolucion;
	}
	
}
