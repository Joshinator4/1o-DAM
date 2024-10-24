package ejercicio1;

/*Autor: Joshua Sangareau Quesada
Fecha: 23 may 2024 
Descripcion: clase Moto
*/
public class Moto extends Vehiculo{
	
	private int espejos;
	private boolean casco;
	
	public Moto(String matricula, String dni, String telefono, String modelo, int espejos, boolean casco) {
		super(matricula, dni, telefono, modelo);
		this.espejos = espejos;
		this.casco = casco;
	}

	//metodo abstracto para calcular el precio de moto
	@Override
	public double calcularPrecio(int dias) {
		double devolucion;
		if(dias < 30) {
			devolucion = 1.5 * dias;
		}else if(dias >= 30 && dias <= 90) {
			devolucion = 1 * dias;
		}else {
			devolucion = 0.5 * dias;
		}
		return devolucion;
	}

	public int getEspejos() {
		return espejos;
	}

	public String isCasco() {
		String devolucion;
		if(this.casco) {
			devolucion = "Si";
		}else {
			devolucion = "No";
		}
		return devolucion;
	}

	public void setEspejos(int espejos) {
		this.espejos = espejos;
	}

	public void setCasco(boolean casco) {
		this.casco = casco;
	}

	@Override
	public String toString() {
		return super.toString() + "Moto [espejos=" + espejos + ", casco=" + isCasco() + "]";
	}
	
	
	
	
	
	
}
