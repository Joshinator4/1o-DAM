package mueble;

public class Asiento extends Mueble{
	
	//atributos inmutables estaticos de la clase
	public static final int MIN_PLAZAS = 1;
	public static final int MAX_PLAZAS = 9;
	
	//atributos inmutables de cada objeto
	private final int plazasAsiento;
	private final String tapiceria;
	private final String color;
	
	
	public Asiento(double precio, String descripcion, int plazas,  String tapiceria, String color) throws IllegalArgumentException {
		super(precio, descripcion);
		if(plazas < MIN_PLAZAS || plazas > MAX_PLAZAS) {
			throw new IllegalArgumentException ("El número de plazas no está en el rango permitido: " + plazas);
		}else {
			this.plazasAsiento = plazas;
		}
		this.tapiceria = tapiceria;
		this.color = color;
		
		
	}


	public int getNumPlazas() {
		return plazasAsiento;
	}


	public String getTapiceria() {
		return tapiceria;
	}


	public String getColor() {
		return color;
	}


	@Override
	public String toString() {
		return super.toString() + String.format(" plazasAsiento= %d, tapiceria= %s, color= %s", getNumPlazas(), getTapiceria(), getColor());
	}

	
}
