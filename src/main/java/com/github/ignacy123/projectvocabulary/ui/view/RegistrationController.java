package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.domain.UserReopositoryMemory;
import com.github.ignacy123.projectvocabulary.ui.domain.UserRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by ignacy on 03.02.16.
 */

public class RegistrationController extends AbstractBaseController {
    @FXML
    private TextField loginField;
    @FXML
    private Label loginError;
    @FXML
    private TextField emailField;
    @FXML
    private Label emailError;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label passwordError;
    @FXML
    private PasswordField passwordConfirmationField;
    @FXML
    private Label passwordConfirmationError;
    private UserRepository userRepository = new UserReopositoryMemory();
    @FXML
    public void register() {
        if (validateLogin()) {
            main.switchToWindowScene();
        }

    }

    private boolean validateLogin() {
        String login = loginField.getText();
        if (login.length() < 3) {
            loginError.setText("Login must be at least 3 characters long.");
            return false;
        }
        return true;

    }
}