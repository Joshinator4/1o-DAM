package ejercicio1;

/*Autor: Joshua Sangareau Quesada
Fecha: 23 may 2024 
Descripcion: clase Coche
*/
public class Coche extends Vehiculo{
	
	
	enum Estado {NUEVO, DAÑADO_PARCIAL, DAÑADO};

	private int kilometros;
	private Estado estado;
	
	public Coche(String matricula, String dni, String telefono,String modelo, int kilometros, Estado estado) throws IllegalArgumentException {
		super(matricula, dni, telefono, modelo);
		if(kilometros < 0) {
			throw new IllegalArgumentException("Los km del coche no pueden ser menores a 0, no se creará el estacionamiento");
		}else {
			this.kilometros = kilometros;
		}
		this.estado = estado;
	}
	
	

	@Override
	public String toString() {
		return super.toString() + "Coche [kilometros=" + kilometros + ", estado=" + estado + "]";
	}



	public int getKilometros() {
		return kilometros;
	}



	public Estado getEstado() {
		return estado;
	}



	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}



	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	


	//metodo abstracto para calcular el precio de coche
	@Override
	public double calcularPrecio(int dias) {
		double devolucion;
		if(dias < 30) {
			devolucion = 3 * dias;
		}else if(dias >= 30 && dias <= 60) {
			devolucion = 2.5 * dias;
		}else {
			devolucion = 2 * dias;
		}
		return devolucion;
	}
	
	
	
	
}
