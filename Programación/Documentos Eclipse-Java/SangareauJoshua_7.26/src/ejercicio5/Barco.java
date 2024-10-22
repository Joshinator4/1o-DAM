package ejercicio5;

public class Barco extends VehiculoAcuatico{
	
	private boolean motor;
	
	public Barco(String matricula, String modelo, int eslora, boolean motor) throws IllegalArgumentException {
		super(matricula, modelo, eslora);
		setMotor(motor);
	}
	
	public Barco(boolean motor){
		super();
		setMotor(motor);
	}
	
	public Barco(){
		super();
		setMotor(false);
	}

	public boolean isMotor() {
		return motor;
	}

	public void setMotor(boolean motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return super.toString() + "Barco [motor=" + siONo(this.motor)+ "]";
	}
	
	
	//Este metodo sirve para mostrar si o no en vez de true o false
		private String siONo (boolean x) {
			String devolucion;
			if(x) {
				devolucion = "Si";
			} else {
				devolucion = "No";
			}
			return devolucion;
		}
	
	
	
	

}
