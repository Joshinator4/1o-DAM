package generarID;

	import java.time.LocalDate;

	/**
	 * Autor: Adrián González García
	 * Fecha: 25 abr 2024
	 * Ejercicio: Modelaje de la clase abstracta Servicio
	 */
	public abstract class Servicio {
	    public static final int MAX_SERVICIOS = 999;
	    public static final int MIN_YEAR = LocalDate.MIN.getYear();
	    
	    private static int[] contador;
	    
	    protected final String id;
	    protected String trabajador;
	    protected LocalDate fecha;
	    protected String cliente;
	    
	    static {
	        contador = new int[LocalDate.now().getYear() - MIN_YEAR];
	    }
	    
	    
	    protected Servicio(String trabajador, LocalDate fecha, String cliente) throws IllegalArgumentException {
	        int anyo = fecha.getYear()-MIN_YEAR;
	        if(contador[anyo-1]==MAX_SERVICIOS) throw new IllegalArgumentException("Se ha llegado al máximo de servicios por año");
	        this.trabajador = trabajador;
	        this.fecha = fecha;
	        this.cliente = cliente;
	        this.id = generarId(anyo);
	        contador[anyo-1]++;
	    }
	    
	    private String generarId(int anyo) {
	        String codigo = String.valueOf(contador[anyo-1]);
	        while(codigo.length()<3) codigo = "0" + codigo;
	        return String.valueOf(fecha.getYear()) + "-" + codigo;
	    }
	    
	    public String getId() {
	        return id;
	    }

	    public LocalDate getFecha() {
	        return fecha;
	    }

	    public abstract double costeMaterial();
	    
	    public abstract double costeManoObra();
	    
	    public final double costeTotal() {
	        return costeMaterial() + costeManoObra();
	    }
	    
	}

