import java.io.FileNotFoundException;
import java.io.IOException;

import Logic.x2j_j2x.Xml_To_Json;
import UI.MainStage;
import javafx.application.Application;
import javafx.stage.Stage;

// public class App extends Application {
public class App {
    // @Override
    // Controls + Layout + Scene + Stage
    // public void start(Stage primaryStage) {
    // MainStage mainStage = new MainStage();
    // mainStage.createMainStage(primaryStage);
    // }

    public static void main(String[] args) {
        Xml_To_Json xml_to_json_obj = new Xml_To_Json();
        String jsonData = "{\"name\":\"John\", \"age\":30, \"car\":null}";
        String xmlData = "<root>" +
                "<name>John</name>" +
                "<age>30</age>" +
                "<car>null</car>" +
                "</root>";
        // xml_to_json_obj.ToXml(jsonData);
        xml_to_json_obj.ToXmlWithApi(jsonData);
        // launch(args);
    }
}