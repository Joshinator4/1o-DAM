/*Realizar un programa en Java que solicite al usuario los siguientes datos:
 * Nombre
 * Apellidos
 * Fecha nacimiento
 * Salario bruto
 * Años trabajando en la empresa
 * Tiene hijos.
 * A partir de estos datos, el programa debe de hacer lo siguiente:
 * Calcular el salario neto del usuario (aplicarle un 15% de IRPF)
 * Mostrar una ficha al usuario en la que se le indique lo siguiente:
 * Estimad@ (Nombre Apellidos), su salario bruto es (salario bruto),
 * teniendo en cuenta un IRPF del 15% su salario neto es (salario neto).
 * Debido a sus (número de años trabajando en la empresa) años trabajando en la
 * empresa su salario se incrementará en un 1% por cada año. El aumento se de
 * (aumento) y el salario total es (salario total).
 * 
 */
package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// Llamamos al Scanner y declaramos la variables
		
		Scanner teclado = new Scanner (System.in);
		
		String nombre, apellidos, fechaNacimiento;
		double salarioBruto, salarioNeto, cantidadIrpf, salarioTotal, aumento, porcentajeYears;
		byte hijos, yearsTrabajando;
		
		//hacemos una constante de IRPF y la inicializamos en 0,15 (15%)
		
		final double IRPF;
		
		IRPF = 0.15;
		
		//pedimos los datos al usuario y le damos el valor a las variables
		
		System.out.println("Introduzca su nombre: ");
		
		nombre = teclado.nextLine();
		
		System.out.println("Introduzca sus apellidos: ");
		
		apellidos = teclado.nextLine();
		
		System.out.println("Introduzca su fecha de nacimiento en formato dd/mm/aaaa: ");
		
		fechaNacimiento = teclado.nextLine();
		
		System.out.println("Introduzca salario bruto: ");
		
		salarioBruto = teclado.nextInt();
		
		System.out.println("Introduzca cantidad de años trabajando: ");
		
		yearsTrabajando = teclado.nextByte();
		
		System.out.println("Introduzca nº de hijos: ");
		
		hijos = teclado.nextByte();
		
		//Realizamos los cálculos matemáticos.
		
		cantidadIrpf = (salarioBruto * IRPF);
		
		salarioNeto = (salarioBruto - cantidadIrpf);
		
		//Cuidado aquí si ponemos (división entrera [/]) no salen decimales. Yo intentaba que saliera 0.15 (15 / 100). No sale por la división entera. Utilizar * (multiplicación) por el nº decimal
		
		porcentajeYears = (yearsTrabajando * 0.01);
		
		aumento = (porcentajeYears * salarioBruto);
		
		salarioTotal = (salarioNeto + aumento);
		
		
		System.out.println("Estimad@ " + nombre + " su salario bruto es: " + salarioBruto);
		System.out.println("teniendo en cuenta un IRPF del 15% su salario neto es: " + salarioNeto);
		System.out.println("debido a sus: " + yearsTrabajando + " años trabajando en la empresa");
		System.out.println("su salario se incrementará en 1% por cada año. El aumento ");
		System.out.println("es de: " + aumento + " y el salario total es: " + salarioTotal);
	}

}
