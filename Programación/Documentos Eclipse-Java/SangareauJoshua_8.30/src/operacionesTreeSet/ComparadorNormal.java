package operacionesTreeSet;

import java.util.Comparator;

public class ComparadorNormal implements Comparator<Alumno>{

	@Override
	public int compare(Alumno o1, Alumno o2) {
		int devolucion = 0;
		if(o1.getGrupo().compareTo(o2.getGrupo())<0) {
			devolucion = -1;
		}else if(o1.getGrupo().compareTo(o2.getGrupo())>0) {
			devolucion = 1;
		}else {
			if(o1.getNombre().compareTo(o2.getNombre())< 0) {
				devolucion = -1;
			}else if(o1.getNombre().compareTo(o2.getNombre())> 0) {
				devolucion = 1;
			}
		}
		return devolucion;
	}

}
