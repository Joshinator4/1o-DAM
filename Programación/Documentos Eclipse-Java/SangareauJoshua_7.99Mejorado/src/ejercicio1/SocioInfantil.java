/*
 * Objetivo:Clase SocioInfantil, hereda de socio, con los atributos y metodos necesrios para esta clase
 * Autor: Joshua Sangareau Quesada
 * fecha: 21/03/2024
 * 
 */

package ejercicio1;

public class SocioInfantil extends SocioMejorado{
	
	private int adultoAsociado;

	public SocioInfantil(String nombre, String dni, TipoCliente tipo, int adultoAsociado) {
		super(nombre, dni, tipo);
		this.adultoAsociado = adultoAsociado;
	}

	public int getAdultoAsociado() {
		return adultoAsociado;
	}

	public void setAdultoAsociado(int adultoAsociado) {
		this.adultoAsociado = adultoAsociado;
	}
	
	//este metodo calcula las cuotas de los socios Infantiles metodo heredado de socio
	@Override
	public double calcularCuota() {
		double devolucion = 0;
		if(adultoAsociado!=0) {
			devolucion = super.calcularCuota();
			devolucion -= devolucion*0.25;
		}
		return devolucion;
		
	}
	
	@Override
	public String toString() {
		return super.toString() + "ClienteInfantil [adultoAsociado=" + adultoAsociado + "]";
	}
	
	

	
}
