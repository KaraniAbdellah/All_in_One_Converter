import UI.MainStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    // Controls + Layout + Scene + Stage
    public void start(Stage primaryStage) {
        MainStage mainStage = new MainStage();
        mainStage.createMainStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}