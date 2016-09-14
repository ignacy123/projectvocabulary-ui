package com.github.ignacy123.projectvocabulary.ui.view;

import javafx.fxml.FXML;

/**
 * Created by ignacy on 20.01.16.
 */
public class RootTeacherController extends AbstractBaseController{
    @FXML
    public void showGroups(){
        main.switchToGroupsScene();
    }
    @FXML
    public void logOut() {
        main.logOut();
    }

    public void showUserProfile(){
        main.switchToProfileScene();
    }
}
