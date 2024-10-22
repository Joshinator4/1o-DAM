package cajeroAutomatico;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tarjeta extends CuentaBancaria{
	private static int contadorTarjeta=1;
	
	private String numeroTarjeta;
	private int pinTarjeta;
	
	
	public Tarjeta(String cuentaBancaria, double saldo, int pin) throws IllegalArgumentException{
		super(cuentaBancaria, saldo);
		Pattern patPin = Pattern.compile("[0-9]{4}");
		String comprobarPin = Integer.toString(pin);
		Matcher matPin = patPin.matcher(comprobarPin);
		if (matPin.matches()) {
			this.pinTarjeta = pin;
		} else {
			throw new IllegalArgumentException("ERROR: El patron del pin no es correcto. El pin se compone de 4 números enteros");
		}
		this.numeroTarjeta = setNumero();
	}
	
	public int getPinTarjeta() {
		return this.pinTarjeta;
	}
	@Override
	protected String setNumero() {
		String devolucion = null, cambiar;
		cambiar = Integer.toString(contadorTarjeta);
		if (cambiar.length() == 1) {
			devolucion = "T0000" + cambiar;
			Tarjeta.contadorTarjeta++;
		}else if (cambiar.length() == 2) {
			devolucion = "T000" + cambiar;
			Tarjeta.contadorTarjeta++;
		}else if (cambiar.length() == 3) {
			devolucion = "T00" + cambiar;
			Tarjeta.contadorTarjeta++;
		}else if (cambiar.length() == 4) {
			devolucion =  "T0" + cambiar;
			Tarjeta.contadorTarjeta++;
		}else if (cambiar.length() == 5) {
			devolucion =  "T" + cambiar;
			Tarjeta.contadorTarjeta++;
		}
		return devolucion;
	}
	

}
