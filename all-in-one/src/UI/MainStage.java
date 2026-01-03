package UI;

import java.rmi.server.ServerNotActiveException;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainStage {

    public void createMainStage(Stage primaryStage) {
        Header header = new Header();
        Converter converter = new Converter();
        Info info = new Info();
        Footer footer = new Footer();

        // Get layouts for each part
        GridPane headerLayout = header.createHeader();
        GridPane converterLayout = converter.createConverterScene();
        GridPane infoLayout = info.createInfoScene();
        GridPane footerLayout = footer.createFooter();

        // Put all Layouts in Vertical Layout
        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(headerLayout, converterLayout, infoLayout, footerLayout);

        // Create ONE scene with main layout
        Scene mainScene = new Scene(mainLayout, 600, 400); // bigger window

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("All In One Convertion");
        primaryStage.show();
    }

}
