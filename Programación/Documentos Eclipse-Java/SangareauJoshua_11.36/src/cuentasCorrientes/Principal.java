/*
 *Gestión de Clientes: alta, baja (solo si no tiene cuentas corrientes), modificación (todo salvo dni). 
 *Gestión de cuentas corrientes (alta de cuenta, baja de cuenta [no la elimina de la base de datos para no perder los datos], ingreso en cuenta,
 *salida de cuenta, transferencia [tiene una cuenta emisora y una receptora, generará dos movimientos].
 *Gestión de movimientos de la cuenta corriente de un cliente. Recibe el número de cuenta corriente a gestionar y permite: listar los movimientos entre fechas. 
*/
package cuentasCorrientes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Clase que representa <strong>la gestion de un banco</strong>
 * <p>
 * En esta clase se permite gestionar clientes, sus cuentas corrientes y sus
 * movimientos pudiendo:
 * </p>
 * <ul>
 * <li>Dar de alta un cliente</li>
 * <li>Dar de baja a un cliente si no tiene cuentas corrientes</li>
 * <li>Modificar los datos de un cliente</li>
 * <li>Dar de alta una cuenta corriente</li>
 * <li>Dar de baja una cuenta (no se borrarán los datos)</li>
 * <li>Realizar un ingreso</li>
 * <li>Realizar una retirada</li>
 * <li>Realizar una transferencia entre cuentas</li>
 * <li>Gestionar los movimientos realizados entre dos fechas</li>
 * </ul>
 * 
 * @author Joshua
 * @version 1.0
 */
public class Principal {
	/**
	 * Método main de la clase principal donde se desarrollará el menú para acceder
	 * a las distintas funciones (métodos) del código
	 * 
	 */
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int opcionDeseada;
		Connection conexion = null;
		conexion = realizarConexion(conexion);
		do {
			System.out.println(
					"Elija un opcion:\n1.-Alta cliente.\n2.-Baja de un cliente(solo si no tiene cuentas asociadas)"
							+ "\n3.-Modificar datos de un cliente.\n4.-Alta de cuenta" + "\n5.-Dar de baja una cuenta\n"
							+ "6.-Ingreso\n7.-Retirada\n8.-Transeferencia\n9.-Gestionar movimientos por fecha\n"
							+ "10.-Listar los últimos 10 movimientos.\n0.-Salir del programa");
			opcionDeseada = teclado.nextInt();
			switch (opcionDeseada) {
			case (1): {

				altaCliente(teclado, conexion);
				break;

			}
			case (2): {

				bajaCliente(teclado, conexion);
				break;

			}
			case (3): {

				modificarCliente(teclado, conexion);
				break;

			}
			case (4): {
				altaCuenta(teclado, conexion);
				break;

			}
			case (5): {
				bajaCuenta(teclado, conexion);
				break;

			}
			case (6): {
				ingreso(teclado, conexion);
				break;

			}
			case (7): {
				retirada(teclado, conexion);
				break;

			}
			case (8): {
				transferencia(teclado, conexion);
				break;

			}
			case (9): {
				listarMovimientos(teclado, conexion);
				break;

			}
			case (10): {
				listarUltimosDiez(teclado, conexion);
				break;

			}
			case (0): {
				System.out.println("Se va a proceder a cerrar el programa, ¡Hasta Pronto!");
				try {
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
			default: {
				System.out.println(
						"Se ha introducido una opcion incorrecta, introduzca un numero de cualquiera de las funciones");
			}

			}

		} while (opcionDeseada != 0);

	}

	// este método realiza la conexion con la base de datos
	private static Connection realizarConexion(Connection conexion) {
		try {
			String url = "jdbc:mysql://localhost:3306/cuentas_corrientes";
			String user = "java";
			String pass = "1234";
			conexion = DriverManager.getConnection(url, user, pass);

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conexion;

	}

	// este método solicita los datos necesarios y da de alta a un cliente,
	// filtrando si el cliente ya existe
	/**
	 * Método que añade un cliente a la base de datos filtrando por dni que no
	 * exista otro cliente ya creado con ese dni En caso de ya existir el dni se
	 * mostrará un mensaje.
	 * 
	 * @param teclado  un objeto de tipo Scanner para pedir los datos necesarios
	 * @param conexion un objeto de tipo Connection que da la conexion para realizar
	 *                 la consulta de filtrado de dni y la insercion en caso que se
	 *                 pueda realizar
	 */
	public static void altaCliente(Scanner teclado, Connection conexion) {
		String dni, nombre, telefono, direccion;
		String consulta = "insert into clientes (dni, nombre, telefono, direccion) values(?,?,?,?)";
		teclado.nextLine();
		System.out.println("Introduzca el dni del cliente");
		dni = teclado.nextLine();
		int cantidad = filtrarDni(teclado, conexion, dni);
		if (cantidad > 0) {
			System.out.println("El cliente con dni que intenta introducir ya existe");
		} else {
			System.out.println("Introduzca el nombre del cliente");
			nombre = teclado.nextLine();
			System.out.println("Introduzca el telefono del cliente");
			telefono = teclado.nextLine();
			System.out.println("Introduzca la direccion del cliente");
			direccion = teclado.nextLine();

			try {
				PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
				sentenciaConsulta.setString(1, dni);
				sentenciaConsulta.setString(2, nombre);
				sentenciaConsulta.setString(3, telefono);
				sentenciaConsulta.setString(4, direccion);

				sentenciaConsulta.executeUpdate();
				sentenciaConsulta.close();
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
				System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
			}
		}
	}

	// este método elimina un cliente de la base de datos si no tiene cuentas
	// existentes
	/**
	 * Método que da de baja un cliente de la base de datos filtrando por dni para
	 * que exista el cliente y filtrando tambien que no tenga cuentas corrientes. En
	 * ese caso no dejará borrarlo.
	 * 
	 * @param teclado  un objeto de tipo Scanner para pedir los datos necesarios
	 * @param conexion un objeto de tipo Connection que da la conexion para realizar
	 *                 la consulta de filtrado de dni y el borrado en caso que se
	 *                 pueda realizar
	 */
	public static void bajaCliente(Scanner teclado, Connection conexion) {
		String dni;
		String consulta = "delete from clientes where dni = (?)";
		teclado.nextLine();
		System.out.println("Introduzca el dni del cliente a borrar");
		dni = teclado.nextLine();
		int cantidad = filtrarDni(teclado, conexion, dni);
		if (cantidad > 0) {
			try {
				PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
				sentenciaConsulta.setString(1, dni);

				sentenciaConsulta.executeUpdate();
				sentenciaConsulta.close();
			} catch (SQLException ex) {
				if (ex.getErrorCode() == 1451) {
					System.out.println("No se puede borrar a un cliente que tiene cuentas corrientes abiertas");
				} else {
					System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
				}

			}
		} else {
			System.out.println("El cliente con ese dni no existe");
		}
	}

	// este método modifica los datos de un cliente excepto el dni
	/**
	 * Método que modifica la información de un cliente de la base de datos
	 * filtrando por dni para que exista el cliente, en caso que se pueda solicitara
	 * nuevo nombre, telefono y direccion y lo modificará en la base de datos. En
	 * caso de no existir el dni se mostrará un mensaje.
	 * 
	 * @param teclado  un objeto de tipo Scanner para pedir los datos necesarios
	 * @param conexion un objeto de tipo Connection que da la conexion para realizar
	 *                 las operaciones oportunas con la base de datos
	 */
	public static void modificarCliente(Scanner teclado, Connection conexion) {
		String dni, nombre, telefono, direccion;
		String consulta = "update clientes set nombre = (?), telefono = (?), direccion = (?) where dni = (?)";
		teclado.nextLine();
		System.out.println("Introduzca el dni del cliente");
		dni = teclado.nextLine();
		int cantidad = filtrarDni(teclado, conexion, dni);
		if (cantidad > 0) {
			System.out.println("Introduzca el nuevo nombre del cliente");
			nombre = teclado.nextLine();
			System.out.println("Introduzca el nuevo telefono del cliente");
			telefono = teclado.nextLine();
			System.out.println("Introduzca la nueva direccion del cliente");
			direccion = teclado.nextLine();

			try {
				PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
				sentenciaConsulta.setString(1, nombre);
				sentenciaConsulta.setString(2, telefono);
				sentenciaConsulta.setString(3, direccion);
				sentenciaConsulta.setString(4, dni);

				sentenciaConsulta.executeUpdate();
				sentenciaConsulta.close();

			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
				System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");

			}
		} else {
			System.out.println("El cliente con ese dni no existe");
		}

	}

	// este método da de alta una cuenta pidiendo los datos necesarios y filtra si
	// el cliente existe o no antes de crearla
	/**
	 * Método que da de alta una cuenta corriente en la base de datos filtrando por
	 * dni para que exista el cliente, en caso que se pueda solicitara el saldo
	 * inicial de la cuenta. En ese caso no dejará borrarlo.
	 * 
	 * @param teclado  un objeto de tipo Scanner para pedir los datos necesarios
	 * @param conexion un objeto de tipo Connection que da la conexion para realizar
	 *                 las operaciones oportunas con la base de datos
	 */
	public static void altaCuenta(Scanner teclado, Connection conexion) {
		String dniCliente, situacion = "activa";
		double saldo;
		String consulta = "insert into cuentas (dni_cliente, situacion, saldo) values(?,?,?)";
		teclado.nextLine();
		System.out.println("Introduzca el dni del cliente");
		dniCliente = teclado.nextLine();
		int cantidad = filtrarDni(teclado, conexion, dniCliente);
		if (cantidad > 0) {
			System.out.println("Introduzca el saldo inicial de la cuenta");
			saldo = teclado.nextDouble();

			try {
				PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
				sentenciaConsulta.setString(1, dniCliente);
				sentenciaConsulta.setString(2, situacion);
				sentenciaConsulta.setDouble(3, saldo);

				sentenciaConsulta.executeUpdate();
				sentenciaConsulta.close();

			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
				System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");

			}
		} else {
			System.out.println("El cliente con ese dni no existe");
		}

	}

	// este método da de baja una cuenta corriente cambiando la situacion a baja
	/**
	 * Método que da de baja una cuenta corriente en la base de datos filtrando por
	 * dni para que exista el cliente, en caso que se pueda solicitara el numero de
	 * la cuenta. En caso de poder realizar la baja, no se borrarán la información
	 * de la base de datos, solo se modificara a estado de baja.
	 * 
	 * @param teclado  un objeto de tipo Scanner para pedir los datos necesarios
	 * @param conexion un objeto de tipo Connection que da la conexion para realizar
	 *                 las operaciones oportunas con la base de datos
	 */
	public static void bajaCuenta(Scanner teclado, Connection conexion) {
		String situacion = "baja";
		int numeroCuenta;
		String consulta = "update cuentas set situacion = (?) where numero_cuenta = (?)";
		int cantidad = filtrarDni(teclado, conexion);
		if (cantidad > 0) {
			System.out.println("Introduzca el numero de cuenta");
			numeroCuenta = teclado.nextInt();
			if (filtrarCuentaActiva(conexion, numeroCuenta) == 1) {
				try {

					PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
					sentenciaConsulta.setString(1, situacion);
					sentenciaConsulta.setInt(2, numeroCuenta);

					sentenciaConsulta.executeUpdate();
					sentenciaConsulta.close();

				} catch (SQLException ex) {
					System.out.println("SQLException: " + ex.getMessage());
					System.out.println("SQLState: " + ex.getSQLState());
					System.out.println("VendorError: " + ex.getErrorCode());
					System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");

				}
			} else {
				System.out.println("La cuenta que desea dar de baja ya se encuentra en situacion de baja");
			}
		} else {
			System.out.println("El cliente con ese dni no existe");
		}

	}

	// este método filtra por el dni si el cliente existe o no, devuele 1 si existe
	// o 0 si no existe
	private static int filtrarDni(Scanner teclado, Connection conexion) {
		int devolucion = 0;
		String dniCliente;
		teclado.nextLine();
		System.out.println("Introduzca el dni del cliente");
		dniCliente = teclado.nextLine();
		String consulta2 = "SELECT count(*) FROM clientes where dni = ?";
		try {
			PreparedStatement sentenciaConsulta2 = conexion.prepareStatement(consulta2);
			sentenciaConsulta2.setString(1, dniCliente);
			ResultSet resultado = sentenciaConsulta2.executeQuery();
			resultado.next();
			devolucion = resultado.getInt(1);
			sentenciaConsulta2.close();
			resultado.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");

		}

		return devolucion;

	}

	// metodo sobrecargado. este método filtra por el dni si el cliente existe o no,
	// devuele 1 si existe o 0 si no existe
	private static int filtrarDni(Scanner teclado, Connection conexion, String dni) {
		int devolucion = 0;
		String consulta2 = "SELECT count(*) FROM clientes where dni = ?";
		PreparedStatement sentenciaConsulta2;
		try {
			sentenciaConsulta2 = conexion.prepareStatement(consulta2);
			sentenciaConsulta2.setString(1, dni);
			ResultSet resultado = sentenciaConsulta2.executeQuery();
			resultado.next();
			devolucion = resultado.getInt(1);
			sentenciaConsulta2.close();
			resultado.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");

		}

		return devolucion;

	}

	// este metodo filta si la cuenta está en situacion activa o de baja. si esta
	// activa devuelve 1 si esta de baja devuelve 0
	private static int filtrarCuentaActiva(Connection conexion, int numCuenta) {
		int devolucion = 0;
		String situacion;
		try {
			String consulta2 = "select situacion from cuentas where numero_cuenta = (?)";
			PreparedStatement sentenciaConsulta2 = conexion.prepareStatement(consulta2);
			sentenciaConsulta2.setInt(1, numCuenta);
			ResultSet resultado = sentenciaConsulta2.executeQuery();
			resultado.next();
			situacion = resultado.getString("situacion");
			if (situacion.equals("activa")) {
				devolucion = 1;
			} else {
				devolucion = 0;
			}
			sentenciaConsulta2.close();
			resultado.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
		}
		return devolucion;

	}

	// este método simula el ingreso de dinero en una cuenta corriente, filta si la
	// cuenta está en situacion activa o de baja
	/**
	 * Método que realiza el ingreso de una cantidad de dinero en la cuenta
	 * corriente. Solicita el numero de cuenta y el saldo a ingresar para asi
	 * modificar la informacion correspondiente. Genera un moviento en la cuenta de
	 * tipo ingreso
	 * 
	 * @param teclado  un objeto de tipo Scanner para pedir los datos necesarios
	 * @param conexion un objeto de tipo Connection que da la conexion para realizar
	 *                 las operaciones oportunas con la base de datos
	 */
	public static void ingreso(Scanner teclado, Connection conexion) {
		int numeroCuenta;
		double ingreso, total;
		System.out.println("Introduzca el numero de cuenta");
		numeroCuenta = teclado.nextInt();
		if (filtrarCuentaActiva(conexion, numeroCuenta) == 1) {
			System.out.println("Introduzca el saldo a ingresar");
			ingreso = teclado.nextDouble();
			total = consultaSaldo(numeroCuenta, conexion) + ingreso;
			actualizarSaldo(conexion, total, numeroCuenta);
			generarMovimientos(numeroCuenta, ingreso, generarFecha(), "ingreso", 0, "ingreso de dinero", conexion);
		} else {
			System.out.println("La cuenta está en situación de baja");
		}

	}

	// este método simula la retirada de dinero en una cuenta corriente, filta si la
	// cuenta está en situacion activa o de baja
	/**
	 * Método que realiza la retirada de una cantidad de dinero en la cuenta
	 * corriente. Solicita el numero de cuenta y el saldo a retirar para asi
	 * modificar la informacion correspondiente. Genera un moviento en la cuenta de
	 * tipo retirada
	 * 
	 * @param teclado  un objeto de tipo Scanner para pedir los datos necesarios
	 * @param conexion un objeto de tipo Connection que da la conexion para realizar
	 *                 las operaciones oportunas con la base de datos
	 */
	public static void retirada(Scanner teclado, Connection conexion) {
		int numeroCuenta;
		double retirada, total;
		System.out.println("Introduzca el numero de cuenta");
		numeroCuenta = teclado.nextInt();
		if (filtrarCuentaActiva(conexion, numeroCuenta) == 1) {
			System.out.println("Introduzca el saldo a retirar");
			retirada = teclado.nextDouble();
			total = consultaSaldo(numeroCuenta, conexion) - retirada;
			if (total < 0) {
				System.out.println("ATENCION SALDO NEGATIVO EN LA CUENTA " + numeroCuenta
						+ ". La retirada se realizará pero tenga en cuenta que su cuenta queda en descuebierto");
			}
			actualizarSaldo(conexion, total, numeroCuenta);
			generarMovimientos(numeroCuenta, retirada, generarFecha(), "retirada", 0, "retirada de dinero", conexion);
		} else {
			System.out.println("La cuenta está en situación de baja");
		}

	}

	// este metodo realiza la consulta de saldo de una cuenta será llamado por otros
	// métodos los cuales realizarán las operaciones necesarias
	private static double consultaSaldo(int numeroCuenta, Connection conexion) {
		double devolucion = 0;
		try {
			String consulta2 = "select saldo from cuentas where numero_cuenta = (?)";
			PreparedStatement sentenciaConsulta2 = conexion.prepareStatement(consulta2);
			sentenciaConsulta2.setInt(1, numeroCuenta);
			ResultSet resultado = sentenciaConsulta2.executeQuery();
			resultado.next();
			devolucion = resultado.getDouble(1);
			sentenciaConsulta2.close();
			resultado.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
		}
		return devolucion;

	}

	// este método actualiza el saldo de una cuenta. será llamado por otros métodos
	// los cuales realizab las operaciones y llaman a este método para actualizar el
	// saldo
	private static void actualizarSaldo(Connection conexion, double total, int numeroCuenta) {
		String consulta = "update cuentas set saldo = (?) where numero_cuenta = (?)";
		try {
			PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
			sentenciaConsulta.setDouble(1, total);
			sentenciaConsulta.setInt(2, numeroCuenta);
			sentenciaConsulta.executeUpdate();
			sentenciaConsulta.close();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");

		}
	}

	private static Timestamp generarFecha() {
		LocalDateTime ahora = LocalDateTime.now();
		Timestamp fecha = Timestamp.valueOf(ahora);
		return fecha;
	}

	// este método simula la transferencia de dinero entre una cuenta corriente y
	// otra filta si las cuentas están en situacion activa o de baja.
	// genera un movimiento a cada cuenta
	/**
	 * Método que realiza la transferencia de una cantidad de dinero de una cuenta
	 * corriente a otra. Solicita el numero de cuenta que realiza la transferencia,
	 * el saldo a transferir y la cuenta destino para asi modificar la informacion
	 * correspondiente en ambas cuentas. Genera un moviento en la cuenta que realiza
	 * la transferencia de tipo transferencia enviada y un movimiento en la cuenta
	 * que lo recibe de tipo transferencia recibida.
	 * 
	 * @param teclado  un objeto de tipo Scanner para pedir los datos necesarios
	 * @param conexion un objeto de tipo Connection que da la conexion para realizar
	 *                 las operaciones oportunas con la base de datos
	 */
	public static void transferencia(Scanner teclado, Connection conexion) {
		int numeroCuentaManda, numeroCuentaRecibe;
		double cantidadTransefe, saldoCuentaManda, saldoCuentaRecibe, saldoCuentaMandaFinal = 0,
				saldoCuentaRecibeFinal = 0;
		String concepto;
		System.out.println("Introduzca la cuenta que realiza la transferencia");
		numeroCuentaManda = teclado.nextInt();
		if (filtrarCuentaActiva(conexion, numeroCuentaManda) == 1) {
			System.out.println("Introduzca la cuenta que recibe la transferencia");
			numeroCuentaRecibe = teclado.nextInt();
			if (filtrarCuentaActiva(conexion, numeroCuentaRecibe) == 1) {
				System.out.println("Introduzca la cantidad a enviar");
				cantidadTransefe = teclado.nextDouble();
				teclado.nextLine();
				System.out.println("Añada un concepto");
				concepto = teclado.nextLine();

				saldoCuentaManda = consultaSaldo(numeroCuentaManda, conexion);
				saldoCuentaRecibe = consultaSaldo(numeroCuentaRecibe, conexion);
				saldoCuentaMandaFinal = saldoCuentaManda - cantidadTransefe;
				if (saldoCuentaMandaFinal < 0) {
					System.out.println("ATENCION SALDO NEGATIVO EN LA CUENTA " + numeroCuentaManda
							+ ". La transferencia se realizará pero tenga en cuenta que su cuenta queda en descuebierto");
				}
				saldoCuentaRecibeFinal = saldoCuentaRecibe + cantidadTransefe;
				actualizarSaldo(conexion, saldoCuentaMandaFinal, numeroCuentaManda);
				actualizarSaldo(conexion, saldoCuentaRecibeFinal, numeroCuentaRecibe);
				generarMovimientos(numeroCuentaManda, cantidadTransefe, generarFecha(), "transferencia enviada",
						numeroCuentaRecibe, concepto, conexion);
				generarMovimientos(numeroCuentaRecibe, cantidadTransefe, generarFecha(), "transferencia recibida",
						numeroCuentaManda, concepto, conexion);
			} else {
				System.out.println("La situacion de la cuenta que recibe el envío es de baja");
			}
		} else {
			System.out.println("La situacion de la cuenta que realiza el envío es de baja");
		}

	}

	// este método genera movimientos en las cuentas de donde se ha ingresado,
	// retirado o transferido saldo. Será llamado por otros métodos
	private static void generarMovimientos(int numCuenta, double importe, Timestamp fecha, String tipo,
			int numCuentaRecibe, String concepto, Connection conexion) {
		String consulta = "insert into movimientos values (?,?,?,?,?,?)";
		try {
			PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
			sentenciaConsulta.setInt(1, numCuenta);
			sentenciaConsulta.setDouble(2, importe);
			sentenciaConsulta.setTimestamp(3, fecha);
			sentenciaConsulta.setString(4, tipo);
			sentenciaConsulta.setInt(5, numCuentaRecibe);
			sentenciaConsulta.setString(6, concepto);

			sentenciaConsulta.executeUpdate();
			sentenciaConsulta.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
		}

	}

	// este método solicita el dia mes y año de una fecha para devolver un objeto de
	// tipo Timestamp
	private static Timestamp pedirFecha(Scanner teclado, String orden) {
		Timestamp devolucion;
		int dia1, mes1, anho1;
		System.out.println("Introduzca el dia de la " + orden + " fecha");
		dia1 = teclado.nextInt();
		System.out.println("Introduzca el mes de la " + orden + " fecha");
		mes1 = teclado.nextInt();
		System.out.println("Introduzca el año de la " + orden + " fecha");
		anho1 = teclado.nextInt();
		LocalDateTime tiempo1 = LocalDateTime.of(anho1, mes1, dia1, 00, 00, 00, 00);
		devolucion = Timestamp.valueOf(tiempo1);
		return devolucion;

	}

	// este metodo mostrará los movimientos de una cuenta entre dos fecha
	// solicitadas al usuario
	/**
	 * Método que muestra la informacion de los movimientos de una cuenta. Solicita
	 * el numero de cuenta a la que consultar sus movimientos y dos fechas. Se
	 * listarán los movimientos de la cuenta corriente que haya entre las 2 fechas
	 * introducidas. *
	 * 
	 * @param teclado  un objeto de tipo Scanner para pedir los datos necesarios
	 * @param conexion un objeto de tipo Connection que da la conexion para realizar
	 *                 las operaciones oportunas con la base de datos
	 */
	public static void listarMovimientos(Scanner teclado, Connection conexion) {
		int numCuenta;
		String consulta = "select * from cuentas_corrientes.movimientos where numero_cuenta = (?) and fecha_hora between (?) and (?)";
		System.out.println("Introduzca el numero de cuenta a consultar");
		numCuenta = teclado.nextInt();

		Timestamp fecha1 = pedirFecha(teclado, "primera");
		Timestamp fecha2 = pedirFecha(teclado, "segunda");
		try {
			PreparedStatement sentenciaConsulta2 = conexion.prepareStatement(consulta);
			sentenciaConsulta2.setInt(1, numCuenta);
			sentenciaConsulta2.setTimestamp(2, fecha1);
			sentenciaConsulta2.setTimestamp(3, fecha2);

			ResultSet resultado = sentenciaConsulta2.executeQuery();
			while (resultado.next()) {
				System.out.println("numero_cuenta: " + resultado.getInt(1) + " importe: " + resultado.getDouble(2)
						+ " fecha_hora: " + resultado.getTimestamp(3) + " tipo: " + resultado.getString(4)
						+ " cuenta_transferida: " + resultado.getInt(5) + " concepto: " + resultado.getString(6));
			}
			sentenciaConsulta2.close();
			resultado.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
		}

	}

	// este metodo mostrará los ultimos 10 movimientos de una cuenta
	/**
	 * Método que muestra la informacion de los ultimos 10 movimientos de una
	 * cuenta. Solicita el numero de cuenta a la que consultar sus movimientos.
	 * 
	 * @param teclado  un objeto de tipo Scanner para pedir los datos necesarios
	 * @param conexion un objeto de tipo Connection que da la conexion para realizar
	 *                 las operaciones oportunas con la base de datos
	 */
	public static void listarUltimosDiez(Scanner teclado, Connection conexion) {
		int numCuenta;
		String consulta = "select * from cuentas_corrientes.movimientos where numero_cuenta = (?) order by fecha_hora desc limit 10";
		System.out.println("Introduzca el numero de cuenta a consultar los ultimos 10 movimientos");
		numCuenta = teclado.nextInt();
		PreparedStatement sentenciaConsulta2;
		try {
			sentenciaConsulta2 = conexion.prepareStatement(consulta);
			sentenciaConsulta2.setInt(1, numCuenta);
			ResultSet resultado = sentenciaConsulta2.executeQuery();
			while (resultado.next()) {
				System.out.println("numero_cuenta: " + resultado.getInt(1) + " importe: " + resultado.getDouble(2)
						+ " fecha_hora: " + resultado.getTimestamp(3) + " tipo: " + resultado.getString(4)
						+ " cuenta_transferida: " + resultado.getInt(5) + " concepto: " + resultado.getString(6));
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
		}

	}

}
