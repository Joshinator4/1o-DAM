package mueble;

public final class Estanteria extends Almacenaje{
	
	//atributos de cada objeto
	private String tipoEstanteria;

	public Estanteria(double precio, String descripcion, double anchura, double altura, int maxModulos, String tipoEstanteria)throws IllegalArgumentException {
		super(precio, descripcion, anchura, altura, maxModulos);
		setTipoEstanteria(tipoEstanteria);
		
	}

	public String getTipo() {
		return tipoEstanteria;
	}

	public void setTipoEstanteria(String tipoEstanteria) {
		this.tipoEstanteria = tipoEstanteria;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" tipoEstanteria= %s", getTipo());
	}
	
	@Override
	public void anyadirModulo(Modulo modulo) throws NullPointerException, IllegalArgumentException  {
		if(modulo == null ) {
			throw new NullPointerException ("Error: el módulo a añadir no puede ser nulo");
		}else if (modulo != Modulo.BALDA) {
			throw new IllegalArgumentException ("El modulo añadido a una estanteria solo puede ser una BALDA");
		}else {
			super.anyadirModulo(modulo);
		}
	}
	
	

}
