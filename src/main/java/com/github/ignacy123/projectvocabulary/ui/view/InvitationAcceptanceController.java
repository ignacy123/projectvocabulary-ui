package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.dto.InvitationAcceptanceDto;
import com.github.ignacy123.projectvocabulary.ui.restapi.InvitationRestApi;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by ignacy on 08.11.16.
 */
public class InvitationAcceptanceController extends AbstractBaseController{
    private InvitationRestApi api = InvitationRestApi.INSTANCE;
    @FXML
    private TextField uid;

    @FXML
    public void joinGroup(){
        InvitationAcceptanceDto dto = new InvitationAcceptanceDto();
        dto.setInvitationUid(uid.getText());
//        dto.setStudentId(main.getCurrentUser().getId());
        String cookie = main.getCurrentUser().getCookie();
        api.acceptInvitation(dto, cookie);
    }
    @FXML
    public void back(){
        main.switchToRootScene();
    }

}
