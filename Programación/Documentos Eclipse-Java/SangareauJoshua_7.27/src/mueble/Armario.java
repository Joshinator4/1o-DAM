package mueble;

public class Armario extends Almacenaje {
	
	// atributos inmutables estaticos de la clase
	public static final int MIN_PUERTAS  = 1;
	public static final int MAX_PUERTAS = 6; 
	
	//atributos de cada objeto
	private int numeroPuertas;
	
	
	public Armario(double precio, String descripcion, double anchura, double altura, int maxModulos, int cantPuertas)throws IllegalArgumentException {
		super(precio, descripcion, anchura, altura, maxModulos);
		setNumeroPuertas(cantPuertas);
	}


	public int getNumPuertas() {
		return numeroPuertas;
	}


	public void setNumeroPuertas(int numeroPuertas) throws IllegalArgumentException {
		if(numeroPuertas < MIN_PUERTAS || numeroPuertas > MAX_PUERTAS) {
			throw new IllegalArgumentException("El número de puertas no está en el rango permitido: " + numeroPuertas );
		}else {
			this.numeroPuertas = numeroPuertas;
		}
	}


	@Override
	public String toString() {
		return super.toString() + String.format("numeroPuertas= %d", getNumPuertas());
	}

	
	
	
}
