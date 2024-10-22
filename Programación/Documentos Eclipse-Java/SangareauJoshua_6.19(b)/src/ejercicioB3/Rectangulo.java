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
package ejercicioB3;

public class Rectangulo {

	int x1; // primera coordenada del eje X
	int x2; // segunda coordenada del eje X
	int y1; // primera coordenada del eje Y
	int y2; // segunda coordenada del eje Y

	public Rectangulo(int x1, int y1, int x2, int y2) throws IllegalArgumentException {
		
		if(x1 > x2 && y1 > y2) {
			throw new IllegalArgumentException ("ERROR al instanciar Rectangulo, parametros introducidos incorrectos. Las coordenadas x1 e y1 deben ser siempre menores que x1 e y2." );
		}
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}
