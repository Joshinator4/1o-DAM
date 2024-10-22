package cuentasCorrientes;

public class CuentaCorriente {
	
	enum TipoSituacion {ACTIVA, BAJA}
	
	private int numero_cuenta;
	private String dni_cliente;
	private TipoSituacion situacion;
	private double saldo;
	
	
	public CuentaCorriente(int numero_cuenta, String dni_cliente, TipoSituacion situacion, double saldo) {
		this.numero_cuenta = numero_cuenta;
		this.dni_cliente = dni_cliente;
		this.situacion = situacion;
		this.saldo = saldo;
	}


	public int getNumero_cuenta() {
		return numero_cuenta;
	}


	public String getDni_cliente() {
		return dni_cliente;
	}


	public TipoSituacion getSituacion() {
		return situacion;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setNumero_cuenta(int numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}


	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}


	public void setSituacion(TipoSituacion situacion) {
		this.situacion = situacion;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	@Override
	public String toString() {
		return "CuentaCorriente [numero_cuenta=" + numero_cuenta + ", dni_cliente=" + dni_cliente + ", situacion="
				+ situacion + ", saldo=" + saldo + "]";
	}
	
	
}
