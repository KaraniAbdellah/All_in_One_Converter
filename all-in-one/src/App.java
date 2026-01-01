
import Logic.x2j_j2x.Json_To_Xml;
import Logic.x2j_j2x.Xml_To_Json;

// public class App extends Application {
public class App {
    // @Override
    // Controls + Layout + Scene + Stage
    // public void start(Stage primaryStage) {
    // MainStage mainStage = new MainStage();
    // mainStage.createMainStage(primaryStage);
    // }

    public static void main(String[] args) {
        String jsonData = "{\"name\":\"John\", \"age\":30, \"car\":null}";
        String xmlData = "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";

        Xml_To_Json xml_to_json_obj = new Xml_To_Json();
        Json_To_Xml json_to_xml_obj = new Json_To_Xml();

        // xml_to_json_obj.ToXml(jsonData);
        json_to_xml_obj.ToJson(xmlData);

        // xml_to_json_obj.ToXmlWithApi(jsonData);
        // launch(args);
    }
}
