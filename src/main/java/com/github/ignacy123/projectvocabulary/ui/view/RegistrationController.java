package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.domain.*;
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
    private final UserRepository userRepository = UserRepository.getInstance();
    private final RegistrationValidator registrationValidator = new RegistrationValidator();

    @FXML
    public void register() {
        clearErrors();
        if (validate()) {
            saveUser();
        }
    }

    private void saveUser() {
        try {
            User user = new User();
            user.setPassword(passwordField.getText());
            user.setEmail(emailField.getText());
            user.setLogin(loginField.getText());
            userRepository.saveUser(user);
            main.switchToWindowScene();
        } catch (UserEmailNotUniqueException e) {
            emailError.setText("This email is already used.");
        } catch (UserLoginNotUniqueException e) {
            loginError.setText("This login is already used.");
        }
    }

    private boolean validate() {
        boolean valid = true;
        valid = validateLogin() && valid;
        valid = validateEmail() && valid;
        valid = validatePassword() && valid;

        if (!passwordField.getText().equals(passwordConfirmationField.getText())) {
            passwordConfirmationError.setText("Passwords are not equal.");
        }

        return valid;
    }

    private void clearErrors() {
        passwordError.setText("");
        loginError.setText("");
        emailError.setText("");
    }

    private boolean validateLogin() {
        ValidationResult validationResult = registrationValidator.validateLogin(loginField.getText());
        if (!validationResult.isValid()) {
            loginError.setText(validationResult.getMessage());
        }
        return validationResult.isValid();
    }

    private boolean validatePassword() {
        ValidationResult validationResult = registrationValidator.validatePassword(passwordField.getText());
        if (!validationResult.isValid()) {
            passwordError.setText(validationResult.getMessage());
        }
        return validationResult.isValid();
    }

    private boolean validateEmail() {
        ValidationResult validationResult = registrationValidator.validateEmail(emailField.getText());
        if (!validationResult.isValid()) {
            emailError.setText(validationResult.getMessage());
        }
        return validationResult.isValid();
    }


    @FXML
    public void back() {
        main.switchToWindowScene();
    }
}