package productos;

import java.time.LocalDate;

public abstract class Producto {

	protected final String codigoProducto;//código del producto con formato xxxx asignado de forma consecutiva por el sistema.
	private static int contadorCodigo=1;
	
	protected String nombreProducto;//nombre del producto.

	protected LocalDate fechaCaducidad;//fecha de caducidad.

	protected int numeroLote;//número de lote.
	
	
	//Constructor de la clase
	public Producto (String nombreProducto, LocalDate fechaCaducidad, int numeroLote) {
		this.codigoProducto = sacarCodigo();
		setNombreProducto(nombreProducto);
		setFechaCaducidad(fechaCaducidad);
		setNumeroLote(numeroLote);
	}
	
	//Setters y getters
	public String getCodigoProducto() {
		return this.codigoProducto;
	}
	
	public String getNombreProducto() {
		return this.nombreProducto;
	}
	
	public LocalDate getFechaCaducidad() {
		return this.fechaCaducidad;
	}
	
	public int getNumeroLote() {
		return this.numeroLote;
	}
	
	public void setNombreProducto(String nombre) {
		this.nombreProducto = nombre;
	}
	
	public void setFechaCaducidad(LocalDate caducidad) {
		this.fechaCaducidad = caducidad;
	}
	
	public void setNumeroLote(int lote) {
		this.numeroLote = lote;
	}
	
	//Metodo toString de la clase Padre
	public String toString() {
		return ("Código de producto: " + getCodigoProducto() + ", Nombre de producto: " + getNombreProducto() + ", Fecha de caducidad: " + getFechaCaducidad() );
	}
	
	//Metodo que genera un codigo consecuitivo con formato XXXX
	private String sacarCodigo() {
		String devolucion = null, cambiar;
		cambiar = Integer.toString(contadorCodigo);
		if (cambiar.length() == 1) {
			devolucion = "000" + cambiar;
			Producto.contadorCodigo++;
		}else if (cambiar.length() == 2) {
			devolucion = "00" + cambiar;
			Producto.contadorCodigo++;
		}else if (cambiar.length() == 3) {
			devolucion = "0" + cambiar;
			Producto.contadorCodigo++;
		}else if (cambiar.length() == 4) {
			devolucion =  cambiar;
			Producto.contadorCodigo++;
		}
		return devolucion;
	}
}
