package ejercicioD1;

import ejercicioD1.Punto;

public class Principal {

	public static void main(String[] args) {
		Punto punto1 = new Punto (5,0);
		Punto punto2 = new Punto (10);
		Punto punto3 = new Punto ();
		
		
		System.out.println("Los valores de del punto 1 son x: " + punto1.getX() + ", y: " + punto1.getY());
		System.out.println("Los valores de del punto 2 son x: " + punto2.getX() + ", y: " + punto2.getY());
		System.out.println("Los valores de del punto 3 son x: " + punto3.getX() + ", y: " + punto3.getY());
		
		
		punto1.setX(punto1.getX()+3);
		System.out.println("Si sumamos 3 a x del punto1. Los valores de del punto 1 son x: " + punto1.getX() + ", y: " + punto1.getY());
		punto2.setY(punto2.getY()+7);
		System.out.println("Si restamos 5 a y del punto2. Los valores de del punto 2 son x: " + punto2.getX() + ", y: " + punto2.getY());
		punto3.setY(punto3.getY()*3);
		System.out.println("Si multiplicamos por 3 a la coordernada Y del punto3. Los valores de del punto 1 son x: " + punto3.getX()+ ", y: " + punto3.getY());
		
		System.out.println("imprimiendo las coordenadas del punto1: ");
		punto1.imprime();
		punto2.setXY(punto2.getX()+8, punto2.getY()+11);
		System.out.println("Usando el metodo setXY, la nueva coordenada X es: " + punto2.getX() + " la nueva coordenada Y es: " + punto2.getY());
		punto3.desplaza(2, 5);
		System.out.println("desplazando las coordenadas X e Y. La nueva coordenada X es: " + punto3.getX() + " la nueva coordenada Y es: " + punto3.getY());
		System.out.println("La distancia del punto1 al punto3 es: " + punto1.distancia(punto3));
		
	}

}
