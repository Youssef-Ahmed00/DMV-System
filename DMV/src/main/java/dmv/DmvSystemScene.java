package dmv;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class DmvSystemScene {
    ToggleButton addCitizenToggleButton;
    ToggleButton creatLicenseToggleButton;
    ToggleButton citizenToggleButton;
    ToggleButton licenseToggleButton;
    ToggleGroup optionsToggleGroup;

    Button nextButton;
    Button logOutButton;
    Button shutDownButton;

    GridPane gridPane;

    Scene scene;

    DmvSystemScene(){
        addCitizenToggleButton = new RadioButton("Add Citizen");
        creatLicenseToggleButton  = new RadioButton("Create License");
        citizenToggleButton = new RadioButton("Citizen Information");
        licenseToggleButton = new RadioButton("License Information");
        optionsToggleGroup = new ToggleGroup();
        optionsToggleGroup.getToggles().addAll(addCitizenToggleButton,creatLicenseToggleButton,citizenToggleButton,licenseToggleButton);

        nextButton = new Button("Next");
        logOutButton = new Button("Log Out");
        shutDownButton = new Button("Shut Down");

        gridPane = new GridPane();
        gridPane.add(addCitizenToggleButton,0,0);
        gridPane.add(creatLicenseToggleButton,0,1);
        gridPane.add(citizenToggleButton,0,2);
        gridPane.add(licenseToggleButton,0,3);
        gridPane.add(nextButton,2,4);
        gridPane.add(logOutButton,3,4);
        gridPane.add(shutDownButton,4,4);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        scene = new Scene(gridPane);
        scene.getStylesheets().add("Styles.css");

    }

}
