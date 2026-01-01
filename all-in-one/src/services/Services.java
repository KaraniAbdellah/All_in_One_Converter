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
    private String API_KEY;

    public Services() {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(this.BASE_URL_CONFG));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.API_KEY = p.getProperty("RAPIDO_API_KEY");
        this.client = HttpClient.newHttpClient();
    }

    public String getXmlData(String jsonData) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://json-to-xml.p.rapidapi.com/apitalk/json-to-xml/api/%7B%7D"))
                    .header("x-rapidapi-key", this.API_KEY)
                    .header("x-rapidapi-host", "json-to-xml.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return response.body();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error In Sending Request From GetXmlData");
            return null;
        }
    }

    public String getJsonData(String xmlData) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(
                            "https://xml-to-json1.p.rapidapi.com/?url=https%3A%2F%2Fwww.w3schools.com%2Fxml%2Fplant_catalog.xml"))
                    .header("x-rapidapi-key", this.API_KEY)
                    .header("x-rapidapi-host", "xml-to-json1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error In Sending Request From GetJsonData");
            return null;
        }

    }

}
