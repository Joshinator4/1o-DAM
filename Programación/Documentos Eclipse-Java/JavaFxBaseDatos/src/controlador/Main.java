package controlador;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import controlador.Controlador;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			primaryStage.setTitle("Gestion de clientes");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/vista/Clientes.fxml"));
			Pane ventana = (Pane) loader.load();
			
			//Show the scene containing the root layout
			Scene scene = new Scene(ventana);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void stop() {
	    Controlador.cerrarConexion();
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}

}
