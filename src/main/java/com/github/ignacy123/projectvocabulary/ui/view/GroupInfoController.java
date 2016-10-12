package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.Main;
import com.github.ignacy123.projectvocabulary.ui.domain.User;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by ignacy on 11.10.16.
 */
public class GroupInfoController extends  AbstractBaseController{
    @FXML
    private Label name;
    @FXML
    private Label amountOfStudents;
     public void init (Main main){
         name.setText(main.getCurrentGroup().getName());
         amountOfStudents.setText(String.valueOf(main.getCurrentGroup().getStudents().size()));
     }
}
