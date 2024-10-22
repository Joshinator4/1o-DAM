package saludando;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Aplicación que escribe hola mundo por consola, cuando se pulsa un botón.
 * 
 * Hoja de estilos de: https://pixelduke.wordpress.com/2012/10/23/jmetro-windows-8-controls-on-java/
 * @author JJBH
 */
public class Saludando extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Crear un Nodo de clase Button
        Button btn = new Button();
        
        // Establecer el texto del botón
        btn.setText("Di otra vez Hola mundo'");
        
        /* Utilizando la notación lambda, establcer la acción del programa 
           cuando se pulse el botón: escribir por consola un mensaje */
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("¡Hola mundo!");
        });
        
        // Sin notación lambda sería así.
        /*btn.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println("¡Hola mundo!");
            }
        });*/
        
        // Nodo raiz, de clase StackPane
        StackPane root = new StackPane();
        // Añadimos el botón como hijo de raiz
        root.getChildren().add(btn);
        // Crear la escena para que contenga la raíz
        Scene scene = new Scene(root, 300, 250);
        
        // Cargar una hoja de estilo específica
        scene.getStylesheets().add("recursos/css/JMetroLightTheme.css");
        
        
        // Establecer el título de la ventana
        primaryStage.setTitle("Hola Mundo con JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
