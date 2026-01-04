package UI;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import Logic.x2j_j2x.Json_To_Xml;
import Logic.x2j_j2x.Xml_To_Json;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Converter {

    public void getOutput(String option1, String option2,
            TextArea Input, TextArea Output) {

        if (option1.equals(option2)) {
            Output.setText(Input.getText());
        } else if (option1.equals("XML") && option2.equals("JSON")) {
            // From XML to JSON
            Xml_To_Json xml_to_json = new Xml_To_Json();
            String jsonData = xml_to_json.ToJson(Input.getText());
            System.out.println("jsonData returned: " + jsonData);
            Output.setText(jsonData);
        } else if (option1.equals("JSON") && option2.equals("XML")) {
            // From JSON to XML
            Json_To_Xml json_to_xml = new Json_To_Xml();
            String xmlData = json_to_xml.ToXml(Input.getText());
            System.out.println("xmlData returned: " + xmlData);
            Output.setText(formatXml(xmlData));
        } else {
            Output.setText("Not Built YET");
        }
    }

    private String formatXml(String xml) {
        try {
            xml = xml.replaceFirst("<\\?xml.*?\\?>", "").trim();

            StringBuilder formatted = new StringBuilder();
            int indent = 0;
            boolean inTag = false;

            for (int i = 0; i < xml.length(); i++) {
                char c = xml.charAt(i);

                if (c == '<') {
                    if (i + 1 < xml.length() && xml.charAt(i + 1) == '/') {
                        // Closing tag
                        indent--;
                        formatted.append("\n").append("  ".repeat(Math.max(0, indent)));
                    } else if (!inTag) {
                        // Opening tag
                        formatted.append("\n").append("  ".repeat(indent));
                    }
                    inTag = true;
                } else if (c == '>') {
                    inTag = false;
                    if (i > 0 && xml.charAt(i - 1) != '/') {
                        if (i + 1 < xml.length() && xml.charAt(i + 1) != '<') {
                        } else {
                            indent++;
                        }
                    }
                }

                formatted.append(c);
            }

            return formatted.toString().trim();
        } catch (Exception e) {
            return xml; // Return original if formatting fails
        }
    }

    public GridPane createConverterScene() {
        GridPane gridPaneConvertor = new GridPane();
        gridPaneConvertor.setPadding(new Insets(20));
        gridPaneConvertor.setHgap(20);
        gridPaneConvertor.setVgap(10);

        // Title and description
        Label title = new Label("ALL to ALL Convertor");
        title.setStyle(
                "-fx-font-size: 24px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #62c853;"
                        + "-fx-padding: 0px 0px -10px 0px;");
        Label desc = new Label("Convert your XML, JSON, CSV data to a JSON, XML, ...");
        desc.setStyle("-fx-font-size: 14px;" +
                "-fx-padding: 0px 0px 15px 0px;");

        title.setMaxWidth(Double.MAX_VALUE);
        title.setAlignment(javafx.geometry.Pos.CENTER);

        desc.setMaxWidth(Double.MAX_VALUE);
        desc.setAlignment(javafx.geometry.Pos.CENTER);

        // Text areas for input and output
        TextArea Input = new TextArea();
        Input.setPromptText("Paste your XML here");
        Input.setPrefSize(600, 400);
        Input.setStyle("-fx-border-color: #62c853;" + "-fx-border-width: 2px;" + "-fx-border-style: solid;"
                + "-fx-border-radius: 10px;" + "-fx-background-radius: 10px;");

        TextArea Output = new TextArea();
        Output.setPromptText("Your JSON will appear here");
        Output.setPrefSize(600, 400);
        Output.setEditable(false);
        Output.setStyle("-fx-border-color: #62c853;" + "-fx-border-width: 2px;" + "-fx-border-style: solid;"
                + "-fx-border-radius: 10px;" + "-fx-background-radius: 10px;");

        String comboStyle = "-fx-background-color: white;" +
                "-fx-border-color: #62c853;" +
                "-fx-border-width: 2px;" +
                "-fx-border-radius: 8px;" +
                "-fx-background-radius: 8px;" +
                "-fx-font-size: 14px;" +
                "-fx-padding: 4px;";

        ComboBox<String> formatChoiceInput = new ComboBox<>();
        ComboBox<String> formatChoiceOutput = new ComboBox<>();

        formatChoiceInput.getItems().addAll("XML", "JSON", "CSV");
        formatChoiceInput.setValue("XML");
        formatChoiceInput.setStyle(comboStyle);

        formatChoiceOutput.getItems().addAll("XML", "JSON", "CSV");
        formatChoiceOutput.setValue("JSON");
        formatChoiceOutput.setStyle(comboStyle);

        VBox boxInput = new VBox(10, formatChoiceInput, Input);
        boxInput.setAlignment(Pos.TOP_LEFT);

        VBox boxOutput = new VBox(10, formatChoiceOutput, Output);
        boxOutput.setAlignment(Pos.TOP_LEFT);

        HBox boxes = new HBox(10, boxInput, boxOutput);
        boxes.setAlignment(Pos.CENTER);

        // Events
        Input.textProperty().addListener((obs, oldText, newText) -> {
            System.out.println("User typed: " + newText);
            // Here you can add XML to JSON conversion logic
            Output.setText("{\n  \"example\": \"Your JSON output here\"\n}");
        });

        // Button Convert
        Button convertButton = new Button("Convert");

        convertButton.setStyle("-fx-background-color: #62c853;" + "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" + "-fx-font-weight: bold;" +
                "-fx-padding: 10px 15px;" + "-fx-background-radius: 8px;" +
                "-fx-cursor: hand;");

        VBox boxConvertButton = new VBox(10, convertButton);
        boxConvertButton.setAlignment(Pos.CENTER);

        // Events
        convertButton.setOnMouseClicked(event -> {
            System.out.println(Input.getText());
            System.out.println(Output.getText());
            System.out.println(formatChoiceInput.getValue());
            System.out.println(formatChoiceOutput.getValue());
            System.out.println("Button Clicked");
            getOutput(formatChoiceInput.getValue(), formatChoiceOutput.getValue(), Input, Output);
        });

        // Add all to GridPane
        gridPaneConvertor.add(title, 0, 0);
        gridPaneConvertor.add(desc, 0, 1);
        gridPaneConvertor.add(boxes, 0, 2);
        gridPaneConvertor.add(boxConvertButton, 0, 3);
        gridPaneConvertor.setAlignment(Pos.CENTER);

        return gridPaneConvertor;
    }

}
