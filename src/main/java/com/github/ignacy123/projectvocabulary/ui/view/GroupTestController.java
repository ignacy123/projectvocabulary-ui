package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.Main;
import com.github.ignacy123.projectvocabulary.ui.domain.Group;
import com.github.ignacy123.projectvocabulary.ui.restapi.GroupRestApi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;


/**
 * Created by ignacy on 07.09.16.
 */
public class GroupTestController extends AbstractBaseController {
    @FXML
    private ListView groupsView;

    private ObservableList<String> groupNames = FXCollections.observableArrayList();

    private List<Group> groups;

    private GroupRestApi restApi = GroupRestApi.INSTANCE;

    @Override
    public void init(Main main) {
        super.init(main);
        groups = restApi.getTeacherGroups(main.getCurrentUser().getId(), main.getCurrentUser().getCookie());
        groupNames.clear();
        for (Group group : groups) {
            groupNames.add(group.getName());
        }
        groupsView.setItems(groupNames);

    }

    @FXML
    public void showGroup() {
        System.out.println(groupsView.getSelectionModel().getSelectedIndex() + ":" + groupsView.getSelectionModel().getSelectedItem());
        Group group = groups.get(groupsView.getSelectionModel().getSelectedIndex());
        main.switchToGroupInfoScene(group);
    }
    @FXML
    public void addNewGroup() {
        main.switchToAddGroupScene();
    }

    @FXML
    public void back() {
        main.switchToRootScene();
    }
}
