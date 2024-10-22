package ejercicio9;

public class Producto implements Comparable<Producto>{
	
	private String nombreProducto;
	private int cantidad;
	
	public Producto(String nombreProducto, int cantidad) {
		
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

	
	@Override
	public String toString() {
		return "Producto [nombreProducto=" + nombreProducto + ", cantidad=" + cantidad + "]";
	}

	@Override
	public int compareTo(Producto o) {
		int devolucion;
		if(this.nombreProducto.compareTo(o.getNombreProducto()) < 0){
			devolucion = -1;
		}else if(this.nombreProducto.compareTo(o.getNombreProducto()) > 0) {
			devolucion = 1;
		}else {
			devolucion = 0;
		}
		return devolucion;
	}
	
	
	
	
}
