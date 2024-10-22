package ejercicio6;

public interface iFigura2D {
	
	//Para devolver el perímetro de la figura
	public double perimetro();
	
	//Para devolver el área de la figura
	public double area(); 
	
	//Para escalar la figura (aumentar o disminuir su tamaño). Solo 
	//hay que multiplicar los atributos de la figura por la escala (> 0).
	public void escalar(double escala); 
	
	//Para mostrar la información de la figura (atributos, perímetro y área) en una
	//sola línea.
	public void imprimir(); 


	
}
