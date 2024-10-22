package ejercicio1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Clase que representa un <strong>Computadora de vuelo de un avión</strong>
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar
 * información sobre:</p>
 * <ul>
 * <li>La matricula del avión</li>
 * <li>El modelo del avión.</li>
 * <li>Si el avón está en vuelo o no</li>
 * <li>El nombre del piloto</li>
 * <li>El tipo de vuelo, si es de escuela o privado</li>
 * <li>El tiempo total de vuelo del avion en minutos</li>
 * <li>La velocidad en un momento determinado del avión en km/h</li>
 * <li>El rumbo del avión en grados</li>
 * <li>La altitud del avion durante el vuelo en metros. Deberá estar entre 1000m y 3000m</li>
 * <li>La cantidad de aeronaves que hay en vuelo en el momento actual</li>
 * <li>La Cantidad de aeronaves que hay creadas en el momento actual</li>
 * <li>La cantidad total de horas de vuelo de todas las aeronaves</li>
 * </ul>
 * @author Joshua
 * @version 1.0
 */
public class ComputadorVuelo {
	
	enum TipoVuelo{ESCUELA, PRIVADO}
	
	//Atributos estaticos constantes de la clase
	/**
	 * El nombre del piloto por defecto será:
	 * {@value PILOTO_DEFECTO}
	 */
	public static final String PILOTO_DEFECTO = "Juan Perez";
	/**
	 * La matricula por defecto será:
	 * {@value MATRICULA_DEFECTO}
	 */
	public static final String MATRICULA_DEFECTO = "EC-ABC";
	/**
	 * El modelo por defecto será:
	 * {@value MODELO_DEFECTO}
	 */
	public static final String MODELO_DEFECTO = "Cessna 152";
	/**
	 * La altitud minima alcanzada en el vuelo de la aeronave será:
	 * {@value MIN_ALTITUD} metros
	 */
	public static final int MIN_ALTITUD = 1000;
	/**
	 * La altitud maxima alcanzada en el vuelo de la aeronave será:
	 * {@value MAX_ALTITUD} metros 
	 */
	public static final int MAX_ALTITUD = 3000;
	/**
	 * El tipo de vuelo de ESCUELA de la aeronave será es:
	 * {@value VUELO_ESCUELA} 
	 */
	public static final int VUELO_ESCUELA = 0;
	/**
	 * El tipo de vuelo de PRIVADO de la aeronave será es:
	 * {@value VUELO_PRIVADO} 
	 */
	public static final int VUELO_PRIVADO = 1;
	
	
	//Atributos estaticos de la clase
	/**
	 *La Cantidad de aeronaves que hay creadas en el momento actual
	 */
	private static int cantidadTotalAeronaves=0;
	/**
	 * La cantidad de aeronaves que hay en vuelo en el momento actual
	 */
	private static int cantidadTotalAeronavesVolando=0;
	/**
	 *La cantidad total de horas de vuelo de todas las aeronaves
	 */
	private static float cantidadTotalHorasVueloAeronaves=0;

	//atributos de clase constantes
	private final String matricula;
	private final String modelo;

	// atributos del estado del vuelo
	private boolean estaVolando; //Si el avón está en vuelo o no
	private String nombrePiloto; //Nombre del piloto que esta pilotando el avion
	private TipoVuelo tipoVuelo; //EL tipo de vuelo, puede ser ESCUELA o PRIVADO
	private int tiempoTotalVuelo; //tiempo del vuelo en minutos
	// atributosla informacion del vuelo
	private int velocidad; // velocidad en km/h
	private int rumbo; // indica el rumbo en grados
	private int altitud; // indica altitud en metros

	
	//Constructores de clase
		/**
		 * <strong>Constructor de tres parámetros.</strong>
		 * El computador de vuelo se creará con los valores introducidos como parámetros si son correctos
		 * 
		 * @param matricula La matricula de la aeronave a crear
		 * @param modelo Modelo de la aeronave a crear
		 * @param piloto El nombre del piloto que pilotará la aeronave
		 * @throws IllegalArgumentException Si la matricula es incorrecta. Si matricula, piloto o modelo estan vacíos. 
		 * @throws NullPointerException Si la matricula, piloto o modelo son nulos  
		 */
	public ComputadorVuelo(String matricula, String modelo, String piloto) throws NullPointerException, IllegalArgumentException{
		if(matricula == null) {
			throw new NullPointerException ("La matrícula de la aeronave no puede ser nula ");
		}else if(matricula.isEmpty()) {
			throw new IllegalArgumentException ("La matrícula contiene una cadena vacía.");
		}else if(!comprobarMatricula(matricula)) {
			throw new IllegalArgumentException ("El formato de la matrícula es incorrecto: " + matricula);
		}else {
			this.matricula = matricula;
		}
		
		if(modelo == null){
			throw new NullPointerException ("El modelo de la aeronave no puede ser nula ");
		}else if(modelo.isEmpty()) {
			throw new IllegalArgumentException ("El modelo contiene una cadena vacía.");
		}else {
			this.modelo = modelo;
		}
		setNombrePiloto(piloto); //atencion!!! Para piloto el filtro y lanzado de excepciones esta en el setter!! (Se hace así ya que piloto no es constante)
		this.cantidadTotalAeronaves++;
		setEstaVolando(false);
		setTipoVuelo(VUELO_ESCUELA);
		setTiempoVuelo(0);
		setVelocidad(0);
		setRumbo(0);
		this.altitud = 0;
		
	}
	
	/**
	 * <strong>Constructor de dos parámetros.</strong>
	 * El computador de vuelo se creará con los valores introducidos como parámetros si son correctos
	 * 
	 * @param matricula La matricula de la aeronave a crear
	 * @param modelo Modelo de la aeronave a crear
	 * El piloto se creara con el valor por defecto piloto = {@value PILOTO_DEFECTO}
	 * @throws IllegalArgumentException Si la matricula es incorrecta. Si matricula o modelo estan vacíos. 
	 * @throws NullPointerException Si la matricula o modelo son nulos  
	 */
	public ComputadorVuelo(String matricula, String modelo) throws NullPointerException, IllegalArgumentException{
		this(matricula, modelo, PILOTO_DEFECTO);
		
	}
	/**
	 * <strong>Constructor sin parámetros.</strong>
	 * 
	 * Se creará con los valores por defecto por omisión, matricula =  {@value MATRICULA_DEFECTO}, modelo = {@value MODELO_DEFECTO} y piloto = {@value PILOTO_DEFECTO}
	 */
	public ComputadorVuelo() {
		this(MATRICULA_DEFECTO, MODELO_DEFECTO, PILOTO_DEFECTO);
	}
	
	/**
	 * Método estático fabrica o pseudoconstructor que genera un array de computadoras de vuelo segun el paramatro recibido
	 * 
	 * @param cantidadAeronaves recibe numero entero con la cantidad de aeronaves a instanciar en el array (tambien sirve para dimensionar el array)
	 * @throws IllegalArgumentException Lanzará esta excepcion si el parametro recibido es menor que 1 o mayor que 10
	 * @return devuelve el array de computadores de vuelos creado
	 */
	public static ComputadorVuelo[] crearArrayComputadorVuelo(int cantidadAeronaves) throws IllegalArgumentException{
		if(cantidadAeronaves < 1 || cantidadAeronaves > 10) {
			throw new IllegalArgumentException ("Número de aviones incorrecto" + cantidadAeronaves + ", debe ser mayor o igual que 1 y menor o igual que 10,");
		}
			ComputadorVuelo[] arrayComputadores = new ComputadorVuelo[cantidadAeronaves];
			for(int i = 0; i < cantidadAeronaves; i++) {
				arrayComputadores[i] = new ComputadorVuelo();
			}
		return arrayComputadores;
	}

	/**
	 * Método que comprueba si la matricula corresponde con el patrón y tiene un formato correcto
	 * 
	 * @return Devuelve en true o false si la matricula es correcta o no
	 */
	private boolean comprobarMatricula(String matricula){
		boolean devolucion;
		Pattern patMatricula = Pattern.compile("[E]{1}[C]{1}[-]{1}[a-zA-Z0-9]{3}");
	    Matcher matMatricula = patMatricula.matcher(matricula);
		if(matMatricula.matches()) {
			devolucion = true;
		}else {
			devolucion = false;
		}
	    return devolucion;
			
	}
	
	/**
	 * Método realiza el despegue de la aeronave recibiendo como parametros el tipo de vuelo, la velocidad del vuelo y la altitud.
	 * Actualiza los atributos involucrados en el vuelo
	 * 
	 * @param tipoVuelo El tipo de vuelo que se va a realizar en numero 0 = ESCUELA y 1 = PRIVADO
	 * @param velocidad La velocidad a la que se realizará el vuelo
	 * @param altitud La altitud que se mantendrá durante el vuelo. Debe ser inferior o iual a 3000m y superior o igual a 1000m
	 * @throws IllegalStateException Se lanzara si la aeronave ya está en vuelo
	 * @throws IllegalArgumentException Se lanzará si la altitud del vuelo es mayor que {@value MAX_ALTITUD}metros o menor que {@value MIN_ALTITUD}metros
	 */
	public void despegar(int tipoVuelo, int velocidad, int altitud)throws IllegalStateException, IllegalArgumentException {
		if(altitud < MIN_ALTITUD && altitud > MAX_ALTITUD) {
			throw new IllegalArgumentException("La altitud de vuelo de " + altitud + "metros es incorrecta.");
		}else if(estaVolando == true) {
			throw new IllegalStateException (this.matricula + "ya ha despegado y se encuentra fuera del aeropuerto.");
		}else {
			setEstaVolando(true);
			setTipoVuelo(tipoVuelo);
			setAltitud(altitud);
			setVelocidad(velocidad);
			cantidadTotalAeronavesVolando++;
		}
		
	}
	
	
	/**
	 * Método realiza el aterrizaje de la aeronave recibiendo como parametros aeropuerto de salida, el aeropuerto de llegada y el tiempo de vuelo.
	 * Actualiza los atributos involucrados en el vuelo, acumula el tiempo de vuelo y pone a 0 la velocidad, rumbo y altitud
	 * 
	 * @param aeropuertoSalida El aeropuerto del que despega o sale la aeronave
	 * @param aeropuertoLlegada El aeropuerto en el que aterriza o llega la aeronave
	 * @param tiempoVuelo El tiempo de vuelo en minutos
	 * @throws IllegalStateException Se lanzara si la aeronave ya está en vuelo
	 * @throws IllegalArgumentException Se lanzará si la altitud del vuelo es mayor que {@value MAX_ALTITUD}metros o menor que {@value MIN_ALTITUD}metros
	 */
	public void aterrizar(String aeropuertoSalida, String aeropuertoLlegada, int tiempoVuelo)throws IllegalStateException {
		if(estaVolando == false) {
			throw new IllegalStateException (this.matricula + "ya ha aterrizado y debe despegar de nuevo antes de volver a aterrizar");
		}else {
			setEstaVolando(false);
			setTiempoVuelo(getTiempoVuelo() + tiempoVuelo);
			cantidadTotalHorasVueloAeronaves += (float)tiempoVuelo/60;
			cantidadTotalAeronavesVolando--;
			this.altitud = 0;
			setVelocidad(0);
			setRumbo(0);
		}
	}
	
	
	//Metodos setter y getter de la clase
	/**
	* Método que devuelve si la aeronave esta en vuelo o no.
	* 
	* @return Devuelve en true o false si la aeronave esta en vuelo o no.
	*/
	public boolean isEstaVolando() {
		return estaVolando;
	}

	/**
	 * Metodo que actualiza el estado del avion, si está volando o no
	 * @param estaVolando true o false según si está volando o no respectivamente
	 */
	public void setEstaVolando(boolean estaVolando) {
		this.estaVolando = estaVolando;
	}
	
	
	/**
	* Método que devuelve el nombre del piloto de la aeronave.
	* 
	* @return Devuelve el nombre del piloto de la aeronave
	*/
	public String getNombrePiloto() {
		return nombrePiloto;
	}
	
	/**
	 * Metodo que actualiza el nombre del piloto
	 * @param nombrePiloto cadena de texto con el nombre del piloto
	 * @throws NullPointerException lanzara esta excepcion si la cadena de texto es nula
	 * @throws IllegalArgumentException lanzará esta excepción si la cadena de texto está vacía
	 */
	public void setNombrePiloto(String nombrePiloto) throws NullPointerException, IllegalArgumentException{
		if(nombrePiloto == null){
			throw new NullPointerException ("El nombre del piloto de la aeronave no puede ser nula ");
		}else if(nombrePiloto.isEmpty()) {
			throw new IllegalArgumentException ("El nombre del piloto contiene una cadena vacía.");
		}else {
			this.nombrePiloto = nombrePiloto;
		}
	}
	
	/**
	* Método que devuelve el tipo de vuelo que está relizando la aeronave.
	* 
	* @return Devuelve 0 sie el tipo de ESCUELA y 1 si el tipo es PRIVADO
	*/
	public int getTipoVuelo() {
		int devolucion;
		if(tipoVuelo == TipoVuelo.ESCUELA) {
			devolucion = 0;
		}else if(tipoVuelo == TipoVuelo.PRIVADO) {
			devolucion = 1;
		}else {
			devolucion = 0;
		}
		return devolucion;
	}
	

	/**
	 * Metodo que actualiza el tipo de vuelo actual
	 * @param tipoVuelo nuemero entero que deben ser 0 o 1. 0 = ESCUELA y 1 = PRIVADO
	 * @throws IllegalArgumentException lanzara esta excepcion si el parametro recibido es diferente de 0 o 1.
	 */
	public void setTipoVuelo(int tipoVuelo) throws IllegalArgumentException {
		if(tipoVuelo == 0) {
			this.tipoVuelo = TipoVuelo.ESCUELA;
		}else if(tipoVuelo == 1) {
			this.tipoVuelo = TipoVuelo.PRIVADO;
		}else {
			throw new IllegalArgumentException("EL tipo de vuelo solo puede ser 0 o 1");
		}
	}
	
	
	/**
	* Método que devuelve el tiempo total de vuelo de la aeronave en minutos.
	* 
	* @return Devuelve el tiempo total de vuelo de la aeronave en minutos.
	*/
	public int getTiempoVuelo() {
		return tiempoTotalVuelo;
	}
	

	/**
	 * Metodo que actualiza el tiempo total de vuelo de la aeronave
	 * @param tiempoVuelo recibe un numero entero con los minutos acumulados de vuelo 
	 */
	public void setTiempoVuelo(int tiempoVuelo) {
		this.tiempoTotalVuelo = tiempoVuelo;
	}
	
	/**
	* Método que devuelve la velocidad del vuelo actual de la aeronave en km/h.
	* 
	* @return Devuelve la velocidad del vuelo actual de la aeronave en km/h.
	*/
	public int getVelocidad() {
		return velocidad;
	}
	
	/**
	 * Metodo que actualiza la velocidad de vuelo de la aeronave
	 * @param velocidad recibe un numero entero con la velocidad en km/h
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	/**
	* Método que devuelve el rumbo del vuelo actual de la aeronave en grados.
	* 
	* @return Devuelve el rumbo del vuelo actual de la aeronave en grados.
	*/
	public int getRumbo() {
		return rumbo;
	}
	
	/**
	 * Metodo que actualiza el rumbo de vuelo de la aeronave
	 * @param rumbo recibe un numero entero con el rumbo en grados
	 */
	public void setRumbo(int rumbo) {
		this.rumbo = rumbo;
	}
	 
	/**
	* Método que devuelve la altitud del vuelo actual de la aeronave en metros.
	* 
	* @return Devuelve la altitud del vuelo actual de la aeronave en metros.
	*/
	public int getAltitud() {
		return altitud;
	}
	
	/**
	 * Metodo que actualiza la altitud de vuelo de la aeronave
	 * @param altitud recibe un numero entero la altitud en metros.
	 */
	public void setAltitud(int altitud) {
		if(altitud >= MIN_ALTITUD && altitud <= MAX_ALTITUD) {
			this.altitud = altitud;
		}else {
			this.altitud = MIN_ALTITUD;
		}
	}
	
	
	/**
	* Método que devuelve la matricula de la aeronave.
	* 
	* @return Devuelve la matricula de la aeronave..
	*/
	public String getMatricula() {
		return matricula;
	}
	
	
	/**
	* Método que devuelve el modelo de la aeronave.
	* 
	* @return Devuelve el modelo de la aeronave.
	*/
	public String getModelo() {
		return modelo;
	}
	
	/**
	* Método estatico que devuelve el numero aeronaves creadas hasta el momento.
	* 
	* @return Devuelve el numero aeronaves creadas hasta el momento.
	*/
	public static int getNumAeronaves() {
		return cantidadTotalAeronaves;
	}

	/**
	* Método estatico que devuelve el numero aeronaves que estan volando en este momento.
	* 
	* @return Devuelve el numero aeronaves que estan volando en este momento.
	*/
	public static int getNumAeronavesVolando() {
		return cantidadTotalAeronavesVolando;
	}
	
	/**
	* Método estatico que devuelve el numero total de horas de vuelo de todas las aeronaves en este momento.
	* 
	* @return Devuelve el numero total de horas de vuelo de todas las aeronaves en este momento.
	*/
	public static float getNumHorasVuelo() {
		return cantidadTotalHorasVueloAeronaves;
	}

	
	/**
	 * Método que da información general de la aeronave.
	 * 
	 * @return Devuelve cadena de texto con la información de la matricula, si esta volando o no, nombre del piloto, tipo de vuelo, tiempo total de vuelo de la aeronave en minutos, velocidad en km/h, rumbo en grados y altitud en metros
	 */
	@Override
	public String toString() {
		return String.format("[matricula= %s, modelo= %s, estaVolando= %b, nombrePiloto= %s, tipoVuelo= %d,"
				+ " tiempoTotalVuelo= %d, V= %d km/h, rumbo= %dº, altitud= %d metros]", getMatricula(),getModelo(),
				isEstaVolando(), getNombrePiloto(), getTipoVuelo(), getTiempoVuelo(), getVelocidad(), getRumbo(), getAltitud());
	}
	
	

}
