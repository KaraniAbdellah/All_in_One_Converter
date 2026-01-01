package Logic.x2j_j2x;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONObject;
import org.json.XML;

import services.Services;

public class Xml_To_Json {

    public String ToXml(String jsonData) {
        // First Way With Ready Packages
        JSONObject jsonObject = new JSONObject(jsonData);
        System.out.println(XML.toString(jsonObject));

        // Second Way Manually
        String xmlData = "";
        String jsonDataSplited[] = jsonData.split("");
        for (int i = 0; i < jsonDataSplited.length; i++) {
            System.out.print(jsonDataSplited[i]);
            if (jsonDataSplited[i] == ":") {
                System.out.println("The Begenning of Value");
                for (int j = 0; jsonDataSplited[j] == ","; j++) {
                    xmlData += jsonDataSplited[j];
                }
                continue;
            }
            if (jsonDataSplited[i] == "\"") {
                System.out.println("The Begenning attribute");
            }
        }
        System.out.println(xmlData);
        return xmlData;
    }

    public String ToJson(String data) {
        String jsonData = "THIS XML DATA";
        return jsonData;
    }

    public String ToXmlWithApi(String jsonData) {
        Services services = new Services();
        String xmlData = services.getXmlData(jsonData);
        if (xmlData == null) {
            System.out.println("Can Not Get The Data");
        }
        return xmlData;
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
