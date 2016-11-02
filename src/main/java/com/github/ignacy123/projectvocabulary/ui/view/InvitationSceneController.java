package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.Main;
import com.github.ignacy123.projectvocabulary.ui.restapi.InvitationDto;
import com.github.ignacy123.projectvocabulary.ui.restapi.InvitationRestApi;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Created by ignacy on 25.10.16.
 */
public class InvitationSceneController extends AbstractBaseController{
    private static final Logger LOGGER = LoggerFactory.getLogger(InvitationSceneController.class);
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    private String nameToSend;
    private String emailToSend;
    private InvitationRestApi restApi = InvitationRestApi.INSTANCE;
    private InvitationDto dto;

    public void init(Main main){
        super.init(main);
    }
    public void invite(){
        nameToSend = name.getText();
        emailToSend = email.getText();
        dto = new InvitationDto();
        dto.setEmail(emailToSend);
        dto.setName(nameToSend);
        LOGGER.info("sending invitation {} ", dto);
        restApi.create(dto, main.getCurrentGroup().getId(), main.getCurrentUser().getCookie());
        main.switchToGroupInfoScene(main.getCurrentGroup());
    }
}
