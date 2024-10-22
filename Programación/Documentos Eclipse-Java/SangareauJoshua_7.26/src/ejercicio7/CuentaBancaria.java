package ejercicio7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CuentaBancaria {

	private String cuentaBancaria;
	private String titular;
	private double saldo;
	private double[] movimientos;
	private int contadorMovimientos;

	// Constructor de 2 argumentos o parámetros
	public CuentaBancaria(String cuentaBancaria, String titular) throws IllegalArgumentException{
		Pattern patDni = Pattern.compile("[a-zA-Z]{2}[0-9]{22}");
		Matcher matDni = patDni.matcher(cuentaBancaria);
		if (matDni.matches()) {
			this.cuentaBancaria = cuentaBancaria;
		} else {
			throw new IllegalArgumentException("ERROR: El patron de la cuenta bancaria no es correcto");
		}
		
		if (titular.isEmpty() || titular == null) {
			throw new IllegalArgumentException("ERROR: El titular no puede estar vacio o crearlo como null");
		} else {
			this.titular = titular;
		}
		
		setSaldo(0);
		this.movimientos = new double[100];
		this.contadorMovimientos = 0;
	}

	public String getCuentaBancaria() {
		return this.cuentaBancaria;
	}

	public String getTitular() {
		return this.titular;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public double getMovimiento(int numeroMovimiento) {
		return this.movimientos[numeroMovimiento-1];
	}
	
	private void setSaldo(double saldo) throws IllegalArgumentException {
		if (saldo >= 0) {
			this.saldo = saldo;
		} else {
			throw new IllegalArgumentException("ERROR: El saldo no debe ser creado con un valor menor que 0");
		}
	}

	public void ingreso(double ingresar) throws CuentaException, AvisarHaciendaException {
		if (ingresar <= 0) {
			throw new CuentaException(ingresar);
		} else {
			setSaldo(getSaldo() + ingresar);
			this.movimientos[contadorMovimientos] = ingresar;
			this.contadorMovimientos++;
			if (ingresar >= 3000) {
				throw new AvisarHaciendaException(ingresar);
			}
		}
	}
	
	public void retirada(double retirar) throws CuentaException {
		if (retirar <= 0) {
			throw new CuentaException(retirar);
		}else {
			if((getSaldo() - retirar) < -50) {
				throw new IllegalArgumentException("ERROR: Se esta intetando retirar dinero dejando el saldo en descubierto por debajo de -50€");
			}else {
				this.movimientos[contadorMovimientos] = -retirar;
				this.contadorMovimientos++;
				if ((getSaldo() - retirar) < 0 && (getSaldo() - retirar) >= -50 ) {
					System.out.println("AVISO: Saldo Negativo");
				}
				setSaldo(getSaldo() - retirar);
			}
		}
		
	}
	
	public String consultaMovimientos() {
		String devolucion = "";
			for(int i = 0; i < this.contadorMovimientos; i++) {
				devolucion += "movimiento " + (i+1) + ": " + movimientos[i] + " ";
				if(movimientos[i] < 0) {
					devolucion += "retirada\n";
				}else if(movimientos[i] > 0){
					devolucion += "ingreso\n";
				}
			}
			if(devolucion.isEmpty()) {
				devolucion = "No hay movimientos en la Cuenta Bancaria";
			}
		devolucion += "total: " + getSaldo();
		return devolucion;
	}
	

}
