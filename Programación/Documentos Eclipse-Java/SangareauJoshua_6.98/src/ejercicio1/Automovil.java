/*
 * Objetivo: Crear una clase automovil segun lo solictado por el ejercicio
 * Autor: Joshua Sangareau Quesada
 * fecha: 20/2/2024
 */
package ejercicio1;

import java.time.LocalDate;

public class Automovil {
	enum TipoMotor{COMBUSTION, ELECTRICO}
	
	public static final int VelocidadMaximaTotal = 240;
	public static final String MODELO_POR_DEFECTO = "S-70";
	public static final int ANHO_POR_DEFECTO = 2024;
	public static final TipoMotor TIPO_POR_DEFECTO = TipoMotor.COMBUSTION;
	
	private static int contadorCodigo=1;
	public static int cantidadTotalVehiculos = 0; //la cantidad total de automóviles
	public static int cantidadTotalElectricos = 0; //la cantidad de automóviles eléctricos existentes.
	
	private final String codigo; //identifica el automóvil. Lo genera el sistema y tiene el formato AAAA-9999, donde AAAA es el año de fabricación y 9999 es un número que se asigna a partir de 1 cada año natural. Como máximo, cada año habrá un máximo de 500. No cambia nunca.
	private String modelo;  //  el nombre del modelo.
	private int anhoFabricacion; //año de fabricación del automóvil. Siempre será posterior al año 2000.
	private TipoMotor tipo; //combustión o eléctrico.
	private int velocidadMaxima; //velocidad máxima sostenida por el vehículo en km/h. Nunca podrá ser superior a 240 km/h.
	private int velocidadActual;  //velocidad del vehículo en un momento dado.
	
	public Automovil(String modelo, int anhoFabricacion, TipoMotor tipo, int velocidadMaxima) throws IllegalArgumentException{
		
		setModelo(modelo);
		setAnhoFabricacion(anhoFabricacion);
		setTipo(tipo);
		setVelocidadMaxima(velocidadMaxima);
		this.codigo = sacarCodigo();
		this.velocidadActual =0;
		this.cantidadTotalVehiculos++;
		if(this.tipo == TipoMotor.ELECTRICO) {
			cantidadTotalElectricos++;
		}
		
	}
	
	public Automovil() {
		this(MODELO_POR_DEFECTO, ANHO_POR_DEFECTO, TIPO_POR_DEFECTO, VelocidadMaximaTotal);
		this.velocidadActual =0;
	}
	
	
	
	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public int getAnhoFabricacion() {
		return anhoFabricacion;
	}



	public void setAnhoFabricacion(int anhoFabricacion) throws IllegalArgumentException{
		if(anhoFabricacion >= 2000) {
			this.anhoFabricacion = anhoFabricacion;
		}else {
			throw new IllegalArgumentException("El año de fabricacion no puede ser inferior a 2000");
		}
	}



	public TipoMotor getTipo() {
		return tipo;
	}



	public void setTipo(TipoMotor tipo) {
		this.tipo = tipo;
	}



	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}



	public void setVelocidadMaxima(int velocidadMaxima) throws IllegalArgumentException{
		if(velocidadMaxima > VelocidadMaximaTotal) {
			throw new IllegalArgumentException("La velocidad maxima no puede ser mayor a: " + VelocidadMaximaTotal);
		}
		this.velocidadMaxima = velocidadMaxima;
	}



	public int getVelocidadActual() {
		return velocidadActual;
	}



	public void setVelocidadActual(int velocidadActual) throws IllegalArgumentException{
		if(velocidadActual > this.velocidadMaxima) {
			throw new IllegalArgumentException("La velocidad maxima no puede ser mayor a: " + this.velocidadMaxima);
		}
		this.velocidadActual = velocidadActual;
	}



	public String getCodigo() {
		return codigo;
	}
	
	public void acelerar(int kmh)  throws IllegalArgumentException{
		if(this.velocidadActual + kmh > this.velocidadMaxima) {
			throw new IllegalArgumentException("La velocidad actual no puede ser mayor a: " + this.velocidadMaxima);
		}else {
			this.velocidadActual += kmh;
		}
	}
	
	public void frenar(int kmh)  throws IllegalArgumentException{
		if(this.velocidadActual - kmh < 0) {
			this.velocidadActual = 0;
			throw new IllegalArgumentException("No se puede frenar por debajo de 0 km/h");
		}else {
			this.velocidadActual -= kmh;
		}
	}
	
	public String toString() {
		return "Automovil [codigo=" + codigo + ", modelo=" + modelo + ", anhoFabricacion=" + anhoFabricacion + ", tipo="
				+ tipo + ", velocidadMaxima=" + velocidadMaxima + ", velocidadActual=" + velocidadActual + "]";
	}


	//Este metodo genera el codigo del vehiculo
	private String sacarCodigo() {
		String devolucion = null, cambiar;
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaEmpieza = LocalDate.of(2024, 1, 1);
		if(fechaActual.getYear() == fechaEmpieza.getYear()) {
			
		}else {
			Automovil.contadorCodigo = 0;
		}
		cambiar = Integer.toString(contadorCodigo);
		if (cambiar.length() == 1) {
			devolucion = "" + this.anhoFabricacion +"-"+ contadorCodigo;
			Automovil.contadorCodigo++;
		}else if (cambiar.length() == 2) {
			devolucion = "" + this.anhoFabricacion +"-"+ contadorCodigo;
			Automovil.contadorCodigo++;
		}else if (cambiar.length() == 3) {
			devolucion = "" + this.anhoFabricacion +"-"+ contadorCodigo;
			Automovil.contadorCodigo++;
		}else if (cambiar.length() == 4) {
			devolucion =  "" + this.anhoFabricacion +"-"+ contadorCodigo;
			Automovil.contadorCodigo++;
		}
		
		return devolucion;
	}
}
