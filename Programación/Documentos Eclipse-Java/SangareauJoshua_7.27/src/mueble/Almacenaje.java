package mueble;

public abstract class Almacenaje extends Mueble implements Personalizable{
	
	// atributos inmutables estaticos de la clase
	public static final int MIN_MODULOS = 1;
	public static final int MAX_MODULOS = 20;
	
	//atributos inmutables de cada objeto
	private final int maxModulos;
	
	//atributos de cada objeto
	private double anchura;
	private double altura;
	protected Modulo[] arrayModulos;
	private int contadorArray;
	protected int contadorModulos; 
	
	

	public Almacenaje(double precio, String descripcion, double anchura, double altura, int maxModulos) throws IllegalArgumentException {
		super(precio, descripcion);
		if(maxModulos < MIN_MODULOS || maxModulos > MAX_MODULOS) {
			throw new IllegalArgumentException ("No se puede crear el mueble de Almacenaje. El número de módulos no está en el rango permitido: " + maxModulos);
		}else {
			this.maxModulos = maxModulos;
		}
		setAnchura(anchura);
		setAltura(altura);
		arrayModulos = new Modulo[(int)maxModulos];
		arrayModulos[0] = Modulo.BALDA;
		this.contadorArray = 1;
		setModulosAnyadidos(1);
		
	}

	


	public int getNumModulos() {
		return maxModulos;
	}




	public double getAnchura() {
		return anchura;
	}




	public double getAltura() {
		return altura;
	}


	public int getModulosAnyadidos() {
		return contadorModulos;
	}




	public void setModulosAnyadidos(int contadorArray) {
		this.contadorModulos = contadorArray;
	}




	public void setAnchura(double anchura) {
		this.anchura = anchura;
	}




	public void setAltura(double altura) {
		this.altura = altura;
	}

	
	


	@Override
	public String toString() {
		return super.toString() + String.format(" anchura= %.2f, altura= %.2f, maxModulos= %d, Módulos añadidos= %d",getAnchura(), getAltura(), getNumModulos(),getModulosAnyadidos());
	}




	@Override
	public String obtenerModulos() {
		String devolucion = "[ ";
		for(int i = 0; i < this.arrayModulos.length; i++) {
			devolucion += arrayModulos[i] + " ";
		}
		devolucion += "]";
		return devolucion;
	}



	@Override
	public void anyadirModulo(Modulo modulo) throws IllegalStateException, NullPointerException {
		if(modulo == null ) {
			throw new NullPointerException ("Error: el módulo a añadir no puede ser nulo");
		}else if((getModulosAnyadidos() + 1) > maxModulos) {
			throw new IllegalStateException ("Error: no se puede añadir el módulo" + modulo + ". El número de módulos no puede superar el máximo permitido: " + maxModulos);
		}else {
			arrayModulos[this.contadorArray] = modulo;
			this.contadorArray++;
			setModulosAnyadidos(getModulosAnyadidos()+1); 
		}
	}


	@Override
	public Modulo extraerModulo() throws IllegalStateException {
		Modulo devolucion;
		if(this.contadorArray <= 1) {
			throw new IllegalStateException ("Error: no se puede quitar el módulo. El número de módulos no puede ser inferior a " + MIN_MODULOS);
		}else {
			devolucion = arrayModulos[this.contadorArray-1];
			arrayModulos[this.contadorArray-1] = null;
			this.contadorArray--;
			setModulosAnyadidos(getModulosAnyadidos()-1); 
		}
		return devolucion;
	}

}
