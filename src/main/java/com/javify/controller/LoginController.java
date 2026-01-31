package com.javify.controller;

import com.javify.dao.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label statusLabel;

    public void handleLogin() {
        String user = usernameField.getText();
        String pass = passwordField.getText();

        UserDAO dao = new UserDAO();
        if (dao.validate(user, pass)) {
            statusLabel.setStyle("-fx-text-fill: #1DB954"); // Spotify Green
            statusLabel.setText("Success! Logging in...");
            // In the next step, we will make this switch to the Player screen
        } else {
            statusLabel.setStyle("-fx-text-fill: red");
            statusLabel.setText("Invalid Username or Password.");
        }
    }
}