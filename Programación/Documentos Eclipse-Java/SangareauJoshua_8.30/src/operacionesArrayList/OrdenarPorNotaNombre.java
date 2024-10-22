package operacionesArrayList;

import java.util.Comparator;

public class OrdenarPorNotaNombre implements Comparator<Alumno>{

	@Override
	public int compare(Alumno o1, Alumno o2) {
		int devolucion;
		if(o1.getMatematicas() > o2.getMatematicas()) {
			devolucion = -1;
		}else if(o1.getMatematicas() < o2.getMatematicas()) {
			devolucion = 1;
		}else {
			if(o1.getNombre().compareTo(o2.getNombre()) > 0) {
				devolucion = 1;
			}else if(o1.getNombre().compareTo(o2.getNombre()) < 0) {
				devolucion = -1;
			}else {
				devolucion = 0;
			}
		}
		return devolucion;
	}

}