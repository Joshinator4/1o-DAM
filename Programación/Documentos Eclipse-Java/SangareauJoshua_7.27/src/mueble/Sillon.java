package mueble;

public final class Sillon extends Asiento implements Ajustable{
	
	//atributos inmutables estaticos de la clase
	public static final int POS_BAJADO = 0;
	public static final int POS_SUBIDO = 1;
	
	//atributos de cada objeto
	private int posicionPies;
	

	public Sillon(double precio, String descripcion, String tapiceria, String color) throws IllegalArgumentException {
		super(precio, descripcion, Asiento.MIN_PLAZAS, tapiceria, color);
		setPosicionPies(0);
	}
	
	

	public int getPosicionPies() {
		return posicionPies;
	}



	public void setPosicionPies(int posicionPies) throws IllegalArgumentException {
		if(posicionPies == 0 || posicionPies == 1) {
			this.posicionPies = posicionPies;
		}else {
			throw new IllegalArgumentException ("Error: la posicion de los pies del sillon solo puede ser 0 o 1");
		}
	}

	public String getPiscionEnString() {
		String devolucion ="";
		if(getPosicionPies() == 0) {
			devolucion = "bajada";
		}else if(getPosicionPies() == 1) {
			devolucion = "subida";
		}
		return devolucion;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(", posicionPies= %s", getPiscionEnString());
	}



	@Override
	public int obtenerPosicion() {
		return getPosicionPies();
	}

	@Override
	public int subirPosicion() throws IllegalStateException {
		if(getPosicionPies() + 1 > 1) {
			throw new IllegalStateException("Error: no se pueden subir los pies del sillón. Ya están subidos"); 
		}else{
			setPosicionPies(getPosicionPies() + 1);
		}
		return getPosicionPies();
	}

	@Override
	public int bajarPosicion() throws IllegalStateException {
		if(getPosicionPies() - 1 < 0) {
			throw new IllegalStateException("Error: no se pueden bajar los pies del sillón. Ya están bajados"); 
		}else{
			setPosicionPies(getPosicionPies() - 1);
		}
		return getPosicionPies();
	}
	
	
	
	
}
