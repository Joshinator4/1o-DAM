package ejercicioB1;

import ejercicioB1.Punto;

public class Principal {

	public static void main(String[] args) {
		Punto punto1 = new Punto (5,0);
		Punto punto2 = new Punto (10);
		Punto punto3 = new Punto ();
		
		
		System.out.println("Los valores de del punto 1 son x: " + punto1.x + ", y: " + punto1.y);
		System.out.println("Los valores de del punto 2 son x: " + punto2.x + ", y: " + punto2.y);
		System.out.println("Los valores de del punto 3 son x: " + punto3.x + ", y: " + punto3.y);
		
		punto1.x = punto1.x+3;
		System.out.println("Si sumamos 3 a x del punto1. Los valores de del punto 1 son x: " + punto1.x + ", y: " + punto1.y);
		punto2.y = punto2.y-5;
		System.out.println("Si restamos 5 a y del punto2. Los valores de del punto 1 son x: " + punto2.x + ", y: " + punto2.y);
		punto3.y = punto3.y*3;
		System.out.println("Si multiplicamos por 3 a y del punto3. Los valores de del punto 1 son x: " + punto3.x + ", y: " + punto3.y);


	}

}
