package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.Main;
import com.github.ignacy123.projectvocabulary.ui.domain.User;
import com.github.ignacy123.projectvocabulary.ui.domain.UserRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sun.security.util.Password;

/**
 * Created by ignacy on 02.03.16.
 */
public class LoginController extends AbstractBaseController {
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label loginError;

    @FXML
    public void logIn() {
        String login = loginField.getText();
        String password = passwordField.getText();
        UserRepository userRepository = UserRepository.getInstance();
        User loggingUser = userRepository.findUserByLogin(login);
        if (loggingUser != null && loggingUser.passwordMatches(password)) {
            main.setCurrentUser(loggingUser);
            main.switchToRootScene();
        } else {
            loginError.setText("Invalid username or password.");
        }
    }

    @FXML
    public void back() {
        main.switchToWindowScene();
    }
}
