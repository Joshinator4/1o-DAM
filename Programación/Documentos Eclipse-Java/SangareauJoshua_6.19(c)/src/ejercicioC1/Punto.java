package ejercicioC1;

public class Punto {

	private int x; //Coordenada X
	private int y; //Coordenada Y
	
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
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
