package ejercicio1;

import ejercicio1.VehiculoTransporte.TipoVehiculoTransporte;

public class VehiculoCarga extends Vehiculo{
	
	enum TipoVehiculoCarga{CAMION, FURGONETA}
	
	private int taraMaxima;
	private TipoVehiculoCarga tipo;
	
	public VehiculoCarga(String matricula, int taraMaxima, TipoVehiculoCarga tipo) throws IllegalArgumentException {
		super(matricula);
		this.taraMaxima = taraMaxima;
		this.tipo = tipo;
		
	}

	public int getTaraMaxima() {
		return taraMaxima;
	}

	public TipoVehiculoCarga getTipo() {
		return tipo;
	}

	public void setTaraMaxima(int taraMaxima) {
		this.taraMaxima = taraMaxima;
	}

	public void setTipo(TipoVehiculoCarga tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "VehiculoCarga [taraMaxima=" + taraMaxima + ", tipo=" + tipo + "]";
	}

	@Override
	public String obtenerPrecioAlquiler(int numDias) {
		String devolucion;
		double calculo=0;
		if(this.tipo.equals(TipoVehiculoCarga.CAMION)) {
			calculo = 40 + ((50*numDias) + (20*taraMaxima*numDias));
		}else {
			calculo = (50*numDias) + (20*taraMaxima*numDias);
		}
		return "Este es el precio de alquiler de este vehiculo para " + numDias + " dias: " + calculo + "€";
	}

	
}
