package Logic.x2j_j2x;

import org.json.JSONObject;
import org.json.XML;

import services.Services;

public class Json_To_Xml {
    public String ToXml(String jsonData) {
        // One Way With org.json
        JSONObject jsonObject = new JSONObject(jsonData);
        String xmlData = XML.toString(jsonObject);
        return xmlData;

        // Second Way Manually
        // String xmlData = "";
        // String jsonDataSplited[] = jsonData.split("");
        // for (int i = 0; i < jsonDataSplited.length; i++) {
        // System.out.print(jsonDataSplited[i]);
        // if (jsonDataSplited[i] == ":") {
        // System.out.println("The Begenning of Value");
        // for (int j = 0; jsonDataSplited[j] == ","; j++) {
        // xmlData += jsonDataSplited[j];
        // }
        // continue;
        // }
        // if (jsonDataSplited[i] == "\"") {
        // System.out.println("The Begenning attribute");
        // }
        // }
        // System.out.println(xmlData);
        // return xmlData;
    }

    public String ToXmlWithApi(String jsonData) {
        Services services = new Services();
        String xmlData = services.getXmlData(jsonData);
        if (xmlData == null) {
            System.out.println("Can Not Get The Data");
        }
        return xmlData;
    }

}
