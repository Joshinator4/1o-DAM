package inmobiliaria;

public class Local extends Inmueble{
	
	private int distanciaCentro;
	private boolean estaAlquilado;
	private double valor;
	
	public Local(int superficie, String propietario, String direccion, int distancia, boolean alquilado, double valor) throws IllegalArgumentException{
		super(superficie, propietario, direccion);
		this.distanciaCentro = distancia;
		this.estaAlquilado = alquilado;
		if(alquilado == true) {
			this.valor = valor*1.2;
			if(distancia > 2 ) {
				this.valor = this.valor*0.8;
			}
			
		}else {
			if(distancia > 2 ) {
				this.valor = valor*0.8;
			}else {
				this.valor = valor;
			}
		}
		
		
	}
	

}
