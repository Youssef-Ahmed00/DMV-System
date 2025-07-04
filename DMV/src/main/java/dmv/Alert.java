package dmv;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Alert {
    Label detailsLabel;

    Button okButton;

    ImageView image;

    GridPane gridPane;

    Scene scene;
    Alert(){
        detailsLabel = new Label("");
        okButton = new Button("    OK    ");
        image = new ImageView("/error.png");
        gridPane = new GridPane();
        gridPane.add(detailsLabel,0,0);
        gridPane.add(image,1,0);
        gridPane.add(okButton,1,1);
        gridPane.setVgap(10);
        gridPane.setHgap(100);
        gridPane.setAlignment(Pos.CENTER);
        scene = new Scene(gridPane);
        scene.getStylesheets().add("Styles.css");
    }
}
