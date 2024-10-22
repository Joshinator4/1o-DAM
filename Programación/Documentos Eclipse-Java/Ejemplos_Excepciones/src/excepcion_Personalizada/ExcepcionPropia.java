package excepcion_Personalizada;

public class ExcepcionPropia extends Exception{
	
	private int num;
	
	public ExcepcionPropia(int n) {
		this.num = n;
	}
	
	public String toString() {
		return "Excepcion Propia [" + this.num + "]";
	}
}
