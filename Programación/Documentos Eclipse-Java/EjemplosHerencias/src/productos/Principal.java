package productos;

import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
		
		LocalDate fechaCaducidad = LocalDate.of(2024, 5, 15);
		LocalDate fechaEnvasado = LocalDate.of(2024, 2, 4);
		LocalDate fechaPreferente = LocalDate.of(2024, 2, 28);
		
		ProductoFresco producto1 = new ProductoFresco("Yogurt", fechaCaducidad, 1, fechaEnvasado, "España");
		System.out.println(producto1.toString());
		producto1.setNombreProducto("yougurt fresa");
		producto1.setPaisOrigen("Cuba");
		System.out.println(producto1.toString());
		
		ProductoCongelado producto2 = new ProductoCongelado ("Croquetas", fechaCaducidad, 2, -25, 12);
		System.out.println(producto2.toString());
		producto2.setMesesConservar(15);
		producto2.setTempRecomendada(-35);
		System.out.println(producto2.toString());
		
		ProductoRefrigerado producto3 = new ProductoRefrigerado ("Shushi", fechaCaducidad, 3, "CM-325", 4, fechaPreferente);
		System.out.println(producto3.toString());
		producto3.setTempMinima(2);
		producto3.setFechaPreferente(fechaEnvasado);
		System.out.println(producto3.toString());
		
	}

}
