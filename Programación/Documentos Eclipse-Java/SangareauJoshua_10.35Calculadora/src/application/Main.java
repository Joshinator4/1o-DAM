package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import controlador.ControladorCalculadora;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/vista/calculadora.fxml"));
			Pane ventana = (Pane) loader.load();
			Scene scene = new Scene(ventana);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
