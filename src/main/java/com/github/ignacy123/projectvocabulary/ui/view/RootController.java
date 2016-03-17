package com.github.ignacy123.projectvocabulary.ui.view;

import javafx.fxml.FXML;

/**
 * Created by ignacy on 20.01.16.
 */
public class RootController extends AbstractBaseController{
    @FXML
    public void startSession(){
        main.switchToSessionScene();
    }
    @FXML
    public void logOut() {
        main.logOut();
    }
}
