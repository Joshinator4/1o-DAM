package ejercicioB4;

public class Articulo {
	String nombre; // el nombre del articulo
	double precio; // el precio del articulo sin iva
	final int IVA; // Porcentaje de iva ya listo para multiplicarlo
	int cuantosQuedan; // Cantidad de articulos que quedan en el alamacén

	public Articulo(String nombre, double precio, int IVA, int cuantosQuedan) throws IllegalArgumentException{
	
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException ("El nombre no se ha introducido o se ha introducido con la cadena de texto vacía, por favor introduzca un nombre al artículo");
		}
		if (IVA != 21) {
			throw new IllegalArgumentException ("ERROR: Se ha creado el objeto con un IVA incorrecto, el IVA será siempre 21");
		}

		if (cuantosQuedan < 0) {
			throw new IllegalArgumentException("ERROR: Se ha creado el objeto con una cantidad de cuantos quedan incorrecta, siempre será >= 0");
		}
		
		if (precio < 0) {
			throw new IllegalArgumentException("ERROR: Se ha creado el objeto con precio incorrecto, siempre será >= 0");
		}

		this.nombre = nombre;
		this.precio = precio;
		this.IVA = IVA;
		this.cuantosQuedan = cuantosQuedan;
		
	}
	
	public Articulo(double precio, int IVA, int cuantosQuedan) throws IllegalArgumentException{
		this("anonimo", precio, IVA, cuantosQuedan);
	}
}
