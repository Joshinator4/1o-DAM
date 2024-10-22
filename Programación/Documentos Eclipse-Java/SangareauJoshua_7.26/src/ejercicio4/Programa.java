package ejercicio4;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		boolean banderaPrograma = true;
		int opcionSeleccionada, empresaModificar;
		Empresa[] empresas = new Empresa[10];
		Scanner teclado = new Scanner(System.in);

		try {
			empresas[0] = new Empresa("Telefonica", "C12345678");
			empresas[1] = new Empresa("Vodafone", "V12345678");
			empresas[2] = new Empresa("Orange", "O12345678");

			System.out
					.println("Elija la empresa la cual desea modificar:\n1.- Telefonica" + "\n2.- Vodafone\n3.- Orange");
			empresaModificar = teclado.nextInt();

			do {

				System.out.println(
						"Introduzca la opcion deseada: \n1.- Añadir empleado predefinido\n2.- Añadir empleado personalizado\n3.- "
								+ "Eliminar empleado por numero de ID Empleado\n4.- Mostrar la informacion de los todos los empleados de la empresa"
								+ "\n5.- Mostrar la informacion de salarios de cada empleado de la empresa\n6.- Calcular La suma total de salarios "
								+ "brutos de los empleados de la empresa\n7.- Calcular la suma total de los salarios netos de los empleados de la empresa"
								+ "\n0.- Salir del programa");
				opcionSeleccionada = teclado.nextInt();
				teclado.nextLine();
				
				switch (opcionSeleccionada) {
				case (1): {
					empresas[empresaModificar - 1].añadirEmpleado();
					break;

				}
				case (2): {
					System.out.println("Introduzca nombre del empleado:");
					String nombreEmpleado = teclado.nextLine();
					System.out.println("Introduzca dni del empleado:");
					String dniEmpleado = teclado.nextLine();
					System.out.println("Introduzca salario del empleado:");
					double salarioEmpleado = teclado.nextDouble();
					teclado.nextLine();
					empresas[empresaModificar - 1]
							.añadirEmpleado(new Empleado(nombreEmpleado, dniEmpleado, salarioEmpleado));
					break;

				}
				case (3): {
					System.out.println("Introduzca el ID del Empleado a eliminar");
					int empleadoEliminar = teclado.nextInt();
					empresas[empresaModificar - 1].eliminarEmpleado(empleadoEliminar);
					teclado.nextLine();
					break;

				}
				case (4): {
					System.out.println(empresas[empresaModificar - 1].mostrarEmpleados());
					break;

				}
				case (5): {
					System.out.println(empresas[empresaModificar - 1].mostrarEmpleadosNeto());
					break;

				}
				case (6): {
					System.out.println(empresas[empresaModificar - 1].calcularBrutosEmpresa());
					break;

				}
				case (7): {
					System.out.println(empresas[empresaModificar - 1].calcularNetosEmpresa());
					break;

				}
				case (0): {
					System.out.println("Se va a proceder a cerrar el programa. ¡Hasta pronto!");
					banderaPrograma = false;
					break;

				}
				default: {
					System.out.println(
							"Se ha introducido una opcion incorrecta. Por favor marque alguno de los numero previamente mostrados");
					break;

				}

				}

			} while (banderaPrograma == true);

		} catch (IllegalArgumentException excepcion1) {
			System.out.println(excepcion1.getMessage());
		} catch (Exception excepcion2) {
			System.out.println(excepcion2.getMessage());
		}

	}

}
