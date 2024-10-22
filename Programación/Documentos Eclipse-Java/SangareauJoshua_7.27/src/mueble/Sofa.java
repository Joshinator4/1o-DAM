package mueble;

public class Sofa extends Asiento{
	
	private String composicion;

	public Sofa(double precio, String descripcion, int plazas, String tapiceria, String color, String composicion)throws IllegalArgumentException {
		super(precio, descripcion, plazas, tapiceria, color);
		setComposicion(composicion);
	}

	public String getComposicion() {
		return composicion;
	}

	public void setComposicion(String composicion) {
		this.composicion = composicion;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(", composicion= ", getComposicion());
	}
	
	

}
