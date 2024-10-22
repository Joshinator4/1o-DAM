package ejercicio5;

public class Submarino extends VehiculoAcuatico{
	
	private int profundidadMax; //Profundidad maxima que podra alcanzar el submarino con un minimo de 10m y un maximo de 300m
	
	public Submarino(String matricula, String modelo, int eslora, int profundidad) throws IllegalArgumentException {
		super(matricula, modelo, eslora);
		setProfundidadMax(profundidad);
	}
	
	public Submarino(int profundidad) throws IllegalArgumentException{
		super();
		setProfundidadMax(profundidad);
	}
	
	public Submarino(){
		super();
		setProfundidadMax(150);
	}

	public int getProfundidadMax() {
		return profundidadMax;
	}

	public void setProfundidadMax(int profundidadMax)throws IllegalArgumentException {
		if(profundidadMax > 300 || profundidadMax < 10) {
			throw new IllegalArgumentException("La profundidad maxima son 300 m y la mínima son 10m");
		}else {
			this.profundidadMax = profundidadMax;
		}
		
	}

	@Override
	public String toString() {
		return super.toString() + "Submarino [profundidadMax=" + profundidadMax + "]";
	}
	
	
}
