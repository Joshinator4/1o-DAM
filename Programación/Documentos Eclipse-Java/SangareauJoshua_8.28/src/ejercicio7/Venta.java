package ejercicio7;

public class Venta {
	
	enum NombreMes{ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE}
	
	private int numeroMes;
	private NombreMes nombreMes;
	private int ventasMes;
	
	
	public Venta(int numeroMes, int ventasMes) {
		this.numeroMes = numeroMes;
		setNombreMes(numeroMes);
		this.ventasMes = ventasMes;
	}
	
	
	public String saberVentas() {
		String devolucion = "";
		devolucion += "Mes: " + getNombreMes() + ", se han vendido: " + getVentasMes() + " unidades";
		return devolucion;
	}
	
	public String saberNombre() {
		return this.nombreMes.toString();
		
	}


	public int getNumeroMes() {
		return numeroMes;
	}


	public NombreMes getNombreMes() {
		return nombreMes;
	}


	public int getVentasMes() {
		return ventasMes;
	}


	public void setNumeroMes(int numeroMes) {
		this.numeroMes = numeroMes;
	}


	public void setNombreMes(int numeroMes) {
		switch(numeroMes) {
			case(1):{
				this.nombreMes = NombreMes.ENERO;
				break;
			}case(2):{
				this.nombreMes = NombreMes.FEBRERO;
				break;
			}case(3):{
				this.nombreMes = NombreMes.MARZO;
				break;
			}case(4):{
				this.nombreMes = NombreMes.ABRIL;
				break;
			}case(5):{
				this.nombreMes = NombreMes.MAYO;
				break;
			}case(6):{
				this.nombreMes = NombreMes.JUNIO;
				break;
			}case(7):{
				this.nombreMes = NombreMes.JULIO;
				break;
			}case(8):{
				this.nombreMes = NombreMes.AGOSTO;
				break;
			}case(9):{
				this.nombreMes = NombreMes.SEPTIEMBRE;
				break;
			}case(10):{
				this.nombreMes = NombreMes.OCTUBRE;
				break;
			}case(11):{
				this.nombreMes = NombreMes.NOVIEMBRE;
				break;
			}case(12):{
				this.nombreMes = NombreMes.DICIEMBRE;
				break;
			}default:{
				System.out.println("El numero de mes introducido no es correcto");
				break;
			}
		}
		
		this.nombreMes = nombreMes;
	}


	public void setVentasMes(int ventasMes) {
		this.ventasMes = ventasMes;
	}
	
	

}
