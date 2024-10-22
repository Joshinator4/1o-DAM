package excepcion_Personalizada;

public class Excepcion_Personalizada {

	public static void main(String[] args) {

		try{
			metodo(1);
			metodo(20);
			
		}catch (ExcepcionPropia e){
			System.out.println("Capturada: " + e);
		}
		try {
			metodo(5);
		}catch(ExcepcionPropia e1) {
			System.out.println("Capturada: " + e1);
		}

	}
	
	static void metodo (int n) throws ExcepcionPropia {
		System.out.println("Llamado por metodo (" + n + ")");
		
		if(n > 10) {
			throw new ExcepcionPropia(n);
		}
		
		System.out.println("Finalización normal");
	}

}
