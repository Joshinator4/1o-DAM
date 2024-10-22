/*
 * En nuestro software necesitamos asegurarnos de que la coordenada (x1,y1) represente la esquina
inferior izquierda y la (x2,y2) la superior derecha del rectangulo, como en el dibujo.
Añade a Rectangulo un constructor con los 4 parámetros. Incluye un if que compruebe los valores
(*). Si son válidos guardará los parámetros en el objeto.
Si no lo son mostrará un mensaje del estilo “ERROR al instanciar Rectangulo...” utilizando
System.err.println(…). No podremos evitar que se instancie el objeto pero al menos avisaremos por
pantalla.
Corrige el main para utilizar dicho constructor. Debería mostrar un mensaje de error.
(*) Pista: Es suficiente con un if ( (condición) && (condición) )
 */
package ejercicioC3;

public class Rectangulo {

	private int x1; // primera coordenada del eje X
	private int x2; // segunda coordenada del eje X
	private int y1; // primera coordenada del eje Y
	private int y2; // segunda coordenada del eje Y

	public Rectangulo(int x1, int y1, int x2, int y2) throws IllegalArgumentException {

		setX2(x2);
		setY2(y2);
		setX1(x1);
		setY1(y1);
	}
	
	public int getX1() {
		return this.x1;
	}
	public int getY1() {
		return this.y1;
	}
	public int getX2() {
		return this.x2;
	}
	public int getY2() {
		return this.y2;
	}

	public void setX1(int x1) throws IllegalArgumentException {
		if (x1 >= this.x2) {
			throw new IllegalArgumentException("ERROR: La coordenada x1 NO debe ser mayor o igual a la coordena x2");
		} else {
			if (x1 < 0) {
				throw new IllegalArgumentException("ERROR: La coordenada x1 NO debe ser menor que 0");
			} else {
				this.x1 = x1;
			}
		}

	}
	public void setX2(int x2) throws IllegalArgumentException {
		if (x2 <= this.x1) {
			throw new IllegalArgumentException("ERROR: La coordenada x2 NO debe ser menor o igual a la coordena x1");
		} else {
			if (x2 <= 0) {
				throw new IllegalArgumentException("ERROR: La coordenada x2 NO debe ser menor o igual que 0");
			} else {
				this.x2 = x2;
			}
		}

	}
	public void setY1(int y1) throws IllegalArgumentException {
		if (y1 >= this.y2) {
			throw new IllegalArgumentException("ERROR: La coordenada y1 NO debe ser mayor o igual a la coordena y2");
		} else {
			if (y1 < 0) {
				throw new IllegalArgumentException("ERROR: La coordenada y1 NO debe ser menor que 0");
			} else {
				this.y1 = y1;
			}
		}

	}
	public void setY2(int y2) throws IllegalArgumentException {
		if (y2 <= this.y1) {
			throw new IllegalArgumentException("ERROR: La coordenada y2 NO debe ser menor o igual a la coordena y1");
		} else {
			if (y2 <= 0) {
				throw new IllegalArgumentException("ERROR: La coordenada y2 NO debe ser menor o igual que 0");
			} else {
				this.y2 = y2;
			}
		}

	}
}
