package services;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class Services {
    private String BASE_URL_CONFG = "/home/abdellah/Documents/git_projects/All_in_One_Converter/all-in-one/config.properties";
    private HttpClient client;
    private String NOCODE_BASE_URL_JSON_TO_XML;
    private String NOCODE_BASE_URL_XML_TO_JSON;

    public Services() {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(this.BASE_URL_CONFG));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.NOCODE_BASE_URL_JSON_TO_XML = p.getProperty("NOCODE_BASE_URL_JSON_TO_XML");
        this.NOCODE_BASE_URL_XML_TO_JSON = p.getProperty("NOCODE_BASE_URL_XML_TO_JSON");
        this.client = HttpClient.newHttpClient();
        System.out.println("API_KEY = " + this.NOCODE_BASE_URL_JSON_TO_XML);
        System.out.println("API_KEY = " + this.NOCODE_BASE_URL_XML_TO_JSON);
    }

    public String getXmlData(String jsonData) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.NOCODE_BASE_URL_JSON_TO_XML))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonData))
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error sending request: " + e.getMessage());
            return null;
        }
    }

    public String getJsonData(String xmlData) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.NOCODE_BASE_URL_XML_TO_JSON))
                    .header("Content-Type", "application/xml") // important for XML
                    .POST(HttpRequest.BodyPublishers.ofString(xmlData))
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error sending request: " + e.getMessage());
            return null;
        }
    }

}


