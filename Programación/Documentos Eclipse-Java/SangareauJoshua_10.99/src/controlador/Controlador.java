package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controlador implements Initializable {

	@FXML
	private Button btnSumar;
	@FXML
	private Button btnImport1;
	@FXML
	private Button btnImport2;
	
	@FXML
	private TextField txtOp1;
	@FXML
	private TextField txtOp2;
	@FXML
	private TextField txtResultado;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	@FXML
	private void sumar(ActionEvent event) {
		try {
			int op1 = Integer.parseInt(this.txtOp1.getText());
			int op2 = Integer.parseInt(this.txtOp2.getText());
			
			
			int resultado = op1 + op2;
			if (resultado >= 0) {
                this.txtResultado.setStyle("-fx-text-fill: green;");
            } else {
                this.txtResultado.setStyle("-fx-text-fill: red;");
            }
			this.txtResultado.setText(resultado + "");
			
		}catch(NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Formato Incorrecto");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void importar1(ActionEvent event) {
		String numero1;		
		numero1 = importar("operando1.txt");
		this.txtOp1.setText(numero1);
			
	
	}
	@FXML
	private void importar2(ActionEvent event) {
		String numero2;		
		numero2 = importar("operando2.txt");
		this.txtOp2.setText(numero2);
			
	
	}

	private String importar(String nombreArchivo) {
		String devolucion = "";
		String temporal;
		File archivo = new File(nombreArchivo);
		try {
			Scanner lector = new Scanner (archivo);
			devolucion = lector.next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return devolucion;
		
	}
	
	
	
	
}
