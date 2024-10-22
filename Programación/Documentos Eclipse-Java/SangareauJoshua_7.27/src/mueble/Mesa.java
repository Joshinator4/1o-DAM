package mueble;

public final class Mesa extends Mueble{
	
	// atributos inmutables estaticos de la clase
	public static final int MIN_COMENSALES  = 4;
	public static final int MAX_COMENSALES = 16; 
	
	
	//atributos de cada objeto
	private String forma;
	private int comensales;
	

	public Mesa(double precio, String descripcion, String forma, int numeroComensales) throws IllegalArgumentException {
		super(precio, descripcion);
		setComensales(numeroComensales);
		this.forma = forma;
	}


	public String getForma() {
		return forma;
	}


	public int getComensales() {
		return comensales;
	}


	public void setForma(String forma) {
		this.forma = forma;
	}


	public void setComensales(int comensales) {
		if(comensales%2!=0) {
			throw new IllegalArgumentException("ERROR: el los comensales deben ser multiplo de 2 y mayor que " + MIN_COMENSALES + " y menor que " + MAX_COMENSALES);
		} else if(comensales < MIN_COMENSALES) {
			throw new IllegalArgumentException("ERROR: el los comensales deben ser mayor que " + MIN_COMENSALES);
		}else if(comensales > MAX_COMENSALES) {
			throw new IllegalArgumentException("ERROR: el los comensales deben ser menor que " + MAX_COMENSALES);
		}else {
			this.comensales = comensales;
		}
		
	}


	@Override
	public String toString() {
		return super.toString() + String.format("forma= %s, comensales= %d", getForma(), getComensales());
	}
	
	

}
