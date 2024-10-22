package ejercicio5;

public class Principal {

	public static void main(String[] args) {
		
		try {
			VehiculoTerrestre terrestre1 = new VehiculoTerrestre();
			System.out.println(terrestre1.toString());
			try {
				System.out.println("Forzando error en matricula terrestre");
				VehiculoTerrestre terrestre2 = new VehiculoTerrestre("122ABC", "leon", 1);			
				
			}catch(IllegalArgumentException excepcion3) {
				System.out.println(excepcion3.getMessage());
			}catch(Exception excepcion4) {
				System.out.println(excepcion4.getMessage());
			}
			try {
				System.out.println("Forzando error en numero de ruedas");
				VehiculoTerrestre terrestre3 = new VehiculoTerrestre("1222ABC", "leon", 1);			
				
			}catch(IllegalArgumentException excepcion3) {
				System.out.println(excepcion3.getMessage());
			}catch(Exception excepcion4) {
				System.out.println(excepcion4.getMessage());
			}
			System.out.println("-----------------------------------------------------------------------------------------");
			
			VehiculoAcuatico acuatico1 = new VehiculoAcuatico();
			System.out.println(acuatico1.toString());
			try {
				System.out.println("Forzando error en matricula acuatico");
				VehiculoAcuatico acuatico2 = new VehiculoAcuatico("AC", "Yate", 5);			
				
			}catch(IllegalArgumentException excepcion3) {
				System.out.println(excepcion3.getMessage());
			}catch(Exception excepcion4) {
				System.out.println(excepcion4.getMessage());
			}
			try {
				System.out.println("Forzando error en la eslora del vehiculo acuatico");
				VehiculoAcuatico acuatico3 = new VehiculoAcuatico("ACAS", "Yate", 1);			
				
			}catch(IllegalArgumentException excepcion3) {
				System.out.println(excepcion3.getMessage());
			}catch(Exception excepcion4) {
				System.out.println(excepcion4.getMessage());
			}
			
			System.out.println("-----------------------------------------------------------------------------------------");
			
			VehiculoAereo aereo1 = new VehiculoAereo();
			System.out.println(aereo1.toString());
			
			try {
				System.out.println("Forzando error en la matricula aerea");
				VehiculoAereo aereo2 = new VehiculoAereo("ACAS12345", "Boing 747", 10);			
				
			}catch(IllegalArgumentException excepcion3) {
				System.out.println(excepcion3.getMessage());
			}catch(Exception excepcion4) {
				System.out.println(excepcion4.getMessage());
			}
			try {
				System.out.println("Forzando error en el numero de asientos del vehiculo aereo");
				VehiculoAereo aereo3 = new VehiculoAereo("ACAS123456", "Boing 747", 7);			
				
			}catch(IllegalArgumentException excepcion3) {
				System.out.println(excepcion3.getMessage());
			}catch(Exception excepcion4) {
				System.out.println(excepcion4.getMessage());
			}
			
		}catch(IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}catch(Exception excepcion2) {
			System.out.println(excepcion2.getMessage());
		}
		
		
		System.out.println("-----------------------------------------------------------------------------------------");
		
		
		try {
			Coche coche1 = new Coche();	
			System.out.println(coche1.toString());
			Moto moto1 = new Moto();
			System.out.println(moto1.toString());
			Avion avion1 = new Avion();
			System.out.println(avion1.toString());
			Helicoptero helicoptero1= new Helicoptero();
			System.out.println(helicoptero1.toString());
			Barco barco1 = new Barco();
			System.out.println(barco1.toString());
			Submarino submarino1 = new Submarino();
			System.out.println(submarino1.toString());
			
			
		}catch(IllegalArgumentException excepcion5) {
			System.out.println(excepcion5.getMessage());
		}catch(Exception excepcion6) {
			System.out.println(excepcion6.getMessage());
		}
		

	}

}
