package botanico;

import java.util.Comparator;

public class ComparadorEspeciePlantaPorNombre implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		int devolucion;
		if(o1.compareTo(o2) < 0) {
			devolucion = -1;
		}else if(o1.compareTo(o2) > 0) {
			devolucion = 1;
		}else {
			devolucion = 0;
		}
		return devolucion;
	}

}
