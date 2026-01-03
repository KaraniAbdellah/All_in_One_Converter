package UI;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class Header {
    public Scene createHeaderScene() {
        // Logo + Github Link and Linkedin With Icons + User Logo
        Image img_logo = new Image(getClass().getResourceAsStream("../images/infinity-symbol-clip-art-free-png.png"));

        GridPane grid_pane = new GridPane();

        Scene headerScene = new Scene(grid_pane);

        return headerScene;
    }
}
