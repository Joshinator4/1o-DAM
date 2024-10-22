package productos;

import java.time.LocalDate;

public class ProductoRefrigerado extends Producto{
	
	private String codigoOrganismo;
	
	private int tempMinima;
	
	private LocalDate fechaPreferente;
	
	public ProductoRefrigerado(String nombreProducto, LocalDate fechaCaducidad, int numeroLote, String codigoOrganismo, int tempMinima, LocalDate fechaPreferente){
		super(nombreProducto, fechaCaducidad, numeroLote);
		this.codigoOrganismo = codigoOrganismo;
		this.tempMinima = tempMinima;
		this.fechaPreferente = fechaPreferente;
	}
	
	
	//setters y getters de la clase
	public String getCodigoOrganismo() {
		return this.codigoOrganismo;
	}
	
	public int getTempMinima() {
		return this.tempMinima;
	}
	
	public LocalDate getFechaPreferente() {
		return this.fechaPreferente;
	}
	
	public void setCodigoOrganismo(String organismo) {
		this.codigoOrganismo = organismo;
	}
	
	public void setTempMinima(int temperatura) {
		this.tempMinima = temperatura;
	}
	
	public void setFechaPreferente(LocalDate fecha) {
		this.fechaPreferente = fecha;
	}
	
	//Metodo toString de la clase hija heredando de Productos
	@Override
	public String toString() {
		return super.toString() + ", Código de organismo : " + getCodigoOrganismo() + ", Temperatura mínima: " + getTempMinima() + ", Fecha de consumo preferente: " + getFechaPreferente();
	}
}
