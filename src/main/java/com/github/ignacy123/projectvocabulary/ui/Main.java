package com.github.ignacy123.projectvocabulary.ui;

import com.github.ignacy123.projectvocabulary.ui.dictionary.DictionaryFactory;
import com.github.ignacy123.projectvocabulary.ui.dictionary.MultiDictionary;
import com.github.ignacy123.projectvocabulary.ui.domain.User;
import com.github.ignacy123.projectvocabulary.ui.domain.UserRepository;
import com.github.ignacy123.projectvocabulary.ui.view.BaseController;
import com.github.ignacy123.projectvocabulary.ui.view.RootController;
import com.github.ignacy123.projectvocabulary.ui.view.WindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ignacy on 14.01.16.
 */
public class Main extends Application {
    private Stage primaryStage;
    private User currentUser;
    private MultiDictionary dictionary;

    public MultiDictionary getDictionary() {
        return dictionary;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("dictionary.c5");
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
        switchScene("view/Root.fxml");
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

}
