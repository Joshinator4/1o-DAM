package vehiculo;
/**
 * Clase que representa un <strong>Vehículo</strong>
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar
 * información sobre:</p>
 * <ul>
 * <li>capacidad del depósito de combustible (en litros);</li>
 * <li>consumo medio del vehículo (en litros/100 km);</li>
 * <li>si el vehículo tiene el motor encendido o apagado;</li>
 * <li>el nivel actual del depósito de combustible (en litros);</li>
 * <li>la cantidad de kilómetros recorridos desde que se ha arrancado por última vez (en kilómetros);</li>
 * <li>el consumo realizado desde que se ha arrancado por última vez (en litros);</li>
 * <li>la cantidad total de kilómetros recorridos desde que se fabricó el vehículo (en kilómetros);</li>
 * <li>el consumo total realizado desde que se fabricó el cvehículo (en litros).</li>
 * <li>distancia recorrida total por todos los vehículos que se hayan ido creando hasta el momento (kilómetros);</li>
 * <li>combustible total consumido por todos los vehículos que se hayan ido creando hasta el momento (litros);</li>
 * <li>número de vehículos con el motor encendido en el momento actual.</li>
 * </ul>
 * @author Joshua
 * @version 1.0
 */
public class Vehiculo {

	//Atributos estaticos constantes de la clase
	/**
	 * Consumo medio minimo permitido del vehículo. No puede tener un consumo medio menor que:
	 * {@value MIN_CONSUMO_MEDIO} litros 
	 */
	public static final double MIN_CONSUMO_MEDIO = 2.0;
	/**
	 * Consumo medio máximo permitido del vehículo. No puede tener un consumo medio mayor que:
	 * {@value MAX_CONSUMO_MEDIO} litros 
	 */
	public static final double MAX_CONSUMO_MEDIO = 20.0;
	/**
	 * Capacidad mínima del deposito del vehículo. No puede tener una capacidad menor que:
	 * {@value MIN_CAPACIDAD_DEPOSITO} litros 
	 */
	public static final double MIN_CAPACIDAD_DEPOSITO = 10.0;
	/**
	 * Capacidad mínima del deposito del vehículo. No puede tener una capacidad menor que:
	 * {@value MAX_CAPACIDAD_DEPOSITO} litros 
	 */
	public static final double MAX_CAPACIDAD_DEPOSITO = 120.0;
	/**
	 * Consumo de combustible que gasta el arrancar el motor del vehículo:
	 * {@value CONSUMO_ARRANCAR} litros
	 */
	public static final double CONSUMO_ARRANCAR = 0.02;
	/**
	 * Consumo medio del vehículo que se establecerá por omisión al construir el vehículo: 
	 * {@value VALOR_OMISION_CONSUMO_MEDIO} litros
	 */
	public static final double VALOR_OMISION_CONSUMO_MEDIO = 5.0;
	/**
	 *  Capacidad del deposito del vehículo que se establecerá por omisión al construir el vehículo: 
	 * {@value VALOR_OMISION_CAPACIDAD_DEPOSITO} litros
	 */
	public static final double VALOR_OMISION_CAPACIDAD_DEPOSITO = 50;
	
	//Atributos estaticos de la clase
	/**
	 * Total de kilometros recorridos por todos los vehículos creados
	 */
	private static double kmRecorridosTodos = 0;
	/**
	 * Total de combustible gastado por todos los vehículos creados
	 */
	private static double combustibleTotalTodos = 0;
	/***
	 * Total de vehículos con el motor en marcha en ete momento
	 */
	private static int vehiculosEncendidos = 0;
	
	//Atributos constantes de objeto que se iniciaran en el constructor
	/**
	 * Capacidad del depósito de combustible en litros
	 */
	private final double Capacidad_Deposito; //capacidad del depósito de combustible (en litros) no variará
	/**
	 * Consumo medio del vehículo (en litros/100 km)
	 */
	private final double Consumo_Medio; //consumo medio del vehículo (en litros/100 km);
	
	//Atributos de los objetos
	private boolean estadoMotor; // si el vehículo tiene el motor encendido o apagado;
	private double nivelDeposito; //el nivel actual del depósito de combustible (en litros);
	private double consumoRealizado; //el consumo realizado desde que se ha arrancado por última vez (en litros);
	private double kmRecorridos; //la cantidad de kilómetros recorridos desde que se ha arrancado por última vez (en kilómetros);
	private double kmTotales; //la cantidad total de kilómetros recorridos desde que se fabricó el vehículo (en kilómetros);
	private double consumoTotal; //el consumo total realizado desde que se fabricó el vehículo (en litros).
	
	
	//Constructores de clase
	/**
	 * <strong>Constructor de dos parámetros.</strong>
	 * El vehículo se creará con los valores introducidos como parámetros si son correctos
	 * 
	 * @param capacidadDeposito Capacidad del deposito con el que se creará el vehículo
	 * @param consumoMedio Cosumo medio con el que se creará el vehículo
	 * @throws IllegalArgumentException Si la capacidad del deposito es menor de {@value MIN_CAPACIDAD_DEPOSITO} o mayor de {@value MAX_CAPACIDAD_DEPOSITO} 
	 * y el consumo medio es menor de {@value MIN_CONSUMO_MEDIO} o mayor de {@value MAX_CONSUMO_MEDIO} litros/100km
	 */
	public Vehiculo(double capacidadDeposito, double consumoMedio) throws IllegalArgumentException{
		if (capacidadDeposito >= MIN_CAPACIDAD_DEPOSITO && capacidadDeposito <= MAX_CAPACIDAD_DEPOSITO) {
			this.Capacidad_Deposito = capacidadDeposito;
		}else {
			throw new IllegalArgumentException ("No se puede crear el deposito con menos de 10 o mas de 120 litros de capacidad");
		}
		if(consumoMedio >= MIN_CONSUMO_MEDIO && consumoMedio <= MAX_CONSUMO_MEDIO) {
			this.Consumo_Medio = consumoMedio;
		}else {
			throw new IllegalArgumentException ("No se puede crear el consumo con menos 2 o mas de 20 litros de consumo");
		}
		this.estadoMotor = false;
		this.nivelDeposito = 0;
		this.consumoRealizado = 0;
		this.kmRecorridos = 0;
		this.kmTotales = 0;
		this.consumoTotal = 0;
		
	}
	/**
	 * <strong>Constructor sin parámetros.</strong>
	 * 
	 * Se creará con los valores por defecto por omisión, capacidad deposito =  {@value VALOR_OMISION_CAPACIDAD_DEPOSITO} litros y consumo medio = {@value VALOR_OMISION_CONSUMO_MEDIO} litros/100km
	 */
	public Vehiculo (){
		this(VALOR_OMISION_CAPACIDAD_DEPOSITO, VALOR_OMISION_CONSUMO_MEDIO);
	}
	
	
	//Metodos getter de la clase
	/**
	 * Método que devuelve si el vehiculo esta arrancado o no, con la finalidad de conocer el estado del motor en este instante
	 * 
	 * @return Devuelve en true o false si el vehiculo esta arrancado o no
	 */
	public boolean getIsArrancado(){
		return this.estadoMotor;
	}
	/**
	 * Método que devuelve el consumo medio del vehículo
	 * 
	 * @return devuelve el consumo medio del vehículo
	 */
	public double getConsumoMedio(){
		return this.Consumo_Medio;
	}
	/**
	 * Método que devuelve la capacidad del depósito del vehículo
	 * 
	 * @return capacidad del depósito del vehículo (en litros)
	 */
		
	public double getCapacidadDeposito() {
		return this.Capacidad_Deposito;
	}
	
	/**
	 * Método que devuelve el nivel actual del deósito de combustible, informando así la cantidad que aún hay disponible para poder seguir usando el vehículo
	 * 
	 * @return devuelve el nivel actual del deósito de combustible (en litros)
	 */
	public double getNivelCombustible() {
		return this.nivelDeposito;
	}
	
	/**
	 * Método que informa de la cantidad de kilometros recorridos desde la última vez que se arrancó el vehículo
	 * 
	 * @return devuelve la cantidad de kilometros recorridos desde la última vez que se arrancó el vehículo
	 */
	public double getDistanciaRecorrida() {
		return this.kmRecorridos;
	}
	
	/**
	 * Método que informa de la cantidad de kilómetros recorridos desde que el vehículo se construyó
	 * 
	 * @return devuelve la cantidad de kilómetros recorridos desde que el vehículo se construyó
	 */
	public double getDistanciaRecorridaTotal() {
		return this.kmTotales;
	}
	
	/**
	 * Método que informa de la cantidad de combustible consumido desde la última vez que se arrancó el coche 
	 *  
	 * @return devuelve la cantidad de combustible consumido desde la última vez que se arrancó el coche (en litros)
	 */
	public double getCombustibleConsumido() {
		return this.consumoRealizado;
	}
	
	/**
	 * Método que informa del consumo total realizado desde que se fabricó el vehículo.
	 * 
	 * @return devuelve el consumo total realizado desde que se fabricó el vehículo (en litros).
	 */
	public double getCombustibleConsumidoTotal() {
		return this.consumoTotal;
	}
	
	/**
	 * Método que informa la distancia recorrida total por todos los vehículos generados hasta este instante.
	 * 
	 * @return devuelve la distancia recorrida total por todos los objetos vehículo generados hasta este instante (en kilometros).
	 */
	public static double getDistanciaRecorridaFlota() {
		return kmRecorridosTodos;
	}
	
	/**
	 * Método que informa el combustible consumido total por todos los objetos vehículo generados hasta este instante.
	 * 
	 * @return devuelve el combustible consumido total por todos los objetos vehículo generados hasta este instante (en litros).
	 */
	public static double getCombustibleConsumidoFlota() {
		return combustibleTotalTodos;
	}
	
	/**
	 * Método que informa de la cantidad de vehículos que estan arrancado en este instante.
	 * 
	 * @return devuelve un numero entero indicando la cantidad de vehículos que hay con el motor en marcha en este instante
	 */
	public static double getNumVehiculosArrancadosFlota() {
		return vehiculosEncendidos;
	}
	
	
	//Metodos para usar de la clase
	
	/**
	 * Método que añade la cantidad determinada de combustible al depósito. Si se intenta repostar mas cantidad de la que puede asumir el depósito en este instante, no repostará la cantidad restante, dejando 
	 * al máximo de capcidad el depósito
	 * 
	 * @param cantidadRepostar añade la cantidad indicada de combustible al depósito.
	 * @throws IllegalArgumentException Si se intenta repostar mas cantidad de la que puede asumir el depósito en este instante, no repostará la cantidad restante.
	 */
	public void repostar (double cantidadRepostar) throws IllegalArgumentException{
		if(this.estadoMotor == true) {
			throw new IllegalArgumentException("se intentó repostar con el motor encendido. No se ha repostado.");
			
		}else {
			if(getNivelCombustible() + cantidadRepostar > this.Capacidad_Deposito) {
				double exceso;
				exceso = getNivelCombustible() + cantidadRepostar - this.Capacidad_Deposito;
				this.nivelDeposito = this.Capacidad_Deposito;
				throw new IllegalArgumentException("depósito lleno. Se ha sobrepasado la capaciad del depósito de combustible en " + exceso + " litros.");
			
			}else {
				this.nivelDeposito = getNivelCombustible() + cantidadRepostar;
			}
		}
	}
	
	/**
	 * Método que arranca el vehículo
	 * 
	 * @throws IllegalStateException si el vehículo se encuentra ya rrancado lanzará excepción. Si el nivel del deposito es inferior al consumo de arrancar, lanzará excepción.
	 */
	public void arrancar () throws IllegalStateException {
		if (this.estadoMotor == true) {
			throw new IllegalStateException ("Error: El motor ya se encuentra arrancado.");
		}else if(getNivelCombustible() - CONSUMO_ARRANCAR < 0){
			throw new IllegalStateException ("depósito vacío. Se intentó arrancar sin combustible suficiente.");
		}else {	
			this.consumoRealizado = getCombustibleConsumido() +  CONSUMO_ARRANCAR;
			this.nivelDeposito = getNivelCombustible() - CONSUMO_ARRANCAR;
			this.estadoMotor = true;
			vehiculosEncendidos++;
		}
	}
	
	/**
	 * Método que realiza el trayecto determinado. Este metodo controlará el nivel del deposito, reduciendo su nivel según la distancia recorrida.
	 * Añadirá los kilometros realizados al cuentakilómetros total y al parcial.
	 * Controlará la cantidad de kilómetros que se puede realizar con el nivel de combustible actual, recorriendo los kilómetros que sean
	 * posibles en el caso que el consumo del trayecto sea mayor que el nivel actual de combustible en el dopósito.
	 * Añadira el consumo y los kilómetros recorridos al contador de la flota de vehículos
	 * 
	 * @param kmTrayecto Cantidad de kilómetros a realizar en el trayecto deseado
	 * @throws IllegalArgumentException Si se intenta relizar un trayecto negativo, lanxzará excepción.
	 * @throws IllegalStateException Si se intenta realizar un trayecto con el motor apagado se lanzará excepción.
	 */
	public void realizarTrayecto (double kmTrayecto) throws IllegalArgumentException, IllegalStateException {
		if(kmTrayecto < 0) {
			throw new IllegalArgumentException ("Error: Se intentó realizar un trayecto negativo.");
		}
		if(this.estadoMotor == false) {
			throw new IllegalStateException ("Error: Se intentó realizar un trayecto con el motor apagado. No se ha avanzado.");
		}
		double consumoKilometro = this.Consumo_Medio/100;
		double consumoTrayecto = consumoKilometro * kmTrayecto;
		double trayectoDisponible = getNivelCombustible() / consumoKilometro;
		double faltaRecorrer = kmTrayecto - trayectoDisponible;
		if(consumoTrayecto > this.nivelDeposito) {
			this.kmRecorridos += trayectoDisponible;
			this.kmTotales += trayectoDisponible;
			kmRecorridosTodos += trayectoDisponible;
			combustibleTotalTodos += trayectoDisponible;
			this.nivelDeposito = 0;
			throw new IllegalArgumentException("no se ha podido finalizar el trayecto completamente. Depósito vacío. Han faltado por recorrer " + faltaRecorrer + " km.");
			
		}else {
			this.kmRecorridos += kmTrayecto;
			this.kmTotales += kmTrayecto;
			this.nivelDeposito -= consumoTrayecto;
			kmRecorridosTodos += kmTrayecto;
			combustibleTotalTodos += kmTrayecto;
		}
		
	}
	
	/**
	 * Método que realiza el apagado del motor del vehículo.
	 * Este método restablecerá los valores a 0 del consumo realizado desde la última vez que se arrancó el vehículo y de los kilómetros recorridos desde
	 * la última vez que se arrancó el vehículo. También restará 1 a la cantidad de vehículos totales que se encuentran arrancados en este momento.
	 * 
	 * @throws IllegalStateException Si el motor del vehículo ya se encuentra apagado, lanzará excepción.
	 */
	public void apagar() throws IllegalStateException {
		if(this.estadoMotor == false) {
			throw new IllegalStateException ("el motor ya se encuentra apagado.");
		}else {
			this.estadoMotor = false;
			this.consumoRealizado = 0;
			this.kmRecorridos = 0;
			vehiculosEncendidos--;
		}
	}
	
	private String encendidoOApagado(boolean estadoVehiculo) {
		String devolucion;
		if(this.estadoMotor == true) {
			devolucion = "Encendido";
		}else {
			devolucion = "Apagado";
		}
		return devolucion;
	}
	/**
	 * Método que da información general del objeto vehículo.
	 * 
	 * @return Devuelve cadena de texto con la información del estado del motor, nivel del depósito, distancia recorrida y consumo realizado desde la ultima vez que se arrancó
	 */
	public String toString() {
		return String.format("Estado del motor: %s, nivel del depósito: %.2f, distancia recorrida: %.2f, consumo realizado: %.2f", encendidoOApagado(getIsArrancado()), getNivelCombustible(), getDistanciaRecorrida(), getCombustibleConsumido());
	}

}
