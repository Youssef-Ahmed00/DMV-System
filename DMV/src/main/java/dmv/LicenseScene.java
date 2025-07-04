package dmv;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LicenseScene {
    Label fullNameLabel;
    Label licenseNoLabel;
    Label birthDateLabel;
    Label issueDateLabel;
    Label expiryDateLabel;
    Label classLabel;
    Label licenseStatusLabel;
    Label restLabel;

    Label fullNameValueLabel;
    Label licenseNoValueLabel;
    Label birthDateValueLabel;
    Label issueDateValueLabel;
    Label expiryDateValueLabel;
    Label classValueLabel;
    Label licenseStatusValueLabel;
    Label restValueLabel;

    Label gap;

    ImageView image;

    Button removeButton;
    Button renewButton;
    Button okButton;

    GridPane gridPane;

    Scene scene;
    LicenseScene(){
        fullNameLabel = new Label("Full Name:");
        licenseNoLabel = new Label("License Number:");
        birthDateLabel = new Label("Date Of Birth:");
        issueDateLabel = new Label("ISS:");
        expiryDateLabel = new Label("EXP");
        classLabel = new Label("Class:");
        licenseStatusLabel = new Label("Status");
        restLabel = new Label("REST");

        fullNameValueLabel = new Label();
        licenseNoValueLabel = new Label();
        birthDateValueLabel = new Label();
        issueDateValueLabel = new Label();
        expiryDateValueLabel = new Label();
        classValueLabel = new Label();
        licenseStatusValueLabel = new Label();
        restValueLabel = new Label();

        gap = new Label("               ");

        image = new ImageView("/person.png");
        image.setFitHeight(64);
        image.setFitWidth(64);
        removeButton = new Button("  Remove  ");
        renewButton = new Button("  Renew  ");
        okButton = new Button("    OK    ");

        gridPane = new GridPane();
        gridPane.add(image,0,0);
        gridPane.add(fullNameLabel,0,1);
        gridPane.add(licenseNoLabel,0,2);
        gridPane.add(birthDateLabel,0,3);
        gridPane.add(issueDateLabel,0,4);
        gridPane.add(expiryDateLabel,0,5);
        gridPane.add(classLabel,0,6);
        gridPane.add(licenseStatusLabel,0,7);
        gridPane.add(restLabel,0,8);
        gridPane.add(gap,1,1);
        gridPane.add(fullNameValueLabel,2,1);
        gridPane.add(licenseNoValueLabel,2,2);
        gridPane.add(birthDateValueLabel,2,3);
        gridPane.add(issueDateValueLabel,2,4);
        gridPane.add(expiryDateValueLabel,2,5);
        gridPane.add(classValueLabel,2,6);
        gridPane.add(licenseStatusValueLabel,2,7);
        gridPane.add(restValueLabel,2,8);
        gridPane.add(removeButton,3,9);
        gridPane.add(renewButton,4,9);
        gridPane.add(okButton,5,9);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        scene = new Scene(gridPane);
        scene.getStylesheets().add("Styles.css");
    }
}
