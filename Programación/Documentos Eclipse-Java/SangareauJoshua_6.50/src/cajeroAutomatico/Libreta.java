package cajeroAutomatico;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Libreta extends CuentaBancaria{
private static int contadorLibreta=1;
	
	private final String numeroLibreta;
	private final int pinLibreta;
	
	
	public Libreta(String cuentaBancaria, double saldo, int pin) {
		super(cuentaBancaria, saldo);
		Pattern patPin = Pattern.compile("[0-9]{4}");
		String comprobarPin = Integer.toString(pin);
		Matcher matPin = patPin.matcher(comprobarPin);
		if (matPin.matches()) {
			this.pinLibreta = pin;
		} else {
			throw new IllegalArgumentException("ERROR: El patron del pin no es correcto. El pin se compone de 4 números enteros");
		}
		this.numeroLibreta = setNumero();
		Libreta.contadorLibreta++;
	}
	public int getPinLibreta() {
		return this.pinLibreta;
	}
	@Override
	protected String setNumero() {
		String devolucion = null, cambiar;
		cambiar = Integer.toString(contadorLibreta);
		if (cambiar.length() == 1) {
			devolucion = "L0000" + cambiar;
		}else if (cambiar.length() == 2) {
			devolucion = "L000" + cambiar;
		}else if (cambiar.length() == 3) {
			devolucion = "L00" + cambiar;
		}else if (cambiar.length() == 4) {
			devolucion =  "L0" + cambiar;
		}else if (cambiar.length() == 5) {
			devolucion =  "L" + cambiar;
		}
		return devolucion;
	}
	
}
