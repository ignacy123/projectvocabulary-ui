package com.github.ignacy123.projectvocabulary.ui;

import com.github.ignacy123.projectvocabulary.ui.dictionary.DictionaryFactory;
import com.github.ignacy123.projectvocabulary.ui.dictionary.MultiDictionary;
import com.github.ignacy123.projectvocabulary.ui.domain.Group;
import com.github.ignacy123.projectvocabulary.ui.domain.User;
import com.github.ignacy123.projectvocabulary.ui.view.BaseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ignacy on 14.01.16.
 */
public class Main extends Application {
    private Stage primaryStage;
    private User currentUser;
    private Group currentGroup;
    private MultiDictionary dictionary;

    public MultiDictionary getDictionary() {
        return dictionary;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        InputStream inputStream = getClass().getResourceAsStream("dictionary.c5");
        dictionary = DictionaryFactory.createDictionaryFromC5InputStream(inputStream);
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Project vocabulary");
        switchToWindowScene();
        primaryStage.show();
    }


    public void logOut() {
        setCurrentUser(null);
        switchToWindowScene();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void switchScene(String fxmlView){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(fxmlView));
        Parent pane;
        try {
            pane = loader.load();
            Scene scene = new Scene(pane, 600, 400);
            BaseController controller = loader.getController();
            controller.init(this);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't switch scene", e);
        }
    }
    public void switchToRegistrationScene (){
        switchScene("view/Registration.fxml");
    }
    public void switchToRootScene (){
        if(currentUser.getType() == User.Type.STUDENT) {
            switchScene("view/RootStudent.fxml");
        }else{
            switchScene("view/RootTeacher.fxml");
        }
    }

    public void switchToSessionScene (){
        switchScene("view/Session.fxml");
    }
    public void switchToWindowScene (){
        switchScene("view/Window.fxml");
    }
    public void switchToLoginScene (){
        switchScene("view/Login.fxml");
    }
    public void switchToProfileEditingScene() {switchScene("view/ProfileEditing.fxml");}


    public void switchToProfileScene() {switchScene("view/Profile.fxml");
    }

    public void switchToGroupsScene() {
        switchScene("view/GroupTest.fxml");
    }

    public void switchToGroupInfoScene(Group group){
        currentGroup = group;
        switchScene("view/GroupInfo.fxml");
    }

    public Group getCurrentGroup() {
        return currentGroup;
    }

    public void setCurrentGroup(Group currentGroup) {
        this.currentGroup = currentGroup;
    }
}
