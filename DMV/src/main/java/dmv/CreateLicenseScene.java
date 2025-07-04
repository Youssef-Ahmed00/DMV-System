package dmv;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class CreateLicenseScene {
    Label nationalIdLabel;
    Label classLabel;
    Label restLabel;

    TextField nationalIdTextField;

    ToggleButton aToggleButton;
    ToggleButton bToggleButton;
    ToggleButton cToggleButton;
    ToggleButton dToggleButton;
    ToggleButton eToggleButton;
    ToggleButton fToggleButton;
    ToggleGroup classToggleGroup;


    ToggleButton noneToggleButton;
    ToggleButton visionToggleButton;
    ToggleButton nightToggleButton;
    ToggleButton areaToggleButton;
    ToggleButton ageToggleButton;
    ToggleButton medicalToggleButton;
    ToggleGroup restToggleGroup;

    Button backButton;
    Button createButton;

    GridPane gridPane;

    Scene scene;

    CreateLicenseScene() {
        nationalIdLabel = new Label("National ID");
        classLabel = new Label("Class");
        restLabel = new Label("REST");

        nationalIdTextField = new TextField();

        aToggleButton = new RadioButton("A");
        bToggleButton = new RadioButton("B");
        cToggleButton = new RadioButton("C");
        dToggleButton = new RadioButton("D");
        eToggleButton = new RadioButton("E");
        fToggleButton = new RadioButton("F");
        classToggleGroup = new ToggleGroup();
        classToggleGroup.getToggles().addAll(aToggleButton, bToggleButton, cToggleButton, dToggleButton, eToggleButton, fToggleButton);

        noneToggleButton = new RadioButton("None");
        visionToggleButton = new RadioButton("Vision Requirements");
        nightToggleButton = new RadioButton("Night Driving Restriction");
        areaToggleButton = new RadioButton("Area Restriction");
        ageToggleButton = new RadioButton("Age Limitation");
        medicalToggleButton = new RadioButton("Medical Reassessment");
        restToggleGroup = new ToggleGroup();
        restToggleGroup.getToggles().addAll(noneToggleButton,visionToggleButton,nightToggleButton,areaToggleButton,ageToggleButton,medicalToggleButton);

        backButton = new Button(" Back ");
        createButton = new Button("Create");

        gridPane = new GridPane();
        gridPane.add(nationalIdLabel,0,0);
        gridPane.add(classLabel,0,2);
        gridPane.add(restLabel,0,6);
        gridPane.add(aToggleButton,1,2);
        gridPane.add(bToggleButton,2,2);
        gridPane.add(cToggleButton,1,3);
        gridPane.add(dToggleButton,2,3);
        gridPane.add(eToggleButton,1,4);
        gridPane.add(fToggleButton,2,4);
        gridPane.add(nationalIdTextField,1,0);
        gridPane.add(noneToggleButton,1,6);
        gridPane.add(visionToggleButton,2,6);
        gridPane.add(nightToggleButton,1,7);
        gridPane.add(areaToggleButton,2,7);
        gridPane.add(ageToggleButton,1,8);
        gridPane.add(medicalToggleButton,2,8);
        gridPane.add(backButton,3,9);
        gridPane.add(createButton,4,9);

        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        scene = new Scene(gridPane);
        scene.getStylesheets().add("Styles.css");

    }
}
