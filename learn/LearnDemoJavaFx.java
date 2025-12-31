package UI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LearnDemoJavaFx {
    public void createMainStage(Stage primaryStage) {
        // Control is Button
        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");
        // Button btn1 = new Button();
        // Layout [Horizantal and There is Vertical, ...]
        // HBox root = new HBox();
        GridPane root = new GridPane();
        // add Control/Button to Layout
        root.add(btn1, 0, 0); // row, column
        root.add(btn2, 1, 0);
        root.add(btn3, 2, 1);
        root.setGridLinesVisible(true);
        root.setVgap(5);
        root.setHgap(5);
        root.setMaxHeight(300);
        root.setMaxWidth(300);
        // root.getChildren().add(btn1); with HBox
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
}
