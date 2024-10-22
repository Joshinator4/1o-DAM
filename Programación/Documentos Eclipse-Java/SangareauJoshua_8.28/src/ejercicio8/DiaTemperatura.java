package ejercicio8;

public class DiaTemperatura implements Comparable<DiaTemperatura>{
	
	enum DiaSemana{LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO}
	
	private int diaMes;
	private DiaSemana diaSemana;
	private int temperaturaMedia;
	
	
	public DiaTemperatura(int diaMes, DiaSemana diaSemana) {
		this.diaMes = diaMes;
		this.diaSemana = diaSemana;
		this.temperaturaMedia = 0;
	}


	public int getDiaMes() {
		return diaMes;
	}


	public DiaSemana getDiaSemana() {
		return diaSemana;
	}


	public int getTemperaturaMedia() {
		return temperaturaMedia;
	}


	public void setDiaMes(int diaMes) {
		this.diaMes = diaMes;
	}


	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}


	public void setTemperaturaMedia(int temperaturaMedia) {
		this.temperaturaMedia = temperaturaMedia;
	}


	@Override
	public String toString() {
		return "DiaTemperatura [diaMes=" + diaMes + ", diaSemana=" + diaSemana + ", temperaturaMedia="
				+ temperaturaMedia + "]";
	}


	@Override
	public int compareTo(DiaTemperatura o) {
		int devolucion;
		if(this.diaMes < o.getDiaMes()) {
			devolucion = -1;
		}else if(this.diaMes > o.getDiaMes()) {
			devolucion = 1;
		}else {
			devolucion = 0;
		} 
		return devolucion;
	}
	
	
	
	
	
}
