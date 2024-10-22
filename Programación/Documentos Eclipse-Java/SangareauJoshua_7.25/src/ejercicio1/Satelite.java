package ejercicio1;

public class Satelite extends Astro{
	
	private double distanciaAlPlaneta; // distancia en miles de KM al planeta al que orbita
	private int orbitaPlanetaria; // Tiempo en horas que tarda en dar una vuelta al cuerpo al que orbitan
	private int pertenecePlaneta; //Numero de idPlaneta al que orbita
	
	public Satelite(double distanciaPlaneta, int orbitaPlanetaria, int pertenecePlaneta)throws IllegalArgumentException {
		super();
		setDistanciaAlPlaneta(distanciaPlaneta);
		setOrbitaPlanetaria(orbitaPlanetaria);
		setPertenecePlaneta(pertenecePlaneta);
	}
	public Satelite(int pertenecePlaneta) {
		this(1000, 24, pertenecePlaneta);
	}

	public Satelite() {
		this(1000, 24, 1);
	}

	public double getDistanciaAlPlaneta() {
		return distanciaAlPlaneta;
	}

	public void setDistanciaAlPlaneta(double distanciaAlPlaneta) throws IllegalArgumentException{
		if(distanciaAlPlaneta <= 0) {
			throw new IllegalArgumentException("La distancia del satelite al cuerpo que orbitan no puede ser ni inferior ni igual a 0");
		}
		this.distanciaAlPlaneta = distanciaAlPlaneta;
	}

	public int getOrbitaPlanetaria() {
		return orbitaPlanetaria;
	}

	public void setOrbitaPlanetaria(int orbitaPlanetaria)throws IllegalArgumentException{
		if( orbitaPlanetaria <= 0) {
			throw new IllegalArgumentException("El tiempo en horas de la orbitacion del satélite sobre el cuerpo al que orbitan no puede ser ni inferior ni igual a 0");
		}
		this.orbitaPlanetaria = orbitaPlanetaria;
	}

	public int getPertenecePlaneta() {
		return pertenecePlaneta;
	}

	public void setPertenecePlaneta(int pertenecePlaneta) throws IllegalArgumentException{
		if(pertenecePlaneta <=0 || pertenecePlaneta > Planeta.contadorPlaneta -1) {
			throw new IllegalArgumentException("El id del planeta al que pertence no es correcto. No puede ser inferior a 0 o superior a la cantidad de planetas creados");
		}
		this.pertenecePlaneta = pertenecePlaneta;
	}
	
	@Override
	public String muestra() {
		return super.muestra() + "Satelite [distanciaAlPlaneta=" + distanciaAlPlaneta + ", orbitaPlanetaria=" + orbitaPlanetaria
				+ ", pertenecePlaneta=" + pertenecePlaneta + "]";
	}
	
	
	
	
}
