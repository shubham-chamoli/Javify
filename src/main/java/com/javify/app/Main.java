package com.javify.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file
        URL url = new File("src/main/resources/fxml/login.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        stage.setTitle("Javify - Login");
        stage.setScene(new Scene(root, 400, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}