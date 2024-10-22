package mueble;

public final class Silla extends Asiento implements Ajustable{
	

	//atributos inmutables estaticos de la clase
	public static final int MIN_POSICION = 1;
	public static final int MAX_POSICION = 4;
	
	//atributos de cada objeto
	private int poscionRespaldo;
	
	public Silla(double precio, String descripcion, String tapiceria, String color) throws IllegalArgumentException {
		super(precio, descripcion, Asiento.MIN_PLAZAS, tapiceria, color);
		this.poscionRespaldo = MIN_POSICION;
	}
	
	

	public int getPoscionRespaldo() {
		return poscionRespaldo;
	}



	public void setPoscionRespaldo(int poscionRespaldo) throws IllegalStateException{
		if(poscionRespaldo < MIN_POSICION){
			throw new IllegalStateException("Error: no se puede bajar a la posición " +  poscionRespaldo + ", ya que la posición minima es " + MIN_POSICION); 
		}if(poscionRespaldo > MAX_POSICION) {
			throw new IllegalStateException("Error: no se puede subir a la posición " +  poscionRespaldo + ", ya que la posición máxima es " + MAX_POSICION);
		}else {
			this.poscionRespaldo = poscionRespaldo;	
		}
	}



	@Override
	public int obtenerPosicion() {
		return getPoscionRespaldo();
	}

	@Override
	public int subirPosicion() throws IllegalStateException {
		setPoscionRespaldo(getPoscionRespaldo() + 1);
		return getPoscionRespaldo();
	}

	@Override
	public int bajarPosicion() throws IllegalStateException {
		setPoscionRespaldo(getPoscionRespaldo() - 1);
		return getPoscionRespaldo();
	}

	@Override
	public String toString() {
		return super.toString() + String.format(", poscionRespaldo= %d", getPoscionRespaldo());
	}

	
}
