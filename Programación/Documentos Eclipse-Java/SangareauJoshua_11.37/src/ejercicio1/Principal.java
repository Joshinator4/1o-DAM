/*Autor: Joshua Sangareau Quesada
Fecha: 17 may 2024 
Descripcion: clase Principal
*/
package ejercicio1;


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
		conexion = realizarConexion(conexion);
		do {
			System.out.println("Elija un opcion:\n1 - Mostrar Películas.\n2 - Borrar Plataforma"
					+ "\n3 - Modificar Plataforma.\n4 - Mostrar Películas por plataformas\n0 - Salir del programa");
			opcionDeseada = teclado.nextInt();
			switch (opcionDeseada) {
			case (1): {
				consultaPeliculas(conexion);
				break;

			}
			case (2): {
				consultarPlataformas(conexion);
				borrarPlataforma(conexion, teclado);
				break;

			}
			case (3): {
				modificarPlataforma(conexion, teclado);
				break;

			}
			case (4): {
				mostrarPeliculasPorPlataforma(conexion);
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
			String url = "jdbc:mysql://localhost:3306/gestion_peliculas";
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
	
	//este metodo realiza la consulta los datos de la tabla de peliculas en la base de datos 
	public static void consultaPeliculas(Connection conexion) {
		
		String consulta = "select * from peliculas";
		
		try {
			Statement sentenciaConsulta = conexion.createStatement();
			ResultSet resultado = sentenciaConsulta.executeQuery(consulta);
			System.out.println("-------- Listado de Peliculas -----------------\n"
					+ "| Código - titulo - Sinopsis - Fecha de estreno |\n"
					+ " -----------------------------------------------");
			while (resultado.next()) {
				System.out.println(resultado.getInt(1) + " - " + resultado.getString(2) + " - " + resultado.getString(3) + " - " + resultado.getDate(4) + ".");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	//este metodo consulta el codigo y el nombre de la tabla plataformas de la base de datos 
	public static void consultarPlataformas(Connection conexion) {
		String consulta = "select codigo, nombre from plataformas";
		
		try {
			Statement sentenciaConsulta = conexion.createStatement();
			ResultSet resultado = sentenciaConsulta.executeQuery(consulta);
			System.out.println("-------- Listado de Plataformas ---------------\n"
					+ "| Código - Nombre                               |\n"
					+ " -----------------------------------------------");
			while (resultado.next()) {
				System.out.println(resultado.getInt(1) + " - " + resultado.getString(2) + ".");
			}
			resultado.close();
			sentenciaConsulta.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	//metodo sobrecargado privado este método sera llamado cuando sea necesario consultar si existe la plataforma con codigo que se pasa por parámetro, de la tabla plataformas en la base de datos
	private static int consultarPlataformas(Connection conexion, int codigoPlataforma) {
		String consulta = "select count(*) from plataformas where codigo = ?";
		int devolucion = 0;
		try {
			PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
			sentenciaConsulta.setInt(1, codigoPlataforma);
			ResultSet resultado = sentenciaConsulta.executeQuery();
			resultado.next();
			devolucion = resultado.getInt(1);
			
			sentenciaConsulta.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return devolucion;
	}
	//este método comprueba borra una plataforma de la tabla plataformas filtrando si existe la plataforma y si tiene peliculas asocias a ella. En caso de no existir la plataforma o tener peliculas
	//referenciando a la plataforma, no se borrará dicha plataforma
	public static void borrarPlataforma(Connection conexion, Scanner teclado) {
		String consulta = "delete from plataformas where codigo = ?";
		int codigo;
		System.out.println("Introduzca el codigo de la plataforma a borrar");
		codigo = teclado.nextInt();
		try {
			if(consultarPlataformas(conexion, codigo) > 0) {
				PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
				sentenciaConsulta.setInt(1, codigo);
				sentenciaConsulta.executeUpdate();
				sentenciaConsulta.close();
				System.out.println("Borrado de plataforma correcto");
			}else {
				System.out.println("La plataforma no existe");
			}
			
		} catch (SQLException ex) {
			if(ex.getErrorCode() == 1451) {
				System.out.println("La plataforma tiene peliculas referenciando a la plataforma, no se borrará");
			}else {
			ex.printStackTrace();
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
		
	}
	
	//este método modifica el nombre de una plataforma de la tabla plataformas, filtrando primero si existe dicha plataforma.
	public static void modificarPlataforma(Connection conexion, Scanner teclado) {
		String consulta = "update plataformas set nombre = ? where codigo = ?";
		int codigo;
		String nombre;
		consultarPlataformas(conexion);
		System.out.println("Introduzca el codigo de la plataforma a modificar");
		codigo = teclado.nextInt();
		try {
			if(consultarPlataformas(conexion, codigo) > 0) {
				teclado.nextLine();
				System.out.println("Introduzca el nuevo nombre de la plataforma");
				nombre = teclado.nextLine();
				PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
				sentenciaConsulta.setString(1, nombre);
				sentenciaConsulta.setInt(2, codigo);
				sentenciaConsulta.executeUpdate();
				sentenciaConsulta.close();
				System.out.println("se ha modificado el nombre de la plataforma correctamente");
			}else {
				System.out.println("La plataforma no existe");
			}
			
		} catch (SQLException ex) {
			if(ex.getErrorCode() == 1451) {
				System.out.println("La plataforma tiene peliculas referenciando a la plataforma, no se borrará");
			}else {
			ex.printStackTrace();
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
	}
	
	//este método mostrará una lista de los titulos de las peliculas que hay en la tabla peliculas, que están asociadas a cada una de las plataformas existentes en la tabla plataformas
	public static void mostrarPeliculasPorPlataforma(Connection conexion) {
		String consulta = "select nombre, codigo from plataformas";
		String consulta2 = "select titulo from peliculas p inner join disponible_en d on p.codigo = d.codPelicula where d.codPlataforma = ?";
		String nombrePlataforma, nombrePelicula;
		int codigoPlataforma;
		try {
			System.out.println("--------------------------------------------------------------------------\n"
					+ "| PELICULAS POR PLATAFORMAS                                                |\n"
					+ " -------------------------------------------------------------------------");
				
			Statement sentenciaConsulta = conexion.createStatement();
			ResultSet resultado = sentenciaConsulta.executeQuery(consulta);
				
			while(resultado.next()) {
				nombrePlataforma = resultado.getString(1);
				codigoPlataforma = resultado.getInt(2);
				System.out.println("Plataforma: " + nombrePlataforma + ":");
				
				PreparedStatement sentenciaConsulta2 = conexion.prepareStatement(consulta2);
				sentenciaConsulta2.setInt(1, codigoPlataforma);
				ResultSet resultado2 = sentenciaConsulta2.executeQuery();
				while(resultado2.next()) {
					nombrePelicula = resultado2.getString(1);
					System.out.println("  " + nombrePelicula);
				}
				System.out.println("-----------------------------------------------------------------------");
				sentenciaConsulta2.close();
				resultado2.close();
			}
			
			sentenciaConsulta.close();
			resultado.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			
		}
	}

}
