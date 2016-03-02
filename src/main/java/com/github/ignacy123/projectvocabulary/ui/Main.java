package com.github.ignacy123.projectvocabulary.ui;

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

/**
 * Created by ignacy on 14.01.16.
 */
public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Project vocabulary");
        switchToWindowScene();
        primaryStage.show();
    }


    public void home() {
        VBox root = createRootPane();
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);

    }
    private VBox createRootPane() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("com.github.ignacy123.projectvocabulary.ui/root.fxml"));
        VBox root;
        try {
            root = (VBox) loader.load();
            RootController controller = loader.getController();
            controller.init(this);
            return root;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
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
