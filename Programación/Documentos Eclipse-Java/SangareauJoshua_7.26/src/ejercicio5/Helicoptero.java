package ejercicio5;

public class Helicoptero extends VehiculoAereo{
	
	private int numeroHelices; //Numero de hélices que tiene el helicoptero con minimo de 3 y maximo de 8
	
	public Helicoptero(String matricula, String modelo, int numeroAsientos, int numeroHelices)throws IllegalArgumentException{
		super(matricula, modelo, numeroAsientos);
		setNumeroHelices(numeroHelices);
	}
	
	public Helicoptero(int numeroHelices) throws IllegalArgumentException{
		super();
		setNumeroHelices(numeroHelices);
	}
	
	public Helicoptero() {
		super();
		setNumeroHelices(6);
	}

	public int getNumeroHelices() {
		return numeroHelices;
	}

	public void setNumeroHelices(int numeroHelices) throws IllegalArgumentException{
		if(numeroHelices < 3 || numeroHelices > 8) {
			throw new IllegalArgumentException("ERROR: El numero de hélices debe ser superior o igual a 3 e inferior o igual a 8");
		}else {
			this.numeroHelices = numeroHelices;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Helicoptero [numeroHelices=" + numeroHelices + "]";
	}
	
	
	
}
