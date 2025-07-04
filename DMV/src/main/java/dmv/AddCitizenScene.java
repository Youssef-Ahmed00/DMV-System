package dmv;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class AddCitizenScene {

    Label fullNameLabel;
    Label nationalIdLabel;
    Label houseNoLabel;
    Label streetLabel;
    Label governorateLabel;
    Label countryLabel;
    Label dateOfBirthLabel;
    Label genderLabel;
    Label maritalStatusLabel;
    Label religionLabel;

    TextField fullNameTextField;
    TextField nationalIdTextField;
    TextField houseNoTextField;
    TextField streetTextField;
    TextField governorateTextField;
    TextField countryTextField;
    DatePicker dateOfBirthDatePicker;

    ToggleButton maleToggleButton;
    ToggleButton femaleToggleButton;
    ToggleGroup genderToggleGroup;

    ToggleButton singleToggleButton;
    ToggleButton marriedToggleButton;
    ToggleButton divorcedToggleButton;
    ToggleButton widowedToggleButton;
    ToggleGroup maritalStatusToggleGroup;

    ToggleButton christianToggleButton;
    ToggleButton muslimToggleButton;
    ToggleGroup religionToggleGroup;

    Button backButton;
    Button submitButton;

    GridPane gridPane;

    Scene scene;

    AddCitizenScene() {
        fullNameLabel = new Label("Full Name");
        nationalIdLabel = new Label("National ID");
        houseNoLabel = new Label("House Number");
        streetLabel = new Label("Street");
        governorateLabel = new Label("Governorate");
        countryLabel = new Label("Country");
        dateOfBirthLabel = new Label("Date Of Birth");
        genderLabel = new Label("Gender");
        maritalStatusLabel = new Label("Marital Status");
        religionLabel = new Label("Religion");

        fullNameTextField = new TextField();
        nationalIdTextField = new TextField();
        houseNoTextField = new TextField();
        streetTextField = new TextField();
        governorateTextField = new TextField();
        countryTextField = new TextField();
        dateOfBirthDatePicker = new DatePicker();

        maleToggleButton = new RadioButton("Male");
        femaleToggleButton = new RadioButton("Female");
        genderToggleGroup = new ToggleGroup();
        genderToggleGroup.getToggles().addAll(maleToggleButton, femaleToggleButton);

        singleToggleButton = new RadioButton("Single");
        marriedToggleButton = new RadioButton("Married");
        divorcedToggleButton = new RadioButton("Divorced");
        widowedToggleButton = new RadioButton("widowed");
        maritalStatusToggleGroup = new ToggleGroup();
        maritalStatusToggleGroup.getToggles().addAll(singleToggleButton, marriedToggleButton, divorcedToggleButton, widowedToggleButton);

        christianToggleButton = new RadioButton("Christian");
        muslimToggleButton = new RadioButton("Muslim");
        religionToggleGroup = new ToggleGroup();
        religionToggleGroup.getToggles().addAll(christianToggleButton, muslimToggleButton);

        backButton = new Button(" Back ");
        submitButton = new Button("Submit");

        gridPane = new GridPane();
        gridPane.add(fullNameLabel, 0, 0);
        gridPane.add(nationalIdLabel, 0, 1);
        gridPane.add(houseNoLabel, 0, 2);
        gridPane.add(streetLabel, 2, 2);
        gridPane.add(governorateLabel, 0, 3);
        gridPane.add(countryLabel, 2, 3);
        gridPane.add(dateOfBirthLabel, 0, 4);
        gridPane.add(genderLabel, 0, 5);
        gridPane.add(maritalStatusLabel, 0, 7);
        gridPane.add(religionLabel, 0, 10);
        gridPane.add(fullNameTextField, 1, 0);
        gridPane.add(nationalIdTextField, 1, 1);
        gridPane.add(houseNoTextField, 1, 2);
        gridPane.add(streetTextField, 3, 2);
        gridPane.add(governorateTextField, 1, 3);
        gridPane.add(countryTextField, 3, 3);
        gridPane.add(dateOfBirthDatePicker, 1, 4);
        gridPane.add(maleToggleButton, 1, 5);
        gridPane.add(femaleToggleButton, 2, 5);
        gridPane.add(singleToggleButton, 1, 7);
        gridPane.add(marriedToggleButton, 2, 7);
        gridPane.add(divorcedToggleButton, 1, 8);
        gridPane.add(widowedToggleButton, 2, 8);
        gridPane.add(christianToggleButton, 1, 10);
        gridPane.add(muslimToggleButton, 2, 10);
        gridPane.add(backButton, 4, 11);
        gridPane.add(submitButton, 5, 11);


        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        scene = new Scene(gridPane);
        scene.getStylesheets().add("Styles.css");


    }
}
