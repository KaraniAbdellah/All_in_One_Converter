package UI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainStage {
    public void createMainStage(Stage primaryStage) {
        Label label = new Label("Hello World, JavaFX !");
        Scene scene = new Scene(label, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("All In One");
        primaryStage.setWidth(200);
        primaryStage.setHeight(200);

        // Header Scene
        Header header = new Header();
        // Converter Scene

        // Info Scene

        // Footer Scene
        primaryStage.show();
    }
}
