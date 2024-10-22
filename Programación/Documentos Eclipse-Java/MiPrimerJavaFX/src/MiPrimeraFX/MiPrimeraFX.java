package MiPrimeraFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MiPrimeraFX extends Application{

	public static void main(String[] args) {
		
		launch(args);

	}
	
	
	public void start(Stage stage) throws Exception {
        Label label = new Label("Hola JavaFX") ;
        // Crear un panel y añadirlo a la escena
        Scene scene = new Scene(new StackPane(label), 640, 480) ;
        // Añadir la escena al escenario
        stage.setScene(scene);
        // Mostrar el escenario
        stage.show(); 
    }  

}
