package controlador;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Operacion;

	public class ControladorCalculadora {
		
		Operacion operacion1;
		
		@FXML
		private TextField numeros;
		
		@FXML
		private Button btnSumar;
		@FXML
		private Button btnRestar;
		@FXML
		private Button btnMultiplicar;
		@FXML
		private Button btnDividir;
		@FXML
		private Button btnIgual;
		@FXML
		private Button btn1;
		@FXML
		private Button btn2;
		@FXML
		private Button btn3;
		@FXML
		private Button btn4;
		@FXML
		private Button btn5;
		@FXML
		private Button btn6;
		@FXML
		private Button btn7;
		@FXML
		private Button btn8;
		@FXML
		private Button btn9;
		@FXML
		private Button btn0;
		@FXML
		private Button btnComa;
		@FXML
		private Button btnC;
		@FXML
		private Button btnCE;
		
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			
		}
		
		@FXML
		private void botonComa(ActionEvent event) {
			this.numeros.setText(numeros.getText() + ".");
		}
		
		@FXML
		private void boton1(ActionEvent event) {
			try {
				this.numeros.setText(numeros.getText() + "1");
		
			}catch(NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Formato Incorrecto");
				alert.showAndWait();
			}
			
		}
		
		@FXML
		private void boton2(ActionEvent event) {
			try {
				this.numeros.setText(numeros.getText() + "2");
				
			}catch(NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Formato Incorrecto");
				alert.showAndWait();
			}
			
		}
		
		@FXML
		private void boton3(ActionEvent event) {
			try {
				this.numeros.setText(numeros.getText() + "3");
				
			}catch(NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Formato Incorrecto");
				alert.showAndWait();
			}
			
		}
		
		@FXML
		private void boton4(ActionEvent event) {
			try {
				this.numeros.setText(numeros.getText() + "4");
				
			}catch(NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Formato Incorrecto");
				alert.showAndWait();
			}
			
		}
		
		@FXML
		private void boton5(ActionEvent event) {
			try {
				this.numeros.setText(numeros.getText() + "5");
				
			}catch(NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Formato Incorrecto");
				alert.showAndWait();
			}
			
		}
		
		@FXML
		private void boton6(ActionEvent event) {
			try {
				this.numeros.setText(numeros.getText() + "6");
				
			}catch(NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Formato Incorrecto");
				alert.showAndWait();
			}
			
		}
		
		@FXML
		private void boton7(ActionEvent event) {
			try {
				this.numeros.setText(numeros.getText() + "7");
				
			}catch(NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Formato Incorrecto");
				alert.showAndWait();
			}
			
		}
		
		@FXML
		private void boton8(ActionEvent event) {
			try {
				this.numeros.setText(numeros.getText() + "8");
				
			}catch(NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Formato Incorrecto");
				alert.showAndWait();
			}
			
		}
		
		@FXML
		private void boton9(ActionEvent event) {
			try {
				this.numeros.setText(numeros.getText() + "9");
				
			}catch(NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Formato Incorrecto");
				alert.showAndWait();
			}
			
		}
		
		@FXML
		private void boton0(ActionEvent event) {
			try {
				this.numeros.setText(numeros.getText() + "0");
				
			}catch(NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Formato Incorrecto");
				alert.showAndWait();
			}
			
		}
		
		private void operacion(int operar) {
			double numero1 = Double.parseDouble(this.numeros.getText());
			this.numeros.setText("");
			this.operacion1 = new Operacion(numero1, operar);
		}
		
		@FXML
		private void sumar(ActionEvent event) {
			operacion(1);
		}
		
		@FXML
		private void restar(ActionEvent event) {
			operacion(2);
		}
		
		@FXML
		private void multiplicar(ActionEvent event) {
			operacion(3);
		}
		
		@FXML
		private void dividir(ActionEvent event) {
			operacion(4);
		}
		
		@FXML
		private void igual(ActionEvent event) {
			
			if(this.numeros.getText().isEmpty()) {
				
			}else {
				double numero2 = Double.parseDouble(this.numeros.getText());
				this.operacion1.setB(numero2);
				if(this.operacion1.getOperar() == 1) {
					this.numeros.setText(operacion1.sumar() + "");
				}else if(this.operacion1.getOperar() == 2) {
					this.numeros.setText(operacion1.restar() + "");
				}else if(this.operacion1.getOperar() == 3) {
					this.numeros.setText(operacion1.multiplicar() + "");
				}else if(this.operacion1.getOperar() == 4){
					this.numeros.setText(operacion1.dividir() + "");
				}
			}
			
			
		}
		
		@FXML
		private void botonC(ActionEvent event) {
			this.operacion1.setA(0);
			this.operacion1.setB(0);
			this.operacion1.setOperar(0);
			this.numeros.setText("");
		}
		
		@FXML
		private void botonCE(ActionEvent event) {
			this.numeros.setText("");
		}
		
		
	
}
