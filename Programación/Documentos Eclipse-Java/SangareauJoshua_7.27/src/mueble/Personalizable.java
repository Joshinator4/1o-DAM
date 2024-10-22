package mueble;

public interface Personalizable {
	
	public String obtenerModulos();
	
	public void anyadirModulo(Modulo modulo) throws IllegalStateException, NullPointerException;
	
	public Modulo extraerModulo() throws IllegalStateException;
	
}
