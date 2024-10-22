package ejercicio1;

public class Planeta extends Astro{
	protected static int contadorPlaneta = 1; //contador que asignará numero al idPlaneta
	
	
	private Satelite [] satelitePlaneta; //Array de satelites que guardará para cada planeta los satélites que le orbitan
	private int contadorSatelites = 0;  //contador que recorrerá las posiciones del array satelitePlaneta
	private double distanciaSol; //distancia en millones de Kilometros
	private boolean orbitaSol; //si orbita o no al sol (si está o no dentro del sistema solar)
	private boolean tieneSatelites; // si tiene o no satélites que le orbitan
	private final int idPlaneta; //Numero identificativo del planeta
	
	public Planeta(double distancia, boolean orbita, boolean satelites) throws IllegalArgumentException{
		super();
		setDistanciaSol(distancia);
		setOrbitaSol(orbita);
		setTieneSatelites(satelites);
		this.idPlaneta = contadorPlaneta;
		this.satelitePlaneta = new Satelite[15];
		this.contadorPlaneta++;
	}
	
	public Planeta() {
		this(1800, true, false);
	}
	
	public double getDistanciaSol() {
		return distanciaSol;
	}

	public void setDistanciaSol(double distanciaSol) throws IllegalArgumentException{
		if(distanciaSol <= 0) {
			throw new IllegalArgumentException("La distancia al sol no puede ser negativa o 0");
		}
		this.distanciaSol = distanciaSol;
	}

	public boolean isOrbitaSol() {
		return orbitaSol;
	}

	public void setOrbitaSol(boolean orbitaSol) throws IllegalStateException{
		if(this.orbitaSol == false && orbitaSol == false) {
			throw new IllegalStateException("No se puede poner que no orbita al sol cuando el estado ya es: no orbita");
		}else if(this.orbitaSol == true && orbitaSol == true) {
			throw new IllegalStateException("No se puede poner que orbita al sol cuando el estado ya es: si orbita");
		}
		this.orbitaSol = orbitaSol;
	}

	public boolean isTieneSatelites() {
		return tieneSatelites;
	}

	public void setTieneSatelites(boolean tieneSatelites) {
		this.tieneSatelites = tieneSatelites;
	}

	public int getIdPlaneta() {
		return idPlaneta;
	}
	

	public void agregarSateliteAPlaneta(Satelite objetoSatelite) {
		if(contadorSatelites == 0) {
			setTieneSatelites(true);
		}
		this.satelitePlaneta [contadorSatelites] = objetoSatelite;
		this.satelitePlaneta [contadorSatelites].setPertenecePlaneta(getIdPlaneta());
		contadorSatelites++;
	}

	@Override
	public String muestra() {
		String devolucion = "";
		devolucion += super.muestra() + "Planeta [distanciaSol=" + distanciaSol + ", orbitaSol=" + orbitaSol + ", tieneSatelites="
				+ tieneSatelites + ", idPlaneta=" + idPlaneta + "]";
		for(int i = 0; i < this.satelitePlaneta.length; i++) {
			if(satelitePlaneta[i] == null){
				
			}else {
				devolucion += "\nSatelite " + (i+1) +": " + satelitePlaneta[i].muestra();
			}
		}
		if(devolucion.isEmpty()) {
			devolucion = "El planeta no tiene satélites";
		}
		return devolucion;
		
	}
	
	
	
	
	
	
}
