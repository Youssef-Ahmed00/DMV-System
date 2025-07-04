package dmv;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LogInScene {
    Label nameLabel;
    Label passwordLabel;

    TextField nameTextField;
    PasswordField passwordTextField;

    Button logInButton;

    GridPane gridPane;

    Scene scene;

    LogInScene(){
        nameLabel = new Label("Name");
        passwordLabel = new Label("Password");

        nameTextField = new TextField();
        passwordTextField = new PasswordField();

        logInButton = new Button("Log In");

        gridPane = new GridPane();
        gridPane.add(nameLabel,0,0);
        gridPane.add(passwordLabel,0,1);
        gridPane.add(nameTextField,1,0);
        gridPane.add(passwordTextField,1,1);
        gridPane.add(logInButton,2,2);

        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        scene = new Scene(gridPane);
        scene.getStylesheets().add("Styles.css");
    }
}
