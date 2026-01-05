import UI.MainStage;
import javafx.application.Application;
import javafx.stage.Stage;

// public class App extends Application {
public class App extends Application {
    // Controls + Layout + Scene + Stage
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("ALL IN ONE");
        MainStage mainStage = new MainStage();
        mainStage.createMainStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// Code for Test API
/*
 * String jsonData = "{\"name\":\"John\", \"age\":30, \"car\":null}";
 * String xmlData =
 * "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";
 * 
 * Xml_To_Json xml_to_json_obj = new Xml_To_Json();
 * Json_To_Xml json_to_xml_obj = new Json_To_Xml();
 * 
 * System.out.println(xml_to_json_obj.ToJson(xmlData));
 * System.out.println(xml_to_json_obj.ToJsonWithApi(xmlData));
 * System.out.println(json_to_xml_obj.ToXml(jsonData));
 * System.out.println(json_to_xml_obj.ToXmlWithApi(jsonData));
 * 
 * json_to_xml_obj.ToXml(jsonData);
 */