package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Suma;
import modelo.Resta;
import modelo.Division;
import modelo.Multiplicacion;

public class OperacionesControlador implements Initializable {

	@FXML
	private Button btnSumar;
	@FXML
	private Button btnRestar;
	@FXML
	private Button btnMultiplicar;
	@FXML
	private Button btnDividir;
	
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
			
			Suma sumaNumeros = new Suma(op1, op2);
			double resultado = sumaNumeros.suma();
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
	private void restar(ActionEvent event) {
		try {
			int op1 = Integer.parseInt(this.txtOp1.getText());
			int op2 = Integer.parseInt(this.txtOp2.getText());
			
			Resta restaNumeros = new Resta(op1, op2);
			double resultado = restaNumeros.restar();
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
	private void multiplicar(ActionEvent event) {
		try {
			int op1 = Integer.parseInt(this.txtOp1.getText());
			int op2 = Integer.parseInt(this.txtOp2.getText());
			
			Multiplicacion multiNumeros = new Multiplicacion(op1, op2);
			double resultado = multiNumeros.multiplicar();
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
	private void dividir(ActionEvent event) {
		try {
			int op1 = Integer.parseInt(this.txtOp1.getText());
			int op2 = Integer.parseInt(this.txtOp2.getText());
			
			Division dividirNumeros = new Division(op1, op2);
			double resultado = dividirNumeros.dividir();
			this.txtResultado.setText(resultado + "");
			
		}catch(NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Formato Incorrecto");
			alert.showAndWait();
		}
	}
	
	
}
