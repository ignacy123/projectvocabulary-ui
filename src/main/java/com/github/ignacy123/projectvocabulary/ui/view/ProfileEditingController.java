package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.Main;
import com.github.ignacy123.projectvocabulary.ui.dto.UserUpdateDto;
import com.github.ignacy123.projectvocabulary.ui.restapi.UserRestApi;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by ignacy on 24.08.16.
 */
public class ProfileEditingController extends AbstractBaseController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private Label currentFirstName;
    @FXML
    private Label currentLastName;
    @FXML
    private Label currentEmail;

    private final UserRestApi restApi = UserRestApi.INSTANCE;
    public void init(Main main){
        super.init(main);
        currentFirstName.setText(main.getCurrentUser().getFirstName());
        currentLastName.setText(main.getCurrentUser().getLastName());
        currentEmail.setText((main.getCurrentUser().getEmail()));
    }
    public void back(){
        main.switchToProfileScene();
    }
    public void submitChanges(){
        String newFirstName = firstName.getText();
        String newLastName = lastName.getText();
        String newEmail = email.getText();
        UserUpdateDto updateDto = new UserUpdateDto();
        updateDto.setEmail(newEmail);
        updateDto.setFirstName(newFirstName);
        updateDto.setLastName(newLastName);
        restApi.update(updateDto, main.getCurrentUser());
    }
}
