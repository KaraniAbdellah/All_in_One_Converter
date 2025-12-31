import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class App extends Application {
    @Override
    // Controls + Layout + Scene + Stage
    public void start(Stage primaryStage) {
        // Control is Button
        Button btn1 = new Button("Click here");
        // Layout [Horizantal and There is Vertical]
        HBox root = new HBox();
        // add Control/Button to Layout
        root.getChildren().add(btn1);
        // add layout to scene
        Scene scene1 = new Scene(root);
        // add scene to stage
        primaryStage.setScene(scene1);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        // primaryStage.setFullScreen(true);
        primaryStage.setTitle("JAVAFX APP");
        primaryStage.show();
        // primaryStage.close(); // dispear app
    }

    public static void main(String[] args) {
        launch(args);
    }
}