package cuentasCorrientes;

import java.time.LocalDateTime;

public class Movimientos {
	
	enum TipoMovimiento{INGRESO, SALIDA, T_RECIBIDA, T_ENVIADA}
	
	private int cuenta_emisora;
	private int cuenta_receptora;
	private double importe;
	private LocalDateTime fecha_hora;
	private String concepto;
	
	
	public Movimientos(int cuenta_emisora, int cuenta_receptora, double importe, LocalDateTime fecha_hora, String concepto) {
		this.cuenta_emisora = cuenta_emisora;
		this.cuenta_receptora = cuenta_receptora;
		this.importe = importe;
		this.fecha_hora = fecha_hora;
		this.concepto = concepto;
	}


	public int getCuenta_emisora() {
		return cuenta_emisora;
	}


	public int getCuenta_receptora() {
		return cuenta_receptora;
	}


	public double getImporte() {
		return importe;
	}


	public LocalDateTime getFecha_hora() {
		return fecha_hora;
	}


	public String getConcepto() {
		return concepto;
	}


	public void setCuenta_emisora(int cuenta_emisora) {
		this.cuenta_emisora = cuenta_emisora;
	}


	public void setCuenta_receptora(int cuenta_receptora) {
		this.cuenta_receptora = cuenta_receptora;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}


	public void setFecha_hora(LocalDateTime fecha_hora) {
		this.fecha_hora = fecha_hora;
	}


	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	
	
	
}
