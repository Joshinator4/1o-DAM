package ejercicioC4;

public class Articulo {
	String nombre; // el nombre del articulo
	double precio; // el precio del articulo sin iva
	final int iva; // Porcentaje de iva ya listo para multiplicarlo
	int cuantosQuedan; // Cantidad de articulos que quedan en el alamacén

	public Articulo(String nombre, double precio, int iva, int cuantosQuedan) throws IllegalArgumentException{
	
		if (iva != 21) {
			throw new IllegalArgumentException ("ERROR: Se ha creado el objeto con un IVA incorrecto, el IVA será siempre 21");
		}

		setNombre(nombre);
		setPrecio(precio);
		this.iva = iva;
		setCuantosQuedan(cuantosQuedan);
	}
	
	public Articulo(double precio, int IVA, int cuantosQuedan)throws IllegalArgumentException {
		this("anonimo", precio, IVA, cuantosQuedan);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public double getPrecio() {
		return this.precio;
	}
	
	public int getIva() {
		return this.iva;
	}
	
	public int getCuantosQuedan() {
		return this.cuantosQuedan;
	}
	
	public void setNombre(String nombre) throws IllegalArgumentException{
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException ("El nombre no se ha introducido o se ha introducido con la cadena de texto vacía, por favor introduzca un nombre al artículo");
		}else {
			this.nombre = nombre;
		}
	}
	
	public void setPrecio(double precio) throws IllegalArgumentException{
		if (precio < 0) {
			throw new IllegalArgumentException("ERROR: Se ha creado el objeto con precio incorrecto, siempre será >= 0");
		}else {
			this.precio = precio;
		}
	}
	
	public void setCuantosQuedan(int cuantosQuedan) throws IllegalArgumentException{
		if (cuantosQuedan < 0) {
			throw new IllegalArgumentException("ERROR: Se ha creado el objeto con una cantidad de cuantos quedan incorrecta, siempre será >= 0");
		}else {
			this.cuantosQuedan = cuantosQuedan;
		}
	}
	
	public String toString(){
		return "nombre del articulo " + getNombre() + ", precio: " + getPrecio() + "€, IVA: " + getIva() + "%, cuantos artículos quedan: " + getCuantosQuedan();
	}
}
