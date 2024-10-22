package sentenciasParametrizadas;

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
		
		Connection conexion;
		
		String titulo;
		int idAutor, idLibro;
		try {
			String url = "jdbc:mysql://localhost:3306/biblioteca_ud5?useSSL=false";
			String user = "java";
			String pass = "1234";
			conexion = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexion funcionando");
			/*
			System.out.println();
			System.out.println("Introduzca el titulo del libro");
			titulo = teclado.nextLine();
			System.out.println();
			System.out.println("Introduzca el id del autor");
			idAutor = teclado.nextInt();
			creacionLibro(conexion, titulo, idAutor);
			
			System.out.println("Introduzca el nuevo titulo a cambiar en el libro");
			titulo = teclado.nextLine();
			System.out.println("Introduzca el id del libro a cambiar");
			idLibro = teclado.nextInt();
			actualizarLibro(conexion, titulo, idLibro);
			*/
			System.out.println("Introduzca el id del libro a borrar");
			idLibro = teclado.nextInt();
			borrarLibro(conexion, idLibro);
			conexion.close();
			System.out.println("Conexion cerrada");
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public static void creacionLibro(Connection conexion, String titulo, int idAutor) {
		
		String consulta = "insert into libros (titulo, id_autor) values(?,?)";
		long id =-1;
		try {
			PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            sentenciaConsulta.setString(1, titulo);
            sentenciaConsulta.setInt(2, idAutor);

            int registrosAfectados = sentenciaConsulta.executeUpdate();
            if (registrosAfectados > 0) {
            	 ResultSet idGenerado = sentenciaConsulta.getGeneratedKeys();
                 if (idGenerado.next()){
                     id=idGenerado.getLong(1);
                     System.out.printf("Producto insertado con ID=%d\n",id);                        
                 }
                System.out.println("Producto insertado correctamente.");
            } else {
                System.out.println("El producto no ha podido ser insertado.");
            }
            sentenciaConsulta.close();
        } catch (SQLException ex) {
            System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
        }
		
	}
	
public static void actualizarLibro(Connection conexion, String titulo, int idLibro) {
		
		String consulta = "update libros set titulo = (?) where id_libro = (?)";
		try {
			PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
            sentenciaConsulta.setString(1, titulo);
            sentenciaConsulta.setInt(2, idLibro);

            int registrosAfectados = sentenciaConsulta.executeUpdate();
            if (registrosAfectados > 0) {
                System.out.println("Producto actualizado correctamente.");
            } else {
                System.out.println("El producto no ha podido ser insertado.");
            }
            sentenciaConsulta.close();
        } catch (SQLException ex) {
            System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
        }
		
	}
	public static void borrarLibro(Connection conexion, int idLibro) {
		
		String consulta = "delete from libros where id_libro = (?)";
		try {
			PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
	        sentenciaConsulta.setInt(1, idLibro);
	
	        int registrosAfectados = sentenciaConsulta.executeUpdate();
	        if (registrosAfectados > 0) {
	            System.out.println("Producto borrado correctamente.");
	        } else {
	            System.out.println("El producto no ha podido ser insertado.");
	        }
	        sentenciaConsulta.close();
	    } catch (SQLException ex) {
	        System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
	    }
	
	}

}



