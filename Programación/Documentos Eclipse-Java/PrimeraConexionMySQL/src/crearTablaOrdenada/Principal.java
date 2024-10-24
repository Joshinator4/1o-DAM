package crearTablaOrdenada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		Connection conexion;
		ArrayList<Libro> listaLibros = new ArrayList<>();
		String titulo;
		int idAutor, idLibro;
		try {
			String url = "jdbc:mysql://localhost:3306/biblioteca_ud5?useSSL=false";
			String user = "java";
			String pass = "1234";
			conexion = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexion funcionando");
	
			listaLibros.addAll(lectorLibros(conexion));
			
			Collections.sort(listaLibros);
			
			insertarEnTabla(conexion, listaLibros);
			
			conexion.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public static List<Libro> lectorLibros(Connection conexion) {

		List<Libro> lista = new ArrayList<Libro>();
		String consulta = "select * from libros;";

		int id_libro, id_autor;
		String titulo;
		
		try {
			Statement sentenciaConsulta = conexion.createStatement();
			ResultSet conjuntoResutlado = sentenciaConsulta.executeQuery(consulta);
			
			while(conjuntoResutlado.next()) {
				id_libro = conjuntoResutlado.getInt("id_libro");
				titulo = conjuntoResutlado.getString("titulo");
				id_autor = conjuntoResutlado.getInt("id_autor");
				Libro libro = new Libro (id_libro, titulo, id_autor);
				lista.add(libro);
			}
			sentenciaConsulta.close();
			conjuntoResutlado.close();
			
		} catch (SQLException ex) {
			System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
		}
		
		return lista;
	}
	
	public static void insertarEnTabla(Connection conexion, ArrayList<Libro> lista) {
		String consulta = "insert into libros_ordenados values(?,?,?)";
		
		try {
			for(Libro i: lista) {
			
				PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
				sentenciaConsulta.setInt(1, i.getId_libro());
				sentenciaConsulta.setString(2, i.getTitulo());
	            sentenciaConsulta.setInt(3, i.getId_autor());
	
	            int registrosAfectados = sentenciaConsulta.executeUpdate();
	            if (registrosAfectados > 0) { 
	                System.out.println("Producto insertado correctamente.");
	            } else {
	                System.out.println("El producto no ha podido ser insertado.");
	            }
	            sentenciaConsulta.close();
	       
			}
		} catch (SQLException ex) {
	        System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
	    }
	}

}
