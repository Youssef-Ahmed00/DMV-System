package dmv;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class CitizenScene {
    ImageView image;

    Label fullNameLabel;
    Label nationalIdLabel;
    Label addresstLabel;
    Label birthDateLabel;
    Label genderLabel;
    Label maritalStatusLabel;
    Label religionLabel;

    Label fullNameValueLabel;
    Label nationalIdValueLabel;
    Label addresstLabelValueLabel;
    Label birthDateValueLabel;
    Label genderValueLabel;
    Label maritalStatusValueLabel;
    Label religionValueLabel;

    Label gap;

    Button removeButton;
    Button okButton;

    GridPane gridPane;

    Scene scene;

    CitizenScene(){
        image = new ImageView("/person.png");
        image.setFitHeight(64);
        image.setFitWidth(64);

        fullNameLabel = new Label("Full Name :");
        nationalIdLabel = new Label("National ID :");
        addresstLabel = new Label("Address :");
        birthDateLabel = new Label("Date Of Birth :");
        genderLabel = new Label("Gender :" );
        maritalStatusLabel = new Label("Marital Status :");
        religionLabel = new Label("Religion : ");

        fullNameValueLabel = new Label();
        nationalIdValueLabel = new Label();
        addresstLabelValueLabel = new Label();
        birthDateValueLabel = new Label();
        genderValueLabel = new Label();
        maritalStatusValueLabel = new Label();
        religionValueLabel = new Label();

        gap = new Label("               ");

        removeButton = new Button(" Remove ");
        okButton = new Button("   OK   ");


        gridPane = new GridPane();
        gridPane.add(image,0,0);
        gridPane.add(fullNameLabel,0,1);
        gridPane.add(nationalIdLabel,0,2);
        gridPane.add(addresstLabel,0,3);
        gridPane.add(birthDateLabel,0,4);
        gridPane.add(genderLabel,0,5);
        gridPane.add(maritalStatusLabel,0,6);
        gridPane.add(religionLabel,0,7);
        gridPane.add(gap,1,1);
        gridPane.add(fullNameValueLabel,2,1);
        gridPane.add(nationalIdValueLabel,2,2);
        gridPane.add(addresstLabelValueLabel,2,3);
        gridPane.add(birthDateValueLabel,2,4);
        gridPane.add(genderValueLabel,2,5);
        gridPane.add(maritalStatusValueLabel,2,6);
        gridPane.add(religionValueLabel,2,7);
        gridPane.add(removeButton,3,8);
        gridPane.add(okButton,4,8);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        scene = new Scene(gridPane);
        scene.getStylesheets().add("Styles.css");
    }
}
