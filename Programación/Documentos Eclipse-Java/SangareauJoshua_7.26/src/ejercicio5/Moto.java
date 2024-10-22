package ejercicio5;

public class Moto extends VehiculoTerrestre{
	enum ColorMoto{ROJO, AZUL, AMARILLO, NEGRO}
	

	private ColorMoto color; //Color de la moto
	
	public Moto(String matricula, String modelo, int numeroRuedas, ColorMoto color) throws IllegalArgumentException {
		super(matricula, modelo, numeroRuedas);
		this.color = color;
	}
	
	public Moto (ColorMoto color){
		super();
		setColor(color);
	}
	
	public Moto (){
		super();
		setColor(ColorMoto.NEGRO);
	}

	public ColorMoto getColor() {
		return color;
	}

	public void setColor(ColorMoto color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return super.toString() + "Moto [Color=" + color + "]";
	}
	
	
	
	
}
