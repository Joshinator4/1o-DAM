package inmobiliaria;

public class Principal {

	public static void main(String[] args) {


		try {
			
			Vivienda casa1 = new Vivienda();
			casa1.getFechaConst();
			
			
			
			
		}catch(IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}

	}

}
