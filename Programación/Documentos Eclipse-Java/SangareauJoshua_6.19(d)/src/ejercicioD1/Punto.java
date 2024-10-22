package ejercicioD1;

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
	
	public void imprime() {
		System.out.println("(" + this.x + "," + this.y + ")");
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void desplaza(int dx, int dy) {
		this.x = this.x + dx;
		this.y = this.y + dy;
	}
	
	public int distancia(Punto p) {
		int devolucion;
		devolucion = (int)Math.sqrt(Math.pow((double)(this.x - p.x), 2) + Math.pow((double)(this.y - p.y), 2));
		return devolucion;
	}
}
