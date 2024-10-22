package mueble;

public interface Ajustable {
	
	public int obtenerPosicion();
	
	public int subirPosicion() throws IllegalStateException; //sube UNA posicion
	
	public int bajarPosicion() throws IllegalStateException;//baja UNA posicion

}
