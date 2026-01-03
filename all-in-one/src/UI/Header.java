package UI;

import java.net.URI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.layout.GridPane;

public class Header {

    // Create a social button with logo and text
    public Button createSocialButton(String socialType, String logoPath) {
        Image logo = new Image(getClass().getResourceAsStream(logoPath));
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(20);
        logoView.setFitHeight(20);

        Button btn = new Button(socialType, logoView);
        btn.setStyle(
                "-fx-background-color:#444;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-padding: 10px 15px;" +
                        "-fx-background-radius: 5px;");

        return btn;
    }

    // Create the header layout
    public GridPane createHeader() {
        GridPane header = new GridPane();
        header.setPadding(new Insets(10));
        header.setHgap(10);
        header.setVgap(10);

        // Logo
        Image logoImg = new Image(getClass().getResourceAsStream("../images/avatar.png"));
        ImageView logoView = new ImageView(logoImg);
        logoView.setFitWidth(80);
        logoView.setFitHeight(80);
        logoView.setStyle("-fx-border-radius: 50px;");
        Circle clip = new Circle(80 / 2, 80 / 2, Math.min(80, 80) / 2);
        logoView.setClip(clip);

        // Social buttons
        Button githubBtn = createSocialButton("Github", "../images/github.png");
        Button linkedinBtn = createSocialButton("Linkedin", "../images/linkedin.jpg");

        // Layout
        HBox socialBox = new HBox(10, githubBtn, linkedinBtn);
        socialBox.setAlignment(Pos.CENTER_RIGHT);

        header.add(logoView, 0, 0);
        header.add(socialBox, 1, 0);
        header.setAlignment(Pos.CENTER);

        return header;
    }

}
