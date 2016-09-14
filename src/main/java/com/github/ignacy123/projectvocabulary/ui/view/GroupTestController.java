package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


/**
 * Created by ignacy on 07.09.16.
 */
public class GroupTestController extends AbstractBaseController {
    @FXML
    private ListView groupsView;

    private ObservableList<String> groupNames = FXCollections.observableArrayList();

    @Override
    public void init(Main main) {
        super.init(main);
        groupNames.add("test");
        groupNames.add("test2");
        groupNames.add("test3");
        groupsView.setItems(groupNames);

    }
    @FXML
    public void showGroup(){
        System.out.println(groupsView.getSelectionModel().getSelectedIndex()+":"+groupsView.getSelectionModel().getSelectedItem());
    }

    public void addNewGroup(){
    }
}
