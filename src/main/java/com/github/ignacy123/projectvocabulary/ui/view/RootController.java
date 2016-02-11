package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by ignacy on 20.01.16.
 */
public class RootController extends AbstractBaseController{
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;


    public RootController() {
        System.out.println();
    }
    @FXML
    public void showSummary() {
        String content = "User: " + loginField.getText() + "\n";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Form Summary");
        alert.setHeaderText(null);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
