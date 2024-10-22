package ejercicioA4;

public class Principal {

	public static void main(String[] args) {
		
		double precioFinal1, precioFinal2;
		
		Articulo articulo1 = new Articulo();
		Articulo articulo2 = new Articulo();
		
		articulo1.cuantosQuedan = 3;
		articulo1.nombre = "balón";
		articulo1.precio = 15.35;
		precioFinal1 = articulo1.precio * (double)articulo1.IVA/100 + articulo1.precio;
		
		System.out.println(articulo1.nombre + "- Precio: " + articulo1.precio + " - IVA: " + articulo1.IVA + "% - PVP: " + precioFinal1);
		
		articulo1.precio = 19.69;
		precioFinal1 = articulo1.precio * (double)articulo1.IVA/100 + articulo1.precio;
		
		System.out.println(articulo1.nombre + "- Nuevo Precio: " + articulo1.precio + " - IVA: " + articulo1.IVA + "% - Nuevo PVP: " + precioFinal1);
		
		articulo2.cuantosQuedan = 15;
		articulo2.nombre = "lámpara";
		articulo2.precio = 57.99;
		precioFinal2 = articulo2.precio * (double)articulo2.IVA/100 + articulo2.precio;
		
		System.out.println(articulo2.nombre + "- Precio: " + articulo2.precio + " - IVA: " + articulo2.IVA + "% - PVP: " + precioFinal2);
		
		articulo2.precio = 99.69;
		precioFinal2 = articulo2.precio * (double)articulo2.IVA/100 + articulo2.precio;
		
		System.out.println(articulo2.nombre + "- Nuevo Precio: " + articulo2.precio + " - IVA: " + articulo2.IVA + "% - Nuevo PVP: " + precioFinal2);
	}

}
