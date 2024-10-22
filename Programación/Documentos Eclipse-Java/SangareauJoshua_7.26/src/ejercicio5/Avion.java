package ejercicio5;

public class Avion extends VehiculoAereo{
	
	private int tiempoMaxVuelo; //Tiempo maximo en horas que puede volar el avion siendo el minimo 2h y el maximo 15h
	
	public Avion(String matricula, String modelo, int numeroAsientos, int tiempoMaxVuelo) throws IllegalArgumentException{
		super(matricula, modelo, numeroAsientos);
		setTiempoMaxVuelo(tiempoMaxVuelo);
	}
	
	public Avion(int tiempoMaxVuelo)throws IllegalArgumentException {
		super();
		setTiempoMaxVuelo(tiempoMaxVuelo);
	}
	
	public Avion() {
		super();
		setTiempoMaxVuelo(5);
	}

	public int getTiempoMaxVuelo() {
		return tiempoMaxVuelo;
	}

	public void setTiempoMaxVuelo(int tiempoMaxVuelo) throws IllegalArgumentException{
		if(tiempoMaxVuelo < 2 || tiempoMaxVuelo > 15) {
			throw new IllegalArgumentException("ERROR: El tiempo de vuelo debe ser superior o igual a 2h e inferior o igual a 15h");
		}else {
			this.tiempoMaxVuelo = tiempoMaxVuelo;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Avion [tiempoMaxVuelo=" + tiempoMaxVuelo + "]";
	}
	
	
	
	
}
