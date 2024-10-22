package ejercicioB1;

public class Punto {
	
	int x; //Coordenada X
	int y; //Coordenada Y
	
	public Punto (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Punto (int x) {
		this(x, 5);
	}
	
	public Punto () {
		this(3, 5);
	}
	
}
