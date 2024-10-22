package controlador;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controlador implements Initializable {

	@FXML
	private Button btnSiguiente;
	@FXML
	private Button btnUltimo;
	@FXML
	private Button btnAnterior;
	@FXML
	private Button btnPrimero;
	@FXML
	private Button btnAceptar;
	@FXML
	private Button btnCancelar;
	@FXML
	private Button btnNuevo;
	@FXML
	private Button btnEditar;
	@FXML
	private Button btnBorrar;
	
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtDireccion;
	
	static Connection conexion = conectar();
	ResultSet resultado;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		resultado();
		try {
			resultado.first();
			txtId.setText(resultado.getInt("id") + "");
			txtNombre.setText(resultado.getString("nombre"));
			txtDireccion.setText(resultado.getString("direccion"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void cerrarConexion() {
		try {
			conexion.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Connection conectar() {
		Connection conexion = null;
		try {
			String url = "jdbc:mysql://localhost:3306/tienda";
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
	
	public void resultado() {
		String consulta = "select * from clientes;";
		try {
			Statement sentenciaConsulta = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			resultado = sentenciaConsulta.executeQuery(consulta);
			} catch (SQLException ex1) {
				System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
				ex1.printStackTrace();
			}
	
	}
	
	@FXML
	private void primero(ActionEvent event) {
		try {
			resultado.first();
			txtId.setText(resultado.getInt("id") + "");
			txtNombre.setText(resultado.getString("nombre"));
			txtDireccion.setText(resultado.getString("direccion"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void anterior(ActionEvent event) {
		try {
			
			if(!resultado.isFirst()) {
				resultado.previous();
				txtId.setText(resultado.getInt("id") + "");
				txtNombre.setText(resultado.getString("nombre"));
				txtDireccion.setText(resultado.getString("direccion"));
			}else {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@FXML
	private void siguiente(ActionEvent event) {
		try {
			if(!resultado.isLast()) {
				resultado.next();
				txtId.setText(resultado.getInt("id") + "");
				txtNombre.setText(resultado.getString("nombre"));
				txtDireccion.setText(resultado.getString("direccion"));
			}else {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@FXML
	private void ultimo(ActionEvent event) {
		try {
			resultado.last();
			txtId.setText(resultado.getInt("id") + "");
			txtNombre.setText(resultado.getString("nombre"));
			txtDireccion.setText(resultado.getString("direccion"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void nuevo(ActionEvent event) {
		try {
			resultado.moveToInsertRow();
			resultado.updateInt("id", Integer.parseInt(txtId.getText()));
			resultado.updateString("nombre", txtNombre.getText());
			resultado.updateString("direccion", txtDireccion.getText()); 
			resultado.insertRow();
			resultado.moveToCurrentRow();
			txtId.setText(resultado.getInt("id") + "");
			txtNombre.setText(resultado.getString("nombre"));
			txtDireccion.setText(resultado.getString("direccion"));
            
        } catch (SQLException ex) {
            System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
        }
	}
	
	@FXML
	private void editar(ActionEvent event) {
		try {
			resultado.updateInt("id", Integer.parseInt(txtId.getText()));
			resultado.updateString("nombre", txtNombre.getText());
			resultado.updateString("direccion", txtDireccion.getText()); 
			resultado.updateRow();
  
        } catch (SQLException ex) {
            System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
        }
		
	}
	@FXML
	private void borrar(ActionEvent event) {
		try {
			resultado.deleteRow();			
			txtId.setText(resultado.getInt("id") + "");
			txtNombre.setText(resultado.getString("nombre"));
			txtDireccion.setText(resultado.getString("direccion"));
  
        } catch (SQLException ex) {
            System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
        }
		
	}
	@FXML
	private void aceptar(ActionEvent event) {
		/*try {
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}*/
	}
	@FXML
	private void cancelar(ActionEvent event) {
		txtId.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
	}
	
}
