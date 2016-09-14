package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.domain.*;
import com.github.ignacy123.projectvocabulary.ui.restapi.ErrorDto;
import com.github.ignacy123.projectvocabulary.ui.restapi.RegistrationDto;
import com.github.ignacy123.projectvocabulary.ui.restapi.RestValidationException;
import com.github.ignacy123.projectvocabulary.ui.restapi.UserRestApi;
import com.github.ignacy123.projectvocabulary.ui.validation.RegistrationValidator;
import com.github.ignacy123.projectvocabulary.ui.validation.ValidationResult;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Map;

/**
 * Created by ignacy on 03.02.16.
 */

public class RegistrationController extends AbstractBaseController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
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
    @FXML
    private RadioButton studentRadio;
    @FXML
    private RadioButton teacherRadio;
    @FXML
    private ToggleGroup userTypeGroup;
    private final UserRestApi userRestApi = UserRestApi.INSTANCE;
    private final RegistrationValidator registrationValidator = new RegistrationValidator();

    @FXML
    public void register() {
        clearErrors();
//        if (validate()) {
        saveUser();
//        }
    }

    private void saveUser() {
        try {
            RegistrationDto user = new RegistrationDto();
            user.setPassword(passwordField.getText());
            user.setEmail(emailField.getText());
            user.setFirstName(firstNameField.getText());
            user.setLastName(lastNameField.getText());
            if (userTypeGroup.getSelectedToggle() == studentRadio) {
                user.setType(User.Type.STUDENT);
            } else {
                user.setType(User.Type.TEACHER);
            }
            System.out.println(user);
            userRestApi.register(user);
            main.switchToWindowScene();
        } catch (RestValidationException e) {
            ErrorDto errorDto = e.getErrorDto();
            displayValidationErrors(errorDto);
        } catch (UserEmailNotUniqueException e) {
            emailError.setText("This email is already used.");
        }
    }

    private void displayValidationErrors(ErrorDto errorDto) {
        clearErrors();
        for (Map.Entry<String, String> entry : errorDto.getErrors().entrySet()) {
            switch (entry.getKey()) {
                case "email":
                    emailError.setText(entry.getValue());
                    break;
                case "password":
                    passwordError.setText(entry.getValue());
                    break;
            }
        }

    }

    private boolean validate() {
        boolean valid = true;
        valid = validateEmail() && valid;
        valid = validatePassword() && valid;

        if (!passwordField.getText().equals(passwordConfirmationField.getText())) {
            passwordConfirmationError.setText("Passwords are not equal.");
        }

        return valid;
    }

    private void clearErrors() {
        passwordError.setText("");
        emailError.setText("");
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