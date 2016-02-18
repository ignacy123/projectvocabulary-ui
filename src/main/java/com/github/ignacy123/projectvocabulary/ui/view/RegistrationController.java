package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.domain.UserReopositoryMemory;
import com.github.ignacy123.projectvocabulary.ui.domain.UserRepository;
import com.github.ignacy123.projectvocabulary.ui.validation.RegistrationValidator;
import com.github.ignacy123.projectvocabulary.ui.validation.ValidationResult;
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
        RegistrationValidator registrationValidator = new RegistrationValidator();
        ValidationResult validationResult = registrationValidator.validateLogin(loginField.getText());
        loginError.setText(validationResult.getMessage());
        return validationResult.isValid();
    }
    private boolean validatePassword() {
        RegistrationValidator registrationValidator = new RegistrationValidator();
        ValidationResult validationResult = registrationValidator.validatePassword(passwordField.getText());
        System.out.println(validationResult.getError());
        return validationResult.isValid();
    }
    private boolean validateEmail() {
        RegistrationValidator registrationValidator = new RegistrationValidator();
        ValidationResult validationResult = registrationValidator.validateEmail(emailField.getText());
        System.out.println(validationResult.getError());
        return validationResult.isValid();
    }


}