package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.Main;
import com.github.ignacy123.projectvocabulary.ui.domain.User;
import com.github.ignacy123.projectvocabulary.ui.domain.UserRepository;
import com.github.ignacy123.projectvocabulary.ui.restapi.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sun.security.util.Password;

/**
 * Created by ignacy on 02.03.16.
 */
public class LoginController extends AbstractBaseController {

    private final UserRestApi restApi = UserRestApi.INSTANCE;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label loginError;

    @FXML
    public void back() {
        main.switchToWindowScene();
    }



    @FXML
    public void logIn() {
        try {
            String login = loginField.getText();
            String password = passwordField.getText();
            LogInDto dto = new LogInDto();
            dto.setEmail(login);
            dto.setPassword(password);
            UserDto user = restApi.logIn(dto);
            User loggingUser = new User();
            loggingUser.setFirstName(user.getFirstName());
            loggingUser.setLastName(user.getLastName());
            loggingUser.setId(user.getId());
            loggingUser.setEmail(user.getEmail());
            loggingUser.setCookie(user.getCookie());
            loggingUser.setType(user.getType());
            main.setCurrentUser(loggingUser);
            main.switchToRootScene();
        } catch (RestValidationException e) {
            ErrorDto errorDto = e.getErrorDto();
            displayLoginError(errorDto);
        }
    }

    private void displayLoginError(ErrorDto errorDto) {
        loginError.setText(errorDto.getMessage());
    }
}
