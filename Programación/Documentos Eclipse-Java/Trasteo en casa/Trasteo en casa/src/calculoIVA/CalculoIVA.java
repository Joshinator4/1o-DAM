/* Realizaremos un calculo de IVA haciendo la impresión en pantalla con el sigueinte formato:
 * Introduce el precio del producto: 8.4 
 * Importe del IVA: 1.764
 * Precio con IVA: 10.164
 */
package calculoIVA;

	import java.util.Scanner;

public class CalculoIVA {

    public static void main(String args[]) {
    	
    	 double precioProducto;
    	 double porcentajeIva;
         double valorDelIva;
         double precioTotal;
    	
      Scanner teclado=new Scanner(System.in);
      
      System.out.print("Introduce el precio del producto: ");
      
      precioProducto = teclado.nextDouble();
      
      porcentajeIva = 0.21;
      
      valorDelIva = (precioProducto * porcentajeIva);
      
      precioTotal = (precioProducto + valorDelIva);
      
      System.out.println("Importe del iva es: " + valorDelIva + "\n" + "Precio con IVA: " + precioTotal);
      
      
      
    }
}
