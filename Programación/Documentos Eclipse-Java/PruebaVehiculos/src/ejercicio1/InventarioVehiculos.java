package ejercicio1;

import java.util.HashSet;

import ejercicio1.VehiculoCarga.TipoVehiculoCarga;
import ejercicio1.VehiculoTransporte.TipoVehiculoTransporte;

public class InventarioVehiculos {

	
	private HashSet<Vehiculo> listaVehiculos;
	
	public InventarioVehiculos() {
		this.listaVehiculos = new HashSet<>();
		
	}
	
	public void crearVehiculoTransporte(String Matricula, int numeroPlazas, int tipoVehiculo) {
		if(tipoVehiculo == 1) {
			listaVehiculos.add(new VehiculoTransporte(Matricula, numeroPlazas, TipoVehiculoTransporte.COCHE));
		}else if(tipoVehiculo == 2) {
			listaVehiculos.add(new VehiculoTransporte(Matricula, numeroPlazas, TipoVehiculoTransporte.MINIBUS)); 

		}
	}
	
	public void crearVehiculoCarga(String Matricula, int taraMaxima, int tipoVehiculo) {
		if(tipoVehiculo == 3) {
			listaVehiculos.add(new VehiculoCarga(Matricula, taraMaxima, TipoVehiculoCarga.CAMION)); 
		}else if(tipoVehiculo == 4) {
			listaVehiculos.add(new VehiculoCarga(Matricula, taraMaxima, TipoVehiculoCarga.FURGONETA));
		}
	}
	
	public String obtenerPrecioAlquiler(String matricula, int numDias)throws IllegalArgumentException {
		String devolucion="";
		for(Vehiculo i: listaVehiculos) {
			if(i.getMatricula().equals(matricula)) {
				if(i instanceof VehiculoTransporte) {
					devolucion = i.obtenerPrecioAlquiler(numDias);
				}else if(i instanceof VehiculoCarga) {
					devolucion = i.obtenerPrecioAlquiler(numDias);
				}
			}
		}
		if(devolucion.isEmpty()) {
			throw new IllegalArgumentException("ERROR: la matrícula no existe entre nuestros vehiculos");
		}
		return devolucion;
	}
	
	public String mostrarTodosLosPrecios (int numDias)throws IllegalArgumentException  {
		String devolucion="";
		for(Vehiculo i: listaVehiculos) {
			devolucion += "\n"+i.toString() + " = " + i.obtenerPrecioAlquiler(numDias) + "€ en total";
		}
		if(devolucion.isEmpty()) {
			throw new IllegalArgumentException("ERROR: no hay vehiculos creados");
		}
		return devolucion;
		
	}
	
}
