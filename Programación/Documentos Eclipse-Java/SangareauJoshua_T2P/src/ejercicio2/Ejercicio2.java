package ejercicio2;

public class Ejercicio2 {

	public static void main(String[] args) {
		//Se crean arrays con los precios de las horas y el consumo
		double [] precioHora = {0.176913085, 0.162418527, 0.163008205, 0.161324055, 0.160931245, 0.156762018, 0.151811078, 0.140889361, 0.133800035, 0.125667033, 0.108986202, 0.092593459, 0.085345099, 0.083556969, 0.077146071, 0.08592403, 0.105271229, 0.115156177, 0.125293963, 0.144438618, 0.15376299, 0.148261656, 0.131731964, 0.114278129} ;
		double [] costeHora = {0.02582931041, 0.012181389525, 0.011247566145, 0.010486063575, 0.00997773719, 0.009248959062, 0.010171342226, 0.009439587187, 0.018865804935, 0.036569106603, 0.026047702278, 0.060741309104, 0.099512385434, 0.065842891572, 0.077146071, 0.01941883078, 0.021159517029, 0.034201384569, 0.07392343817, 0.045787041906, 0.05427833547, 0.07487213628, 0.034118578676, 0.027883863476};
		//4.El método main() llamará a los métodos anteriores y mostrará los resultados.
		System.out.printf("Mostrando los resultados del coste del dia completo: %f €", costeDiaCompleto(costeHora));
		System.out.printf("\nMostrando los resultados de la hora mas cara: %d ", horaMasCara(precioHora));
		System.out.printf("\nMostrando los resultados de la hora del dia que ha salido mas cara: %d", horaCosteAlto(costeHora));
	}
	
	
	//1.Un método que calcule el coste del día completo.
	public static double costeDiaCompleto(double [] costeHora){
		//Se recibe array con el coste de cada hora y se va sumando los valores de cada una de las horas
		double diaCompleto=0;
		for (int i = 0; i < 24; i++) {
			diaCompleto += costeHora[i];
		}
		return diaCompleto;
	}
	
	//2.Un método que calcule qué hora del día ha tenido el precio más alto.
	public static int horaMasCara(double [] precioHora){
		//Se recibe un array con los precios de cada hora y se realiza filtro para quedarme con el campo del array que contiene el valor mas alto, se devuelve la hora
		double horaCara= precioHora[0], horaPrecioAlta = 0;
		for (int i = 0; i < 24; i++) {
			if(precioHora[i] > horaCara) {
				horaCara = precioHora[i];
				horaPrecioAlta = i;
			}
		}
		return (int)horaPrecioAlta+1;
	}
	
	//3.Un método que calcule la hora que ha tenido el coste más alto.
	public static int horaCosteAlto(double [] costeHora){
		//Se recibe 1 array con el coste de cada hora y se filtra que hora es en la que mas se ha gastado, se duvuelve la hora
		double horaCosteAlta = 0, resultado;
		resultado = costeHora[0];
		for (int i = 0; i < 24; i++) {
			if(costeHora[i] > resultado) {
				resultado = costeHora[i];
				horaCosteAlta = i;
			}
		}
		return (int)horaCosteAlta+1;
	}
}
