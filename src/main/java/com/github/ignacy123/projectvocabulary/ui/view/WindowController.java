package com.github.ignacy123.projectvocabulary.ui.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * Created by ignacy on 20.01.16.
 */
public class WindowController extends AbstractBaseController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField ageField;



    public WindowController() {

    }

    @FXML
    public void showSummary() {
        String content = "First name: " + firstNameField.getText() + "\n";
        content += "Last name: " + lastNameField.getText() + "\n";
        content += "Age: " + ageField.getText() + "\n";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Form Summary");
        alert.setHeaderText(null);
        alert.setContentText(content);

        alert.showAndWait();
    }


    @FXML
    public void back() {
        main.logOut();
    }

    @FXML
    public void switchToRegistrationScene() {
        main.switchToRegistrationScene();
    }
    @FXML
    public void switchToLoginScene() { main.switchToLoginScene(); }
}
