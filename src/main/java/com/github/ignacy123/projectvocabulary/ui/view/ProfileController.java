package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.Main;
import com.github.ignacy123.projectvocabulary.ui.domain.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by ignacy on 16.08.16.
 */
public class ProfileController extends AbstractBaseController{
    @FXML
    private Label email;

    @FXML
    private Label firstName;

    @FXML
    private Label lastName;

    @Override
    public void init(Main main) {
        super.init(main);
        User user = main.getCurrentUser();
        email.setText(user.getEmail());
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
    }

    public void back(){
        main.switchToRootScene();
    }
    public void edit(){
        main.switchToProfileEditingScene();
    }


}
