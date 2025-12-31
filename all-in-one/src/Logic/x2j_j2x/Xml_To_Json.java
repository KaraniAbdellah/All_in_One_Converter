package Logic.x2j_j2x;

// We Need to Package
// org.json: for json to xml
// 

import org.json.JSONObject;
import org.json.XML;

public class Xml_To_Json {
    public String ToXml(String data) {
        // First Way With Ready Packages
        // String jsonData = "{\"name\":\"John\", \"age\":30, \"car\":null}";
        // JSONObject jsonObject = new JSONObject(jsonData);
        // System.out.println(XML.toString(jsonObject));
        // return jsonData;
        // Second Way Manually
        String jsonData = "{\"name\":\"John\", \"age\":30, \"car\":null}";
        String xmlData = "";
        
        return xmlData;
    }

    public String ToJson(String data) {
        String jsonData = "THIS XML DATA";
        return jsonData;
    }

    public String ToXmlWithApi(String data) {
        String xmlData = "THIS XML DATA";
        return xmlData;
    }

    public String ToJsonWithApi(String data) {
        String jsonData = "THIS XML DATA";
        return jsonData;
    }
}
