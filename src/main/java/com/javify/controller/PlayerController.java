package com.javify.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PlayerController {
    
    @FXML
    private Button playButton;

    private boolean isPlaying = false;

    public void handlePlay() {
        if (isPlaying) {
            playButton.setText("▶"); // Play Icon
            System.out.println("Pausing Music...");
        } else {
            playButton.setText("⏸"); // Pause Icon
            System.out.println("Playing Music...");
        }
        isPlaying = !isPlaying;
    }
}