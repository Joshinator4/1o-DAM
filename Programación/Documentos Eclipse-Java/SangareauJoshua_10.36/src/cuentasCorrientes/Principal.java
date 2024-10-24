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
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int opcionDeseada;
		Connection conexion = null;
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
		
		do {
			System.out.println("Elija un opcion:\n1.-Alta cliente.\n2.-Baja de un cliente(solo si no tiene cuentas asociadas)"
					+ "\n3.-Modificar datos de un cliente.\n4.-Alta de cuenta"
					+ "\n5.-Para cada uno de los ciclistas, mostrar las rutas recorridas ordenadas por kms. y y el total de kilómetros recorridos por el ciclista.\n"
					+ "6.-Añadir ruta a distintos ciclistas\n0.-Salir del programa");
			opcionDeseada = teclado.nextInt();
			switch (opcionDeseada) {
				case(1):{
					
					altaCliente(teclado, conexion);
					break;
					
				}case(2):{
					
					bajaCliente(teclado, conexion);
					break;
					
				}case(3):{
					
					modificarCliente(teclado, conexion);
					break;
					
				}case(4):{
					altaCuenta(teclado, conexion);
					break;
					
				}case(5):{
					
					break;
					
				}case(6):{
					
					break;
					
				}case(0):{
					System.out.println("Se va a proceder a cerrar el programa, ¡Hasta Pronto!");
					try {
						conexion.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}default:{
					System.out.println("Se ha introducido una opcion incorrecta, introduzca un numero de cualquiera de las funciones");
				}

			}
				
		}while(opcionDeseada != 0);

	
	}
	
	public static void altaCliente(Scanner teclado, Connection conexion) {
		String dni, nombre, telefono, direccion;
		String consulta = "insert into clientes (dni, nombre, telefono, direccion) values(?,?,?,?)";
		teclado.nextLine();
		System.out.println("Introduzca el dni del cliente");
		dni = teclado.nextLine();
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
	
	public static void bajaCliente(Scanner teclado, Connection conexion) {
		String dni;
		String consulta = "delete from clientes where dni = (?)";
		teclado.nextLine();
		System.out.println("Introduzca el dni del cliente a borrar");
		dni = teclado.nextLine();		
		
		
		try {
			PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
            sentenciaConsulta.setString(1, dni);
     
            sentenciaConsulta.executeUpdate();
            sentenciaConsulta.close();
        } catch (SQLException ex) {
        	if(ex.getErrorCode() == 1451) {
        		System.out.println("No se puede borrar a un cliente que tiene cuentas corrientes abiertas");
        	}else {
        		System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
        	}
            
        }
	}
	
	public static void modificarCliente(Scanner teclado, Connection conexion) {
		String dni, nombre, telefono, direccion;
		String consulta = "update clientes set nombre = (?), telefono = (?), direccion = (?) where dni = (?)";
		String consulta2 = "SELECT count(*) FROM clientes where dni = ?";
		teclado.nextLine();
		System.out.println("Introduzca el dni del cliente a modificar");
		dni = teclado.nextLine();
		PreparedStatement sentenciaConsulta2;
		try {
			sentenciaConsulta2 = conexion.prepareStatement(consulta2);
			sentenciaConsulta2.setString(1, dni);
			ResultSet resultado = sentenciaConsulta2.executeQuery();
			resultado.next();
			int cantidad = resultado.getInt(1);
            sentenciaConsulta2.close();
			if(cantidad > 0) {
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
			}else {
				System.out.println("El cliente con ese dni no existe");
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
			
	}
	
	public static void altaCuenta(Scanner teclado, Connection conexion) {
		String dniCliente, situacion = "activa";
		double saldo;
		String consulta = "insert into cuentas (dni_cliente, situacion, saldo) values(?,?,?)";
		teclado.nextLine();
		System.out.println("Introduzca el dni del cliente");
		dniCliente = teclado.nextLine();
		System.out.println("llega");
		String consulta2 = "SELECT count(*) FROM clientes where dni = ?";
		teclado.nextLine();
		PreparedStatement sentenciaConsulta2;
		try {
			
			sentenciaConsulta2 = conexion.prepareStatement(consulta2);
			sentenciaConsulta2.setString(1, dniCliente);
			ResultSet resultado = sentenciaConsulta2.executeQuery();
			resultado.next();
			int cantidad = resultado.getInt(1);
            sentenciaConsulta2.close();
			if(cantidad > 0) {
				System.out.println("Introduzca el saldo de la cuenta");
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
			}else {
				System.out.println("El cliente con ese dni no existe");
			}
        } catch (SQLException ex) {
        	System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
            System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
        }
		
	}
	
	
}
