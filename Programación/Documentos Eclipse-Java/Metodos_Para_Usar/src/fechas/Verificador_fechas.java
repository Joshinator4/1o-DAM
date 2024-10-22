package fechas;

public class Verificador_fechas {
	
	public static boolean verificadorFecha (byte x, byte y, int z) {
		
		boolean correcto;
		// OOOOOOOJJJJOOOOOOOO CCCCUUUUIIIIDDDDAAAADDDDOOOOO!!!!!!!!!!! el año está puesto en 2023, para años posteriores cambiar en el condicional IF de la siguiente línea
		if(z > 0 && z <= 2023) {
		//Esteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee de arriba!!!
			correcto = true;
			
			switch (y) {
				case 1, 3 , 5 , 7 , 8, 10, 12 :{
					if(x > 0 && x <= 31) {
						correcto = true;
					}else {
						correcto = false;
					}
					break;
				}
				case 4, 6, 9, 11 :{
					if(x > 0 && x <= 30) {
						correcto = true;
					}else {
						correcto = false;
					} 
					break;
				}
				case 2: {
					if(x > 0 && x <= 29) {
						correcto = true;
						if(x == 29) {
							if(saberSiEsBisiesto(z)==true) {
								correcto = true;
							}else {
								correcto = false;
							}
						}
					}else {
						correcto = false;
					}
					
					break;
				}
				default:{
				correcto = false;
				}
			}
		}else {
			correcto = false;
		}
		
		return correcto;
		
	}
	
	public static boolean saberSiEsBisiesto (int x) {
		boolean bisiesto = false;
		if ((x % 4 == 0) && ((x % 100 != 0) || (x % 400 == 0))) {
			bisiesto = true;
		}
		else {
			bisiesto = false;
		}
		return bisiesto;
			
	}
}
