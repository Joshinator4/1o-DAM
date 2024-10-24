package productos;

import java.time.LocalDate;

public class ProductoFresco extends Producto{
	
	private LocalDate fehaEnvasado;
	
	private String paisOrigen;
	
	
	//Constructor de la clase
	public ProductoFresco(String nombreProducto, LocalDate fechaCaducidad, int numeroLote, LocalDate fechaEnvasado, String paisOrigen){
		super(nombreProducto, fechaCaducidad, numeroLote);
		this.fehaEnvasado = fechaEnvasado;
		this.paisOrigen = paisOrigen;
	}
	
	//Métodos setter y getters de la clase
	public LocalDate getFehaEnvasado() {
		return this.fehaEnvasado;
	}
	
	public String getPaisOrigen() {
		return this.paisOrigen;
	}
	
	public void setFehaEnvasado(LocalDate envasado) {
		this.fehaEnvasado = envasado;
	}
	
	public void setPaisOrigen(String origen) {
		this.paisOrigen = origen;
	}
	
	//Metodo toString de la clase hija heredando de Productos
	@Override
	public String toString() {
		return super.toString() + ", Fecha envasado : " + getFehaEnvasado() + ", Pais de origen: " + getPaisOrigen();
	}
}
