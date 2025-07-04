package dmv;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FindScene {
    Label nationalIdLabel;

    TextField nationalIdTextField;

    Button okButton;
    Button backButton;

    GridPane gridPane;

    Scene scene;

    FindScene(){
        nationalIdLabel = new Label("National ID");

        nationalIdTextField = new TextField();

        okButton = new Button("    OK    ");
        backButton = new Button("   Back   ");
         gridPane = new GridPane();
         gridPane.add(nationalIdLabel,0,0);
         gridPane.add(nationalIdTextField,1,0);
         gridPane.add(backButton,2,1);
         gridPane.add(okButton,3,1);

         gridPane.setVgap(10);
         gridPane.setHgap(10);
         gridPane.setAlignment(Pos.CENTER);

         scene = new Scene(gridPane);
         scene.getStylesheets().add("Styles.css");
    }
}

