package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.Main;
import com.github.ignacy123.projectvocabulary.ui.domain.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;

/**
 * Created by ignacy on 11.10.16.
 */
public class GroupInfoController extends AbstractBaseController {
    @FXML
    private Label name;
    @FXML
    private Label amountOfStudents;
    @FXML
    private ListView shownStudents;

    private ObservableList<User> students = FXCollections.observableArrayList();

    public void init(Main main) {
        super.init(main);
        name.setText(main.getCurrentGroup().getName());
        amountOfStudents.setText(String.valueOf(main.getCurrentGroup().getStudents().size()));
        for (User user : main.getCurrentGroup().getStudents()) {
            students.add(user);
        }
        shownStudents.setItems(students);
    }

    public void back() {
        main.switchToGroupsScene();
    }
}
