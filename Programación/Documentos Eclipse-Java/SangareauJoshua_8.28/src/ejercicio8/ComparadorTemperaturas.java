package ejercicio8;

import java.util.Comparator;

public class ComparadorTemperaturas implements Comparator<DiaTemperatura> {

	@Override
	public int compare(DiaTemperatura o1, DiaTemperatura o2) {
		
		return o1.getTemperaturaMedia() - o2.getTemperaturaMedia();
	}

}
