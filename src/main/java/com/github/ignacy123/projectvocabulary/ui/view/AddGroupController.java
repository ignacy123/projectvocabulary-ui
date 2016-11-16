package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.restapi.GroupDto;
import com.github.ignacy123.projectvocabulary.ui.restapi.GroupRestApi;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by ignacy on 13.09.16.
 */
public class AddGroupController extends AbstractBaseController{
    @FXML
    TextField groupName;
    private GroupRestApi groupRestApi = GroupRestApi.INSTANCE;

    @FXML
    public void back(){
        main.switchToGroupsScene();

    }

    @FXML
    public void createGroup(){
        
        GroupDto dto = new GroupDto();
        dto.setName(groupName.getText());
        groupRestApi.create(dto, main.getCurrentUser().getCookie());
    }
}
