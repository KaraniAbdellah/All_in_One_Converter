package Logic.x2j_j2x;

import org.json.JSONObject;
import org.json.XML;
import services.Services;

public class Xml_To_Json {

    public String ToJson(String xmlData) {
        // One Way With org.json
        JSONObject xmlJsonObj = XML.toJSONObject(xmlData);
        String jsonData = xmlJsonObj.toString(4);
        return jsonData;
        // Second Way

    }

    public String ToJsonWithApi(String xmlData) {
        Services services = new Services();
        String jsonData = services.getJsonData(xmlData);
        if (jsonData == null) {
            System.out.println("Can Not Get The Data");
        }
        return jsonData;
    }
}
