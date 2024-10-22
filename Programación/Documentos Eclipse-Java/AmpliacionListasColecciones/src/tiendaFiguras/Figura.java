package tiendaFiguras;

public class Figura {
	
	
	private String codigo;
	private double precio;
	private Superheroe heroe;
	private Dimension dimensiones;
	
	
	public Figura(String codigo, double precio, Superheroe heroe, Dimension dimensiones) {
		this.codigo = codigo;
		this.precio = precio;
		this.heroe = heroe;
		this.dimensiones = dimensiones;
	}


	public String getCodigo() {
		return codigo;
	}


	public double getPrecio() {
		return precio;
	}


	public Superheroe getHeroe() {
		return heroe;
	}


	public Dimension getDimensiones() {
		return dimensiones;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public void setHeroe(Superheroe heroe) {
		this.heroe = heroe;
	}


	public void setDimensiones(Dimension dimensiones) {
		this.dimensiones = dimensiones;
	}
	
	
	
	
	
}
