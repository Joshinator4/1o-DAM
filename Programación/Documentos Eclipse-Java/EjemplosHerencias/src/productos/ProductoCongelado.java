package productos;

import java.time.LocalDate;

public class ProductoCongelado extends Producto{
	
	private double tempRecomendada;
	
	private int mesesConservar;
	
	public ProductoCongelado(String nombreProducto, LocalDate fechaCaducidad, int numeroLote, double tempRecomendada, int mesesConservar){
		super(nombreProducto, fechaCaducidad, numeroLote);
		this.tempRecomendada = tempRecomendada;
		this.mesesConservar = mesesConservar;
	}
	
	//Métodos setter y getter de la clase
	
	public int getMesesConservar() {
		return this.mesesConservar;
	}
	
	public double getTempRecomendada() {
		return this.tempRecomendada;
	}
	
	public void setTempRecomendada(double temperatura) {
		this.tempRecomendada = temperatura;
	}
	
	public void setMesesConservar(int meses) {
		this.mesesConservar = meses;
	}
	
	//Metodo toString de la clase hija heredando de Productos
	@Override
	public String toString() {
		return super.toString() + ", Temperatura recomendada: " + getTempRecomendada() + ", Meses maximos a conservar: " + getMesesConservar();
	}

}
