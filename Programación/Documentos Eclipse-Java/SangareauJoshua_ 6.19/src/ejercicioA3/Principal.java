package ejercicioA3;

public class Principal {

	public static void main(String[] args) {
		
		int areaObjeto1, areaObjeto2, perimetroObjeto1, perimetroObjeto2;
		
		Rectangulo objeto1 = new Rectangulo ();
		Rectangulo objeto2 = new Rectangulo ();
		
		objeto1.x1 = 0;
		objeto1.y1 = 0;
		objeto1.x2 = 5;
		objeto1.y2 = 5;
		
		objeto2.x1 = 7;
		objeto2.y1 = 9;
		objeto2.x2 = 2;
		objeto2.y2 = 3;
		
		perimetroObjeto1 = (objeto1.x1 + objeto1.x2)*2 + (objeto1.y1 + objeto1.y2)*2;
		perimetroObjeto2 = (objeto2.x1 - objeto2.x2)*2 + (objeto2.y1 - objeto2.y2)*2;
		
		areaObjeto1 = (objeto1.x1 + objeto1.x2) * (objeto1.y1 + objeto1.y2);
		areaObjeto2 = (objeto2.x1 - objeto2.x2) * (objeto2.y1 - objeto2.y2);
		
		System.out.println("Las coordenadas del objeto 1 son (" + objeto1.x1 + "," + objeto1.y1 + ")" + " y (" + + objeto1.x2 + "," + objeto1.y2 + ") .El area del objeto 1 es: " + areaObjeto1 + ". El perímetro del objeto1 es: " + perimetroObjeto1);
		System.out.println("Las coordenadas del objeto 2 son (" + objeto2.x1 + "," + objeto2.y1 + ")" + " y (" + + objeto2.x2 + "," + objeto2.y2 + ") .El area del objeto 2 es: " + areaObjeto2 + ". El perímetro del objeto1 es: " + perimetroObjeto2);
		
		objeto1.x1 = 0 + 2;
		objeto1.y1 = 0 + 3;
		objeto1.x2 = 5 + 4;
		objeto1.y2 = 5 + 1;
		
		objeto2.x1 = 7 + 3;
		objeto2.y1 = 9 + 2;
		objeto2.x2 = 2 + 1;
		objeto2.y2 = 3 + 4;
		
		perimetroObjeto1 = (objeto1.x1 + objeto1.x2)*2 + (objeto1.y1 + objeto1.y2)*2;
		perimetroObjeto2 = (objeto2.x1 - objeto2.x2)*2 + (objeto2.y1 - objeto2.y2)*2;
		
		areaObjeto1 = (objeto1.x1 + objeto1.x2) * (objeto1.y1 + objeto1.y2);
		areaObjeto2 = (objeto2.x1 - objeto2.x2) * (objeto2.y1 - objeto2.y2);
		
		System.out.println("Las nuevas coordenadas del objeto 1 son (" + objeto1.x1 + "," + objeto1.y1 + ")" + " y (" + + objeto1.x2 + "," + objeto1.y2 + ") .El nuevo area del objeto 1 es: " + areaObjeto1 + ". El nuevo perímetro del objeto1 es: " + perimetroObjeto1);
		System.out.println("Las nuevas coordenadas del objeto 2 son (" + objeto2.x1 + "," + objeto2.y1 + ")" + " y (" + + objeto2.x2 + "," + objeto2.y2 + ") .El nuevo area del objeto 2 es: " + areaObjeto2 + ". El nuevo perímetro del objeto1 es: " + perimetroObjeto2);
		
		
	}

}
