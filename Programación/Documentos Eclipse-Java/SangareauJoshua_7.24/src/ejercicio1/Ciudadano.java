package ejercicio1;

public class Ciudadano extends Humano{

		protected String documento;
		
		
		public Ciudadano(String nombre, String apellido,String dni) {
			super(nombre, apellido);
			this.documento = dni;
		}
		
		public String identificacion() {
			return super.getNombreCompleto() + ", " + this.documento + ".";
		}
}
