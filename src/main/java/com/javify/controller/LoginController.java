package com.javify.controller;

import com.javify.dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label statusLabel;

    // IMPORTANT: Add "ActionEvent event" inside the parentheses!
    public void handleLogin(ActionEvent event) {
        String user = usernameField.getText();
        String pass = passwordField.getText();

        UserDAO dao = new UserDAO();
        if (dao.validate(user, pass)) {
            statusLabel.setStyle("-fx-text-fill: #1DB954");
            statusLabel.setText("Success! Logging in...");

            // --- SWITCH SCENE CODE STARTS HERE ---
            try {
                // 1. Load the Dashboard XML
                URL url = new File("src/main/resources/fxml/dashboard.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);

                // 2. Get the current window (Stage) from the button click
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                // 3. Set the scene to the Dashboard
                stage.setScene(new Scene(root, 1000, 700));
                stage.centerOnScreen();
                stage.setTitle("Javify - Music Player");
                
            } catch (Exception e) {
                e.printStackTrace();
                statusLabel.setText("Error loading dashboard.");
            }
            // --- SWITCH SCENE CODE ENDS HERE ---

        } else {
            statusLabel.setStyle("-fx-text-fill: red");
            statusLabel.setText("Invalid Username or Password.");
        }
    }
}