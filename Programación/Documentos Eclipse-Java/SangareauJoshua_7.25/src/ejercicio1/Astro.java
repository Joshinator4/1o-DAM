package ejercicio1;

public abstract class Astro {
		
	protected double radioEcuatorial; //radio del astro en el la linea ecuatorial o centro del planeta en KM
	protected double rotacionEje; //tiempo en dias que tarda en rotar sobre su propio eje el astro
	protected double traslacion; //tiempo en dias que tarda en dar un vuelta completa alrededor del cuerpo al que orbitan
	protected double distanciaCuerpoOrbitan; //distancia en miles de KM a la que se encuentra el astro del cuerpo al que orbitan
	private double tempMedia;
	private double gravedad;
	
	public Astro (double radioEcuatorial, double rotacionEje, double traslacion, double distanciaCuerpoOrbitan, double temperatura, double gravedad)throws IllegalArgumentException{
		setRadioEcuatorial(radioEcuatorial);
		setRotacionEje(rotacionEje);
		setTraslacion(traslacion);
		setDistanciaCuerpoOrbitan(distanciaCuerpoOrbitan);
		setTempMedia(temperatura);
		setGravedad(gravedad);
	}
	
	public Astro() {
		this(1500, 1, 365, 500, 0, 0);
	}
	
	
	public double getTempMedia() {
		return tempMedia;
	}

	public void setTempMedia(double tempMedia) {
		this.tempMedia = tempMedia;
	}

	public double getGravedad() {
		return gravedad;
	}

	public void setGravedad(double gravedad) throws IllegalArgumentException{
		if(gravedad >= 0) {
			this.gravedad = gravedad;
		} else {
			throw new IllegalArgumentException("La gravedad no puede ser negativa");
		}
	}
	
	
	public double getRadioEcuatorial() {
		return radioEcuatorial;
		
	}
	public void setRadioEcuatorial(double radioEcuatorial) throws IllegalArgumentException{
		if(radioEcuatorial > 0) {
			this.radioEcuatorial = radioEcuatorial;
		}else {
			throw new IllegalArgumentException("El radio equatorial no puede ser negativo o 0");
		}
	}
	public double getRotacionEje() {
		return rotacionEje;
	}
	public void setRotacionEje(double rotacionEje) throws IllegalArgumentException{
		if(rotacionEje > 0) {
			this.rotacionEje = rotacionEje;
		}else {
			throw new IllegalArgumentException("La rotacion sobre el eje no puede ser negativo o 0");
		}
	}
	public double getTraslacion() {
		return traslacion;
	}
	public void setTraslacion(double traslacion) throws IllegalArgumentException{
		if(traslacion > 0) {
			this.traslacion = traslacion;
		}else {
			throw new IllegalArgumentException("La traslacion sobre el cuerpo al que orbitan no puede ser negativo o 0");
		}
	}
	
	public double getDistanciaCuerpoOrbitan() {
		return distanciaCuerpoOrbitan;
	}
	public void setDistanciaCuerpoOrbitan(double distanciaCuerpoOrbitan) throws IllegalArgumentException{
		if(distanciaCuerpoOrbitan > 0) {
			this.distanciaCuerpoOrbitan = distanciaCuerpoOrbitan;
		}else {
			throw new IllegalArgumentException("La distancia sobre el cuerpo al que orbitan no puede ser negativo o 0");
		}
	}

	public String muestra() {
		return "Astro [radioEcuatorial=" + radioEcuatorial + ", rotacionEje=" + rotacionEje + ", traslacion="
				+ traslacion + ", distanciaCuerpoOrbitan=" + distanciaCuerpoOrbitan + "]";
	}
	
	
	
	
	
}
