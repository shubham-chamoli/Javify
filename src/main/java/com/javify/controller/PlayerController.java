package com.javify.controller;

import com.javify.dao.SongDAO;
import com.javify.model.Song;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.util.List;

public class PlayerController {
    
    @FXML private Button playButton;
    @FXML private TableView<Song> songTable;
    @FXML private TableColumn<Song, String> titleColumn;
    @FXML private TableColumn<Song, String> artistColumn;

    private MediaPlayer mediaPlayer;
    private Song currentSong;

    public void initialize() {
        // 1. Setup the Table Columns
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));

        // 2. Load Songs from Database
        SongDAO dao = new SongDAO();
        List<Song> songs = dao.getAllSongs();
        songTable.getItems().addAll(songs);

        // 3. Handle Click on Song
        songTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                playSong(newSelection);
            }
        });
    }

    private void playSong(Song song) {
        currentSong = song;
        if (mediaPlayer != null) mediaPlayer.stop();
        
        try {
            Media media = new Media(new File(song.getFilePath()).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
            playButton.setText("⏸");
        } catch (Exception e) {
            System.out.println("Error playing file: " + e.getMessage());
        }
    }

    public void handlePlay() {
        if (mediaPlayer == null) return;
        
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
            playButton.setText("▶");
        } else {
            mediaPlayer.play();
            playButton.setText("⏸");
        }
    }
}