package mueble;

public abstract class Mueble {
	
	// atributos inmutables estaticos de la clase
	public static final double MIN_PRECIO = 0.01;
	public static final double MAX_PRECIO = 10000;
	
	//atributos inmutables de cada objeto
	private final int identificador;
	private final String descripcion;
	private static int contadorIdentificador = 1;
	
	//atributos de cada objeto
	protected double precio;
	
	public Mueble(double precio, String descripcion)throws IllegalArgumentException  {
		setPrecio(precio);
		this.identificador = contadorIdentificador;
		this.descripcion = descripcion;
		contadorIdentificador++;
		
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) throws IllegalArgumentException {
		if(precio >= MIN_PRECIO && precio <= MAX_PRECIO) {
			this.precio = precio;
		}else {
			throw new IllegalArgumentException  ("El precio no está en el rango permitido: " + precio);
		}
	}
	public int getId() {
		return identificador;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	
	@Override
	public String toString() {
		return String.format("Tipo= %s, identificador= %d, precio= %.2f, descripcion= %s",getClass(), getId(), getPrecio(), getDescripcion());
	}
	
	
	
	
	
	
}
