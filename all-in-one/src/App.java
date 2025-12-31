import Logic.x2j_j2x.Xml_To_Json;
import UI.MainStage;
import javafx.application.Application;
import javafx.stage.Stage;


// public class App extends Application {
public class App {
    // @Override
    // Controls + Layout + Scene + Stage
    // public void start(Stage primaryStage) {
    //     MainStage mainStage = new MainStage();
    //     mainStage.createMainStage(primaryStage);
    // }

    public static void main(String[] args) {
        Xml_To_Json xml_to_json_obj = new Xml_To_Json();
        xml_to_json_obj.ToXml(null);
        // launch(args);
    }
}