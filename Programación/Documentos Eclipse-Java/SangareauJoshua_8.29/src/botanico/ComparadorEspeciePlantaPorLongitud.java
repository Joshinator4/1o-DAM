package botanico;

import java.util.Comparator;

public class ComparadorEspeciePlantaPorLongitud implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		int devolucion;
		if(o1.length() < o2.length()) {
			devolucion = -1;
		}else if(o1.length() > o2.length()) {
			devolucion = 1;
		}else {
			devolucion = 0;
		}
		return devolucion;
	}

}
