package ejercicio1;

public class VehiculoTransporte extends Vehiculo{
	
	enum TipoVehiculoTransporte{COCHE, MINIBUS}
	
	private TipoVehiculoTransporte tipo;
	private int numeroPlazas;
	
	public VehiculoTransporte(String matricula, int numeroPlazas, TipoVehiculoTransporte tipo) throws IllegalArgumentException {
		super(matricula);
		this.numeroPlazas = numeroPlazas;
		this.tipo = tipo;
		
	}

	public TipoVehiculoTransporte getTipo() {
		return tipo;
	}

	public int getNumeroPlazas() {
		return numeroPlazas;
	}

	public void setTipo(TipoVehiculoTransporte tipo) {
		this.tipo = tipo;
	}

	public void setNumeroPlazas(int numeroPlazas) {
		this.numeroPlazas = numeroPlazas;
	}

	@Override
	public String toString() {
		return "VehiculoTransporte [tipo=" + tipo + ", numeroPlazas=" + numeroPlazas + "]";
	}

	@Override
	public String obtenerPrecioAlquiler(int numDias) {
		String devolucion;
		double calculo=0;
		if(this.tipo.equals(TipoVehiculoTransporte.COCHE)) {
			calculo = ((50*numDias) + (1.5*this.numeroPlazas*numDias));
		}else {
			calculo = 50*numDias + (2*this.numeroPlazas);
		}
		return "Este es el precio de alquiler de este vehiculo para " + numDias + " dias: " + calculo + "€";
	}
	
	
	

}
