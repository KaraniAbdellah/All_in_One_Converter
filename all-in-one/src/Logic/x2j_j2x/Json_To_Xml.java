package Logic.x2j_j2x;

import org.json.JSONObject;
import org.json.XML;

import services.Services;

public class Json_To_Xml {
    public String ToJson(String xmlData) {
        // One Way
        JSONObject xmlJsonObj = XML.toJSONObject(xmlData);
        String jsonData = xmlJsonObj.toString(4);
        System.out.println(jsonData);
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
