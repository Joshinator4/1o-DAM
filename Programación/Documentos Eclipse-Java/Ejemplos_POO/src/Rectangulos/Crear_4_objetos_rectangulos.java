package Rectangulos;

import java.awt.Point;
import java.awt.Rectangle;

public class Crear_4_objetos_rectangulos {

	public static void main(String[] args) {
		Rectangle rectangulo1, rectangulo2, rectangulo3, rectangulo4;
		Point punto1;
		
		
		rectangulo1 = new Rectangle();
		//Modificar x = 2 e y =3
		
		rectangulo1.setLocation(2, 3);
		rectangulo1.setSize(2, 3);
		System.out.println(rectangulo1.toString());
		
		if(rectangulo1.getHeight() < 5) {
			rectangulo1.setSize((int)rectangulo1.getWidth(), 5);
		}
		
		rectangulo2 = rectangulo1;
		
		for(int i = 5; i <=20; i+=5) {
			rectangulo2.setLocation(i, (int)rectangulo2.getY());
			System.out.println(rectangulo2.toString());
		}
		System.out.println(rectangulo1.toString());
		
		
		
		/*rectangulo2 = new Rectangle(9, 10);
		rectangulo3 = new Rectangle(15, 20, 5, 9);
		
		punto1= new Point();
		rectangulo4 = new Rectangle(punto1);
		
		System.out.println(rectangulo1.toString());
		System.out.println(rectangulo2.toString());
		System.out.println(rectangulo3.toString());
		System.out.println(rectangulo4.toString());
		
		System.out.println(rectangulo4.equals(rectangulo1));
		*/
	
		
	
	}
	
	
}