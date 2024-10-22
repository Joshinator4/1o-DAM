package ejercicio3;

import java.util.Scanner;

public class PrincipalEmpleado {

	public static void main(String[] args) {
		
		double sueldoBase;
		int horasExtras;
		
		Scanner teclado = new Scanner (System.in);
		try {
			Empleado empleado1 = new Empleado("53702469E", "Juan", "Blázquez");
			System.out.printf("Introduzca el sueldo base de: %s\n", empleado1.getNombreEmpleado());
			sueldoBase = teclado.nextDouble();
			empleado1.setSueldoBase(sueldoBase);
			empleado1.setPrecioHoraExtra();
			System.out.printf("Introduzca el numero de horas extras realizadas este mes por: %s\n", empleado1.getNombreEmpleado());
			horasExtras = teclado.nextInt();
			empleado1.setCantidadHorasExtra(horasExtras);
			System.out.println(empleado1.verTodoEmpleado());
			
			Empleado empleado2 = new Empleado("05462865C", "Antonio", "González", 2356.25, 15.15, 20, 15, 3, true);
			
			Empleado empleado3 = new Empleado();
			empleado3.copia(empleado2);
			System.out.printf("Introduzca el sueldo base de: %s\n", empleado3.getNombreEmpleado());
			sueldoBase = teclado.nextDouble();
			empleado3.setSueldoBase(sueldoBase);
			empleado3.setPrecioHoraExtra();
			System.out.printf("Introduzca el numero de horas extras realizadas este mes por: %s\n", empleado3.getNombreEmpleado());
			horasExtras = teclado.nextInt();
			empleado3.setCantidadHorasExtra(horasExtras);
			System.out.printf(empleado3.verDatosEconomicos() +"\n");
			
			System.out.println(empleado1.verTodoEmpleado() + "\n" +  empleado2.verTodoEmpleado() + "\n" + empleado3.verTodoEmpleado());
			
			System.out.println("El numero total de empleados es: " + Empleado.numeroTotalEmpleados());
			
		}catch (IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		}catch (IllegalStateException excepcion2) {
			System.out.println(excepcion2.getMessage());
		}catch (Exception excepcion3) {
			System.out.println(excepcion3.getMessage());
		}
		
	}

}
