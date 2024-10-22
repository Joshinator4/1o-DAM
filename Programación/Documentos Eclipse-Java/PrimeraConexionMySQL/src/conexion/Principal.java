package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		
		
		Connection conexion;
		
		String nombre, altura;
		try {
			String url = "jdbc:mysql://localhost:3306/nba?useSSL=false";
			String user = "java";
			String pass = "1234";
			conexion = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexion funcionando");
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("select Nombre, Altura from nba.jugadores");
			while(resultado.next()) {
				nombre = resultado.getString("Nombre");
				altura = resultado.getString("Altura");
				System.out.println("Nombre del jugador: " + nombre + " , altura: " + altura);
			}
			resultado.close();
			sentencia.close();
			conexion.close();
			System.out.println("Conexion cerrada");
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

}
